// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status reason of the mandate request response.
 */
public enum MandateRequestResponseStatusReason {
  MERCHANT_CANCELLED("MERCHANT_CANCELLED"),

  BANK_CANCELLED("BANK_CANCELLED"),

  DECLINED("DECLINED"),

  REJECTED("REJECTED"),

  DISPUTED("DISPUTED"),

  UNAUTHORIZED("UNAUTHORIZED"),

  TRANSFERRED("TRANSFERRED");

  private final String value;

  MandateRequestResponseStatusReason(String value) {
    this.value = value;
  }

  @JsonCreator
  public static MandateRequestResponseStatusReason fromValue(String value) {
    for (MandateRequestResponseStatusReason b : MandateRequestResponseStatusReason.values()) {
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