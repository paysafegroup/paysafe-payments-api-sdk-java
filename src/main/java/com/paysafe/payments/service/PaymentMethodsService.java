// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.paymentmethod.LookUpPaymentMethodsResponse;

public interface PaymentMethodsService {

  /**
   * Retrieves the list of payment methods enabled for a given merchant account by currency code.
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/paymentmethods</strong></p>
   *
   * @param currencyCode the currency code for the merchant account (e.g. USD, CAD)
   * @return PaymentMethodsResponse containing the list of payment methods
   * @throws PaysafeSdkException if an error occurs with the Payments API
   */
  LookUpPaymentMethodsResponse lookUpPaymentMethods(final CurrencyCode currencyCode) throws PaysafeSdkException;

  /**
   * Retrieves the list of payment methods enabled for a given merchant account by currency code.
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout
   * and/or automaticRetries), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/paymentmethods</strong></p>
   *
   * @param currencyCode   the currency code for the merchant account (e.g. USD, CAD)
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return PaymentMethodsResponse containing the list of payment methods
   * @throws PaysafeSdkException if an error occurs with the Payments API
   */
  LookUpPaymentMethodsResponse lookUpPaymentMethods(final CurrencyCode currencyCode, final RequestOptions requestOptions) throws PaysafeSdkException;
}
