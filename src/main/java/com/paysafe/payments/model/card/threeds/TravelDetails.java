// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the Amex-specific travel details.
 * <ul>
 *   <li>
 *     <b>isAirTravel:</b> This indicates whether the transaction is an air travel related purchase, e.g., a ticket purchase  <br>
 *     Default: false
 *   </li>
 *   <li>
 *     <b>airlineCarrier:</b> This is the selected airline carrier.
 *   </li>
 *   <li>
 *     <b>departureDate:</b> This is the date of departure in the time zone of the departure location.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
 *   </li>
 *   <li>
 *     <b>destination:</b> This is the airport code of the destination airport.
 *   </li>
 *   <li>
 *     <b>origin:</b> This is the airport code of the originating airport.
 *   </li>
 *   <li>
 *     <b>passengerFirstName:</b> This is the first name of the cardholder from the billing details.
 *   </li>
 *   <li>
 *     <b>passengerLastName:</b> This is the last name of the cardholder from the billing details.
 *   </li>
 * </ul>
 */
public class TravelDetails {

  @JsonProperty("isAirTravel")
  private Boolean isAirTravel = false;
  @JsonProperty("airlineCarrier")
  private String airlineCarrier;
  @JsonProperty("departureDate")
  private LocalDate departureDate;
  @JsonProperty("destination")
  private String destination;
  @JsonProperty("origin")
  private String origin;
  @JsonProperty("passengerFirstName")
  private String passengerFirstName;
  @JsonProperty("passengerLastName")
  private String passengerLastName;

  public TravelDetails() {
    super();
  }

  private TravelDetails(Builder builder) {
    setIsAirTravel(builder.isAirTravel);
    setAirlineCarrier(builder.airlineCarrier);
    setDepartureDate(builder.departureDate);
    setDestination(builder.destination);
    setOrigin(builder.origin);
    setPassengerFirstName(builder.passengerFirstName);
    setPassengerLastName(builder.passengerLastName);
  }

  public static Builder builder() {
    return new Builder();
  }

  public TravelDetails isAirTravel(Boolean isAirTravel) {
    this.isAirTravel = isAirTravel;
    return this;
  }

  /**
   * This indicates whether the transaction is an air travel related purchase, e.g., a ticket purchase
   *
   * @return isAirTravel
   */
  public Boolean getIsAirTravel() {
    return isAirTravel;
  }

  public void setIsAirTravel(Boolean isAirTravel) {
    this.isAirTravel = isAirTravel;
  }

  public TravelDetails airlineCarrier(String airlineCarrier) {
    this.airlineCarrier = airlineCarrier;
    return this;
  }

  /**
   * This is the selected airline carrier.
   *
   * @return airlineCarrier
   */
  public String getAirlineCarrier() {
    return airlineCarrier;
  }

  public void setAirlineCarrier(String airlineCarrier) {
    this.airlineCarrier = airlineCarrier;
  }

