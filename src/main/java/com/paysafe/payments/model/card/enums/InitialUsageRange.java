// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets initialUsageRange
 */
public enum InitialUsageRange {
  CURRENT_TRANSACTION("CURRENT_TRANSACTION"),

  LESS_THAN_THIRTY_DAYS("LESS_THAN_THIRTY_DAYS"),

  THIRTY_TO_SIXTY_DAYS("THIRTY_TO_SIXTY_DAYS"),

  MORE_THAN_SIXTY_DAYS("MORE_THAN_SIXTY_DAYS");

  private final String value;

  InitialUsageRange(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InitialUsageRange fromValue(String value) {
    for (InitialUsageRange b : InitialUsageRange.values()) {
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