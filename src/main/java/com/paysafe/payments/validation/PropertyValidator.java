package com.paysafe.payments.validation;

import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_BLANK_API_KEY;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_INVALID_API_KEY_FORMAT;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;

import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;

public class PropertyValidator {

  public static void validateApiKey(String apiKey) throws IllegalArgumentException {
    if (apiKey == null || apiKey.isBlank()) {
      throw new IllegalArgumentException(MESSAGE_BLANK_API_KEY);
    }
    if (!apiKey.matches("^[^:\\s]+:[^:\\s]+$")) {
      throw new IllegalArgumentException(MESSAGE_INVALID_API_KEY_FORMAT);
    }
  }

  public static void validateMaxAutomaticRetries(Integer maxAutomaticRetries) throws IllegalArgumentException {
    if (maxAutomaticRetries != null && maxAutomaticRetries > 5) {
      throw new IllegalArgumentException(MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES);
    }
    if (maxAutomaticRetries != null && maxAutomaticRetries < 0) {
      throw new IllegalArgumentException(MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE);
    }
  }

  public static void validateConnectTimeout(Integer connectTimeout) throws IllegalArgumentException {
    if (connectTimeout != null && connectTimeout <= 0) {
      throw new IllegalArgumentException(MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE);
    }
  }

  public static void validateResponseTimeout(Integer responseTimeout) throws IllegalArgumentException {
    if (responseTimeout != null && responseTimeout <= 0) {
      throw new IllegalArgumentException(MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE);
    }
  }
}
