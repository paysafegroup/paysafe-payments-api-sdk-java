// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates service class (first class, business class, etc.). Example values (not limited to):
 * <ul>
 * <li> F - first class </li>
 * <li> J - business class </li>
 * <li> W - premium economy class </li>
 * <li> Y - economy class </li>
 * </ul>
 */
public enum ServiceClass {
  F("F"),

  J("J"),

  W("W"),

  Y("Y");

  private final String value;

  ServiceClass(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ServiceClass fromValue(String value) {
    for (ServiceClass b : ServiceClass.values()) {
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