// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the type of fraudulent transaction that was carried out with the intention of financial gain. Possible values for the fraud type: <br />
 * • ACCOUNT_TAKEOVER - Account Takeover  <br />
 * • BAD_DEPOSIT - Proceeds of Bad Deposit  <br />
 * • FIRST_PARTY_FRAUD <br />
 * • First Party Fraud <br />
 * • INTERCEPTED_PAYMENT <br />
 * • Intercepted Transfer  <br />
 * • MERCHANT_DISPUTE - Merchant Dispute <br />
 * • FAMILY_FRIEND_FRAUD - Family/Friendly Fraud <br />
 * • BUSINESS_EMAIL_COMPROMISE - Business Email Compromise <br />
 * • VENDOR_EMAIL_COMPROMISE - Vendor Email Compromise <br />
 * • MALWARE - Malware <br />
 * • APPLICATION_FRAUD - Application Fraud <br />
 * • FRAUD_BUSINESS - Fraudulent Business <br />
 * • OTHER - Other fraud type
 */
public enum InteracFraudType {
  ACCOUNT_TAKEOVER("ACCOUNT_TAKEOVER"),

  BAD_DEPOSIT("BAD_DEPOSIT"),

  FIRST_PARTY_FRAUD("FIRST_PARTY_FRAUD"),

  INTERCEPTED_PAYMENT("INTERCEPTED_PAYMENT"),

  MERCHANT_DISPUTE("MERCHANT_DISPUTE"),

  FAMILY_FRIEND_FRAUD("FAMILY_FRIEND_FRAUD"),

  BUSINESS_EMAIL_COMPROMISE("BUSINESS_EMAIL_COMPROMISE"),

  VENDOR_EMAIL_COMPROMISE("VENDOR_EMAIL_COMPROMISE"),

  MALWARE("MALWARE"),

  APPLICATION_FRAUD("APPLICATION_FRAUD"),

  FRAUD_BUSINESS("FRAUD_BUSINESS"),

  OTHER("OTHER");

  private final String value;

  InteracFraudType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracFraudType fromValue(String value) {
    for (InteracFraudType b : InteracFraudType.values()) {
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