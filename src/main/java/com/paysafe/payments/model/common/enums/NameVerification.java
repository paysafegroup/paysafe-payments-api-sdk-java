// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the account name inquiry name result returned by the acquirer.
 */
public enum NameVerification {
  MATCH("MATCH"),

  PARTIAL_MATCH("PARTIAL_MATCH"),

  NO_MATCH("NO_MATCH"),

  NOT_PROCESSED("NOT_PROCESSED"),

  UNKNOWN("UNKNOWN");


  private final String value;

  NameVerification(String value) {
    this.value = value;
  }

  @JsonCreator
  public static NameVerification fromValue(String value) {
    for (NameVerification b : NameVerification.values()) {
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