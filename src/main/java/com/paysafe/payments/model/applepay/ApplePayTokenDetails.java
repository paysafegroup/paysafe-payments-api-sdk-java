// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.TokenExpiry;
import com.paysafe.payments.model.card.enums.TokenStatus;

/**
 * Apple Pay token information. Returned when the stored payment method is an Apple Pay token. <br>
 * <ul>
 *   <li>
 *     <b>bin:</b> The first 6 digits of the Apple Pay's DPAN (Device Primary Account Number) - Bank Identification Number (BIN) <br>
 *     Example: 411111
 *   </li>
 *   <li>
 *     <b>lastDigits:</b> This is the last digits of the Apple Pay's token.
 *   </li>
 *   <li>
 *     <b>expiry:</b> This is the expiry date of the DPAN (the token). <br>
 *   </li>
 *   <li>
 *     <b>status:</b> This is the status of the token. <br>
 *     <i>Allowed values: ACTIVE, EXPIRED, DISABLED</i>
 *   </li>
 * </ul>
 */
public class ApplePayTokenDetails {

  @JsonProperty("bin")
  private String bin;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("expiry")
  private TokenExpiry expiry;
  @JsonProperty("status")
  private TokenStatus status;

  public ApplePayTokenDetails() {
    super();
  }

  private ApplePayTokenDetails(Builder builder) {
    setBin(builder.bin);
    setLastDigits(builder.lastDigits);
    setExpiry(builder.expiry);
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayTokenDetails bin(String bin) {
    this.bin = bin;
    return this;
  }

  /**
   * The first 6 digits of the Apple Pay's DPAN (Device Primary Account Number) - Bank Identification Number (BIN)
   *
   * @return bin
   */
  public String getBin() {
    return bin;
  }

  public void setBin(String bin) {
    this.bin = bin;
  }

  public ApplePayTokenDetails lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * This is the last digits of the Apple Pay's token.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  public ApplePayTokenDetails expiry(TokenExpiry expiry) {
    this.expiry = expiry;
    return this;
  }

  /**
   * This is the token's expiry date.
   *
   * @return expiry
   */
  public TokenExpiry getExpiry() {
    return expiry;
  }

  public void setExpiry(TokenExpiry expiry) {
    this.expiry = expiry;
  }

  public ApplePayTokenDetails status(TokenStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the token.
   *
   * @return status
   */
  public TokenStatus getStatus() {
    return status;
  }

  public void setStatus(TokenStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayTokenDetails applePayTokenDetails = (ApplePayTokenDetails) o;
    return Objects.equals(this.bin, applePayTokenDetails.bin) &&
        Objects.equals(this.lastDigits, applePayTokenDetails.lastDigits) &&
        Objects.equals(this.expiry, applePayTokenDetails.expiry) &&
        Objects.equals(this.status, applePayTokenDetails.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bin, lastDigits, expiry, status);
  }

  @Override
  public String toString() {

    return "class ApplePayTokenDetails {\n"
        + "    bin: " + toIndentedString(bin) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    expiry: " + toIndentedString(expiry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * {@code ApplePayTokenDetails} builder static inner class.
   */
  public static final class Builder {
    private String bin;
    private String lastDigits;
    private TokenExpiry expiry;
    private TokenStatus status;

    private Builder() {
    }

    /**
     * Sets the {@code bin} and returns a reference to this Builder enabling method chaining.
     *
     * @param bin the {@code bin} to set
     * @return a reference to this Builder
     */
    public Builder bin(String bin) {
      this.bin = bin;
      return this;
    }

    /**
     * Sets the {@code lastDigits} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the {@code lastDigits} to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * Sets the {@code expiry} and returns a reference to this Builder enabling method chaining.
     *
     * @param expiry the {@code expiry} to set
     * @return a reference to this Builder
     */
    public Builder expiry(TokenExpiry expiry) {
      this.expiry = expiry;
      return this;
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(TokenStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Returns a {@code ApplePayTokenDetails} built from the parameters previously set.
     *
     * @return a {@code ApplePayTokenDetails} built with parameters of this {@code ApplePayTokenDetails.Builder}
     */
    public ApplePayTokenDetails build() {
      return new ApplePayTokenDetails(this);
    }
  }
}

