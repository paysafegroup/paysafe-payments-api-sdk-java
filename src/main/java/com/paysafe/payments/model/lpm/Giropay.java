// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the giropay account used for the request.
 */
public class Giropay {

  @JsonProperty("subMerchantReference")
  private String subMerchantReference;
  @JsonProperty("merchantCategory")
  private String merchantCategory;

  public Giropay() {
    super();
  }

  private Giropay(Builder builder) {
    setSubMerchantReference(builder.subMerchantReference);
    setMerchantCategory(builder.merchantCategory);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Giropay subMerchantReference(String subMerchantReference) {
    this.subMerchantReference = subMerchantReference;
    return this;
  }

  /**
   * This is the unique merchant identifier that allows Paysafe to define the transaction with Giropay.
   *
   * @return subMerchantReference
   */
  public String getSubMerchantReference() {
    return subMerchantReference;
  }

  public void setSubMerchantReference(String subMerchantReference) {
    this.subMerchantReference = subMerchantReference;
  }

  public Giropay merchantCategory(String merchantCategory) {
    this.merchantCategory = merchantCategory;
    return this;
  }

  /**
   * This is the merchant's category of operations. <b>Note:</b> if present and provided with value as I_GAMING, then buyerAccount details will shared
   * in Payment response. For other verticals,it should be either null or shouldn't be provided.
   *
   * @return merchantCategory
   */
  public String getMerchantCategory() {
    return merchantCategory;
  }

  public void setMerchantCategory(String merchantCategory) {
    this.merchantCategory = merchantCategory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Giropay giropay = (Giropay) o;
    return Objects.equals(this.subMerchantReference, giropay.subMerchantReference) &&
        Objects.equals(this.merchantCategory, giropay.merchantCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subMerchantReference, merchantCategory);
  }

  @Override
  public String toString() {

    return "class Giropay {\n"
        + "    subMerchantReference: " + toIndentedString(subMerchantReference) + "\n"
        + "    merchantCategory: " + toIndentedString(merchantCategory) + "\n"
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
   * {@code Giropay} builder static inner class.
   */
  public static final class Builder {
    private String subMerchantReference;
    private String merchantCategory;

    private Builder() {
    }

    /**
     * Sets the {@code subMerchantReference} and returns a reference to this Builder enabling method chaining.
     *
     * @param subMerchantReference the {@code subMerchantReference} to set
     * @return a reference to this Builder
     */
    public Builder subMerchantReference(String subMerchantReference) {
      this.subMerchantReference = subMerchantReference;
      return this;
    }

    /**
     * Sets the {@code merchantCategory} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantCategory the {@code merchantCategory} to set
     * @return a reference to this Builder
     */
    public Builder merchantCategory(String merchantCategory) {
      this.merchantCategory = merchantCategory;
      return this;
    }

    /**
     * Returns a {@code Giropay} built from the parameters previously set.
     *
     * @return a {@code Giropay} built with parameters of this {@code Giropay.Builder}
     */
    public Giropay build() {
      return new Giropay(this);
    }
  }
}

