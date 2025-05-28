// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The transactionIntent property is used to identify the intent of the authorization requests.
 * The value of the transactionIntent shows if the transaction is crypto or quasi-cash related one.
 * <b>Note: </b>This field is mandatory for Visa card - cross-border fundingTransactions where the
 * recipient is from any of the following countries:  India, Bangladesh, Argentina, and Egypt.
 * It is required only if the use cases explained below are applicable for the merchants or the default
 * behavior is not acceptable for them. The merchant needs to add in the request transactionIntent property
 * value as shown in the example below. <br>
 * See <a href="https://developer.paysafe.com/en/payments-api/#/schemas/transactionIntent">Transaction Intent documentation</a>
 * for more information.
 */
public enum TransactionIntentCredit {

  WALLET_CRYPTO_OFF_RAMP("WALLET_CRYPTO_OFF_RAMP"),

  CRYPTO_OFF_RAMP("CRYPTO_OFF_RAMP"),

  TRAVEL_AND_TOURISM("TRAVEL_AND_TOURISM"),

  EDUCATION("EDUCATION"),

  MEDICAL_TREATMENT("MEDICAL_TREATMENT"),

  SAVINGS("SAVINGS"),

  CHARITY("CHARITY"),

  OTHER("OTHER"),

  SALARY("SALARY");

  private final String value;

  TransactionIntentCredit(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransactionIntentCredit fromValue(String value) {
    for (TransactionIntentCredit b : TransactionIntentCredit.values()) {
      if (b.value.equalsIgnoreCase(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }
}

