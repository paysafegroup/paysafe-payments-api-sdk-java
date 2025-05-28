// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the 3D Secure signature verification status.
 *
 * <p>The {@code SignatureStatus} enum defines the result of the 3D Secure signature verification process
 * for a given transaction.</p>
 *
 * <p>Enum Values:</p>
 * <ul>
 *   <li><strong>Y:</strong> All transaction and signature checks were satisfied, meaning the signature verification passed successfully.</li>
 *   <li><strong>N:</strong> At least one transaction or signature check failed, meaning the signature verification did not pass.</li>
 * </ul>
 */
public enum SignatureString {
  Y("Y"),

  N("N");

  private final String value;

  SignatureString(String value) {
    this.value = value;
  }

  @JsonCreator
  public static SignatureString fromValue(String value) {
    for (SignatureString b : SignatureString.values()) {
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