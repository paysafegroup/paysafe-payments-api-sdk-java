// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.profile.enums.EmailVerified;
import com.paysafe.payments.model.common.profile.enums.PhoneVerified;
import com.paysafe.payments.model.customer.enums.Locale;

/**
 * This is customer's profile details. Required for fundingTransaction in CARD payments. Also required for VIP Preferred, Play+ Registration,
 * paysafecard Payout. Optional for Skrill Payment.
 *
 * <ul>
 *   <li>
 *     <b>id:</b> The customer's profile id in the system. If this is present rest all other fields are not required.
 *   </li>
 *   <li>
 *     <b>status:</b> The status of customer in the system, returned in the response.
 *   </li>
 *   <li>
 *     <b>merchantCustomerId:</b> This is the reference number for the customer created by the merchant and submitted
 *     as part of the request. It must be unique for each customer. <br>
 *     <b>Note:</b> This value is mandatory when <i>fundingTransaction</i> is used.  <br>
 *   </li>
 *   <li>
 *     <b>locale:</b> This indicates the customer's locale preference.  <br>
 *     <i>Allowed values: en_US, fr_CA, en_GB, en_CA</i>
 *   </li>
 *   <li>
 *     <b>firstName:</b> This is the customer’s first name.  <br>
 *     Example: Venkata Suresh
 *   </li>
 *   <li>
 *     <b>lastName:</b> This is the customer’s last name.  <br>
 *     Example: Chagalamarri
 *   </li>
 *   <li>
 *     <b>email:</b> This is the customer's email address.  <br>
 *     Example: paysafe@gmail.com
 *   </li>
 *   <li>
 *     <b>phone:</b> This is the customer's phone number.  <br>
 *     Example: 1234567891
 *   </li>
 *   <li>
 *     <b>emailVerified:</b> Is the customer’s email ID verified by merchant or not?  <br>
 *     <b>Note:</b> EmailVerified is optional for Pay by Bank. If this value is not provided, the default value will be set to NOT_VERIFIED.  <br>
 *     <i>Allowed values: NOT_VERIFIED, VERIFIED</i>
 *   </li>
 *   <li>
 *     <b>phoneVerified:</b> Is the customer’s phone number verified by merchant or not?  <br>
 *     <b>Note:</b> PhoneVerified is optional for Pay by Bank. If this value is not provided, the default value will be set to NOT_VERIFIED.  <br>
 *     <i>Allowed values: NOT_VERIFIED, VERIFIED</i>
 *   </li>
 *   <li>
 *     <b>dateOfBirth:</b> Customer's date of birth.  <br>
 *     <b>Note:</b> Required for Pay by Bank.
 *   </li>
 *   <li>
 *     <b>mobile:</b> Customer's mobile number.  <br>
 *     Example: 9846573804
 *   </li>
 *   <li>
 *     <b>gender:</b> This field indicates the Customer's gender.  <br>
 *     <i>Allowed values: M, F</i>
 *   </li>
 *   <li>
 *     <b>nationality:</b> This field indicates the Customer's nationality.  <br>
 *     Example: Indian
 *   </li>
 *   <li>
 *     <b>identityDocuments:</b> Required if at time of onboarding with Paysafe enrolmentType is selected
 *     as "OPEN_LOOP" else optional.
 *   </li>
 * </ul>
 */
public class Profile {

  @JsonProperty("id")
  private String id;
  @JsonProperty("status")
  private String status;
  @JsonProperty("merchantCustomerId")
  private String merchantCustomerId;
  @JsonProperty("locale")
  private Locale locale;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("emailverified")
  private EmailVerified emailVerified;
  @JsonProperty("phoneVerified")
  private PhoneVerified phoneVerified;
  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("gender")
  private String gender;
  @JsonProperty("nationality")
  private String nationality;
  @JsonProperty("IdentityDocument")
  private List<IdentityDocument> identityDocuments = null;

  public Profile() {
    super();
  }

  private Profile(Builder builder) {
    setId(builder.id);
    setStatus(builder.status);
    setMerchantCustomerId(builder.merchantCustomerId);
    setLocale(builder.locale);
    setFirstName(builder.firstName);
    setLastName(builder.lastName);
    setEmail(builder.email);
    setPhone(builder.phone);
    setEmailVerified(builder.emailVerified);
    setPhoneVerified(builder.phoneVerified);
    setDateOfBirth(builder.dateOfBirth);
    setGender(builder.gender);
    setNationality(builder.nationality);
    setIdentityDocuments(builder.identityDocuments);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Profile id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is returned in Response. The customer's profile id in the system. If this is present rest all other fields are not required.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Profile status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of customer in the system, returned in the response.
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Profile merchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
    return this;
  }

