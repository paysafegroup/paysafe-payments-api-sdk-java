// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This specifies the action of the merchant server in order to complete the Payment. Possible values are:
 * <ul>
 *   <li>
 *     <b>SYNCHRONOUS :</b> The status of the Payment request will be returned synchronously to the merchant, e.g., a credit card request.
 *   </li>
 *   <li>
 *     <b>ASYNCHRONOUS :</b> The Payment request is not completed immediately and the merchant must rely on
 *     <a href="https://developer.paysafe.com/en/api-docs/paysafe-checkout/webhoooks/">webhooks</a>
 *     to retrieve the status of the Payment request.
 *   </li>
 * </ul>
 */
public enum ExecutionMode {

  SYNCHRONOUS("SYNCHRONOUS"),

  ASYNCHRONOUS("ASYNCHRONOUS");

  private final String value;

  ExecutionMode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ExecutionMode fromValue(String value) {
    for (ExecutionMode b : ExecutionMode.values()) {
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
