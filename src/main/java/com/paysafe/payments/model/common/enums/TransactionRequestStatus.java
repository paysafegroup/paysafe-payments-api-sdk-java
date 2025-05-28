// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the transaction request for standalone and original credits. Possible values are:
 * <ul>
 * <li> RECEIVED – Our system has received the request and is waiting for the downstream processor’s response.  </li>
 * <li> INITIATED – The transaction was initiated with the downstream provider.  </li>
 * <li> PENDING - The transaction is awaiting the payment service provider's response.  </li>
 * <li> FAILED – The transaction failed, due to either an error or being declined.  </li>
 * <li> CANCELLED – The transaction request is cancelled.  </li>
 * <li> EXPIRED – The transaction request is expired.  </li>
 * <li> COMPLETED – The transaction request is completed. </li>
 * </ul>
 */
public enum TransactionRequestStatus {
  RECEIVED("RECEIVED"),

  INITIATED("INITIATED"),

  PENDING("PENDING"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED"),

  EXPIRED("EXPIRED"),

  COMPLETED("COMPLETED");

  private final String value;

  TransactionRequestStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransactionRequestStatus fromValue(String value) {
    for (TransactionRequestStatus b : TransactionRequestStatus.values()) {
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