// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

/**
 * This type of exception is thrown in the event that Paysafe SDK cannot connect to the Paysafe Payments API endpoint.
 */
public class ApiConnectionException extends PaysafeSdkException {

  public ApiConnectionException(String message) {
    super(message);
  }

  @Override public String toString() {
    return "ApiConnectionException{" +
        "message=" + getMessage() +
        '}';
  }
}
