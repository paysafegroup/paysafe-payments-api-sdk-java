// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.travel.airline.enums.ServiceClass;

/**
 * Contains detailed itinerary information for one of the trip legs
 */
public class Leg {

  @JsonProperty("fare")
  private String fare;
  @JsonProperty("serviceClass")
  private ServiceClass serviceClass;
  @JsonProperty("serviceClassFee")
  private String serviceClassFee;
  @JsonProperty("isStopOverAllowed")
  private Boolean isStopOverAllowed;
  @JsonProperty("departureAirport")
  private String departureAirport;
  @JsonProperty("destination")
  private String destination;
  @JsonProperty("fareBasis")
  private String fareBasis;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("departureTime")
  private String departureTime;
  @JsonProperty("arrivalTime")
  private String arrivalTime;
  @JsonProperty("conjunctionTicket")
  private String conjunctionTicket;
  @JsonProperty("couponNumber")
  private String couponNumber;
  @JsonProperty("notation")
  private String notation;
  @JsonProperty("taxes")
  private String taxes;
  @JsonProperty("flight")
  private Flight flight;

  public Leg() {
    super();
  }

  private Leg(Builder builder) {
    setFare(builder.fare);
    setServiceClass(builder.serviceClass);
    setServiceClassFee(builder.serviceClassFee);
    setIsStopOverAllowed(builder.isStopOverAllowed);
    setDepartureAirport(builder.departureAirport);
    setDestination(builder.destination);
    setFareBasis(builder.fareBasis);
    setDepartureDate(builder.departureDate);
    setArrivalTime(builder.arrivalTime);
    setConjunctionTicket(builder.conjunctionTicket);
    setCouponNumber(builder.couponNumber);
    setNotation(builder.notation);
    setTaxes(builder.taxes);
    setFlight(builder.flight);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Leg fare(String fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Indicates the total fare applied to a specific leg.
   *
   * @return fare
   */
  public String getFare() {
    return fare;
  }

  public void setFare(String fare) {
    this.fare = fare;
  }

  public Leg serviceClass(ServiceClass serviceClass) {
    this.serviceClass = serviceClass;
    return this;
  }

  /**
   * Indicates service class (first class, business class, etc.).
   *
   * @return serviceClass
   */
  public ServiceClass getServiceClass() {
    return serviceClass;
  }

  public void setServiceClass(ServiceClass serviceClass) {
    this.serviceClass = serviceClass;
  }

  public Leg serviceClassFee(String serviceClassFee) {
    this.serviceClassFee = serviceClassFee;
    return this;
  }

  /**
   * Fee applied to a specific leg
   *
   * @return serviceClassFee
   */
  public String getServiceClassFee() {
    return serviceClassFee;
  }

  public void setServiceClassFee(String serviceClassFee) {
    this.serviceClassFee = serviceClassFee;
  }

  public Leg isStopOverAllowed(Boolean isStopOverAllowed) {
    this.isStopOverAllowed = isStopOverAllowed;
    return this;
  }

  /**
   * Indicates whether a stopover is allowed on this ticket. Valid values are:  - false - not allowed  - true - allowed
   *
   * @return isStopOverAllowed
   */
  public Boolean getIsStopOverAllowed() {
    return isStopOverAllowed;
  }

  public void setIsStopOverAllowed(Boolean isStopOverAllowed) {
    this.isStopOverAllowed = isStopOverAllowed;
  }

  public Leg departureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
    return this;
  }

  /**
   * Departure airport
   *
   * @return departureAirport
   */
  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }

  public Leg destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Destination Airport Code (IATA Airport Code).
   *
   * @return destination
   */
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Leg fareBasis(String fareBasis) {
    this.fareBasis = fareBasis;
    return this;
  }

  /**
   * Contains a Fare Basis Code for Leg that carriers assign to a particular ticket type, such as business class or discounted/nonrefundable.
   *
   * @return fareBasis
   */
  public String getFareBasis() {
    return fareBasis;
  }

  public void setFareBasis(String fareBasis) {
    this.fareBasis = fareBasis;
  }

