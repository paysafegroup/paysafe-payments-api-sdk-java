// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymentmethod;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents response returned from PaysafeAPI endpoint 'Look Up Payment Methods'.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LookUpPaymentMethodsResponse {

  @JsonProperty("paymentMethods")
  private List<PaymentMethod> paymentMethods = null;

  public LookUpPaymentMethodsResponse() {
    super();
  }

  private LookUpPaymentMethodsResponse(Builder builder) {
    setPaymentMethods(builder.paymentMethods);
  }

  public static Builder builder() {
    return new Builder();
  }

  public LookUpPaymentMethodsResponse paymentMethods(List<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
    return this;
  }

  /**
   * Get paymentMethods
   *
   * @return paymentMethods
   */
  public List<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
  }

  public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LookUpPaymentMethodsResponse lookUpPaymentMethodsResponse = (LookUpPaymentMethodsResponse) o;
    return Objects.equals(this.paymentMethods, lookUpPaymentMethodsResponse.paymentMethods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethods);
  }

  @Override
  public String toString() {
    return "class LookUpPaymentMethodsResponse {\n"
        + "    paymentMethods: " + toIndentedString(paymentMethods) + "\n"
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
   * {@code LookUpPaymentMethodsResponse} builder static inner class.
   */
  public static final class Builder {
    private List<PaymentMethod> paymentMethods;

    private Builder() {
    }

    /**
     * Sets the {@code paymentMethods} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentMethods the {@code paymentMethods} to set
     * @return a reference to this Builder
     */
    public Builder paymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
      return this;
    }

    /**
     * Returns a {@code LookUpPaymentMethodsResponse} built from the parameters previously set.
     *
     * @return a {@code LookUpPaymentMethodsResponse} built with parameters of this {@code LookUpPaymentMethodsResponse.Builder}
     */
    public LookUpPaymentMethodsResponse build() {
      return new LookUpPaymentMethodsResponse(this);
    }
  }
}
