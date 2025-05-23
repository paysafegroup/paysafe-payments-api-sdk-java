// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.travel.airline.enums.ComputerizedReservationSystem;

/**
 * Contains information about your airline travel.
 * <b>Note:</b> This object is only for Airline Merchants..
 * <b>Note:</b> This field has to be passed only in case of card transactions.
 */
public class AirlineTravelDetails {

  @JsonProperty("passengerNameRecord")
  private String passengerNameRecord;
  @JsonProperty("passengerName")
  private String passengerName;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("origin")
  private String origin;
  @JsonProperty("computerizedReservationSystem")
  private ComputerizedReservationSystem computerizedReservationSystem;
  @JsonProperty("additionalBookingReference")
  private String additionalBookingReference;
  @JsonProperty("totalFare")
  private Long totalFare;
  @JsonProperty("totalFee")
  private Long totalFee;
  @JsonProperty("totalTaxes")
  private Long totalTaxes;
  @JsonProperty("ticket")
  private Ticket ticket;
  @JsonProperty("passengers")
  private Passengers passengers;
  @JsonProperty("customerReferenceNumber")
  private String customerReferenceNumber;
  @JsonProperty("travelAgency")
  private TravelAgency travelAgency;
  @JsonProperty("tripLegs")
  private TripLegs tripLegs;

  public AirlineTravelDetails() {
    super();
  }

  private AirlineTravelDetails(Builder builder) {
    setPassengerNameRecord(builder.passengerNameRecord);
    setPassengerName(builder.passengerName);
    setDepartureDate(builder.departureDate);
    setOrigin(builder.origin);
    setComputerizedReservationSystem(builder.computerizedReservationSystem);
    setAdditionalBookingReference(builder.additionalBookingReference);
    setTotalFare(builder.totalFare);
    setTotalFee(builder.totalFee);
    setTotalTaxes(builder.totalTaxes);
    setTicket(builder.ticket);
    setPassengers(builder.passengers);
    setCustomerReferenceNumber(builder.customerReferenceNumber);
    setTravelAgency(builder.travelAgency);
    setTripLegs(builder.tripLegs);
  }

  public static Builder builder() {
    return new Builder();
  }

  public AirlineTravelDetails passengerNameRecord(String passengerNameRecord) {
    this.passengerNameRecord = passengerNameRecord;
    return this;
  }

  /**
   * The airline company uses the passengerNameRecord as a reservation number.
   *
   * @return passengerNameRecord
   */
  public String getPassengerNameRecord() {
    return passengerNameRecord;
  }

  public void setPassengerNameRecord(String passengerNameRecord) {
    this.passengerNameRecord = passengerNameRecord;
  }

  public AirlineTravelDetails passengerName(String passengerName) {
    this.passengerName = passengerName;
    return this;
  }

