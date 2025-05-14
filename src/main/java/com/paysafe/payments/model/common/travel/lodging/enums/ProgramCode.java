// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.lodging.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The code that corresponds to the category of lodging charges.
 * This field determines the nature of the charge being submitted.
 *
 * <p>Allowed values:</p>
 * <ul>
 *   <li><strong>LODGING:</strong> Default value. Submitted charges are for lodging.</li>
 *   <li><strong>NO_SHOW:</strong> Charges for the failure of the guest to check in for a reserved room.</li>
 *   <li><strong>ADVANCED_DEPOSIT:</strong> Charges for an advanced deposit made to reserve one or more rooms.
 *       The settlement date will be sent to the schemes for both the check-in and check-out dates in this case.</li>
 * </ul>
 */
public enum ProgramCode {
  LODGING("LODGING"),

  NO_SHOW("NO_SHOW"),

  ADVANCED_DEPOSIT("ADVANCED_DEPOSIT");

  private final String value;

  ProgramCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ProgramCode fromValue(String value) {
    for (ProgramCode b : ProgramCode.values()) {
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
