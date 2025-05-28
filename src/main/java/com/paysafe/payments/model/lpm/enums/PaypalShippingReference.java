// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The shipping preference. The possible values are:
 * <ul>
 * <li> NO_SHIPPING - Redacts the shipping address from the PayPal pages. Recommended for digital goods. </li>
 * <li> GET_FROM_FILE - Uses the customer-selected shipping address on PayPal pages. </li>
 * <li> SET_PROVIDED_ADDRESS. If available, uses the merchant-provided shipping address, which the customer cannot change on the PayPal pages. </li>
 * </ul>
 * If the merchant does not provide an address, the customer can enter the address on PayPal pages.
 */
public enum PaypalShippingReference {
  GET_FROM_FILE("GET_FROM_FILE"),

  NO_SHIPPING("NO_SHIPPING"),

  SET_PROVIDED_ADDRESS("SET_PROVIDED_ADDRESS");

  private final String value;

  PaypalShippingReference(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaypalShippingReference fromValue(String value) {
    for (PaypalShippingReference b : PaypalShippingReference.values()) {
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