  /**
   * Name of the passenger to whom the ticket was issued.
   *
   * @return passengerName
   */
  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }

  public AirlineTravelDetails departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger’s departure. Date format = YYYY-MM-DD, ISO 8601 expected. For example 2022-12-20.
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public AirlineTravelDetails origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Departure Airport Code: IATA Airport Code.
   *
   * @return origin
   */
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public AirlineTravelDetails computerizedReservationSystem(ComputerizedReservationSystem computerizedReservationSystem) {
    this.computerizedReservationSystem = computerizedReservationSystem;
    return this;
  }

  /**
   * Indicates the computerized reservation system used to make the reservation and purchase the ticket.
   * For tickets purchased in Germany, this field should one of these codes: <ul>
   * <li> STRT - Start   </li>
   * <li> PARS - TWA   </li>
   * <li> DATS - Delta   </li>
   * <li> SABR - Sabre   </li>
   * <li> DALA - Covia-Apollo   </li>
   * <li> BLAN - Dr. Blank   </li>
   * <li> DERD - DER  </li>
   * <li> TUID - TUI  </li>
   * </ul>
   *
   * <b>Note:</b> Required only if the ticket is purchased in Germany. Otherwise it can be omitted.
   *
   * @return computerizedReservationSystem
   * l
   */
  public ComputerizedReservationSystem getComputerizedReservationSystem() {
    return computerizedReservationSystem;
  }

  public void setComputerizedReservationSystem(ComputerizedReservationSystem computerizedReservationSystem) {
    this.computerizedReservationSystem = computerizedReservationSystem;
  }

  public AirlineTravelDetails additionalBookingReference(String additionalBookingReference) {
    this.additionalBookingReference = additionalBookingReference;
    return this;
  }

  /**
   * BookingReference field. Typically used for the PNR, but should allow an airline to specify any other reference if they feel fit.
   *
   * @return additionalBookingReference
   */
  public String getAdditionalBookingReference() {
    return additionalBookingReference;
  }

  public void setAdditionalBookingReference(String additionalBookingReference) {
    this.additionalBookingReference = additionalBookingReference;
  }

  public AirlineTravelDetails totalFare(Long totalFare) {
    this.totalFare = totalFare;
    return this;
  }

  /**
   * Total fare for all legs on the ticket, excluding taxes and fees. If multiple tickets are purchased, this is the total fare for all tickets
   *
   * @return totalFare
   */
  public Long getTotalFare() {
    return totalFare;
  }

  public void setTotalFare(Long totalFare) {
    this.totalFare = totalFare;
  }

  public AirlineTravelDetails totalFee(Long totalFee) {
    this.totalFee = totalFee;
    return this;
  }

  /**
   * Total fee for all legs on the ticket. If multiple tickets are purchased, this is the total fee for all tickets.
   *
   * @return totalFee
   */
  public Long getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Long totalFee) {
    this.totalFee = totalFee;
  }

  public AirlineTravelDetails totalTaxes(Long totalTaxes) {
    this.totalTaxes = totalTaxes;
    return this;
  }

  /**
   * Total taxes for all legs on the ticket. If multiple tickets are purchased, this is the total taxes for all tickets.
   *
   * @return totalTaxes
   */
  public Long getTotalTaxes() {
    return totalTaxes;
  }

  public void setTotalTaxes(Long totalTaxes) {
    this.totalTaxes = totalTaxes;
  }

  public AirlineTravelDetails ticket(Ticket ticket) {
    this.ticket = ticket;
    return this;
  }

  /**
   * Information about the Airline Ticket Number and if the ticket is restricted.
   *
   * @return ticket
   */
  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public AirlineTravelDetails passengers(Passengers passengers) {
    this.passengers = passengers;
    return this;
  }

  /**
   * Get passengers
   *
   * @return passengers
   */
  public Passengers getPassengers() {
    return passengers;
  }

  public void setPassengers(Passengers passengers) {
    this.passengers = passengers;
  }

  public AirlineTravelDetails customerReferenceNumber(String customerReferenceNumber) {
    this.customerReferenceNumber = customerReferenceNumber;
    return this;
  }

  /**
   * Contains the code that the cardholder supplied to the card acceptor.
   *
   * @return customerReferenceNumber
   */
  public String getCustomerReferenceNumber() {
    return customerReferenceNumber;
  }

  public void setCustomerReferenceNumber(String customerReferenceNumber) {
    this.customerReferenceNumber = customerReferenceNumber;
  }

  public AirlineTravelDetails travelAgency(TravelAgency travelAgency) {
    this.travelAgency = travelAgency;
    return this;
  }

  /**
   * Information about the travel agency if the ticket was issued by a travel agency.
   *
   * @return travelAgency
   */
  public TravelAgency getTravelAgency() {
    return travelAgency;
  }

  public void setTravelAgency(TravelAgency travelAgency) {
    this.travelAgency = travelAgency;
  }

  public AirlineTravelDetails tripLegs(TripLegs tripLegs) {
    this.tripLegs = tripLegs;
    return this;
  }

  /**
   * A grouping of four separate trip segments. Each leg contains detailed itinerary information.
   *
   * @return tripLegs
   */
  public TripLegs getTripLegs() {
    return tripLegs;
  }

  public void setTripLegs(TripLegs tripLegs) {
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
    AirlineTravelDetails airlineTravelDetails = (AirlineTravelDetails) o;
    return Objects.equals(this.passengerNameRecord, airlineTravelDetails.passengerNameRecord) &&
        Objects.equals(this.passengerName, airlineTravelDetails.passengerName) &&
        Objects.equals(this.departureDate, airlineTravelDetails.departureDate) &&
        Objects.equals(this.origin, airlineTravelDetails.origin) &&
        Objects.equals(this.computerizedReservationSystem, airlineTravelDetails.computerizedReservationSystem) &&
        Objects.equals(this.additionalBookingReference, airlineTravelDetails.additionalBookingReference) &&
        Objects.equals(this.totalFare, airlineTravelDetails.totalFare) &&
        Objects.equals(this.totalFee, airlineTravelDetails.totalFee) &&
        Objects.equals(this.totalTaxes, airlineTravelDetails.totalTaxes) &&
        Objects.equals(this.ticket, airlineTravelDetails.ticket) &&
        Objects.equals(this.passengers, airlineTravelDetails.passengers) &&
        Objects.equals(this.customerReferenceNumber, airlineTravelDetails.customerReferenceNumber) &&
        Objects.equals(this.travelAgency, airlineTravelDetails.travelAgency) &&
        Objects.equals(this.tripLegs, airlineTravelDetails.tripLegs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passengerNameRecord, passengerName, departureDate, origin, computerizedReservationSystem, additionalBookingReference,
        totalFare, totalFee, totalTaxes, ticket, passengers, customerReferenceNumber, travelAgency, tripLegs);
  }

  @Override
  public String toString() {

    return "class AirlineTravelDetails {\n"
        + "    passengerNameRecord: " + toIndentedString(passengerNameRecord) + "\n"
        + "    passengerName: " + toIndentedString(passengerName) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    origin: " + toIndentedString(origin) + "\n"
        + "    computerizedReservationSystem: " + toIndentedString(computerizedReservationSystem) + "\n"
        + "    additionalBookingReference: " + toIndentedString(additionalBookingReference) + "\n"
        + "    totalFare: " + toIndentedString(totalFare) + "\n"
        + "    totalFee: " + toIndentedString(totalFee) + "\n"
        + "    totalTaxes: " + toIndentedString(totalTaxes) + "\n"
        + "    ticket: " + toIndentedString(ticket) + "\n"
        + "    passengers: " + toIndentedString(passengers) + "\n"
        + "    customerReferenceNumber: " + toIndentedString(customerReferenceNumber) + "\n"
        + "    travelAgency: " + toIndentedString(travelAgency) + "\n"
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
   * {@code AirlineTravelDetails} builder static inner class.
   */
  public static final class Builder {
    private String passengerNameRecord;
    private String passengerName;
    private String departureDate;
    private String origin;
    private ComputerizedReservationSystem computerizedReservationSystem;
    private String additionalBookingReference;
    private Long totalFare;
    private Long totalFee;
    private Long totalTaxes;
    private Ticket ticket;
    private Passengers passengers;
    private String customerReferenceNumber;
    private TravelAgency travelAgency;
    private TripLegs tripLegs;

    private Builder() {
    }

    /**
     * Sets the {@code passengerNameRecord} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerNameRecord the {@code passengerNameRecord} to set
     * @return a reference to this Builder
     */
    public Builder passengerNameRecord(String passengerNameRecord) {
      this.passengerNameRecord = passengerNameRecord;
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
     * Sets the {@code computerizedReservationSystem} and returns a reference to this Builder enabling method chaining.
     *
     * @param computerizedReservationSystem the {@code computerizedReservationSystem} to set
     * @return a reference to this Builder
     */
    public Builder computerizedReservationSystem(ComputerizedReservationSystem computerizedReservationSystem) {
      this.computerizedReservationSystem = computerizedReservationSystem;
      return this;
    }

    /**
     * Sets the {@code additionalBookingReference} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalBookingReference the {@code additionalBookingReference} to set
     * @return a reference to this Builder
     */
    public Builder additionalBookingReference(String additionalBookingReference) {
      this.additionalBookingReference = additionalBookingReference;
      return this;
    }

    /**
     * Sets the {@code totalFare} and returns a reference to this Builder enabling method chaining.
     *
     * @param totalFare the {@code totalFare} to set
     * @return a reference to this Builder
     */
    public Builder totalFare(Long totalFare) {
      this.totalFare = totalFare;
      return this;
    }

    /**
     * Sets the {@code totalFee} and returns a reference to this Builder enabling method chaining.
     *
     * @param totalFee the {@code totalFee} to set
     * @return a reference to this Builder
     */
    public Builder totalFee(Long totalFee) {
      this.totalFee = totalFee;
      return this;
    }

    /**
     * Sets the {@code totalTaxes} and returns a reference to this Builder enabling method chaining.
     *
     * @param totalTaxes the {@code totalTaxes} to set
     * @return a reference to this Builder
     */
    public Builder totalTaxes(Long totalTaxes) {
      this.totalTaxes = totalTaxes;
      return this;
    }

    /**
     * Sets the {@code ticket} and returns a reference to this Builder enabling method chaining.
     *
     * @param ticket the {@code ticket} to set
     * @return a reference to this Builder
     */
    public Builder ticket(Ticket ticket) {
      this.ticket = ticket;
      return this;
    }

    /**
     * Sets the {@code passengers} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengers the {@code passengers} to set
     * @return a reference to this Builder
     */
    public Builder passengers(Passengers passengers) {
      this.passengers = passengers;
      return this;
    }

    /**
     * Sets the {@code customerReferenceNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param customerReferenceNumber the {@code customerReferenceNumber} to set
     * @return a reference to this Builder
     */
    public Builder customerReferenceNumber(String customerReferenceNumber) {
      this.customerReferenceNumber = customerReferenceNumber;
      return this;
    }

    /**
     * Sets the {@code travelAgency} and returns a reference to this Builder enabling method chaining.
     *
     * @param travelAgency the {@code travelAgency} to set
     * @return a reference to this Builder
     */
    public Builder travelAgency(TravelAgency travelAgency) {
      this.travelAgency = travelAgency;
      return this;
    }

    /**
     * Sets the {@code tripLegs} and returns a reference to this Builder enabling method chaining.
     *
     * @param tripLegs the {@code tripLegs} to set
     * @return a reference to this Builder
     */
    public Builder tripLegs(TripLegs tripLegs) {
      this.tripLegs = tripLegs;
      return this;
    }

    /**
     * Returns a {@code AirlineTravelDetails} built from the parameters previously set.
     *
     * @return a {@code AirlineTravelDetails} built with parameters of this {@code AirlineTravelDetails.Builder}
     */
    public AirlineTravelDetails build() {
      return new AirlineTravelDetails(this);
    }
  }
}

