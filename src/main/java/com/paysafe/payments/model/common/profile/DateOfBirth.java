// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.profile;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the recipient&#39;s date of birth.  <b>Note:</b> Required for Pay by Bank.
 */
public class DateOfBirth {

  @JsonProperty("day")
  private Integer day;
  @JsonProperty("month")
  private Integer month;
  @JsonProperty("year")
  private Integer year;

  public DateOfBirth() {
    super();
  }

  private DateOfBirth(Builder builder) {
    setDay(builder.day);
    setMonth(builder.month);
    setYear(builder.year);
  }

  public static Builder builder() {
    return new Builder();
  }

  public DateOfBirth day(Integer day) {
    this.day = day;
    return this;
  }

  /**
   * This is the day of birth.  <br>
   * Maximum: 31
   *
   * @return day
   */
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public DateOfBirth month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * This is the month of birth.  <br>
   * Maximum: 12
   *
   * @return month
   */
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public DateOfBirth year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * This is the year of birth.  <br>
   * Minimum: 1900
   *
   * @return year
   */
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DateOfBirth dateOfBirth = (DateOfBirth) o;
    return Objects.equals(this.day, dateOfBirth.day) &&
        Objects.equals(this.month, dateOfBirth.month) &&
        Objects.equals(this.year, dateOfBirth.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, month, year);
  }

  @Override
  public String toString() {

    return "class DateOfBirth {\n"
        + "    day: " + toIndentedString(day) + "\n"
        + "    month: " + toIndentedString(month) + "\n"
        + "    year: " + toIndentedString(year) + "\n"
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
   * {@code DateOfBirth} builder static inner class.
   */
  public static final class Builder {
    private Integer day;
    private Integer month;
    private Integer year;

    private Builder() {
    }

    /**
     * Sets the {@code day} and returns a reference to this Builder enabling method chaining.
     *
     * @param day the {@code day} to set
     * @return a reference to this Builder
     */
    public Builder day(Integer day) {
      this.day = day;
      return this;
    }

    /**
     * Sets the {@code month} and returns a reference to this Builder enabling method chaining.
     *
     * @param month the {@code month} to set
     * @return a reference to this Builder
     */
    public Builder month(Integer month) {
      this.month = month;
      return this;
    }

    /**
     * Sets the {@code year} and returns a reference to this Builder enabling method chaining.
     *
     * @param year the {@code year} to set
     * @return a reference to this Builder
     */
    public Builder year(Integer year) {
      this.year = year;
      return this;
    }

    /**
     * Returns a {@code DateOfBirth} built from the parameters previously set.
     *
     * @return a {@code DateOfBirth} built with parameters of this {@code DateOfBirth.Builder}
     */
    public DateOfBirth build() {
      return new DateOfBirth(this);
    }
  }
}

