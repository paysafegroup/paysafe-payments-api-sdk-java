// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.AccountCreatedRange;

/**
 * These are the details of the current payment account of the cardholder.
 * <ul>
 * <li>
 * <b>createdRange:</b> This indicates the length of time that the payment account was enrolled in the cardholder’s
 * account with the 3DS Requestor.Allowed values: NO_ACCOUNT, DURING_TRANSACTION, LESS_THAN_THIRTY_DAYS, THIRTY_TO_SIXTY_DAYS, MORE_THAN_SIXTY_DAYS
 * </li>
 * <li>
 * <b>createdDate:</b> This is the date that the cardholder opened the account with the 3DS Requestor.
 * The ISO 8601 date format is expected, i.e., YYYY-MM-DD.e.
 * </li>
 * </ul>
 */
public class PaymentAccountDetails {

  @JsonProperty("createdRange")
  private AccountCreatedRange createdRange;
  @JsonProperty("createdDate")
  private String createdDate;

  public PaymentAccountDetails() {
    super();
  }

  private PaymentAccountDetails(Builder builder) {
    setCreatedRange(builder.accountCreatedRange);
    setCreatedDate(builder.createdDate);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentAccountDetails createdRange(AccountCreatedRange accountCreatedRange) {
    this.createdRange = accountCreatedRange;
    return this;
  }

  /**
   * This indicates the length of time that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.
   *
   * @return createdRange
   */
  public AccountCreatedRange getCreatedRange() {
    return createdRange;
  }

  public void setCreatedRange(AccountCreatedRange accountCreatedRange) {
    this.createdRange = accountCreatedRange;
  }

  public PaymentAccountDetails createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * This is the date that the cardholder opened the account with the 3DS Requestor. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.e.
   *
   * @return createdDate
   */
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentAccountDetails paymentAccountDetails = (PaymentAccountDetails) o;
    return Objects.equals(this.createdRange, paymentAccountDetails.createdRange) &&
        Objects.equals(this.createdDate, paymentAccountDetails.createdDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdRange, createdDate);
  }

  @Override
  public String toString() {

    return "class PaymentAccountDetails {\n"
        + "    accountCreatedRange: " + toIndentedString(createdRange) + "\n"
        + "    createdDate: " + toIndentedString(createdDate) + "\n"
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
   * {@code PaymentAccountDetails} builder static inner class.
   */
  public static final class Builder {
    private AccountCreatedRange accountCreatedRange;
    private String createdDate;

    private Builder() {
    }

    /**
     * Sets the {@code createdRange} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountCreatedRange the {@code createdRange} to set
     * @return a reference to this Builder
     */
    public Builder createdRange(AccountCreatedRange accountCreatedRange) {
      this.accountCreatedRange = accountCreatedRange;
      return this;
    }

    /**
     * Sets the {@code createdDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param createdDate the {@code createdDate} to set
     * @return a reference to this Builder
     */
    public Builder createdDate(String createdDate) {
      this.createdDate = createdDate;
      return this;
    }

    /**
     * Returns a {@code PaymentAccountDetails} built from the parameters previously set.
     *
     * @return a {@code PaymentAccountDetails} built with parameters of this {@code PaymentAccountDetails.Builder}
     */
    public PaymentAccountDetails build() {
      return new PaymentAccountDetails(this);
    }
  }
}

