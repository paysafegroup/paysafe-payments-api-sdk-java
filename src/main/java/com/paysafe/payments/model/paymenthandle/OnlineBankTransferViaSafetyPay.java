// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.PaymentDetails;

/**
 * OnlineBankTransferViaSafetyPay
 */
public class OnlineBankTransferViaSafetyPay {

  @JsonProperty("paymentDetails")
  private PaymentDetails paymentDetails;
  @JsonProperty("paymentExpiryInMinutes")
  private Long paymentExpiryInMinutes;

  public OnlineBankTransferViaSafetyPay() {
    super();
  }

  private OnlineBankTransferViaSafetyPay(Builder builder) {
    setPaymentDetails(builder.paymentDetails);
    setPaymentExpiryInMinutes(builder.paymentExpiryInMinutes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public OnlineBankTransferViaSafetyPay paymentDetails(PaymentDetails paymentDetails) {
    this.paymentDetails = paymentDetails;
    return this;
  }

  /**
   * Get paymentDetails
   *
   * @return paymentDetails
   */
  public PaymentDetails getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(PaymentDetails paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public OnlineBankTransferViaSafetyPay paymentExpiryInMinutes(Long paymentExpiryInMinutes) {
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
    OnlineBankTransferViaSafetyPay onlineBankTransferViaSafetyPay = (OnlineBankTransferViaSafetyPay) o;
    return Objects.equals(this.paymentDetails, onlineBankTransferViaSafetyPay.paymentDetails) &&
        Objects.equals(this.paymentExpiryInMinutes, onlineBankTransferViaSafetyPay.paymentExpiryInMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentDetails, paymentExpiryInMinutes);
  }

  @Override
  public String toString() {

    return "class OnlineBankTransferViaSafetyPay {\n"
        + "    paymentDetails: " + toIndentedString(paymentDetails) + "\n"
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
   * {@code OnlineBankTransferViaSafetyPay} builder static inner class.
   */
  public static final class Builder {
    private Long paymentExpiryInMinutes;
    private PaymentDetails paymentDetails;

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
     * Returns a {@code OnlineBankTransferViaSafetyPay} built from the parameters previously set.
     *
     * @return a {@code OnlineBankTransferViaSafetyPay} built with parameters of this {@code OnlineBankTransferViaSafetyPay.Builder}
     */
    public OnlineBankTransferViaSafetyPay build() {
      return new OnlineBankTransferViaSafetyPay(this);
    }

    /**
     * Sets the {@code paymentDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentDetails the {@code paymentDetails} to set
     * @return a reference to this Builder
     */
    public Builder paymentDetails(PaymentDetails paymentDetails) {
      this.paymentDetails = paymentDetails;
      return this;
    }
  }
}

