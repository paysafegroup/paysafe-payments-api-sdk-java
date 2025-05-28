// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer.singleusecustomertoken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.model.customer.CustomerPaymentHandle;
import com.paysafe.payments.model.customer.enums.Locale;
import com.paysafe.payments.model.customer.enums.SingleUseCustomerTokenStatus;
import com.paysafe.payments.model.customer.enums.SingleUseTokenPaymentType;

/**
 * SingleUseCustomerToken
 */
public class SingleUseCustomerToken {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private List<SingleUseTokenPaymentType> paymentType = null;
  @JsonProperty("id")
  private String id;
  @JsonProperty("timeToLiveSeconds")
  private Long timeToLiveSeconds;
  @JsonProperty("status")
  private SingleUseCustomerTokenStatus status;
  @JsonProperty("singleUseCustomerToken")
  private String singleUseCustomerToken;
  @JsonProperty("locale")
  private Locale locale;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("middleName")
  private String middleName;
  @JsonProperty("lastname")
  private String lastname;
  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("ip")
  private String ip;
  @JsonProperty("nationality")
  private String nationality;
  @JsonProperty("addresses")
  private List<Address> addresses = null;
  @JsonProperty("paymentHandles")
  private List<CustomerPaymentHandle> paymentHandles = null;
  @JsonProperty("customerId")
  private String customerId;

  public SingleUseCustomerToken() {
    super();
  }

