// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This indicates the outcome of the Authentication.
 * <ul>
 * <li> Y – The cardholder successfully authenticated with their card issuer.  </li>
 * <li> A – The cardholder authentication was attempted.  </li>
 * <li> N – The cardholder failed to successfully authenticate with their card issuer.  </li>
 * <li> U – Authentication with the card issuer was unavailable.  </li>
 * <li> E – An error occurred during authentication. </li>
 * </ul>
 */
public enum ThreeDResult {
  Y("Y"),

  A("A"),

  N("N"),

  U("U"),

  E("E");

  private final String value;

  ThreeDResult(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDResult fromValue(String value) {
    for (ThreeDResult b : ThreeDResult.values()) {
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