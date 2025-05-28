// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.verification.Verification;
import com.paysafe.payments.model.verification.VerificationList;
import com.paysafe.payments.model.verification.VerificationRequest;

public interface VerificationService {

  /**
   * Verification allows merchants to validate a credit card without charging any amount on the card. <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/verifications</strong></p>
   *
   * @param verificationRequest request body
   * @return details of a verification for a specific payment type.
   * @throws PaysafeSdkException if an error occurs
   */
  Verification createVerification(final VerificationRequest verificationRequest) throws PaysafeSdkException;

  /**
   * Verification allows merchants to validate a credit card without charging any amount on the card. <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/verifications</strong></p>
   *
   * @param verificationRequest request body
   * @param requestOptions      Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return details of a verification for a specific payment type.
   * @throws PaysafeSdkException if an error occurs
   */
  Verification createVerification(final VerificationRequest verificationRequest, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the details of a verification for a specific payment type by its unique ID. <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/verifications/{verificationId}</strong></p>
   *
   * @param verificationId the id of the verification
   * @return Verification containing the verification details for a specific payment type
   * @throws PaysafeSdkException if an error occurs
   */
  Verification getVerificationById(final String verificationId) throws PaysafeSdkException;

  /**
   * Gets the details of a verification for a specific payment type by its unique ID. <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/verifications/{verificationId}</strong></p>
   *
   * @param verificationId the id of the verification
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return Verification containing the verification details for a specific payment type
   * @throws PaysafeSdkException if an error occurs
   */
  Verification getVerificationById(final String verificationId, RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the verification for a specific payment type by merchant reference number. <br>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/verifications</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the request when creating verification.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @return VerificationList object containing a list of verifications and meta information for pagination APIs
   * @throws PaysafeSdkException if an error occurs
   */
  VerificationList getVerificationUsingMerchantReferenceNumber(String merchantRefNum, String endDate, Integer limit,
      Integer offset, String startDate) throws PaysafeSdkException;

  /**
   * Gets the verification for a specific payment type by merchant reference number. <br>
   * The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/verifications/{verificationId}</strong></p>
   *
   * @param merchantRefNum Unique merchant reference number created by the merchant and submitted as part of the request when creating verification.
   * @param endDate        This is the end date in UTC. If null is provided, current date will be used.
   * @param limit          This is the total number of records to return. If null is provided, default value (10) will be used.
   * @param offset         This is the starting position, where 0 is the first record. If null is provided, default value (0) will be used.
   * @param startDate      This is the start date in UTC. If null is provided, default value (30 days before the end date) will be used.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return VerificationList object containing a list of verifications and meta information for pagination APIs
   * @throws PaysafeSdkException if an error occurs
   */
  VerificationList getVerificationUsingMerchantReferenceNumber(String merchantRefNum, String endDate, Integer limit,
      Integer offset, String startDate, RequestOptions requestOptions) throws PaysafeSdkException;
}
