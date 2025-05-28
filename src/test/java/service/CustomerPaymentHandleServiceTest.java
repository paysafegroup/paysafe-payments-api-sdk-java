// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
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
import static com.paysafe.payments.model.common.enums.CurrencyCode.GBP;
import static com.paysafe.payments.model.paymenthandle.enums.PaymentType.CARD;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.card.CardBillingDetailsRequest;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.MandateRequestStatus;
import com.paysafe.payments.model.customer.CustomerPaymentHandle;
import com.paysafe.payments.model.customer.CustomerPaymentHandleRequest;
import com.paysafe.payments.model.customer.UpdateCustomerRequestCard;
import com.paysafe.payments.model.paymenthandle.enums.Action;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleStatus;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleUsage;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

import base.BasePaysafeClientTest;

public class CustomerPaymentHandleServiceTest extends BasePaysafeClientTest {

  public static final String CUSTOMER_PAYMENT_HANDLES_ENDPOINT = "/paymenthub/v1/customers/%s/paymenthandles/%s";
  public static final String CREATE_CUSTOMER_PAYMENT_HANDLE_ENDPOINT = "/paymenthub/v1/customers/%s/paymenthandles";
  private static final String CUSTOMER_ID = "921cd968-6882-422c-ae4f-a10ddbae95ff";
  private static final String PAYMENT_HANDLE_ID = "c672fd10-962e-4f57-a1f2-1c3105ffe5d3";
  private static final String NON_EXISTING_CUSTOMER_ID = "00000000-0000-0000-0000-000000000000";
  private static final String NON_EXISTING_PAYMENT_HANDLE_ID = "11111111-1111-1111-1111-111111111111";

