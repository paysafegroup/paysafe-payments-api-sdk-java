// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * For CARD payment method only.
 * This is the merchant descriptor that will be displayed on the customer's card or bank statement.
 * <ul>
 *   <li>
 *     <b>dynamicDescriptor:</b> This is a merchant descriptor that will be displayed on a customer’s card statement.  <br>
 *     Example: OnlineStore
 *   </li>
 *   <li>
 *     <b>phone:</b> This is the merchant’s phone number, which is appended to the merchant descriptor on a customer’s card statement.  <br>
 *     <b>Note:</b> This field is used only in case of payment.  <br>
 *     Example: 12345678
 *   </li>
 * </ul>
 */
public class MerchantDescriptor {

  @JsonProperty("dynamicDescriptor")
  private String dynamicDescriptor;
  @JsonProperty("phone")
  private String phone;

  public MerchantDescriptor() {
    super();
  }

  private MerchantDescriptor(Builder builder) {
    setDynamicDescriptor(builder.dynamicDescriptor);
    setPhone(builder.phone);
  }

  public static Builder builder() {
    return new Builder();
  }

  public MerchantDescriptor dynamicDescriptor(String dynamicDescriptor) {
    this.dynamicDescriptor = dynamicDescriptor;
    return this;
  }

  /**
   * This is a merchant descriptor that will be displayed on a customer’s card statement.
   *
   * @return dynamicDescriptor
   */
  public String getDynamicDescriptor() {
    return dynamicDescriptor;
  }

  public void setDynamicDescriptor(String dynamicDescriptor) {
    this.dynamicDescriptor = dynamicDescriptor;
  }

  public MerchantDescriptor phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This is the merchant’s phone number, which is appended to the merchant descriptor on a customer’s card statement.
   * <b>Note:</b> This field is used only in case of payment.
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantDescriptor merchantDescriptor = (MerchantDescriptor) o;
    return Objects.equals(this.dynamicDescriptor, merchantDescriptor.dynamicDescriptor) &&
        Objects.equals(this.phone, merchantDescriptor.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dynamicDescriptor, phone);
  }

  @Override
  public String toString() {

    return "class MerchantDescriptor {\n"
        + "    dynamicDescriptor: " + toIndentedString(dynamicDescriptor) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
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
   * {@code MerchantDescriptor} builder static inner class.
   */
  public static final class Builder {
    private String dynamicDescriptor;
    private String phone;

    private Builder() {
    }

    /**
     * Sets the {@code dynamicDescriptor} and returns a reference to this Builder enabling method chaining.
     *
     * @param dynamicDescriptor the {@code dynamicDescriptor} to set
     * @return a reference to this Builder
     */
    public Builder dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
    }

    /**
     * Sets the {@code phone} and returns a reference to this Builder enabling method chaining.
     *
     * @param phone the {@code phone} to set
     * @return a reference to this Builder
     */
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    /**
     * Returns a {@code MerchantDescriptor} built from the parameters previously set.
     *
     * @return a {@code MerchantDescriptor} built with parameters of this {@code MerchantDescriptor.Builder}
     */
    public MerchantDescriptor build() {
      return new MerchantDescriptor(this);
    }
  }
}

