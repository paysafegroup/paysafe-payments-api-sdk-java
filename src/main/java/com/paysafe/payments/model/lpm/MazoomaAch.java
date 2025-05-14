// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MazoomaAch
 */
public class MazoomaAch {

  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;

  public MazoomaAch() {
    super();
  }

  private MazoomaAch(Builder builder) {
    setPaymentHandleToken(builder.paymentHandleToken);
  }

  public static Builder builder() {
    return new Builder();
  }

  public MazoomaAch paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is a unique identifier for each user bank account which is saved at Mazooma end.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MazoomaAch mazoomaAch = (MazoomaAch) o;
    return Objects.equals(this.paymentHandleToken, mazoomaAch.paymentHandleToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentHandleToken);
  }

  @Override
  public String toString() {

    return "class MazoomaAch {\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
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
   * {@code MazoomaAch} builder static inner class.
   */
  public static final class Builder {
    private String paymentHandleToken;

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
     * Returns a {@code MazoomaAch} built from the parameters previously set.
     *
     * @return a {@code MazoomaAch} built with parameters of this {@code MazoomaAch.Builder}
     */
    public MazoomaAch build() {
      return new MazoomaAch(this);
    }
  }
}

