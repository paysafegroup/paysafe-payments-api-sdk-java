// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_BLANK_API_KEY;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_INVALID_API_KEY_FORMAT;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;

public class PaysafeClientValidationTest {

  @Test
  void buildPaysafeClient_blankApiKey() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey("    ")
                .build()
    );

    assertEquals(MESSAGE_BLANK_API_KEY, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }

  @Test
  void buildPaysafeClient_invalidApiKeyFormat() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey("badFormat")
                .build()
    );

    assertEquals(MESSAGE_INVALID_API_KEY_FORMAT, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }

  @Test
  void buildPaysafeClient_invalidApiKey_onlyPassword() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey(":password")
                .build()
    );

    assertEquals(MESSAGE_INVALID_API_KEY_FORMAT, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }

  @Test
  void buildPaysafeClient_tooLargeMaxAutomaticRetries() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey("username:password")
                .maxAutomaticRetries(100)
                .build()
    );

    assertEquals(MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }

  @Test
  void buildPaysafeClient_negativeautomaticRetries() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey("username:password")
                .maxAutomaticRetries(-1)
                .build()
    );

    assertEquals(MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }

  @Test
  void buildPaysafeClient_negativeConnectTimeout() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey("username:password")
                .connectTimeout(-1)
                .build()
    );

    assertEquals(MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }

  @Test
  void buildPaysafeClient_negativeResponseTimeout() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () ->
            PaysafeClient.builder()
                .apiKey("username:password")
                .responseTimeout(-1)
                .build()
    );

    assertEquals(MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE, exception.getMessage());
    assertNull(exception.getError());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getCode());
  }
}
