// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;
import static config.TestHttpClientProvider.createTestSslContext;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.service.MonitorService;
import com.paysafe.payments.service.impl.MonitorServiceImpl;

import base.BasePaysafeClientTest;

public class PaysafeClientConfigurationTest extends BasePaysafeClientTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";
  public static final String API_KEY = "clientId:clientKey";

  @Test
  void test_customConnectTimeout() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {

    // we are using non-routable base url for testing connect timeout
    // zero automatic retries for checking if connect timeout is correctly set
    PaysafeApiClient customPaysafeApiClient = PaysafeApiClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .maxAutomaticRetries(0)
        .connectTimeout(1000)
        .responseTimeout(5000)
        .build();
    customPaysafeApiClient.overrideBaseUrl("http://192.0.0.1:8080");

    MonitorService customMonitorService = new MonitorServiceImpl(customPaysafeApiClient);

    long startTime = System.currentTimeMillis();

    PaysafeSdkException exception = assertThrows(
        ApiConnectionException.class, customMonitorService::verifyThatServiceIsAccessible
    );

    long endTime = System.currentTimeMillis();

    assertTrue(exception.getMessage().contains("Error connecting to http://192.0.0.1:8080"));
    assertTrue(exception.getMessage().contains("failed: connect timed out"));
    assertTrue(endTime - startTime >= 1000);
    assertTrue(endTime - startTime <= 2000); // include processing overhead
  }

  @Test
  void test_customRequestTimeout() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withFixedDelay(6000)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")
        ));

    PaysafeApiClient customPaysafeApiClient = PaysafeApiClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .maxAutomaticRetries(0)
        .connectTimeout(1000)
        .responseTimeout(5000)
        .build();
    customPaysafeApiClient.overrideBaseUrl(WIREMOCK_URL);

    MonitorService customMonitorService = new MonitorServiceImpl(customPaysafeApiClient);

    PaysafeSdkException exception = assertThrows(
        ApiConnectionException.class, customMonitorService::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
    assertTrue(exception.getMessage().contains("reason: Read timed out"));
  }

  @Test
  void test_validateRequestOptions() {
    RequestOptions requestOptions = new RequestOptions();
    requestOptions.setConnectTimeout(-0);

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions)
    );
    assertEquals(MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE, exception.getMessage());

    requestOptions.setConnectTimeout(1000);

    requestOptions.setResponseTimeout(-100);
    exception = assertThrows(
        IllegalArgumentException.class, () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions)
    );
    assertEquals(MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE, exception.getMessage());

    requestOptions.setMaxAutomaticRetries(-5);

    exception = assertThrows(
        IllegalArgumentException.class, () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions)
    );
    assertEquals(MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE, exception.getMessage());

    requestOptions.setMaxAutomaticRetries(1000);

    exception = assertThrows(
        IllegalArgumentException.class, () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions)
    );
    assertEquals(MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES, exception.getMessage());

    requestOptions.setMaxAutomaticRetries(1);
  }
}
