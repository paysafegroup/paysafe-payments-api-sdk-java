// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the account status.
 */
public enum AccountStatus {
  ACTIVE("ACTIVE"),

  SUSPENDED("SUSPENDED");

  private final String value;

  AccountStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AccountStatus fromValue(String value) {
    for (AccountStatus b : AccountStatus.values()) {
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