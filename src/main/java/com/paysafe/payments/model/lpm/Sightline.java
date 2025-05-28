// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the Play+ (Sightline) used for the transaction.
 */
public class Sightline {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("ssn")
  private String ssn;
  @JsonProperty("last4ssn")
  private String last4ssn;
  @JsonProperty("lastDigits")
  private String lastDigits;

  public Sightline() {
    super();
  }

  private Sightline(Builder builder) {
    setConsumerId(builder.consumerId);
    setSsn(builder.ssn);
    setLast4ssn(builder.last4ssn);
    setLastDigits(builder.lastDigits);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Sightline consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the Loyalty Membership Number unique to the customer to be enrolled with Play+ (Sightline). This is to be provided by the merchant.  _Mandatory_
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Sightline ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }

  /**
   * This the customer's Social Security Number.
   *
   * @return ssn
   */
  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public Sightline last4ssn(String last4ssn) {
    this.last4ssn = last4ssn;
    return this;
  }

  /**
   * This the customer’s last 4 digits of Social Security Number.
   *
   * @return last4ssn
   */
  public String getLast4ssn() {
    return last4ssn;
  }

  public void setLast4ssn(String last4ssn) {
    this.last4ssn = last4ssn;
  }

  public Sightline lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * This the customer’s last 4 digits of Social Security Number.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sightline sightline = (Sightline) o;
    return Objects.equals(this.consumerId, sightline.consumerId) &&
        Objects.equals(this.ssn, sightline.ssn) &&
        Objects.equals(this.last4ssn, sightline.last4ssn) &&
        Objects.equals(this.lastDigits, sightline.lastDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, ssn, last4ssn, lastDigits);
  }

  @Override
  public String toString() {

    return "class Sightline {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    ssn: " + toIndentedString(ssn) + "\n"
        + "    last4ssn: " + toIndentedString(last4ssn) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
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
   * {@code Sightline} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String ssn;
    private String last4ssn;
    private String lastDigits;

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
     * Sets the {@code ssn} and returns a reference to this Builder enabling method chaining.
     *
     * @param ssn the {@code ssn} to set
     * @return a reference to this Builder
     */
    public Builder ssn(String ssn) {
      this.ssn = ssn;
      return this;
    }

    /**
     * Sets the {@code last4ssn} and returns a reference to this Builder enabling method chaining.
     *
     * @param last4ssn the {@code last4ssn} to set
     * @return a reference to this Builder
     */
    public Builder last4ssn(String last4ssn) {
      this.last4ssn = last4ssn;
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
     * Returns a {@code Sightline} built from the parameters previously set.
     *
     * @return a {@code Sightline} built with parameters of this {@code Sightline.Builder}
     */
    public Sightline build() {
      return new Sightline(this);
    }
  }
}

