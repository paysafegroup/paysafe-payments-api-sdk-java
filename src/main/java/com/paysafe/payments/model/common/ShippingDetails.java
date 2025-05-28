// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.ShipMethod;

/**
 * Details about shipping
 * <ul>
 *   <li>
 *     <b>shipMethod:</b> This is the method of shipment.  <br>
 *     <i>Allowed values: N, T, C, O, S</i>
 *   </li>
 *   <li>
 *     <b>street:</b> This is the recipient's street address.  <br>
 *     Example: 20735 Stevens Creek Blvd
 *   </li>
 *   <li>
 *     <b>street2:</b> This is the second line of the street address in the shipping address, if required (e.g., apartment number).  <br>
 *     Example: Montessori
 *   </li>
 *   <li>
 *     <b>city:</b> This is the city in which the recipient resides.  <br>
 *     Example: Cupertino
 *   </li>
 *   <li>
 *     <b>state:</b> This is the state/province/region in which the recipient lives.  <br>
 *     - For Canada see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes;</a>
 *      <br>
 *     - For the United States see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes;</a>
 *      <br>
 *     - Other countries have no restrictions.  <br>
 *     Example: ON
 *   </li>
 *   <li>
 *     <b>countries:</b> This is the country where the address is located.  <br>
 *     See <a href="https://developer.paysafe.com/en/support/reference-information/codes/#country-codes">Country Codes.</a>  <br>
 *     Example: CA
 *   </li>
 *   <li>
 *     <b>zip:</b> This is the recipient's postal/zip code.  <br>
 *     Example: 95014
 *   </li>
 * </ul>
 */
public class ShippingDetails {

  @JsonProperty("shipMethod")
  private ShipMethod shipMethod;
  @JsonProperty("street")
  private String street;
  @JsonProperty("street2")
  private String street2;
  @JsonProperty("city")
  private String city;
  @JsonProperty("state")
  private String state;
  @JsonProperty("country")
  private String country;
  @JsonProperty("zip")
  private String zip;

  public ShippingDetails() {
    super();
  }

  private ShippingDetails(Builder builder) {
    setShipMethod(builder.shipMethod);
    setStreet(builder.street);
    setStreet2(builder.street2);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ShippingDetails shipMethod(ShipMethod shipMethod) {
    this.shipMethod = shipMethod;
    return this;
  }

  /**
   * This is the method of shipment. Possible values are:    - N – Next Day/Overnight   - T – Two-Day Service   - C – Lowest Cost   - O – Other   - S – Same Day
   *
   * @return shipMethod
   */
  public ShipMethod getShipMethod() {
    return shipMethod;
  }

  public void setShipMethod(ShipMethod shipMethod) {
    this.shipMethod = shipMethod;
  }

  public ShippingDetails street(String street) {
    this.street = street;
    return this;
  }

  /**
   * This is the recipient's street address.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public ShippingDetails street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * This is the second line of the street address in the shipping address, if required (e.g., apartment number).
   *
   * @return street2
   */
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public ShippingDetails city(String city) {
    this.city = city;
    return this;
  }

  /**
   * This is the city in which the recipient resides.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ShippingDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * This is the state/province/region in which the recipient lives.
   * For Canada see (<a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes.</a>) <br>
   * For the United States see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes.</a> <br>
   * Other countries have no restrictions.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ShippingDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is the country where the address is located.
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

  public ShippingDetails zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * This is the recipient's postal/zip code.
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
    ShippingDetails shippingDetails = (ShippingDetails) o;
    return Objects.equals(this.shipMethod, shippingDetails.shipMethod) &&
        Objects.equals(this.street, shippingDetails.street) &&
        Objects.equals(this.street2, shippingDetails.street2) &&
        Objects.equals(this.city, shippingDetails.city) &&
        Objects.equals(this.state, shippingDetails.state) &&
        Objects.equals(this.country, shippingDetails.country) &&
        Objects.equals(this.zip, shippingDetails.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipMethod, street, street2, city, state, country, zip);
  }

  @Override
  public String toString() {

    return "class ShippingDetails {\n"
        + "    shipMethod: " + toIndentedString(shipMethod) + "\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    street2: " + toIndentedString(street2) + "\n"
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
   * {@code ShippingDetails} builder static inner class.
   */
  public static final class Builder {
    private ShipMethod shipMethod;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zip;

    private Builder() {
    }

    /**
     * Sets the {@code shipMethod} and returns a reference to this Builder enabling method chaining.
     *
     * @param shipMethod the {@code shipMethod} to set
     * @return a reference to this Builder
     */
    public Builder shipMethod(ShipMethod shipMethod) {
      this.shipMethod = shipMethod;
      return this;
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
     * Sets the {@code street2} and returns a reference to this Builder enabling method chaining.
     *
     * @param street2 the {@code street2} to set
     * @return a reference to this Builder
     */
    public Builder street2(String street2) {
      this.street2 = street2;
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
     * Returns a {@code ShippingDetails} built from the parameters previously set.
     *
     * @return a {@code ShippingDetails} built with parameters of this {@code ShippingDetails.Builder}
     */
    public ShippingDetails build() {
      return new ShippingDetails(this);
    }
  }
}

