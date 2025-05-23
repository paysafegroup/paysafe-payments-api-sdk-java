// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.paymentfacilitator;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains information about Payment facilitator. <b>Note:</b> This object is only for Payment facilitator merchants.
 * <ul>
 *   <li><b>subMerchant</b>: Contains information for Payment facilitator sub-merchant. </li>
 * </ul>
 */
public class PaymentFacilitator {

  @JsonProperty("subMerchant")
  private SubMerchant subMerchant;

  public PaymentFacilitator() {
    super();
  }

  private PaymentFacilitator(Builder builder) {
    setSubMerchant(builder.subMerchant);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentFacilitator subMerchant(SubMerchant subMerchant) {
    this.subMerchant = subMerchant;
    return this;
  }

  /**
   * Contains information for Payment facilitator sub-merchant.  <b>Note:</b> This object is only for Payment facilitator merchants.
   *
   * @return subMerchant
   */
  public SubMerchant getSubMerchant() {
    return subMerchant;
  }

  public void setSubMerchant(SubMerchant subMerchant) {
    this.subMerchant = subMerchant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentFacilitator paymentFacilitator = (PaymentFacilitator) o;
    return Objects.equals(this.subMerchant, paymentFacilitator.subMerchant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subMerchant);
  }

  @Override
  public String toString() {

    return "class PaymentFacilitator {\n"
        + "    subMerchant: " + toIndentedString(subMerchant) + "\n"
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
   * {@code PaymentFacilitator} builder static inner class.
   */
  public static final class Builder {
    private SubMerchant subMerchant;

    private Builder() {
    }

    /**
     * Sets the {@code subMerchant} and returns a reference to this Builder enabling method chaining.
     *
     * @param subMerchant the {@code subMerchant} to set
     * @return a reference to this Builder
     */
    public Builder subMerchant(SubMerchant subMerchant) {
      this.subMerchant = subMerchant;
      return this;
    }

    /**
     * Returns a {@code PaymentFacilitator} built from the parameters previously set.
     *
     * @return a {@code PaymentFacilitator} built with parameters of this {@code PaymentFacilitator.Builder}
     */
    public PaymentFacilitator build() {
      return new PaymentFacilitator(this);
    }
  }
}
