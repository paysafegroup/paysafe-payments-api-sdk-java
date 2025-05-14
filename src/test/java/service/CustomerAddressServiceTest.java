// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor;
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
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.model.customer.enums.AddressStatus;
import com.paysafe.payments.model.customer.enums.CustomerStatus;

import base.BasePaysafeClientTest;

public class CustomerAddressServiceTest extends BasePaysafeClientTest {

  private static final String CUSTOMER_ID = "11111-6882-422c-ae4f-a10ddbae95ff";
  private static final String ADDRESS_ID = "99999-6882-422c-ae4f-a10ddbae95fe";
  private static final String CUSTOMER_ADDRESS_ENDPOINT = "/paymenthub/v1/customers/%s/addresses";

  @Test
  void testCreateAddress_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT, CUSTOMER_ID);

    stubFor(post(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_address/create_address_response.json")));

    Address addressRequest = Address.builder()
        .nickName("Home")
        .street("N.G.O's Colony")
        .street2("Besdie Sri Ramakrishna P.G College")
        .city("Nandyal")
        .zip("518502")
        .country("CA")
        .state("ON")
        .phone("647-788-3901")
        .defaultShippingAddressIndicator(true)
        .build();

    Address response = paysafeClient.customerAddressService().createAddress(CUSTOMER_ID, addressRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(urlPath)));
    assertNotNull(response);
    assertEquals("Home", response.getNickName());
    assertEquals("N.G.O's Colony", response.getStreet());
    assertEquals(AddressStatus.ACTIVE, response.getStatus());
  }

  @Test
  void testGetAddressById_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, ADDRESS_ID);

    stubFor(get(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_address/get_address_response.json")));

    Address response = paysafeClient.customerAddressService().getAddressById(CUSTOMER_ID, ADDRESS_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(urlPath)));
    assertNotNull(response);
    assertEquals(ADDRESS_ID, response.getId());
    assertEquals("Home", response.getNickName());
    assertEquals(AddressStatus.ACTIVE, response.getStatus());
    assertEquals("N.G.O's Colony", response.getStreet());
    assertEquals("Nandyal", response.getCity());
    assertEquals("ON", response.getState());
    assertEquals("CA", response.getCountry());
    assertEquals("518502", response.getZip());
    assertEquals("647-788-3901", response.getPhone());
    assertFalse(response.getDefaultShippingAddressIndicator());
  }

  @Test
  void testGetAddressById_throwsExceptionOnEntityNotFoundError() {
    final String nonExistingAddressId = "non-existing-address-id";
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, nonExistingAddressId);

    stubFor(get(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.customerAddressService().getAddressById(CUSTOMER_ID, nonExistingAddressId)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(urlPath)));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testUpdateAddress_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, ADDRESS_ID);

    stubFor(put(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_address/update_address_response.json")));

    Address updatedRequest = Address.builder()
        .nickName("Office")
        .street("101 Queen")
        .street2("Unit 202")
        .city("Toronto0")
        .zip("M5H 2N2")
        .country("US")
        .state("NY")
        .phone("903-788-3901")
        .defaultShippingAddressIndicator(false)
        .build();

    Address response = paysafeClient.customerAddressService().updateAddress(CUSTOMER_ID, ADDRESS_ID, updatedRequest);

    WireMock.verify(1, putRequestedFor(urlEqualTo(urlPath)));

    assertNotNull(response);
    assertEquals("Office", response.getNickName());
    assertEquals("101 Queen", response.getStreet());
    assertEquals("Unit 202", response.getStreet2());
    assertEquals("Toronto0", response.getCity());
    assertEquals("NY", response.getState());
    assertEquals("US", response.getCountry());
    assertEquals("M5H 2N2", response.getZip());
    assertEquals("903-788-3901", response.getPhone());
    assertEquals(AddressStatus.ACTIVE, response.getStatus());
    assertFalse(response.getDefaultShippingAddressIndicator());
  }

  @Test
  void testUpdateAddress_throwsExceptionOnEntityNotFoundError() {
    final String nonExistingAddressId = "non-existing-address-id";
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, nonExistingAddressId);

    stubFor(put(urlPathEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    Address updatedRequest = Address.builder()
        .nickName("Office")
        .street("101 Queen")
        .street2("Unit 202")
        .city("Toronto0")
        .zip("M5H 2N2")
        .country("US")
        .state("NY")
        .phone("903-788-3901")
        .defaultShippingAddressIndicator(false)
        .build();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.customerAddressService().updateAddress(CUSTOMER_ID, nonExistingAddressId, updatedRequest, null)
    );

    WireMock.verify(1, putRequestedFor(urlEqualTo(urlPath)));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testDeleteAddress_isSuccessful() {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, ADDRESS_ID);

    stubFor(delete(urlEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(200)));

    assertDoesNotThrow(() -> paysafeClient.customerAddressService().deleteAddress(CUSTOMER_ID, ADDRESS_ID));
    WireMock.verify(1, deleteRequestedFor(urlEqualTo(urlPath)));
  }

  @Test
  void testDeleteAddress_throwsExceptionOnEntityNotFound() {
    final String nonExistingAddressId = "non-existing-address-id";
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, nonExistingAddressId);

    stubFor(delete(urlEqualTo(urlPath))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () ->
        paysafeClient.customerAddressService().deleteAddress(CUSTOMER_ID, nonExistingAddressId));

    WireMock.verify(1, deleteRequestedFor(urlEqualTo(urlPath)));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}