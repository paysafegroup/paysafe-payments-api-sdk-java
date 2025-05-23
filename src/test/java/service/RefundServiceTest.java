// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.putRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.refund.Refund;
import com.paysafe.payments.model.refund.RefundList;
import com.paysafe.payments.model.refund.RefundRequest;

import base.BasePaysafeClientTest;

class RefundServiceTest extends BasePaysafeClientTest {

  public static final String PROCESS_REFUND_ENDPOINT = "/paymenthub/v1/settlements/%s/refunds";
  public static final String REFUND_ENDPOINT = "/paymenthub/v1/refunds";
  public static final String REFUND_ID = "6cf00c1c-fb83-4cc8-a7cc-cd9118ce4f53";
  public static final String SETTLEMENT_ID = "3aeb9c63-6386-46a3-9f8e-f452e722228a";
  public static final String MERCHANT_REF_NUM = "a9318b525273ee3cda79a2f947a9";

  @Test
  void testProcessRefund_isSuccessful() throws PaysafeSdkException {
    String urlPath = String.format(PROCESS_REFUND_ENDPOINT, SETTLEMENT_ID);
    stubFor(post(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("refund/process_refund_card_response.json")));

    RefundRequest refundRequest = RefundRequest.builder()
        .merchantRefNum("92cf2183-2298-44a6-99d4-5af6d727cea3")
        .amount(500L)
        .dupCheck(true)
        .build();

    Refund refund = paysafeClient.refundService().processRefund(SETTLEMENT_ID, refundRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(PROCESS_REFUND_ENDPOINT, SETTLEMENT_ID))));
    assertNotNull(refund);
  }

  @Test
  void testGetRefundById_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("refund/get_refund_by_id_card_response.json")));

    Refund response = paysafeClient.refundService().getRefundById(REFUND_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID))));
    assertNotNull(response);
    assertEquals(REFUND_ID, response.getId());
  }

  @Test
  void testGetRefundById_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID)))
        .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json")
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.refundService().getRefundById(REFUND_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.",
        exception.getError().getDetails().get(0));
  }

  @Test
  void testUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(REFUND_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("refund/get_refund_using_merchant_ref_number_card_response.json")));

    RefundList response = paysafeClient.refundService().getRefundUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(REFUND_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM)));

    assertNotNull(response);
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertFalse(response.getRefunds().isEmpty());
    assertEquals(MERCHANT_REF_NUM, response.getRefunds().get(0).getMerchantRefNum());
  }

  @Test
  void testUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(REFUND_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json")
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.refundService().getRefundUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(REFUND_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM)));

    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.",
        exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelRefund_isSuccessful() throws PaysafeSdkException {
    String refundId = "6cf00c1c-fb83-4cc8-a7cc-cd9118ce4f64";
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", REFUND_ENDPOINT, refundId)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("refund/cancel_refund_response.json")));

    CancelResponse response = paysafeClient.refundService().cancelRefund(refundId, cancelRequest);

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", REFUND_ENDPOINT, refundId))));
    assertNotNull(response);
    assertEquals(refundId, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelRefund_throwsExceptionOnEntityNotFoundError() {
    String invalidRefundId = "invalid-refund-id";
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", REFUND_ENDPOINT, invalidRefundId)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.refundService().cancelRefund(invalidRefundId, cancelRequest)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", REFUND_ENDPOINT, invalidRefundId))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}