  private SingleUseCustomerToken(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setId(builder.id);
    setTimeToLiveSeconds(builder.timeToLiveSeconds);
    setStatus(builder.status);
    setSingleUseCustomerToken(builder.singleUseCustomerToken);
    setLocale(builder.locale);
    setFirstName(builder.firstName);
    setMiddleName(builder.middleName);
    setLastname(builder.lastname);
    setDateOfBirth(builder.dateOfBirth);
    setEmail(builder.email);
    setPhone(builder.phone);
    setIp(builder.ip);
    setNationality(builder.nationality);
    setAddresses(builder.addresses);
    setPaymentHandles(builder.paymentHandles);
    setCustomerId(builder.customerId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SingleUseCustomerToken merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public SingleUseCustomerToken paymentType(List<SingleUseTokenPaymentType> paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This specifies the payment type for which you are creating the single-use token.
   *
   * @return paymentType
   */
  public List<SingleUseTokenPaymentType> getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(List<SingleUseTokenPaymentType> paymentType) {
    this.paymentType = paymentType;
  }

  public SingleUseCustomerToken id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests, e.g., to look up the Payment Handle.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SingleUseCustomerToken timeToLiveSeconds(Long timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
    return this;
  }

  /**
   * This is the period of time, in seconds, the singleUseCustomerToken is valid before expiration.  <br>
   * Maximum: 899
   *
   * @return timeToLiveSeconds
   */
  public Long getTimeToLiveSeconds() {
    return timeToLiveSeconds;
  }

  public void setTimeToLiveSeconds(Long timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
  }

  public SingleUseCustomerToken status(SingleUseCustomerTokenStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the single-use customer token.
   *
   * @return status
   */
  public SingleUseCustomerTokenStatus getStatus() {
    return status;
  }

  public void setStatus(SingleUseCustomerTokenStatus status) {
    this.status = status;
  }

  public SingleUseCustomerToken singleUseCustomerToken(String singleUseCustomerToken) {
    this.singleUseCustomerToken = singleUseCustomerToken;
    return this;
  }

  /**
   * This token can be used in the Payments Checkout to populate the checkout with customer information.
   *
   * @return singleUseCustomerToken
   */
  public String getSingleUseCustomerToken() {
    return singleUseCustomerToken;
  }

  public void setSingleUseCustomerToken(String singleUseCustomerToken) {
    this.singleUseCustomerToken = singleUseCustomerToken;
  }

  public SingleUseCustomerToken locale(Locale locale) {
    this.locale = locale;
    return this;
  }

  /**
   * This indicates the customer's locale.
   *
   * @return locale
   */
  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public SingleUseCustomerToken firstName(String firstName) {
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

  public SingleUseCustomerToken middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * This is the customer’s middle name.
   *
   * @return middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public SingleUseCustomerToken lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * This is the customer's last name.
   *
   * @return lastname
   */
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public SingleUseCustomerToken dateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * This is the recipient's date of birth.  <b>Note:</b> Required for Pay by Bank.
   *
   * @return dateOfBirth
   */
  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public SingleUseCustomerToken email(String email) {
    this.email = email;
    return this;
  }

  /**
   * This is the customer's email address.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SingleUseCustomerToken phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This is the customer's phone number.
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public SingleUseCustomerToken ip(String ip) {
    this.ip = ip;
    return this;
  }

  /**
   * This is the customer’s IP address
   *
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public SingleUseCustomerToken nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * This is the customer’s nationality.
   *
   * @return nationality
   */
  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public SingleUseCustomerToken addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public SingleUseCustomerToken addAddressesItem(Address addressItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressItem);
    return this;
  }

  public SingleUseCustomerToken removeAddressesItem(Address addressItem) {
    if (addressItem != null && this.addresses != null) {
      this.addresses.remove(addressItem);
    }

    return this;
  }

  /**
   * This is an array of addresses associated with the customer.
   *
   * @return addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public SingleUseCustomerToken paymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
    return this;
  }

  public SingleUseCustomerToken addPaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (this.paymentHandles == null) {
      this.paymentHandles = new ArrayList<>();
    }
    this.paymentHandles.add(paymentHandlesItem);
    return this;
  }

  public SingleUseCustomerToken removePaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (paymentHandlesItem != null && this.paymentHandles != null) {
      this.paymentHandles.remove(paymentHandlesItem);
    }

    return this;
  }

  /**
   * This is an array of payment handles associated with the customer.
   *
   * @return paymentHandles
   */
  public List<CustomerPaymentHandle> getPaymentHandles() {
    return paymentHandles;
  }

  public void setPaymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
  }

  public SingleUseCustomerToken customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * This is the ID of the customer profile used for this request.
   *
   * @return customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingleUseCustomerToken token = (SingleUseCustomerToken) o;
    return Objects.equals(this.merchantRefNum, token.merchantRefNum) &&
        Objects.equals(this.paymentType, token.paymentType) &&
        Objects.equals(this.id, token.id) &&
        Objects.equals(this.timeToLiveSeconds, token.timeToLiveSeconds) &&
        Objects.equals(this.status, token.status) &&
        Objects.equals(this.singleUseCustomerToken, token.singleUseCustomerToken) &&
        Objects.equals(this.locale, token.locale) &&
        Objects.equals(this.firstName, token.firstName) &&
        Objects.equals(this.middleName, token.middleName) &&
        Objects.equals(this.lastname, token.lastname) &&
        Objects.equals(this.dateOfBirth, token.dateOfBirth) &&
        Objects.equals(this.email, token.email) &&
        Objects.equals(this.phone, token.phone) &&
        Objects.equals(this.ip, token.ip) &&
        Objects.equals(this.nationality, token.nationality) &&
        Objects.equals(this.addresses, token.addresses) &&
        Objects.equals(this.paymentHandles, token.paymentHandles) &&
        Objects.equals(this.customerId, token.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, paymentType, id, timeToLiveSeconds, status, singleUseCustomerToken, locale, firstName, middleName, lastname,
        dateOfBirth, email, phone, ip, nationality, addresses, paymentHandles, customerId);
  }

  @Override
  public String toString() {

    return "class SingleUseCustomerToken {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    timeToLiveSeconds: " + toIndentedString(timeToLiveSeconds) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    singleUseCustomerToken: " + toIndentedString(singleUseCustomerToken) + "\n"
        + "    locale: " + toIndentedString(locale) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    middleName: " + toIndentedString(middleName) + "\n"
        + "    lastname: " + toIndentedString(lastname) + "\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    ip: " + toIndentedString(ip) + "\n"
        + "    nationality: " + toIndentedString(nationality) + "\n"
        + "    addresses: " + toIndentedString(addresses) + "\n"
        + "    paymentHandles: " + toIndentedString(paymentHandles) + "\n"
        + "    customerId: " + toIndentedString(customerId) + "\n"
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
   * {@code SingleUseCustomerToken} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private List<SingleUseTokenPaymentType> paymentType;
    private String id;
    private Long timeToLiveSeconds;
    private SingleUseCustomerTokenStatus status;
    private String singleUseCustomerToken;
    private Locale locale;
    private String firstName;
    private String middleName;
    private String lastname;
    private DateOfBirth dateOfBirth;
    private String email;
    private String phone;
    private String ip;
    private String nationality;
    private List<Address> addresses;
    private List<CustomerPaymentHandle> paymentHandles;
    private String customerId;

    private Builder() {
    }

    /**
     * Sets the {@code merchantRefNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the {@code merchantRefNum} to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * Sets the {@code paymentType} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the {@code paymentType} to set
     * @return a reference to this Builder
     */
    public Builder paymentType(List<SingleUseTokenPaymentType> paymentType) {
      this.paymentType = paymentType;
      return this;
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
     * Sets the {@code timeToLiveSeconds} and returns a reference to this Builder enabling method chaining.
     *
     * @param timeToLiveSeconds the {@code timeToLiveSeconds} to set
     * @return a reference to this Builder
     */
    public Builder timeToLiveSeconds(Long timeToLiveSeconds) {
      this.timeToLiveSeconds = timeToLiveSeconds;
      return this;
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(SingleUseCustomerTokenStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code singleUseCustomerToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param singleUseCustomerToken the {@code singleUseCustomerToken} to set
     * @return a reference to this Builder
     */
    public Builder singleUseCustomerToken(String singleUseCustomerToken) {
      this.singleUseCustomerToken = singleUseCustomerToken;
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
     * Sets the {@code middleName} and returns a reference to this Builder enabling method chaining.
     *
     * @param middleName the {@code middleName} to set
     * @return a reference to this Builder
     */
    public Builder middleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    /**
     * Sets the {@code lastname} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastname the {@code lastname} to set
     * @return a reference to this Builder
     */
    public Builder lastname(String lastname) {
      this.lastname = lastname;
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
     * Sets the {@code ip} and returns a reference to this Builder enabling method chaining.
     *
     * @param ip the {@code ip} to set
     * @return a reference to this Builder
     */
    public Builder ip(String ip) {
      this.ip = ip;
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
     * Sets the {@code addresses} and returns a reference to this Builder enabling method chaining.
     *
     * @param addresses the {@code addresses} to set
     * @return a reference to this Builder
     */
    public Builder addresses(List<Address> addresses) {
      this.addresses = addresses;
      return this;
    }

    /**
     * Sets the {@code paymentHandles} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandles the {@code paymentHandles} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandles(List<CustomerPaymentHandle> paymentHandles) {
      this.paymentHandles = paymentHandles;
      return this;
    }

    /**
     * Sets the {@code customerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param customerId the {@code customerId} to set
     * @return a reference to this Builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    /**
     * Returns a {@code SingleUseCustomerToken} built from the parameters previously set.
     *
     * @return a {@code SingleUseCustomerToken} built with parameters of this {@code SingleUseCustomerToken.Builder}
     */
    public SingleUseCustomerToken build() {
      return new SingleUseCustomerToken(this);
    }
  }
}

