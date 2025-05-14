// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

import com.paysafe.payments.errorhandling.error.PaysafeError;

/**
 * This is the parent class that represents various exceptions that may happen while using the Paysafe SDK.
 */
public class PaysafeSdkException extends Exception {

  /**
   * Http status code returned by Payments API.
   */
  private final Integer code;

  /**
   * Unique ID that can be provided to the Paysafe Support team as a reference for investigation.
   */
  private final String internalCorrelationId;

  /**
   * Represents details of the error in cases other than 402 HTTP status code.
   */
  private final PaysafeError error;

  public PaysafeSdkException(String message) {
    super(message);
    this.code = null;
    this.internalCorrelationId = null;
    this.error = null;
  }

  public PaysafeSdkException(String message, Integer code, String internalCorrelationId) {
    super(message);
    this.code = code;
    this.internalCorrelationId = internalCorrelationId;
    this.error = null;
  }

  public PaysafeSdkException(String message, Integer code, String internalCorrelationId, PaysafeError error) {
    super(message);
    this.code = code;
    this.internalCorrelationId = internalCorrelationId;
    this.error = error;
  }

  public PaysafeError getError() {
    return error;
  }

  public Integer getCode() {
    return code;
  }

  public String getInternalCorrelationId() {
    return internalCorrelationId;
  }

  @Override public String toString() {
    return "PaysafeSdkException{" +
        "code=" + code +
        ", internalCorrelationId='" + internalCorrelationId + '\'' +
        ", error=" + error +
        '}';
  }
}
