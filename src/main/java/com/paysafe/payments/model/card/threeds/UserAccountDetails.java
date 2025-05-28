// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.AccountChangedRange;
import com.paysafe.payments.model.card.enums.PasswordChangedRange;
import com.paysafe.payments.model.card.enums.AccountCreatedRange;

/**
 * These are the user account details from the merchant website.
 *
 * <ul>
 *   <li>
 *     <b>addCardAttemptsForLastDay:</b> This is the number of Add Card attempts in the last 24 hours.
 *   </li>
 *   <li>
 *     <b>changedDate:</b> This is the date that the cardholder’s account with the 3DS Requestor was last changed.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
 *   </li>
 *   <li>
 *     <b>changedRange:</b> This is the length of time between the most recent change to the cardholder’s account information
 *     and the API call of the current transaction.  <br>
 *     <i>Allowed values: DURING_TRANSACTION, LESS_THAN_THIRTY_DAYS, THIRTY_TO_SIXTY_DAYS, MORE_THAN_SIXTY_DAYS</i>
 *   </li>
 *   <li>
 *     <b>createdDate:</b> This is the date when the cardholder opened the account with the 3DS Requestor.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
 *   </li>
 *   <li>
 *     <b>createdRange:</b> This is the length of time between the cardholder opening the account with the 3DS Requestor
 *     and the API call of the current transaction.  <br>
 *     <i>Allowed values: NO_ACCOUNT, DURING_TRANSACTION, LESS_THAN_THIRTY_DAYS, THIRTY_TO_SIXTY_DAYS, MORE_THAN_SIXTY_DAYS</i>
 *   </li>
 *   <li>
 *     <b>passwordChangedDate:</b> This is the date when the cardholder’s account was reset or the password was changed.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
 *   </li>
 *   <li>
 *     <b>passwordChangedRange:</b> This is the length of time between the most recent password change or cardholder account reset
 *     and the API call of the current transaction.  <br>
 *     <i>Allowed values: NO_CHANGE, DURING_TRANSACTION, LESS_THAN_THIRTY_DAYS, THIRTY_TO_SIXTY_DAYS, MORE_THAN_SIXTY_DAYS</i>
 *   </li>
 *   <li>
 *     <b>suspiciousAccountActivity:</b> This indicates whether the 3DS Requestor has experienced suspicious activity,
 *     including previous fraud, on the cardholder account.
 *   </li>
 *   <li>
 *     <b>totalPurchasesSixMonthCount:</b> This is the total number of purchases from this cardholder account in the previous six months.
 *   </li>
 *   <li>
 *     <b>transactionCountForPreviousDay:</b> This is the number of transactions (successful and abandoned) for this cardholder account
 *     with the 3DS Requestor across all payment accounts in the previous 24 hours.
 *   </li>
 *   <li>
 *     <b>transactionCountForPreviousYear:</b> This is the number of transactions (successful and abandoned) for this cardholder account
 *     with the 3DS Requestor across all payment accounts in the previous year.
 *   </li>
 *   <li>
 *     <b>shippingDetailsUsage:</b> This is the shipping usage information.
 *   </li>
 *   <li>
 *     <b>userLogin:</b> This is the cardholder login information.
 *   </li>
 *   <li>
 *     <b>paymentAccountDetails:</b> These are the details of the current payment account of the cardholder.
 *   </li>
 *   <li>
 *     <b>priorThreeDSAuthentication:</b> This is the previous authentication information used with current merchant, cardholder, and card.
 *   </li>
 *   <li>
 *     <b>travelDetails:</b> These are the Amex-specific travel details.
 *   </li>
 * </ul>
 */
public class UserAccountDetails {