  public TravelDetails departureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * This is the date of departure in the time zone of the departure location. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return departureDate
   */
  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
  }

  public TravelDetails destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * This is the airport code of the destination airport.
   *
   * @return destination
   */
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public TravelDetails origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * This is the airport code of the originating airport.
   *
   * @return origin
   */
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public TravelDetails passengerFirstName(String passengerFirstName) {
    this.passengerFirstName = passengerFirstName;
    return this;
  }

  /**
   * This is the first name of the cardholder from the billing details.
   *
   * @return passengerFirstName
   */
  public String getPassengerFirstName() {
    return passengerFirstName;
  }

  public void setPassengerFirstName(String passengerFirstName) {
    this.passengerFirstName = passengerFirstName;
  }

  public TravelDetails passengerLastName(String passengerLastName) {
    this.passengerLastName = passengerLastName;
    return this;
  }

  /**
   * This is the last name of the cardholder from the billing details.
   *
   * @return passengerLastName
   */
  public String getPassengerLastName() {
    return passengerLastName;
  }

  public void setPassengerLastName(String passengerLastName) {
    this.passengerLastName = passengerLastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TravelDetails travelDetails = (TravelDetails) o;
    return Objects.equals(this.isAirTravel, travelDetails.isAirTravel) &&
        Objects.equals(this.airlineCarrier, travelDetails.airlineCarrier) &&
        Objects.equals(this.departureDate, travelDetails.departureDate) &&
        Objects.equals(this.destination, travelDetails.destination) &&
        Objects.equals(this.origin, travelDetails.origin) &&
        Objects.equals(this.passengerFirstName, travelDetails.passengerFirstName) &&
        Objects.equals(this.passengerLastName, travelDetails.passengerLastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isAirTravel, airlineCarrier, departureDate, destination, origin, passengerFirstName, passengerLastName);
  }

  @Override
  public String toString() {

    return "class TravelDetails {\n"
        + "    isAirTravel: " + toIndentedString(isAirTravel) + "\n"
        + "    airlineCarrier: " + toIndentedString(airlineCarrier) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    destination: " + toIndentedString(destination) + "\n"
        + "    origin: " + toIndentedString(origin) + "\n"
        + "    passengerFirstName: " + toIndentedString(passengerFirstName) + "\n"
        + "    passengerLastName: " + toIndentedString(passengerLastName) + "\n"
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
   * {@code TravelDetails} builder static inner class.
   */
  public static final class Builder {
    private Boolean isAirTravel;
    private String airlineCarrier;
    private LocalDate departureDate;
    private String destination;
    private String origin;
    private String passengerFirstName;
    private String passengerLastName;

    private Builder() {
    }

    /**
     * Sets the {@code isAirTravel} and returns a reference to this Builder enabling method chaining.
     *
     * @param isAirTravel the {@code isAirTravel} to set
     * @return a reference to this Builder
     */
    public Builder isAirTravel(Boolean isAirTravel) {
      this.isAirTravel = isAirTravel;
      return this;
    }

    /**
     * Sets the {@code airlineCarrier} and returns a reference to this Builder enabling method chaining.
     *
     * @param airlineCarrier the {@code airlineCarrier} to set
     * @return a reference to this Builder
     */
    public Builder airlineCarrier(String airlineCarrier) {
      this.airlineCarrier = airlineCarrier;
      return this;
    }

    /**
     * Sets the {@code departureDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param departureDate the {@code departureDate} to set
     * @return a reference to this Builder
     */
    public Builder departureDate(LocalDate departureDate) {
      this.departureDate = departureDate;
      return this;
    }

    /**
     * Sets the {@code destination} and returns a reference to this Builder enabling method chaining.
     *
     * @param destination the {@code destination} to set
     * @return a reference to this Builder
     */
    public Builder destination(String destination) {
      this.destination = destination;
      return this;
    }

    /**
     * Sets the {@code origin} and returns a reference to this Builder enabling method chaining.
     *
     * @param origin the {@code origin} to set
     * @return a reference to this Builder
     */
    public Builder origin(String origin) {
      this.origin = origin;
      return this;
    }

    /**
     * Sets the {@code passengerFirstName} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerFirstName the {@code passengerFirstName} to set
     * @return a reference to this Builder
     */
    public Builder passengerFirstName(String passengerFirstName) {
      this.passengerFirstName = passengerFirstName;
      return this;
    }

    /**
     * Sets the {@code passengerLastName} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerLastName the {@code passengerLastName} to set
     * @return a reference to this Builder
     */
    public Builder passengerLastName(String passengerLastName) {
      this.passengerLastName = passengerLastName;
      return this;
    }

    /**
     * Returns a {@code TravelDetails} built from the parameters previously set.
     *
     * @return a {@code TravelDetails} built with parameters of this {@code TravelDetails.Builder}
     */
    public TravelDetails build() {
      return new TravelDetails(this);
    }
  }
}

