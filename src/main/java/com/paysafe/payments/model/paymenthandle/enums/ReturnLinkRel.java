// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the link type that allows different endpoints to be targeted depending on the end state of the transaction.
 * <ul>
 *   <li>
 *     <b>redirect_registration:</b> Merchant needs to redirect consumer to this url to complete registration.
 *   </li>
 *   <li>
 *     <b>redirect_payment:</b> Merchant needs to redirect consumer to this url to complete authentication.
 *   </li>
 *   <li>
 *     <b>on_completed:</b> Paysafe will return to this merchant url post successful payment.
 *   </li>
 *   <li>
 *     <b>on_failed:</b> Paysafe will return to this merchant url post if payment failed.
 *   </li>
 *   <li>
 *     <b>on_cancelled:</b> Paysafe will return to this merchant url post if payment is cancelled.
 *   </li>
 *   <li>
 *     <b>default:</b> The default return URL that will be used if specific status return URL is not defined.
 *   </li>
 * </ul>
 */
public enum ReturnLinkRel {
  REDIRECT_PAYMENT("redirect_payment"),

  REDIRECT_REGISTRATION("redirect_registration"),

  ON_COMPLETED("on_completed"),

  DEFAULT("default"),

  ON_FAILED("on_failed"),

  ON_CANCELLED("on_cancelled");

  private final String value;

  ReturnLinkRel(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ReturnLinkRel fromValue(String value) {
    for (ReturnLinkRel b : ReturnLinkRel.values()) {
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