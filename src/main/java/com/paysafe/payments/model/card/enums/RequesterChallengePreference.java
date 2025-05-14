// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This indicates whether a challenge is requested for this transaction.
 */
public enum RequesterChallengePreference {
  NO_PREFERENCE("NO_PREFERENCE"),

  NO_CHALLENGE_REQUESTED("NO_CHALLENGE_REQUESTED"),

  CHALLENGE_REQUESTED("CHALLENGE_REQUESTED"),

  CHALLENGE_MANDATED("CHALLENGE_MANDATED");

  private final String value;

  RequesterChallengePreference(String value) {
    this.value = value;
  }

  @JsonCreator
  public static RequesterChallengePreference fromValue(String value) {
    for (RequesterChallengePreference b : RequesterChallengePreference.values()) {
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