// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This specifies the next step of the user journey once they proceed to the Payment. Possible values are:
 * <ul>
 *   <li>
 *     <b>NONE:</b> No action is required, for example, for a standard credit card payment.
 *   </li>
 *   <li>
 *     <b>REDIRECT:</b> The user must be redirected in order to complete a Payment, for example,
 *     when an alternate payment method like Paysafecard is used.
 *   </li>
 *   <li>
 *     <b>LOOKUP:</b> Lookup.
 *   </li>
 * </ul>
 */
public enum Action {
  NONE("NONE"),

  REDIRECT("REDIRECT"),

  LOOKUP("LOOKUP");

  private final String value;

  Action(String value) {
    this.value = value;
  }

  @JsonCreator
  public static Action fromValue(String value) {
    for (Action b : Action.values()) {
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
