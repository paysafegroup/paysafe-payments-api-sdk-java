// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This indicates the customer's locale.
 */
public enum Locale {
  EN_US("en_US"),

  FR_CA("fr_CA"),

  EN_CA("en_CA"),

  EN_GB("en_GB");

  private final String value;

  Locale(String value) {
    this.value = value;
  }

  @JsonCreator
  public static Locale fromValue(String value) {
    for (Locale b : Locale.values()) {
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