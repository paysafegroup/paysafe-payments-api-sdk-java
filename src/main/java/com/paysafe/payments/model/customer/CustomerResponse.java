// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.enums.CustomerStatus;

/**
 * Customer details including saved addresses and payment handles
 */
public class CustomerResponse extends BaseApiResponse {

  @JsonProperty("merchantCustomerId")
  private String merchantCustomerId;
  @JsonProperty("locale")
  private String locale;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("middleName")
  private String middleName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("gender")
  private String gender;
  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("cellPhone")
  private String cellPhone;
  @JsonProperty("nationality")
  private String nationality;
  @JsonProperty("ip")
  private String ip;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("accountId")
  private String accountId;
  @JsonProperty("id")
  private String id;
  @JsonProperty("status")
  private String status = CustomerStatus.ACTIVE.getValue();
  @JsonProperty("paymentToken")
  private String paymentToken;
  @JsonProperty("addresses")
  private List<Address> addresses = null;
  @JsonProperty("paymentHandles")
  private List<CustomerPaymentHandle> paymentHandles = null;

  public CustomerResponse() {
    super();
  }

  private CustomerResponse(Builder builder) {
    setMerchantCustomerId(builder.merchantCustomerId);
    setLocale(builder.locale);
    setFirstName(builder.firstName);
    setMiddleName(builder.middleName);
    setLastName(builder.lastName);
    setGender(builder.gender);
    setDateOfBirth(builder.dateOfBirth);
    setEmail(builder.email);
    setPhone(builder.phone);
    setCellPhone(builder.cellPhone);
    setNationality(builder.nationality);
    setIp(builder.ip);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setAccountId(builder.accountId);
    setId(builder.id);
    setStatus(builder.status);
    setPaymentToken(builder.paymentToken);
    setAddresses(builder.addresses);
    setPaymentHandles(builder.paymentHandles);
    setError(builder.error);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CustomerResponse merchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
    return this;
  }

  /**
   * This is a customer ID that the merchant provides with the request for their own internal customer identification.
   * This value must be unique for each customer belonging to a merchant.
   *
   * @return merchantCustomerId
   */
  public String getMerchantCustomerId() {
    return merchantCustomerId;
  }

