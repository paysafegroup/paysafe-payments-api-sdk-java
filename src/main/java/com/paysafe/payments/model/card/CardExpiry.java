// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the card's expiry date.
 * <ul>
 *   <li>
 *     <b>month:</b> This is the card expiry month.  <br>
 *     Example: 12
 *   </li>
 *   <li>
 *     <b>year:</b> This is the card expiry year.  <br>
 *     Example: 2024
 *   </li>
 * </ul>
 */
public class CardExpiry {

  @JsonProperty("month")
  private Integer month;
  @JsonProperty("year")
  private Integer year;

  public CardExpiry() {
    super();
  }

  private CardExpiry(Builder builder) {
    setMonth(builder.month);
    setYear(builder.year);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CardExpiry month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * This is the card expiry month.  <br>
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

  public CardExpiry year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * This is the card expiry year.  <br>
   * Maximum: 9999
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
    CardExpiry cardExpiry = (CardExpiry) o;
    return Objects.equals(this.month, cardExpiry.month) &&
        Objects.equals(this.year, cardExpiry.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, year);
  }

  @Override
  public String toString() {

    return "class CardExpiry {\n"
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
   * {@code CardExpiry} builder static inner class.
   */
  public static final class Builder {
    private Integer month;
    private Integer year;

    private Builder() {
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
     * Returns a {@code CardExpiry} built from the parameters previously set.
     *
     * @return a {@code CardExpiry} built with parameters of this {@code CardExpiry.Builder}
     */
    public CardExpiry build() {
      return new CardExpiry(this);
    }
  }
}

