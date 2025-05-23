// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.lodging.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the various types of extra charges that may apply to a lodging reservation.
 */
public enum ExtraChargesType {
  RESTAURANT("RESTAURANT"),

  GIFT_SHOP("GIFT_SHOP"),

  MINI_BAR("MINI_BAR"),

  TELEPHONE("TELEPHONE"),

  OTHER("OTHER"),

  LAUNDRY("LAUNDRY");

  private final String value;

  ExtraChargesType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ExtraChargesType fromValue(String value) {
    for (ExtraChargesType b : ExtraChargesType.values()) {
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
