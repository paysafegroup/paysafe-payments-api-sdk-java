// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about the Airline Ticket.
 */
public class Ticket {

  @JsonProperty("ticketNumber")
  private String ticketNumber;
  @JsonProperty("isRestrictedTicket")
  private Boolean isRestrictedTicket;
  @JsonProperty("cityOfTicketIssuing")
  private String cityOfTicketIssuing;
  @JsonProperty("ticketDeliveryMethod")
  private String ticketDeliveryMethod;
  @JsonProperty("isAgencyCard")
  private Boolean agencyCard;
  @JsonProperty("ticketIssueDate")
  private String ticketIssueDate;
  @JsonProperty("ticketPrice")
  private BigDecimal ticketPrice;
  @JsonProperty("numberOfPax")
  private Integer numberOfPax;

  public Ticket() {
    super();
  }

  private Ticket(Builder builder) {
    setTicketNumber(builder.ticketNumber);
    setIsRestrictedTicket(builder.isRestrictedTicket);
    setCityOfTicketIssuing(builder.cityOfTicketIssuing);
    setTicketDeliveryMethod(builder.ticketDeliveryMethod);
    setAgencyCard(builder.isAgencyCard);
    setTicketIssueDate(builder.ticketIssueDate);
    setTicketPrice(builder.ticketPrice);
    setNumberOfPax(builder.numberOfPax);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Ticket ticketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Airline ticket number
   *
   * @return ticketNumber
   */
  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public Ticket isRestrictedTicket(Boolean isRestrictedTicket) {
    this.isRestrictedTicket = isRestrictedTicket;
    return this;
  }

  /**
   * Indicates whether this ticket is non-refundable. This entry should be supplied on CPS/Passenger Transport 1 or 2 transactions if
   * the ticket was purchased as a non-refundable ticket. Valid values are:
   * <ul>
   * <li>false - No restriction (default)  </li>
   * <li>true - Restricted (non-refundable) ticket  </li>
   * </ul>
   *
   * @return isRestrictedTicket
   */
  public Boolean getIsRestrictedTicket() {
    return isRestrictedTicket;
  }

  public void setIsRestrictedTicket(Boolean isRestrictedTicket) {
    this.isRestrictedTicket = isRestrictedTicket;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.ticketNumber, ticket.ticketNumber) &&
        Objects.equals(this.isRestrictedTicket, ticket.isRestrictedTicket) &&
        Objects.equals(this.cityOfTicketIssuing, ticket.cityOfTicketIssuing) &&
        Objects.equals(this.ticketDeliveryMethod, ticket.ticketDeliveryMethod) &&
        Objects.equals(this.agencyCard, ticket.agencyCard) &&
        Objects.equals(this.ticketIssueDate, ticket.ticketIssueDate) &&
        Objects.equals(this.ticketPrice, ticket.ticketPrice) &&
        Objects.equals(this.numberOfPax, ticket.numberOfPax);
  }

  /**
   * Place of issue for the ticket for this passenger. Required during settlement request with TSYS processor.
   *
   * @return cityOfTicketIssuing
   */
  public String getCityOfTicketIssuing() {
    return cityOfTicketIssuing;
  }

  public void setCityOfTicketIssuing(String cityOfTicketIssuing) {
    this.cityOfTicketIssuing = cityOfTicketIssuing;
  }

  /**
   * Way of delivering the ticket. Required during settlement request with TSYS processor.
   *
   * @return ticketDeliveryMethod
   */
  public String getTicketDeliveryMethod() {
    return ticketDeliveryMethod;
  }

  public void setTicketDeliveryMethod(String ticketDeliveryMethod) {
    this.ticketDeliveryMethod = ticketDeliveryMethod;
  }

  /**
   * Specifies whether the purchaser is the ticket holder or agency.
   *
   * @return isAgencyCard
   */
  public Boolean isAgencyCard() {
    return agencyCard;
  }

  public void setAgencyCard(Boolean agencyCard) {
    this.agencyCard = agencyCard;
  }

  /**
   * Ticket's issue date. Sometime it is different that the date of the transaction (can be before that).
   * Date format = YYYY-MM-DD, ISO 8601, i.e. 2021-01-26
   *
   * @return ticketIssueDate
   */
  public String getTicketIssueDate() {
    return ticketIssueDate;
  }

  public void setTicketIssueDate(String ticketIssueDate) {
    this.ticketIssueDate = ticketIssueDate;
  }

