// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the address.
 */
public enum AddressStatus {
  ACTIVE("ACTIVE"),

  INITIAL("INITIAL");

  private final String value;

  AddressStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AddressStatus fromValue(String value) {
    for (AddressStatus b : AddressStatus.values()) {
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