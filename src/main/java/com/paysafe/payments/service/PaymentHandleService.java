// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.paymenthandle.PaymentHandle;
import com.paysafe.payments.model.paymenthandle.PaymentHandleList;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;

public interface PaymentHandleService {

  /**
   * Creates the payment handle. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/paymenthandles</strong></p>
   *
   * @param paymentHandleRequest Contains the details
   * @return created payment handle
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentHandle createPaymentHandle(final PaymentHandleRequest paymentHandleRequest) throws PaysafeSdkException;

  /**
   * Creates the payment handle. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/paymenthandles</strong></p>
   *
   * @param paymentHandleRequest Contains the details
   * @param requestOptions       Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return created payment handle
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentHandle createPaymentHandle(final PaymentHandleRequest paymentHandleRequest, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the payment handle by id. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/paymenthandles/{paymentHandleId}</strong></p>
   *
   * @param paymentHandleId the unique identifier returned when payment handle was created
   * @return PaymentHandle
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentHandle getPaymentHandleById(final String paymentHandleId) throws PaysafeSdkException;

  /**
   * Gets the payment handle by id. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/paymenthandles/{paymentHandleId}</strong></p>
   *
   * @param paymentHandleId the unique identifier returned when payment handle was created
   * @param requestOptions  Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return PaymentHandle
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentHandle getPaymentHandleById(final String paymentHandleId, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the payment handle using merchant reference number. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/paymenthandles</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the request when creating payment handle.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @return PaymentHandleList containing a list of verifications and meta information for the pagination APIs
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentHandleList getPaymentHandleUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate) throws PaysafeSdkException;

  /**
   * Gets the payment handle using merchant reference number. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/paymenthandles</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the request when creating payment handle.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return PaymentHandleList containing a list of verifications and meta information for the pagination APIs
   * @throws PaysafeSdkException if an error occurs
   */
  PaymentHandleList getPaymentHandleUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate, final RequestOptions requestOptions) throws PaysafeSdkException;
}
