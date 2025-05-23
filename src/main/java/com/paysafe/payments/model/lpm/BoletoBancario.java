// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the Boleto Bancario account used for the request.
 */
public class BoletoBancario {

  @JsonProperty("paymentExpiryInMinutes")
  private Long paymentExpiryInMinutes;

  public BoletoBancario() {
    super();
  }

  private BoletoBancario(Builder builder) {
    setPaymentExpiryInMinutes(builder.paymentExpiryInMinutes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public BoletoBancario paymentExpiryInMinutes(Long paymentExpiryInMinutes) {
    this.paymentExpiryInMinutes = paymentExpiryInMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at Safetypay.
   *
   * @return paymentExpiryInMinutes
   */
  public Long getPaymentExpiryInMinutes() {
    return paymentExpiryInMinutes;
  }

  public void setPaymentExpiryInMinutes(Long paymentExpiryInMinutes) {
    this.paymentExpiryInMinutes = paymentExpiryInMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoletoBancario boletoBancario = (BoletoBancario) o;
    return Objects.equals(this.paymentExpiryInMinutes, boletoBancario.paymentExpiryInMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentExpiryInMinutes);
  }

  @Override
  public String toString() {

    return "class BoletoBancario {\n"
        + "    paymentExpiryInMinutes: " + toIndentedString(paymentExpiryInMinutes) + "\n"
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
   * {@code BoletoBancario} builder static inner class.
   */
  public static final class Builder {
    private Long paymentExpiryInMinutes;

    private Builder() {
    }

    /**
     * Sets the {@code paymentExpiryInMinutes} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentExpiryInMinutes the {@code paymentExpiryInMinutes} to set
     * @return a reference to this Builder
     */
    public Builder paymentExpiryInMinutes(Long paymentExpiryInMinutes) {
      this.paymentExpiryInMinutes = paymentExpiryInMinutes;
      return this;
    }

    /**
     * Returns a {@code BoletoBancario} built from the parameters previously set.
     *
     * @return a {@code BoletoBancario} built with parameters of this {@code BoletoBancario.Builder}
     */
    public BoletoBancario build() {
      return new BoletoBancario(this);
    }
  }
}

