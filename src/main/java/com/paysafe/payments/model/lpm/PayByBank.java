// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object should be used only for pay by bank transactions.
 */
public class PayByBank {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("registrationId")
  private String registrationId;
  @JsonProperty("ach")
  private PayByBankAch ach;

  public PayByBank() {
    super();
  }

  private PayByBank(Builder builder) {
    setConsumerId(builder.consumerId);
    setRegistrationId(builder.registrationId);
    setAch(builder.ach);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PayByBank consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is your identifier for your consumer and must be unique per consumer.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public PayByBank registrationId(String registrationId) {
    this.registrationId = registrationId;
    return this;
  }

  /**
   * Paysafe’s unique identifier for your consumer.
   *
   * @return registrationId
   */
  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }

  public PayByBank ach(PayByBankAch ach) {
    this.ach = ach;
    return this;
  }

  /**
   * This is an array containing a list of bank accounts that the consumer has linked in order to make Pay by Bank payments, along with additional
   * information about those accounts.
   *
   * @return ach
   */
  public PayByBankAch getAch() {
    return ach;
  }

  public void setAch(PayByBankAch ach) {
    this.ach = ach;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayByBank payByBank = (PayByBank) o;
    return Objects.equals(this.consumerId, payByBank.consumerId) &&
        Objects.equals(this.registrationId, payByBank.registrationId) &&
        Objects.equals(this.ach, payByBank.ach);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, registrationId, ach);
  }

  @Override
  public String toString() {

    return "class PayByBank {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    registrationId: " + toIndentedString(registrationId) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
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
   * {@code PayByBank} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String registrationId;
    private PayByBankAch ach;

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
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(PayByBankAch ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Returns a {@code PayByBank} built from the parameters previously set.
     *
     * @return a {@code PayByBank} built with parameters of this {@code PayByBank.Builder}
     */
    public PayByBank build() {
      return new PayByBank(this);
    }
  }
}

