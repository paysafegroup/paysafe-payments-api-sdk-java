// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the bank account type.
 */
public enum BankAccountType {
  SAVINGS("SAVINGS"),

  CHECKING("CHECKING"),

  LOAN("LOAN");

  private final String value;

  BankAccountType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static BankAccountType fromValue(String value) {
    for (BankAccountType b : BankAccountType.values()) {
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