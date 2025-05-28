// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;

/**
 * Starts http-only instance of WireMock server for proxy testing.
 */
public class PaysafeClientProxyTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";
  public static final String API_KEY = "clientId:clientKey";

  private static WireMockServer wireMockServer;

  // initialize one WireMock server, which is 'cheaper' than creating new instance for each test
  @BeforeAll
  static void init() {
    wireMockServer = new WireMockServer(
        options()
            .port(8443)
            .usingFilesUnderDirectory("src/test/resources")
    );
    wireMockServer.start();
    WireMock.configureFor("localhost", 8443);
  }

  // stop the server after all tests were executed
  @AfterAll
  static void stopWireMock() {
    wireMockServer.stop();
  }

  // reset all counters and mappings between tests
  @BeforeEach
  void resetAll() {
    wireMockServer.resetAll();
  }

  @Test
  void testProxy_withProvidedProxy() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")
        ));

    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("localhost", 8443));

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .proxy(proxy)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }

  @Test
  void testProxy_withSystemPropertiesHttp() throws PaysafeSdkException {

    System.setProperty("http.proxyHost", "localhost");
    System.setProperty("http.proxyPort", "8443");
    System.setProperty("http.proxyUser", "squid");
    System.setProperty("http.proxyPassword", "ward");

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")
        ));

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());

    System.clearProperty("http.proxyHost");
    System.clearProperty("http.proxyPort");
    System.clearProperty("http.proxyUser");
    System.clearProperty("http.proxyPassword");
  }

  @Test
  void testProxy_withSystemPropertiesHttps() throws PaysafeSdkException {

    System.setProperty("https.proxyHost", "localhost");
    System.setProperty("https.proxyPort", "8443");
    System.setProperty("https.proxyUser", "squid");
    System.setProperty("https.proxyPassword", "ward");

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")
        ));

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());

    System.clearProperty("https.proxyHost");
    System.clearProperty("https.proxyPort");
    System.clearProperty("https.proxyUser");
    System.clearProperty("https.proxyPassword");
  }

  @Test
  void testProxy_providedProxyOverridesSystemProperties() throws PaysafeSdkException {

    System.setProperty("http.proxyHost", "testuri");
    System.setProperty("http.proxyPort", "1000");
    System.setProperty("http.proxyUser", "squid");
    System.setProperty("http.proxyPassword", "ward");

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")
        ));

    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("localhost", 8443));

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .proxy(proxy)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    WireMock.verify(1, getRequestedFor(urlEqualTo(MONITOR_ENDPOINT)));
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());

    System.clearProperty("http.proxyHost");
    System.clearProperty("http.proxyPort");
    System.clearProperty("http.proxyUser");
    System.clearProperty("http.proxyPassword");
  }
}
