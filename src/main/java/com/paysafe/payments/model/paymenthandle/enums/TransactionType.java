// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This specifies the transaction type for which the Payment Handle is created.
 * <ul>
 *   <li>
 *     <b>PAYMENT:</b> Payment Handle is created to continue the Payment.
 *   </li>
 *   <li>
 *     <b>STANDALONE_CREDIT:</b> Payment Handle is created to continue the Standalone Credit.
 *   </li>
 *   <li>
 *     <b>ORIGINAL_CREDIT:</b> Payment Handle is created to continue the Original Credit.
 *   </li>
 *   <li>
 *     <b>VERIFICATION:</b> Payment Handle is created to continue the Verification request.
 *   </li>
 * </ul>
 */
public enum TransactionType {
  PAYMENT("PAYMENT"),

  STANDALONE_CREDIT("STANDALONE_CREDIT"),

  ORIGINAL_CREDIT("ORIGINAL_CREDIT"),

  VERIFICATION("VERIFICATION");

  private final String value;

  TransactionType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransactionType fromValue(String value) {
    for (TransactionType b : TransactionType.values()) {
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
