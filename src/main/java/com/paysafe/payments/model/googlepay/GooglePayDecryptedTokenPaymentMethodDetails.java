// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GooglePayDecryptedTokenPaymentMethodDetails
 */
public class GooglePayDecryptedTokenPaymentMethodDetails {

  @JsonProperty("authMethod")
  private String authMethod;
  @JsonProperty("pan")
  private String pan;
  @JsonProperty("expirationMonth")
  private Integer expirationMonth;
  @JsonProperty("expirationYear")
  private Integer expirationYear;
  @JsonProperty("cryptogram")
  private String cryptogram;
  @JsonProperty("eciIndicator")
  private String eciIndicator;

  public GooglePayDecryptedTokenPaymentMethodDetails() {
    super();
  }

  private GooglePayDecryptedTokenPaymentMethodDetails(Builder builder) {
    setAuthMethod(builder.authMethod);
    setPan(builder.pan);
    setExpirationMonth(builder.expirationMonth);
    setExpirationYear(builder.expirationYear);
    setCryptogram(builder.cryptogram);
    setEciIndicator(builder.eciIndicator);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GooglePayDecryptedTokenPaymentMethodDetails authMethod(String authMethod) {
    this.authMethod = authMethod;
    return this;
  }

  /**
   * Get authMethod
   *
   * @return authMethod
   */
  public String getAuthMethod() {
    return authMethod;
  }

  public void setAuthMethod(String authMethod) {
    this.authMethod = authMethod;
  }

  public GooglePayDecryptedTokenPaymentMethodDetails pan(String pan) {
    this.pan = pan;
    return this;
  }

  /**
   * The DPAN number
   *
   * @return pan
   */
  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }

  public GooglePayDecryptedTokenPaymentMethodDetails expirationMonth(Integer expirationMonth) {
    this.expirationMonth = expirationMonth;
    return this;
  }

  /**
   * Get expirationMonth
   *
   * @return expirationMonth
   */
  public Integer getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(Integer expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public GooglePayDecryptedTokenPaymentMethodDetails expirationYear(Integer expirationYear) {
    this.expirationYear = expirationYear;
    return this;
  }

  /**
   * Get expirationYear
   *
   * @return expirationYear
   */
  public Integer getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(Integer expirationYear) {
    this.expirationYear = expirationYear;
  }

  public GooglePayDecryptedTokenPaymentMethodDetails cryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
    return this;
  }

  /**
   * This field is required when authMethod is CRYPTOGRAM_3DS.
   *
   * @return cryptogram
   */
  public String getCryptogram() {
    return cryptogram;
  }

  public void setCryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
  }

  public GooglePayDecryptedTokenPaymentMethodDetails eciIndicator(String eciIndicator) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayDecryptedTokenPaymentMethodDetails googlePayDecryptedTokenPaymentMethodDetails = (GooglePayDecryptedTokenPaymentMethodDetails) o;
    return Objects.equals(this.authMethod, googlePayDecryptedTokenPaymentMethodDetails.authMethod) &&
        Objects.equals(this.pan, googlePayDecryptedTokenPaymentMethodDetails.pan) &&
        Objects.equals(this.expirationMonth, googlePayDecryptedTokenPaymentMethodDetails.expirationMonth) &&
        Objects.equals(this.expirationYear, googlePayDecryptedTokenPaymentMethodDetails.expirationYear) &&
        Objects.equals(this.cryptogram, googlePayDecryptedTokenPaymentMethodDetails.cryptogram) &&
        Objects.equals(this.eciIndicator, googlePayDecryptedTokenPaymentMethodDetails.eciIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authMethod, pan, expirationMonth, expirationYear, cryptogram, eciIndicator);
  }

  @Override
  public String toString() {

    return "class GooglePayDecryptedTokenPaymentMethodDetails {\n"
        + "    authMethod: " + toIndentedString(authMethod) + "\n"
        + "    pan: " + toIndentedString(pan) + "\n"
        + "    expirationMonth: " + toIndentedString(expirationMonth) + "\n"
        + "    expirationYear: " + toIndentedString(expirationYear) + "\n"
        + "    cryptogram: " + toIndentedString(cryptogram) + "\n"
        + "    eciIndicator: " + toIndentedString(eciIndicator) + "\n"
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
   * {@code GooglePayDecryptedTokenPaymentMethodDetails} builder static inner class.
   */
  public static final class Builder {
    private String authMethod;
    private String pan;
    private Integer expirationMonth;
    private Integer expirationYear;
    private String cryptogram;
    private String eciIndicator;

    private Builder() {
    }

    /**
     * Sets the {@code authMethod} and returns a reference to this Builder enabling method chaining.
     *
     * @param authMethod the {@code authMethod} to set
     * @return a reference to this Builder
     */
    public Builder authMethod(String authMethod) {
      this.authMethod = authMethod;
      return this;
    }

    /**
     * Sets the {@code pan} and returns a reference to this Builder enabling method chaining.
     *
     * @param pan the {@code pan} to set
     * @return a reference to this Builder
     */
    public Builder pan(String pan) {
      this.pan = pan;
      return this;
    }

    /**
     * Sets the {@code expirationMonth} and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationMonth the {@code expirationMonth} to set
     * @return a reference to this Builder
     */
    public Builder expirationMonth(Integer expirationMonth) {
      this.expirationMonth = expirationMonth;
      return this;
    }

    /**
     * Sets the {@code expirationYear} and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationYear the {@code expirationYear} to set
     * @return a reference to this Builder
     */
    public Builder expirationYear(Integer expirationYear) {
      this.expirationYear = expirationYear;
      return this;
    }

    /**
     * Sets the {@code cryptogram} and returns a reference to this Builder enabling method chaining.
     *
     * @param cryptogram the {@code cryptogram} to set
     * @return a reference to this Builder
     */
    public Builder cryptogram(String cryptogram) {
      this.cryptogram = cryptogram;
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
     * Returns a {@code GooglePayDecryptedTokenPaymentMethodDetails} built from the parameters previously set.
     *
     * @return a {@code GooglePayDecryptedTokenPaymentMethodDetails} built with parameters of this {@code
     * GooglePayDecryptedTokenPaymentMethodDetails.Builder}
     */
    public GooglePayDecryptedTokenPaymentMethodDetails build() {
      return new GooglePayDecryptedTokenPaymentMethodDetails(this);
    }
  }
}

