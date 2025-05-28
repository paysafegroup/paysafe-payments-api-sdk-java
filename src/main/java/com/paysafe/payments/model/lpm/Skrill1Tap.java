// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the skrill 1-Tap account used for the transaction.
 */
public class Skrill1Tap {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("maxAmount")
  private Long maxAmount;

  public Skrill1Tap() {
    super();
  }

  private Skrill1Tap(Builder builder) {
    setConsumerId(builder.consumerId);
    setMaxAmount(builder.maxAmount);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Skrill1Tap consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * Unique ID of the user which is used to identify to account and user in subsequent calls.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Skrill1Tap maxAmount(Long maxAmount) {
    this.maxAmount = maxAmount;
    return this;
  }

  /**
   * This acts as an upper limit, any subsequent transactions for this subscription cannot be more than the maxAmount set.
   *
   * @return maxAmount
   */
  public Long getMaxAmount() {
    return maxAmount;
  }

  public void setMaxAmount(Long maxAmount) {
    this.maxAmount = maxAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Skrill1Tap skrill1Tap = (Skrill1Tap) o;
    return Objects.equals(this.consumerId, skrill1Tap.consumerId) &&
        Objects.equals(this.maxAmount, skrill1Tap.maxAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, maxAmount);
  }

  @Override
  public String toString() {

    return "class Skrill1Tap {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    maxAmount: " + toIndentedString(maxAmount) + "\n"
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
   * {@code Skrill1Tap} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private Long maxAmount;

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
     * Sets the {@code maxAmount} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAmount the {@code maxAmount} to set
     * @return a reference to this Builder
     */
    public Builder maxAmount(Long maxAmount) {
      this.maxAmount = maxAmount;
      return this;
    }

    /**
     * Returns a {@code Skrill1Tap} built from the parameters previously set.
     *
     * @return a {@code Skrill1Tap} built with parameters of this {@code Skrill1Tap.Builder}
     */
    public Skrill1Tap build() {
      return new Skrill1Tap(this);
    }
  }
}

