// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

import com.paysafe.payments.errorhandling.error.PaysafeError;
import com.paysafe.payments.model.BaseApiResponse;

/**
 * This type of exception is thrown in the event of 402 Payment Required HTTP response code from Paysafe Payments API.
 */
public class RequestDeclinedException extends PaysafeSdkException {

  /**
   * Represents details of the error, together with (partial) API response, in case of 402 HTTP status code.
   */
  private final transient BaseApiResponse apiResponse;

  public RequestDeclinedException(String message, Integer code, String internalCorrelationId, PaysafeError error, BaseApiResponse apiResponse) {
    super(message, code, internalCorrelationId, error);
    this.apiResponse = apiResponse;
  }

  public BaseApiResponse getApiResponse() {
    return apiResponse;
  }

  @Override public String toString() {
    return "RequestDeclinedException{" +
        "code=" + getCode() +
        ", internalCorrelationId='" + getInternalCorrelationId() + '\'' +
        ", error=" + getError() +
        ", apiResponse=" + getApiResponse() +
        '}';
  }
}
