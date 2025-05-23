// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Mandate;

/**
 * These are the details of the sepa account used for the transaction.
 */
public class Sepa {

  @JsonProperty("nickName")
  private String nickName;
  @JsonProperty("accountHolderName")
  private String accountHolderName;
  @JsonProperty("bic")
  private String bic;
  @JsonProperty("iban")
  private String iban;
  @JsonProperty("mandate")
  private Mandate mandate;
  @JsonProperty("lastDigits")
  private String lastDigits;

  public Sepa() {
    super();
  }

  private Sepa(Builder builder) {
    setNickName(builder.nickName);
    setAccountHolderName(builder.accountHolderName);
    setBic(builder.bic);
    setIban(builder.iban);
    setMandate(builder.mandate);
    setLastDigits(builder.lastDigits);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Sepa nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * This is an alias for this bank account.
   *
   * @return nickName
   */
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Sepa accountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return this;
  }

  /**
   * This is the name of the customer or company  that owns the bank account.
   *
   * @return accountHolderName
   */
  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public Sepa bic(String bic) {
    this.bic = bic;
    return this;
  }

  /**
   * This is the Bank Identifier Code for the consumer's bank account.
   *
   * @return bic
   */
  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public Sepa iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * This is the International Bank Account Number for the costumer's bank account.
   *
   * @return iban
   */
  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public Sepa mandate(Mandate mandate) {
    this.mandate = mandate;
    return this;
  }

  /**
   * Contains customer bank's mandate details
   *
   * @return mandate
   */
  public Mandate getMandate() {
    return mandate;
  }

  public void setMandate(Mandate mandate) {
    this.mandate = mandate;
  }

  public Sepa lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last two digits of the iban.
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
    Sepa sepa = (Sepa) o;
    return Objects.equals(this.nickName, sepa.nickName) &&
        Objects.equals(this.accountHolderName, sepa.accountHolderName) &&
        Objects.equals(this.bic, sepa.bic) &&
        Objects.equals(this.iban, sepa.iban) &&
        Objects.equals(this.mandate, sepa.mandate) &&
        Objects.equals(this.lastDigits, sepa.lastDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickName, accountHolderName, bic, iban, mandate, lastDigits);
  }

  @Override
  public String toString() {

    return "class Sepa {\n"
        + "    nickName: " + toIndentedString(nickName) + "\n"
        + "    accountHolderName: " + toIndentedString(accountHolderName) + "\n"
        + "    bic: " + toIndentedString(bic) + "\n"
        + "    iban: " + toIndentedString(iban) + "\n"
        + "    mandate: " + toIndentedString(mandate) + "\n"
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
   * {@code Sepa} builder static inner class.
   */
  public static final class Builder {
    private String nickName;
    private String accountHolderName;
    private String bic;
    private String iban;
    private Mandate mandate;
    private String lastDigits;

    private Builder() {
    }

    /**
     * Sets the {@code nickName} and returns a reference to this Builder enabling method chaining.
     *
     * @param nickName the {@code nickName} to set
     * @return a reference to this Builder
     */
    public Builder nickName(String nickName) {
      this.nickName = nickName;
      return this;
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
     * Sets the {@code bic} and returns a reference to this Builder enabling method chaining.
     *
     * @param bic the {@code bic} to set
     * @return a reference to this Builder
     */
    public Builder bic(String bic) {
      this.bic = bic;
      return this;
    }

    /**
     * Sets the {@code iban} and returns a reference to this Builder enabling method chaining.
     *
     * @param iban the {@code iban} to set
     * @return a reference to this Builder
     */
    public Builder iban(String iban) {
      this.iban = iban;
      return this;
    }

    /**
     * Sets the {@code mandate} and returns a reference to this Builder enabling method chaining.
     *
     * @param mandate the {@code mandate} to set
     * @return a reference to this Builder
     */
    public Builder mandate(Mandate mandate) {
      this.mandate = mandate;
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
     * Returns a {@code Sepa} built from the parameters previously set.
     *
     * @return a {@code Sepa} built with parameters of this {@code Sepa.Builder}
     */
    public Sepa build() {
      return new Sepa(this);
    }
  }
}

