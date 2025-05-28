// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the rapid transfer used for the transaction.
 */
public class RapidTransfer {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("countryCode")
  private String countryCode;

  public RapidTransfer() {
    super();
  }

  private RapidTransfer(Builder builder) {
    setConsumerId(builder.consumerId);
    setCountryCode(builder.countryCode);
  }

  public static Builder builder() {
    return new Builder();
  }

  public RapidTransfer consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * Customer/end-user email id which will be the unique identifier of the user at Skrill end
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public RapidTransfer countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Two-digit unique country code to identify the area of operation of bank account and currency.
   *
   * @return countryCode
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RapidTransfer rapidTransfer = (RapidTransfer) o;
    return Objects.equals(this.consumerId, rapidTransfer.consumerId) &&
        Objects.equals(this.countryCode, rapidTransfer.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, countryCode);
  }

  @Override
  public String toString() {

    return "class RapidTransfer {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    countryCode: " + toIndentedString(countryCode) + "\n"
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
   * {@code RapidTransfer} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String countryCode;

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
     * Sets the {@code countryCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param countryCode the {@code countryCode} to set
     * @return a reference to this Builder
     */
    public Builder countryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Returns a {@code RapidTransfer} built from the parameters previously set.
     *
     * @return a {@code RapidTransfer} built with parameters of this {@code RapidTransfer.Builder}
     */
    public RapidTransfer build() {
      return new RapidTransfer(this);
    }
  }
}

