// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets countryCode
 */
public enum CountryCode {
  BRL("BRL"),

  CLP("CLP"),

  COP("COP"),

  CRC("CRC"),

  PEN("PEN"),

  USD("USD");

  private final String value;

  CountryCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CountryCode fromValue(String value) {
    for (CountryCode b : CountryCode.values()) {
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