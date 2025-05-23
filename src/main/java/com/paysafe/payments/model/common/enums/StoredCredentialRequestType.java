// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This specifies the type of request being made.  Possible values are:
 * <ul>
 * <li> ADHOC – Ad hoc consumer-initiated request  </li>
 * <li> TOPUP – Unscheduled merchant-iniitated request when a consumer balance is below a set limit.  </li>
 * <li> RECURRING – Scheduled, merchant-initiated recurring request.  </li>
 * </ul>
 * 
 * <b>Note:</b> This value defaults to ADHOC.
 */
public enum StoredCredentialRequestType {
  ADHOC("ADHOC"),

  TOPUP("TOPUP"),

  RECURRING("RECURRING");

  private final String value;

  StoredCredentialRequestType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static StoredCredentialRequestType fromValue(String value) {
    for (StoredCredentialRequestType b : StoredCredentialRequestType.values()) {
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
