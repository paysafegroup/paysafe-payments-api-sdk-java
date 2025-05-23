// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This specifies how the Payment Handle will be used for Payments. Possible values are:
 * <ul>
 * <li>SINGLE_USE – The Payment Handle can be used for one transaction only and expires if not used.</li>
 * <li>MULTI_USE – The Payment Handle can be used multiple times.</li>
 * </ul>
 */
public enum PaymentHandleUsage {
  SINGLE_USE("SINGLE_USE"),

  MULTI_USE("MULTI_USE");

  private final String value;

  PaymentHandleUsage(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentHandleUsage fromValue(String value) {
    for (PaymentHandleUsage b : PaymentHandleUsage.values()) {
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
