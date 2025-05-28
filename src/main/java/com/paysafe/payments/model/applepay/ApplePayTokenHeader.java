// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Header parameter of Apple Pay Token
 */
public class ApplePayTokenHeader {

  @JsonProperty("transactionId")
  private String transactionId;
  @JsonProperty("ephemeralPublicKey")
  private String ephemeralPublicKey;
  @JsonProperty("publicKeyHash")
  private String publicKeyHash;

  public ApplePayTokenHeader() {
    super();
  }

  private ApplePayTokenHeader(Builder builder) {
    setTransactionId(builder.transactionId);
    setEphemeralPublicKey(builder.ephemeralPublicKey);
    setPublicKeyHash(builder.publicKeyHash);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayTokenHeader transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Returned by Apple Pay
   *
   * @return transactionId
   */
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public ApplePayTokenHeader ephemeralPublicKey(String ephemeralPublicKey) {
    this.ephemeralPublicKey = ephemeralPublicKey;
    return this;
  }

  /**
   * Returned by Apple Pay
   *
   * @return ephemeralPublicKey
   */
  public String getEphemeralPublicKey() {
    return ephemeralPublicKey;
  }

  public void setEphemeralPublicKey(String ephemeralPublicKey) {
    this.ephemeralPublicKey = ephemeralPublicKey;
  }

  public ApplePayTokenHeader publicKeyHash(String publicKeyHash) {
    this.publicKeyHash = publicKeyHash;
    return this;
  }

  /**
   * Returned by Apple Pay
   *
   * @return publicKeyHash
   */
  public String getPublicKeyHash() {
    return publicKeyHash;
  }

  public void setPublicKeyHash(String publicKeyHash) {
    this.publicKeyHash = publicKeyHash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayTokenHeader applePayTokenHeader = (ApplePayTokenHeader) o;
    return Objects.equals(this.transactionId, applePayTokenHeader.transactionId) &&
        Objects.equals(this.ephemeralPublicKey, applePayTokenHeader.ephemeralPublicKey) &&
        Objects.equals(this.publicKeyHash, applePayTokenHeader.publicKeyHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, ephemeralPublicKey, publicKeyHash);
  }

  @Override
  public String toString() {

    return "class ApplePayTokenHeader {\n"
        + "    transactionId: " + toIndentedString(transactionId) + "\n"
        + "    ephemeralPublicKey: " + toIndentedString(ephemeralPublicKey) + "\n"
        + "    publicKeyHash: " + toIndentedString(publicKeyHash) + "\n"
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
   * {@code ApplePayTokenHeader} builder static inner class.
   */
  public static final class Builder {
    private String transactionId;
    private String ephemeralPublicKey;
    private String publicKeyHash;

    private Builder() {
    }

    /**
     * Sets the {@code transactionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionId the {@code transactionId} to set
     * @return a reference to this Builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Sets the {@code ephemeralPublicKey} and returns a reference to this Builder enabling method chaining.
     *
     * @param ephemeralPublicKey the {@code ephemeralPublicKey} to set
     * @return a reference to this Builder
     */
    public Builder ephemeralPublicKey(String ephemeralPublicKey) {
      this.ephemeralPublicKey = ephemeralPublicKey;
      return this;
    }

    /**
     * Sets the {@code publicKeyHash} and returns a reference to this Builder enabling method chaining.
     *
     * @param publicKeyHash the {@code publicKeyHash} to set
     * @return a reference to this Builder
     */
    public Builder publicKeyHash(String publicKeyHash) {
      this.publicKeyHash = publicKeyHash;
      return this;
    }

    /**
     * Returns a {@code ApplePayTokenHeader} built from the parameters previously set.
     *
     * @return a {@code ApplePayTokenHeader} built with parameters of this {@code ApplePayTokenHeader.Builder}
     */
    public ApplePayTokenHeader build() {
      return new ApplePayTokenHeader(this);
    }
  }
}

