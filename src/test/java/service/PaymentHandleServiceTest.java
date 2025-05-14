// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2024. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.ApiException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.RequestDeclinedException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.PaymentSimulator;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.card.enums.AuthenticationPurpose;
import com.paysafe.payments.model.card.enums.PasswordChangedRange;
import com.paysafe.payments.model.card.enums.AccountCreatedRange;
import com.paysafe.payments.model.card.enums.InitialUsageRange;
import com.paysafe.payments.model.card.enums.PreOrderPurchaseIndicator;
import com.paysafe.payments.model.card.enums.ReOrderItemsIndicator;
import com.paysafe.payments.model.card.enums.ShippingIndicator;
import com.paysafe.payments.model.card.enums.TransactionIntent;
import com.paysafe.payments.model.card.threeds.AuthenticationMethod;
import com.paysafe.payments.model.card.threeds.OrderItemDetails;
import com.paysafe.payments.model.card.threeds.PaymentAccountDetails;
import com.paysafe.payments.model.card.threeds.PurchasedGiftCardDetails;
import com.paysafe.payments.model.card.threeds.ShippingDetailsUsage;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.card.threeds.UserAccountDetails;
import com.paysafe.payments.model.card.threeds.UserLogin;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.paymenthandle.PaymentHandle;
import com.paysafe.payments.model.paymenthandle.PaymentHandleList;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;

import base.BasePaysafeClientTest;

public class PaymentHandleServiceTest extends BasePaysafeClientTest {

  public static final String PAYMENT_HANDLES_ENDPOINT = "/paymenthub/v1/paymenthandles";

  public static final String MERCHANT_REF_NUM = "rzkPbqSIHGGOmja8jf2tCKIHg";
  public static final String PAYMENT_HANDLE_ID = "e05205d9-93f3-4c20-9c2a-b6b8dc74cf17";

