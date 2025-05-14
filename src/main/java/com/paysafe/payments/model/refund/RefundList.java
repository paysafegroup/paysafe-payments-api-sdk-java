// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.refund;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * RefundList
 */
public class RefundList {

  @JsonProperty("refunds")
  private List<Refund> refunds = null;
  @JsonProperty("meta")
  private Meta meta;

  public RefundList() {
    super();
  }

  private RefundList(Builder builder) {
    setRefunds(builder.refunds);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public RefundList refunds(List<Refund> refunds) {
    this.refunds = refunds;
    return this;
  }

  public RefundList addRefundsItem(Refund refundItem) {
    if (this.refunds == null) {
      this.refunds = new ArrayList<>();
    }
    this.refunds.add(refundItem);
    return this;
  }

  public RefundList removeRefundsItem(Refund refundItem) {
    if (refundItem != null && this.refunds != null) {
      this.refunds.remove(refundItem);
    }

    return this;
  }

  /**
   * Get refunds
   *
   * @return refunds
   */
  public List<Refund> getRefunds() {
    return refunds;
  }

  public void setRefunds(List<Refund> refunds) {
    this.refunds = refunds;
  }

  public RefundList meta(Meta meta) {
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
    RefundList refundList = (RefundList) o;
    return Objects.equals(this.refunds, refundList.refunds) &&
        Objects.equals(this.meta, refundList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refunds, meta);
  }

  @Override
  public String toString() {

    return "class RefundList {\n"
        + "    refunds: " + toIndentedString(refunds) + "\n"
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
   * {@code RefundList} builder static inner class.
   */
  public static final class Builder {
    private List<Refund> refunds;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the {@code refunds} and returns a reference to this Builder enabling method chaining.
     *
     * @param refunds the {@code refunds} to set
     * @return a reference to this Builder
     */
    public Builder refunds(List<Refund> refunds) {
      this.refunds = refunds;
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
     * Returns a {@code RefundList} built from the parameters previously set.
     *
     * @return a {@code RefundList} built with parameters of this {@code RefundList.Builder}
     */
    public RefundList build() {
      return new RefundList(this);
    }
  }
}

