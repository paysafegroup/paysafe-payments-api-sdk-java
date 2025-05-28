// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The travel agency address
 */
public class AgencyAddress {

  @JsonProperty("street")
  private String street;

  @JsonProperty("zip")
  private String zip;

  @JsonProperty("country")
  private String country;

  public AgencyAddress() {
    super();
  }

  private AgencyAddress(Builder builder) {
    setStreet(builder.street);
    setZip(builder.zip);
    setCountry(builder.country);
  }

  public static Builder builder() {
    return new Builder();
  }

  public AgencyAddress street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Address line of the agent selling the ticket.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public AgencyAddress zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * Postal code of the agent selling the ticket.
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public AgencyAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * ISO Country code of agent selling the ticket.
   *
   * @return country
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgencyAddress agencyAddress = (AgencyAddress) o;
    return Objects.equals(this.street, agencyAddress.street) &&
        Objects.equals(this.zip, agencyAddress.zip) &&
        Objects.equals(this.country, agencyAddress.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, zip, country);
  }

  @Override
  public String toString() {

    return "class AgencyAddress {\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
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
   * {@code AgencyAddress} builder static inner class.
   */
  public static final class Builder {
    private String street;
    private String zip;
    private String country;

    private Builder() {
    }

    /**
     * Sets the {@code street} and returns a reference to this Builder enabling method chaining.
     *
     * @param street the {@code street} to set
     * @return a reference to this Builder
     */
    public Builder street(String street) {
      this.street = street;
      return this;
    }

    /**
     * Sets the {@code zip} and returns a reference to this Builder enabling method chaining.
     *
     * @param zip the {@code zip} to set
     * @return a reference to this Builder
     */
    public Builder zip(String zip) {
      this.zip = zip;
      return this;
    }

    /**
     * Sets the {@code country} and returns a reference to this Builder enabling method chaining.
     *
     * @param country the {@code country} to set
     * @return a reference to this Builder
     */
    public Builder country(String country) {
      this.country = country;
      return this;
    }

    /**
     * Returns a {@code AgencyAddress} built from the parameters previously set.
     *
     * @return a {@code AgencyAddress} built with parameters of this {@code AgencyAddress.Builder}
     */
    public AgencyAddress build() {
      return new AgencyAddress(this);
    }
  }
}

