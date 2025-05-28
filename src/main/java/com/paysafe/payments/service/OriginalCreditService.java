// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.originalcredit.OriginalCredit;
import com.paysafe.payments.model.originalcredit.OriginalCreditList;
import com.paysafe.payments.model.originalcredit.OriginalCreditRequest;

public interface OriginalCreditService {

  /**
   * Processes an Original Credit transaction for a merchant.
   * Original Credits allow merchants with specific merchant category codes (MCCs) to issue winnings as credits to cardholders,
   * without requiring a previous transaction.  <br>
   * Uses the PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/originalcredits</strong></p>
   *
   * @param originalCreditRequest The request body containing all necessary details for processing the original credit.
   * @return An {@code OriginalCredit} object containing the response details from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  OriginalCredit processOriginalCredit(final OriginalCreditRequest originalCreditRequest) throws PaysafeSdkException;

  /**
   * Processes an Original Credit transaction for a merchant.
   * Original Credits allow merchants with specific merchant category codes (MCCs) to issue winnings
   * as credits to cardholders, without requiring a previous transaction. <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, and/or automaticRetries),
   * instead of the values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/originalcredits</strong></p>
   *
   * @param originalCreditRequest The request body containing all necessary details for processing the original credit.
   * @param requestOptions        Custom request options for controlling the request behavior.
   * @return An {@code OriginalCredit} object containing the response details from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  OriginalCredit processOriginalCredit(final OriginalCreditRequest originalCreditRequest, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the details of an Original Credit transaction using its unique identifier.
   * This endpoint allows merchants to look up the status and details of an existing Original Credit
   * transaction by providing the original credit ID received in the initial response. <br>
   * Uses the PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/originalcredits/{originalCreditId}</strong></p>
   *
   * @param originalCreditId The unique identifier of the original credit transaction to be retrieved.
   * @return An {@code OriginalCredit} object containing the response details from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  OriginalCredit getOriginalCreditById(final String originalCreditId) throws PaysafeSdkException;

  /**
   * Gets the details of an Original Credit transaction using its unique identifier with custom request options.
   * This endpoint allows merchants to look up the status and details of an existing Original Credit transaction,
   * using specified request parameters for customized behavior such as timeouts and retries.
   *
   * <p>Endpoint:
   * <strong>GET /v1/originalcredits/{originalCreditId}</strong></p>
   *
   * @param originalCreditId The unique identifier of the original credit transaction to be retrieved.
   * @param requestOptions   Custom request options for controlling the request behavior.
   * @return An {@code OriginalCredit} object containing the response details from Paysafe.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  OriginalCredit getOriginalCreditById(final String originalCreditId, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the details of one or more Original Credit transactions using the merchant reference number. <br>
   * Uses the PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/originalcredits?</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the original credit request.
   * @param endDate        The end date in UTC. If null is provided, the current date will be used.
   * @param limit          The total number of records to return. If null is provided, the default value (10) will be used.
   * @param offset         The starting position, where 0 is the first record. If null is provided, the default value (0) will be used.
   * @param startDate      The start date in UTC. If null is provided, the default value (30 days before the end date) will be used.
   * @return an {@code OriginalCreditList} object containing a list of original credit transactions and pagination metadata.
   * @throws PaysafeSdkException if an error occurs during the request.
   */
  OriginalCreditList getOriginalCreditUsingMerchantReferenceNumber(final String merchantRefNum,
      final String endDate, final Integer limit, final Integer offset, final String startDate) throws PaysafeSdkException;

  /**
   * Gets the details of one or more Original Credit transactions using the merchant reference number. <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, and/or automaticRetries)
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/originalcredits?</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the original credit request.
   * @param endDate        The end date in UTC. If null is provided, the current date will be used.
   * @param limit          The total number of records to return. If null is provided, the default value (10) will be used.
   * @param offset         The starting position, where 0 is the first record. If null is provided, the default value (0) will be used.
   * @param startDate      The start date in UTC. If null is provided, the default value (30 days before the end date) will be used.
   * @param requestOptions Custom connectTimeout, responseTimeout, and/or maxAutomaticRetries for this request.
   * @return an {@code OriginalCreditList} object containing a list of original credit transactions and pagination metadata.
   * @throws PaysafeSdkException if an error occurs during the request.
   */
  OriginalCreditList getOriginalCreditUsingMerchantReferenceNumber(final String merchantRefNum,
      final String endDate, final Integer limit, final Integer offset, final String startDate,
      final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Cancels a pending Original Credit request. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/originalcredits/{originalCreditId}</strong></p>
   *
   * @param originalCreditId The ID of the Original Credit to cancel.
   * @param cancelRequest    The request body for canceling an Original Credit.
   * @return A {@code CancelResponse} object containing the updated Original Credit details.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  CancelResponse cancelOriginalCredit(final String originalCreditId, final CancelRequest cancelRequest) throws PaysafeSdkException;

  /**
   * Cancels a pending Original Credit request. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/originalcredits/{originalCreditId}</strong></p>
   *
   * @param originalCreditId The ID of the Original Credit to cancel.
   * @param cancelRequest    The request body for canceling an Original Credit.
   * @param requestOptions   Custom request options for timeout, retries, etc.
   * @return A {@code CancelResponse} object containing the updated Original Credit details.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  CancelResponse cancelOriginalCredit(final String originalCreditId, final CancelRequest cancelRequest, final RequestOptions requestOptions)
      throws PaysafeSdkException;
}