// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

import com.paysafe.payments.errorhandling.error.PaysafeError;

/**
 * This type of exception is thrown in the event of 403 Forbidden HTTP response code from Paysafe Payments API.  <br>
 * Please reverify the API key or contact Paysafe support for assistance.
 */
public class UnauthorizedException extends PaysafeSdkException {

  public UnauthorizedException(String message, Integer code, String internalCorrelationId, PaysafeError error) {
    super(message, code, internalCorrelationId, error);
  }

  @Override public String toString() {
    return "UnauthorizedException{" +
        "code=" + getCode() +
        ", internalCorrelationId='" + getInternalCorrelationId() + '\'' +
        ", error=" + getError() +
        '}';
  }
}
