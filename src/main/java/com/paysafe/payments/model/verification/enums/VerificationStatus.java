// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.verification.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the verification request. Possible values are:
 * <ul>
 *  <li> RECEIVED - A verification request was received from merchant, but it has not yet been sent to downstream gateway.</li>
 *  <li> ERROR - The verification has errored - failed for non-business reason (non http status 402 error).</li>
 *  <li> FAILED - The verification has failed and the downstream gateway has returned an error (http status 402) for some business reason.</li>
 *  <li> COMPLETED - The verification was completed successfully.</li>
 * </ul>
 */
public enum VerificationStatus {
  COMPLETED("COMPLETED"),

  FAILED("FAILED"),

  RECEIVED("RECEIVED"),

  ERROR("ERROR");

  private final String value;

  VerificationStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VerificationStatus fromValue(String value) {
    for (VerificationStatus b : VerificationStatus.values()) {
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
