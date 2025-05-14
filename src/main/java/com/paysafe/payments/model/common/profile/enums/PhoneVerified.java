// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.profile.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Is the customer’s phone number verified by merchant or not?
 */
public enum PhoneVerified {
  NOT_VERIFIED("NOT_VERIFIED"),

  VERIFIED("VERIFIED");

  private final String value;

  PhoneVerified(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PhoneVerified fromValue(String value) {
    for (PhoneVerified b : PhoneVerified.values()) {
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