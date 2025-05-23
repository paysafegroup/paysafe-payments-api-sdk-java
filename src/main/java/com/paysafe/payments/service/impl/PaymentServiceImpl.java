// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.buildQueryParameters;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.payment.PaymentList;
import com.paysafe.payments.model.payment.PaymentRequest;
import com.paysafe.payments.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

  private static final String PAYMENT_ENDPOINT = "/v1/payments";

  private final PaysafeApiClient paysafeApiClient;

  public PaymentServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Payment processPayment(final PaymentRequest paymentRequest) throws PaysafeSdkException {
    return processPayment(paymentRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Payment processPayment(final PaymentRequest paymentRequest, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executePost(PAYMENT_ENDPOINT, paymentRequest, requestOptions);
    return processResponse(response, Payment.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Payment getPaymentById(final String paymentId) throws PaysafeSdkException {
    return getPaymentById(paymentId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Payment getPaymentById(final String paymentId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s/%s", PAYMENT_ENDPOINT, paymentId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, Payment.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentList getPaymentsUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate)
      throws PaysafeSdkException {
    return getPaymentsUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PaymentList getPaymentsUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate,
      final RequestOptions requestOptions)
      throws PaysafeSdkException {

    final String path = String.format("%s%s", PAYMENT_ENDPOINT,
        buildQueryParameters(merchantRefNum, endDate, limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, PaymentList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelPayment(final String paymentId, CancelRequest cancelRequest) throws PaysafeSdkException {
    return cancelPayment(paymentId, cancelRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelPayment(final String paymentId, CancelRequest cancelRequest, final RequestOptions requestOptions)
      throws PaysafeSdkException {
    final String path = String.format("%s/%s", PAYMENT_ENDPOINT, paymentId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, cancelRequest, requestOptions);
    return processResponse(response, CancelResponse.class);
  }
}
