// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.payment.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the transaction request for payment, verification. Possible values are
 * <ul>
 * <li> RECEIVED – Our system has received the request and is waiting for the downstream processor’s response. </li>
 * <li> PROCESSING - Transactions are submitted to Payment Service Provider (PSP)/Scheme and waiting for PSP to complete the transaction </li>
 * <li> COMPLETED – The transaction was completed.  </li>
 * <li> HELD – The request has been placed on hold due to risk considerations. </li>
 * <li> FAILED – The transaction failed, due to either an error or being declined. </li>
 * <li> CANCELLED – The request has been fully voided (reversed). </li>
 * <li> PENDING – The transaction awaiting payment service provider's response. </li>
 * </ul>
 */
public enum PaymentRequestStatus {

  RECEIVED("RECEIVED"),

  PROCESSING("PROCESSING"),

  COMPLETED("COMPLETED"),

  HELD("HELD"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED"),

  PENDING("PENDING");

  private final String value;

  PaymentRequestStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentRequestStatus fromValue(String value) {
    for (PaymentRequestStatus b : PaymentRequestStatus.values()) {
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
