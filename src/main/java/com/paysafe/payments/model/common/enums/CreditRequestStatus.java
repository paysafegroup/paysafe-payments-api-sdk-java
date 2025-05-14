// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the transaction request for standalone and original credits. Possible values are:  <br />
 * • RECEIVED – Our system has received the request and is waiting for the downstream processor’s response. <br />
 * • INITIATED – The transaction was initiated with the downstream provider. <br />
 * • PENDING - The transaction is awaiting the payment service provider's response. <br />
 * • FAILED – The transaction failed, due to either an error or being declined. <br />
 * • CANCELLED – The transaction request is cancelled. <br />
 * • EXPIRED – The transaction request is expired. <br />
 * • COMPLETED – The transaction request is completed.
 */
public enum CreditRequestStatus {
  RECEIVED("RECEIVED"),

  INITIATED("INITIATED"),

  PENDING("PENDING"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED"),

  EXPIRED("EXPIRED"),

  COMPLETED("COMPLETED");

  private final String value;

  CreditRequestStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CreditRequestStatus fromValue(String value) {
    for (CreditRequestStatus b : CreditRequestStatus.values()) {
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