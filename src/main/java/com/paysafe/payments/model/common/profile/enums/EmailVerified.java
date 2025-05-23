// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.profile.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Is the customer’s email ID verified by merchant or not?  <br>
 * If not sent, default value will be set to NOT_VERIFIED.
 * Be aware that unverified email may lead to request failures, as this is the part of our risk check parameters.  <br>
 */
public enum EmailVerified {
  NOT_VERIFIED("NOT_VERIFIED"),

  VERIFIED("VERIFIED");

  private final String value;

  EmailVerified(String value) {
    this.value = value;
  }

  @JsonCreator
  public static EmailVerified fromValue(String value) {
    for (EmailVerified b : EmailVerified.values()) {
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