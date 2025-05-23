// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.lpm.enums.KeyLevelRestriction;

/**
 * These are the details of the paysafecash account used for the transaction.
 */
public class Paysafecash {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("minAgeRestriction")
  private Long minAgeRestriction;
  @JsonProperty("kycLevelRestriction")
  private KeyLevelRestriction kycLevelRestriction;
  @JsonProperty("countryRestriction")
  private String countryRestriction;
  @JsonProperty("expirationTime")
  private Long expirationTime;

  public Paysafecash() {
    super();
  }

  private Paysafecash(Builder builder) {
    setConsumerId(builder.consumerId);
    setMinAgeRestriction(builder.minAgeRestriction);
    setKycLevelRestriction(builder.kycLevelRestriction);
    setCountryRestriction(builder.countryRestriction);
    setExpirationTime(builder.expirationTime);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Paysafecash consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the merchant's unique identifier of the customer. For security purposes, if any personal data is used (for example, customer's user name,
   * email address, etc.), it has to be encrypted or hashed. Mandatory.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Paysafecash minAgeRestriction(Long minAgeRestriction) {
    this.minAgeRestriction = minAgeRestriction;
    return this;
  }

  /**
   * payment can be restricted for a certain minimum consumer age (implicitly restricts payment to registered consumers only)
   *
   * @return minAgeRestriction
   */
  public Long getMinAgeRestriction() {
    return minAgeRestriction;
  }

  public void setMinAgeRestriction(Long minAgeRestriction) {
    this.minAgeRestriction = minAgeRestriction;
  }

  public Paysafecash kycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
    return this;
  }

  /**
   * Payment can be restricted for a certain minimum kyc level (implicitly restricts payment to registered consumers only).
   * @return kycLevelRestriction
   */
  public KeyLevelRestriction getKycLevelRestriction() {
    return kycLevelRestriction;
  }

  public void setKycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
  }

  public Paysafecash countryRestriction(String countryRestriction) {
    this.countryRestriction = countryRestriction;
    return this;
  }

  /**
   * This is the code of the country to which the transaction will be restricted.
   *
   * @return countryRestriction
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>  _Optional, length=2_
   */
  public String getCountryRestriction() {
    return countryRestriction;
  }

  public void setCountryRestriction(String countryRestriction) {
    this.countryRestriction = countryRestriction;
  }

  public Paysafecash expirationTime(Long expirationTime) {
    this.expirationTime = expirationTime;
    return this;
  }

  /**
   * This is barcode expiration time in minutes at Paysafecash end.  <br>
   * Minimum: 5
   *
   * @return expirationTime
   */
  public Long getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(Long expirationTime) {
    this.expirationTime = expirationTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paysafecash paysafecash = (Paysafecash) o;
    return Objects.equals(this.consumerId, paysafecash.consumerId) &&
        Objects.equals(this.minAgeRestriction, paysafecash.minAgeRestriction) &&
        Objects.equals(this.kycLevelRestriction, paysafecash.kycLevelRestriction) &&
        Objects.equals(this.countryRestriction, paysafecash.countryRestriction) &&
        Objects.equals(this.expirationTime, paysafecash.expirationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, minAgeRestriction, kycLevelRestriction, countryRestriction, expirationTime);
  }

  @Override
  public String toString() {

    return "class Paysafecash {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    minAgeRestriction: " + toIndentedString(minAgeRestriction) + "\n"
        + "    kycLevelRestriction: " + toIndentedString(kycLevelRestriction) + "\n"
        + "    countryRestriction: " + toIndentedString(countryRestriction) + "\n"
        + "    expirationTime: " + toIndentedString(expirationTime) + "\n"
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
   * {@code Paysafecash} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private Long minAgeRestriction;
    private KeyLevelRestriction kycLevelRestriction;
    private String countryRestriction;
    private Long expirationTime;

    private Builder() {
    }

    /**
     * Sets the {@code consumerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the {@code consumerId} to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * Sets the {@code minAgeRestriction} and returns a reference to this Builder enabling method chaining.
     *
     * @param minAgeRestriction the {@code minAgeRestriction} to set
     * @return a reference to this Builder
     */
    public Builder minAgeRestriction(Long minAgeRestriction) {
      this.minAgeRestriction = minAgeRestriction;
      return this;
    }

    /**
     * Sets the {@code kycLevelRestriction} and returns a reference to this Builder enabling method chaining.
     *
     * @param kycLevelRestriction the {@code kycLevelRestriction} to set
     * @return a reference to this Builder
     */
    public Builder kycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
      this.kycLevelRestriction = kycLevelRestriction;
      return this;
    }

    /**
     * Sets the {@code countryRestriction} and returns a reference to this Builder enabling method chaining.
     *
     * @param countryRestriction the {@code countryRestriction} to set
     * @return a reference to this Builder
     */
    public Builder countryRestriction(String countryRestriction) {
      this.countryRestriction = countryRestriction;
      return this;
    }

    /**
     * Sets the {@code expirationTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationTime the {@code expirationTime} to set
     * @return a reference to this Builder
     */
    public Builder expirationTime(Long expirationTime) {
      this.expirationTime = expirationTime;
      return this;
    }

    /**
     * Returns a {@code Paysafecash} built from the parameters previously set.
     *
     * @return a {@code Paysafecash} built with parameters of this {@code Paysafecash.Builder}
     */
    public Paysafecash build() {
      return new Paysafecash(this);
    }
  }
}

