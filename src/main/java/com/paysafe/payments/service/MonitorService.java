// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.monitor.MonitorResponse;

public interface MonitorService {

  /**
   * Returns current status of Paysafe Payments API. Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>GET /v1/monitor</strong></p>
   *
   * @return MonitorResponse containing single field, status, with single possible value READY.
   * @throws PaysafeSdkException if an error occurs
   */
  MonitorResponse verifyThatServiceIsAccessible() throws PaysafeSdkException;

  /**
   * Returns current status of Paysafe Payments API. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/monitor</strong></p>
   *
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return MonitorResponse containing single field, status, with single possible value READY.
   * @throws PaysafeSdkException if an error occurs
   */
  MonitorResponse verifyThatServiceIsAccessible(final RequestOptions requestOptions) throws PaysafeSdkException;
}
