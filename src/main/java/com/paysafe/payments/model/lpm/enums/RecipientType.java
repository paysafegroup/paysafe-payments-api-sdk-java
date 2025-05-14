// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of payout recipient.
 * For Paypal, only supported value is PAYPAL_ID.
 */
public enum RecipientType {

  PAYPAL_ID("PAYPAL_ID");

  private final String value;

  RecipientType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static RecipientType fromValue(String value) {
    for (RecipientType b : RecipientType.values()) {
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