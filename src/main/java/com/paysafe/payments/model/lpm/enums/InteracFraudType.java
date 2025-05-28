// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the type of fraudulent transaction that was carried out with the intention of financial gain. Possible values for the fraud type:
 * <ul>
 * <li> ACCOUNT_TAKEOVER - Account Takeover   </li>
 * <li> BAD_DEPOSIT - Proceeds of Bad Deposit   </li>
 * <li> FIRST_PARTY_FRAUD  </li>
 * <li> First Party Fraud  </li>
 * <li> INTERCEPTED_PAYMENT  </li>
 * <li> Intercepted Transfer   </li>
 * <li> MERCHANT_DISPUTE - Merchant Dispute  </li>
 * <li> FAMILY_FRIEND_FRAUD - Family/Friendly Fraud  </li>
 * <li> BUSINESS_EMAIL_COMPROMISE - Business Email Compromise  </li>
 * <li> VENDOR_EMAIL_COMPROMISE - Vendor Email Compromise  </li>
 * <li> MALWARE - Malware  </li>
 * <li> APPLICATION_FRAUD - Application Fraud  </li>
 * <li> FRAUD_BUSINESS - Fraudulent Business  </li>
 * <li> OTHER - Other fraud type </li>
 * </ul>
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