  /**
   * Price for one ticket.
   *
   * @return ticketPrice
   */
  public BigDecimal getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  /**
   * The number of the passengers which tickets are with the same PNR. Required during settlement request with TSYS processor.
   *
   * @return numberOfPax
   */
  public Integer getNumberOfPax() {
    return numberOfPax;
  }

  public void setNumberOfPax(Integer numberOfPax) {
    this.numberOfPax = numberOfPax;
  }

  /**
   * {@code Ticket} builder static inner class.
   */
  @Override
  public int hashCode() {
    return Objects.hash(ticketNumber, isRestrictedTicket, cityOfTicketIssuing,
        ticketDeliveryMethod, agencyCard, ticketIssueDate, ticketPrice, numberOfPax);
  }

  @Override
  public String toString() {

    return "class Ticket {\n"
        + "    ticketNumber: " + toIndentedString(ticketNumber) + "\n"
        + "    isRestrictedTicket: " + toIndentedString(isRestrictedTicket) + "\n"
        + "    cityOfTicketIssuing: " + toIndentedString(cityOfTicketIssuing) + "\n"
        + "    ticketDeliveryMethod: " + toIndentedString(ticketDeliveryMethod) + "\n"
        + "    agencyCard: " + toIndentedString(agencyCard) + "\n"
        + "    ticketIssueDate: " + toIndentedString(ticketIssueDate) + "\n"
        + "    ticketPrice: " + toIndentedString(ticketPrice) + "\n"
        + "    numberOfPax: " + toIndentedString(numberOfPax) + "\n"
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

  public static final class Builder {

    private String ticketNumber;
    private Boolean isRestrictedTicket;
    private String cityOfTicketIssuing;
    private String ticketDeliveryMethod;
    private Boolean isAgencyCard;
    private String ticketIssueDate;
    private BigDecimal ticketPrice;
    private Integer numberOfPax;

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
     * Sets the {@code isRestrictedTicket} and returns a reference to this Builder enabling method chaining.
     *
     * @param isRestrictedTicket the {@code isRestrictedTicket} to set
     * @return a reference to this Builder
     */
    public Builder isRestrictedTicket(Boolean isRestrictedTicket) {
      this.isRestrictedTicket = isRestrictedTicket;
      return this;
    }

    /**
     * Sets the {@code cityOfTicketIssuing} and returns a reference to this Builder enabling method chaining.
     *
     * @param cityOfTicketIssuing the {@code cityOfTicketIssuing} to set
     * @return a reference to this Builder
     */
    public Builder cityOfTicketIssuing(String cityOfTicketIssuing) {
      this.cityOfTicketIssuing = cityOfTicketIssuing;
      return this;
    }

    /**
     * Sets the {@code ticketDeliveryMethod} and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketDeliveryMethod the {@code ticketDeliveryMethod} to set
     * @return a reference to this Builder
     */
    public Builder ticketDeliveryMethod(String ticketDeliveryMethod) {
      this.ticketDeliveryMethod = ticketDeliveryMethod;
      return this;
    }

    /**
     * Sets the {@code isAgencyCard} and returns a reference to this Builder enabling method chaining.
     *
     * @param isAgencyCard the {@code isAgencyCard} to set
     * @return a reference to this Builder
     */
    public Builder isAgencyCard(Boolean isAgencyCard) {
      this.isAgencyCard = isAgencyCard;
      return this;
    }

    /**
     * Sets the {@code ticketIssueDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketIssueDate the {@code ticketIssueDate} to set
     * @return a reference to this Builder
     */
    public Builder ticketIssueDate(String ticketIssueDate) {
      this.ticketIssueDate = ticketIssueDate;
      return this;
    }

    /**
     * Sets the {@code ticketPrice} and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketPrice the {@code ticketPrice} to set
     * @return a reference to this Builder
     */
    public Builder ticketPrice(BigDecimal ticketPrice) {
      this.ticketPrice = ticketPrice;
      return this;
    }

    /**
     * Sets the {@code numberOfPax} and returns a reference to this Builder enabling method chaining.
     *
     * @param numberOfPax the {@code numberOfPax} to set
     * @return a reference to this Builder
     */
    public Builder numberOfPax(Integer numberOfPax) {
      this.numberOfPax = numberOfPax;
      return this;
    }

    /**
     * Returns a {@code Ticket} built from the parameters previously set.
     *
     * @return a {@code Ticket} built with parameters of this {@code Ticket.Builder}
     */
    public Ticket build() {
      return new Ticket(this);
    }
  }
}

