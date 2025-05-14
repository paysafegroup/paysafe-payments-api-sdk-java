// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.validation;

/**
 * This class holds error messages for validations.
 */
public class ErrorMessages {

  public static final String MESSAGE_BLANK_API_KEY = "You must provide non-blank api key in format 'username:password'";
  public static final String MESSAGE_INVALID_API_KEY_FORMAT = "Api key does not match format 'username:password'";
  public static final String MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES = "Maximum allowed number of automatic retries is 5";
  public static final String MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE = "Maximum automatic retries cannot be negative";
  public static final String MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE = "Connect timeout must be a positive value";
  public static final String MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE = "Response timeout must be a positive value";

  private ErrorMessages() {
  }
}
