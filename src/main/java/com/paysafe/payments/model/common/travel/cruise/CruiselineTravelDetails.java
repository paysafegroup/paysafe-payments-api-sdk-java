// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.travel.cruise.enums.TravelPackageApplication;

/**
 * Contains information about your cruise line travel.
 * <b>Note:<b> This object is only for Cruise line Merchants. <br />
 * <b>Note:<b> This field has to be passed only in case of card transactions.
 */
public class CruiselineTravelDetails {

  @JsonProperty("cruiseShipName")
  private String cruiseShipName;
  @JsonProperty("passengerName")
  private String passengerName;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("returnDate")
  private String returnDate;
  @JsonProperty("country")
  private String country;
  @JsonProperty("state")
  private String state;
  @JsonProperty("originCity")
  private String originCity;
  @JsonProperty("roomRate")
  private Long roomRate;
  @JsonProperty("travelPackageApplication")
  private TravelPackageApplication travelPackageApplication;
  @JsonProperty("ticket")
  private CruiselineTicket ticket;
  @JsonProperty("passengers")
  private CruiselinePassengers passengers;
  @JsonProperty("tripLegs")
  private CruiselineTripLegs tripLegs;

  public CruiselineTravelDetails() {
    super();
  }

  private CruiselineTravelDetails(Builder builder) {
    setCruiseShipName(builder.cruiseShipName);
    setPassengerName(builder.passengerName);
    setDepartureDate(builder.departureDate);
    setReturnDate(builder.returnDate);
    setCountry(builder.country);
    setState(builder.state);
    setOriginCity(builder.originCity);
    setRoomRate(builder.roomRate);
    setTravelPackageApplication(builder.travelPackageApplication);
    setTicket(builder.ticket);
    setPassengers(builder.passengers);
    setTripLegs(builder.tripLegs);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CruiselineTravelDetails cruiseShipName(String cruiseShipName) {
    this.cruiseShipName = cruiseShipName;
    return this;
  }

  /**
   * The ship name booked for the cruise.  Required during settlement request with AMEX for integration with TSYS processor.
   *
   * @return cruiseShipName
   */
  public String getCruiseShipName() {
    return cruiseShipName;
  }

  public void setCruiseShipName(String cruiseShipName) {
    this.cruiseShipName = cruiseShipName;
  }

  public CruiselineTravelDetails passengerName(String passengerName) {
    this.passengerName = passengerName;
    return this;
  }

  /**
   * Name of the passenger to whom the ticket was issued.
   * Required during authorization request with AMEX for integration with TSYS processor. <br />
   * Required during settlement request with Visa or Mastercard for integration with TSYS processor.
   *
   * @return passengerName
   */
  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }

  public CruiselineTravelDetails departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger’s departure. Date format = YYYY-MM-DD, ISO 8601 expected. <br />
   * Required during authorization request with AMEX for integration with TSYS processor. <br />
   * Required during settlement request for integration with TSYS processor.
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public CruiselineTravelDetails returnDate(String returnDate) {
    this.returnDate = returnDate;
    return this;
  }