  @JsonProperty("addCardAttemptsForLastDay")
  private Integer addCardAttemptsForLastDay;
  @JsonProperty("changedDate")
  private String changedDate;
  @JsonProperty("changedRange")
  private AccountChangedRange changedRange;
  @JsonProperty("createdDate")
  private String createdDate;
  @JsonProperty("createdRange")
  private AccountCreatedRange createdRange;
  @JsonProperty("passwordChangedDate")
  private String passwordChangedDate;
  @JsonProperty("passwordChangedRange")
  private PasswordChangedRange passwordChangedRange;
  @JsonProperty("suspiciousAccountActivity")
  private Boolean suspiciousAccountActivity;
  @JsonProperty("totalPurchasesSixMonthCount")
  private Integer totalPurchasesSixMonthCount;
  @JsonProperty("transactionCountForPreviousDay")
  private Integer transactionCountForPreviousDay;
  @JsonProperty("transactionCountForPreviousYear")
  private Integer transactionCountForPreviousYear;
  @JsonProperty("shippingDetailsUsage")
  private ShippingDetailsUsage shippingDetailsUsage;
  @JsonProperty("userLogin")
  private UserLogin userLogin;
  @JsonProperty("paymentAccountDetails")
  private PaymentAccountDetails paymentAccountDetails;
  @JsonProperty("priorThreeDSAuthentication")
  private PriorThreedsAuthentication priorThreeDSAuthentication;
  @JsonProperty("travelDetails")
  private TravelDetails travelDetails;

  public UserAccountDetails() {
    super();
  }

  private UserAccountDetails(final Builder builder) {
    setAddCardAttemptsForLastDay(builder.addCardAttemptsForLastDay);
    setChangedDate(builder.changedDate);
    setPasswordChangedRange(builder.passwordChangedRange);
    setCreatedDate(builder.createdDate);
    setCreatedRange(builder.accountCreatedRange);
    setPasswordChangedDate(builder.passwordChangedDate);
    setSuspiciousAccountActivity(builder.suspiciousAccountActivity);
    setTotalPurchasesSixMonthCount(builder.totalPurchasesSixMonthCount);
    setTransactionCountForPreviousDay(builder.transactionCountForPreviousDay);
    setTransactionCountForPreviousYear(builder.transactionCountForPreviousYear);
    setShippingDetailsUsage(builder.shippingDetailsUsage);
    setUserLogin(builder.userLogin);
    setPaymentAccountDetails(builder.paymentAccountDetails);
    setPriorThreeDSAuthentication(builder.priorThreeDSAuthentication);
    setTravelDetails(builder.travelDetails);
  }

  public static Builder builder() {
    return new Builder();
  }

  public UserAccountDetails addCardAttemptsForLastDay(Integer addCardAttemptsForLastDay) {
    this.addCardAttemptsForLastDay = addCardAttemptsForLastDay;
    return this;
  }

  /**
   * This is the number of Add Card attempts in the last 24 hours.  <br>
   * Maximum: 999
   *
   * @return addCardAttemptsForLastDay
   */
  public Integer getAddCardAttemptsForLastDay() {
    return addCardAttemptsForLastDay;
  }

  public void setAddCardAttemptsForLastDay(Integer addCardAttemptsForLastDay) {
    this.addCardAttemptsForLastDay = addCardAttemptsForLastDay;
  }

  public UserAccountDetails changedDate(String changedDate) {
    this.changedDate = changedDate;
    return this;
  }

  /**
   * This is the date that the cardholder’s account with the 3DS Requestor was last changed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return changedDate
   */
  public String getChangedDate() {
    return changedDate;
  }

  public void setChangedDate(String changedDate) {
    this.changedDate = changedDate;
  }

  public UserAccountDetails changedRange(PasswordChangedRange passwordChangedRange) {
    this.passwordChangedRange = passwordChangedRange;
    return this;
  }

  /**
   * This is the length of time between the most recent change to the cardholder’s account information and the API call of the current transaction.
   *
   * @return changedRange
   */
  public AccountChangedRange getChangedRange() {
    return changedRange;
  }

  public void setChangedRange(AccountChangedRange changedRange) {
    this.changedRange = changedRange;
  }

