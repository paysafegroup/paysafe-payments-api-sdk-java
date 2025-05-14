// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

import com.paysafe.payments.errorhandling.error.PaysafeError;

/**
 * This type of exception is thrown in the event of 500 Internal Server Error HTTP response code
 * or 502 External Server Error from Paysafe Payments API.
 */
public class ApiException extends PaysafeSdkException {

  public ApiException(String message, Integer code, String internalCorrelationId, PaysafeError error) {
    super(message, code, internalCorrelationId, error);
  }

  @Override public String toString() {
    return "ApiException{" +
        "code=" + getCode() +
        ", internalCorrelationId='" + getInternalCorrelationId() + '\'' +
        ", error=" + getError() +
        '}';
  }
}
