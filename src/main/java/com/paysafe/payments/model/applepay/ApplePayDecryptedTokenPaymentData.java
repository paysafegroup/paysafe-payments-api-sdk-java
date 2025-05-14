// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ApplePayDecryptedTokenPaymentData
 */
public class ApplePayDecryptedTokenPaymentData {

  @JsonProperty("onlinePaymentCryptogram")
  private String onlinePaymentCryptogram;
  @JsonProperty("eciIndicator")
  private String eciIndicator;
  @JsonProperty("emvData")
  private String emvData;

  public ApplePayDecryptedTokenPaymentData() {
    super();
  }

  private ApplePayDecryptedTokenPaymentData(Builder builder) {
    setOnlinePaymentCryptogram(builder.onlinePaymentCryptogram);
    setEciIndicator(builder.eciIndicator);
    setEmvData(builder.emvData);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayDecryptedTokenPaymentData onlinePaymentCryptogram(String onlinePaymentCryptogram) {
    this.onlinePaymentCryptogram = onlinePaymentCryptogram;
    return this;
  }

  /**
   * The cryptogram for this payment. Required when paymentDataType is '3DSecure'
   *
   * @return onlinePaymentCryptogram
   */
  public String getOnlinePaymentCryptogram() {
    return onlinePaymentCryptogram;
  }

  public void setOnlinePaymentCryptogram(String onlinePaymentCryptogram) {
    this.onlinePaymentCryptogram = onlinePaymentCryptogram;
  }

  public ApplePayDecryptedTokenPaymentData eciIndicator(String eciIndicator) {
    this.eciIndicator = eciIndicator;
    return this;
  }

  /**
   * The ECI indicator.
   *
   * @return eciIndicator
   */
  public String getEciIndicator() {
    return eciIndicator;
  }

  public void setEciIndicator(String eciIndicator) {
    this.eciIndicator = eciIndicator;
  }

  public ApplePayDecryptedTokenPaymentData emvData(String emvData) {
    this.emvData = emvData;
    return this;
  }

  /**
   * Required when paymentDataType is 'EMV'
   *
   * @return emvData
   */
  public String getEmvData() {
    return emvData;
  }

  public void setEmvData(String emvData) {
    this.emvData = emvData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayDecryptedTokenPaymentData applePayDecryptedTokenPaymentData = (ApplePayDecryptedTokenPaymentData) o;
    return Objects.equals(this.onlinePaymentCryptogram, applePayDecryptedTokenPaymentData.onlinePaymentCryptogram) &&
        Objects.equals(this.eciIndicator, applePayDecryptedTokenPaymentData.eciIndicator) &&
        Objects.equals(this.emvData, applePayDecryptedTokenPaymentData.emvData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onlinePaymentCryptogram, eciIndicator, emvData);
  }

  @Override
  public String toString() {

    return "class ApplePayDecryptedTokenPaymentData {\n"
        + "    onlinePaymentCryptogram: " + toIndentedString(onlinePaymentCryptogram) + "\n"
        + "    eciIndicator: " + toIndentedString(eciIndicator) + "\n"
        + "    emvData: " + toIndentedString(emvData) + "\n"
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
   * {@code ApplePayDecryptedTokenPaymentData} builder static inner class.
   */
  public static final class Builder {
    private String onlinePaymentCryptogram;
    private String eciIndicator;
    private String emvData;

    private Builder() {
    }

    /**
     * Sets the {@code onlinePaymentCryptogram} and returns a reference to this Builder enabling method chaining.
     *
     * @param onlinePaymentCryptogram the {@code onlinePaymentCryptogram} to set
     * @return a reference to this Builder
     */
    public Builder onlinePaymentCryptogram(String onlinePaymentCryptogram) {
      this.onlinePaymentCryptogram = onlinePaymentCryptogram;
      return this;
    }

    /**
     * Sets the {@code eciIndicator} and returns a reference to this Builder enabling method chaining.
     *
     * @param eciIndicator the {@code eciIndicator} to set
     * @return a reference to this Builder
     */
    public Builder eciIndicator(String eciIndicator) {
      this.eciIndicator = eciIndicator;
      return this;
    }

    /**
     * Sets the {@code emvData} and returns a reference to this Builder enabling method chaining.
     *
     * @param emvData the {@code emvData} to set
     * @return a reference to this Builder
     */
    public Builder emvData(String emvData) {
      this.emvData = emvData;
      return this;
    }

    /**
     * Returns a {@code ApplePayDecryptedTokenPaymentData} built from the parameters previously set.
     *
     * @return a {@code ApplePayDecryptedTokenPaymentData} built with parameters of this
     * {@code ApplePayDecryptedTokenPaymentData.Builder}
     */
    public ApplePayDecryptedTokenPaymentData build() {
      return new ApplePayDecryptedTokenPaymentData(this);
    }
  }
}

