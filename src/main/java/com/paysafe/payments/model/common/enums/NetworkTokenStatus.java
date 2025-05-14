// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of the network token.
 */
public enum NetworkTokenStatus {
  ACTIVE("ACTIVE"),

  INACTIVE("INACTIVE"),

  SUSPENDED("SUSPENDED");

  private final String value;

  NetworkTokenStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static NetworkTokenStatus fromValue(String value) {
    for (NetworkTokenStatus b : NetworkTokenStatus.values()) {
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