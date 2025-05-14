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
import com.paysafe.payments.model.standalonecredit.StandaloneCredit;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditList;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditRequest;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditUpdateRequest;
import com.paysafe.payments.service.StandaloneCreditService;

public class StandaloneCreditServiceImpl implements StandaloneCreditService {

  private static final String STANDALONE_CREDIT_ENDPOINT = "/v1/standalonecredits";
  private static final String ENDPOINT_PATH_FORMAT = "%s/%s";

  private final PaysafeApiClient paysafeApiClient;

  public StandaloneCreditServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StandaloneCredit processStandaloneCredit(StandaloneCreditRequest creditRequest) throws PaysafeSdkException {
    return processStandaloneCredit(creditRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StandaloneCredit processStandaloneCredit(StandaloneCreditRequest creditRequest, RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executePost(STANDALONE_CREDIT_ENDPOINT, creditRequest, requestOptions);
    return processResponse(response, StandaloneCredit.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StandaloneCreditList getStandaloneCreditUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate) throws PaysafeSdkException {

    return getStandaloneCreditsUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StandaloneCreditList getStandaloneCreditsUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format("%s%s", STANDALONE_CREDIT_ENDPOINT, buildQueryParameters(merchantRefNum, endDate,
        limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, StandaloneCreditList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StandaloneCredit getStandaloneCreditById(final String standaloneCreditId) throws PaysafeSdkException {
    return getStandaloneCreditById(standaloneCreditId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StandaloneCredit getStandaloneCreditById(final String standaloneCreditId,
      final RequestOptions requestOptions) throws PaysafeSdkException {
    final String endpoint = String.format(ENDPOINT_PATH_FORMAT, STANDALONE_CREDIT_ENDPOINT, standaloneCreditId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(endpoint, requestOptions);
    return processResponse(response, StandaloneCredit.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelStandaloneCredit(final String standaloneCreditId,
      final CancelRequest cancelRequest) throws PaysafeSdkException {
    return cancelStandaloneCredit(standaloneCreditId, cancelRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelStandaloneCredit(final String standaloneCreditId,
      final CancelRequest cancelRequest, final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(ENDPOINT_PATH_FORMAT, STANDALONE_CREDIT_ENDPOINT, standaloneCreditId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, cancelRequest, requestOptions);
    return processResponse(response, CancelResponse.class);
  }

  @Override public StandaloneCredit patchStandaloneCreditStatusForInteracFraud(final String standaloneCreditId,
      final StandaloneCreditUpdateRequest creditUpdateRequest) throws PaysafeSdkException {
    return patchStandaloneCreditStatusForInteracFraud(standaloneCreditId, creditUpdateRequest, null);
  }

  @Override public StandaloneCredit patchStandaloneCreditStatusForInteracFraud(final String standaloneCreditId,
      final StandaloneCreditUpdateRequest creditUpdateRequest, RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(ENDPOINT_PATH_FORMAT, STANDALONE_CREDIT_ENDPOINT, standaloneCreditId);
    PaysafeApiResponse response = paysafeApiClient.executePatch(path, creditUpdateRequest, requestOptions);
    return processResponse(response, StandaloneCredit.class);
  }
}
