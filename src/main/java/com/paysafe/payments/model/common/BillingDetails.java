// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Customer's billing details. Required if AVS (Address verification) is enabled.
 * If included in the request, this will serve as the billing address for transaction processing.
 * Any billing details returned in Apple Pay Token by Apple Pay will be ignored.
 * 3DS Flow: It is recommended to send billingDetails to improve acceptance rate.
 *
 * <ul>
 *   <li>
 *     <b>id:</b> This is the ID of the billing address, returned in the response.
 *   </li>
 *   <li>
 *     <b>city:</b> This is the city where the address is located.  <br>
 *     Example: Toronto
 *   </li>
 *   <li>
 *     <b>country:</b> This is the country where the address is located. See
 *     <a href="https://developer.paysafe.com/en/support/reference-information/codes/#country-codes">Country Codes</a> <br>
 *     Example: CA
 *   </li>
 *   <li>
 *     <b>nickName:</b> This is the nickname the merchant has for the billing address.  <br>
 *     Example: Home
 *   </li>
 *   <li>
 *     <b>state:</b> This is the state/province/region in which the customer lives.  <br>
 *     - For Canada see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes</a>
 *      <br>
 *     - For United States see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes</a>
 *      <br>
 *     - Other countries have no restrictions.  <br>
 *     - For 3DS flow: If billingDetails is provided and country is US or CA, then state is mandatory.  <br>
 *     Example: ON
 *   </li>
 *   <li>
 *     <b>street:</b> This is the first line of the customer's street address.  <br>
 *     Example: Street
 *   </li>
 *   <li>
 *     <b>street1:</b> This is the first line of the street address.  <br>
 *     <b>Note:</b> Mandatory for VIPPreferred  <br>
 *     Example: street1
 *   </li>
 *   <li>
 *     <b>street2:</b> This is the second line of the street address, if required (e.g., apartment number).  <br>
 *     Example: street2
 *   </li>
 *   <li>
 *     <b>zip:</b> This is the zip, postal, or post code of the customer's address.  <br>
 *     Example: M5H 2N2
 *   </li>
 *   <li>
 *     <b>phone:</b> This is the customer's telephone number.  <br>
 *     Example: 8765846321
 *   </li>
 *   <li>
 *     <b>error:</b> This contains error details.  <br>
 *   </li>
 * </ul>
 */
public class BillingDetails {

  @JsonProperty("nickName")
  private String nickName;
  @JsonProperty("street")
  private String street;
  @JsonProperty("street1")
  private String street1;
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
  @JsonProperty("phone")
  private String phone;

  public BillingDetails() {
    super();
  }

  private BillingDetails(Builder builder) {
    setNickName(builder.nickName);
    setStreet(builder.street);
    setStreet1(builder.street1);
    setStreet2(builder.street2);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
    setPhone(builder.phone);
  }

  public static Builder builder() {
    return new Builder();
  }

  public BillingDetails nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * This is the nickname the merchant has for the  billing address.
   *
   * @return nickName
   */
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public BillingDetails street(String street) {
    this.street = street;
    return this;
  }

  /**
   * This is the line of the customer's street address. <br>
   * If both street and street1 are sent then street1 is ignored.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public BillingDetails street1(String street1) {
    this.street1 = street1;
    return this;
  }

  /**
   * This is the first line of the customer's street address. <br>
   * If both street and street1 are sent then street1 is ignored.
   *
   * @return street1
   */
  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public BillingDetails street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * This is the second line of the street address, if required (e.g., apartment number).
   * If more than 15 characters are sent then address will be truncated to first 15 characters.
   *
   * @return street2
   */
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public BillingDetails city(String city) {
    this.city = city;
    return this;
  }

  /**
   * This is the city where the address is located.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public BillingDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * This is the state/province/region in which the  customer lives.
   * In 3DS flow, it is mandatory if country is US or CA.
   * For Canada see (<a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes.</a>) <br>
   * For the United States see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes.</a> <br>
   *  <br>
   * In cases when it is not mandatory, it is recommended to send billingDetails to improve acceptance rate.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public BillingDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is the country where the address is located.
   * SKRILL - Dummy value can be sent in request as this is not passed to Skrill.
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

  public BillingDetails zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * This is the zip, postal, or post code of the customer's address.
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public BillingDetails phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This is the customer's telephone number.
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingDetails billingDetails = (BillingDetails) o;
    return Objects.equals(this.nickName, billingDetails.nickName) &&
        Objects.equals(this.street, billingDetails.street) &&
        Objects.equals(this.street1, billingDetails.street1) &&
        Objects.equals(this.street2, billingDetails.street2) &&
        Objects.equals(this.city, billingDetails.city) &&
        Objects.equals(this.state, billingDetails.state) &&
        Objects.equals(this.country, billingDetails.country) &&
        Objects.equals(this.zip, billingDetails.zip) &&
        Objects.equals(this.phone, billingDetails.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickName, street, street1, street2, city, state, country, zip, phone);
  }

  @Override
  public String toString() {

    return "class BillingDetails {\n"
        + "    nickName: " + toIndentedString(nickName) + "\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    street1: " + toIndentedString(street1) + "\n"
        + "    street2: " + toIndentedString(street2) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
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
   * {@code BillingDetails} builder static inner class.
   */
  public static final class Builder {
    private String nickName;
    private String street;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;

    private Builder() {
    }

    /**
     * Sets the {@code nickName} and returns a reference to this Builder enabling method chaining.
     *
     * @param nickName the {@code nickName} to set
     * @return a reference to this Builder
     */
    public Builder nickName(String nickName) {
      this.nickName = nickName;
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
     * Sets the {@code street1} and returns a reference to this Builder enabling method chaining.
     *
     * @param street1 the {@code street1} to set
     * @return a reference to this Builder
     */
    public Builder street1(String street1) {
      this.street1 = street1;
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
     * Sets the {@code phone} and returns a reference to this Builder enabling method chaining.
     *
     * @param phone the {@code phone} to set
     * @return a reference to this Builder
     */
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    /**
     * Returns a {@code BillingDetails} built from the parameters previously set.
     *
     * @return a {@code BillingDetails} built with parameters of this {@code BillingDetails.Builder}
     */
    public BillingDetails build() {
      return new BillingDetails(this);
    }
  }
}

