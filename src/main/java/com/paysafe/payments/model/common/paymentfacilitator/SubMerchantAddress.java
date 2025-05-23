// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.paymentfacilitator;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains information for Payment facilitator sub-merchant address.  <br>
 * <b>Note:</b> This object is only for Payment facilitator merchants.
 */
public class SubMerchantAddress {

  @JsonProperty("street")
  private String street;
  @JsonProperty("city")
  private String city;
  @JsonProperty("state")
  private String state;
  @JsonProperty("country")
  private String country;
  @JsonProperty("zip")
  private String zip;

  public SubMerchantAddress() {
    super();
  }

  private SubMerchantAddress(Builder builder) {
    setStreet(builder.street);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SubMerchantAddress street(String street) {
    this.street = street;
    return this;
  }

  /**
   * This field must contain the street address of the actual merchant.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public SubMerchantAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * This field must contain the city of the actual merchant.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public SubMerchantAddress state(String state) {
    this.state = state;
    return this;
  }

  /**
   * See <a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes</a>
   * or <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes</a> for Canada or the United States.
   * For other countries, see <a href="https://en.wikipedia.org/wiki/ISO_3166-2">ISO 3166-2.</a> <br>
   * For transactions with American Express cards, the state/province/region is mandatory.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public SubMerchantAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is the country where the address is located.
   *
   * @return country
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>   *
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public SubMerchantAddress zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * This field must contain the postal code of the actual merchant.
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubMerchantAddress SubMerchantAddress = (SubMerchantAddress) o;
    return Objects.equals(this.street, SubMerchantAddress.street) &&
        Objects.equals(this.city, SubMerchantAddress.city) &&
        Objects.equals(this.state, SubMerchantAddress.state) &&
        Objects.equals(this.country, SubMerchantAddress.country) &&
        Objects.equals(this.zip, SubMerchantAddress.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, country, zip);
  }

  @Override
  public String toString() {

    return "class SubMerchantAddress {\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
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
   * {@code SubMerchantAddress} builder static inner class.
   */
  public static final class Builder {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;

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
     * Sets the {@code city} and returns a reference to this Builder enabling method chaining.
     *
     * @param city the {@code city} to set
     * @return a reference to this Builder
     */
    public Builder city(String city) {
      this.city = city;
      return this;
    }

    /**
     * Sets the {@code state} and returns a reference to this Builder enabling method chaining.
     *
     * @param state the {@code state} to set
     * @return a reference to this Builder
     */
    public Builder state(String state) {
      this.state = state;
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
     * Returns a {@code SubMerchantAddress} built from the parameters previously set.
     *
     * @return a {@code SubMerchantAddress} built with parameters of this {@code SubMerchantAddress.Builder}
     */
    public SubMerchantAddress build() {
      return new SubMerchantAddress(this);
    }
  }
}
