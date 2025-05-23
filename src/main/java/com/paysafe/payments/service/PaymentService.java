// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.payment.PaymentList;
import com.paysafe.payments.model.payment.PaymentRequest;

public interface PaymentService {

  /**
   * Creates a payment. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments</strong></p>
   *
   * @return Payment
   * @throws PaysafeSdkException if an error occurs
   */
  Payment processPayment(final PaymentRequest paymentReqBody) throws PaysafeSdkException;

  /**
   * Creates a payment. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments</strong></p>
   *
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return Payment
   * @throws PaysafeSdkException if an error occurs
   */
  Payment processPayment(final PaymentRequest paymentReqBody, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the payment using merchant reference number. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/payments</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the request when creating payment handle.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @return a PaymentList object containing a list of verifications and meta information for the pagination APIs.
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentList getPaymentsUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate) throws PaysafeSdkException;

  /**
   * Gets the payment using merchant reference number. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/payments</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the request when creating payment handle.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return a PaymentList object containing a list of verifications and meta information for the pagination APIs.
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentList getPaymentsUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the details of a specific payment by its unique ID. Uses PaysafeClient configuration
   * to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments/{paymentId}</strong></p>
   *
   * @param paymentId the id of the payment
   * @return Payment containing the payment details
   * @throws PaysafeSdkException if an error occurs
   */
  Payment getPaymentById(final String paymentId) throws PaysafeSdkException;

  /**
   * Gets the details of a specific payment by its unique ID. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments/{paymentId}</strong></p>
   *
   * @param paymentId      the id of the payment
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return Payment containing the payment details
   * @throws PaysafeSdkException if an error occurs
   */
  Payment getPaymentById(final String paymentId, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Cancels a payment using a specific paymentId. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/payments/{paymentId}</strong></p>
   *
   * @return CancelResponse
   * @throws PaysafeSdkException if an error occurs
   */
  CancelResponse cancelPayment(final String paymentId, final CancelRequest cancelRequest) throws PaysafeSdkException;

  /**
   * Cancels a payment using a specific paymentId. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/payments/{paymentId}</strong></p>
   *
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return CancelResponse
   * @throws PaysafeSdkException if an error occurs
   */
  CancelResponse cancelPayment(final String paymentId, final CancelRequest cancelRequest, final RequestOptions requestOptions) throws PaysafeSdkException;
}
