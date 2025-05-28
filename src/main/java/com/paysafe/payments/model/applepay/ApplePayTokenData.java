// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object contains the user's payment credentials.
 */
public class ApplePayTokenData {

  @JsonProperty("paymentData")
  private ApplePayTokenPaymentData paymentData;
  @JsonProperty("paymentMethod")
  private ApplePayPaymentMethod paymentMethod;
  @JsonProperty("transactionIdentifier")
  private String transactionIdentifier;

  public ApplePayTokenData() {
    super();
  }

  private ApplePayTokenData(Builder builder) {
    setPaymentData(builder.paymentData);
    setPaymentMethod(builder.paymentMethod);
    setTransactionIdentifier(builder.transactionIdentifier);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayTokenData paymentData(ApplePayTokenPaymentData paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  /**
   * Get paymentData
   *
   * @return paymentData
   */
  public ApplePayTokenPaymentData getPaymentData() {
    return paymentData;
  }

  public void setPaymentData(ApplePayTokenPaymentData paymentData) {
    this.paymentData = paymentData;
  }

  public ApplePayTokenData paymentMethod(ApplePayPaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * Payment method parameter returned by Apple Pay JS
   *
   * @return paymentMethod
   */
  public ApplePayPaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(ApplePayPaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public ApplePayTokenData transactionIdentifier(String transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  /**
   * Transaction identifier parameter returned by Apple Pay JS
   *
   * @return transactionIdentifier
   */
  public String getTransactionIdentifier() {
    return transactionIdentifier;
  }

  public void setTransactionIdentifier(String transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayTokenData applePayTokenData = (ApplePayTokenData) o;
    return Objects.equals(this.paymentData, applePayTokenData.paymentData) &&
        Objects.equals(this.paymentMethod, applePayTokenData.paymentMethod) &&
        Objects.equals(this.transactionIdentifier, applePayTokenData.transactionIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentData, paymentMethod, transactionIdentifier);
  }

  @Override
  public String toString() {

    return "class ApplePayApplePayPaymentTokenToken {\n"
        + "    paymentData: " + toIndentedString(paymentData) + "\n"
        + "    paymentMethod: " + toIndentedString(paymentMethod) + "\n"
        + "    transactionIdentifier: " + toIndentedString(transactionIdentifier) + "\n"
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
   * {@code ApplePayApplePayPaymentTokenToken} builder static inner class.
   */
  public static final class Builder {
    private ApplePayTokenPaymentData paymentData;
    private ApplePayPaymentMethod paymentMethod;
    private String transactionIdentifier;

    private Builder() {
    }

    /**
     * Sets the {@code paymentData} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentData the {@code paymentData} to set
     * @return a reference to this Builder
     */
    public Builder paymentData(ApplePayTokenPaymentData paymentData) {
      this.paymentData = paymentData;
      return this;
    }

    /**
     * Sets the {@code paymentMethod} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentMethod the {@code paymentMethod} to set
     * @return a reference to this Builder
     */
    public Builder paymentMethod(ApplePayPaymentMethod paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
    }

    /**
     * Sets the {@code transactionIdentifier} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIdentifier the {@code transactionIdentifier} to set
     * @return a reference to this Builder
     */
    public Builder transactionIdentifier(String transactionIdentifier) {
      this.transactionIdentifier = transactionIdentifier;
      return this;
    }

    /**
     * Returns a {@code ApplePayApplePayPaymentTokenToken} built from the parameters previously set.
     *
     * @return a {@code ApplePayApplePayPaymentTokenToken} built with parameters of this {@code ApplePayApplePayPaymentTokenToken.Builder}
     */
    public ApplePayTokenData build() {
      return new ApplePayTokenData(this);
    }
  }
}

