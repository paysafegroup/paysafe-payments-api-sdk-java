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
import static com.paysafe.payments.model.common.enums.CurrencyCode.USD;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.airline.Passenger;
import com.paysafe.payments.model.common.travel.airline.Passengers;
import com.paysafe.payments.model.common.travel.airline.Ticket;
import com.paysafe.payments.model.common.travel.airline.enums.Gender;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.payment.PaymentList;
import com.paysafe.payments.model.payment.PaymentRequest;

import base.BasePaysafeClientTest;

class PaymentServiceTest extends BasePaysafeClientTest {

  public static final String PAYMENT_ENDPOINT = "/paymenthub/v1/payments";
  public static final String PAYMENT_ID = "3aeb9c63-6386-46a3-9f8e-f452e722228a";
  public static final String MERCHANT_REF_NUM = "MerchantRefNum-145";

  @Test
  void testGetPaymentById_isSuccessful() throws PaysafeSdkException {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment/get_payment_by_id_response.json")));

    Payment response = paysafeClient.paymentService().getPaymentById(PAYMENT_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertNotNull(response);
  }

  @Test
  void testGetPaymentById_throwsExceptionOnUnauthorizedAccessError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentById(PAYMENT_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentById_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentById(PAYMENT_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentById_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentById(PAYMENT_ID)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(PAYMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment/get_payment_using_merchant_ref_number_response.json")));

    PaymentList response = paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(
        MERCHANT_REF_NUM, null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s",
        PAYMENT_ENDPOINT, MERCHANT_REF_NUM))));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertNotNull(response.getPayments());
    assertFalse(response.getPayments().isEmpty());
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_queryParamsAreSetCorrectly() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(PAYMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo("merchantRefNum-145"))
        .withQueryParam("endDate", equalTo("2022-12-19"))
        .withQueryParam("limit", equalTo("32"))
        .withQueryParam("offset", equalTo("0"))
        .withQueryParam("startDate", equalTo("2022-11-18"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment/get_payment_using_merchant_ref_number_response.json")));

    paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber("merchantRefNum-145", "2022-12-19", 32, 0, "2022-11-18");

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s%s",
        PAYMENT_ENDPOINT, "?merchantRefNum=merchantRefNum-145&endDate=2022-12-19&limit=32&offset=0&startDate=2022-11-18"))));

    stubFor(get(urlPathEqualTo(PAYMENT_ENDPOINT))
        .withQueryParam("endDate", equalTo("2022-12-19"))
        .withQueryParam("limit", equalTo("32"))
        .withQueryParam("offset", equalTo("0"))
        .withQueryParam("startDate", equalTo("2022-11-18"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment/get_payment_using_merchant_ref_number_response.json")));

    paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(null, "2022-12-19", 32, 0, "2022-11-18");

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s%s",
        PAYMENT_ENDPOINT, "?endDate=2022-12-19&limit=32&offset=0&startDate=2022-11-18"))));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(PAYMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null,
            null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(get(urlPathEqualTo(PAYMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(get(urlPathEqualTo(PAYMENT_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelPayment_isSuccessful() throws PaysafeSdkException {
    stubFor(put(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment/cancel_payment_response.json")));

    CancelRequest requestBody = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    CancelResponse response = paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody);

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertNotNull(response);
    assertEquals(PAYMENT_ID, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelPayment_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(put(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    CancelRequest requestBody = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelPayment_throwsExceptionOnEntityNotFoundError() {
    stubFor(put(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    CancelRequest requestBody = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCancelPayment_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(put(urlPathEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    CancelRequest requestBody = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testProcessPayment_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(PAYMENT_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment/process_payment_card_with_airline_travel_details_response.json")));

    PaymentRequest paymentRequest = PaymentRequest.builder()
        .merchantRefNum("fc5b62df1202e491475d")
        .amount(500L)
        .settleWithAuth(true)
        .paymentHandleToken("SC2INoYvSe2MzQuB")
        .customerIp("172.0.0.1")
        .currencyCode(USD)
        .merchantDescriptor(MerchantDescriptor.builder()
            .dynamicDescriptor("100,test")
            .phone("1000000000")
            .build())
        .airlineTravelDetails(createAirlineTravelDetails())
        .merchantRefNum("fc5b62df1202e491475d")
        .amount(500L)
        .settleWithAuth(true)
        .paymentHandleToken("SC2INoYvSe2MzQuB")
        .customerIp("172.0.0.1")
        .currencyCode(USD)
        .preAuth(false)
        .build();

    Payment response = paysafeClient.paymentService().processPayment(paymentRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_ENDPOINT)));
    assertNotNull(response);
  }

  @Test
  void testProcessPayment_throwsExceptionOnInvalidCredentialsError() {
    stubFor(post(urlPathEqualTo(PAYMENT_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.paymentService().processPayment(new PaymentRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_ENDPOINT)));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testProcessPayment_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(post(urlPathEqualTo(PAYMENT_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    PaysafeSdkException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.paymentService().processPayment(new PaymentRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_ENDPOINT)));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testProcessPayment_throwsApiConnectionException() {

    stubFor(post(urlPathEqualTo(PAYMENT_ENDPOINT))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    PaysafeSdkException exception = assertThrows(
        ApiConnectionException.class,
        () -> paysafeClient.paymentService().processPayment(new PaymentRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_ENDPOINT)));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  public static AirlineTravelDetails createAirlineTravelDetails() {
    return AirlineTravelDetails.builder()
        .passengerName("John Smith")
        .departureDate("2023-05-25")
        .origin("YUL")
        .customerReferenceNumber("123456")
        .passengerNameRecord("passNamRec")
        .additionalBookingReference("additionalBookingRef")
        .totalFare(1000L)
        .totalFee(100L)
        .totalTaxes(10L)
        .ticket(Ticket.builder()
            .ticketNumber("198J8928")
            .isRestrictedTicket(false)
            .build())
        .passengers(Passengers.builder()
            .passenger1(Passenger.builder()
                .ticketNumber("56827")
                .firstName("Suzy")
                .lastName("Doe")
                .phoneNumber("7181855783")
                .passengerCode("INF")
                .gender(Gender.M)
                .build())
            .passenger2(Passenger.builder()
                .ticketNumber("56828")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("7181855785")
                .passengerCode("INF")
                .gender(Gender.M)
                .build())
            .build())
        .build();
  }
}