  /**
   * Date of passenger’s return. Date format = YYYY-MM-DD, ISO 8601 expected.
   * Required during settlement request with AMEX for integration with TSYS processor.
   *
   * @return returnDate
   */
  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }

  public CruiselineTravelDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This field contains the country code of the cruise location.
   *
   * @return country
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   * Required during settlement request with AMEX for integration with TSYS processor.
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CruiselineTravelDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The region code that corresponds to the state, province, or other country subdivision of the cruise location.
   * See <a href="https://developer.paysafe.com/en/support/reference-information/codes/#province-codes">Province Codes</a>
   * or <a href="https://developer.paysafe.com/en/support/reference-information/codes/#state-codes">State Codes</a> for Canada or the United States.
   * <br />
   * Required during settlement request with AMEX for integration with TSYS processor.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CruiselineTravelDetails originCity(String originCity) {
    this.originCity = originCity;
    return this;
  }

  /**
   * Departure City where the trip originates.  Required for AMEX in case of integration with TSYS processor.
   *
   * @return originCity
   */
  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }

  public CruiselineTravelDetails roomRate(Long roomRate) {
    this.roomRate = roomRate;
    return this;
  }

  /**
   * Total cost of the cruise. For onboard purchases or transactions occurring during cruise travel, this field must be zero filled.
   * Required during settlement request with AMEX for integration with TSYS processor. <br />
   * Maximum: 999999999999
   *
   * @return roomRate
   */
  public Long getRoomRate() {
    return roomRate;
  }

  public void setRoomRate(Long roomRate) {
    this.roomRate = roomRate;
  }

  public CruiselineTravelDetails travelPackageApplication(TravelPackageApplication travelPackageApplication) {
    this.travelPackageApplication = travelPackageApplication;
    return this;
  }

  /**
   * Indicates if the package includes car rental, airline flight, both or neither.
   *
   * @return travelPackageApplication
   */
  public TravelPackageApplication getTravelPackageApplication() {
    return travelPackageApplication;
  }

  public void setTravelPackageApplication(TravelPackageApplication travelPackageApplication) {
    this.travelPackageApplication = travelPackageApplication;
  }

  public CruiselineTravelDetails ticket(CruiselineTicket ticket) {
    this.ticket = ticket;
    return this;
  }

  /**
   * Information about the Cruise line Ticket Number and if the ticket is restricted.
   * Required during settlement.
   * <b>Note:<b> This object is only for Cruise line Merchants.
   *
   * @return ticket
   */
  public CruiselineTicket getTicket() {
    return ticket;
  }

  public void setTicket(CruiselineTicket ticket) {
    this.ticket = ticket;
  }

  public CruiselineTravelDetails passengers(CruiselinePassengers passengers) {
    this.passengers = passengers;
    return this;
  }

  /**
   * A grouping of up to ten cruise line passengers. <b>Note:<b> This object is only for Cruise line Merchants.
   *
   * @return passengers
   */
  public CruiselinePassengers getPassengers() {
    return passengers;
  }

  public void setPassengers(CruiselinePassengers passengers) {
    this.passengers = passengers;
  }

  public CruiselineTravelDetails tripLegs(CruiselineTripLegs tripLegs) {
    this.tripLegs = tripLegs;
    return this;
  }

  /**
   * A grouping of up to four cruise line legs. Each leg provides detailed itinerary data.
   * <b>Note:<b> This object is only for Cruise line Merchants.
   *
   * @return tripLegs
   */
  public CruiselineTripLegs getTripLegs() {
    return tripLegs;
  }

  public void setTripLegs(CruiselineTripLegs tripLegs) {
    this.tripLegs = tripLegs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselineTravelDetails cruiselineTravelDetails = (CruiselineTravelDetails) o;
    return Objects.equals(this.cruiseShipName, cruiselineTravelDetails.cruiseShipName) &&
        Objects.equals(this.passengerName, cruiselineTravelDetails.passengerName) &&
        Objects.equals(this.departureDate, cruiselineTravelDetails.departureDate) &&
        Objects.equals(this.returnDate, cruiselineTravelDetails.returnDate) &&
        Objects.equals(this.country, cruiselineTravelDetails.country) &&
        Objects.equals(this.state, cruiselineTravelDetails.state) &&
        Objects.equals(this.originCity, cruiselineTravelDetails.originCity) &&
        Objects.equals(this.roomRate, cruiselineTravelDetails.roomRate) &&
        Objects.equals(this.travelPackageApplication, cruiselineTravelDetails.travelPackageApplication) &&
        Objects.equals(this.ticket, cruiselineTravelDetails.ticket) &&
        Objects.equals(this.passengers, cruiselineTravelDetails.passengers) &&
        Objects.equals(this.tripLegs, cruiselineTravelDetails.tripLegs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cruiseShipName, passengerName, departureDate, returnDate, country, state, originCity, roomRate,
        travelPackageApplication, ticket, passengers, tripLegs);
  }

  @Override
  public String toString() {

    return "class CruiselineTravelDetails {\n"
        + "    cruiseShipName: " + toIndentedString(cruiseShipName) + "\n"
        + "    passengerName: " + toIndentedString(passengerName) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    returnDate: " + toIndentedString(returnDate) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    originCity: " + toIndentedString(originCity) + "\n"
        + "    roomRate: " + toIndentedString(roomRate) + "\n"
        + "    travelPackageApplication: " + toIndentedString(travelPackageApplication) + "\n"
        + "    ticket: " + toIndentedString(ticket) + "\n"
        + "    passengers: " + toIndentedString(passengers) + "\n"
        + "    tripLegs: " + toIndentedString(tripLegs) + "\n"
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
   * {@code CruiselineTravelDetails} builder static inner class.
   */
  public static final class Builder {
    private String cruiseShipName;
    private String passengerName;
    private String departureDate;
    private String returnDate;
    private String country;
    private String state;
    private String originCity;
    private Long roomRate;
    private TravelPackageApplication travelPackageApplication;
    private CruiselineTicket ticket;
    private CruiselinePassengers passengers;
    private CruiselineTripLegs tripLegs;

    private Builder() {
    }

    /**
     * Sets the {@code cruiseShipName} and returns a reference to this Builder enabling method chaining.
     *
     * @param cruiseShipName the {@code cruiseShipName} to set
     * @return a reference to this Builder
     */
    public Builder cruiseShipName(String cruiseShipName) {
      this.cruiseShipName = cruiseShipName;
      return this;
    }

    /**
     * Sets the {@code passengerName} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerName the {@code passengerName} to set
     * @return a reference to this Builder
     */
    public Builder passengerName(String passengerName) {
      this.passengerName = passengerName;
      return this;
    }

    /**
     * Sets the {@code departureDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param departureDate the {@code departureDate} to set
     * @return a reference to this Builder
     */
    public Builder departureDate(String departureDate) {
      this.departureDate = departureDate;
      return this;
    }

    /**
     * Sets the {@code returnDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param returnDate the {@code returnDate} to set
     * @return a reference to this Builder
     */
    public Builder returnDate(String returnDate) {
      this.returnDate = returnDate;
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
     * Sets the {@code originCity} and returns a reference to this Builder enabling method chaining.
     *
     * @param originCity the {@code originCity} to set
     * @return a reference to this Builder
     */
    public Builder originCity(String originCity) {
      this.originCity = originCity;
      return this;
    }

    /**
     * Sets the {@code roomRate} and returns a reference to this Builder enabling method chaining.
     *
     * @param roomRate the {@code roomRate} to set
     * @return a reference to this Builder
     */
    public Builder roomRate(Long roomRate) {
      this.roomRate = roomRate;
      return this;
    }

    /**
     * Sets the {@code travelPackageApplication} and returns a reference to this Builder enabling method chaining.
     *
     * @param travelPackageApplication the {@code travelPackageApplication} to set
     * @return a reference to this Builder
     */
    public Builder travelPackageApplication(TravelPackageApplication travelPackageApplication) {
      this.travelPackageApplication = travelPackageApplication;
      return this;
    }

    /**
     * Sets the {@code ticket} and returns a reference to this Builder enabling method chaining.
     *
     * @param ticket the {@code ticket} to set
     * @return a reference to this Builder
     */
    public Builder ticket(CruiselineTicket ticket) {
      this.ticket = ticket;
      return this;
    }

    /**
     * Sets the {@code passengers} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengers the {@code passengers} to set
     * @return a reference to this Builder
     */
    public Builder passengers(CruiselinePassengers passengers) {
      this.passengers = passengers;
      return this;
    }

    /**
     * Sets the {@code tripLegs} and returns a reference to this Builder enabling method chaining.
     *
     * @param tripLegs the {@code tripLegs} to set
     * @return a reference to this Builder
     */
    public Builder tripLegs(CruiselineTripLegs tripLegs) {
      this.tripLegs = tripLegs;
      return this;
    }

    /**
     * Returns a {@code CruiselineTravelDetails} built from the parameters previously set.
     *
     * @return a {@code CruiselineTravelDetails} built with parameters of this {@code CruiselineTravelDetails.Builder}
     */
    public CruiselineTravelDetails build() {
      return new CruiselineTravelDetails(this);
    }
  }
}

