// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.service.MonitorService;

public class MonitorServiceImpl implements MonitorService {

  public static final String MONITOR_ENDPOINT = "/v1/monitor";

  private final PaysafeApiClient paysafeApiClient;

  /**
   * Instantiates new MonitorService object.
   *
   * @param paysafeApiClient instance of paysafeApiClient which executes REST calls
   */
  public MonitorServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MonitorResponse verifyThatServiceIsAccessible() throws PaysafeSdkException {
    return verifyThatServiceIsAccessible(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MonitorResponse verifyThatServiceIsAccessible(final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executeGet(MONITOR_ENDPOINT, requestOptions);
    return processResponse(response, MonitorResponse.class);
  }
}


