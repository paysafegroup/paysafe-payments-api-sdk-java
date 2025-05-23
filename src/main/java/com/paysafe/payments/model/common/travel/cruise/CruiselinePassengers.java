// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A grouping of up to ten cruise line passengers. <b>Note:</b> This object is only for Cruise line Merchants.
 */
public class CruiselinePassengers {

  @JsonProperty("passenger1")
  private CruiselinePassenger passenger1;
  @JsonProperty("passenger2")
  private CruiselinePassenger passenger2;
  @JsonProperty("passenger3")
  private CruiselinePassenger passenger3;
  @JsonProperty("passenger4")
  private CruiselinePassenger passenger4;
  @JsonProperty("passenger5")
  private CruiselinePassenger passenger5;
  @JsonProperty("passenger6")
  private CruiselinePassenger passenger6;
  @JsonProperty("passenger7")
  private CruiselinePassenger passenger7;
  @JsonProperty("passenger8")
  private CruiselinePassenger passenger8;
  @JsonProperty("passenger9")
  private CruiselinePassenger passenger9;
  @JsonProperty("passenger10")
  private CruiselinePassenger passenger10;

  public CruiselinePassengers() {
    super();
  }

  private CruiselinePassengers(Builder builder) {
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

  public CruiselinePassengers passenger1(CruiselinePassenger passenger1) {
    this.passenger1 = passenger1;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger1
   */
  public CruiselinePassenger getPassenger1() {
    return passenger1;
  }

  public void setPassenger1(CruiselinePassenger passenger1) {
    this.passenger1 = passenger1;
  }

  public CruiselinePassengers passenger2(CruiselinePassenger passenger2) {
    this.passenger2 = passenger2;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger2
   */
  public CruiselinePassenger getPassenger2() {
    return passenger2;
  }

  public void setPassenger2(CruiselinePassenger passenger2) {
    this.passenger2 = passenger2;
  }

  public CruiselinePassengers passenger3(CruiselinePassenger passenger3) {
    this.passenger3 = passenger3;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger3
   */
  public CruiselinePassenger getPassenger3() {
    return passenger3;
  }

  public void setPassenger3(CruiselinePassenger passenger3) {
    this.passenger3 = passenger3;
  }

  public CruiselinePassengers passenger4(CruiselinePassenger passenger4) {
    this.passenger4 = passenger4;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger4
   */
  public CruiselinePassenger getPassenger4() {
    return passenger4;
  }

  public void setPassenger4(CruiselinePassenger passenger4) {
    this.passenger4 = passenger4;
  }

  public CruiselinePassengers passenger5(CruiselinePassenger passenger5) {
    this.passenger5 = passenger5;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger5
   */
  public CruiselinePassenger getPassenger5() {
    return passenger5;
  }

  public void setPassenger5(CruiselinePassenger passenger5) {
    this.passenger5 = passenger5;
  }

  public CruiselinePassengers passenger6(CruiselinePassenger passenger6) {
    this.passenger6 = passenger6;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger6
   */
  public CruiselinePassenger getPassenger6() {
    return passenger6;
  }

  public void setPassenger6(CruiselinePassenger passenger6) {
    this.passenger6 = passenger6;
  }

  public CruiselinePassengers passenger7(CruiselinePassenger passenger7) {
    this.passenger7 = passenger7;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger7
   */
  public CruiselinePassenger getPassenger7() {
    return passenger7;
  }

  public void setPassenger7(CruiselinePassenger passenger7) {
    this.passenger7 = passenger7;
  }

  public CruiselinePassengers passenger8(CruiselinePassenger passenger8) {
    this.passenger8 = passenger8;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger8
   */
  public CruiselinePassenger getPassenger8() {
    return passenger8;
  }

  public void setPassenger8(CruiselinePassenger passenger8) {
    this.passenger8 = passenger8;
  }

  public CruiselinePassengers passenger9(CruiselinePassenger passenger9) {
    this.passenger9 = passenger9;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger9
   */
  public CruiselinePassenger getPassenger9() {
    return passenger9;
  }

  public void setPassenger9(CruiselinePassenger passenger9) {
    this.passenger9 = passenger9;
  }

  public CruiselinePassengers passenger10(CruiselinePassenger passenger10) {
    this.passenger10 = passenger10;
    return this;
  }

  /**
   * Cruise line passenger.<b>Note:</b> This object is only for Cruise line Merchants.
   *
   * @return passenger10
   */
  public CruiselinePassenger getPassenger10() {
    return passenger10;
  }

  public void setPassenger10(CruiselinePassenger passenger10) {
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
    CruiselinePassengers cruiselinePassengers = (CruiselinePassengers) o;
    return Objects.equals(this.passenger1, cruiselinePassengers.passenger1) &&
        Objects.equals(this.passenger2, cruiselinePassengers.passenger2) &&
        Objects.equals(this.passenger3, cruiselinePassengers.passenger3) &&
        Objects.equals(this.passenger4, cruiselinePassengers.passenger4) &&
        Objects.equals(this.passenger5, cruiselinePassengers.passenger5) &&
        Objects.equals(this.passenger6, cruiselinePassengers.passenger6) &&
        Objects.equals(this.passenger7, cruiselinePassengers.passenger7) &&
        Objects.equals(this.passenger8, cruiselinePassengers.passenger8) &&
        Objects.equals(this.passenger9, cruiselinePassengers.passenger9) &&
        Objects.equals(this.passenger10, cruiselinePassengers.passenger10);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passenger1, passenger2, passenger3, passenger4, passenger5, passenger6, passenger7, passenger8, passenger9, passenger10);
  }

  @Override
  public String toString() {

    return "class CruiselinePassengers {\n"
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
   * {@code CruiselinePassengers} builder static inner class.
   */
  public static final class Builder {
    private CruiselinePassenger passenger1;
    private CruiselinePassenger passenger2;
    private CruiselinePassenger passenger3;
    private CruiselinePassenger passenger4;
    private CruiselinePassenger passenger5;
    private CruiselinePassenger passenger6;
    private CruiselinePassenger passenger7;
    private CruiselinePassenger passenger8;
    private CruiselinePassenger passenger9;
    private CruiselinePassenger passenger10;

    private Builder() {
    }

    /**
     * Sets the {@code passenger1} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger1 the {@code passenger1} to set
     * @return a reference to this Builder
     */
    public Builder passenger1(CruiselinePassenger passenger1) {
      this.passenger1 = passenger1;
      return this;
    }

    /**
     * Sets the {@code passenger2} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger2 the {@code passenger2} to set
     * @return a reference to this Builder
     */
    public Builder passenger2(CruiselinePassenger passenger2) {
      this.passenger2 = passenger2;
      return this;
    }

    /**
     * Sets the {@code passenger3} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger3 the {@code passenger3} to set
     * @return a reference to this Builder
     */
    public Builder passenger3(CruiselinePassenger passenger3) {
      this.passenger3 = passenger3;
      return this;
    }

    /**
     * Sets the {@code passenger4} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger4 the {@code passenger4} to set
     * @return a reference to this Builder
     */
    public Builder passenger4(CruiselinePassenger passenger4) {
      this.passenger4 = passenger4;
      return this;
    }

    /**
     * Sets the {@code passenger5} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger5 the {@code passenger5} to set
     * @return a reference to this Builder
     */
    public Builder passenger5(CruiselinePassenger passenger5) {
      this.passenger5 = passenger5;
      return this;
    }

    /**
     * Sets the {@code passenger6} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger6 the {@code passenger6} to set
     * @return a reference to this Builder
     */
    public Builder passenger6(CruiselinePassenger passenger6) {
      this.passenger6 = passenger6;
      return this;
    }

    /**
     * Sets the {@code passenger7} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger7 the {@code passenger7} to set
     * @return a reference to this Builder
     */
    public Builder passenger7(CruiselinePassenger passenger7) {
      this.passenger7 = passenger7;
      return this;
    }

    /**
     * Sets the {@code passenger8} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger8 the {@code passenger8} to set
     * @return a reference to this Builder
     */
    public Builder passenger8(CruiselinePassenger passenger8) {
      this.passenger8 = passenger8;
      return this;
    }

    /**
     * Sets the {@code passenger9} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger9 the {@code passenger9} to set
     * @return a reference to this Builder
     */
    public Builder passenger9(CruiselinePassenger passenger9) {
      this.passenger9 = passenger9;
      return this;
    }

    /**
     * Sets the {@code passenger10} and returns a reference to this Builder enabling method chaining.
     *
     * @param passenger10 the {@code passenger10} to set
     * @return a reference to this Builder
     */
    public Builder passenger10(CruiselinePassenger passenger10) {
      this.passenger10 = passenger10;
      return this;
    }

    /**
     * Returns a {@code CruiselinePassengers} built from the parameters previously set.
     *
     * @return a {@code CruiselinePassengers} built with parameters of this {@code CruiselinePassengers.Builder}
     */
    public CruiselinePassengers build() {
      return new CruiselinePassengers(this);
    }
  }
}