  public void setMerchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
  }

  public CustomerResponse locale(String locale) {
    this.locale = locale;
    return this;
  }

  /**
   * This indicates the language of the customer.
   *
   * @return locale
   */
  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public CustomerResponse firstName(String firstName) {
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

  public CustomerResponse middleName(String middleName) {
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

  public CustomerResponse lastName(String lastName) {
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

  public CustomerResponse gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * This is the customer’s gender. Possible values are:  - M - Male  - F - Female
   *
   * @return gender
   */
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public CustomerResponse dateOfBirth(DateOfBirth dateOfBirth) {
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

  public CustomerResponse email(String email) {
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

  public CustomerResponse phone(String phone) {
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

  public CustomerResponse cellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
    return this;
  }

  /**
   * This is the customer's cell phone number.
   *
   * @return cellPhone
   */
  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  public CustomerResponse nationality(String nationality) {
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

  public CustomerResponse ip(String ip) {
    this.ip = ip;
    return this;
  }

  /**
   * This is the customer’s IP address.
   *
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public CustomerResponse paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is the paymentHandleToken that is present in the response to a Single-use Payment Handle creation request.
   * <b>Note:</b> It is a mandatory field only if we are trying to Create a Customer Using a Single-Use Payment Handle Token.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public CustomerResponse accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Account Id in the paysafe system.
   *
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public CustomerResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the customer. Possible values are:
   * <ul>
   * <li> INITIAL </li>
   * <li> ACTIVE </li>
   * </ul>
   *
   * By default, the system automatically sets the customer status to an ACTIVE state. If you want to prevent the customer from being used for payments,
   * you can set the status to an INITIAL state (e.g., in cases where you first want to validate the customer).
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CustomerResponse paymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
    return this;
  }

  /**
   * It is the customer profile Identifier at the paysafe end.
   *
   * @return paymentToken
   */
  public String getPaymentToken() {
    return paymentToken;
  }

  public void setPaymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
  }

  public CustomerResponse addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public CustomerResponse addAddressesItem(Address addressItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressItem);
    return this;
  }

  public CustomerResponse removeAddressesItem(Address addressItem) {
    if (addressItem != null && this.addresses != null) {
      this.addresses.remove(addressItem);
    }

    return this;
  }

  /**
   * Get addresses
   *
   * @return addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public CustomerResponse paymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
    return this;
  }

  public CustomerResponse addPaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (this.paymentHandles == null) {
      this.paymentHandles = new ArrayList<>();
    }
    this.paymentHandles.add(paymentHandlesItem);
    return this;
  }

  public CustomerResponse removePaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
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
  public List<CustomerPaymentHandle> getPaymentHandles() {
    return paymentHandles;
  }

  public void setPaymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerResponse customerResponse = (CustomerResponse) o;
    return Objects.equals(this.merchantCustomerId, customerResponse.merchantCustomerId) &&
        Objects.equals(this.locale, customerResponse.locale) &&
        Objects.equals(this.firstName, customerResponse.firstName) &&
        Objects.equals(this.middleName, customerResponse.middleName) &&
        Objects.equals(this.lastName, customerResponse.lastName) &&
        Objects.equals(this.gender, customerResponse.gender) &&
        Objects.equals(this.dateOfBirth, customerResponse.dateOfBirth) &&
        Objects.equals(this.email, customerResponse.email) &&
        Objects.equals(this.phone, customerResponse.phone) &&
        Objects.equals(this.cellPhone, customerResponse.cellPhone) &&
        Objects.equals(this.nationality, customerResponse.nationality) &&
        Objects.equals(this.ip, customerResponse.ip) &&
        Objects.equals(this.paymentHandleTokenFrom, customerResponse.paymentHandleTokenFrom) &&
        Objects.equals(this.accountId, customerResponse.accountId) &&
        Objects.equals(this.id, customerResponse.id) &&
        Objects.equals(this.status, customerResponse.status) &&
        Objects.equals(this.paymentToken, customerResponse.paymentToken) &&
        Objects.equals(this.addresses, customerResponse.addresses) &&
        Objects.equals(this.paymentHandles, customerResponse.paymentHandles) &&
        Objects.equals(this.getError(), customerResponse.getError());
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantCustomerId, locale, firstName, middleName, lastName, gender, dateOfBirth, email, phone, cellPhone,
        nationality, ip, paymentHandleTokenFrom, accountId, id, status, paymentToken, addresses, paymentHandles, getError());
  }

  @Override
  public String toString() {

    return "class CustomerResponse {\n"
        + "    merchantCustomerId: " + toIndentedString(merchantCustomerId) + "\n"
        + "    locale: " + toIndentedString(locale) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    middleName: " + toIndentedString(middleName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    gender: " + toIndentedString(gender) + "\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    cellPhone: " + toIndentedString(cellPhone) + "\n"
        + "    nationality: " + toIndentedString(nationality) + "\n"
        + "    ip: " + toIndentedString(ip) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    accountId: " + toIndentedString(accountId) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    paymentToken: " + toIndentedString(paymentToken) + "\n"
        + "    addresses: " + toIndentedString(addresses) + "\n"
        + "    paymentHandles: " + toIndentedString(paymentHandles) + "\n"
        + "    error: " + toIndentedString(getError()) + "\n"
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
   * {@code CustomerResponse} builder static inner class.
   */
  public static final class Builder {
    private String merchantCustomerId;
    private String locale;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private DateOfBirth dateOfBirth;
    private String email;
    private String phone;
    private String cellPhone;
    private String nationality;
    private String ip;
    private String paymentHandleTokenFrom;
    private String accountId;
    private String id;
    private String status;
    private String paymentToken;
    private List<Address> addresses;
    private List<CustomerPaymentHandle> paymentHandles;
    private Error error;

    private Builder() {
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
    public Builder locale(String locale) {
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
     * Sets the {@code cellPhone} and returns a reference to this Builder enabling method chaining.
     *
     * @param cellPhone the {@code cellPhone} to set
     * @return a reference to this Builder
     */
    public Builder cellPhone(String cellPhone) {
      this.cellPhone = cellPhone;
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
     * Sets the {@code paymentHandleTokenFrom} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleTokenFrom the {@code paymentHandleTokenFrom} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleTokenFrom(String paymentHandleTokenFrom) {
      this.paymentHandleTokenFrom = paymentHandleTokenFrom;
      return this;
    }

    /**
     * Sets the {@code accountId} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountId the {@code accountId} to set
     * @return a reference to this Builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
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
     * Sets the {@code paymentToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentToken the {@code paymentToken} to set
     * @return a reference to this Builder
     */
    public Builder paymentToken(String paymentToken) {
      this.paymentToken = paymentToken;
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
     * Sets the {@code error} and returns a reference to this Builder enabling method chaining.
     *
     * @param error the {@code error} to set
     * @return a reference to this Builder
     */
    public Builder error(Error error) {
      this.error = error;
      return this;
    }

    /**
     * Returns a {@code CustomerResponse} built from the parameters previously set.
     *
     * @return a {@code CustomerResponse} built with parameters of this {@code CustomerResponse.Builder}
     */
    public CustomerResponse build() {
      return new CustomerResponse(this);
    }
  }
}

