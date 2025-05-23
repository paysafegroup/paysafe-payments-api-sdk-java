// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A grouping of up to ten airline travel passengers.
 */
public class Passengers {

  @JsonProperty("passenger1")
  private Passenger passenger1;
  @JsonProperty("passenger2")
  private Passenger passenger2;
  @JsonProperty("passenger3")
  private Passenger passenger3;
  @JsonProperty("passenger4")
  private Passenger passenger4;
  @JsonProperty("passenger5")
  private Passenger passenger5;
  @JsonProperty("passenger6")
  private Passenger passenger6;
  @JsonProperty("passenger7")
  private Passenger passenger7;
  @JsonProperty("passenger8")
  private Passenger passenger8;
  @JsonProperty("passenger9")
  private Passenger passenger9;
  @JsonProperty("passenger10")
  private Passenger passenger10;

  public Passengers() {
    super();
  }

  private Passengers(final Builder builder) {
    setPassenger1(builder.passenger1);
    setPassenger2(builder.passenger2);
    setPassenger3(builder.passenger3);
    setPassenger4(builder.passenger4);
    setPassenger5(builder.passenger5);
    setPassenger6(builder.passenger6);
    setPassenger7(builder.passenger7);
    setPassenger8(builder.passenger8);
    setPassenger9(builder.passenger9);
    setPassenger10(builder.passenger10);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Passengers passenger1(Passenger passenger1) {
    this.passenger1 = passenger1;
    return this;
  }

  /**
   * Get passenger1
   *
   * @return passenger1
   */
  public Passenger getPassenger1() {
    return passenger1;
  }

  public void setPassenger1(Passenger passenger1) {
    this.passenger1 = passenger1;
  }

  public Passengers passenger2(Passenger passenger2) {
    this.passenger2 = passenger2;
    return this;
  }

  /**
   * Get passenger2
   *
   * @return passenger2
   */
  public Passenger getPassenger2() {
    return passenger2;
  }

  public void setPassenger2(Passenger passenger2) {
    this.passenger2 = passenger2;
  }

  public Passengers passenger3(Passenger passenger3) {
    this.passenger3 = passenger3;
    return this;
  }

  /**
   * Get passenger3
   *
   * @return passenger3
   */
  public Passenger getPassenger3() {
    return passenger3;
  }

  public void setPassenger3(Passenger passenger3) {
    this.passenger3 = passenger3;
  }

  public Passengers passenger4(Passenger passenger4) {
    this.passenger4 = passenger4;
    return this;
  }

  /**
   * Get passenger4
   *
   * @return passenger4
   */
  public Passenger getPassenger4() {
    return passenger4;
  }

  public void setPassenger4(Passenger passenger4) {
    this.passenger4 = passenger4;
  }

  public Passengers passenger5(Passenger passenger5) {
    this.passenger5 = passenger5;
    return this;
  }

  /**
   * Get passenger5
   *
   * @return passenger5
   */
  public Passenger getPassenger5() {
    return passenger5;
  }

  public void setPassenger5(Passenger passenger5) {
    this.passenger5 = passenger5;
  }

  public Passengers passenger6(Passenger passenger6) {
    this.passenger6 = passenger6;
    return this;
  }

  /**
   * Get passenger6
   *
   * @return passenger6
   */
  public Passenger getPassenger6() {
    return passenger6;
  }

  public void setPassenger6(Passenger passenger6) {
    this.passenger6 = passenger6;
  }

  /**
   * Get passenger7
   *
   * @return passenger7
   */
  public Passenger getPassenger7() {
    return passenger7;
  }

  public void setPassenger7(final Passenger passenger7) {
    this.passenger7 = passenger7;
  }

  /**
   * Get passenger8
   *
   * @return passenger8
   */
  public Passenger getPassenger8() {
    return passenger8;
  }

  public void setPassenger8(final Passenger passenger8) {
    this.passenger8 = passenger8;
  }

  /**
   * Get passenger9
   *
   * @return passenger9
   */
  public Passenger getPassenger9() {
    return passenger9;
  }

  public void setPassenger9(final Passenger passenger9) {
    this.passenger9 = passenger9;
  }

  /**
   * Get passenger10
   *
   * @return passenger10
   */
  public Passenger getPassenger10() {
    return passenger10;
  }

  public void setPassenger10(final Passenger passenger10) {
    this.passenger10 = passenger10;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Passengers passengers = (Passengers) o;
    return Objects.equals(this.passenger1, passengers.passenger1) &&
        Objects.equals(this.passenger2, passengers.passenger2) &&
        Objects.equals(this.passenger3, passengers.passenger3) &&
        Objects.equals(this.passenger4, passengers.passenger4) &&
        Objects.equals(this.passenger5, passengers.passenger5) &&
        Objects.equals(this.passenger6, passengers.passenger6) &&
        Objects.equals(this.passenger7, passengers.passenger7) &&
        Objects.equals(this.passenger8, passengers.passenger8) &&
        Objects.equals(this.passenger9, passengers.passenger9) &&
        Objects.equals(this.passenger10, passengers.passenger10);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passenger1, passenger2, passenger3, passenger4, passenger5, passenger6, passenger7, passenger8, passenger9, passenger10);
  }

