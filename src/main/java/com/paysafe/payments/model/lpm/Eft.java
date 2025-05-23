// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details of the EFT account to be used for the transaction
 */
public class Eft {

  @JsonProperty("accountHolderName")
  private String accountHolderName;
  @JsonProperty("accountNumber")
  private String accountNumber;
  @JsonProperty("transitNumber")
  private String transitNumber;
  @JsonProperty("institutionId")
  private String institutionId;
  @JsonProperty("lastDigits")
  private String lastDigits;

  public Eft() {
    super();
  }

  private Eft(Builder builder) {
    setAccountHolderName(builder.accountHolderName);
    setAccountNumber(builder.accountNumber);
    setTransitNumber(builder.transitNumber);
    setInstitutionId(builder.institutionId);
    setLastDigits(builder.lastDigits);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Eft accountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return this;
  }

  /**
   * This is the name of the customer or company.
   *
   * @return accountHolderName
   */
  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public Eft accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * This is the bank account number.
   *
   * @return accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Eft transitNumber(String transitNumber) {
    this.transitNumber = transitNumber;
    return this;
  }

  /**
   * This is the 5-digit transit number of the customer's bank branch.
   *
   * @return transitNumber
   */
  public String getTransitNumber() {
    return transitNumber;
  }

  public void setTransitNumber(String transitNumber) {
    this.transitNumber = transitNumber;
  }

  public Eft institutionId(String institutionId) {
    this.institutionId = institutionId;
    return this;
  }

  /**
   * This is the 3-digit institution ID of the customer’s bank branch.
   *
   * @return institutionId
   */
  public String getInstitutionId() {
    return institutionId;
  }

  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }

  public Eft lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * It contains only last 2 digits of bank account.
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
    Eft eft = (Eft) o;
    return Objects.equals(this.accountHolderName, eft.accountHolderName) &&
        Objects.equals(this.accountNumber, eft.accountNumber) &&
        Objects.equals(this.transitNumber, eft.transitNumber) &&
        Objects.equals(this.institutionId, eft.institutionId) &&
        Objects.equals(this.lastDigits, eft.lastDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountHolderName, accountNumber, transitNumber, institutionId, lastDigits);
  }

  @Override
  public String toString() {

    return "class Eft {\n"
        + "    accountHolderName: " + toIndentedString(accountHolderName) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
        + "    transitNumber: " + toIndentedString(transitNumber) + "\n"
        + "    institutionId: " + toIndentedString(institutionId) + "\n"
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
   * {@code Eft} builder static inner class.
   */
  public static final class Builder {
    private String accountHolderName;
    private String accountNumber;
    private String transitNumber;
    private String institutionId;
    private String lastDigits;

    private Builder() {
    }

    /**
     * Sets the {@code accountHolderName} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountHolderName the {@code accountHolderName} to set
     * @return a reference to this Builder
     */
    public Builder accountHolderName(String accountHolderName) {
      this.accountHolderName = accountHolderName;
      return this;
    }

    /**
     * Sets the {@code accountNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountNumber the {@code accountNumber} to set
     * @return a reference to this Builder
     */
    public Builder accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    /**
     * Sets the {@code transitNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param transitNumber the {@code transitNumber} to set
     * @return a reference to this Builder
     */
    public Builder transitNumber(String transitNumber) {
      this.transitNumber = transitNumber;
      return this;
    }

    /**
     * Sets the {@code institutionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param institutionId the {@code institutionId} to set
     * @return a reference to this Builder
     */
    public Builder institutionId(String institutionId) {
      this.institutionId = institutionId;
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
     * Returns a {@code Eft} built from the parameters previously set.
     *
     * @return a {@code Eft} built with parameters of this {@code Eft.Builder}
     */
    public Eft build() {
      return new Eft(this);
    }
  }
}

