// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A grouping of four separate trip segments. Each leg contains detailed itinerary information.
 */
public class TripLegs {

  @JsonProperty("leg1")
  private Leg leg1;
  @JsonProperty("leg2")
  private Leg leg2;
  @JsonProperty("leg3")
  private Leg leg3;
  @JsonProperty("leg4")
  private Leg leg4;

  public TripLegs() {
    super();
  }

  private TripLegs(Builder builder) {
    setLeg1(builder.leg1);
    setLeg2(builder.leg2);
    setLeg3(builder.leg3);
    setLeg4(builder.leg4);
  }

  public static Builder builder() {
    return new Builder();
  }

  public TripLegs leg1(Leg leg1) {
    this.leg1 = leg1;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the trip legs
   *
   * @return leg1
   */
  public Leg getLeg1() {
    return leg1;
  }

  public void setLeg1(Leg leg1) {
    this.leg1 = leg1;
  }

  public TripLegs leg2(Leg leg2) {
    this.leg2 = leg2;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the trip legs
   *
   * @return leg2
   */
  public Leg getLeg2() {
    return leg2;
  }

  public void setLeg2(Leg leg2) {
    this.leg2 = leg2;
  }

  public TripLegs leg3(Leg leg3) {
    this.leg3 = leg3;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the trip legs
   *
   * @return leg3
   */
  public Leg getLeg3() {
    return leg3;
  }

  public void setLeg3(Leg leg3) {
    this.leg3 = leg3;
  }

  public TripLegs leg4(Leg leg4) {
    this.leg4 = leg4;
    return this;
  }

  /**
   * Contains detailed itinerary information for one of the trip legs
   *
   * @return leg4
   */
  public Leg getLeg4() {
    return leg4;
  }

  public void setLeg4(Leg leg4) {
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
    TripLegs tripLegs = (TripLegs) o;
    return Objects.equals(this.leg1, tripLegs.leg1) &&
        Objects.equals(this.leg2, tripLegs.leg2) &&
        Objects.equals(this.leg3, tripLegs.leg3) &&
        Objects.equals(this.leg4, tripLegs.leg4);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leg1, leg2, leg3, leg4);
  }

  @Override
  public String toString() {

    return "class TripLegs {\n"
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
   * {@code TripLegs} builder static inner class.
   */
  public static final class Builder {
    private Leg leg1;
    private Leg leg2;
    private Leg leg3;
    private Leg leg4;

    private Builder() {
    }

    /**
     * Sets the {@code leg1} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg1 the {@code leg1} to set
     * @return a reference to this Builder
     */
    public Builder leg1(Leg leg1) {
      this.leg1 = leg1;
      return this;
    }

    /**
     * Sets the {@code leg2} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg2 the {@code leg2} to set
     * @return a reference to this Builder
     */
    public Builder leg2(Leg leg2) {
      this.leg2 = leg2;
      return this;
    }

    /**
     * Sets the {@code leg3} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg3 the {@code leg3} to set
     * @return a reference to this Builder
     */
    public Builder leg3(Leg leg3) {
      this.leg3 = leg3;
      return this;
    }

    /**
     * Sets the {@code leg4} and returns a reference to this Builder enabling method chaining.
     *
     * @param leg4 the {@code leg4} to set
     * @return a reference to this Builder
     */
    public Builder leg4(Leg leg4) {
      this.leg4 = leg4;
      return this;
    }

    /**
     * Returns a {@code TripLegs} built from the parameters previously set.
     *
     * @return a {@code TripLegs} built with parameters of this {@code TripLegs.Builder}
     */
    public TripLegs build() {
      return new TripLegs(this);
    }
  }
}

