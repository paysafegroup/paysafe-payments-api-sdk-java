// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package base;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static config.TestHttpClientProvider.createTestSslContext;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.TextFile;
import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;

public class BasePaysafeClientTest {

  public static final String WIREMOCK_URL = "https://localhost:8443";
  public static final String API_KEY = "clientId:clientKey";

  public static WireMockServer wireMockServer;
  public static PaysafeClient paysafeClient;

  // initialize one WireMock server and PaysafeClient per test class, which is 'cheaper' than creating new instances for each test
  @BeforeAll
  static void init() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    wireMockServer = new WireMockServer(
        options()
            .httpsPort(8443)
            .usingFilesUnderDirectory("src/test/resources")
    );
    wireMockServer.start();

    WireMock.configureFor("https", "localhost", 8443);
    paysafeClient = buildPaysafeClient();
  }

  // stop the server after all tests were executed
  @AfterAll
  static void stopWireMock() {
    wireMockServer.stop();
  }

  public static PaysafeClient buildPaysafeClient() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .build();
    paysafeClient.overrideBaseUrl(WIREMOCK_URL);

    return paysafeClient;
  }

  // reset all counters and mappings between tests
  @BeforeEach
  void resetAll() {
    wireMockServer.resetAll();
  }
}
