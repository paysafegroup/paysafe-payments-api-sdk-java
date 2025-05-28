// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.buildQueryParameters;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.voidauthorization.VoidAuthorization;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationRequest;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationsList;
import com.paysafe.payments.service.VoidAuthorizationService;

public class VoidAuthorizationServiceImpl implements VoidAuthorizationService {

  private static final String VOID_AUTHORIZATION_ENDPOINT = "/v1/payments/%s/voidauths";
  private static final String VOID_AUTHORIZATION_GET_ENDPOINT = "/v1/voidauths";

  private final PaysafeApiClient paysafeApiClient;

  public VoidAuthorizationServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VoidAuthorization voidAuthorization(final String paymentId, final VoidAuthorizationRequest voidAuthorizationRequest)
      throws PaysafeSdkException {
    return voidAuthorization(paymentId, voidAuthorizationRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VoidAuthorization voidAuthorization(final String paymentId, final VoidAuthorizationRequest voidAuthorizationRequest,
      final RequestOptions requestOptions)
      throws PaysafeSdkException {
    final String path = String.format(VOID_AUTHORIZATION_ENDPOINT, paymentId);
    PaysafeApiResponse response = paysafeApiClient.executePost(path, voidAuthorizationRequest, requestOptions);
    return processResponse(response, VoidAuthorization.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VoidAuthorization getVoidAuthorizationById(final String voidAuthId) throws PaysafeSdkException {
    return getVoidAuthorizationById(voidAuthId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VoidAuthorization getVoidAuthorizationById(final String voidAuthId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s/%s", VOID_AUTHORIZATION_GET_ENDPOINT, voidAuthId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, VoidAuthorization.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VoidAuthorizationsList getVoidAuthorizationUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate) throws PaysafeSdkException {
    return getVoidAuthorizationUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VoidAuthorizationsList getVoidAuthorizationUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate, final RequestOptions requestOptions)
      throws PaysafeSdkException {
    final String path = String.format("%s%s", VOID_AUTHORIZATION_GET_ENDPOINT,
        buildQueryParameters(merchantRefNum, endDate, limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, VoidAuthorizationsList.class);
  }
}