  public Leg departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger’s departure for this leg. Date format = YYYY-MM-DD, ISO 8601 expected. For example, 2014-01-26
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  /**
   * Departure time at the airport of departure Date format = YYYY-MM-DDTHH:MM:SSZ, ISO 8601 expected: 2014-01-26T10:32:28Z
   *
   * @return departureTime
   */
  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public Leg arrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * Arrival time at the airport for that specific leg.
   *
   * @return arrivalTime
   */
  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Leg conjunctionTicket(String conjunctionTicket) {
    this.conjunctionTicket = conjunctionTicket;
    return this;
  }

  /**
   * Specifying a number of the conjunction ticket within a single contract of carriage.
   *
   * @return conjunctionTicket
   */
  public String getConjunctionTicket() {
    return conjunctionTicket;
  }

  public void setConjunctionTicket(String conjunctionTicket) {
    this.conjunctionTicket = conjunctionTicket;
  }

  public Leg couponNumber(String couponNumber) {
    this.couponNumber = couponNumber;
    return this;
  }

  /**
   * Coupon number associated with the leg. Every leg could have a coupon number.
   *
   * @return couponNumber
   */
  public String getCouponNumber() {
    return couponNumber;
  }

  public void setCouponNumber(String couponNumber) {
    this.couponNumber = couponNumber;
  }

  public Leg notation(String notation) {
    this.notation = notation;
    return this;
  }

  /**
   * An endorsement can be an agency-added notation or a mandatory government required notation, such as value-added tax.
   * A restriction is a limitation based on the type of fare, such as a ticket with a 3-day minimum stay
   *
   * @return notation
   */
  public String getNotation() {
    return notation;
  }

  public void setNotation(String notation) {
    this.notation = notation;
  }

  public Leg taxes(String taxes) {
    this.taxes = taxes;
    return this;
  }

  /**
   * Taxes for a specific leg
   *
   * @return taxes
   */
  public String getTaxes() {
    return taxes;
  }

  public void setTaxes(String taxes) {
    this.taxes = taxes;
  }

  public Leg flight(Flight flight) {
    this.flight = flight;
    return this;
  }