  @Test
  void testCreateCustomerPaymentHandle_card_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CREATE_CUSTOMER_PAYMENT_HANDLE_ENDPOINT, CUSTOMER_ID);

    stubFor(post(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_payment_handle/create_customer_payment_handle_card_response.json")));

    CustomerPaymentHandleRequest paymentHandleRequest = CustomerPaymentHandleRequest.builder()
        .merchantRefNum("wed18012023Test")
        .card(UpdateCustomerRequestCard.builder()
            .cardNum("4037111111000000")
            .cardExpiry(CardExpiry.builder().month(10).year(2025).build())
            .cvv("111")
            .holderName("Dilip")
            .issuingCountry("US")
            .build())
        .paymentType(CARD)
        .amount(900L)
        .customerIp("127.0.0.1")
        .currencyCode(CurrencyCode.USD)
        .build();

    CustomerPaymentHandle response = paysafeClient.customerPaymentHandleService().createPaymentHandleForCustomer(CUSTOMER_ID, paymentHandleRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(urlPath)));
    assertNotNull(response);
    assertEquals(PaymentHandleUsage.MULTI_USE, response.getUsage());
    assertEquals(Action.NONE, response.getAction());
    assertEquals("24ce6840-6d41-4cfa-b27d-cc3e26124236", response.getBillingDetailsId());
    assertEquals("CPSql8EPmo45jNB", response.getPaymentHandleToken());
    assertEquals("0000", response.getCard().getLastDigits());
  }

  @Test
  void testCreateCustomerPaymentHandle_multiuse_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CREATE_CUSTOMER_PAYMENT_HANDLE_ENDPOINT, CUSTOMER_ID);

    stubFor(post(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_payment_handle/create_multiuse_customer_payment_handle_response.json")));

    CustomerPaymentHandleRequest paymentHandleRequest = CustomerPaymentHandleRequest.builder()
        .paymentHandleTokenFrom("SAOMuI4DuXuLXulf")
        .build();

    CustomerPaymentHandle response = paysafeClient.customerPaymentHandleService().createPaymentHandleForCustomer(CUSTOMER_ID, paymentHandleRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(urlPath)));
    assertNotNull(response);
    assertEquals(PaymentHandleUsage.MULTI_USE, response.getUsage());
    assertEquals(Action.NONE, response.getAction());
    assertEquals("b7be6f48-143d-4be0-95aa-8e8539f17ccc", response.getBillingDetailsId());
    assertEquals("DSR5qCCJZElTvxe", response.getPaymentHandleToken());
    assertEquals("12", response.getEft().getLastDigits());
    assertEquals("XYZ Company", response.getEft().getAccountHolderName());
  }

  @Test
  void testGetCustomerPaymentHandleByPaymentHandleId_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID);

    stubFor(get(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_payment_handle/get_customer_payment_handle_by_id_response.json")));

    CustomerPaymentHandle response = paysafeClient.customerPaymentHandleService().getCustomerPaymentHandleByPaymentHandleId(CUSTOMER_ID, PAYMENT_HANDLE_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(urlPath)));
    assertNotNull(response);
    assertEquals(PaymentHandleStatus.PAYABLE, response.getStatus());
    assertEquals(PaymentHandleUsage.MULTI_USE, response.getUsage());
    assertEquals(Action.NONE, response.getAction());
    assertEquals(PaymentType.BACS, response.getPaymentType());
    assertEquals("DsOYXhRmFcOCSF2", response.getPaymentHandleToken());
    assertEquals("a85cb1b2-d3b5-44e0-9c1a-4760fb7deceb", response.getBillingDetailsId());
    assertEquals("72", response.getBacs().getLastDigits());
    assertEquals("Sally Barnes", response.getBacs().getAccountHolderName());
    assertEquals("Sally's Barclays Account", response.getBacs().getNickName());
    assertEquals("086081", response.getBacs().getSortCode());
    assertEquals(1, response.getMandates().size());
    assertEquals("6c44d842-5720-4155-beb2-f8704a9daf0f", response.getMandates().get(0).getId());
    assertEquals("DOCNIG2336", response.getMandates().get(0).getReference());
    assertEquals(MandateRequestStatus.PENDING, response.getMandates().get(0).getStatus());
  }

  @Test
  void testUpdateCustomerPaymentHandle_card_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID);

    stubFor(put(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_payment_handle/update_customer_payment_handle_response.json")));

    CustomerPaymentHandleRequest updateRequest = CustomerPaymentHandleRequest.builder()
        .merchantRefNum("xzcxzcwqeqwewewqer")
        .paymentType(PaymentType.CARD)
        .currencyCode(GBP)
        .customerIp("10.10.12.64")
        .billingDetails(CardBillingDetailsRequest.builder()
            .street("Andhra bank lane")
            .street2("Manikonda")
            .city("Hyderabad")
            .state("TS")
            .country("IN")
            .zip("500089")
            .build())
        .card(UpdateCustomerRequestCard.builder()
            .cardNum("4222222222222")
            .lastDigits("2222")
            .cardExpiry(CardExpiry.builder().month(12).year(2021).build())
            .cvv("111")
            .issuingCountry("US")
            .build())
        .build();

    CustomerPaymentHandle response = paysafeClient.customerPaymentHandleService().updateCustomerPaymentHandle(
        CUSTOMER_ID, PAYMENT_HANDLE_ID, updateRequest);

    WireMock.verify(1, putRequestedFor(urlEqualTo(urlPath)));

    assertNotNull(response);
    assertEquals("ad9c23c2-509b-43ae-bf5d-64554c9fc378", response.getMerchantRefNum());
    assertEquals(PaymentHandleStatus.INITIATED, response.getStatus());
    assertEquals(PaymentHandleUsage.MULTI_USE, response.getUsage());
    assertEquals(PaymentType.CARD, response.getPaymentType());
    assertEquals("2222", response.getCard().getLastDigits());
    assertEquals("Casino slots payin", response.getMerchantDescriptor().getDynamicDescriptor());
  }

  @Test
  void testUpdateCustomerPaymentHandle_throwsExceptionOnEntityNotFoundError() {
    final String urlPath = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, NON_EXISTING_CUSTOMER_ID, NON_EXISTING_PAYMENT_HANDLE_ID);

    stubFor(put(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    CustomerPaymentHandleRequest updateRequest = CustomerPaymentHandleRequest.builder()
        .merchantRefNum("xzcxzcwqeqwewewqer")
        .paymentType(CARD)
        .currencyCode(GBP)
        .customerIp("10.10.12.64")
        .billingDetails(CardBillingDetailsRequest.builder()
            .street("Andhra bank lane")
            .street2("Manikonda")
            .city("Hyderabad")
            .state("TS")
            .country("IN")
            .zip("500089")
            .build())
        .card(UpdateCustomerRequestCard.builder()
            .cardNum("4222222222222")
            .lastDigits("2222")
            .cardExpiry(CardExpiry.builder().month(12).year(2021).build())
            .cvv("111")
            .issuingCountry("US")
            .build())
        .build();

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () ->
        paysafeClient.customerPaymentHandleService().updateCustomerPaymentHandle(
            NON_EXISTING_CUSTOMER_ID, NON_EXISTING_PAYMENT_HANDLE_ID, updateRequest));

    WireMock.verify(1, putRequestedFor(urlEqualTo(urlPath)));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testDeleteCustomerPaymentHandle_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID);

    stubFor(WireMock.delete(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)));

    paysafeClient.customerPaymentHandleService().deleteCustomerPaymentHandle(CUSTOMER_ID, PAYMENT_HANDLE_ID);

    WireMock.verify(1, WireMock.deleteRequestedFor(urlEqualTo(urlPath)));
  }

  @Test
  void testDeleteCustomerPaymentHandle_throwsExceptionOnEntityNotFound() {
    final String urlPath = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, NON_EXISTING_CUSTOMER_ID, NON_EXISTING_PAYMENT_HANDLE_ID);

    stubFor(WireMock.delete(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () ->
        paysafeClient.customerPaymentHandleService().deleteCustomerPaymentHandle(
            NON_EXISTING_CUSTOMER_ID, NON_EXISTING_PAYMENT_HANDLE_ID));

    WireMock.verify(1, WireMock.deleteRequestedFor(urlEqualTo(urlPath)));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}