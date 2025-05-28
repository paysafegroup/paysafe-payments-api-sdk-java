// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.exception;

/**
 * This type of exception is thrown in the event that arguments for creating PaysafeClient are not valid.
 */
public class IllegalArgumentException extends PaysafeSdkException {

  public IllegalArgumentException(String message) {
    super(message);
  }

  @Override public String toString() {
    return "IllegalArgumentException{" +
        "message=" + getMessage() +
        '}';
  }
}
