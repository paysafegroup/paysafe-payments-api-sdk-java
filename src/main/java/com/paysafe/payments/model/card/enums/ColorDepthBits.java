// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the bit depth of the color palette for displaying images, in bits per pixel.
 */
public enum ColorDepthBits {
  _1("1"),

  _4("4"),

  _5("5"),

  _15("15"),

  _16("16"),

  _24("24"),

  _32("32"),

  _48("48");

  private final String value;

  ColorDepthBits(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ColorDepthBits fromValue(String value) {
    for (ColorDepthBits b : ColorDepthBits.values()) {
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