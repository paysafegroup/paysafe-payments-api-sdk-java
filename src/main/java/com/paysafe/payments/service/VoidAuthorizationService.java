// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.voidauthorization.VoidAuthorization;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationRequest;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationsList;

public interface VoidAuthorizationService {

  /**
   * Void an authorization for a given paymentId.  <br>
   * A Void Authorization request allows you to void (or cancel) an authorization request, provided the authorization has not yet been settled.  <br>
   * An authorization is part of a payment request. This is only applicable when settleWithAuth is set to false in the payment request. <br>
   * If settleWithAuth is set to true in the payment request, then the authorization and settlement are completed in the same request.
   * In that case you would not be able to process a Void Authorization.
   * <p>
   *  <br> Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments/{paymentId}/voidauths</strong></p>
   *
   * @param paymentId                The ID of the payment for which the authorization is being voided.
   * @param voidAuthorizationRequest The request body containing the details for the void authorization.
   * @return A {@link VoidAuthorization} object containing the result of the void authorization request.
   * @throws PaysafeSdkException if an error occurs
   */
  VoidAuthorization voidAuthorization(String paymentId, VoidAuthorizationRequest voidAuthorizationRequest)
      throws PaysafeSdkException;

  /**
   * Void an authorization for a given paymentId.  <br>
   * A Void Authorization request allows you to void (or cancel) an authorization request, provided the authorization has not yet been settled.  <br>
   * An authorization is part of a payment request. This is only applicable when settleWithAuth is set to false in the payment request. <br>
   * If settleWithAuth is set to true in the payment request, then the authorization and settlement are completed in the same request.
   * In that case you would not be able to process a Void Authorization. <br>
   * <p>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments/{paymentId}/voidauths</strong></p>
   *
   * @param paymentId                The ID of the payment for which the authorization is being voided.
   * @param voidAuthorizationRequest The request body containing the details for the void authorization.
   * @param requestOptions           Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A {@link VoidAuthorization} object containing the result of the void authorization request.
   * @throws PaysafeSdkException if an error occurs
   */
  VoidAuthorization voidAuthorization(String paymentId, VoidAuthorizationRequest voidAuthorizationRequest, RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * Gets the details of a void authorization by its id. <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/payments/{paymentId}/voidauths/{voidAuthId}</strong></p>
   *
   * @param voidAuthId The ID of the Void Authorization to retrieve.
   * @return A {@link VoidAuthorization} object containing the details of the Void Authorization.
   * @throws PaysafeSdkException if an error occurs
   */
  VoidAuthorization getVoidAuthorizationById(String voidAuthId) throws PaysafeSdkException;

  /**
   * Gets the details of a void authorization by its id.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/payments/{paymentId}/voidauths/{voidAuthId}</strong></p>
   *
   * @param voidAuthId     The ID of the Void Authorization to retrieve.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A {@link VoidAuthorization} object containing the details of the Void Authorization.
   * @throws PaysafeSdkException if an error occurs
   */
  VoidAuthorization getVoidAuthorizationById(String voidAuthId, RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the void authorization for a specific payment type by merchant reference number. <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/payments/{paymentId}/voidauths</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the
   *                       request when creating void authorization.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @return VoidAuthorizationsList object containing a list of verifications and meta information for pagination APIs
   * @throws PaysafeSdkException if an error occurs
   */
  VoidAuthorizationsList getVoidAuthorizationUsingMerchantReferenceNumber(String merchantRefNum, String endDate, Integer limit,
      Integer offset, String startDate) throws PaysafeSdkException;

  /**
   * Gets the void authorization for a specific payment type by merchant reference number.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/payments/{paymentId}/voidauths</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the
   *                       request when creating void authorization.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return VoidAuthorizationsList object containing a list of verifications and meta information for pagination APIs
   * @throws PaysafeSdkException if an error occurs
   */
  VoidAuthorizationsList getVoidAuthorizationUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate, final RequestOptions requestOptions) throws PaysafeSdkException;
}
