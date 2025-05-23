// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Customer's billing details
 */
public class CardBillingDetailsRequest {

  @JsonProperty("nickName")
  private String nickName;
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

  public CardBillingDetailsRequest() {
    super();
  }

  private CardBillingDetailsRequest(Builder builder) {
    setNickName(builder.nickName);
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

  public CardBillingDetailsRequest nickName(String nickName) {
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

  public CardBillingDetailsRequest street(String street) {
    this.street = street;
    return this;
  }

  /**
   * This is the first line of the customer's street address. <br>
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public CardBillingDetailsRequest street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * This is the second line of the street address, if required (e.g., apartment number).
   *
   * @return street2
   */
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public CardBillingDetailsRequest city(String city) {
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

  public CardBillingDetailsRequest state(String state) {
    this.state = state;
    return this;
  }

  /**
   * This is the state/province/region in which the  customer lives.
   * For Canada see (<a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes.</a>) <br>
   * For the United States see <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes.</a> <br>
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CardBillingDetailsRequest country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is the country where the address is located.
   *
   * @return country
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>List of possible country codes</a>
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CardBillingDetailsRequest zip(String zip) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardBillingDetailsRequest cardBillingDetailsRequest = (CardBillingDetailsRequest) o;
    return Objects.equals(this.nickName, cardBillingDetailsRequest.nickName) &&
        Objects.equals(this.street, cardBillingDetailsRequest.street) &&
        Objects.equals(this.street2, cardBillingDetailsRequest.street2) &&
        Objects.equals(this.city, cardBillingDetailsRequest.city) &&
        Objects.equals(this.state, cardBillingDetailsRequest.state) &&
        Objects.equals(this.country, cardBillingDetailsRequest.country) &&
        Objects.equals(this.zip, cardBillingDetailsRequest.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickName, street, street2, city, state, country, zip);
  }

  @Override
  public String toString() {

    return "class CardSimpleBillingDetailsRequest {\n"
        + "    nickName: " + toIndentedString(nickName) + "\n"
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
   * {@code CardSimpleBillingDetailsRequest} builder static inner class.
   */
  public static final class Builder {
    private String nickName;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zip;

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
     * Returns a {@code CardSimpleBillingDetailsRequest} built from the parameters previously set.
     *
     * @return a {@code CardSimpleBillingDetailsRequest} built with parameters of this {@code CardSimpleBillingDetailsRequest.Builder}
     */
    public CardBillingDetailsRequest build() {
      return new CardBillingDetailsRequest(this);
    }
  }
}

