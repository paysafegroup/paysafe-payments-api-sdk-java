// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.patch;
import static com.github.tomakehurst.wiremock.client.WireMock.patchRequestedFor;
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
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.lpm.enums.InteracFraudStatus;
import com.paysafe.payments.model.lpm.enums.InteracFraudType;
import com.paysafe.payments.model.standalonecredit.Interac;
import com.paysafe.payments.model.standalonecredit.StandaloneCredit;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditList;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditRequest;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditUpdateRequest;

import base.BasePaysafeClientTest;

class StandaloneCreditServiceTest extends BasePaysafeClientTest {

  private static final String STANDALONE_CREDIT_ENDPOINT = "/paymenthub/v1/standalonecredits";
  private static final String MERCHANT_REF_NUM = "32be35aac78dbfe252a2";
  private static final String STANDALONE_CREDIT_ID = "eddbec36-6fc7-48fb-a694-dfc5b314ec0d";

  @Test
  void testProcessStandaloneCredit_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(STANDALONE_CREDIT_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("standalone_credit/process_standalone_credit_card_response.json")));

    StandaloneCreditRequest creditRequest = StandaloneCreditRequest.builder()
        .merchantRefNum("32be35aac78dbfe252a2")
        .amount(500L)
        .currencyCode(CurrencyCode.USD)
        .paymentHandleToken("SCQp7CmWCSRFmvzv")
        .description("Winning payment from Loto 649")
        .build();

    StandaloneCredit standaloneCredit = paysafeClient.standaloneCreditService().processStandaloneCredit(creditRequest);

    verify(postRequestedFor(urlEqualTo(STANDALONE_CREDIT_ENDPOINT)));
    assertNotNull(standaloneCredit);
  }

  @Test
  void testGetStandaloneCreditsUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(STANDALONE_CREDIT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("standalone_credit/get_standalone_credit_using_merchant_ref_number_response.json")));

    StandaloneCreditList response = paysafeClient.standaloneCreditService().getStandaloneCreditUsingMerchantReferenceNumber(
        MERCHANT_REF_NUM, null, null, null, null);

    verify(getRequestedFor(urlPathEqualTo(STANDALONE_CREDIT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM)));

    assertNotNull(response);
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertFalse(response.getStandaloneCredits().isEmpty());
    assertEquals(MERCHANT_REF_NUM, response.getStandaloneCredits().get(0).getMerchantRefNum());
  }

  @Test
  void testGetStandaloneCreditsUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(STANDALONE_CREDIT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().getStandaloneCreditUsingMerchantReferenceNumber(
            MERCHANT_REF_NUM, null, 10, 0, null)
    );

    verify(getRequestedFor(urlPathEqualTo(STANDALONE_CREDIT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM)));

    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.",
        exception.getError().getDetails().get(0));
  }

  @Test
  void testGetStandaloneCreditById_isSuccessful() throws PaysafeSdkException {
    final String endpoint = STANDALONE_CREDIT_ENDPOINT + "/" + STANDALONE_CREDIT_ID;

    stubFor(get(urlPathEqualTo(endpoint))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("standalone_credit/get_standalone_credit_by_id_response.json")));

    StandaloneCredit response = paysafeClient.standaloneCreditService().getStandaloneCreditById(STANDALONE_CREDIT_ID);

    verify(getRequestedFor(urlPathEqualTo(endpoint)));

    assertNotNull(response);
    assertEquals(STANDALONE_CREDIT_ID, response.getId());
    assertEquals(MERCHANT_REF_NUM, response.getMerchantRefNum());
    assertEquals(CurrencyCode.USD, response.getCurrencyCode());
    assertEquals(500L, response.getAmount());
    assertEquals("SIM1UZ3YM7IS1", response.getCardSchemeTransactionId());
  }

  @Test
  void testGetStandaloneCreditById_throwsExceptionOnEntityNotFoundError() {
    final String standaloneCreditId = "bad-id";
    final String endpoint = STANDALONE_CREDIT_ENDPOINT + "/" + standaloneCreditId;

    stubFor(get(urlPathEqualTo(endpoint))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().getStandaloneCreditById(standaloneCreditId)
    );

    verify(getRequestedFor(urlPathEqualTo(endpoint)));

    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.",
        exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelStandaloneCredit_isSuccessful() throws PaysafeSdkException {
    final String standaloneCreditId = "eddbec36-6fc7-48fb-a694-dfc5b314ec0d";

    CancelRequest cancelRequest = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, standaloneCreditId)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("standalone_credit/cancel_standalone_credit_response.json")));

    CancelResponse response = paysafeClient.standaloneCreditService().cancelStandaloneCredit(standaloneCreditId, cancelRequest);

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, standaloneCreditId))));

    assertNotNull(response);
    assertEquals(standaloneCreditId, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelStandaloneCredit_throwsExceptionOnEntityNotFoundError() {
    final String invalidStandaloneCreditId = "invalid-credit-id";

    CancelRequest cancelRequest = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidStandaloneCreditId)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().cancelStandaloneCredit(invalidStandaloneCreditId, cancelRequest)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidStandaloneCreditId))));

    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testPatchStandaloneCreditStatusForInteracFraud_isSuccessful() throws PaysafeSdkException {
    String standaloneCreditId = "a2afe762-2421-4d57-9c5e-17b06bfb2af6";

    StandaloneCreditUpdateRequest updateRequest = StandaloneCreditUpdateRequest.builder()
        .interacEtransfer(Interac.builder()
            .consumerId("123456")
            .fraudStatus(InteracFraudStatus.CONFIRM_FRAUD)
            .fraudType(InteracFraudType.FRAUD_BUSINESS)
            .build())
        .build();

    stubFor(patch(urlPathEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, standaloneCreditId)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("standalone_credit/patch_standalone_credit_response.json")));

    StandaloneCredit response = paysafeClient.standaloneCreditService().patchStandaloneCreditStatusForInteracFraud(standaloneCreditId, updateRequest);

    WireMock.verify(1, patchRequestedFor(urlEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, standaloneCreditId))));

    assertNotNull(response);
    assertEquals(standaloneCreditId, response.getId());
  }

  @Test
  void testPatchStandaloneCreditStatusForInteracFraud_throwsExceptionOnEntityNotFoundError() {
    String invalidStandaloneCreditId = "invalid-credit-id";

    StandaloneCreditUpdateRequest updateRequest = StandaloneCreditUpdateRequest.builder()
        .interacEtransfer(Interac.builder()
            .consumerId("123456")
            .fraudStatus(InteracFraudStatus.CONFIRM_FRAUD)
            .fraudType(InteracFraudType.FRAUD_BUSINESS)
            .build())
        .build();

    stubFor(patch(urlPathEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidStandaloneCreditId)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().patchStandaloneCreditStatusForInteracFraud(invalidStandaloneCreditId, updateRequest)
    );

    WireMock.verify(1, patchRequestedFor(urlEqualTo(String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidStandaloneCreditId))));

    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}
