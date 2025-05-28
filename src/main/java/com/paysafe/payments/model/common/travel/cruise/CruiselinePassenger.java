// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.travel.airline.enums.Gender;

/**
 * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
 */
public class CruiselinePassenger {

  @JsonProperty("ticketNumber")
  private String ticketNumber;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("phoneNumber")
  private String phoneNumber;
  @JsonProperty("passengerCode")
  private String passengerCode;
  @JsonProperty("gender")
  private Gender gender;

  public CruiselinePassenger() {
    super();
  }

  private CruiselinePassenger(Builder builder) {
    setTicketNumber(builder.ticketNumber);
    setFirstName(builder.firstName);
    setLastName(builder.lastName);
    setPhoneNumber(builder.phoneNumber);
    setPassengerCode(builder.passengerCode);
    setGender(builder.gender);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CruiselinePassenger ticketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Identifies the ticket for this passenger only.
   *
   * @return ticketNumber
   */
  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public CruiselinePassenger firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Passenger's first name.
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CruiselinePassenger lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Passenger's last name.
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CruiselinePassenger phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Passenger's phone number.
   *
   * @return phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public CruiselinePassenger passengerCode(String passengerCode) {
    this.passengerCode = passengerCode;
    return this;
  }

  /**
   * Code that identifies a type of passenger. For example 'INF' which indicates a child traveling on parent's lap.
   *
   * @return passengerCode
   */
  public String getPassengerCode() {
    return passengerCode;
  }

  public void setPassengerCode(String passengerCode) {
    this.passengerCode = passengerCode;
  }

  public CruiselinePassenger gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Passenger gender. Options: [M – Male, F – Female, O – Other, N – Not Specified]
   *
   * @return gender
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselinePassenger cruiselinePassenger = (CruiselinePassenger) o;
    return Objects.equals(this.ticketNumber, cruiselinePassenger.ticketNumber) &&
        Objects.equals(this.firstName, cruiselinePassenger.firstName) &&
        Objects.equals(this.lastName, cruiselinePassenger.lastName) &&
        Objects.equals(this.phoneNumber, cruiselinePassenger.phoneNumber) &&
        Objects.equals(this.passengerCode, cruiselinePassenger.passengerCode) &&
        Objects.equals(this.gender, cruiselinePassenger.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticketNumber, firstName, lastName, phoneNumber, passengerCode, gender);
  }

  @Override
  public String toString() {

    return "class CruiselinePassenger {\n"
        + "    ticketNumber: " + toIndentedString(ticketNumber) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    phoneNumber: " + toIndentedString(phoneNumber) + "\n"
        + "    passengerCode: " + toIndentedString(passengerCode) + "\n"
        + "    gender: " + toIndentedString(gender) + "\n"
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
   * {@code CruiselinePassenger} builder static inner class.
   */
  public static final class Builder {
    private String ticketNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passengerCode;
    private Gender gender;

    private Builder() {
    }

    /**
     * Sets the {@code ticketNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketNumber the {@code ticketNumber} to set
     * @return a reference to this Builder
     */
    public Builder ticketNumber(String ticketNumber) {
      this.ticketNumber = ticketNumber;
      return this;
    }

    /**
     * Sets the {@code firstName} and returns a reference to this Builder enabling method chaining.
     *
     * @param firstName the {@code firstName} to set
     * @return a reference to this Builder
     */
    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     * Sets the {@code lastName} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastName the {@code lastName} to set
     * @return a reference to this Builder
     */
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    /**
     * Sets the {@code phoneNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param phoneNumber the {@code phoneNumber} to set
     * @return a reference to this Builder
     */
    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    /**
     * Sets the {@code passengerCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerCode the {@code passengerCode} to set
     * @return a reference to this Builder
     */
    public Builder passengerCode(String passengerCode) {
      this.passengerCode = passengerCode;
      return this;
    }

    /**
     * Sets the {@code gender} and returns a reference to this Builder enabling method chaining.
     *
     * @param gender the {@code gender} to set
     * @return a reference to this Builder
     */
    public Builder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    /**
     * Returns a {@code CruiselinePassenger} built from the parameters previously set.
     *
     * @return a {@code CruiselinePassenger} built with parameters of this {@code CruiselinePassenger.Builder}
     */
    public CruiselinePassenger build() {
      return new CruiselinePassenger(this);
    }
  }
}

