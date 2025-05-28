// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;

import base.BasePaysafeClientTest;

public class MonitorServiceTest extends BasePaysafeClientTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";

  @Test
  void testVerifyThatServiceIsAccessible_isSuccessful() throws PaysafeSdkException {

    stubFor(get(urlPathEqualTo(MONITOR_ENDPOINT))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("monitor/verify_that_service_is_accessible_response.json")
        ));

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    WireMock.verify(1, getRequestedFor(urlMatching(MONITOR_ENDPOINT)));
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }
}
