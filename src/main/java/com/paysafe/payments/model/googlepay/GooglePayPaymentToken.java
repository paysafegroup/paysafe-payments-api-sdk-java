// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GooglePayPaymentToken
 */
public class GooglePayPaymentToken {

  @JsonProperty("apiVersion")
  private Long apiVersion;
  @JsonProperty("apiVersionMinor")
  private Long apiVersionMinor;
  @JsonProperty("paymentMethodData")
  private GooglePayPaymentMethodData paymentMethodData;

  public GooglePayPaymentToken() {
    super();
  }

  private GooglePayPaymentToken(Builder builder) {
    setApiVersion(builder.apiVersion);
    setApiVersionMinor(builder.apiVersionMinor);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GooglePayPaymentToken apiVersion(Long apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  /**
   * Major API version. The value is 2 for this specification.
   *
   * @return apiVersion
   */
  public Long getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(Long apiVersion) {
    this.apiVersion = apiVersion;
  }

  public GooglePayPaymentToken apiVersionMinor(Long apiVersionMinor) {
    this.apiVersionMinor = apiVersionMinor;
    return this;
  }

  /**
   * Minor API version. The value is 0 for this specification.
   *
   * @return apiVersionMinor
   */
  public Long getApiVersionMinor() {
    return apiVersionMinor;
  }

  public void setApiVersionMinor(Long apiVersionMinor) {
    this.apiVersionMinor = apiVersionMinor;
  }

  public GooglePayPaymentToken paymentMethodData(GooglePayPaymentMethodData paymentMethodData) {
    this.paymentMethodData = paymentMethodData;
    return this;
  }

  /**
   * Payment method parameter of Google Pay Token.
   *
   * @return paymentMethodData
   */
  public GooglePayPaymentMethodData getPaymentMethodData() {
    return paymentMethodData;
  }

  public void setPaymentMethodData(GooglePayPaymentMethodData paymentMethodData) {
    this.paymentMethodData = paymentMethodData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentToken googlePayPaymentToken = (GooglePayPaymentToken) o;
    return Objects.equals(this.apiVersion, googlePayPaymentToken.apiVersion) &&
        Objects.equals(this.apiVersionMinor, googlePayPaymentToken.apiVersionMinor) &&
        Objects.equals(this.paymentMethodData, googlePayPaymentToken.paymentMethodData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, apiVersionMinor, paymentMethodData);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentToken {\n"
        + "    apiVersion: " + toIndentedString(apiVersion) + "\n"
        + "    apiVersionMinor: " + toIndentedString(apiVersionMinor) + "\n"
        + "    paymentMethodData: " + toIndentedString(paymentMethodData) + "\n"
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
   * {@code GooglePayPaymentToken} builder static inner class.
   */
  public static final class Builder {
    private Long apiVersion;
    private Long apiVersionMinor;

    private Builder() {
    }

    /**
     * Sets the {@code apiVersion} and returns a reference to this Builder enabling method chaining.
     *
     * @param apiVersion the {@code apiVersion} to set
     * @return a reference to this Builder
     */
    public Builder apiVersion(Long apiVersion) {
      this.apiVersion = apiVersion;
      return this;
    }

    /**
     * Sets the {@code apiVersionMinor} and returns a reference to this Builder enabling method chaining.
     *
     * @param apiVersionMinor the {@code apiVersionMinor} to set
     * @return a reference to this Builder
     */
    public Builder apiVersionMinor(Long apiVersionMinor) {
      this.apiVersionMinor = apiVersionMinor;
      return this;
    }

    /**
     * Returns a {@code GooglePayPaymentToken} built from the parameters previously set.
     *
     * @return a {@code GooglePayPaymentToken} built with parameters of this {@code GooglePayPaymentToken.Builder}
     */
    public GooglePayPaymentToken build() {
      return new GooglePayPaymentToken(this);
    }
  }
}

