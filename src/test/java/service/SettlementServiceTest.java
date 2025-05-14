// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.github.tomakehurst.wiremock.http.Fault;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.CreditRequestStatus;
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.settlement.SettlementList;
import com.paysafe.payments.model.settlement.SettlementRequest;

import base.BasePaysafeClientTest;

class SettlementServiceTest extends BasePaysafeClientTest {

  public static final String PAYMENT_SETTLEMENT_ENDPOINT = "/paymenthub/v1/payments/%s/settlements";
  public static final String SETTLEMENT_ENDPOINT = "/paymenthub/v1/settlements";

  public static final String PAYMENT_ID = "9b84dedd-2a92-47bf-a8ee-131e2d898105";
  public static final String SETTLEMENT_ID = "8d951743-78e5-4fa5-aa15-2c42f0c05228";
  public static final String MERCHANT_REF_NUM = "a9318b525273ee3cda79a2f947a9";

  @Test
  void testProcessSettlement_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(201)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("settlement/process_settlement_card_response.json")));

    SettlementRequest request = SettlementRequest.builder()
        .merchantRefNum("test-merchantRefNum")
        .amount(500L)
        .build();

    Settlement response = paysafeClient.settlementService().processSettlement(PAYMENT_ID, request);

    verify(1, postRequestedFor(urlEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID))));
    assertNotNull(response);
    assertEquals("25f6dadf-176a-415f-95c9-6ff39ff697ba", response.getId());
    assertEquals(CreditRequestStatus.PENDING, response.getStatus());
    assertEquals(500, response.getAvailableToRefund());
  }

  @Test
  void testProcessSettlement_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(post(urlPathEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    SettlementRequest request = new SettlementRequest();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().processSettlement(PAYMENT_ID, request)
    );

    verify(1, postRequestedFor(urlEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testProcessSettlement_throwsExceptionOnInvalidCredentialsError() {
    stubFor(post(urlPathEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    SettlementRequest request = new SettlementRequest();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().processSettlement(PAYMENT_ID, request)
    );

    verify(1, postRequestedFor(urlEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testProcessSettlement_throwsExceptionOnEntityNotFoundError() {
    stubFor(post(urlPathEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, "invalid-payment-id")))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    SettlementRequest request = new SettlementRequest();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().processSettlement("invalid-payment-id", request)
    );

    verify(1, postRequestedFor(urlEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, "invalid-payment-id"))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testProcessSettlement_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(post(urlPathEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    SettlementRequest request = new SettlementRequest();

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class,
        () -> paysafeClient.settlementService().processSettlement(PAYMENT_ID, request)
    );

    verify(1, postRequestedFor(urlEqualTo(String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetSettlementById_isSuccessful() throws PaysafeSdkException {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("settlement/get_settlement_by_id_response.json")));

    Settlement response = paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));
    assertNotNull(response);
    assertEquals(SETTLEMENT_ID, response.getId());
  }

  @Test
  void testGetSettlementById_throwsExceptionOnUnauthorizedAccessError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetSettlementById_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetSettlementById_throwsPaysafeSdkExceptionOnIOError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("settlement/get_settlement_using_merchant_ref_number_response.json")));

    SettlementList response = paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(
        MERCHANT_REF_NUM, null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s%s",
        SETTLEMENT_ENDPOINT, "?merchantRefNum=a9318b525273ee3cda79a2f947a9"))));

    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertNotNull(response.getSettlements());
    assertFalse(response.getSettlements().isEmpty());
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_queryParamsAreSetCorrectly() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .withQueryParam("startDate", equalTo("2022-11-18"))
        .withQueryParam("endDate", equalTo("2022-12-19"))
        .withQueryParam("limit", equalTo("32"))
        .withQueryParam("offset", equalTo("0"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("settlement/get_settlement_using_merchant_ref_number_response.json")));

    paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, "2022-12-19", 32, 0, "2022-11-18");

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .withQueryParam("startDate", equalTo("2022-11-18"))
        .withQueryParam("endDate", equalTo("2022-12-19"))
        .withQueryParam("limit", equalTo("32"))
        .withQueryParam("offset", equalTo("0")));
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, 0, "2022-11-18")
    );

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM)));

    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(get(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse().withStatus(403).withHeader("Content-Type", "application/json")
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, 0, "2022-11-18")
    );

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(SETTLEMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM)));

    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelSettlement_isSuccessful() throws PaysafeSdkException {
    CancelRequest cancelRequest = CancelRequest.builder()
        .status(CreditRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("settlement/cancel_settlement_response.json")));

    CancelResponse response = paysafeClient.settlementService().cancelSettlement(SETTLEMENT_ID, cancelRequest);

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));

    assertNotNull(response);
    assertEquals(SETTLEMENT_ID, response.getId());
    assertEquals(CreditRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelSettlement_throwsExceptionOnInvalidCredentialsError() {
    CancelRequest cancelRequest = CancelRequest.builder()
        .status(CreditRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().cancelSettlement(SETTLEMENT_ID, cancelRequest)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
  }

  @Test
  void testCancelSettlement_throwsExceptionOnUnauthorizedAccessError() {
    CancelRequest cancelRequest = CancelRequest.builder()
        .status(CreditRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID)))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().cancelSettlement(SETTLEMENT_ID, cancelRequest)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID))));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
  }

  @Test
  void testCancelSettlement_throwsExceptionOnEntityNotFoundError() {
    CancelRequest cancelRequest = CancelRequest.builder()
        .status(CreditRequestStatus.CANCELLED)
        .build();

    stubFor(put(urlPathEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, "invalid-settlement-id")))
        .withRequestBody(equalToJson("{\"status\": \"CANCELLED\"}"))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.settlementService().cancelSettlement("invalid-settlement-id", cancelRequest)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", SETTLEMENT_ENDPOINT, "invalid-settlement-id"))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}