// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.settlement.SettlementList;
import com.paysafe.payments.model.settlement.SettlementRequest;

public interface SettlementService {

  /**
   * Submits a Settlement request for a previously authorized payment that has not yet been settled. <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments/{paymentId}/settlements</strong></p>
   *
   * @param paymentId         The ID of the payment to be settled.
   * @param settlementRequest The request object containing settlement details.
   * @return A {@code Settlement} object representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Settlement processSettlement(String paymentId, SettlementRequest settlementRequest) throws PaysafeSdkException;

  /**
   * Submits a Settlement request for a previously authorized payment that has not yet been settled. <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/payments/{paymentId}/settlements</strong></p>
   *
   * @param paymentId         The ID of the payment to be settled.
   * @param settlementRequest The request object containing settlement details.
   * @param requestOptions    Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A {@code Settlement} object representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Settlement processSettlement(String paymentId, SettlementRequest settlementRequest, RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * Gets the details of a specific settlement by its unique ID.  <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/settlements/{settlementId}</strong></p>
   *
   * @param settlementId The ID of the settlement.
   * @return A {@code Settlement} object representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Settlement getSettlementById(String settlementId) throws PaysafeSdkException;

  /**
   * Gets the details of a specific settlement by its unique ID.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/settlements/{settlementId}</strong></p>
   *
   * @param settlementId   The ID of the settlement.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A {@code Settlement} object representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Settlement getSettlementById(String settlementId, RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets settlements using the merchant reference number.  <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/settlements</strong></p>
   *
   * @param merchantRefNum The merchant reference number used in the original request.
   * @param startDate      The start date for filtering settlements.
   * @param endDate        The end date for filtering settlements.
   * @param limit          The maximum number of records to return.
   * @param offset         The pagination offset.
   * @return A list of {@code Settlement} objects representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  SettlementList getSettlementsUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate) throws PaysafeSdkException;

  /**
   * Gets settlements using the merchant reference number.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/settlements</strong></p>
   *
   * @param merchantRefNum The merchant reference number used in the original request.
   * @param startDate      The start date for filtering settlements.
   * @param endDate        The end date for filtering settlements.
   * @param limit          The maximum number of records to return.
   * @param offset         The pagination offset.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A list of {@code Settlement} objects representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  SettlementList getSettlementsUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Cancels a pending settlement request.  <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/settlements/{settlementId}</strong></p>
   *
   * @param settlementId  The ID of the settlement to cancel.
   * @param cancelRequest The request body for canceling a Settlement.
   * @return A {@code Settlement} object containing the updated settlement details.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  CancelResponse cancelSettlement(final String settlementId, final CancelRequest cancelRequest) throws PaysafeSdkException;

  /**
   * Cancels a pending settlement request.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/settlements/{settlementId}</strong></p>
   *
   * @param settlementId  The ID of the settlement to cancel.
   * @param cancelRequest The request body for canceling a Settlement.
   * @return A {@code Settlement} object containing the updated settlement details.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  CancelResponse cancelSettlement(final String settlementId, final CancelRequest cancelRequest, final RequestOptions requestOptions) throws PaysafeSdkException;
}