// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.lpm.enums.BankNameCode;

/**
 * PaymentDetails
 */
public class PaymentDetails {

  @JsonProperty("countryCode")
  private String countryCode;
  @JsonProperty("bankNameCodes")
  private List<BankNameCode> bankNameCodes = null;

  public PaymentDetails() {
    super();
  }

  private PaymentDetails(Builder builder) {
    setCountryCode(builder.countryCode);
    setBankNameCodes(builder.bankNameCodes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentDetails countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode.
   *
   * @return countryCode
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public PaymentDetails bankNameCodes(List<BankNameCode> bankNameCodes) {
    this.bankNameCodes = bankNameCodes;
    return this;
  }

  public PaymentDetails addBankNameCodesItem(BankNameCode bankNameCodesItem) {
    if (this.bankNameCodes == null) {
      this.bankNameCodes = new ArrayList<>();
    }
    this.bankNameCodes.add(bankNameCodesItem);
    return this;
  }

  public PaymentDetails removeBankNameCodesItem(BankNameCode bankNameCodesItem) {
    if (bankNameCodesItem != null && this.bankNameCodes != null) {
      this.bankNameCodes.remove(bankNameCodesItem);
    }

    return this;
  }

  /**
   * Get bankNameCodes.
   *
   * @return bankNameCodes
   */
  public List<BankNameCode> getBankNameCodes() {
    return bankNameCodes;
  }

  public void setBankNameCodes(List<BankNameCode> bankNameCodes) {
    this.bankNameCodes = bankNameCodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDetails paymentDetails = (PaymentDetails) o;
    return Objects.equals(this.countryCode, paymentDetails.countryCode) &&
        Objects.equals(this.bankNameCodes, paymentDetails.bankNameCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, bankNameCodes);
  }

  @Override
  public String toString() {

    return "class PaymentDetails {\n"
        + "    countryCode: " + toIndentedString(countryCode) + "\n"
        + "    bankNameCodes: " + toIndentedString(bankNameCodes) + "\n"
        + "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * {@code PaymentDetails} builder static inner class.
   */
  public static final class Builder {
    private String countryCode;
    private List<BankNameCode> bankNameCodes;

    private Builder() {
    }

    /**
     * Sets the {@code countryCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param countryCode the {@code countryCode} to set
     * @return a reference to this Builder
     */
    public Builder countryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Sets the {@code bankNameCodes} and returns a reference to this Builder enabling method chaining.
     *
     * @param bankNameCodes the {@code bankNameCodes} to set
     * @return a reference to this Builder
     */
    public Builder bankNameCodes(List<BankNameCode> bankNameCodes) {
      this.bankNameCodes = bankNameCodes;
      return this;
    }

    /**
     * Returns a {@code PaymentDetails} built from the parameters previously set.
     *
     * @return a {@code PaymentDetails} built with parameters of this {@code PaymentDetails.Builder}
     */
    public PaymentDetails build() {
      return new PaymentDetails(this);
    }
  }
}

