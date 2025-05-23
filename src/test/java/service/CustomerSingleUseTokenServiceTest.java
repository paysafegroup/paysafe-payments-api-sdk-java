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
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.enums.SingleUseCustomerTokenStatus;
import com.paysafe.payments.model.customer.enums.SingleUseTokenPaymentType;
import com.paysafe.payments.model.customer.singleusecustomertoken.SingleUseCustomerToken;
import com.paysafe.payments.model.customer.singleusecustomertoken.SingleUseCustomerTokenRequest;

import base.BasePaysafeClientTest;

class CustomerSingleUseTokenServiceTest extends BasePaysafeClientTest {

  private static final String CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT = "/paymenthub/v1/customers/%s/singleusecustomertokens";
  private static final String GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT = "/paymenthub/v1/singleusecustomertokens/%s";
  private static final String CUSTOMER_ID = "28511b97-6473-4110-92f7-69bbd3412bd0";
  private static final String NON_EXISTING_CUSTOMER_ID = "non-existing-customer-id";
  private static final String SINGLE_USE_TOKEN_ID = "46776add-2e89-4ec1-96ac-845d017b4ad8";
  private static final String NON_EXISTING_TOKEN_ID = "non-existing-token-id";

  @Test
  void testCreateSingleUseCustomerToken_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(String.format(CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, CUSTOMER_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_single_use_token/create_single_use_customer_token_response.json")));

    SingleUseCustomerTokenRequest requestBody = SingleUseCustomerTokenRequest.builder()
        .merchantRefNum("merchantRefNum")
        .paymentType(Collections.singletonList(SingleUseTokenPaymentType.CARD))
        .build();

    SingleUseCustomerToken response = paysafeClient.customerSingleUseTokenService().createSingleUseCustomerToken(CUSTOMER_ID, requestBody);

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, CUSTOMER_ID))));
    assertNotNull(response);
    assertNotNull(response.getId());
    assertNotNull(response.getSingleUseCustomerToken());
    assertEquals(SingleUseCustomerTokenStatus.ACTIVE, response.getStatus());
    assertEquals(CUSTOMER_ID, response.getCustomerId());
  }

  @Test
  void testCreateSingleUseCustomerToken_throwsExceptionOnEntityNotFoundError() {
    stubFor(post(urlPathEqualTo(String.format(CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, NON_EXISTING_CUSTOMER_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.customerSingleUseTokenService().createSingleUseCustomerToken(NON_EXISTING_CUSTOMER_ID, new SingleUseCustomerTokenRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(
        String.format(CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, NON_EXISTING_CUSTOMER_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetSingleUseCustomerToken_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(String.format(GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, SINGLE_USE_TOKEN_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("customer_single_use_token/get_single_use_customer_token_response.json")));

    SingleUseCustomerToken response = paysafeClient.customerSingleUseTokenService().getSingleUseCustomerToken(SINGLE_USE_TOKEN_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format(GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, SINGLE_USE_TOKEN_ID))));
    assertNotNull(response);
    assertNotNull(response.getTimeToLiveSeconds());
    assertEquals(SINGLE_USE_TOKEN_ID, response.getId());
    assertEquals("SPfslSE3qEuSCdYF", response.getSingleUseCustomerToken());
    assertEquals(SingleUseCustomerTokenStatus.ACTIVE, response.getStatus());
    assertEquals(CUSTOMER_ID, response.getCustomerId());
  }

  @Test
  void testGetSingleUseCustomerToken_tokenNotFound_throwsExceptionOnEntityNotFound() {
    stubFor(get(urlPathEqualTo(String.format(GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, NON_EXISTING_TOKEN_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.customerSingleUseTokenService().getSingleUseCustomerToken(NON_EXISTING_TOKEN_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(
        String.format(GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, NON_EXISTING_TOKEN_ID))));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}
