// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum that indicates the length of time between the most recent password change and the API call of the current transaction.
 */
public enum AccountChangedRange {

  DURING_TRANSACTION("DURING_TRANSACTION"),

  LESS_THAN_THIRTY_DAYS("LESS_THAN_THIRTY_DAYS"),

  THIRTY_TO_SIXTY_DAYS("THIRTY_TO_SIXTY_DAYS"),

  MORE_THAN_SIXTY_DAYS("MORE_THAN_SIXTY_DAYS");

  private final String value;

  AccountChangedRange(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AccountChangedRange fromValue(String value) {
    for (AccountChangedRange b : AccountChangedRange.values()) {
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
