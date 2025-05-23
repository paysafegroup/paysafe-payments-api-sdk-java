// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.standalonecredit.StandaloneCredit;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditList;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditRequest;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditUpdateRequest;

public interface StandaloneCreditService {

  /**
   * Processes a Standalone Credit transaction.  <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/standalonecredits</strong></p>
   *
   * @param body The request body containing the details for the Standalone Credit.
   * @return StandaloneCredit
   * @throws PaysafeSdkException if an error occurs
   */
  StandaloneCredit processStandaloneCredit(final StandaloneCreditRequest body) throws PaysafeSdkException;

  /**
   * Processes a Standalone Credit transaction.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/standalonecredits</strong></p>
   *
   * @param body           The request body containing the details for the Standalone Credit.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return StandaloneCredit
   * @throws PaysafeSdkException if an error occurs
   */
  StandaloneCredit processStandaloneCredit(final StandaloneCreditRequest body, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets standalone credit using the merchant reference number.  <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/standalonecredits</strong></p>
   *
   * @param merchantRefNum The merchant reference number used in the transactions.
   * @param startDate      The start date for filtering transactions.
   * @param endDate        The end date for filtering transactions.
   * @param limit          The maximum number of records to return.
   * @param offset         The pagination offset.
   * @return A list of {@code StandaloneCredit} objects representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  StandaloneCreditList getStandaloneCreditUsingMerchantReferenceNumber(final String merchantRefNum,
      final String endDate, final Integer limit, final Integer offset,
      final String startDate) throws PaysafeSdkException;

  /**
   * Gets standalone credit using the merchant reference number.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/standalonecredits</strong></p>
   *
   * @param merchantRefNum The merchant reference number used in the transactions.
   * @param startDate      The start date for filtering transactions.
   * @param endDate        The end date for filtering transactions.
   * @param limit          The maximum number of records to return.
   * @param offset         The pagination offset.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A list of {@code StandaloneCredit} objects representing the response from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  StandaloneCreditList getStandaloneCreditsUsingMerchantReferenceNumber(final String merchantRefNum,
      final String endDate, final Integer limit, final Integer offset,
      final String startDate, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets a standalone credit using the given standaloneCreditId.  <br>
   * Utilizes the PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/standalonecredits/{standaloneCreditId}</strong></p>
   *
   * <p>Use this method to look up a Standalone Credit by its ID, which is returned
   * in the response to the original Standalone Credit request.</p>
   *
   * @param standaloneCreditId The ID returned in the response of the Standalone Credit request.
   *                           This ID is required for making subsequent requests.
   * @return A {@code StandaloneCredit} object representing the response from Paysafe, containing details about the standalone credit.
   * @throws PaysafeSdkException If the request fails, or the response cannot be processed
   */
  StandaloneCredit getStandaloneCreditById(final String standaloneCreditId) throws PaysafeSdkException;

  /**
   * Gets a standalone credit using the given standaloneCreditId.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/standalonecredits/{standaloneCreditId}</strong></p>
   *
   * <p>Use this method to look up a Standalone Credit by its ID, which is returned
   * in the response to the original Standalone Credit request.</p>
   *
   * @param standaloneCreditId The ID returned in the response of the Standalone Credit request.
   *                           This ID is required for making subsequent requests.
   * @param requestOptions     Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A {@code StandaloneCredit} object representing the response from Paysafe, containing details about the standalone credit.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  StandaloneCredit getStandaloneCreditById(final String standaloneCreditId, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Cancels a standalone credit using the given standaloneCreditId.  <br>
   * Utilizes the PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/standalonecredits/{standaloneCreditId}</strong></p>
   *
   * <p>Use this method to cancel a Standalone Credit by its ID.</p>
   *
   * @param standaloneCreditId The unique ID of the Standalone Credit, returned in the original response.
   * @param cancelRequest      The request body for canceling a Standalone Credit.
   *                           This ID is required to process the cancellation request.
   * @return A {@code CancelResponse} object containing details about the canceled Standalone Credit, including the status and transaction time.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  CancelResponse cancelStandaloneCredit(final String standaloneCreditId, final CancelRequest cancelRequest) throws PaysafeSdkException;

  /**
   * Cancels a standalone credit using the given standaloneCreditId.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/standalonecredits/{standaloneCreditId}</strong></p>
   *
   * <p>Use this method to cancel a Standalone Credit by its ID.</p>
   *
   * @param standaloneCreditId The unique ID of the Standalone Credit, returned in the original response.
   * @param cancelRequest      The request body for canceling a Standalone Credit.
   * @param requestOptions     Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return A {@code CancelResponse} object containing details about the canceled Standalone Credit, including the status and transaction time.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  CancelResponse cancelStandaloneCredit(final String standaloneCreditId, final CancelRequest cancelRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Updates a Standalone Credit using the Interac e-Transfer Fraud API.  <br>
   * Utilizes the PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>PATCH /v1/standalonecredits/{standaloneCreditId}</strong></p>
   *
   * @param standaloneCreditId  The unique ID of the Standalone Credit to update.
   * @param creditUpdateRequest The request body containing fraud-related information.
   * @return An updated {@code StandaloneCredit} object after the fraud update.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  StandaloneCredit patchStandaloneCreditStatusForInteracFraud(final String standaloneCreditId,
      final StandaloneCreditUpdateRequest creditUpdateRequest) throws PaysafeSdkException;

  /**
   * Updates a Standalone Credit using the Interac e-Transfer Fraud API.  <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PATCH /v1/standalonecredits/{standaloneCreditId}</strong></p>
   *
   * @param standaloneCreditId  The unique ID of the Standalone Credit to update.
   * @param creditUpdateRequest The request body containing fraud-related information.
   * @param requestOptions      Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return An updated {@code StandaloneCredit} object after the fraud update.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  StandaloneCredit patchStandaloneCreditStatusForInteracFraud(final String standaloneCreditId,
      final StandaloneCreditUpdateRequest creditUpdateRequest, final RequestOptions requestOptions) throws PaysafeSdkException;
}
