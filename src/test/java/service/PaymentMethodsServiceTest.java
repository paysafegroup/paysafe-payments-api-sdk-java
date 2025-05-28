// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.APPLICATION_JSON;
import static com.paysafe.payments.api.PaysafeApiClient.CONTENT_TYPE;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymentmethod.LookUpPaymentMethodsResponse;

import base.BasePaysafeClientTest;

public class PaymentMethodsServiceTest extends BasePaysafeClientTest {

  public static final String PAYMENT_METHODS_ENDPOINT = "/paymenthub/v1/paymentmethods";

  @Test
  void testLookUpPaymentMethods_isSuccessful() throws PaysafeSdkException {
    stubFor(get(urlPathEqualTo(PAYMENT_METHODS_ENDPOINT))
        .withQueryParam("currencyCode", equalTo("USD"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)
            .withBodyFile("payment_methods/payment_methods_response.json")));

    LookUpPaymentMethodsResponse response = paysafeClient.lookUpPaymentMethodsService().lookUpPaymentMethods(CurrencyCode.USD);

    WireMock.verify(1, getRequestedFor(urlEqualTo(String.format("%s?currencyCode=USD", PAYMENT_METHODS_ENDPOINT))));

    assertEquals(CurrencyCode.USD, response.getPaymentMethods().get(0).getCurrencyCode());
    assertEquals("1009355920", response.getPaymentMethods().get(0).getAccountId());
    assertEquals(2, response.getPaymentMethods().size());
    assertEquals(PaymentType.CARD, response.getPaymentMethods().get(0).getPaymentMethod());
  }
}
