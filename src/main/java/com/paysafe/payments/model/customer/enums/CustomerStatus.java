// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the customer. Possible values are:
 * <ul>
 * <li> INITIAL  </li>
 * <li> ACTIVE  </li>
 * </ul>
 * By default the system automatically sets the customer status to an ACTIVE state.
 * If you want to prevent the customer from being used for payments, you can set the status to an INITIAL state
 * (e.g., in cases where you first want to validate the customer).
 */
public enum CustomerStatus {
  INITIAL("INITIAL"),

  ACTIVE("ACTIVE");

  private final String value;

  CustomerStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CustomerStatus fromValue(String value) {
    for (CustomerStatus b : CustomerStatus.values()) {
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