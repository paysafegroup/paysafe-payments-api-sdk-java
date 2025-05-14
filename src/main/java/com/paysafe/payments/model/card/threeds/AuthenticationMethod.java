// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the mechanism used by the cardholder to authenticate to the 3DS Requester.
 */
public enum AuthenticationMethod {
  NO_LOGIN("NO_LOGIN"),

  INTERNAL_CREDENTIALS("INTERNAL_CREDENTIALS"),

  FEDERATED_ID("FEDERATED_ID"),

  ISSUER_CREDENTIALS("ISSUER_CREDENTIALS"),

  THIRD_PARY_AUTHENTICATION("THIRD_PARY_AUTHENTICATION"),

  FIDO_AUTHENTICATOR("FIDO_AUTHENTICATOR");

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