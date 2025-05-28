// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the processing rails used for card transactions.
 *
 * <p>It indicates whether the transaction is processed via a pinless network or through the regular card scheme network.</p>
 *
 * <p>Enum Values:</p>
 * <ul>
 *   <li><strong>PINLESS:</strong> The transaction is processed using a pinless card transaction method, bypassing the need for a PIN.</li>
 *   <li><strong>CARD_SCHEME_ROUTED:</strong> The transaction is processed through the regular card scheme network, where the standard card network
 *   routing applies.</li>
 * </ul>
 */
public enum ProcessingRails {
  PINLESS("PINLESS"),

  CARD_SCHEME_ROUTED("CARD_SCHEME_ROUTED");

  private final String value;

  ProcessingRails(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ProcessingRails fromValue(String value) {
    for (ProcessingRails b : ProcessingRails.values()) {
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