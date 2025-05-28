// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the transaction request. Possible values are:
 * <ul>
 * <li>INITIATED - The transaction has been initiated.  </li>
 * <li>RECEIVED – Our system has received the request and is waiting for the downstream processor’s response.  </li>
 * <li>COMPLETED – The transaction has been completed.  </li>
 * <li>PENDING – Our system has received the request but it has not yet been batched.   </li>
 * <li>FAILED – The transaction failed, due to either an error or being declined.  </li>
 * <li>CANCELLED – The request has been fully voided (reversed). </li>
 * </ul>
 */
public enum VippreferredTransactionStatus {
  INITIATED("INITIATED"),

  RECEIVED("RECEIVED"),

  COMPLETED("COMPLETED"),

  PENDING("PENDING"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED");

  private final String value;

  VippreferredTransactionStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VippreferredTransactionStatus fromValue(String value) {
    for (VippreferredTransactionStatus b : VippreferredTransactionStatus.values()) {
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