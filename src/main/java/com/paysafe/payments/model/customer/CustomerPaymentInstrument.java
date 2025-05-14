// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Sepa;

/**
 * CustomerPaymentInstrument
 */
public class CustomerPaymentInstrument {

  @JsonProperty("card")
  private UpdateCustomerRequestCard card;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates = null;
  @JsonProperty("sepa")
  private Sepa sepa;

  public CustomerPaymentInstrument() {
    super();
  }

  private CustomerPaymentInstrument(Builder builder) {
    setCard(builder.card);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setAch(builder.ach);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CustomerPaymentInstrument card(UpdateCustomerRequestCard card) {
    this.card = card;
    return this;
  }

  /**
   * Card details to be used for the transaction
   *
   * @return card
   */
  public UpdateCustomerRequestCard getCard() {
    return card;
  }

  public void setCard(UpdateCustomerRequestCard card) {
    this.card = card;
  }

  public CustomerPaymentInstrument paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is an existing Customer Payment Handle, from which the payment instrument and profile details are retrieved.
   * If this parameter is included you can omit the billingDetails object.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public CustomerPaymentInstrument eft(Eft eft) {
    this.eft = eft;
    return this;
  }

  /**
   * Details of the EFT account to be used for the transaction
   *
   * @return eft
   */
  public Eft getEft() {
    return eft;
  }

  public void setEft(Eft eft) {
    this.eft = eft;
  }

  public CustomerPaymentInstrument dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Get dupCheck
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public CustomerPaymentInstrument ach(Ach ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Details of the ach account to be used for the transaction.
   *
   * @return ach
   */
  public Ach getAch() {
    return ach;
  }

  public void setAch(Ach ach) {
    this.ach = ach;
  }

  public CustomerPaymentInstrument bacs(Bacs bacs) {
    this.bacs = bacs;
    return this;
  }

  /**
   * Details of the bacs account to be used for the transaction.
   *
   * @return bacs
   */
  public Bacs getBacs() {
    return bacs;
  }

  public void setBacs(Bacs bacs) {
    this.bacs = bacs;
  }

  public CustomerPaymentInstrument mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public CustomerPaymentInstrument addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public CustomerPaymentInstrument removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * Get mandates
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }

  public CustomerPaymentInstrument sepa(Sepa sepa) {
    this.sepa = sepa;
    return this;
  }

  /**
   * These are the details of the sepa account used for the transaction.
   *
   * @return sepa
   */
  public Sepa getSepa() {
    return sepa;
  }

  public void setSepa(Sepa sepa) {
    this.sepa = sepa;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPaymentInstrument customerPaymentInstrument = (CustomerPaymentInstrument) o;
    return Objects.equals(this.card, customerPaymentInstrument.card) &&
        Objects.equals(this.paymentHandleTokenFrom, customerPaymentInstrument.paymentHandleTokenFrom) &&
        Objects.equals(this.eft, customerPaymentInstrument.eft) &&
        Objects.equals(this.dupCheck, customerPaymentInstrument.dupCheck) &&
        Objects.equals(this.ach, customerPaymentInstrument.ach) &&
        Objects.equals(this.bacs, customerPaymentInstrument.bacs) &&
        Objects.equals(this.mandates, customerPaymentInstrument.mandates) &&
        Objects.equals(this.sepa, customerPaymentInstrument.sepa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(card, paymentHandleTokenFrom, eft, dupCheck, ach, bacs, mandates, sepa);
  }

  @Override
  public String toString() {

    return "class CustomerPaymentInstrument {\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
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
   * {@code CustomerPaymentInstrument} builder static inner class.
   */
  public static final class Builder {
    private UpdateCustomerRequestCard card;
    private String paymentHandleTokenFrom;
    private Eft eft;
    private Boolean dupCheck;
    private Ach ach;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;

    private Builder() {
    }

    /**
     * Sets the {@code card} and returns a reference to this Builder enabling method chaining.
     *
     * @param card the {@code card} to set
     * @return a reference to this Builder
     */
    public Builder card(UpdateCustomerRequestCard card) {
      this.card = card;
      return this;
    }

    /**
     * Sets the {@code paymentHandleTokenFrom} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleTokenFrom the {@code paymentHandleTokenFrom} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleTokenFrom(String paymentHandleTokenFrom) {
      this.paymentHandleTokenFrom = paymentHandleTokenFrom;
      return this;
    }

    /**
     * Sets the {@code eft} and returns a reference to this Builder enabling method chaining.
     *
     * @param eft the {@code eft} to set
     * @return a reference to this Builder
     */
    public Builder eft(Eft eft) {
      this.eft = eft;
      return this;
    }

    /**
     * Sets the {@code dupCheck} and returns a reference to this Builder enabling method chaining.
     *
     * @param dupCheck the {@code dupCheck} to set
     * @return a reference to this Builder
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(Ach ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Sets the {@code bacs} and returns a reference to this Builder enabling method chaining.
     *
     * @param bacs the {@code bacs} to set
     * @return a reference to this Builder
     */
    public Builder bacs(Bacs bacs) {
      this.bacs = bacs;
      return this;
    }

    /**
     * Sets the {@code mandates} and returns a reference to this Builder enabling method chaining.
     *
     * @param mandates the {@code mandates} to set
     * @return a reference to this Builder
     */
    public Builder mandates(List<Mandate> mandates) {
      this.mandates = mandates;
      return this;
    }

    /**
     * Sets the {@code sepa} and returns a reference to this Builder enabling method chaining.
     *
     * @param sepa the {@code sepa} to set
     * @return a reference to this Builder
     */
    public Builder sepa(Sepa sepa) {
      this.sepa = sepa;
      return this;
    }

    /**
     * Returns a {@code CustomerPaymentInstrument} built from the parameters previously set.
     *
     * @return a {@code CustomerPaymentInstrument} built with parameters of this {@code CustomerPaymentInstrument.Builder}
     */
    public CustomerPaymentInstrument build() {
      return new CustomerPaymentInstrument(this);
    }
  }
}

