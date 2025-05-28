// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.buildQueryParameters;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.verification.Verification;
import com.paysafe.payments.model.verification.VerificationList;
import com.paysafe.payments.model.verification.VerificationRequest;
import com.paysafe.payments.service.VerificationService;

public class VerificationServiceImpl implements VerificationService {

  private static final String VERIFICATION_ENDPOINT = "/v1/verifications";

  private final PaysafeApiClient paysafeApiClient;

  public VerificationServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Verification createVerification(final VerificationRequest verificationRequest) throws PaysafeSdkException {
    return createVerification(verificationRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Verification createVerification(final VerificationRequest verificationRequest, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executePost(VERIFICATION_ENDPOINT, verificationRequest, requestOptions);
    return processResponse(response, Verification.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Verification getVerificationById(final String verificationId) throws PaysafeSdkException {
    return getVerificationById(verificationId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Verification getVerificationById(final String verificationId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String endpoint = String.format("%s/%s", VERIFICATION_ENDPOINT, verificationId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(endpoint, requestOptions);
    return processResponse(response, Verification.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VerificationList getVerificationUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate)
      throws PaysafeSdkException {
    return getVerificationUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VerificationList getVerificationUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate, final RequestOptions requestOptions)
      throws PaysafeSdkException {

    final String path = String.format("%s%s", VERIFICATION_ENDPOINT,
        buildQueryParameters(merchantRefNum, endDate, limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, VerificationList.class);
  }
}