  @Override
  public String toString() {

    return "class Passengers {\n"
        + "    passenger1: " + toIndentedString(passenger1) + "\n"
        + "    passenger2: " + toIndentedString(passenger2) + "\n"
        + "    passenger3: " + toIndentedString(passenger3) + "\n"
        + "    passenger4: " + toIndentedString(passenger4) + "\n"
        + "    passenger5: " + toIndentedString(passenger5) + "\n"
        + "    passenger6: " + toIndentedString(passenger6) + "\n"
        + "    passenger7: " + toIndentedString(passenger7) + "\n"
        + "    passenger8: " + toIndentedString(passenger8) + "\n"
        + "    passenger9: " + toIndentedString(passenger9) + "\n"
        + "    passenger10: " + toIndentedString(passenger10) + "\n"
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
   * {@code Passengers} builder static inner class.
   */
  public static final class Builder {
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private Passenger passenger5;
    private Passenger passenger6;
    private Passenger passenger7;
    private Passenger passenger8;
    private Passenger passenger9;
    private Passenger passenger10;

    private Builder() {
    }

    /**
     * Sets the {@code passenger1} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger1 the {@code passenger1} to set
     * @return a reference to this Builder
     */
    public Builder passenger1(Passenger passenger1) {
      this.passenger1 = passenger1;
      return this;
    }

    /**
     * Sets the {@code passenger2} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger2 the {@code passenger2} to set
     * @return a reference to this Builder
     */
    public Builder passenger2(Passenger passenger2) {
      this.passenger2 = passenger2;
      return this;
    }

    /**
     * Sets the {@code passenger3} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger3 the {@code passenger3} to set
     * @return a reference to this Builder
     */
    public Builder passenger3(Passenger passenger3) {
      this.passenger3 = passenger3;
      return this;
    }

    /**
     * Sets the {@code passenger4} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger4 the {@code passenger4} to set
     * @return a reference to this Builder
     */
    public Builder passenger4(Passenger passenger4) {
      this.passenger4 = passenger4;
      return this;
    }

    /**
     * Sets the {@code passenger5} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger5 the {@code passenger5} to set
     * @return a reference to this Builder
     */
    public Builder passenger5(Passenger passenger5) {
      this.passenger5 = passenger5;
      return this;
    }

    /**
     * Sets the {@code passenger6} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger6 the {@code passenger6} to set
     * @return a reference to this Builder
     */
    public Builder passenger6(Passenger passenger6) {
      this.passenger6 = passenger6;
      return this;
    }

    /**
     * Sets the {@code passenger7} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code passenger7} to set
     * @return a reference to this Builder
     */
    public Builder passenger7(final Passenger val) {
      passenger7 = val;
      return this;
    }

    /**
     * Sets the {@code passenger8} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code passenger8} to set
     * @return a reference to this Builder
     */
    public Builder passenger8(final Passenger val) {
      passenger8 = val;
      return this;
    }

    /**
     * Sets the {@code passenger9} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code passenger9} to set
     * @return a reference to this Builder
     */
    public Builder passenger9(final Passenger val) {
      passenger9 = val;
      return this;
    }

    /**
     * Sets the {@code passenger10} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code passenger10} to set
     * @return a reference to this Builder
     */
    public Builder passenger10(final Passenger val) {
      passenger10 = val;
      return this;
    }

    /**
     * Returns a {@code Passengers} built from the parameters previously set.
     *
     * @return a {@code Passengers} built with parameters of this {@code Passengers.Builder}
     */
    public Passengers build() {
      return new Passengers(this);
    }
  }
}

