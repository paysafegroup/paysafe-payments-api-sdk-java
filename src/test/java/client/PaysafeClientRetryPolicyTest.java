// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import static config.TestHttpClientProvider.createTestSslContext;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.github.tomakehurst.wiremock.stubbing.Scenario;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.ApiException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.InvalidRequestException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.RequestConflictException;
import com.paysafe.payments.errorhandling.exception.RequestDeclinedException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.service.MonitorService;
import com.paysafe.payments.service.impl.MonitorServiceImpl;

import base.BasePaysafeClientTest;

public class PaysafeClientRetryPolicyTest extends BasePaysafeClientTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";
  public static final String PAYMENT_HANDLES_ENDPOINT = "/paymenthub/v1/paymenthandles";

  public static final String API_KEY = "clientId:clientKey";

  @Test
  void test_defaultAutomaticRetryPolicy() {

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("thirdAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("thirdAttempt")
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("fourthAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("fourthAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    PaysafeSdkException exception = assertThrows(
        ApiConnectionException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(3, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
  }

  @Test
  void test_doesNotRepeatOn400() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(400)
            .withBodyFile("error/400_bad_request_field_errors_response.json"))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        InvalidRequestException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
  }

  @Test
  void test_doesNotRepeatOn401() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(401)
            .withBodyFile("error/401_invalid_credentials_response.json")
        )
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        InvalidCredentialsException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
  }

  @Test
  void test_doesNotRepeatOn402() {
    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(402)
            .withBodyFile("error/402_request_declined_response.json")
        )
        .willSetStateTo("secondAttempt"));

    stubFor(post(urlPathEqualTo(PAYMENT_HANDLES_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        RequestDeclinedException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest())
    );

    WireMock.verify(1, postRequestedFor(urlEqualTo(PAYMENT_HANDLES_ENDPOINT)));
  }

  @Test
  void test_doesNotRepeatOn403() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(403)
            .withBodyFile("error/403_unauthorized_response.json")
        )
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        UnauthorizedException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
  }

  @Test
  void test_doesNotRepeatOn404() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(404)
            .withBodyFile("error/404_entity_not_found_response.json"))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        PaysafeSdkException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
  }

  @Test
  void test_doesNotRepeatOn409() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(409)
            .withBodyFile("error/409_request_conflict_response.json"))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        RequestConflictException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
  }

  @Test
  void test_doesNotRepeatOn500() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse()
            .withStatus(500)
            .withBodyFile("error/500_internal_server_error_response.json"))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    assertThrows(
        ApiException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible
    );

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
  }

  @Test
  void test_usingRequestOptions() {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withFixedDelay(3000)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.setMaxAutomaticRetries(1);
    requestOptions.setResponseTimeout(2000);

    PaysafeSdkException exception = assertThrows(
        ApiConnectionException.class, () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions)
    );

    // Retrieve all the serve events (requests) recorded by WireMock
    List<ServeEvent> events = WireMock.getAllServeEvents();

    assertEquals(2, events.size());

    // Sort the events by their logged timestamp to ensure chronological order.
    List<ServeEvent> sortedEvents = events.stream()
        .sorted(Comparator.comparingLong(e -> e.getRequest().getLoggedDate().getTime()))
        .collect(Collectors.toList());

    // Extract timestamps (in milliseconds) for each request.
    long t0 = sortedEvents.get(0).getRequest().getLoggedDate().getTime();
    long t1 = sortedEvents.get(1).getRequest().getLoggedDate().getTime();

    // Calculate delays between retries
    long delay1 = t1 - t0;

    // For an exponential backoff with a base delay of 100ms and jitter in range 75% - 100%, we expect:
    // 1st delay >= 100ms
    assertTrue(delay1 >= 75);

    WireMock.verify(2, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertTrue(exception.getMessage().contains("Error connecting to " + WIREMOCK_URL));
    assertTrue(exception.getMessage().contains("reason: Read timed out"));
  }

  @Test
  void test_customAutomaticRetryPolicy() throws PaysafeSdkException, NoSuchAlgorithmException, KeyManagementException {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("secondAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("secondAttempt")
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("thirdAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("thirdAttempt")
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
        .willSetStateTo("fourthAttempt"));

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .inScenario("retryScenario")
        .whenScenarioStateIs("fourthAttempt")
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")));

    PaysafeApiClient paysafeApiClient = PaysafeApiClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .maxAutomaticRetries(3)
        .connectTimeout(1000)
        .responseTimeout(5000)
        .build();
    paysafeApiClient.overrideBaseUrl(WIREMOCK_URL);

    MonitorService customMonitorService = new MonitorServiceImpl(paysafeApiClient);

    MonitorResponse monitorResponse = customMonitorService.verifyThatServiceIsAccessible();

    WireMock.verify(4, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());

    // Retrieve all the serve events (requests) recorded by WireMock
    List<ServeEvent> events = WireMock.getAllServeEvents();

    // Expect 4 attempts (3 failures and 1 success)
    assertEquals(4, events.size());

    // Sort the events by their logged timestamp to ensure chronological order.
    List<ServeEvent> sortedEvents = events.stream()
        .sorted(Comparator.comparingLong(e -> e.getRequest().getLoggedDate().getTime()))
        .collect(Collectors.toList());

    // Extract timestamps (in milliseconds) for each request.
    long t0 = sortedEvents.get(0).getRequest().getLoggedDate().getTime();
    long t1 = sortedEvents.get(1).getRequest().getLoggedDate().getTime();
    long t2 = sortedEvents.get(2).getRequest().getLoggedDate().getTime();
    long t3 = sortedEvents.get(3).getRequest().getLoggedDate().getTime();

    // Calculate delays between retries
    long delay1 = t1 - t0;
    long delay2 = t2 - t1;
    long delay3 = t3 - t2;

    // For an exponential backoff with a base delay of 100ms and jitter in range 75% - 100%, we expect:
    // - 1st delay in range 75 - 100 ms
    // - 2nd delay in range 225 - 300 ms
    // - 3rd delay in range 675 - 900 ms
    assertTrue(delay1 >= 75);
    assertTrue(delay2 >= 225);
    assertTrue(delay3 >= 675);
  }
}
