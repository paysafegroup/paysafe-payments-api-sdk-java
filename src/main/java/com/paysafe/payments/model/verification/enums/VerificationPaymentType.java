// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.verification.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the payment type associated with the Payment Handle used for this request.
 */
public enum VerificationPaymentType {
  CARD("CARD"),

  INTERAC_ETRANSFER("INTERAC_ETRANSFER"),

  MAZOOMA("MAZOOMA"),

  SIGHTLINE("SIGHTLINE"),

  VIPPREFERRED("VIPPREFERRED"),

  SKRILL("SKRILL"),

  NETELLER("NETELLER");

  private final String value;

  VerificationPaymentType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VerificationPaymentType fromValue(String value) {
    for (VerificationPaymentType b : VerificationPaymentType.values()) {
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