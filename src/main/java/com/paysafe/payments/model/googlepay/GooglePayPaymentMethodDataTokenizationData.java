// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The tokenization data for Google Pay.
 */
public class GooglePayPaymentMethodDataTokenizationData {

  @JsonProperty("token")
  private String token;
  @JsonProperty("type")
  private String type;
  @JsonProperty("decryptedToken")
  private GooglePayDecryptedToken decryptedToken;

  public GooglePayPaymentMethodDataTokenizationData() {
    super();
  }

  private GooglePayPaymentMethodDataTokenizationData(Builder builder) {
    setToken(builder.token);
    setType(builder.type);
    setDecryptedToken(builder.decryptedToken);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GooglePayPaymentMethodDataTokenizationData token(String token) {
    this.token = token;
    return this;
  }

  /**
   * This object contains the user's payment credentials.
   *
   * @return token
   */
  public Object getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public GooglePayPaymentMethodDataTokenizationData type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type property of Google Pay Payment Method.
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GooglePayPaymentMethodDataTokenizationData decryptedToken(GooglePayDecryptedToken decryptedToken) {
    this.decryptedToken = decryptedToken;
    return this;
  }

  /**
   * This is the payment data object generated from the Android device for Google Pay.
   *
   * @return decryptedToken
   */
  public GooglePayDecryptedToken getDecryptedToken() {
    return decryptedToken;
  }

  public void setDecryptedToken(GooglePayDecryptedToken decryptedToken) {
    this.decryptedToken = decryptedToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentMethodDataTokenizationData GooglePayPaymentMethodDataTokenizationData = (GooglePayPaymentMethodDataTokenizationData) o;
    return Objects.equals(this.token, GooglePayPaymentMethodDataTokenizationData.token) &&
        Objects.equals(this.type, GooglePayPaymentMethodDataTokenizationData.type) &&
        Objects.equals(this.decryptedToken, GooglePayPaymentMethodDataTokenizationData.decryptedToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, type, decryptedToken);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentMethodDataTokenizationData {\n"
        + "    token: " + toIndentedString(token) + "\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    decryptedToken: " + toIndentedString(decryptedToken) + "\n"
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
   * {@code GooglePayPaymentMethodDataTokenizationData} builder static inner class.
   */
  public static final class Builder {
    private String token;
    private String type;
    private GooglePayDecryptedToken decryptedToken;

    private Builder() {
    }

    /**
     * Sets the {@code token} and returns a reference to this Builder enabling method chaining.
     *
     * @param token the {@code token} to set
     * @return a reference to this Builder
     */
    public Builder token(String token) {
      this.token = token;
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
     * Sets the {@code decryptedToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param decryptedToken the {@code decryptedToken} to set
     * @return a reference to this Builder
     */
    public Builder decryptedToken(GooglePayDecryptedToken decryptedToken) {
      this.decryptedToken = decryptedToken;
      return this;
    }

    /**
     * Returns a {@code GooglePayPaymentMethodDataTokenizationData} built from the parameters previously set.
     *
     * @return a {@code GooglePayPaymentMethodDataTokenizationData} built with parameters of this {@code GooglePayPaymentMethodDataTokenizationData.Builder}
     */
    public GooglePayPaymentMethodDataTokenizationData build() {
      return new GooglePayPaymentMethodDataTokenizationData(this);
    }
  }
}

