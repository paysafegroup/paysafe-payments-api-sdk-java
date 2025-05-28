// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.buildQueryParameters;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.paymenthandle.PaymentHandle;
import com.paysafe.payments.model.paymenthandle.PaymentHandleList;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.service.PaymentHandleService;

/**
 * Service for managing payment handles
 */
public class PaymentHandleServiceImpl implements PaymentHandleService {

  private static final String PAYMENT_HANDLE_ENDPOINT = "/v1/paymenthandles";

  private final PaysafeApiClient paysafeApiClient;

  public PaymentHandleServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentHandle createPaymentHandle(final PaymentHandleRequest paymentHandleRequest) throws PaysafeSdkException {
    return createPaymentHandle(paymentHandleRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentHandle createPaymentHandle(final PaymentHandleRequest paymentHandleRequest, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executePost(PAYMENT_HANDLE_ENDPOINT, paymentHandleRequest, requestOptions);
    return processResponse(response, PaymentHandle.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentHandle getPaymentHandleById(final String paymentHandleId) throws PaysafeSdkException {
    return getPaymentHandleById(paymentHandleId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentHandle getPaymentHandleById(final String paymentHandleId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s/%s", PAYMENT_HANDLE_ENDPOINT, paymentHandleId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, PaymentHandle.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentHandleList getPaymentHandleUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate)
      throws PaysafeSdkException {
    return getPaymentHandleUsingMerchantReferenceNumber(
        merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentHandleList getPaymentHandleUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate, final RequestOptions requestOptions)
      throws PaysafeSdkException {

    final String path = String.format("%s%s", PAYMENT_HANDLE_ENDPOINT,
        buildQueryParameters(merchantRefNum, endDate, limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);

    return processResponse(response, PaymentHandleList.class);
  }
}
