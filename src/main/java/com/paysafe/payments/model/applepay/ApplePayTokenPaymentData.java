// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <b>Note:</b> If you want to pass encrypted Apple Pay token in paymentHandle API request then you must generate Payment Processing
 * Certificate through Paysafe Optic Portal. <br>
 * If you want to pass decrypted Apple Pay token in paymentHandle API request then you can skip Certificate generation through Paysafe
 * Optic Portal. <br>
 * In case of encrypted token, include fields version, data, signature and header. <br>
 * In case of decrypted token, include field decryptedData.
 */
public class ApplePayTokenPaymentData {

  @JsonProperty("version")
  private String version;
  @JsonProperty("data")
  private String data;
  @JsonProperty("signature")
  private String signature;
  @JsonProperty("header")
  private ApplePayTokenHeader header;
  @JsonProperty("decryptedData")
  private ApplePayDecryptedData decryptedData;

  public ApplePayTokenPaymentData() {
    super();
  }

  private ApplePayTokenPaymentData(Builder builder) {
    setVersion(builder.version);
    setData(builder.data);
    setSignature(builder.signature);
    setHeader(builder.header);
    setDecryptedData(builder.decryptedData);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayTokenPaymentData version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Version parameter of Apple Pay Token
   *
   * @return version
   */
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ApplePayTokenPaymentData data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Apple Pay data hash of customer card
   *
   * @return data
   */
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public ApplePayTokenPaymentData signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * Apple pay signature data
   *
   * @return signature
   */
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public ApplePayTokenPaymentData header(ApplePayTokenHeader header) {
    this.header = header;
    return this;
  }

  /**
   * Header parameter of Apple Pay Token
   *
   * @return header
   */
  public ApplePayTokenHeader getHeader() {
    return header;
  }

  public void setHeader(ApplePayTokenHeader header) {
    this.header = header;
  }

  public ApplePayTokenPaymentData decryptedData(ApplePayDecryptedData decryptedData) {
    this.decryptedData = decryptedData;
    return this;
  }

  /**
   * Get decryptedData
   *
   * @return decryptedData
   */
  public ApplePayDecryptedData getDecryptedData() {
    return decryptedData;
  }

  public void setDecryptedData(ApplePayDecryptedData decryptedData) {
    this.decryptedData = decryptedData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayTokenPaymentData applePayTokenPaymentData = (ApplePayTokenPaymentData) o;
    return Objects.equals(this.version, applePayTokenPaymentData.version) &&
        Objects.equals(this.data, applePayTokenPaymentData.data) &&
        Objects.equals(this.signature, applePayTokenPaymentData.signature) &&
        Objects.equals(this.header, applePayTokenPaymentData.header) &&
        Objects.equals(this.decryptedData, applePayTokenPaymentData.decryptedData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, data, signature, header, decryptedData);
  }

  @Override
  public String toString() {

    return "class ApplePayTokenPaymentData {\n"
        + "    version: " + toIndentedString(version) + "\n"
        + "    data: " + toIndentedString(data) + "\n"
        + "    signature: " + toIndentedString(signature) + "\n"
        + "    header: " + toIndentedString(header) + "\n"
        + "    decryptedData: " + toIndentedString(decryptedData) + "\n"
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
   * {@code ApplePayTokenPaymentData} builder static inner class.
   */
  public static final class Builder {
    private String version;
    private String data;
    private String signature;
    private ApplePayTokenHeader header;
    private ApplePayDecryptedData decryptedData;

    private Builder() {
    }

    /**
     * Sets the {@code version} and returns a reference to this Builder enabling method chaining.
     *
     * @param version the {@code version} to set
     * @return a reference to this Builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Sets the {@code data} and returns a reference to this Builder enabling method chaining.
     *
     * @param data the {@code data} to set
     * @return a reference to this Builder
     */
    public Builder data(String data) {
      this.data = data;
      return this;
    }

    /**
     * Sets the {@code signature} and returns a reference to this Builder enabling method chaining.
     *
     * @param signature the {@code signature} to set
     * @return a reference to this Builder
     */
    public Builder signature(String signature) {
      this.signature = signature;
      return this;
    }

    /**
     * Sets the {@code header} and returns a reference to this Builder enabling method chaining.
     *
     * @param header the {@code header} to set
     * @return a reference to this Builder
     */
    public Builder header(ApplePayTokenHeader header) {
      this.header = header;
      return this;
    }

    /**
     * Sets the {@code decryptedData} and returns a reference to this Builder enabling method chaining.
     *
     * @param decryptedData the {@code decryptedData} to set
     * @return a reference to this Builder
     */
    public Builder decryptedData(ApplePayDecryptedData decryptedData) {
      this.decryptedData = decryptedData;
      return this;
    }

    /**
     * Returns a {@code ApplePayTokenPaymentData} built from the parameters previously set.
     *
     * @return a {@code ApplePayTokenPaymentData} built with parameters of this {@code ApplePayTokenPaymentData.Builder}
     */
    public ApplePayTokenPaymentData build() {
      return new ApplePayTokenPaymentData(this);
    }
  }
}

