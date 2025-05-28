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
import com.paysafe.payments.model.originalcredit.OriginalCredit;
import com.paysafe.payments.model.originalcredit.OriginalCreditList;
import com.paysafe.payments.model.originalcredit.OriginalCreditRequest;
import com.paysafe.payments.service.OriginalCreditService;

public class OriginalCreditServiceImpl implements OriginalCreditService {

  public static final String ORIGINAL_CREDIT_ENDPOINT = "/v1/originalcredits";

  private final PaysafeApiClient paysafeApiClient;

  public OriginalCreditServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override public OriginalCredit processOriginalCredit(final OriginalCreditRequest originalCreditRequest) throws PaysafeSdkException {
    return processOriginalCredit(originalCreditRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public OriginalCredit processOriginalCredit(final OriginalCreditRequest originalCreditRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    PaysafeApiResponse response = paysafeApiClient.executePost(ORIGINAL_CREDIT_ENDPOINT, originalCreditRequest, requestOptions);
    return processResponse(response, OriginalCredit.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public OriginalCredit getOriginalCreditById(final String originalCreditId) throws PaysafeSdkException {
    return getOriginalCreditById(originalCreditId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public OriginalCredit getOriginalCreditById(final String originalCreditId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, originalCreditId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, OriginalCredit.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public OriginalCreditList getOriginalCreditUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate,
      final Integer limit, final Integer offset, final String startDate) throws PaysafeSdkException {
    return getOriginalCreditUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public OriginalCreditList getOriginalCreditUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate,
      final Integer limit, final Integer offset, final String startDate, RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s%s", ORIGINAL_CREDIT_ENDPOINT, buildQueryParameters(merchantRefNum, endDate,
        limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, OriginalCreditList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public CancelResponse cancelOriginalCredit(final String originalCreditId, final CancelRequest cancelRequest) throws PaysafeSdkException {
    return cancelOriginalCredit(originalCreditId, cancelRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public CancelResponse cancelOriginalCredit(final String originalCreditId, final CancelRequest cancelRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, originalCreditId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, cancelRequest, requestOptions);
    return processResponse(response, CancelResponse.class);
  }
}
