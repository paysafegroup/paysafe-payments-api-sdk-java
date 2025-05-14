// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * PaymentHandleList
 */
public class PaymentHandleList {

  @JsonProperty("paymentHandles")
  private List<PaymentHandle> paymentHandles = null;
  @JsonProperty("meta")
  private Meta meta;

  public PaymentHandleList() {
    super();
  }

  private PaymentHandleList(Builder builder) {
    setPaymentHandles(builder.paymentHandles);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentHandleList paymentHandles(List<PaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
    return this;
  }

  public PaymentHandleList addPaymentHandlesItem(PaymentHandle paymentHandlesItem) {
    if (this.paymentHandles == null) {
      this.paymentHandles = new ArrayList<>();
    }
    this.paymentHandles.add(paymentHandlesItem);
    return this;
  }

  public PaymentHandleList removePaymentHandlesItem(PaymentHandle paymentHandlesItem) {
    if (paymentHandlesItem != null && this.paymentHandles != null) {
      this.paymentHandles.remove(paymentHandlesItem);
    }

    return this;
  }

  /**
   * Get paymentHandles
   *
   * @return paymentHandles
   */
  public List<PaymentHandle> getPaymentHandles() {
    return paymentHandles;
  }

  public void setPaymentHandles(List<PaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
  }

  public PaymentHandleList meta(Meta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Contains meta info for the pagination APIs
   *
   * @return meta
   */
  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentHandleList paymentHandleList = (PaymentHandleList) o;
    return Objects.equals(this.paymentHandles, paymentHandleList.paymentHandles) &&
        Objects.equals(this.meta, paymentHandleList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentHandles, meta);
  }

  @Override
  public String toString() {

    return "class PaymentHandleList {\n"
        + "    paymentHandles: " + toIndentedString(paymentHandles) + "\n"
        + "    meta: " + toIndentedString(meta) + "\n"
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
   * {@code PaymentHandleList} builder static inner class.
   */
  public static final class Builder {
    private List<PaymentHandle> paymentHandles;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the {@code paymentHandles} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandles the {@code paymentHandles} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandles(List<PaymentHandle> paymentHandles) {
      this.paymentHandles = paymentHandles;
      return this;
    }

    /**
     * Sets the {@code meta} and returns a reference to this Builder enabling method chaining.
     *
     * @param meta the {@code meta} to set
     * @return a reference to this Builder
     */
    public Builder meta(Meta meta) {
      this.meta = meta;
      return this;
    }

    /**
     * Returns a {@code PaymentHandleList} built from the parameters previously set.
     *
     * @return a {@code PaymentHandleList} built with parameters of this {@code PaymentHandleList.Builder}
     */
    public PaymentHandleList build() {
      return new PaymentHandleList(this);
    }
  }
}