  @Test
  void testCreatePaymentHandle_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("paymenthandle/create_payment_handle_card_3ds_response.json")));

    PaymentHandleRequest paymentHandleRequest = buildPaymentHandleRequest();

    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(paymentHandleRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertNotNull(response);
  }

  @Test
  void testCreatePaymentHandle_withSimulatorOnRequestLevel_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withHeader("Simulator", equalTo(PaymentSimulator.INTERNAL.toString()))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("paymenthandle/create_payment_handle_card_3ds_response.json")));

    PaymentHandleRequest paymentHandleRequest = buildPaymentHandleRequest();

    PaymentHandle response = paysafeClient.paymentHandleService()
        .createPaymentHandle(paymentHandleRequest, RequestOptions.builder().simulator(PaymentSimulator.INTERNAL).build());

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertNotNull(response);
  }

  @Test
  void testCreatePaymentHandle_throwsExceptionOnInvalidCredentialsError() {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    InvalidCredentialsException exception = assertThrows(
        InvalidCredentialsException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreatePaymentHandle_throwsApiException() {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(500)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/500_internal_server_error_response.json")));

    ApiException exception = assertThrows(
        ApiException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertEquals(500, exception.getCode());
    assertEquals("1000", exception.getError().getCode());
    assertEquals("Internal Error", exception.getError().getMessage());
    assertEquals("An internal error occurred.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreatePaymentHandle_throwsRequestDeclinedException() {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(402)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/402_request_declined_response.json")));

    RequestDeclinedException exception = assertThrows(
        RequestDeclinedException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertEquals(402, exception.getCode());

    assertEquals("ALTERNATE-PAYMENTS-GATEWAY-4", exception.getError().getCode());
    assertEquals("Transaction declined", exception.getError().getMessage());
    assertEquals("The transaction was declined by the processing gateway.", exception.getError().getDetails().get(0));
    assertEquals("Merchant configuration is incorrect. Verify setup in Netbanx.", exception.getError().getDetails().get(1));

    assertEquals("Refer to Issuer", ((PaymentHandle) exception.getApiResponse()).getGatewayResponse().getResponseCodeDescription());
    assertEquals("550e8400-e29b-41d4-a716-446655440000", ((PaymentHandle) exception.getApiResponse()).getId());
    assertEquals("12345", ((PaymentHandle) exception.getApiResponse()).getMerchantRefNum());

    assertEquals("ALTERNATE-PAYMENTS-GATEWAY-4", exception.getApiResponse().getError().getCode());
    assertEquals("Transaction declined", exception.getApiResponse().getError().getMessage());
    assertEquals("The transaction was declined by the processing gateway.", exception.getApiResponse().getError().getDetails().get(0));
    assertEquals("Merchant configuration is incorrect. Verify setup in Netbanx.", exception.getApiResponse().getError().getDetails().get(1));

  }

  @Test
  void testCreatePaymentHandle_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreatePaymentHandle_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    PaysafeSdkException exception = assertThrows(
        ApiConnectionException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("paymenthandle/get_payment_handle_using_merchant_ref_number_card_response.json")));

    PaymentHandleList response = paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(
        MERCHANT_REF_NUM, null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM))));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertNotNull(response.getPaymentHandles());
    assertFalse(response.getPaymentHandles().isEmpty());
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_queryParamsAreSetCorrectly() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .withQueryParam("endDate", equalTo("2024-12-05"))
        .withQueryParam("limit", equalTo("30"))
        .withQueryParam("offset", equalTo("0"))
        .withQueryParam("startDate", equalTo("2024-11-05"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("paymenthandle/get_payment_handle_using_merchant_ref_number_card_response.json")));

    paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, "2024-12-05", 30, 0, "2024-11-05");

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s%s",
        PAYMENT_HANDLES_ENDPOINT, "?merchantRefNum=rzkPbqSIHGGOmja8jf2tCKIHg&endDate=2024-12-05&limit=30&offset=0&startDate=2024-11-05"))));

    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("endDate", equalTo("2024-12-05"))
        .withQueryParam("limit", equalTo("30"))
        .withQueryParam("offset", equalTo("0"))
        .withQueryParam("startDate", equalTo("2024-11-05"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("paymenthandle/get_payment_handle_using_merchant_ref_number_card_response.json")));

    paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(null, "2024-12-05", 30, 0, "2024-11-05");

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s%s",
        PAYMENT_HANDLES_ENDPOINT, "?endDate=2024-12-05&limit=30&offset=0&startDate=2024-11-05"))));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json"))
    );

    InvalidCredentialsException exception = assertThrows(
        InvalidCredentialsException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null,
            null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    UnauthorizedException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null,
            null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null,
            null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsApiConnectionException() {

    stubFor(get(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class, () ->
            paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetPaymentHandleById_isSuccessful() throws PaysafeSdkException {
    String url = String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID);

    stubFor(get(urlPathEqualTo(url))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("paymenthandle/get_payment_handle_by_id_card_response.json")));

    PaymentHandle response = paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(url)));
    assertNotNull(response);
  }

  @Test
  void testGetPaymentHandleById_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID)))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentHandleById_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    UnauthorizedException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentHandleById_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentHandleById_throwsApiConnectionException() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID))));
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  private PaymentHandleRequest buildPaymentHandleRequest() {
    return PaymentHandleRequest.builder()
        .merchantRefNum(MERCHANT_REF_NUM)
        .transactionType(TransactionType.PAYMENT)
        .threeDs(createThreeDsObject())
        .card(Card.builder()
            .cardNum("4000000000001026")
            .cardExpiry(CardExpiry.builder()
                .month(10)
                .year(2025)
                .build())
            .cvv("111")
            .issuingCountry("US")
            .build())
        .accountId("1009688230")
        .paymentType(PaymentType.CARD)
        .amount(500L)
        .currencyCode(CurrencyCode.USD)
        .billingDetails(BillingDetails.builder()
            .nickName("Home")
            .street("Street name")
            .city("City Name")
            .state("AL")
            .country("US")
            .zip("94404")
            .build())
        .returnLinks(createReturnLinksList())
        .build();
  }

  private ThreeDs createThreeDsObject() {
    return ThreeDs.builder()
        .merchantUrl("https://api.qa.paysafe.com/checkout/v2/index.html#/desktop")
        .deviceChannel("BROWSER")
        .messageCategory("PAYMENT")
        .transactionIntent(TransactionIntent.CHECK_ACCEPTANCE)
        .authenticationPurpose(AuthenticationPurpose.PAYMENT_TRANSACTION)
        .orderItemDetails(OrderItemDetails.builder()
            .preOrderItemAvailabilityDate("2014-01-26")
            .preOrderPurchaseIndicator(PreOrderPurchaseIndicator.MERCHANDISE_AVAILABLE)
            .reorderItemsIndicator(ReOrderItemsIndicator.FIRST_TIME_ORDER)
            .shippingIndicator(ShippingIndicator.SHIP_TO_BILLING_ADDRESS)
            .build())
        .purchasedGiftCardDetails(PurchasedGiftCardDetails.builder()
            .amount(1234)
            .count(2)
            .currency(CurrencyCode.USD)
            .build())
        .userAccountDetails(UserAccountDetails.builder()
            .addCardAttemptsForLastDay(1)
            .changedDate("2010-01-26")
            .changedRange(PasswordChangedRange.DURING_TRANSACTION)
            .createdDate("2010-01-26")
            .createdRange(AccountCreatedRange.NO_ACCOUNT)
            .passwordChangedDate("2012-01-26")
            .passwordChangedRange(PasswordChangedRange.NO_CHANGE)
            .paymentAccountDetails(PaymentAccountDetails.builder()
                .createdRange(AccountCreatedRange.NO_ACCOUNT)
                .createdDate("2010-01-26")
                .build())
            .build())
        .shippingDetailsUsage(ShippingDetailsUsage.builder()
            .cardHolderNameMatch(Boolean.TRUE)
            .initialUsageDate("2014-01-26")
            .initialUsageRange(InitialUsageRange.CURRENT_TRANSACTION)
            .build())
        .suspiciousAccountActivity(Boolean.TRUE)
        .totalPurchasesSixMonthCount(1)
        .transactionCountForPreviousDay(1)
        .transactionCountForPreviousYear(3)
        .userLogin(UserLogin.builder()
            .authenticationMethod(AuthenticationMethod.NO_LOGIN)
            .data("Some up to 2048 bytes undefined data")
            .time("2014-01-26T10:32:28Z")
            .build())
        .build();
  }

  private List<ReturnLink> createReturnLinksList() {

    return List.of(ReturnLink.builder()
            .rel(ReturnLinkRel.DEFAULT)
            .href("https://usgaminggamblig.com/payment/return/")
            .method("GET")
            .build(),

        ReturnLink.builder()
            .rel(ReturnLinkRel.ON_COMPLETED)
            .href("https://usgaminggamblig.com/payment/return/success")
            .method("GET")
            .build(),

        ReturnLink.builder()
            .rel(ReturnLinkRel.ON_FAILED)
            .href("https://usgaminggamblig.com/payment/return/failed")
            .method("GET")
            .build());
  }
}
