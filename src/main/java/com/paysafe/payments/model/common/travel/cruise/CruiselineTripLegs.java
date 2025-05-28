// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A grouping of up to four cruise line legs. Each leg provides detailed itinerary data. <b>Note:</b> This object is only for Cruise line Merchants.
 */
public class CruiselineTripLegs {

  @JsonProperty("leg1")
  private CruiselineLeg leg1;
  @JsonProperty("leg2")
  private CruiselineLeg leg2;
  @JsonProperty("leg3")
  private CruiselineLeg leg3;
  @JsonProperty("leg4")
  private CruiselineLeg leg4;

  public CruiselineTripLegs() {
    super();
  }

  private CruiselineTripLegs(Builder builder) {
    setLeg1(builder.leg1);
    setLeg2(builder.leg2);
    setLeg3(builder.leg3);
    setLeg4(builder.leg4);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CruiselineTripLegs leg1(CruiselineLeg leg1) {
    this.leg1 = leg1;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the cruise line trip legs  <b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return leg1
   */
  public CruiselineLeg getLeg1() {
    return leg1;
  }

  public void setLeg1(CruiselineLeg leg1) {
    this.leg1 = leg1;
  }

  public CruiselineTripLegs leg2(CruiselineLeg leg2) {
    this.leg2 = leg2;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the cruise line trip legs  <b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return leg2
   */
  public CruiselineLeg getLeg2() {
    return leg2;
  }

  public void setLeg2(CruiselineLeg leg2) {
    this.leg2 = leg2;
  }

  public CruiselineTripLegs leg3(CruiselineLeg leg3) {
    this.leg3 = leg3;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the cruise line trip legs  <b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return leg3
   */
  public CruiselineLeg getLeg3() {
    return leg3;
  }

  public void setLeg3(CruiselineLeg leg3) {
    this.leg3 = leg3;
  }

  public CruiselineTripLegs leg4(CruiselineLeg leg4) {
    this.leg4 = leg4;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the cruise line trip legs  <b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return leg4
   */
  public CruiselineLeg getLeg4() {
    return leg4;
  }

  public void setLeg4(CruiselineLeg leg4) {
    this.leg4 = leg4;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselineTripLegs cruiselineTripLegs = (CruiselineTripLegs) o;
    return Objects.equals(this.leg1, cruiselineTripLegs.leg1) &&
        Objects.equals(this.leg2, cruiselineTripLegs.leg2) &&
        Objects.equals(this.leg3, cruiselineTripLegs.leg3) &&
        Objects.equals(this.leg4, cruiselineTripLegs.leg4);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leg1, leg2, leg3, leg4);
  }

  @Override
  public String toString() {

    return "class CruiselineTripLegs {\n"
        + "    leg1: " + toIndentedString(leg1) + "\n"
        + "    leg2: " + toIndentedString(leg2) + "\n"
        + "    leg3: " + toIndentedString(leg3) + "\n"
        + "    leg4: " + toIndentedString(leg4) + "\n"
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
   * {@code CruiselineTripLegs} builder static inner class.
   */
  public static final class Builder {
    private CruiselineLeg leg1;
    private CruiselineLeg leg2;
    private CruiselineLeg leg3;
    private CruiselineLeg leg4;

    private Builder() {
    }

    /**
     * Sets the {@code leg1} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg1 the {@code leg1} to set
     * @return a reference to this Builder
     */
    public Builder leg1(CruiselineLeg leg1) {
      this.leg1 = leg1;
      return this;
    }

    /**
     * Sets the {@code leg2} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg2 the {@code leg2} to set
     * @return a reference to this Builder
     */
    public Builder leg2(CruiselineLeg leg2) {
      this.leg2 = leg2;
      return this;
    }

    /**
     * Sets the {@code leg3} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg3 the {@code leg3} to set
     * @return a reference to this Builder
     */
    public Builder leg3(CruiselineLeg leg3) {
      this.leg3 = leg3;
      return this;
    }

    /**
     * Sets the {@code leg4} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg4 the {@code leg4} to set
     * @return a reference to this Builder
     */
    public Builder leg4(CruiselineLeg leg4) {
      this.leg4 = leg4;
      return this;
    }

    /**
     * Returns a {@code CruiselineTripLegs} built from the parameters previously set.
     *
     * @return a {@code CruiselineTripLegs} built with parameters of this {@code CruiselineTripLegs.Builder}
     */
    public CruiselineTripLegs build() {
      return new CruiselineTripLegs(this);
    }
  }
}

