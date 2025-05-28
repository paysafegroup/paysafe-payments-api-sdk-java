// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.enums.Gender;

/**
 * CustomerRequest
 */
public class CustomerRequest {

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
  private Gender gender;
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

  private Map<String, Object> additionalParameters;

  public CustomerRequest() {
    super();
  }

  private CustomerRequest(final Builder builder) {
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
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CustomerRequest merchantCustomerId(String merchantCustomerId) {
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

  public CustomerRequest locale(String locale) {
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

  public CustomerRequest firstName(String firstName) {
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

  public CustomerRequest middleName(String middleName) {
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

  public CustomerRequest lastName(String lastName) {
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

  public CustomerRequest gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * This is the customer’s gender. Possible values are:  - M - Male  - F - Female
   *
   * @return gender
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public CustomerRequest dateOfBirth(DateOfBirth dateOfBirth) {
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

  public CustomerRequest email(String email) {
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

  public CustomerRequest phone(String phone) {
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

  public CustomerRequest cellPhone(String cellPhone) {
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

  public CustomerRequest nationality(String nationality) {
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

  public CustomerRequest ip(String ip) {
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

  public CustomerRequest paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is the paymentHandleToken that is present in the response to a single-use Payment Handle creation request.
   * <b>Note:</b> It is a mandatory field only if we are trying to *Create a Customer Using a Single-Use Payment Handle Token*.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public CustomerRequest accountId(String accountId) {
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

  /**
   * This map holds additional parameters that can be used for features not available in this client library.
   * During serialization, each key-value pair is treated as if the key were a top-level field in the serialized object,
   * i.e. <code>{"merchantRefNum" : "uuid", "additionalParameter1" : 100, "additionalParameter2" : "string" }</code> .
   *
   * @return additionalParameters
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalParameters() {
    return additionalParameters;
  }

  public void setAdditionalParameters(Map<String, Object> additionalParameters) {
    this.additionalParameters = additionalParameters;
  }

  public void addAdditionalParameter(String key, Object value) {
    if (additionalParameters == null) {
      additionalParameters = new HashMap<>();
    }
    additionalParameters.put(key, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRequest customerRequest = (CustomerRequest) o;
    return Objects.equals(this.merchantCustomerId, customerRequest.merchantCustomerId) &&
        Objects.equals(this.locale, customerRequest.locale) &&
        Objects.equals(this.firstName, customerRequest.firstName) &&
        Objects.equals(this.middleName, customerRequest.middleName) &&
        Objects.equals(this.lastName, customerRequest.lastName) &&
        Objects.equals(this.gender, customerRequest.gender) &&
        Objects.equals(this.dateOfBirth, customerRequest.dateOfBirth) &&
        Objects.equals(this.email, customerRequest.email) &&
        Objects.equals(this.phone, customerRequest.phone) &&
        Objects.equals(this.cellPhone, customerRequest.cellPhone) &&
        Objects.equals(this.nationality, customerRequest.nationality) &&
        Objects.equals(this.ip, customerRequest.ip) &&
        Objects.equals(this.paymentHandleTokenFrom, customerRequest.paymentHandleTokenFrom) &&
        Objects.equals(this.accountId, customerRequest.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantCustomerId, locale, firstName, middleName, lastName, gender, dateOfBirth, email, phone,
        cellPhone, nationality, ip, paymentHandleTokenFrom, accountId, additionalParameters);
  }

  @Override
  public String toString() {

    return "class CustomerRequest {\n"
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
        + "    additionalParameters: " + toIndentedString(additionalParameters) + "\n"
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
   * {@code CustomerRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantCustomerId;
    private String locale;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private DateOfBirth dateOfBirth;
    private String email;
    private String phone;
    private String cellPhone;
    private String nationality;
    private String ip;
    private String paymentHandleTokenFrom;
    private String accountId;
    private Map<String, Object> additionalParameters;

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
    public Builder gender(Gender gender) {
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
     * Inserts one key/value pair to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @return a reference to this Builder
     */
    public Builder putAdditionalParameter(String key, Object value) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.put(key, value);
      return this;
    }

    /**
     * Inserts provided key/value pairs to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @return a reference to this Builder
     */
    public Builder putAllAdditionalParameters(Map<String, Object> additionalParameters) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.putAll(additionalParameters);
      return this;
    }

    /**
     * Sets the {@code additionalParameters} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the {@code additionalParameters} to set
     * @return a reference to this Builder
     */
    public Builder additionalParameters(Map<String, Object> additionalParameters) {
      this.additionalParameters = additionalParameters;
      return this;
    }

    /**
     * Returns a {@code CustomerRequest} built from the parameters previously set.
     *
     * @return a {@code CustomerRequest} built with parameters of this {@code CustomerRequest.Builder}
     */
    public CustomerRequest build() {
      return new CustomerRequest(this);
    }
  }
}

