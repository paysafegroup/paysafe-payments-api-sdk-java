// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Payment can be restricted for a certain minimum kyc level (implicitly restricts payment to registered consumers only). Possible values are:
 * <ul>
 * <li>FULL </li>
 * <li>SIMPLE. </li>
 * </ul>
 */
public enum KeyLevelRestriction {
  FULL("FULL"),

  SIMPLE("SIMPLE");

  private final String value;

  KeyLevelRestriction(String value) {
    this.value = value;
  }

  @JsonCreator
  public static KeyLevelRestriction fromValue(String value) {
    for (KeyLevelRestriction b : KeyLevelRestriction.values()) {
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
