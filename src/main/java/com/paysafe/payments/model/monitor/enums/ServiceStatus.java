// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.monitor.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of Payments API service.
 */
public enum ServiceStatus {
  READY("READY");

  private final String value;

  ServiceStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ServiceStatus fromValue(String value) {
    for (ServiceStatus b : ServiceStatus.values()) {
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
