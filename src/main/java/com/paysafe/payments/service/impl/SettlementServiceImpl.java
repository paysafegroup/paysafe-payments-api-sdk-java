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
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.settlement.SettlementList;
import com.paysafe.payments.model.settlement.SettlementRequest;
import com.paysafe.payments.service.SettlementService;

public class SettlementServiceImpl implements SettlementService {

  private static final String PAYMENT_SETTLEMENT_ENDPOINT = "/v1/payments/%s/settlements";
  private static final String SETTLEMENT_ENDPOINT = "/v1/settlements";

  private final PaysafeApiClient paysafeApiClient;

  public SettlementServiceImpl(PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Settlement processSettlement(final String paymentId, SettlementRequest settlementRequest)
      throws PaysafeSdkException {
    return processSettlement(paymentId, settlementRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Settlement processSettlement(final String paymentId, SettlementRequest settlementRequest, final RequestOptions requestOptions)
      throws PaysafeSdkException {
    final String path = String.format(PAYMENT_SETTLEMENT_ENDPOINT, paymentId);
    PaysafeApiResponse response = paysafeApiClient.executePost(path, settlementRequest, requestOptions);
    return processResponse(response, Settlement.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Settlement getSettlementById(final String settlementId) throws PaysafeSdkException {
    return getSettlementById(settlementId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Settlement getSettlementById(final String settlementId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String endpoint = String.format("%s/%s", SETTLEMENT_ENDPOINT, settlementId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(endpoint, requestOptions);
    return processResponse(response, Settlement.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettlementList getSettlementsUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate)
      throws PaysafeSdkException {
    return getSettlementsUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettlementList getSettlementsUsingMerchantReferenceNumber(
      final String merchantRefNum, final String endDate, final Integer limit, final Integer offset, final String startDate, final RequestOptions requestOptions)
      throws PaysafeSdkException {
    final String path = String.format("%s%s", SETTLEMENT_ENDPOINT, buildQueryParameters(merchantRefNum, endDate,
        limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, SettlementList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelSettlement(final String settlementId, CancelRequest cancelRequest) throws PaysafeSdkException {
    return cancelSettlement(settlementId, cancelRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelSettlement(final String settlementId, CancelRequest cancelRequest, final RequestOptions requestOptions)
      throws PaysafeSdkException {
    final String path = String.format("%s/%s", SETTLEMENT_ENDPOINT, settlementId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, cancelRequest, requestOptions);
    return processResponse(response, CancelResponse.class);
  }
}