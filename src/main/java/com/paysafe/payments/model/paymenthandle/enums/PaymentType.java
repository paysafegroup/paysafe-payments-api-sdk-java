// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the payment type associated with the Payment Handle used for this request. For Apple Pay and Google Pay, paymentType is 'CARD'.
 * <b>Note:</b> this may not be an exhaustive list.
 */
public enum PaymentType {
  CARD("CARD"),

  SKRILL("SKRILL"),

  NETELLER("NETELLER"),

  PAYSAFECASH("PAYSAFECASH"),

  PAYSAFECARD("PAYSAFECARD"),

  PAYPAL("PAYPAL"),

  PAY_BY_BANK("PAY BY BANK"),

  VENMO("VENMO"),

  VIPPREFERRED("VIPPREFERRED"),

  MAZOOMA("MAZOOMA"),

  MBWAY("MBWAY"),

  MULTIBANCO("MULTIBANCO"),

  SIGHTLINE("SIGHTLINE"),

  INTERAC_ETRANSFER("INTERAC_ETRANSFER"),

  RAPID_TRANSFER("RAPID_TRANSFER"),

  SKRILL1TAP("SKRILL1TAP"),

  ACH("ACH"),

  EFT("EFT"),

  BACS("BACS"),

  SEPA("SEPA"),

  ONLINE_BANK_TRANSFER("ONLINE_BANK_TRANSFER"),

  PIX("PIX"),

  KHIPU("KHIPU"),

  MACH("MACH"),

  BOLETO_BANCARIO("BOLETO_BANCARIO"),

  SAFETYPAY_CASH("SAFETYPAY_CASH");

  private final String value;

  PaymentType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentType fromValue(String value) {
    for (PaymentType b : PaymentType.values()) {
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