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
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.paymentfacilitator.SubMerchant;
import com.paysafe.payments.model.common.paymentfacilitator.SubMerchantAddress;
import com.paysafe.payments.model.verification.Verification;
import com.paysafe.payments.model.verification.VerificationList;
import com.paysafe.payments.model.verification.VerificationRequest;

import base.BasePaysafeClientTest;

class VerificationServiceTest extends BasePaysafeClientTest {

  public static final String VERIFICATION_ENDPOINT = "/paymenthub/v1/verifications";

  public static final String VERIFICATION_ID = "71aea8ae-e801-4df3-9436-c5a61c88d3ad";
  public static final String MERCHANT_REF_NUM = "2009581773001912343";

  @Test
  void testGetVerificationById_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID)))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("verification/get_verification_by_id_card_response.json")));

    Verification response = paysafeClient.verificationService().getVerificationById(VERIFICATION_ID);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID))));
    assertNotNull(response);
  }

  @Test
  void testGetVerificationById_throwsExceptionOnInvalidCredentialsError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID)))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationById_throwsExceptionOnEntityNotFoundError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID)))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationById_throwsExceptionOnUnauthorizedAccessError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID)))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationById_throwsPaysafeSdkExceptionOnIOError() {

    stubFor(get(urlPathEqualTo(String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID)))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class, () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID)
    );

    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("verification/get_verification_using_merchant_ref_num_card_response.json")));

    VerificationList response = paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM,
        null, null, null, null);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM))));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertNotNull(response.getVerifications());
    assertFalse(response.getVerifications().isEmpty());
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubFor(get(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json"))
    );

    InvalidCredentialsException exception = assertThrows(
        InvalidCredentialsException.class, () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM,
            null, null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(get(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json"))
    );

    UnauthorizedException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM,
            null, null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubFor(get(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/404_entity_not_found_response.json"))
    );

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM,
            null, null, null, null)
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM))));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(get(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .withQueryParam("merchantRefNum", equalTo(MERCHANT_REF_NUM))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class,
        () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM,
            null, null, null, null)
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM))));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void testCreateVerification_isSuccessful() throws PaysafeSdkException {
    stubFor(post(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("verification/create_verification_card_response.json")));

    Verification response = paysafeClient.verificationService().createVerification(buildVerificationRequest());

    WireMock.verify(1, postRequestedFor(urlEqualTo(VERIFICATION_ENDPOINT)));
    assertNotNull(response);
  }

  @Test
  void testCreateVerification_throwsExceptionOnInvalidCredentialsError() {
    stubFor(post(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(401)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/401_invalid_credentials_response.json")));

    InvalidCredentialsException exception = assertThrows(
        InvalidCredentialsException.class,
        () -> paysafeClient.verificationService().createVerification(buildVerificationRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(VERIFICATION_ENDPOINT)));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreateVerification_throwsExceptionOnUnauthorizedAccessError() {
    stubFor(post(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(403)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("error/403_unauthorized_response.json")));

    UnauthorizedException exception = assertThrows(
        UnauthorizedException.class,
        () -> paysafeClient.verificationService().createVerification(buildVerificationRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(VERIFICATION_ENDPOINT)));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreateVerification_throwsPaysafeSdkExceptionOnIOError() {
    stubFor(post(urlPathEqualTo(VERIFICATION_ENDPOINT))
        .willReturn(aResponse()
            .withFault(Fault.EMPTY_RESPONSE)));

    ApiConnectionException exception = assertThrows(
        ApiConnectionException.class,
        () -> paysafeClient.verificationService().createVerification(buildVerificationRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(VERIFICATION_ENDPOINT)));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  private VerificationRequest buildVerificationRequest() {
    return VerificationRequest.builder()
        .paymentHandleToken("SCTGXiTclLWRk5Pt")
        .merchantRefNum("2ca14f87ff6f60976d18")
        .customerIp("172.10.12.64")
        .dupCheck(Boolean.FALSE)
        .description("Winning payment from Loto 649")
        .paymentFacilitator(PaymentFacilitator.builder()
            .subMerchant(SubMerchant.builder()
                .id("123456789")
                .name("PayFacSubMerchant")
                .phone("478234562331")
                .email("payfac@mail.com")
                .url("www.payfac.com")
                .address(SubMerchantAddress.builder()
                    .street("100 Queen Street West")
                    .city("Toronto")
                    .state("ON")
                    .country("CA")
                    .zip("M5H 2N2")
                    .build())
                .build())
            .build())
        .build();
  }
}
