// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.carrental;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains return details information for car rental  <b>Note:</b> This object is only for Car Rental Merchants.
 */
public class CarRentalReturnDetails {

  @JsonProperty("date")
  private String date;
  @JsonProperty("time")
  private String time;
  @JsonProperty("location")
  private String location;
  @JsonProperty("country")
  private String country;
  @JsonProperty("city")
  private String city;
  @JsonProperty("state")
  private String state;

  public CarRentalReturnDetails() {
    super();
  }

  private CarRentalReturnDetails(Builder builder) {
    setDate(builder.date);
    setTime(builder.time);
    setLocation(builder.location);
    setCountry(builder.country);
    setCity(builder.city);
    setState(builder.state);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CarRentalReturnDetails date(String date) {
    this.date = date;
    return this;
  }

  /**
   * The last date to return the car by. Date format = YYYY-MM-DD, ISO 8601 expected. UTC Date Format.
   * Required during authorization request with Visa for integration with TSYS processor.  <br>
   * Required during settlement request for integration with TSYS processor.
   *
   * @return date
   */
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public CarRentalReturnDetails time(String time) {
    this.time = time;
    return this;
  }

  /**
   * The local date and time when the vehicle was rented and/or picked up. Date format = YYYY-MM-DDTHH:MM:SSZ, ISO 8601 expected.  <br>
   * Required during settlement request with Amex for integration with TSYS processor.
   *
   * @return time
   */
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public CarRentalReturnDetails location(String location) {
    this.location = location;
    return this;
  }

  /**
   * The agency code, phone number, or address abbreviation.
   * Required during settlement request with Mastercard for integration with TSYS processor.
   *
   * @return location
   */
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public CarRentalReturnDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The country of the location where the vehicle must be returned.
   * Required during settlement request with Mastercard or Amex for integration with TSYS processor.
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CarRentalReturnDetails city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The name of the city, town, or village where the vehicle must be returned.
   * Required during settlement request with Mastercard or Amex for integration with TSYS processor.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public CarRentalReturnDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The region code that corresponds to the state, province, or other country subdivision where the vehicle must be returned.
   * See <a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes</a>
   * or <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes</a> for Canada or the United States.
   *  <br>
   * Required during settlement request with Amex for integration with TSYS processor.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarRentalReturnDetails carRentalReturnDetails = (CarRentalReturnDetails) o;
    return Objects.equals(this.date, carRentalReturnDetails.date) &&
        Objects.equals(this.time, carRentalReturnDetails.time) &&
        Objects.equals(this.location, carRentalReturnDetails.location) &&
        Objects.equals(this.country, carRentalReturnDetails.country) &&
        Objects.equals(this.city, carRentalReturnDetails.city) &&
        Objects.equals(this.state, carRentalReturnDetails.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, time, location, country, city, state);
  }

  @Override
  public String toString() {

    return "class CarRentalReturnDetails {\n"
        + "    date: " + toIndentedString(date) + "\n"
        + "    time: " + toIndentedString(time) + "\n"
        + "    location: " + toIndentedString(location) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
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
   * {@code CarRentalReturnDetails} builder static inner class.
   */
  public static final class Builder {
    private String date;
    private String time;
    private String location;
    private String country;
    private String city;
    private String state;

    private Builder() {
    }

    /**
     * Sets the {@code date} and returns a reference to this Builder enabling method chaining.
     *
     * @param date the {@code date} to set
     * @return a reference to this Builder
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }

    /**
     * Sets the {@code time} and returns a reference to this Builder enabling method chaining.
     *
     * @param time the {@code time} to set
     * @return a reference to this Builder
     */
    public Builder time(String time) {
      this.time = time;
      return this;
    }

    /**
     * Sets the {@code location} and returns a reference to this Builder enabling method chaining.
     *
     * @param location the {@code location} to set
     * @return a reference to this Builder
     */
    public Builder location(String location) {
      this.location = location;
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
     * Returns a {@code CarRentalReturnDetails} built from the parameters previously set.
     *
     * @return a {@code CarRentalReturnDetails} built with parameters of this {@code CarRentalReturnDetails.Builder}
     */
    public CarRentalReturnDetails build() {
      return new CarRentalReturnDetails(this);
    }
  }
}

