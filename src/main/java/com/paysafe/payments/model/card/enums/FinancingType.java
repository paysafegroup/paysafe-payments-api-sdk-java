// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the type of financing offered for a transaction.
 * <p>Allowed values:</p>
 * <ul>
 *     <li><b>DEFERRED_PAYMENT</b>: Financing type where payment is deferred for a certain period.</li>
 *     <li><b>EQUAL_PAYMENT</b>: Financing type where the total amount is divided into equal monthly payments.</li>
 * </ul>
 */
public enum FinancingType {
  DEFERRED_PAYMENT("DEFERRED_PAYMENT"),

  EQUAL_PAYMENT("EQUAL_PAYMENT");

  private final String value;

  FinancingType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static FinancingType fromValue(String value) {
    for (FinancingType b : FinancingType.values()) {
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