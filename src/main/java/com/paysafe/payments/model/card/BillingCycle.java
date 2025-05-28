// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details of the billing cycle information for recurring payments.
 * Mandatory if authenticationPurpose = INSTALMENT_TRANSACTION or RECURRING_TRANSACTION.
 */
public class BillingCycle {

  @JsonProperty("endDate")
  private LocalDate endDate;
  @JsonProperty("frequency")
  private Long frequency;

  public BillingCycle() {
    super();
  }

  private BillingCycle(Builder builder) {
    setEndDate(builder.endDate);
    setFrequency(builder.frequency);
  }

  public static Builder builder() {
    return new Builder();
  }

  public BillingCycle endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * This is the date after which no further authorizations will be performed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return endDate
   */
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public BillingCycle frequency(Long frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * This is the minimum number of days between authorizations.
   *
   * @return frequency
   */
  public Long getFrequency() {
    return frequency;
  }

  public void setFrequency(Long frequency) {
    this.frequency = frequency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingCycle billingCycle = (BillingCycle) o;
    return Objects.equals(this.endDate, billingCycle.endDate) &&
        Objects.equals(this.frequency, billingCycle.frequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endDate, frequency);
  }

  @Override
  public String toString() {

    return "class BillingCycle {\n"
        + "    endDate: " + toIndentedString(endDate) + "\n"
        + "    frequency: " + toIndentedString(frequency) + "\n"
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
   * {@code BillingCycle} builder static inner class.
   */
  public static final class Builder {
    private LocalDate endDate;
    private Long frequency;

    private Builder() {
    }

    /**
     * Sets the {@code endDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param endDate the {@code endDate} to set
     * @return a reference to this Builder
     */
    public Builder endDate(LocalDate endDate) {
      this.endDate = endDate;
      return this;
    }

    /**
     * Sets the {@code frequency} and returns a reference to this Builder enabling method chaining.
     *
     * @param frequency the {@code frequency} to set
     * @return a reference to this Builder
     */
    public Builder frequency(Long frequency) {
      this.frequency = frequency;
      return this;
    }

    /**
     * Returns a {@code BillingCycle} built from the parameters previously set.
     *
     * @return a {@code BillingCycle} built with parameters of this {@code BillingCycle.Builder}
     */
    public BillingCycle build() {
      return new BillingCycle(this);
    }
  }
}

