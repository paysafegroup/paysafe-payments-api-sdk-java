// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.lpm.enums.CountryCode;
import com.paysafe.payments.model.lpm.enums.KeyLevelRestriction;

/**
 * These are the details of the paysafecard used for the transaction.
 */
public class Paysafecard {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("minAgeRestriction")
  private Long minAgeRestriction;
  @JsonProperty("kycLevelRestriction")
  private KeyLevelRestriction kycLevelRestriction;
  @JsonProperty("countryRestriction")
  private CountryCode countryRestriction;
  @JsonProperty("submerchantId")
  private String submerchantId;

  public Paysafecard() {
    super();
  }

  private Paysafecard(final Builder builder) {
    setConsumerId(builder.consumerId);
    setMinAgeRestriction(builder.minAgeRestriction);
    setKycLevelRestriction(builder.kycLevelRestriction);
    setCountryRestriction(builder.countryRestriction);
    setSubmerchantId(builder.submerchantId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Paysafecard consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the merchant's unique identifier of the customer. For security purposes, if any personal data is used
   * (for example, customer's user name, email address, etc.), it has to be encrypted or hashed. <b>Mandatory.</b>
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Paysafecard minAgeRestriction(Long minAgeRestriction) {
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

  public Paysafecard kycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
    return this;
  }

  /**
   * Payment can be restricted for a certain minimum kyc level (implicitly restricts payment to registered consumers only). Possible values are <br />
   * - FULL <br
   * - SIMPLE.
   *
   * @return kycLevelRestriction
   */
  public KeyLevelRestriction getKycLevelRestriction() {
    return kycLevelRestriction;
  }

  public void setKycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
  }

  public Paysafecard countryRestriction(CountryCode countryRestriction) {
    this.countryRestriction = countryRestriction;
    return this;
  }

  /**
   * This is the code of the country to which the transaction will be restricted. Optional.
   *
   * @return countryRestriction
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public CountryCode getCountryRestriction() {
    return countryRestriction;
  }

  public void setCountryRestriction(CountryCode countryRestriction) {
    this.countryRestriction = countryRestriction;
  }

  /**
   * The Submerchant Id (Reporting Criteria) is used to classify sub-merchants at PaysafeCard side.
   * @return submerchantId
   */
  public String getSubmerchantId() {
    return submerchantId;
  }

  public void setSubmerchantId(final String submerchantId) {
    this.submerchantId = submerchantId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paysafecard paysafecard = (Paysafecard) o;
    return Objects.equals(this.consumerId, paysafecard.consumerId) &&
        Objects.equals(this.minAgeRestriction, paysafecard.minAgeRestriction) &&
        Objects.equals(this.kycLevelRestriction, paysafecard.kycLevelRestriction) &&
        Objects.equals(this.countryRestriction, paysafecard.countryRestriction) &&
        Objects.equals(this.submerchantId, paysafecard.submerchantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, minAgeRestriction, kycLevelRestriction, countryRestriction, submerchantId);
  }

  @Override
  public String toString() {

    return "class Paysafecard {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    minAgeRestriction: " + toIndentedString(minAgeRestriction) + "\n"
        + "    kycLevelRestriction: " + toIndentedString(kycLevelRestriction) + "\n"
        + "    countryRestriction: " + toIndentedString(countryRestriction) + "\n"
        + "    submerchantId: " + toIndentedString(submerchantId) + "\n"
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
   * {@code Paysafecard} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private Long minAgeRestriction;
    private KeyLevelRestriction kycLevelRestriction;
    private CountryCode countryRestriction;
    private String submerchantId;

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
    public Builder countryRestriction(CountryCode countryRestriction) {
      this.countryRestriction = countryRestriction;
      return this;
    }

    /**
     * Sets the {@code submerchantId} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code submerchantId} to set
     * @return a reference to this Builder
     */
    public Builder submerchantId(final String val) {
      submerchantId = val;
      return this;
    }

    /**
     * Returns a {@code Paysafecard} built from the parameters previously set.
     *
     * @return a {@code Paysafecard} built with parameters of this {@code Paysafecard.Builder}
     */
    public Paysafecard build() {
      return new Paysafecard(this);
    }
  }
}

