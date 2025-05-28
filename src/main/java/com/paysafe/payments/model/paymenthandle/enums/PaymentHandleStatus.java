// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the payment handle. Possible values are:
 * <ul>
 *   <li>
 *     <b>INITIATED:</b> The transaction was initiated with the downstream provider.
 *   </li>
 *   <li>
 *     <b>PAYABLE:</b> The merchant can use the Payment Handle for a Payment request.
 *   </li>
 *   <li>
 *     <b>PROCESSING:</b> The Payment Handle was authorized by customer, awaiting PSP response.
 *   </li>
 *   <li>
 *     <b>FAILED:</b> The transaction failed due to either an error or being declined.
 *   </li>
 *   <li>
 *     <b>EXPIRED:</b> The Payment Handle expired because the merchant did not proceed with the Payment.
 *   </li>
 *   <li>
 *     <b>COMPLETED:</b> The Payment request was initiated successfully using the Payment Handle.
 *   </li>
 * </ul>
 */
public enum PaymentHandleStatus {
  INITIATED("INITIATED"),

  PAYABLE("PAYABLE"),

  PROCESSING("PROCESSING"),

  FAILED("FAILED"),

  EXPIRED("EXPIRED"),

  COMPLETED("COMPLETED");

  private final String value;

  PaymentHandleStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentHandleStatus fromValue(String value) {
    for (PaymentHandleStatus b : PaymentHandleStatus.values()) {
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