  /**
   * Operating Carrier Code and the Number of the airline flight to be taken on Leg of the trip (excluding the carrier code).
   *
   * @return flight
   */
  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Leg leg = (Leg) o;
    return Objects.equals(this.fare, leg.fare) &&
        Objects.equals(this.serviceClass, leg.serviceClass) &&
        Objects.equals(this.serviceClassFee, leg.serviceClassFee) &&
        Objects.equals(this.isStopOverAllowed, leg.isStopOverAllowed) &&
        Objects.equals(this.departureAirport, leg.departureAirport) &&
        Objects.equals(this.destination, leg.destination) &&
        Objects.equals(this.fareBasis, leg.fareBasis) &&
        Objects.equals(this.departureDate, leg.departureDate) &&
        Objects.equals(this.departureTime, leg.departureTime) &&
        Objects.equals(this.arrivalTime, leg.arrivalTime) &&
        Objects.equals(this.conjunctionTicket, leg.conjunctionTicket) &&
        Objects.equals(this.couponNumber, leg.couponNumber) &&
        Objects.equals(this.notation, leg.notation) &&
        Objects.equals(this.taxes, leg.taxes) &&
        Objects.equals(this.flight, leg.flight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fare, serviceClass, serviceClassFee, isStopOverAllowed, departureAirport, destination, fareBasis, departureDate,
        departureTime, arrivalTime, conjunctionTicket, couponNumber, notation, taxes, flight);
  }

  @Override
  public String toString() {

    return "class Leg {\n"
        + "    fare: " + toIndentedString(fare) + "\n"
        + "    serviceClass: " + toIndentedString(serviceClass) + "\n"
        + "    serviceClassFee: " + toIndentedString(serviceClassFee) + "\n"
        + "    isStopOverAllowed: " + toIndentedString(isStopOverAllowed) + "\n"
        + "    departureAirport: " + toIndentedString(departureAirport) + "\n"
        + "    destination: " + toIndentedString(destination) + "\n"
        + "    fareBasis: " + toIndentedString(fareBasis) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    departureTime: " + toIndentedString(departureTime) + "\n"
        + "    arrivalTime: " + toIndentedString(arrivalTime) + "\n"
        + "    conjunctionTicket: " + toIndentedString(conjunctionTicket) + "\n"
        + "    couponNumber: " + toIndentedString(couponNumber) + "\n"
        + "    notation: " + toIndentedString(notation) + "\n"
        + "    taxes: " + toIndentedString(taxes) + "\n"
        + "    flight: " + toIndentedString(flight) + "\n"
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
   * {@code Leg} builder static inner class.
   */
  public static final class Builder {
    private String fare;
    private ServiceClass serviceClass;
    private String serviceClassFee;
    private Boolean isStopOverAllowed;
    private String departureAirport;
    private String destination;
    private String fareBasis;
    private String departureDate;
    private String arrivalTime;
    private String conjunctionTicket;
    private String couponNumber;
    private String notation;
    private String taxes;
    private Flight flight;

    private Builder() {
    }

    /**
     * Sets the {@code fare} and returns a reference to this Builder enabling method chaining.
     *
     * @param fare the {@code fare} to set
     * @return a reference to this Builder
     */
    public Builder fare(String fare) {
      this.fare = fare;
      return this;
    }

    /**
     * Sets the {@code serviceClass} and returns a reference to this Builder enabling method chaining.
     *
     * @param serviceClass the {@code serviceClass} to set
     * @return a reference to this Builder
     */
    public Builder serviceClass(ServiceClass serviceClass) {
      this.serviceClass = serviceClass;
      return this;
    }

    /**
     * Sets the {@code serviceClassFee} and returns a reference to this Builder enabling method chaining.
     *
     * @param serviceClassFee the {@code serviceClassFee} to set
     * @return a reference to this Builder
     */
    public Builder serviceClassFee(String serviceClassFee) {
      this.serviceClassFee = serviceClassFee;
      return this;
    }

    /**
     * Sets the {@code isStopOverAllowed} and returns a reference to this Builder enabling method chaining.
     *
     * @param isStopOverAllowed the {@code isStopOverAllowed} to set
     * @return a reference to this Builder
     */
    public Builder isStopOverAllowed(Boolean isStopOverAllowed) {
      this.isStopOverAllowed = isStopOverAllowed;
      return this;
    }

    /**
     * Sets the {@code departureAirport} and returns a reference to this Builder enabling method chaining.
     *
     * @param departureAirport the {@code departureAirport} to set
     * @return a reference to this Builder
     */
    public Builder departureAirport(String departureAirport) {
      this.departureAirport = departureAirport;
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
     * Sets the {@code fareBasis} and returns a reference to this Builder enabling method chaining.
     *
     * @param fareBasis the {@code fareBasis} to set
     * @return a reference to this Builder
     */
    public Builder fareBasis(String fareBasis) {
      this.fareBasis = fareBasis;
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
     * Sets the {@code arrivalTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param arrivalTime the {@code arrivalTime} to set
     * @return a reference to this Builder
     */
    public Builder arrivalTime(String arrivalTime) {
      this.arrivalTime = arrivalTime;
      return this;
    }

    /**
     * Sets the {@code conjunctionTicket} and returns a reference to this Builder enabling method chaining.
     *
     * @param conjunctionTicket the {@code conjunctionTicket} to set
     * @return a reference to this Builder
     */
    public Builder conjunctionTicket(String conjunctionTicket) {
      this.conjunctionTicket = conjunctionTicket;
      return this;
    }

    /**
     * Sets the {@code couponNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param couponNumber the {@code couponNumber} to set
     * @return a reference to this Builder
     */
    public Builder couponNumber(String couponNumber) {
      this.couponNumber = couponNumber;
      return this;
    }

    /**
     * Sets the {@code notation} and returns a reference to this Builder enabling method chaining.
     *
     * @param notation the {@code notation} to set
     * @return a reference to this Builder
     */
    public Builder notation(String notation) {
      this.notation = notation;
      return this;
    }

    /**
     * Sets the {@code taxes} and returns a reference to this Builder enabling method chaining.
     *
     * @param taxes the {@code taxes} to set
     * @return a reference to this Builder
     */
    public Builder taxes(String taxes) {
      this.taxes = taxes;
      return this;
    }

    /**
     * Sets the {@code flight} and returns a reference to this Builder enabling method chaining.
     *
     * @param flight the {@code flight} to set
     * @return a reference to this Builder
     */
    public Builder flight(Flight flight) {
      this.flight = flight;
      return this;
    }

    /**
     * Returns a {@code Leg} built from the parameters previously set.
     *
     * @return a {@code Leg} built with parameters of this {@code Leg.Builder}
     */
    public Leg build() {
      return new Leg(this);
    }
  }
}

