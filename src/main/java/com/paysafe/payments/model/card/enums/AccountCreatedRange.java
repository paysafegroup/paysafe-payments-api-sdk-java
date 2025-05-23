// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This indicates the length of time that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.
 */
public enum AccountCreatedRange {
  NO_ACCOUNT("NO_ACCOUNT"),

  DURING_TRANSACTION("DURING_TRANSACTION"),

  LESS_THAN_THIRTY_DAYS("LESS_THAN_THIRTY_DAYS"),

  THIRTY_TO_SIXTY_DAYS("THIRTY_TO_SIXTY_DAYS"),

  MORE_THAN_SIXTY_DAYS("MORE_THAN_SIXTY_DAYS");

  private final String value;

  AccountCreatedRange(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AccountCreatedRange fromValue(String value) {
    for (AccountCreatedRange b : AccountCreatedRange.values()) {
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