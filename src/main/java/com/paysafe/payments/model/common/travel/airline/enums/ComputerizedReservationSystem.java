// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates the computerized reservation system used to make the reservation and purchase the ticket.
 * <p>For tickets purchased in Germany, this field should one of these codes:</p>
 * <ul>
 *   <li>STRT = Start</li>
 *   <li>PARS = TWA</li>
 *   <li>DATS = Delta</li>
 *   <li>SABR = Sabre</li>
 *   <li>DALA = Covia-Apollo</li>
 *   <li>BLAN = Dr. Blank</li>
 *   <li>DERD = DER</li>
 *   <li>TUID = TUI</li>
 * </ul>
 *
 * <b>Note:</b> Required only if the ticket is purchased in Germany. Otherwise it can be omitted.
 */
public enum ComputerizedReservationSystem {
  STRT("STRT"),
  PARS("PARS"),
  DATS("DATS"),
  SABR("SABR"),
  DALA("DALA"),
  BLAN("BLAN"),
  DERD("DERD"),
  TUID("TUID");

  private final String value;

  ComputerizedReservationSystem(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ComputerizedReservationSystem fromValue(String value) {
    for (ComputerizedReservationSystem b : ComputerizedReservationSystem.values()) {
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
