// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.paymentmethod.LookUpPaymentMethodsResponse;
import com.paysafe.payments.service.PaymentMethodsService;

public class PaymentMethodsServiceImpl implements PaymentMethodsService {

  private static final String PAYMENT_METHODS_ENDPOINT = "/v1/paymentmethods";

  private final PaysafeApiClient paysafeApiClient;

  /**
   * Instantiates a new LookUpPaymentMethodsServiceImpl object.
   *
   * @param paysafeApiClient instance of PaysafeApiClient used to execute API requests
   */
  public PaymentMethodsServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LookUpPaymentMethodsResponse lookUpPaymentMethods(CurrencyCode currencyCode) throws PaysafeSdkException {
    return lookUpPaymentMethods(currencyCode, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LookUpPaymentMethodsResponse lookUpPaymentMethods(CurrencyCode currencyCode, RequestOptions requestOptions)
      throws PaysafeSdkException {

    String path = String.format("%s?currencyCode=%s", PAYMENT_METHODS_ENDPOINT, currencyCode);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, LookUpPaymentMethodsResponse.class);
  }
}
