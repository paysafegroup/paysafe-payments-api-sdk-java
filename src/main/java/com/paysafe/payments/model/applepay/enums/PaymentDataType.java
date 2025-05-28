// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the account status.
 */
public enum PaymentDataType {
  EMV("EMV"),

  THREED_SECURE("3DSecure");

  private final String value;

  PaymentDataType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentDataType fromValue(String value) {
    for (PaymentDataType b : PaymentDataType.values()) {
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