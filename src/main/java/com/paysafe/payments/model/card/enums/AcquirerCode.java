// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the code for your card acquirer
 */
public enum AcquirerCode {

  VAN("VAN");

  private final String value;

  AcquirerCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AcquirerCode fromValue(String value) {
    for (AcquirerCode b : AcquirerCode.values()) {
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
