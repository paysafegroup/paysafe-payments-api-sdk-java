// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The billing contact provided by the user for this transaction in Apple Pay wallet
 */
public class ApplePayBillingContact {

  @JsonProperty("addressLines")
  private List<String> addressLines = null;
  @JsonProperty("administrativeArea")
  private String administrativeArea;
  @JsonProperty("country")
  private String country;
  @JsonProperty("countryCode")
  private String countryCode;
  @JsonProperty("familyName")
  private String familyName;
  @JsonProperty("givenName")
  private String givenName;
  @JsonProperty("locality")
  private String locality;
  @JsonProperty("phoneticFamilyName")
  private String phoneticFamilyName;
  @JsonProperty("phoneticGivenName")
  private String phoneticGivenName;
  @JsonProperty("postalCode")
  private String postalCode;
  @JsonProperty("subAdministrativeArea")
  private String subAdministrativeArea;
  @JsonProperty("subLocality")
  private String subLocality;

  public ApplePayBillingContact() {
    super();
  }

  private ApplePayBillingContact(Builder builder) {
    setAddressLines(builder.addressLines);
    setAdministrativeArea(builder.administrativeArea);
    setCountry(builder.country);
    setCountryCode(builder.countryCode);
    setFamilyName(builder.familyName);
    setGivenName(builder.givenName);
    setLocality(builder.locality);
    setPhoneticFamilyName(builder.phoneticFamilyName);
    setPhoneticGivenName(builder.phoneticGivenName);
    setPostalCode(builder.postalCode);
    setSubAdministrativeArea(builder.subAdministrativeArea);
    setSubLocality(builder.subLocality);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayBillingContact addressLines(List<String> addressLines) {
    this.addressLines = addressLines;
    return this;
  }

  public ApplePayBillingContact addAddressLinesItem(String addressLinesItem) {
    if (this.addressLines == null) {
      this.addressLines = new ArrayList<>();
    }
    this.addressLines.add(addressLinesItem);
    return this;
  }

  public ApplePayBillingContact removeAddressLinesItem(String addressLinesItem) {
    if (addressLinesItem != null && this.addressLines != null) {
      this.addressLines.remove(addressLinesItem);
    }

    return this;
  }

  /**
   * The street portion of the address for the contact.
   *
   * @return addressLines
   */
  public List<String> getAddressLines() {
    return addressLines;
  }

  public void setAddressLines(List<String> addressLines) {
    this.addressLines = addressLines;
  }

  public ApplePayBillingContact administrativeArea(String administrativeArea) {
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

  public ApplePayBillingContact country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The name of the country or region for the contact.
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ApplePayBillingContact countryCode(String countryCode) {
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

  public ApplePayBillingContact familyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  /**
   * The contact’s family name.
   *
   * @return familyName
   */
  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public ApplePayBillingContact givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * The contact’s given name.
   *
   * @return givenName
   */
  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public ApplePayBillingContact locality(String locality) {
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

  public ApplePayBillingContact phoneticFamilyName(String phoneticFamilyName) {
    this.phoneticFamilyName = phoneticFamilyName;
    return this;
  }

  /**
   * The phonetic spelling of the contact's family name.
   *
   * @return phoneticFamilyName
   */
  public String getPhoneticFamilyName() {
    return phoneticFamilyName;
  }

  public void setPhoneticFamilyName(String phoneticFamilyName) {
    this.phoneticFamilyName = phoneticFamilyName;
  }

  public ApplePayBillingContact phoneticGivenName(String phoneticGivenName) {
    this.phoneticGivenName = phoneticGivenName;
    return this;
  }

  /**
   * The phonetic spelling of the contact's given name.
   *
   * @return phoneticGivenName
   */
  public String getPhoneticGivenName() {
    return phoneticGivenName;
  }

  public void setPhoneticGivenName(String phoneticGivenName) {
    this.phoneticGivenName = phoneticGivenName;
  }

  public ApplePayBillingContact postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * The zip code or postal code, where applicable, for the contact.
   *
   * @return postalCode
   */
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public ApplePayBillingContact subAdministrativeArea(String subAdministrativeArea) {
    this.subAdministrativeArea = subAdministrativeArea;
    return this;
  }

  /**
   * The subadministrative area (such as a county or other region) in a postal address.
   *
   * @return subAdministrativeArea
   */
  public String getSubAdministrativeArea() {
    return subAdministrativeArea;
  }

  public void setSubAdministrativeArea(String subAdministrativeArea) {
    this.subAdministrativeArea = subAdministrativeArea;
  }

  public ApplePayBillingContact subLocality(String subLocality) {
    this.subLocality = subLocality;
    return this;
  }

  /**
   * Additional information associated with the location, typically defined at the city or town level (such as district or neighborhood), in a postal address.
   *
   * @return subLocality
   */
  public String getSubLocality() {
    return subLocality;
  }

  public void setSubLocality(String subLocality) {
    this.subLocality = subLocality;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayBillingContact applePayBillingContact = (ApplePayBillingContact) o;
    return Objects.equals(this.addressLines, applePayBillingContact.addressLines) &&
        Objects.equals(this.administrativeArea, applePayBillingContact.administrativeArea) &&
        Objects.equals(this.country, applePayBillingContact.country) &&
        Objects.equals(this.countryCode, applePayBillingContact.countryCode) &&
        Objects.equals(this.familyName, applePayBillingContact.familyName) &&
        Objects.equals(this.givenName, applePayBillingContact.givenName) &&
        Objects.equals(this.locality, applePayBillingContact.locality) &&
        Objects.equals(this.phoneticFamilyName, applePayBillingContact.phoneticFamilyName) &&
        Objects.equals(this.phoneticGivenName, applePayBillingContact.phoneticGivenName) &&
        Objects.equals(this.postalCode, applePayBillingContact.postalCode) &&
        Objects.equals(this.subAdministrativeArea, applePayBillingContact.subAdministrativeArea) &&
        Objects.equals(this.subLocality, applePayBillingContact.subLocality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressLines, administrativeArea, country, countryCode, familyName, givenName, locality,
        phoneticFamilyName, phoneticGivenName, postalCode, subAdministrativeArea, subLocality);
  }

  @Override
  public String toString() {

    return "class ApplePayBillingContact {\n"
        + "    addressLines: " + toIndentedString(addressLines) + "\n"
        + "    administrativeArea: " + toIndentedString(administrativeArea) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    countryCode: " + toIndentedString(countryCode) + "\n"
        + "    familyName: " + toIndentedString(familyName) + "\n"
        + "    givenName: " + toIndentedString(givenName) + "\n"
        + "    locality: " + toIndentedString(locality) + "\n"
        + "    phoneticFamilyName: " + toIndentedString(phoneticFamilyName) + "\n"
        + "    phoneticGivenName: " + toIndentedString(phoneticGivenName) + "\n"
        + "    postalCode: " + toIndentedString(postalCode) + "\n"
        + "    subAdministrativeArea: " + toIndentedString(subAdministrativeArea) + "\n"
        + "    subLocality: " + toIndentedString(subLocality) + "\n"
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
   * {@code ApplePayBillingContact} builder static inner class.
   */
  public static final class Builder {
    private List<String> addressLines;
    private String administrativeArea;
    private String country;
    private String countryCode;
    private String familyName;
    private String givenName;
    private String locality;
    private String phoneticFamilyName;
    private String phoneticGivenName;
    private String postalCode;
    private String subAdministrativeArea;
    private String subLocality;

    private Builder() {
    }

    /**
     * Sets the {@code addressLines} and returns a reference to this Builder enabling method chaining.
     *
     * @param addressLines the {@code addressLines} to set
     * @return a reference to this Builder
     */
    public Builder addressLines(List<String> addressLines) {
      this.addressLines = addressLines;
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
     * Sets the {@code country} and returns a reference to this Builder enabling method chaining.
     *
     * @param country the {@code country} to set
     * @return a reference to this Builder
     */
    public Builder country(String country) {
      this.country = country;
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
     * Sets the {@code familyName} and returns a reference to this Builder enabling method chaining.
     *
     * @param familyName the {@code familyName} to set
     * @return a reference to this Builder
     */
    public Builder familyName(String familyName) {
      this.familyName = familyName;
      return this;
    }

    /**
     * Sets the {@code givenName} and returns a reference to this Builder enabling method chaining.
     *
     * @param givenName the {@code givenName} to set
     * @return a reference to this Builder
     */
    public Builder givenName(String givenName) {
      this.givenName = givenName;
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
     * Sets the {@code phoneticFamilyName} and returns a reference to this Builder enabling method chaining.
     *
     * @param phoneticFamilyName the {@code phoneticFamilyName} to set
     * @return a reference to this Builder
     */
    public Builder phoneticFamilyName(String phoneticFamilyName) {
      this.phoneticFamilyName = phoneticFamilyName;
      return this;
    }

    /**
     * Sets the {@code phoneticGivenName} and returns a reference to this Builder enabling method chaining.
     *
     * @param phoneticGivenName the {@code phoneticGivenName} to set
     * @return a reference to this Builder
     */
    public Builder phoneticGivenName(String phoneticGivenName) {
      this.phoneticGivenName = phoneticGivenName;
      return this;
    }

    /**
     * Sets the {@code postalCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param postalCode the {@code postalCode} to set
     * @return a reference to this Builder
     */
    public Builder postalCode(String postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    /**
     * Sets the {@code subAdministrativeArea} and returns a reference to this Builder enabling method chaining.
     *
     * @param subAdministrativeArea the {@code subAdministrativeArea} to set
     * @return a reference to this Builder
     */
    public Builder subAdministrativeArea(String subAdministrativeArea) {
      this.subAdministrativeArea = subAdministrativeArea;
      return this;
    }

    /**
     * Sets the {@code subLocality} and returns a reference to this Builder enabling method chaining.
     *
     * @param subLocality the {@code subLocality} to set
     * @return a reference to this Builder
     */
    public Builder subLocality(String subLocality) {
      this.subLocality = subLocality;
      return this;
    }

    /**
     * Returns a {@code ApplePayBillingContact} built from the parameters previously set.
     *
     * @return a {@code ApplePayBillingContact} built with parameters of this {@code ApplePayBillingContact.Builder}
     */
    public ApplePayBillingContact build() {
      return new ApplePayBillingContact(this);
    }
  }
}

