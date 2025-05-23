// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.settlement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the payment type associated with the settlement used for this request.
 */
public enum SettlementPaymentType {
  CARD("CARD"),

  PAYSAFECASH("PAYSAFECASH"),

  PAYSAFECARD("PAYSAFECARD"),

  PAYPAL("PAYPAL"),

  INTERAC("INTERAC");

  private final String value;

  SettlementPaymentType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static SettlementPaymentType fromValue(String value) {
    for (SettlementPaymentType b : SettlementPaymentType.values()) {
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