  public UserAccountDetails createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * This is the date when the cardholder opened the account with the 3DS Requestor. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return createdDate
   */
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public UserAccountDetails createdRange(AccountCreatedRange createdRange) {
    this.createdRange = createdRange;
    return this;
  }

  /**
   * This is the length of time between the cardholder opening the account with the 3DS Requestor and the API call of the current transaction.
   *
   * @return createdRange
   */
  public AccountCreatedRange getCreatedRange() {
    return createdRange;
  }

  public void setCreatedRange(AccountCreatedRange createdRange) {
    this.createdRange = createdRange;
  }

  public UserAccountDetails passwordChangedDate(String passwordChangedDate) {
    this.passwordChangedDate = passwordChangedDate;
    return this;
  }

  /**
   * This is the date when the cardholder’s account was reset or the password was changed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return passwordChangedDate
   */
  public String getPasswordChangedDate() {
    return passwordChangedDate;
  }

  public void setPasswordChangedDate(String passwordChangedDate) {
    this.passwordChangedDate = passwordChangedDate;
  }

  public UserAccountDetails passwordChangedRange(PasswordChangedRange passwordChangedRange) {
    this.passwordChangedRange = passwordChangedRange;
    return this;
  }

  /**
   * This is the length of time between the most recent password change or cardholder account reset and the API call of the current transaction.
   *
   * @return passwordChangedRange
   */
  public PasswordChangedRange getPasswordChangedRange() {
    return passwordChangedRange;
  }

  public void setPasswordChangedRange(PasswordChangedRange passwordChangedRange) {
    this.passwordChangedRange = passwordChangedRange;
  }

  public UserAccountDetails suspiciousAccountActivity(Boolean suspiciousAccountActivity) {
    this.suspiciousAccountActivity = suspiciousAccountActivity;
    return this;
  }

  /**
   * This indicates whether the 3DS Requestor has experienced suspicious activity, including previous fraud, on the cardholder account.
   *
   * @return suspiciousAccountActivity
   */
  public Boolean getSuspiciousAccountActivity() {
    return suspiciousAccountActivity;
  }

  public void setSuspiciousAccountActivity(Boolean suspiciousAccountActivity) {
    this.suspiciousAccountActivity = suspiciousAccountActivity;
  }

