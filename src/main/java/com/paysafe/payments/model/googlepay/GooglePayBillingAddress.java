// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GooglePayBillingAddress
 */
public class GooglePayBillingAddress {

  @JsonProperty("address1")
  private String address1;
  @JsonProperty("address2")
  private String address2;
  @JsonProperty("address3")
  private String address3;
  @JsonProperty("administrativeArea")
  private String administrativeArea;
  @JsonProperty("countryCode")
  private String countryCode;
  @JsonProperty("locality")
  private String locality;
  @JsonProperty("name")
  private String name;
  @JsonProperty("postalCode")
  private Long postalCode;
  @JsonProperty("sortingCode")
  private Long sortingCode;

  public GooglePayBillingAddress() {
    super();
  }

  private GooglePayBillingAddress(Builder builder) {
    setAddress1(builder.address1);
    setAddress2(builder.address2);
    setAddress3(builder.address3);
    setAdministrativeArea(builder.administrativeArea);
    setCountryCode(builder.countryCode);
    setLocality(builder.locality);
    setName(builder.name);
    setPostalCode(builder.postalCode);
    setSortingCode(builder.sortingCode);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GooglePayBillingAddress address1(String address1) {
    this.address1 = address1;
    return this;
  }

  /**
   * The address1 of the contact.
   *
   * @return address1
   */
  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public GooglePayBillingAddress address2(String address2) {
    this.address2 = address2;
    return this;
  }

  /**
   * The address2 of the contact.
   *
   * @return address2
   */
  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public GooglePayBillingAddress address3(String address3) {
    this.address3 = address3;
    return this;
  }

  /**
   * The address3 of the contact.
   *
   * @return address3
   */
  public String getAddress3() {
    return address3;
  }

  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  public GooglePayBillingAddress administrativeArea(String administrativeArea) {
    this.administrativeArea = administrativeArea;
    return this;
  }

  /**
   * The state for the contact.
   *
   * @return administrativeArea
   */
  public String getAdministrativeArea() {
    return administrativeArea;
  }

  public void setAdministrativeArea(String administrativeArea) {
    this.administrativeArea = administrativeArea;
  }

  public GooglePayBillingAddress countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * The contact’s two-letter ISO 3166 country code.
   *
   * @return countryCode
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public GooglePayBillingAddress locality(String locality) {
    this.locality = locality;
    return this;
  }

  /**
   * The city for the contact.
   *
   * @return locality
   */
  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public GooglePayBillingAddress name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The contact's name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GooglePayBillingAddress postalCode(Long postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * The zip code or postal code, where applicable, for the contact.
   *
   * @return postalCode
   */
  public Long getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Long postalCode) {
    this.postalCode = postalCode;
  }

  public GooglePayBillingAddress sortingCode(Long sortingCode) {
    this.sortingCode = sortingCode;
    return this;
  }

  /**
   * Get sortingCode
   *
   * @return sortingCode
   */
  public Long getSortingCode() {
    return sortingCode;
  }

  public void setSortingCode(Long sortingCode) {
    this.sortingCode = sortingCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayBillingAddress googlePayBillingAddress = (GooglePayBillingAddress) o;
    return Objects.equals(this.address1, googlePayBillingAddress.address1) &&
        Objects.equals(this.address2, googlePayBillingAddress.address2) &&
        Objects.equals(this.address3, googlePayBillingAddress.address3) &&
        Objects.equals(this.administrativeArea, googlePayBillingAddress.administrativeArea) &&
        Objects.equals(this.countryCode, googlePayBillingAddress.countryCode) &&
        Objects.equals(this.locality, googlePayBillingAddress.locality) &&
        Objects.equals(this.name, googlePayBillingAddress.name) &&
        Objects.equals(this.postalCode, googlePayBillingAddress.postalCode) &&
        Objects.equals(this.sortingCode, googlePayBillingAddress.sortingCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address1, address2, address3, administrativeArea, countryCode, locality, name, postalCode, sortingCode);
  }

  @Override
  public String toString() {

    return "class GooglePayBillingAddress {\n"
        + "    address1: " + toIndentedString(address1) + "\n"
        + "    address2: " + toIndentedString(address2) + "\n"
        + "    address3: " + toIndentedString(address3) + "\n"
        + "    administrativeArea: " + toIndentedString(administrativeArea) + "\n"
        + "    countryCode: " + toIndentedString(countryCode) + "\n"
        + "    locality: " + toIndentedString(locality) + "\n"
        + "    name: " + toIndentedString(name) + "\n"
        + "    postalCode: " + toIndentedString(postalCode) + "\n"
        + "    sortingCode: " + toIndentedString(sortingCode) + "\n"
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
   * {@code GooglePayBillingAddress} builder static inner class.
   */
  public static final class Builder {
    private String address1;
    private String address2;
    private String address3;
    private String administrativeArea;
    private String countryCode;
    private String locality;
    private String name;
    private Long postalCode;
    private Long sortingCode;

    private Builder() {
    }

    /**
     * Sets the {@code address1} and returns a reference to this Builder enabling method chaining.
     *
     * @param address1 the {@code address1} to set
     * @return a reference to this Builder
     */
    public Builder address1(String address1) {
      this.address1 = address1;
      return this;
    }

    /**
     * Sets the {@code address2} and returns a reference to this Builder enabling method chaining.
     *
     * @param address2 the {@code address2} to set
     * @return a reference to this Builder
     */
    public Builder address2(String address2) {
      this.address2 = address2;
      return this;
    }

    /**
     * Sets the {@code address3} and returns a reference to this Builder enabling method chaining.
     *
     * @param address3 the {@code address3} to set
     * @return a reference to this Builder
     */
    public Builder address3(String address3) {
      this.address3 = address3;
      return this;
    }

    /**
     * Sets the {@code administrativeArea} and returns a reference to this Builder enabling method chaining.
     *
     * @param administrativeArea the {@code administrativeArea} to set
     * @return a reference to this Builder
     */
    public Builder administrativeArea(String administrativeArea) {
      this.administrativeArea = administrativeArea;
      return this;
    }

    /**
     * Sets the {@code countryCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param countryCode the {@code countryCode} to set
     * @return a reference to this Builder
     */
    public Builder countryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Sets the {@code locality} and returns a reference to this Builder enabling method chaining.
     *
     * @param locality the {@code locality} to set
     * @return a reference to this Builder
     */
    public Builder locality(String locality) {
      this.locality = locality;
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
     * Sets the {@code postalCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param postalCode the {@code postalCode} to set
     * @return a reference to this Builder
     */
    public Builder postalCode(Long postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    /**
     * Sets the {@code sortingCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param sortingCode the {@code sortingCode} to set
     * @return a reference to this Builder
     */
    public Builder sortingCode(Long sortingCode) {
      this.sortingCode = sortingCode;
      return this;
    }

    /**
     * Returns a {@code GooglePayBillingAddress} built from the parameters previously set.
     *
     * @return a {@code GooglePayBillingAddress} built with parameters of this
     * {@code GooglePayBillingAddress
     * .Builder}
     */
    public GooglePayBillingAddress build() {
      return new GooglePayBillingAddress(this);
    }
  }
}

