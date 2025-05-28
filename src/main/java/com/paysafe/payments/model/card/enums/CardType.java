// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is type of card used for the request.
 * <ul>
 * <li>AM – American Express</li>
 * <li>DI – Discover</li>
 * <li>JC – JCB</li>
 * <li>MC – Mastercard</li>
 * <li>MD – Maestro</li>
 * <li>SO – Solo</li>
 * <li>VI – Visa</li>
 * <li>VD – Visa Debit</li>
 * <li>VE – Visa Electron</li>
 * </ul>
 */
public enum CardType {
  AM("AM"),

  DI("DI"),

  JC("JC"),

  MC("MC"),

  MD("MD"),

  SO("SO"),

  VI("VI"),

  VD("VD"),

  VE("VE");

  private final String value;

  CardType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CardType fromValue(String value) {
    for (CardType b : CardType.values()) {
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