  /**
   * This is the reference number for the customer created by the merchant and submitted as part of the request. It must be unique for each customer. <br>
   * <b>Note: </b> This value is mandatory when <i>fundingTransaction</i> is used.
   *
   * @return merchantCustomerId
   */
  public String getMerchantCustomerId() {
    return merchantCustomerId;
  }

  public void setMerchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
  }

  public Profile locale(Locale locale) {
    this.locale = locale;
    return this;
  }

  /**
   * This indicates the customer's locale preference.
   *
   * @return locale
   */
  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public Profile firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * This is the customer’s first name.
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Profile lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * This is the customer’s last name.
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Profile email(String email) {
    this.email = email;
    return this;
  }

  /**
   * This is the customer's email address. Max length 40 characters.  <br>
   * 3DS flow: For VISA card, it is recommended to send either email or phone in the API request.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Profile phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This is the customer's phone number. Max length 40 characters.  <br>
   * 3DS flow: For VISA card, it is recommended to send either email or phone in the API request
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Profile emailVerified(EmailVerified emailverified) {
    this.emailVerified = emailverified;
    return this;
  }

  /**
   * <b>Note:</b> For PAY BY BANK payment method only. Defines if the customer’s email ID is verified by merchant or not. <br>
   * If not sent, default value will be set to NOT_VERIFIED.
   * Be aware that unverified email may lead to request failures, as this is the part of our risk check parameters.  <br>
   *
   * @return emailverified
   */
  public EmailVerified getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(EmailVerified emailVerified) {
    this.emailVerified = emailVerified;
  }

  public Profile phoneVerified(PhoneVerified phoneVerified) {
    this.phoneVerified = phoneVerified;
    return this;
  }

  /**
   * For PAY BY BANK payment method only. <br> Is the customer’s phone number verified by merchant or not?  <br>
   * If not sent, default value will be set to NOT_VERIFIED.  <br>
   * Be aware that unverified email may lead to request failures, as this is the part of our risk check.
   *
   * @return phoneVerified
   */
  public PhoneVerified getPhoneVerified() {
    return phoneVerified;
  }

  public void setPhoneVerified(PhoneVerified phoneVerified) {
    this.phoneVerified = phoneVerified;
  }

  public Profile dateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   *
   * @return dateOfBirth
   */
  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Profile gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * This field indicates the Customer's gender. M - Male F - Female
   *
   * @return gender
   */
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Profile nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * This field indicates the Customer's nationality.
   *
   * @return nationality
   */
  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Profile identityDocument(List<IdentityDocument> IdentityDocument) {
    this.identityDocuments = IdentityDocument;
    return this;
  }

  public Profile addIdentityDocumentItem(IdentityDocument IdentityDocumentItem) {
    if (this.identityDocuments == null) {
      this.identityDocuments = new ArrayList<>();
    }
    this.identityDocuments.add(IdentityDocumentItem);
    return this;
  }

  public Profile removeIdentityDocumentItem(IdentityDocument IdentityDocumentItem) {
    if (IdentityDocumentItem != null && this.identityDocuments != null) {
      this.identityDocuments.remove(IdentityDocumentItem);
    }

    return this;
  }

  /**
   * For PAY BY BANK and VIPPREFERRED payment methods.  <br> Required for PAY BY BANK Payment if at time of onboarding with Paysafe
   * enrollmentType is selected as OPEN_LOOP.
   *
   * @return IdentityDocument
   */
  public List<IdentityDocument> getIdentityDocuments() {
    return identityDocuments;
  }

  public void setIdentityDocuments(List<IdentityDocument> IdentityDocument) {
    this.identityDocuments = IdentityDocument;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(this.id, profile.id) &&
        Objects.equals(this.status, profile.status) &&
        Objects.equals(this.merchantCustomerId, profile.merchantCustomerId) &&
        Objects.equals(this.locale, profile.locale) &&
        Objects.equals(this.firstName, profile.firstName) &&
        Objects.equals(this.lastName, profile.lastName) &&
        Objects.equals(this.email, profile.email) &&
        Objects.equals(this.phone, profile.phone) &&
        Objects.equals(this.emailVerified, profile.emailVerified) &&
        Objects.equals(this.phoneVerified, profile.phoneVerified) &&
        Objects.equals(this.dateOfBirth, profile.dateOfBirth) &&
        Objects.equals(this.gender, profile.gender) &&
        Objects.equals(this.nationality, profile.nationality) &&
        Objects.equals(this.identityDocuments, profile.identityDocuments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, merchantCustomerId, locale, firstName, lastName, email, phone, emailVerified,
        phoneVerified, dateOfBirth, gender, nationality, identityDocuments);
  }

  @Override
  public String toString() {

    return "class Profile {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    merchantCustomerId: " + toIndentedString(merchantCustomerId) + "\n"
        + "    locale: " + toIndentedString(locale) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    emailVerified: " + toIndentedString(emailVerified) + "\n"
        + "    phoneVerified: " + toIndentedString(phoneVerified) + "\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    gender: " + toIndentedString(gender) + "\n"
        + "    nationality: " + toIndentedString(nationality) + "\n"
        + "    identityDocuments: " + toIndentedString(identityDocuments) + "\n"
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
   * {@code Profile} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String status;
    private String merchantCustomerId;
    private Locale locale;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private EmailVerified emailVerified;
    private PhoneVerified phoneVerified;
    private DateOfBirth dateOfBirth;
    private String gender;
    private String nationality;
    private List<IdentityDocument> identityDocuments;

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
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code merchantCustomerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantCustomerId the {@code merchantCustomerId} to set
     * @return a reference to this Builder
     */
    public Builder merchantCustomerId(String merchantCustomerId) {
      this.merchantCustomerId = merchantCustomerId;
      return this;
    }

    /**
     * Sets the {@code locale} and returns a reference to this Builder enabling method chaining.
     *
     * @param locale the {@code locale} to set
     * @return a reference to this Builder
     */
    public Builder locale(Locale locale) {
      this.locale = locale;
      return this;
    }

    /**
     * Sets the {@code firstName} and returns a reference to this Builder enabling method chaining.
     *
     * @param firstName the {@code firstName} to set
     * @return a reference to this Builder
     */
    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     * Sets the {@code lastName} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastName the {@code lastName} to set
     * @return a reference to this Builder
     */
    public Builder lastName(String lastName) {
      this.lastName = lastName;
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
     * Sets the {@code emailVerified} and returns a reference to this Builder enabling method chaining.
     *
     * @param emailVerified the {@code emailVerified} to set
     * @return a reference to this Builder
     */
    public Builder emailVerified(EmailVerified emailVerified) {
      this.emailVerified = emailVerified;
      return this;
    }

    /**
     * Sets the {@code phoneVerified} and returns a reference to this Builder enabling method chaining.
     *
     * @param phoneVerified the {@code phoneVerified} to set
     * @return a reference to this Builder
     */
    public Builder phoneVerified(PhoneVerified phoneVerified) {
      this.phoneVerified = phoneVerified;
      return this;
    }

    /**
     * Sets the {@code dateOfBirth} and returns a reference to this Builder enabling method chaining.
     *
     * @param dateOfBirth the {@code dateOfBirth} to set
     * @return a reference to this Builder
     */
    public Builder dateOfBirth(DateOfBirth dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    /**
     * Sets the {@code gender} and returns a reference to this Builder enabling method chaining.
     *
     * @param gender the {@code gender} to set
     * @return a reference to this Builder
     */
    public Builder gender(String gender) {
      this.gender = gender;
      return this;
    }

    /**
     * Sets the {@code nationality} and returns a reference to this Builder enabling method chaining.
     *
     * @param nationality the {@code nationality} to set
     * @return a reference to this Builder
     */
    public Builder nationality(String nationality) {
      this.nationality = nationality;
      return this;
    }

    /**
     * Sets the {@code identityDocuments} and returns a reference to this Builder enabling method chaining.
     *
     * @param identityDocuments the {@code identityDocuments} to set
     * @return a reference to this Builder
     */
    public Builder identityDocuments(List<IdentityDocument> identityDocuments) {
      this.identityDocuments = identityDocuments;
      return this;
    }

    /**
     * Returns a {@code Profile} built from the parameters previously set.
     *
     * @return a {@code Profile} built with parameters of this {@code Profile.Builder}
     */
    public Profile build() {
      return new Profile(this);
    }
  }
}

