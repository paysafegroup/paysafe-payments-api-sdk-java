// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the possible statuses of an Enrollment Lookup request.
 * <p>Values:</p>
 * <ul>
 *   <li><strong>COMPLETED:</strong> The transaction has been completed successfully. The authentication was successful.</li>
 *   <li><strong>FAILED:</strong> The authentication request failed. Further investigation is required, and the error code
 *   should be checked for more details.</li>
 * </ul>
 */
public enum AuthenticationStatus {
  COMPLETED("COMPLETED "),

  FAILED("FAILED");

  private final String value;

  AuthenticationStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AuthenticationStatus fromValue(String value) {
    for (AuthenticationStatus b : AuthenticationStatus.values()) {
      if (b.value.equalsIgnoreCase(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
