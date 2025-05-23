// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.carrental.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A code that corresponds to the classification  of the rental vehicle (e.g., midsize, luxury, cargo van, etc.).
 * Required during settlement request with Amex for integration with TSYS processor.
 */
public enum VehicleClass {
  MINI("MINI"),

  SUBCOMPACT("SUBCOMPACT"),

  ECONOMY("ECONOMY"),

  COMPACT("COMPACT"),

  MIDSIZE("MIDSIZE"),

  INTERMEDIATE("INTERMEDIATE"),

  STANDARD("STANDARD"),

  FULL_SIZE("FULL_SIZE"),

  LUXURY("LUXURY"),

  PREMIUM("PREMIUM"),

  MINIVAN("MINIVAN"),

  VAN_12_PASSENGERS("VAN_12_PASSENGERS"),

  MOVING_VAN("MOVING_VAN"),

  VAN_15_PASSENGERS("VAN_15_PASSENGERS"),

  CARGO_VAN("CARGO_VAN"),

  TRUCK_12_FOOT("TRUCK_12_FOOT"),

  TRUCK_20_FOOT("TRUCK_20_FOOT"),

  TRUCK_24_FOOT("TRUCK_24_FOOT"),

  TRUCK_26_FOOT("TRUCK_26_FOOT"),

  MOPED("MOPED"),

  STRETCH("STRETCH"),

  REGULAR("REGULAR"),

  UNIQUE("UNIQUE"),

  EXOTIC("EXOTIC"),

  SMALL_OR_MEDIUM_TRUCK("SMALL_OR_MEDIUM_TRUCK"),

  LARGE_TRUCK("LARGE_TRUCK"),

  SMALL_SUV("SMALL_SUV"),

  MEDIUM_SUV("MEDIUM_SUV"),

  LARGE_SUV("LARGE_SUV"),

  EXOTIC_SUV("EXOTIC_SUV"),

  FOUR_WHEEL_DRIVE("FOUR_WHEEL_DRIVE"),

  SPECIAL("SPECIAL"),

  MISCELLANEOUS("MISCELLANEOUS");

  private final String value;

  VehicleClass(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VehicleClass fromValue(String value) {
    for (VehicleClass b : VehicleClass.values()) {
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