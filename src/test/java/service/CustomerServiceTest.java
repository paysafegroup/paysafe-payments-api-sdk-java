// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.putRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.customer.CustomerRequest;
import com.paysafe.payments.model.customer.enums.CustomerStatus;
import com.paysafe.payments.model.customer.enums.Gender;

import base.BasePaysafeClientTest;

public class CustomerServiceTest extends BasePaysafeClientTest {

  private static final String CUSTOMERS_ENDPOINT = "/paymenthub/v1/customers";
  private static final String CUSTOMER_ID = "d60fc496-9023-4641-890e-e05c852d2ac4";
  private static final String NON_EXISTING_CUSTOMER_ID = "non-existing-customer-id";
  private static final String MERCHANT_CUSTOMER_ID = "merchant@email.com";
  private static final String FIELDS_PARAM_VALUES_REGEX = "addresses,paymenthandles|paymenthandles,addresses";

  @Test
  void testCreateCustomer_isSuccessful() throws PaysafeSdkException {

    stubFor(post(urlPathEqualTo(CUSTOMERS_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer/create_customer_response.json")));

    CustomerRequest customerRequest = CustomerRequest.builder()
        .merchantCustomerId("546456451")
        .locale("en_US")
        .firstName("John")
        .middleName("James")
        .dateOfBirth(DateOfBirth.builder()
            .day(24)
            .month(10)
            .year(1981)
            .build())
        .email("john.smith@email.com")
        .phone("777-444-8888")
        .ip("192.0.126.111")
        .gender(Gender.M)
        .nationality("Canadian")
        .cellPhone("777-555-8888")
        .build();

    Customer customer = paysafeClient.customerService().createCustomer(customerRequest, null);

    WireMock.verify(1, postRequestedFor(urlEqualTo(CUSTOMERS_ENDPOINT)));
    assertNotNull(customer);
    assertEquals(CustomerStatus.ACTIVE, customer.getStatus());
    assertEquals("546456451", customer.getMerchantCustomerId());
    assertEquals("PPlfJ2gmQoYAQ1d", customer.getPaymentToken());
    assertNull(customer.getPaymentHandles());
  }

  @Test
  void testCreateCustomerUsingSingleUsePaymentHandleToken_isSuccessful() throws PaysafeSdkException {

    stubFor(post(urlPathEqualTo(CUSTOMERS_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer/create_customer_using_single_user_payment_handle_token_response.json")));

    CustomerRequest customerRequest = CustomerRequest.builder()
        .merchantCustomerId("546456451")
        .locale("en_US")
        .firstName("John")
        .middleName("James")
        .dateOfBirth(DateOfBirth.builder()
            .day(24)
            .month(10)
            .year(1981)
            .build())
        .email("john.smith@email.com")
        .phone("777-444-8888")
        .ip("192.0.126.111")
        .gender(Gender.M)
        .nationality("Canadian")
        .cellPhone("777-555-8888")
        .paymentHandleTokenFrom("SCAXH2IawyUMX9BG")
        .accountId("1009688230")
        .build();

    Customer customer = paysafeClient.customerService().createCustomer(customerRequest, null);

    WireMock.verify(1, postRequestedFor(urlEqualTo(CUSTOMERS_ENDPOINT)));
    assertNotNull(customer);
    assertEquals(CustomerStatus.ACTIVE, customer.getStatus());
    assertEquals("f8303a052", customer.getMerchantCustomerId());
    assertEquals("PNWaCnbFb7Y5zUk", customer.getPaymentToken());
    assertNotNull(customer.getPaymentHandles());
    assertEquals(1, customer.getPaymentHandles().size());
    assertEquals("e6ad67f5-16f1-4be6-8944-0b897e3b1380", customer.getPaymentHandles().get(0).getId());
    assertEquals("Dilip", customer.getPaymentHandles().get(0).getCard().getHolderName());
    assertEquals("453091", customer.getPaymentHandles().get(0).getCard().getCardBin());

    assertNotNull(customer.getAddresses());
    assertEquals(1, customer.getAddresses().size());
  }

  @Test
  void testDeleteCustomer_isSuccessful() {
    stubFor(delete(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID)))
        .willReturn(aResponse().withStatus(200)));

    assertDoesNotThrow(() -> paysafeClient.customerService().deleteCustomer(CUSTOMER_ID));
    WireMock.verify(1, deleteRequestedFor(urlEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID))));
  }

  @Test
  void testDeleteCustomer_throwsExceptionOnEntityNotFoundError() {
    stubFor(delete(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().deleteCustomer(NON_EXISTING_CUSTOMER_ID)
    );

    WireMock.verify(1, deleteRequestedFor(urlEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetCustomerById_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID)))
        .withQueryParam("fields", matching(FIELDS_PARAM_VALUES_REGEX))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer/get_customer_profile_by_customer_id_with_subcomponents_response.json")));

    Customer response = paysafeClient.customerService().getCustomerById(CUSTOMER_ID, Set.of("addresses", "paymenthandles"));

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID)))
        .withQueryParam("fields", matching(FIELDS_PARAM_VALUES_REGEX)));
    assertNotNull(response);
    assertFalse(response.getAddresses().isEmpty());
    assertFalse(response.getPaymentHandles().isEmpty());
  }

  @Test
  void testGetCustomerById_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().getCustomerById(NON_EXISTING_CUSTOMER_ID, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetCustomerByMerchantCustomerId_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(CUSTOMERS_ENDPOINT))
        .withQueryParam("merchantCustomerId", equalTo(MERCHANT_CUSTOMER_ID))
        .withQueryParam("fields", matching(FIELDS_PARAM_VALUES_REGEX))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer/get_customer_using_merchant_customer_id_response.json"))
    );

    Customer response = paysafeClient.customerService().getCustomerByMerchantCustomerId(MERCHANT_CUSTOMER_ID, Set.of("addresses", "paymenthandles"));

    WireMock.verify(1, getRequestedFor(urlPathEqualTo(CUSTOMERS_ENDPOINT))
        .withQueryParam("merchantCustomerId", equalTo(MERCHANT_CUSTOMER_ID))
        .withQueryParam("fields", matching(FIELDS_PARAM_VALUES_REGEX)));
    assertNotNull(response);
    assertNull(response.getAddresses());
    assertNull(response.getPaymentHandles());
  }

  @Test
  void testGetCustomerByMerchantCustomerId_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(CUSTOMERS_ENDPOINT))
        .withQueryParam("merchantCustomerId", equalTo(NON_EXISTING_CUSTOMER_ID))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().getCustomerByMerchantCustomerId(NON_EXISTING_CUSTOMER_ID, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(
        String.format("%s?merchantCustomerId=%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testUpdateCustomer_isSuccessful() throws PaysafeSdkException {
    stubFor(put(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer/update_customer_response.json")));

    CustomerRequest updateCustomerRequest = CustomerRequest.builder()
        .merchantCustomerId("546456451")
        .locale("en_US")
        .firstName("John")
        .middleName("James")
        .lastName("Smith")
        .dateOfBirth(DateOfBirth.builder()
            .day(24)
            .month(10)
            .year(1981)
            .build())
        .gender(Gender.M)
        .email("johnjames.smith@email.com")
        .phone("777-444-9999")
        .cellPhone("777-555-8888")
        .nationality("Canadian")
        .ip("192.0.126.111")
        .paymentHandleTokenFrom("PPlfJ2gmQoYAQ1d")
        .build();

    Customer response = paysafeClient.customerService().updateCustomer(CUSTOMER_ID, updateCustomerRequest);

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID))));
    assertNotNull(response);
    assertEquals(CUSTOMER_ID, response.getId());
    assertEquals(CustomerStatus.ACTIVE, response.getStatus());
    assertEquals("546456451", response.getMerchantCustomerId());
    assertEquals("johnjames.smith@email.com", response.getEmail());
    assertEquals("777-444-9999", response.getPhone());
  }

  @Test
  void testUpdateCustomer_throwsExceptionOnEntityNotFoundError() {
    stubFor(put(urlPathEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().updateCustomer(NON_EXISTING_CUSTOMER_ID, new CustomerRequest())
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}