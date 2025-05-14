// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This parameter is used to to identify if user is registered for Interac E-Transfer.
 */
public enum InteracTransferType {
  REGULAR("ALIAS_REGULAR"),

  AUTODEPOSIT("ALIAS_AUTODEPOSIT");

  private final String value;

  InteracTransferType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracTransferType fromValue(String value) {
    for (InteracTransferType b : InteracTransferType.values()) {
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
