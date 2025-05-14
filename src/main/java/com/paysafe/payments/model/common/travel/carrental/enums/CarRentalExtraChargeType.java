// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.carrental.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the various types of extra charges that may apply to a car rental reservation.
 *
 * <p>Enum Values:</p>
 * <ul>
 *   <li><strong>GASOLINE:</strong> Charges related to gasoline or fuel usage during the rental period.</li>
 *   <li><strong>MILEAGE:</strong> Charges for mileage used beyond the agreed-upon limits.</li>
 *   <li><strong>LATE_RETURN:</strong> Charges imposed if the rented vehicle is returned after the scheduled return time.</li>
 *   <li><strong>ONE_WAY_SERVICE_FEE:</strong> Charges for renting a vehicle and returning it at a different location from where it was rented.</li>
 *   <li><strong>DRIVING_VIOLATION:</strong> Charges for any fines or penalties incurred due to driving violations during the rental period.</li>
 * </ul>
 */
public enum CarRentalExtraChargeType {
  GASOLINE("GASOLINE"),

  MILEAGE("MILEAGE"),

  LATE_RETURN("LATE_RETURN"),

  ONE_WAY_SERVICE_FEE("ONE_WAY_SERVICE_FEE"),

  DRIVING_VIOLATION("DRIVING_VIOLATION");

  private final String value;

  CarRentalExtraChargeType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CarRentalExtraChargeType fromValue(String value) {
    for (CarRentalExtraChargeType b : CarRentalExtraChargeType.values()) {
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

