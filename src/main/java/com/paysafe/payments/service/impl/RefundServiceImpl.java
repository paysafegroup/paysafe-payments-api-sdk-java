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
import com.paysafe.payments.model.refund.Refund;
import com.paysafe.payments.model.refund.RefundList;
import com.paysafe.payments.model.refund.RefundRequest;
import com.paysafe.payments.service.RefundService;

public class RefundServiceImpl implements RefundService {

  private static final String PROCESS_REFUND_ENDPOINT = "/v1/settlements/%s/refunds";
  private static final String REFUND_ENDPOINT = "/v1/refunds";

  private final PaysafeApiClient paysafeApiClient;

  public RefundServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Refund processRefund(final String settlementId, final RefundRequest refundRequest) throws PaysafeSdkException {
    return processRefund(settlementId, refundRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Refund processRefund(final String settlementId, final RefundRequest refundRequest, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format(PROCESS_REFUND_ENDPOINT, settlementId);
    PaysafeApiResponse response = paysafeApiClient.executePost(path, refundRequest, requestOptions);
    return processResponse(response, Refund.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Refund getRefundById(final String refundId) throws PaysafeSdkException {
    return getRefundById(refundId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Refund getRefundById(final String refundId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String endpoint = String.format("%s/%s", REFUND_ENDPOINT, refundId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(endpoint, requestOptions);
    return processResponse(response, Refund.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RefundList getRefundUsingMerchantReferenceNumber(String merchantRefNum,
      String endDate, Integer limit, Integer offset, String startDate)
      throws PaysafeSdkException {
    return getRefundUsingMerchantReferenceNumber(merchantRefNum, endDate, limit, offset, startDate, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RefundList getRefundUsingMerchantReferenceNumber(String merchantRefNum,
      String endDate, Integer limit, Integer offset, String startDate, RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format("%s%s", REFUND_ENDPOINT,
        buildQueryParameters(merchantRefNum, endDate, limit, offset, startDate, null, null));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, RefundList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelRefund(String refundId, CancelRequest cancelRequest,
      RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format("%s/%s", REFUND_ENDPOINT, refundId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, cancelRequest, requestOptions);

    return processResponse(response, CancelResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CancelResponse cancelRefund(String refundId, CancelRequest cancelRequest) throws PaysafeSdkException {
    return cancelRefund(refundId, cancelRequest, null);
  }
}
