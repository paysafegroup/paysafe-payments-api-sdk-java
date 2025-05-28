// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the shipping method for the transaction.
 */
public enum ShippingIndicator {
  SHIP_TO_BILLING_ADDRESS("SHIP_TO_BILLING_ADDRESS"),

  SHIP_TO_VERIFIED_ADDRESS("SHIP_TO_VERIFIED_ADDRESS"),

  SHIP_TO_DIFFERENT_ADDRESS("SHIP_TO_DIFFERENT_ADDRESS"),

  SHIP_TO_STORE("SHIP_TO_STORE"),

  DIGITAL_GOODS("DIGITAL_GOODS"),

  TRAVEL_AND_EVENT_TICKETS("TRAVEL_AND_EVENT_TICKETS"),

  OTHER("OTHER");

  private final String value;

  ShippingIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ShippingIndicator fromValue(String value) {
    for (ShippingIndicator b : ShippingIndicator.values()) {
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