  public UserAccountDetails totalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
    this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
    return this;
  }

  /**
   * This is the total number of purchases from this cardholder account in the previous six months.  <br>
   * Maximum: 9999
   *
   * @return totalPurchasesSixMonthCount
   */
  public Integer getTotalPurchasesSixMonthCount() {
    return totalPurchasesSixMonthCount;
  }

  public void setTotalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
    this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
  }

  public UserAccountDetails transactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
    this.transactionCountForPreviousDay = transactionCountForPreviousDay;
    return this;
  }

  /**
   * This is the number of transactions (successful and abandoned) for this cardholder account with the 3DS Requestor across all payment accounts in
   * the previous 24 hours.  <br>
   * Maximum: 999
   *
   * @return transactionCountForPreviousDay
   */
  public Integer getTransactionCountForPreviousDay() {
    return transactionCountForPreviousDay;
  }

  public void setTransactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
    this.transactionCountForPreviousDay = transactionCountForPreviousDay;
  }

  public UserAccountDetails transactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
    this.transactionCountForPreviousYear = transactionCountForPreviousYear;
    return this;
  }

  /**
   * This is the number of transactions (successful and abandoned) for this cardholder account with the 3DS Requestor across all payment accounts
   * in the previous year.  <br>
   * Maximum: 999
   *
   * @return transactionCountForPreviousYear
   */
  public Integer getTransactionCountForPreviousYear() {
    return transactionCountForPreviousYear;
  }

  public void setTransactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
    this.transactionCountForPreviousYear = transactionCountForPreviousYear;
  }

  public UserAccountDetails shippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
    this.shippingDetailsUsage = shippingDetailsUsage;
    return this;
  }

  /**
   * This is the shipping usage information.
   *
   * @return shippingDetailsUsage
   */
  public ShippingDetailsUsage getShippingDetailsUsage() {
    return shippingDetailsUsage;
  }

  public void setShippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
    this.shippingDetailsUsage = shippingDetailsUsage;
  }

  public UserAccountDetails userLogin(UserLogin userLogin) {
    this.userLogin = userLogin;
    return this;
  }

  /**
   * This is the cardholder login information.
   *
   * @return userLogin
   */
  public UserLogin getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(UserLogin userLogin) {
    this.userLogin = userLogin;
  }

  public UserAccountDetails paymentAccountDetails(PaymentAccountDetails paymentAccountDetails) {
    this.paymentAccountDetails = paymentAccountDetails;
    return this;
  }

  /**
   * These are the details of the current payment account of the cardholder.
   *
   * @return paymentAccountDetails
   */
  public PaymentAccountDetails getPaymentAccountDetails() {
    return paymentAccountDetails;
  }

  public void setPaymentAccountDetails(PaymentAccountDetails paymentAccountDetails) {
    this.paymentAccountDetails = paymentAccountDetails;
  }

  public UserAccountDetails priorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
    this.priorThreeDSAuthentication = priorThreeDSAuthentication;
    return this;
  }

  /**
   * This is the previous authentication information used with current merchant, cardholder, and card.
   *
   * @return priorThreeDSAuthentication
   */
  public PriorThreedsAuthentication getPriorThreeDSAuthentication() {
    return priorThreeDSAuthentication;
  }

  public void setPriorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
    this.priorThreeDSAuthentication = priorThreeDSAuthentication;
  }

  public UserAccountDetails travelDetails(TravelDetails travelDetails) {
    this.travelDetails = travelDetails;
    return this;
  }

  /**
   * These are the Amex-specific travel details.
   *
   * @return travelDetails
   */
  public TravelDetails getTravelDetails() {
    return travelDetails;
  }

  public void setTravelDetails(TravelDetails travelDetails) {
    this.travelDetails = travelDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountDetails userAccountDetails = (UserAccountDetails) o;
    return Objects.equals(this.addCardAttemptsForLastDay, userAccountDetails.addCardAttemptsForLastDay) &&
        Objects.equals(this.changedDate, userAccountDetails.changedDate) &&
        Objects.equals(this.changedRange, userAccountDetails.changedRange) &&
        Objects.equals(this.createdDate, userAccountDetails.createdDate) &&
        Objects.equals(this.createdRange, userAccountDetails.createdRange) &&
        Objects.equals(this.passwordChangedDate, userAccountDetails.passwordChangedDate) &&
        Objects.equals(this.passwordChangedRange, userAccountDetails.passwordChangedRange) &&
        Objects.equals(this.suspiciousAccountActivity, userAccountDetails.suspiciousAccountActivity) &&
        Objects.equals(this.totalPurchasesSixMonthCount, userAccountDetails.totalPurchasesSixMonthCount) &&
        Objects.equals(this.transactionCountForPreviousDay, userAccountDetails.transactionCountForPreviousDay) &&
        Objects.equals(this.transactionCountForPreviousYear, userAccountDetails.transactionCountForPreviousYear) &&
        Objects.equals(this.shippingDetailsUsage, userAccountDetails.shippingDetailsUsage) &&
        Objects.equals(this.userLogin, userAccountDetails.userLogin) &&
        Objects.equals(this.paymentAccountDetails, userAccountDetails.paymentAccountDetails) &&
        Objects.equals(this.priorThreeDSAuthentication, userAccountDetails.priorThreeDSAuthentication) &&
        Objects.equals(this.travelDetails, userAccountDetails.travelDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addCardAttemptsForLastDay, changedDate, passwordChangedRange, createdDate, createdRange, passwordChangedDate, passwordChangedRange,
        suspiciousAccountActivity, totalPurchasesSixMonthCount, transactionCountForPreviousDay, transactionCountForPreviousYear, shippingDetailsUsage,
        userLogin, paymentAccountDetails, priorThreeDSAuthentication, travelDetails);
  }

  @Override
  public String toString() {

    return "class UserAccountDetails {\n"
        + "    addCardAttemptsForLastDay: " + toIndentedString(addCardAttemptsForLastDay) + "\n"
        + "    changedDate: " + toIndentedString(changedDate) + "\n"
        + "    changedRange: " + toIndentedString(changedRange) + "\n"
        + "    createdDate: " + toIndentedString(createdDate) + "\n"
        + "    createdRange: " + toIndentedString(createdRange) + "\n"
        + "    passwordChangedDate: " + toIndentedString(passwordChangedDate) + "\n"
        + "    passwordChangedRange: " + toIndentedString(passwordChangedRange) + "\n"
        + "    suspiciousAccountActivity: " + toIndentedString(suspiciousAccountActivity) + "\n"
        + "    totalPurchasesSixMonthCount: " + toIndentedString(totalPurchasesSixMonthCount) + "\n"
        + "    transactionCountForPreviousDay: " + toIndentedString(transactionCountForPreviousDay) + "\n"
        + "    transactionCountForPreviousYear: " + toIndentedString(transactionCountForPreviousYear) + "\n"
        + "    shippingDetailsUsage: " + toIndentedString(shippingDetailsUsage) + "\n"
        + "    userLogin: " + toIndentedString(userLogin) + "\n"
        + "    paymentAccountDetails: " + toIndentedString(paymentAccountDetails) + "\n"
        + "    priorThreeDSAuthentication: " + toIndentedString(priorThreeDSAuthentication) + "\n"
        + "    travelDetails: " + toIndentedString(travelDetails) + "\n"
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
   * {@code UserAccountDetails} builder static inner class.
   */
  public static final class Builder {
    private Integer addCardAttemptsForLastDay;
    private String changedDate;
    private PasswordChangedRange passwordChangedRange;
    private String createdDate;
    private AccountCreatedRange accountCreatedRange;
    private String passwordChangedDate;
    private Boolean suspiciousAccountActivity;
    private Integer totalPurchasesSixMonthCount;
    private Integer transactionCountForPreviousDay;
    private Integer transactionCountForPreviousYear;
    private ShippingDetailsUsage shippingDetailsUsage;
    private UserLogin userLogin;
    private PaymentAccountDetails paymentAccountDetails;
    private PriorThreedsAuthentication priorThreeDSAuthentication;
    private TravelDetails travelDetails;

    private Builder() {
    }

    /**
     * Sets the {@code addCardAttemptsForLastDay} and returns a reference to this Builder enabling method chaining.
     *
     * @param addCardAttemptsForLastDay the {@code addCardAttemptsForLastDay} to set
     * @return a reference to this Builder
     */
    public Builder addCardAttemptsForLastDay(Integer addCardAttemptsForLastDay) {
      this.addCardAttemptsForLastDay = addCardAttemptsForLastDay;
      return this;
    }

    /**
     * Sets the {@code changedDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param changedDate the {@code changedDate} to set
     * @return a reference to this Builder
     */
    public Builder changedDate(String changedDate) {
      this.changedDate = changedDate;
      return this;
    }

    /**
     * Sets the {@code changedRange} and returns a reference to this Builder enabling method chaining.
     *
     * @param passwordChangedRange the {@code changedRange} to set
     * @return a reference to this Builder
     */
    public Builder changedRange(PasswordChangedRange passwordChangedRange) {
      this.passwordChangedRange = passwordChangedRange;
      return this;
    }

    /**
     * Sets the {@code createdDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param createdDate the {@code createdDate} to set
     * @return a reference to this Builder
     */
    public Builder createdDate(String createdDate) {
      this.createdDate = createdDate;
      return this;
    }

    /**
     * Sets the {@code createdRange} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountCreatedRange the {@code createdRange} to set
     * @return a reference to this Builder
     */
    public Builder createdRange(AccountCreatedRange accountCreatedRange) {
      this.accountCreatedRange = accountCreatedRange;
      return this;
    }

    /**
     * Sets the {@code passwordChangedDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param passwordChangedDate the {@code passwordChangedDate} to set
     * @return a reference to this Builder
     */
    public Builder passwordChangedDate(String passwordChangedDate) {
      this.passwordChangedDate = passwordChangedDate;
      return this;
    }

    /**
     * Sets the {@code passwordChangedRange} and returns a reference to this Builder enabling method chaining.
     *
     * @param passwordChangedRange the {@code passwordChangedRange} to set
     * @return a reference to this Builder
     */
    public Builder passwordChangedRange(PasswordChangedRange passwordChangedRange) {
      this.passwordChangedRange = passwordChangedRange;
      return this;
    }

    /**
     * Sets the {@code suspiciousAccountActivity} and returns a reference to this Builder enabling method chaining.
     *
     * @param suspiciousAccountActivity the {@code suspiciousAccountActivity} to set
     * @return a reference to this Builder
     */
    public Builder suspiciousAccountActivity(Boolean suspiciousAccountActivity) {
      this.suspiciousAccountActivity = suspiciousAccountActivity;
      return this;
    }

    /**
     * Sets the {@code totalPurchasesSixMonthCount} and returns a reference to this Builder enabling method chaining.
     *
     * @param totalPurchasesSixMonthCount the {@code totalPurchasesSixMonthCount} to set
     * @return a reference to this Builder
     */
    public Builder totalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
      this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
      return this;
    }

    /**
     * Sets the {@code transactionCountForPreviousDay} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionCountForPreviousDay the {@code transactionCountForPreviousDay} to set
     * @return a reference to this Builder
     */
    public Builder transactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
      this.transactionCountForPreviousDay = transactionCountForPreviousDay;
      return this;
    }

    /**
     * Sets the {@code transactionCountForPreviousYear} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionCountForPreviousYear the {@code transactionCountForPreviousYear} to set
     * @return a reference to this Builder
     */
    public Builder transactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
      this.transactionCountForPreviousYear = transactionCountForPreviousYear;
      return this;
    }

    /**
     * Sets the {@code shippingDetailsUsage} and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingDetailsUsage the {@code shippingDetailsUsage} to set
     * @return a reference to this Builder
     */
    public Builder shippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
      this.shippingDetailsUsage = shippingDetailsUsage;
      return this;
    }

    /**
     * Sets the {@code userLogin} and returns a reference to this Builder enabling method chaining.
     *
     * @param userLogin the {@code userLogin} to set
     * @return a reference to this Builder
     */
    public Builder userLogin(UserLogin userLogin) {
      this.userLogin = userLogin;
      return this;
    }

    /**
     * Sets the {@code paymentAccountDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentAccountDetails the {@code paymentAccountDetails} to set
     * @return a reference to this Builder
     */
    public Builder paymentAccountDetails(PaymentAccountDetails paymentAccountDetails) {
      this.paymentAccountDetails = paymentAccountDetails;
      return this;
    }

    /**
     * Sets the {@code priorThreeDSAuthentication} and returns a reference to this Builder enabling method chaining.
     *
     * @param priorThreeDSAuthentication the {@code priorThreeDSAuthentication} to set
     * @return a reference to this Builder
     */
    public Builder priorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
      this.priorThreeDSAuthentication = priorThreeDSAuthentication;
      return this;
    }

    /**
     * Sets the {@code travelDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param travelDetails the {@code travelDetails} to set
     * @return a reference to this Builder
     */
    public Builder travelDetails(TravelDetails travelDetails) {
      this.travelDetails = travelDetails;
      return this;
    }

    /**
     * Returns a {@code UserAccountDetails} built from the parameters previously set.
     *
     * @return a {@code UserAccountDetails} built with parameters of this {@code UserAccountDetails.Builder}
     */
    public UserAccountDetails build() {
      return new UserAccountDetails(this);
    }
  }
}

