// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.paymentfacilitator;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains information for Payment facilitator sub-merchant. <b>Note:</b> This object is only for Payment facilitator merchants.
 * <ul>
 *   <li>
 *     <b>id:</b> This field contains an identifier of the actual merchant. <br>
 *     Example: 123456789
 *   </li>
 *   <li>
 *     <b>name:</b> This field must contain the name of the actual merchant.
 *   </li>
 *   <li>
 *     <b>phone</b>: This field must contain the phone number of the actual merchant.
 *   </li>
 *   <li>
 *     <b>email:</b> This field must contain the email address of the actual merchant.
 *   </li>
 *   <li>
 *     <b>url:</b> This field must contain the url address of the actual merchant.  <br>
 *     Example: www.paysafe.com
 *   </li>
 *   <li>
 *     <b>address:</b> Contains information for Payment facilitator sub-merchant address.  <br>
 *     <b>Note</b>: This object is only for Payment facilitator merchants.
 *   </li>
 * </ul>
 */
public class SubMerchant {

  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("email")
  private String email;
  @JsonProperty("url")
  private String url;
  @JsonProperty("address")
  private SubMerchantAddress address;

  public SubMerchant() {
  }

  private SubMerchant(final Builder builder) {
    setId(builder.id);
    setName(builder.name);
    setPhone(builder.phone);
    setEmail(builder.email);
    setUrl(builder.url);
    setAddress(builder.address);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SubMerchant id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This field contains an identifier of the actual merchant.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SubMerchant name(String name) {
    this.name = name;
    return this;
  }

  /**
   * This field must contain the name of the actual merchant.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SubMerchant phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This field must contain the phone number of the actual merchant.
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public SubMerchant email(String email) {
    this.email = email;
    return this;
  }

  /**
   * This field must contain the email address of the actual merchant.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SubMerchant url(String url) {
    this.url = url;
    return this;
  }

  /**
   * This field must contain the url address of the actual merchant.
   *
   * @return url
   */
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SubMerchant address(SubMerchantAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Contains information for Payment facilitator sub-merchant address.  <b>Note:</b> This object is only for Payment facilitator merchants.
   *
   * @return address
   */
  public SubMerchantAddress getAddress() {
    return address;
  }

  public void setAddress(SubMerchantAddress address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubMerchant SubMerchant = (SubMerchant) o;
    return Objects.equals(this.id, SubMerchant.id) &&
        Objects.equals(this.name, SubMerchant.name) &&
        Objects.equals(this.phone, SubMerchant.phone) &&
        Objects.equals(this.email, SubMerchant.email) &&
        Objects.equals(this.url, SubMerchant.url) &&
        Objects.equals(this.address, SubMerchant.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, email, url, address);
  }

  @Override
  public String toString() {

    return "class SubMerchant {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    name: " + toIndentedString(name) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    url: " + toIndentedString(url) + "\n"
        + "    address: " + toIndentedString(address) + "\n"
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
   * {@code SubMerchant} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String url;
    private SubMerchantAddress address;

    private Builder() {
    }

    /**
     * Sets the {@code id} and returns a reference to this Builder enabling method chaining.
     *
     * @param id the {@code id} to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the {@code name} and returns a reference to this Builder enabling method chaining.
     *
     * @param name the {@code name} to set
     * @return a reference to this Builder
     */
    public Builder name(String name) {
      this.name = name;
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
     * Sets the {@code email} and returns a reference to this Builder enabling method chaining.
     *
     * @param email the {@code email} to set
     * @return a reference to this Builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Sets the {@code url} and returns a reference to this Builder enabling method chaining.
     *
     * @param url the {@code url} to set
     * @return a reference to this Builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Sets the {@code address} and returns a reference to this Builder enabling method chaining.
     *
     * @param address the {@code address} to set
     * @return a reference to this Builder
     */
    public Builder address(SubMerchantAddress address) {
      this.address = address;
      return this;
    }

    /**
     * Returns a {@code SubMerchant} built from the parameters previously set.
     *
     * @return a {@code SubMerchant} built with parameters of this {@code SubMerchant.Builder}
     */
    public SubMerchant build() {
      return new SubMerchant(this);
    }
  }
}
