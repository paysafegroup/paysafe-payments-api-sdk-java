// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This specifies whether this stored credential request is initial or recurring. Possible values are:
 * <ul>
 * <li>INITIAL – Used when this is the first time the consumer uses this credit card. </li>
 * <li>SUBSEQUENT – Used when the consumer uses this credit card for subsquent requests. </li>
 * </ul>
 * <b>Note:</b> This value defaults to INITIAL.
 */
public enum StoredCredentialRequestOccurrence {
  INITIAL("INITIAL"),

  SUBSEQUENT("SUBSEQUENT");

  private final String value;

  StoredCredentialRequestOccurrence(String value) {
    this.value = value;
  }

  @JsonCreator
  public static StoredCredentialRequestOccurrence fromValue(String value) {
    for (StoredCredentialRequestOccurrence b : StoredCredentialRequestOccurrence.values()) {
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

