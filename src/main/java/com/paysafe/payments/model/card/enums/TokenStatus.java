// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the token.
 */
public enum TokenStatus {
  ACTIVE("ACTIVE"),

  EXPIRED("EXPIRED"),

  DISABLED("DISABLED");

  private final String value;

  TokenStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TokenStatus fromValue(String value) {
    for (TokenStatus b : TokenStatus.values()) {
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
