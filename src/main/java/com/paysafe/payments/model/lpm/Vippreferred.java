// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the vip preferred account used for the transaction.
 */
public class Vippreferred {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("registrationId")
  private String registrationId;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("ach")
  private AchBankAccount ach;
  @JsonProperty("achBankAccounts")
  private List<AchBankAccount> achBankAccounts = null;

  public Vippreferred() {
    super();
  }

  private Vippreferred(Builder builder) {
    setConsumerId(builder.consumerId);
    setRegistrationId(builder.registrationId);
    setPaymentHandleToken(builder.paymentHandleToken);
    setAch(builder.ach);
    setAchBankAccounts(builder.achBankAccounts);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Vippreferred consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * The is the consumer social security number (SSN). As it is sensitive data the consumerId will not be passed in the response.
   * Last 4 digits will be passed as lastDigits.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Vippreferred registrationId(String registrationId) {
    this.registrationId = registrationId;
    return this;
  }

  /**
   * This is the registrationId of the consumer. You can pass the registrationId in place of consumerId in the setup option call..
   *
   * @return registrationId
   */
  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }

  public Vippreferred paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the bank token of the registered bank account. The bank token is returned in the Verification API response.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  public Vippreferred ach(AchBankAccount ach) {
    this.ach = ach;
    return this;
  }

  /**
   * This are the bank details which requires in case of enrollment/payments/payouts
   *
   * @return ach
   */
  public AchBankAccount getAch() {
    return ach;
  }

  public void setAch(AchBankAccount ach) {
    this.ach = ach;
  }

  public Vippreferred achBankAccounts(List<AchBankAccount> achBankAccounts) {
    this.achBankAccounts = achBankAccounts;
    return this;
  }

  public Vippreferred addAchBankAccountsItem(AchBankAccount achBankAccountsItem) {
    if (this.achBankAccounts == null) {
      this.achBankAccounts = new ArrayList<>();
    }
    this.achBankAccounts.add(achBankAccountsItem);
    return this;
  }

  public Vippreferred removeAchBankAccountsItem(AchBankAccount achBankAccountsItem) {
    if (achBankAccountsItem != null && this.achBankAccounts != null) {
      this.achBankAccounts.remove(achBankAccountsItem);
    }

    return this;
  }

  /**
   * This contains all the registered ach bank accounts.
   *
   * @return achBankAccounts
   */
  public List<AchBankAccount> getAchBankAccounts() {
    return achBankAccounts;
  }

  public void setAchBankAccounts(List<AchBankAccount> achBankAccounts) {
    this.achBankAccounts = achBankAccounts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vippreferred vippreferred = (Vippreferred) o;
    return Objects.equals(this.consumerId, vippreferred.consumerId) &&
        Objects.equals(this.registrationId, vippreferred.registrationId) &&
        Objects.equals(this.paymentHandleToken, vippreferred.paymentHandleToken) &&
        Objects.equals(this.ach, vippreferred.ach) &&
        Objects.equals(this.achBankAccounts, vippreferred.achBankAccounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, registrationId, paymentHandleToken, ach, achBankAccounts);
  }

  @Override
  public String toString() {

    return "class Vippreferred {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    registrationId: " + toIndentedString(registrationId) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    achBankAccounts: " + toIndentedString(achBankAccounts) + "\n"
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
   * {@code Vippreferred} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String registrationId;
    private String paymentHandleToken;
    private AchBankAccount ach;
    private List<AchBankAccount> achBankAccounts;

    private Builder() {
    }

    /**
     * Sets the {@code consumerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the {@code consumerId} to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * Sets the {@code registrationId} and returns a reference to this Builder enabling method chaining.
     *
     * @param registrationId the {@code registrationId} to set
     * @return a reference to this Builder
     */
    public Builder registrationId(String registrationId) {
      this.registrationId = registrationId;
      return this;
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
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(AchBankAccount ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Sets the {@code achBankAccounts} and returns a reference to this Builder enabling method chaining.
     *
     * @param achBankAccounts the {@code achBankAccounts} to set
     * @return a reference to this Builder
     */
    public Builder achBankAccounts(List<AchBankAccount> achBankAccounts) {
      this.achBankAccounts = achBankAccounts;
      return this;
    }

    /**
     * Returns a {@code Vippreferred} built from the parameters previously set.
     *
     * @return a {@code Vippreferred} built with parameters of this {@code Vippreferred.Builder}
     */
    public Vippreferred build() {
      return new Vippreferred(this);
    }
  }
}

