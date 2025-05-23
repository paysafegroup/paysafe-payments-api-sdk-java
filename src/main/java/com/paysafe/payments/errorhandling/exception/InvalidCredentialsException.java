// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

import com.paysafe.payments.errorhandling.error.PaysafeError;

/**
 * This type of exception is thrown in the event of 401 Unauthorized HTTP response code from Paysafe Payments API.
 */
public class InvalidCredentialsException extends PaysafeSdkException {

  public InvalidCredentialsException(String message, Integer code, String internalCorrelationId, PaysafeError error) {
    super(message, code, internalCorrelationId, error);
  }

  @Override public String toString() {
    return "InvalidCredentialsException{" +
        "code=" + getCode() +
        ", internalCorrelationId='" + getInternalCorrelationId() + '\'' +
        ", error=" + getError() +
        '}';
  }
}
