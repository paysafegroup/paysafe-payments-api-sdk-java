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
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.CreditRequestStatus;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.originalcredit.OriginalCredit;
import com.paysafe.payments.model.originalcredit.OriginalCreditList;
import com.paysafe.payments.model.originalcredit.OriginalCreditRequest;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

import base.BasePaysafeClientTest;

class OriginalCreditServiceTest extends BasePaysafeClientTest {

  public static final String ORIGINAL_CREDIT_ENDPOINT = "/paymenthub/v1/originalcredits";
  private static final String ORIGINAL_CREDIT_ID = "e075f2ae-dfc4-4f6d-8d89-61158367b6a6";

  @Test
  void testProcessOriginalCredit_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(ORIGINAL_CREDIT_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("original_credit/process_original_credit_card_response.json")));

    OriginalCreditRequest originalCreditRequest = OriginalCreditRequest.builder()
        .amount(100L)
        .merchantRefNum("05e19427-a3d1-46f7-8b2e-bdf8ced0341e")
        .currencyCode(CurrencyCode.USD)
        .customerIp("204.91.0.12")
        .description("Winning payment from Loto 649")
        .build();

    OriginalCredit originalCredit = paysafeClient.originalCreditService().processOriginalCredit(originalCreditRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(ORIGINAL_CREDIT_ENDPOINT)));
    assertNotNull(originalCredit);
    assertEquals("ee9010926e3edd01a799", originalCredit.getMerchantRefNum());
  }

  @Test
  void testProcessOriginalCredit_throwsExceptionOnEntityNotFoundError() {
    stubFor(post(urlPathEqualTo(ORIGINAL_CREDIT_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    OriginalCreditRequest originalCreditRequest = OriginalCreditRequest.builder()
        .amount(100L)
        .merchantRefNum("invalid-merchant-ref-num")
        .currencyCode(CurrencyCode.USD)
        .build();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.originalCreditService().processOriginalCredit(originalCreditRequest)
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(ORIGINAL_CREDIT_ENDPOINT)));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetOriginalCreditById_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("original_credit/get_original_credit_by_id_response.json")));

    OriginalCredit response = paysafeClient.originalCreditService().getOriginalCreditById(ORIGINAL_CREDIT_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID))));
    assertNotNull(response);
    assertEquals(ORIGINAL_CREDIT_ID, response.getId());
    assertEquals(PaymentType.CARD, response.getPaymentType());
    assertEquals("merchantRefNum-151", response.getMerchantRefNum());
  }

  @Test
  void testGetOriginalCreditById_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID)))
        .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json")
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.originalCreditService().getOriginalCreditById(ORIGINAL_CREDIT_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetOriginalCreditUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo("/paymenthub/v1/originalcredits"))
        .withQueryParam("merchantRefNum", equalTo("merchantRefNum-151"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("original_credit/get_original_credit_using_merchant_ref_number_response.json")));

    OriginalCreditList response = paysafeClient.originalCreditService()
        .getOriginalCreditUsingMerchantReferenceNumber("merchantRefNum-151", null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlPathEqualTo("/paymenthub/v1/originalcredits"))
        .withQueryParam("merchantRefNum", equalTo("merchantRefNum-151")));

    assertNotNull(response);
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertFalse(response.getOriginalCredits().isEmpty());
    assertEquals("merchantRefNum-151", response.getOriginalCredits().get(0).getMerchantRefNum());
  }

  @Test
  void testGetOriginalCreditUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo("/paymenthub/v1/originalcredits"))
        .withQueryParam("merchantRefNum", equalTo("merchantRefNum-151"))
        .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json")
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.originalCreditService().getOriginalCreditUsingMerchantReferenceNumber("merchantRefNum-151", null, null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlPathEqualTo("/paymenthub/v1/originalcredits"))
        .withQueryParam("merchantRefNum", equalTo("merchantRefNum-151")));

    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.",
        exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelOriginalCredit_isSuccessful() throws PaysafeSdkException {
    CancelRequest cancelRequest = CancelRequest.builder()
        .status(CreditRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("original_credit/cancel_original_credit_response.json")));

    CancelResponse response = paysafeClient.originalCreditService().cancelOriginalCredit(ORIGINAL_CREDIT_ID, cancelRequest);

    verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID))));

    assertNotNull(response);
    assertEquals(ORIGINAL_CREDIT_ID, response.getId());
    assertEquals(CreditRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelOriginalCredit_throwsExceptionOnEntityNotFoundError() {
    CancelRequest cancelRequest = CancelRequest.builder()
        .status(CreditRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, "invalid-original-credit-id")))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.originalCreditService().cancelOriginalCredit("invalid-original-credit-id", cancelRequest)
    );

    verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, "invalid-original-credit-id"))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

}
