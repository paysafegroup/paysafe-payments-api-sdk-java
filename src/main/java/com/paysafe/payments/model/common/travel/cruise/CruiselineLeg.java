// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains detailed itinerary information for one of the cruise line trip legs  <b>Note:<b> This object is only for Cruise line Merchants.
 */
public class CruiselineLeg {

  @JsonProperty("fare")
  private Long fare;
  @JsonProperty("serviceClass")
  private String serviceClass;
  @JsonProperty("departureCity")
  private String departureCity;
  @JsonProperty("destinationCity")
  private String destinationCity;
  @JsonProperty("departureDate")
  private String departureDate;

  public CruiselineLeg() {
    super();
  }

  private CruiselineLeg(Builder builder) {
    setFare(builder.fare);
    setServiceClass(builder.serviceClass);
    setDepartureCity(builder.departureCity);
    setDestinationCity(builder.destinationCity);
    setDepartureDate(builder.departureDate);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CruiselineLeg fare(Long fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Indicates the total fare applied to a specific leg.
   * Required during settlement request for integration with TSYS processor. <br />
   * Maximum: 999999999999
   *
   * @return fare
   */
  public Long getFare() {
    return fare;
  }

  public void setFare(Long fare) {
    this.fare = fare;
  }

  public CruiselineLeg serviceClass(String serviceClass) {
    this.serviceClass = serviceClass;
    return this;
  }

  /**
   * Indicates service class (first class, business class, etc.). <br />
   * Example values (not limited to): <br />
   * - F - first class <br />
   * - J - business class <br />
   * - W - premium economy class <br />
   * - Y - economy class <br />
   * <p>
   * Required during settlement request for integration with TSYS processor.
   *
   * @return serviceClass
   */
  public String getServiceClass() {
    return serviceClass;
  }

  public void setServiceClass(String serviceClass) {
    this.serviceClass = serviceClass;
  }

  public CruiselineLeg departureCity(String departureCity) {
    this.departureCity = departureCity;
    return this;
  }

  /**
   * Departure City where the trip originates. Possible values are listed
   * <a href="https://unece.org/trade/cefact/unlocode-code-list-country-and-territory">here</a>.
   * Required during settlement request for integration with TSYS processor.
   *
   * @return departureCity
   */
  public String getDepartureCity() {
    return departureCity;
  }

  public void setDepartureCity(String departureCity) {
    this.departureCity = departureCity;
  }

  public CruiselineLeg destinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
    return this;
  }

  /**
   * Destination City where the trip ends. Possible values are listed
   * <a href="https://unece.org/trade/cefact/unlocode-code-list-country-and-territory">here</a>.
   * Required during authorization request with AMEX for integration with TSYS processor. <br />
   * Required during settlement request with Visa or Mastercard for integration with TSYS processor.
   *
   * @return destinationCity
   */
  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public CruiselineLeg departureDate(String departureDate) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselineLeg cruiselineLeg = (CruiselineLeg) o;
    return Objects.equals(this.fare, cruiselineLeg.fare) &&
        Objects.equals(this.serviceClass, cruiselineLeg.serviceClass) &&
        Objects.equals(this.departureCity, cruiselineLeg.departureCity) &&
        Objects.equals(this.destinationCity, cruiselineLeg.destinationCity) &&
        Objects.equals(this.departureDate, cruiselineLeg.departureDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fare, serviceClass, departureCity, destinationCity, departureDate);
  }

  @Override
  public String toString() {

    return "class CruiselineLeg {\n"
        + "    fare: " + toIndentedString(fare) + "\n"
        + "    serviceClass: " + toIndentedString(serviceClass) + "\n"
        + "    departureCity: " + toIndentedString(departureCity) + "\n"
        + "    destinationCity: " + toIndentedString(destinationCity) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
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
   * {@code CruiselineLeg} builder static inner class.
   */
  public static final class Builder {
    private Long fare;
    private String serviceClass;
    private String departureCity;
    private String destinationCity;
    private String departureDate;

    private Builder() {
    }

    /**
     * Sets the {@code fare} and returns a reference to this Builder enabling method chaining.
     *
     * @param fare the {@code fare} to set
     * @return a reference to this Builder
     */
    public Builder fare(Long fare) {
      this.fare = fare;
      return this;
    }

    /**
     * Sets the {@code serviceClass} and returns a reference to this Builder enabling method chaining.
     *
     * @param serviceClass the {@code serviceClass} to set
     * @return a reference to this Builder
     */
    public Builder serviceClass(String serviceClass) {
      this.serviceClass = serviceClass;
      return this;
    }

    /**
     * Sets the {@code departureCity} and returns a reference to this Builder enabling method chaining.
     *
     * @param departureCity the {@code departureCity} to set
     * @return a reference to this Builder
     */
    public Builder departureCity(String departureCity) {
      this.departureCity = departureCity;
      return this;
    }

    /**
     * Sets the {@code destinationCity} and returns a reference to this Builder enabling method chaining.
     *
     * @param destinationCity the {@code destinationCity} to set
     * @return a reference to this Builder
     */
    public Builder destinationCity(String destinationCity) {
      this.destinationCity = destinationCity;
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
     * Returns a {@code CruiselineLeg} built from the parameters previously set.
     *
     * @return a {@code CruiselineLeg} built with parameters of this {@code CruiselineLeg.Builder}
     */
    public CruiselineLeg build() {
      return new CruiselineLeg(this);
    }
  }
}

