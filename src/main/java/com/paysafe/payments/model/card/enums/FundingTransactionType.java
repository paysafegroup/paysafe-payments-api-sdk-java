// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the various processor applied types for funding transactions. The fundingTransaction processorAppliedType value is
 * chosen by Paysafe based on the merchant configuration. It is equal to the one which is used by Paysafe based on your MCC and registration.
 * If you  provide value which is applicable for your MCC but you have been registered for another use case, Paysafe will assign the value
 * you have registered for as use case and will provide it into the response as processorAppliedType. In case the merchant is not registered
 * in the relevant card scheme system, the processorAppliedValue received into the response will be 'NOT_APPLIED'.
 * The processorAppliedType can be seen in the auth response.
 *
 * <p>Enum Values:</p>
 * <ul>
 *   <li><strong>SVDW_FUNDS_TRANSFER:</strong> Stored Value Digital Wallet Funds Transfer.
 *   Used when a digital wallet is pre-loaded with funds using a Visa payment credential before transactions can occur.</li>
 *
 *   <li><strong>SDW_WALLET_TRANSFER:</strong> Staged Digital Wallet Transfer.
 *   Used for back-to-back funding transactions, allowing transactions even with insufficient funds in the wallet account.</li>
 *
 *   <li><strong>ACCOUNT_TO_ACCOUNT:</strong> Account to Account transfer.
 *   Refers to the transfer of money between two accounts, either at the same or different financial institutions.</li>
 *
 *   <li><strong>PERSON_TO_PERSON:</strong> Person to Person transfer.
 *   Refers to transferring funds between two individuals, typically outside of merchant transactions.</li>
 *
 *   <li><strong>NOT_APPLIED:</strong> Not processed as a funding transaction.
 *   This value is used when no funding transaction processor is applied or when the processor determines no application is relevant.</li>
 * </ul>
 */
public enum FundingTransactionType {
  SVDW_FUNDS_TRANSFER("SVDW_FUNDS_TRANSFER"),

  SDW_WALLET_TRANSFER("SDW_WALLET_TRANSFER"),

  ACCOUNT_TO_ACCOUNT("ACCOUNT_TO_ACCOUNT"),

  PERSON_TO_PERSON("PERSON_TO_PERSON"),

  NOT_APPLIED("NOT_APPLIED");

  private final String value;

  FundingTransactionType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static FundingTransactionType fromValue(String value) {
    for (FundingTransactionType b : FundingTransactionType.values()) {
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

