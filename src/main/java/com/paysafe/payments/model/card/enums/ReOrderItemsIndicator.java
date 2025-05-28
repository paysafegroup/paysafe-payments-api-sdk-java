// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This indicates whether the cardholder is reordering merchandise.
 */
public enum ReOrderItemsIndicator {
  FIRST_TIME_ORDER("FIRST_TIME_ORDER"),

  REORDER("REORDER");

  private final String value;

  ReOrderItemsIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ReOrderItemsIndicator fromValue(String value) {
    for (ReOrderItemsIndicator b : ReOrderItemsIndicator.values()) {
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