// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This indicates whether the cardholder is enrolled in 3D Secure. Possible values are: <br />
 * • Y – Cardholder authentication available.  <br />
 * • N – Cardholder not enrolled in authentication.  <br />
 * • U – Cardholder authentication unavailable
 */
public enum ThreeDEnrollment {
  Y("Y"),

  N("N"),

  U("U");

  private final String value;

  ThreeDEnrollment(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDEnrollment fromValue(String value) {
    for (ThreeDEnrollment b : ThreeDEnrollment.values()) {
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