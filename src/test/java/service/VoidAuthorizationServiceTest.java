// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import static com.paysafe.payments.errorhandling.ExceptionBuilder.HEADER_X_INTERNAL_CORRELATION_ID;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.RequestConflictException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.voidauthorization.VoidAuthorization;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationRequest;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationsList;
import com.paysafe.payments.model.voidauthorization.enums.VoidAuthorizationStatus;

import base.BasePaysafeClientTest;

class VoidAuthorizationServiceTest extends BasePaysafeClientTest {

  public static final String VOID_AUTHORIZATION_ENDPOINT = "/paymenthub/v1/payments/%s/voidauths";
  public static final String VOID_AUTHORIZATION_GET_ENDPOINT = "/paymenthub/v1/voidauths";

  public static final String PAYMENT_ID = "9b84f316-e120-4948-97f6-c97d5a305eb3";
  public static final String VOID_ID = "8b84f316-e120-4948-97f6-c97d5a305ee5";
  public static final String MERCHANT_REF_NUM = "a85c6ed15955adeed35e";

  @Test
  void testVoidAuthorization_isSuccessful() throws PaysafeSdkException {

    stubFor(post(urlPathEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("void_authorization/void_authorization_response.json")));

    VoidAuthorizationRequest voidAuthRequest = VoidAuthorizationRequest
        .builder()
        .amount(500L)
        .merchantRefNum(MERCHANT_REF_NUM)
        .build();

    VoidAuthorization response = paysafeClient.voidAuthorizationService().voidAuthorization(PAYMENT_ID, voidAuthRequest);

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID))));
    assertNotNull(response);
    assertEquals(500L, response.getAmount());
    assertEquals("a85c6ed15955adeed35e", response.getMerchantRefNum());
  }

  @Test
  void testVoidAuthorization_invalidCredentials_throwsPaysafeSdkException() {

    stubFor(post(urlPathEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID))).willReturn(aResponse()
        .withStatus(401)
        .withHeader("Content-Type", "application/json")
        .withBodyFile("error/401_invalid_credentials_response.json")));

    InvalidCredentialsException exception = assertThrows(
        InvalidCredentialsException.class,
        () -> paysafeClient.voidAuthorizationService().voidAuthorization(PAYMENT_ID, new VoidAuthorizationRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID))));
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testVoidAuthorization_unauthorizedAccess_throwsPaysafeSdkException() {

    stubFor(post(urlPathEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    UnauthorizedException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.voidAuthorizationService().voidAuthorization(PAYMENT_ID, new VoidAuthorizationRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID))));
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testVoidAuthorization_throwsApiConnectionException() {

    stubFor(post(urlPathEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class, () -> paysafeClient.voidAuthorizationService().voidAuthorization(PAYMENT_ID, new VoidAuthorizationRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetVoidAuthorizationById() throws PaysafeSdkException {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("void_authorization/get_void_authorization_by_id_response.json")));

    VoidAuthorization response = paysafeClient.voidAuthorizationService().getVoidAuthorizationById(VOID_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID))));
    assertNotNull(response);
    assertEquals(500L, response.getAmount());
    assertEquals(VoidAuthorizationServiceTest.MERCHANT_REF_NUM, response.getMerchantRefNum());
    assertEquals(VOID_ID, response.getId());
  }

  @Test
  void testGetVoidAuthorizationById_badId_throwsPaysafeSdkException() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withHeader(HEADER_X_INTERNAL_CORRELATION_ID, "random_correlation_id")
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.voidAuthorizationService().getVoidAuthorizationById(VOID_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID))));
    assertEquals("random_correlation_id", exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVoidAuthorizationById_invalidCredentials_throwsPaysafeSdkException() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID))).willReturn(aResponse()
        .withStatus(401)
        .withHeader("Content-Type", "application/json")
        .withHeader(HEADER_X_INTERNAL_CORRELATION_ID, "random_correlation_id")
        .withBodyFile("error/401_invalid_credentials_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.voidAuthorizationService().getVoidAuthorizationById(VOID_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID))));
    assertEquals("random_correlation_id", exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVoidAuthorizationById_unauthorizedAccess_throwsPaysafeSdkException() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    UnauthorizedException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.voidAuthorizationService().getVoidAuthorizationById(VOID_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID))));
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVoidAuthorizationById_ioException_throwsPaysafeSdkException() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class, () -> paysafeClient.voidAuthorizationService().getVoidAuthorizationById(VOID_ID)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, VOID_ID))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetVoidAuthorizationUsingMerchantReferenceNumber() throws PaysafeSdkException {

    stubFor(get(urlPathEqualTo(VOID_AUTHORIZATION_GET_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("void_authorization/get_void_authorization_using_merchant_ref_number_response.json")));

    VoidAuthorizationsList response = paysafeClient.voidAuthorizationService().getVoidAuthorizationUsingMerchantReferenceNumber(
        MERCHANT_REF_NUM, null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", VOID_AUTHORIZATION_GET_ENDPOINT, MERCHANT_REF_NUM))));

    assertNotNull(response);
    assertNotNull(response.getVoidAuths());
    assertNotNull(response.getMeta());
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertEquals(10, response.getMeta().getLimit());
    assertEquals(1, response.getMeta().getPage());

    assertEquals(1, response.getVoidAuths().size());
    assertEquals(500L, response.getVoidAuths().get(0).getAmount());
    assertEquals(MERCHANT_REF_NUM, response.getVoidAuths().get(0).getMerchantRefNum());
    assertEquals(VOID_ID, response.getVoidAuths().get(0).getId());
    assertEquals(VoidAuthorizationStatus.COMPLETED, response.getVoidAuths().get(0).getStatus());
    assertEquals("2023-01-20T05:51:42Z", response.getVoidAuths().get(0).getTxnTime());
  }

  @Test
  void testCreateVoidAuthorization_throwsRequestConflictException() {

    stubFor(post(urlEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID)))
        .willReturn(aResponse()
            .withStatus(409)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withHeader(HEADER_X_INTERNAL_CORRELATION_ID, "random_correlation_id")
            .withBodyFile("error/409_request_conflict_response.json")));

    VoidAuthorizationRequest voidAuthRequest = VoidAuthorizationRequest
        .builder()
        .amount(500L)
        .merchantRefNum(MERCHANT_REF_NUM)
        .build();

    RequestConflictException exception = assertThrows(
        RequestConflictException.class, () -> paysafeClient.voidAuthorizationService().voidAuthorization(PAYMENT_ID, voidAuthRequest)
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(String.format(VOID_AUTHORIZATION_ENDPOINT, PAYMENT_ID))));

    assertEquals("random_correlation_id", exception.getInternalCorrelationId());
    assertEquals("DW-CUSTOMER-CONFLICT", exception.getError().getCode());
    assertEquals("Customer conflict", exception.getError().getMessage());

    assertEquals(1, exception.getError().getAdditionalDetails().size());
    assertEquals("Customer already exists.", exception.getError().getAdditionalDetails().get(0).getMessage());
    assertEquals("22", exception.getError().getAdditionalDetails().get(0).getCode());
    assertEquals("Duplication", exception.getError().getAdditionalDetails().get(0).getType());

    assertNull(exception.getError().getDetails());
    assertNull(exception.getError().getDetails());
  }
}