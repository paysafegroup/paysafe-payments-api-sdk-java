// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the payment data object generated from the Android device for Google Pay.
 */
public class GooglePayDecryptedToken {

  @JsonProperty("gatewayMerchantId")
  private String gatewayMerchantId;
  @JsonProperty("messageId")
  private String messageId;
  @JsonProperty("messageExpiration")
  private String messageExpiration;
  @JsonProperty("paymentMethodDetails")
  private GooglePayDecryptedTokenPaymentMethodDetails paymentMethodDetails;

  public GooglePayDecryptedToken() {
    super();
  }

  private GooglePayDecryptedToken(Builder builder) {
    setGatewayMerchantId(builder.gatewayMerchantId);
    setMessageId(builder.messageId);
    setMessageExpiration(builder.messageExpiration);
    setPaymentMethodDetails(builder.paymentMethodDetails);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GooglePayDecryptedToken gatewayMerchantId(String gatewayMerchantId) {
    this.gatewayMerchantId = gatewayMerchantId;
    return this;
  }

  /**
   * Get gatewayMerchantId
   *
   * @return gatewayMerchantId
   */
  public String getGatewayMerchantId() {
    return gatewayMerchantId;
  }

  public void setGatewayMerchantId(String gatewayMerchantId) {
    this.gatewayMerchantId = gatewayMerchantId;
  }

  public GooglePayDecryptedToken messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  /**
   * Get messageId
   *
   * @return messageId
   */
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public GooglePayDecryptedToken messageExpiration(String messageExpiration) {
    this.messageExpiration = messageExpiration;
    return this;
  }

  /**
   * Get messageExpiration
   *
   * @return messageExpiration
   */
  public String getMessageExpiration() {
    return messageExpiration;
  }

  public void setMessageExpiration(String messageExpiration) {
    this.messageExpiration = messageExpiration;
  }

  public GooglePayDecryptedToken paymentMethodDetails(GooglePayDecryptedTokenPaymentMethodDetails paymentMethodDetails) {
    this.paymentMethodDetails = paymentMethodDetails;
    return this;
  }

  /**
   * Get paymentMethodDetails
   *
   * @return paymentMethodDetails
   */
  public GooglePayDecryptedTokenPaymentMethodDetails getPaymentMethodDetails() {
    return paymentMethodDetails;
  }

  public void setPaymentMethodDetails(GooglePayDecryptedTokenPaymentMethodDetails paymentMethodDetails) {
    this.paymentMethodDetails = paymentMethodDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayDecryptedToken googlePayDecryptedToken = (GooglePayDecryptedToken) o;
    return Objects.equals(this.gatewayMerchantId, googlePayDecryptedToken.gatewayMerchantId) &&
        Objects.equals(this.messageId, googlePayDecryptedToken.messageId) &&
        Objects.equals(this.messageExpiration, googlePayDecryptedToken.messageExpiration) &&
        Objects.equals(this.paymentMethodDetails, googlePayDecryptedToken.paymentMethodDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gatewayMerchantId, messageId, messageExpiration, paymentMethodDetails);
  }

  @Override
  public String toString() {

    return "class GooglePayDecryptedToken {\n"
        + "    gatewayMerchantId: " + toIndentedString(gatewayMerchantId) + "\n"
        + "    messageId: " + toIndentedString(messageId) + "\n"
        + "    messageExpiration: " + toIndentedString(messageExpiration) + "\n"
        + "    paymentMethodDetails: " + toIndentedString(paymentMethodDetails) + "\n"
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
   * {@code GooglePayDecryptedToken} builder static inner class.
   */
  public static final class Builder {
    private String gatewayMerchantId;
    private String messageId;
    private String messageExpiration;
    private GooglePayDecryptedTokenPaymentMethodDetails paymentMethodDetails;

    private Builder() {
    }

    /**
     * Sets the {@code gatewayMerchantId} and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayMerchantId the {@code gatewayMerchantId} to set
     * @return a reference to this Builder
     */
    public Builder gatewayMerchantId(String gatewayMerchantId) {
      this.gatewayMerchantId = gatewayMerchantId;
      return this;
    }

    /**
     * Sets the {@code messageId} and returns a reference to this Builder enabling method chaining.
     *
     * @param messageId the {@code messageId} to set
     * @return a reference to this Builder
     */
    public Builder messageId(String messageId) {
      this.messageId = messageId;
      return this;
    }

    /**
     * Sets the {@code messageExpiration} and returns a reference to this Builder enabling method chaining.
     *
     * @param messageExpiration the {@code messageExpiration} to set
     * @return a reference to this Builder
     */
    public Builder messageExpiration(String messageExpiration) {
      this.messageExpiration = messageExpiration;
      return this;
    }

    /**
     * Sets the {@code paymentMethodDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentMethodDetails the {@code paymentMethodDetails} to set
     * @return a reference to this Builder
     */
    public Builder paymentMethodDetails(GooglePayDecryptedTokenPaymentMethodDetails paymentMethodDetails) {
      this.paymentMethodDetails = paymentMethodDetails;
      return this;
    }

    /**
     * Returns a {@code GooglePayDecryptedToken} built from the parameters previously set.
     *
     * @return a {@code GooglePayDecryptedToken} built with parameters of this
     * {@code GooglePayDecryptedToken.Builder}
     */
    public GooglePayDecryptedToken build() {
      return new GooglePayDecryptedToken(this);
    }
  }
}

