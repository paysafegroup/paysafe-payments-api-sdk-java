// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the expiry date of the DPAN (the token).
 * <ul>
 *   <li>
 *     <b>month:</b> This is the token expiry month.  <br>
 *     Example: 12
 *   </li>
 *   <li>
 *     <b>year:</b> This is the token expiry year.  <br>
 *     Example: 2024
 *   </li>
 * </ul>
 */
public class TokenExpiry {

  @JsonProperty("month")
  private Long month;
  @JsonProperty("year")
  private Long year;

  public TokenExpiry() {
    super();
  }

  private TokenExpiry(Builder builder) {
    setMonth(builder.month);
    setYear(builder.year);
  }

  public static Builder builder() {
    return new Builder();
  }

  public TokenExpiry month(Long month) {
    this.month = month;
    return this;
  }

  /**
   * This is the token expiry month.  <br>
   * Maximum: 12
   *
   * @return month
   */
  public Long getMonth() {
    return month;
  }

  public void setMonth(Long month) {
    this.month = month;
  }

  public TokenExpiry year(Long year) {
    this.year = year;
    return this;
  }

  /**
   * This is the token expiry year.  <br>
   * Maximum: 9999
   *
   * @return year
   */
  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
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
    TokenExpiry tokenExpiry = (TokenExpiry) o;
    return Objects.equals(this.month, tokenExpiry.month) &&
        Objects.equals(this.year, tokenExpiry.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, year);
  }

  @Override
  public String toString() {

    return "class TokenExpiry {\n"
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
   * {@code TokenExpiry} builder static inner class.
   */
  public static final class Builder {
    private Long month;
    private Long year;

    private Builder() {
    }

    /**
     * Sets the {@code month} and returns a reference to this Builder enabling method chaining.
     *
     * @param month the {@code month} to set
     * @return a reference to this Builder
     */
    public Builder month(Long month) {
      this.month = month;
      return this;
    }

    /**
     * Sets the {@code year} and returns a reference to this Builder enabling method chaining.
     *
     * @param year the {@code year} to set
     * @return a reference to this Builder
     */
    public Builder year(Long year) {
      this.year = year;
      return this;
    }

    /**
     * Returns a {@code TokenExpiry} built from the parameters previously set.
     *
     * @return a {@code TokenExpiry} built with parameters of this {@code TokenExpiry.Builder}
     */
    public TokenExpiry build() {
      return new TokenExpiry(this);
    }
  }
}

