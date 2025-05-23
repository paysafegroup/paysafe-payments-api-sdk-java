// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payment method parameter of Google Pay Token.
 */
public class GooglePayPaymentMethodData {

  @JsonProperty("description")
  private String description;
  @JsonProperty("info")
  private GooglePayPaymentMethodDataInfo info;
  @JsonProperty("tokenizationData")
  private GooglePayPaymentMethodDataTokenizationData tokenizationData;
  @JsonProperty("type")
  private String type;

  public GooglePayPaymentMethodData() {
    super();
  }

  private GooglePayPaymentMethodData(Builder builder) {
    setDescription(builder.description);
    setInfo(builder.info);
    setType(builder.type);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GooglePayPaymentMethodData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A descriptive text.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GooglePayPaymentMethodData info(GooglePayPaymentMethodDataInfo info) {
    this.info = info;
    return this;
  }

  /**
   * Get info
   *
   * @return info
   */
  public GooglePayPaymentMethodDataInfo getInfo() {
    return info;
  }

  public void setInfo(GooglePayPaymentMethodDataInfo info) {
    this.info = info;
  }

  public GooglePayPaymentMethodData tokenizationData(GooglePayPaymentMethodDataTokenizationData tokenizationData) {
    this.tokenizationData = tokenizationData;
    return this;
  }

  /**
   * The tokenization data for Google Pay.
   *
   * @return tokenizationData
   */
  public GooglePayPaymentMethodDataTokenizationData getTokenizationData() {
    return tokenizationData;
  }

  public void setTokenizationData(GooglePayPaymentMethodDataTokenizationData tokenizationData) {
    this.tokenizationData = tokenizationData;
  }

  public GooglePayPaymentMethodData type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentMethodData googlePayPaymentMethodData = (GooglePayPaymentMethodData) o;
    return Objects.equals(this.description, googlePayPaymentMethodData.description) &&
        Objects.equals(this.info, googlePayPaymentMethodData.info) &&
        Objects.equals(this.tokenizationData, googlePayPaymentMethodData.tokenizationData) &&
        Objects.equals(this.type, googlePayPaymentMethodData.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, info, tokenizationData, type);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentMethodData {\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    info: " + toIndentedString(info) + "\n"
        + "    tokenizationData: " + toIndentedString(tokenizationData) + "\n"
        + "    type: " + toIndentedString(type) + "\n"
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
   * {@code GooglePayPaymentMethodData} builder static inner class.
   */
  public static final class Builder {
    private String description;
    private GooglePayPaymentMethodDataInfo info;
    private String type;

    private Builder() {
    }

    /**
     * Sets the {@code description} and returns a reference to this Builder enabling method chaining.
     *
     * @param description the {@code description} to set
     * @return a reference to this Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Sets the {@code info} and returns a reference to this Builder enabling method chaining.
     *
     * @param info the {@code info} to set
     * @return a reference to this Builder
     */
    public Builder info(GooglePayPaymentMethodDataInfo info) {
      this.info = info;
      return this;
    }

    /**
     * Sets the {@code type} and returns a reference to this Builder enabling method chaining.
     *
     * @param type the {@code type} to set
     * @return a reference to this Builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Returns a {@code GooglePayPaymentMethodData} built from the parameters previously set.
     *
     * @return a {@code GooglePayPaymentMethodData} built with parameters of this {@code GooglePayPaymentMethodData.Builder}
     */
    public GooglePayPaymentMethodData build() {
      return new GooglePayPaymentMethodData(this);
    }
  }
}

