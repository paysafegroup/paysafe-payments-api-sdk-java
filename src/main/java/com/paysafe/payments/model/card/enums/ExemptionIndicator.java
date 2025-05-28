// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This exemption gives the Merchant the option to bypass the Strong Customer Authentication or 3DS.
 * <b>Note:</b> This exists only for 3D Secure 2. <br>
 * <ul>
 * <li>LOW_VALUE_EXEMPTION - This exemption is valid only for transactions lower or equal to 30 euro, not exceeding five transactions in a row
 * or 100 euro total amount transactions with no SCA (Strong Customer Authentication) </li>
 * <li>TRA_EXEMPTION - The exemption applies specifically to transactions that are 100 euros or lower. However, there could be additional criteria that
 * need to be considered. Please reach out to your account manager for further details. </li>
 * </ul>
 */
public enum ExemptionIndicator {
  LOW_VALUE_EXEMPTION("LOW_VALUE_EXEMPTION"),

  TRA_EXEMPTION("TRA_EXEMPTION");

  private final String value;

  ExemptionIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ExemptionIndicator fromValue(String value) {
    for (ExemptionIndicator b : ExemptionIndicator.values()) {
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