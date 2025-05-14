// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the Standalone Interac's Credit call response.  Possible values for the fraud status: <br />
 * - CONFIRM_FRAUD - payment is confirmed fraud  <br />
 * - CONFIRM_LEGITIMATE - payment is confirmed legitimate  <br />
 * - SCAM - payment is scam <br />
 * - PRESUME_LEGITIMATE - payment is presume legitimate <br />
 * - SUSPICIOUS - payment is suspicious
 */
public enum InteracFraudStatus {
  CONFIRM_FRAUD("CONFIRM_FRAUD"),

  CONFIRM_LEGITIMATE("CONFIRM_LEGITIMATE"),

  SCAM("SCAM"),

  PRESUME_LEGITIMATE("PRESUME_LEGITIMATE"),

  SUSPICIOUS("SUSPICIOUS");

  private final String value;

  InteracFraudStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracFraudStatus fromValue(String value) {
    for (InteracFraudStatus b : InteracFraudStatus.values()) {
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