// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the mechanism used previously by the cardholder to authenticate to the 3DS Requester.
 */
public enum AuthenticationMethod {
  FRICTIONLESS_AUTHENTICATION("FRICTIONLESS_AUTHENTICATION"),

  ACS_CHALLENGE("ACS_CHALLENGE"),

  AVS_VERIFIED("AVS_VERIFIED"),

  OTHER_ISSUER_METHOD("OTHER_ISSUER_METHOD");

  private final String value;

  AuthenticationMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AuthenticationMethod fromValue(String value) {
    for (AuthenticationMethod b : AuthenticationMethod.values()) {
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