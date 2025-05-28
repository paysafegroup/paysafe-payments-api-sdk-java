// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.lpm.enums.BankAccountType;

/**
 * This is an array containing a list of bank accounts that the consumer has linked in order to make Pay by Bank payments, along with additional
 * information about those accounts.
 */
public class PayByBankAch {

  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("accountType")
  private BankAccountType accountType;
  @JsonProperty("routingNumber")
  private String routingNumber;
  @JsonProperty("lastDigits")
  private String lastDigits;

  public PayByBankAch() {
    super();
  }

  private PayByBankAch(Builder builder) {
    setPaymentHandleToken(builder.paymentHandleToken);
    setAccountType(builder.accountType);
    setRoutingNumber(builder.routingNumber);
    setLastDigits(builder.lastDigits);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PayByBankAch paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is a token representing an individual bank account that the consumer has linked in order to make Pay by Bank payments.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  public PayByBankAch accountType(BankAccountType accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * This provides you with the type of bank account for information purposes.
   *
   * @return accountType
   */
  public BankAccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(BankAccountType accountType) {
    this.accountType = accountType;
  }

  public PayByBankAch routingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
    return this;
  }

  /**
   * This is the 9-digit routing number of the bank.
   *
   * @return routingNumber
   */
  public String getRoutingNumber() {
    return routingNumber;
  }

  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }

  public PayByBankAch lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * This is returned in response. It contains only last 2 digits of bank account.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayByBankAch payByBankAch = (PayByBankAch) o;
    return Objects.equals(this.paymentHandleToken, payByBankAch.paymentHandleToken) &&
        Objects.equals(this.accountType, payByBankAch.accountType) &&
        Objects.equals(this.routingNumber, payByBankAch.routingNumber) &&
        Objects.equals(this.lastDigits, payByBankAch.lastDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentHandleToken, accountType, routingNumber, lastDigits);
  }

  @Override
  public String toString() {

    return "class PayByBankAch {\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    accountType: " + toIndentedString(accountType) + "\n"
        + "    routingNumber: " + toIndentedString(routingNumber) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
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
   * {@code PayByBankAch} builder static inner class.
   */
  public static final class Builder {
    private String paymentHandleToken;
    private BankAccountType accountType;
    private String routingNumber;
    private String lastDigits;

    private Builder() {
    }

    /**
     * Sets the {@code paymentHandleToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleToken the {@code paymentHandleToken} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleToken(String paymentHandleToken) {
      this.paymentHandleToken = paymentHandleToken;
      return this;
    }

    /**
     * Sets the {@code accountType} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountType the {@code accountType} to set
     * @return a reference to this Builder
     */
    public Builder accountType(BankAccountType accountType) {
      this.accountType = accountType;
      return this;
    }

    /**
     * Sets the {@code routingNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param routingNumber the {@code routingNumber} to set
     * @return a reference to this Builder
     */
    public Builder routingNumber(String routingNumber) {
      this.routingNumber = routingNumber;
      return this;
    }

    /**
     * Sets the {@code lastDigits} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the {@code lastDigits} to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * Returns a {@code PayByBankAch} built from the parameters previously set.
     *
     * @return a {@code PayByBankAch} built with parameters of this {@code PayByBankAch.Builder}
     */
    public PayByBankAch build() {
      return new PayByBankAch(this);
    }
  }
}

