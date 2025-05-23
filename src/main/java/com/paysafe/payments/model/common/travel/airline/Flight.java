// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Operating Carrier Code and the Number of the airline flight to be taken on Leg of the trip (excluding the carrier code).
 */
public class Flight {

  @JsonProperty("carrierCode")
  private String carrierCode;
  @JsonProperty("flightNumber")
  private String flightNumber;
  @JsonProperty("airlineName")
  private String airlineName;
  @JsonProperty("airlineIcaoCode")
  private String airlineIcaoCode;

  public Flight() {
    super();
  }

  private Flight(final Builder builder) {
    setCarrierCode(builder.carrierCode);
    setFlightNumber(builder.flightNumber);
    setAirlineName(builder.airlineName);
    setAirlineIcaoCode(builder.airlineIcaoCode);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Flight carrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
    return this;
  }

  /**
   * Operating Carrier Code; the standard abbreviation code indicating name of the operating carrier like United Airlines, Jet Blue, etc.
   *
   * @return carrierCode
   */
  public String getCarrierCode() {
    return carrierCode;
  }

  public void setCarrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
  }

  public Flight flightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
    return this;
  }

  /**
   * Number of the airline flight to be taken on Leg of the trip excluding the carrier code.
   *
   * @return flightNumber
   */
  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  /**
   * Airline full name. Required during settlement request for.
   *
   * @return airlineName
   */
  public String getAirlineName() {
    return airlineName;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public Flight airlineIcaoCode(String airlineIcaoCode) {
    this.airlineIcaoCode = airlineIcaoCode;
    return this;
  }

  /**
   * Airline ICAO code.
   *
   * @return airlineIcaoCode
   */
  public String getAirlineIcaoCode() {
    return airlineIcaoCode;
  }

  public void setAirlineIcaoCode(String airlineIcaoCode) {
    this.airlineIcaoCode = airlineIcaoCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(this.carrierCode, flight.carrierCode) &&
        Objects.equals(this.flightNumber, flight.flightNumber) &&
        Objects.equals(this.airlineName, flight.airlineName) &&
        Objects.equals(this.airlineIcaoCode, flight.airlineIcaoCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carrierCode, flightNumber, airlineName, airlineIcaoCode);
  }

  @Override
  public String toString() {

    return "class Flight {\n"
        + "    carrierCode: " + toIndentedString(carrierCode) + "\n"
        + "    flightNumber: " + toIndentedString(flightNumber) + "\n"
        + "    airlineName: " + toIndentedString(airlineName) + "\n"
        + "    airlineIcaoCode: " + toIndentedString(airlineIcaoCode) + "\n"
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
   * {@code Flight} builder static inner class.
   */
  public static final class Builder {
    private String carrierCode;
    private String flightNumber;
    private String airlineName;
    private String airlineIcaoCode;

    private Builder() {
    }

    /**
     * Sets the {@code carrierCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param carrierCode the {@code carrierCode} to set
     * @return a reference to this Builder
     */
    public Builder carrierCode(String carrierCode) {
      this.carrierCode = carrierCode;
      return this;
    }

    /**
     * Sets the {@code flightNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param flightNumber the {@code flightNumber} to set
     * @return a reference to this Builder
     */
    public Builder flightNumber(String flightNumber) {
      this.flightNumber = flightNumber;
      return this;
    }

    /**
     * Sets the {@code airlineName} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code airlineName} to set
     * @return a reference to this Builder
     */
    public Builder airlineName(final String val) {
      airlineName = val;
      return this;
    }

    /**
     * Sets the {@code airlineIcaoCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code airlineIcaoCode} to set
     * @return a reference to this Builder
     */
    public Builder airlineIcaoCode(final String val) {
      airlineIcaoCode = val;
      return this;
    }

    /**
     * Returns a {@code Flight} built from the parameters previously set.
     *
     * @return a {@code Flight} built with parameters of this {@code Flight.Builder}
     */
    public Flight build() {
      return new Flight(this);
    }
  }
}

