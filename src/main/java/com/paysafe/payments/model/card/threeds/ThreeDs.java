// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.BillingCycle;
import com.paysafe.payments.model.card.enums.AuthenticationPurpose;
import com.paysafe.payments.model.card.enums.RequesterChallengePreference;
import com.paysafe.payments.model.card.enums.TransactionIntent;

/**
 * This is the threeDs object.
 * You need to send this object when you want to process CARD transaction with 3DS.
 * Required if account is enabled for 3DS.  <br>
 * Not required if account is non-3DS.  <br>
 * If you are using your own 3DS service provider. Please refer 'authentication' object if you are using your own 3DS service provider.
 *
 * <ul>
 *   <li>
 *     <b>id:</b> This is the unique ID returned in the response.
 *   </li>
 *   <li>
 *     <b>deviceFingerprintingId:</b> This is the UUID used with device fingerprinting.
 *   </li>
 *   <li>
 *     <b>merchantRefNum:</b> This is the merchant reference number created by the merchant and submitted as part of the request.
 *     It must be unique for each request.  <br>
 *     Example: fc5b62df1202e491475d
 *   </li>
 *   <li>
 *     <b>process:</b> This is an indicator representing whether to call authenticate end point or not.
 *   </li>
 *   <li>
 *     <b>merchantUrl:</b> This is the fully qualified URL of the merchant's commercial or customer care website.  <br>
 *     Example: https://api.qa.paysafe.com/checkout/v2/demo-store/index.html
 *   </li>
 *   <li>
 *     <b>deviceChannel:</b> This is the type of channel interface used to initiate the transaction.  <br>
 *     <i>Allowed values: BROWSER, SDK, 3RI</i>
 *   </li>
 *   <li>
 *     <b>requestorChallengePreference:</b> This indicates whether a challenge is requested for this transaction.  <br>
 *     <i>Allowed values: NO_PREFERENCE, NO_CHALLENGE_REQUESTED, CHALLENGE_REQUESTED, CHALLENGE_MANDATED</i>
 *   </li>
 *   <li>
 *     <b>messageCategory:</b> This is the category of the message for a specific use case.  <br>
 *     <i>Allowed values: PAYMENT, NON_PAYMENT</i>
 *   </li>
 *   <li>
 *     <b>transactionIntent:</b> This identifies the type of transaction being authenticated.  <br>
 *     <i>Allowed values: GOODS_OR_SERVICE_PURCHASE, CHECK_ACCEPTANCE, ACCOUNT_FUNDING, QUASI_CASH_TRANSACTION,
 *     PREPAID_ACTIVATION</i>
 *   </li>
 *   <li>
 *     <b>authenticationPurpose:</b> This is the type of Authentication request. This data element provides additional
 *     information to the ACS to determine the best approach for handling an authentication request.  <br>
 *     <i>Allowed values: PAYMENT_TRANSACTION, RECURRING_TRANSACTION, INSTALMENT_TRANSACTION, ADD_CARD, MAINTAIN_CARD
 *     EMV_TOKEN_VERIFICATION</i>
 *   </li>
 *   <li>
 *     <b>billingCycle:</b> Details of the billing cycle information for recurring payments.  <br>
 *     <b>Note:</b> This object is required if authenticationPurpose = INSTALMENT_TRANSACTION or RECURRING_TRANSACTION.
 *   </li>
 *   <li>
 *     <b>orderItemDetails:</b> Order item details.  <br>
 *   </li>
 *   <li>
 *     <b>purchasedGiftCardDetails:</b> Purchased gift card details.
 *   </li>
 *   <li>
 *     <b>userAccountDetails:</b> These are the user account details from the merchant website.
 *   </li>
 *   <li>
 *     <b>priorThreeDSAuthentication:</b> This is the previous authentication information used with current merchant, cardholder, and card.
 *   </li>
 *   <li>
 *     <b>shippingDetailsUsage:</b> This is the shipping usage information.
 *   </li>
 *   <li>
 *     <b>suspiciousAccountActivity:</b> This indicates whether the 3DS Requestor has experienced suspicious activity,
 *     including previous fraud, on the cardholder account.
 *   </li>
 *   <li>
 *     <b>totalPurchasesSixMonthCount:</b> Transaction count for last 6 months.
 *   </li>
 *   <li>
 *     <b>transactionCountForPreviousDay:</b> Transaction count for last 24 hours.
 *   </li>
 *   <li>
 *     <b>transactionCountForPreviousYear:</b> Transaction count for last 1 year.
 *   </li>
 *   <li>
 *     <b>travelDetails:</b> These are the Amex-specific travel details.
 *   </li>
 *   <li>
 *     <b>userLogin:</b> This is the cardholder login information.
 *   </li>
 *   <li>
 *     <b>browserDetails:</b> These are the browser details.  <br>
 *     <b>Note:</b> This object is not required if the Paysafe SDK is used for device fingerprinting.
 *   </li>
 *   <li>
 *     <b>cavv:</b> This is the Cardholder Authentication Verification Value, indicating that the transaction has been authenticated.
 *   </li>
 *   <li>
 *     <b>eci:</b> This is the Electronic Commerce Indicator code, which gets returned by the card issuer indicating
 *     whether the cardholder was successfully authenticated.
 *   </li>
 *   <li>
 *     <b>status:</b> This is the status of the authentication request.  <br>
 *     <i>Allowed values: COMPLETED, PENDING, FAILED</i>
 *   </li>
 *   <li>
 *     <b>threeDResult:</b> ThreeDResult values.  <br>
 *     <i>Allowed values: Y, A, N, U, E, C, R</i>
 *   </li>
 *   <li>
 *     <b>txnTime:</b> This is the date and time the request was processed.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.
 *   </li>
 *   <li>
 *     <b>directoryServerTransactionId:</b> This is the directory server transaction ID required for Mastercard.  <br>
 *     <b>Note:</b> This exists only for 3D Secure 2.
 *   </li>
 *   <li>
 *     <b>threeDSecureVersion:</b> This is the 3D Secure protocol version, returned in the response.  <br>
 *     <b>Note:</b> If version 2 is not available for the card provided, the value defaults to 1.0.2.
 *   </li>
 *   <li>
 *     <b>acsUrl:</b> This is the fully qualified URL to redirect the consumer to complete the payer authentication transaction.
 *   </li>
 *   <li>
 *     <b>payload:</b> This is the encoded Payment Authentication Request generated by the merchant authentication processing system (MAPS).
 *   </li>
 *   <li>
 *     <b>sdkChallengePayload:</b> This is a payload that, if returned, should be passed to the challenge function of the JavaScrip
 *     SDK to continue with the challenge.
 *   </li>
 *   <li>
 *     <b>xid:</b> This is the transaction identifier returned by the card issuer.  <br>
 *     <b>Note:</b> This exists only for 3DS 1.0.2.
 *   </li>
 *   <li>
 *     <b>threeDEnrollment:</b> ThreeDEnrollment values.  <br>
 *     <i>Allowed valued: Y, N, U</i>
 *   </li>
 *   <li>
 *     <b>maxAuthorizationsForInstalmentPayment:</b> This is the maxAuthorizationsForInstalmentPayment of the request, in minor units.
 *   </li>
 *   <li>
 *     <b>electronicDelivery:</b> Electronic delivery.
 *   </li>
 *   <li>
 *     <b>initialPurchaseTime:</b> This is the date and time of the purchase.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.  <br>
 *     <b>Note:</b> This element is required only if messageCategory=NON_PAYMENT and
 *     authenticationPurpose=INSTALMENT_TRANSACTION or RECURRING_TRANSACTION.
 *   </li>
 *   <li>
 *     <b>amount:</b> This is the amount of the request, in minor units.
 *   </li>
 * </ul>
 */
public class ThreeDs {

  @JsonProperty("id")
  private String id;
  @JsonProperty("deviceFingerprintingId")
  private String deviceFingerprintingId;
  @JsonProperty("merchantUrl")
  private String merchantUrl;
  @JsonProperty("deviceChannel")
  private String deviceChannel;
  @JsonProperty("requestorChallengePreference")
  private RequesterChallengePreference requestorChallengePreference;
  @JsonProperty("messageCategory")
  private String messageCategory;
  @JsonProperty("transactionIntent")
  private TransactionIntent transactionIntent;
  @JsonProperty("authenticationPurpose")
  private AuthenticationPurpose authenticationPurpose;
  @JsonProperty("billingCycle")
  private BillingCycle billingCycle;
  @JsonProperty("orderItemDetails")
  private OrderItemDetails orderItemDetails;
  @JsonProperty("purchasedGiftCardDetails")
  private PurchasedGiftCardDetails purchasedGiftCardDetails;
  @JsonProperty("userAccountDetails")
  private UserAccountDetails userAccountDetails;
  @JsonProperty("priorThreeDSAuthentication")
  private PriorThreedsAuthentication priorThreeDSAuthentication;
  @JsonProperty("shippingDetailsUsage")
  private ShippingDetailsUsage shippingDetailsUsage;
  @JsonProperty("suspiciousAccountActivity")
  private Boolean suspiciousAccountActivity;
  @JsonProperty("totalPurchasesSixMonthCount")
  private Integer totalPurchasesSixMonthCount;
  @JsonProperty("transactionCountForPreviousDay")
  private Integer transactionCountForPreviousDay;
  @JsonProperty("transactionCountForPreviousYear")
  private Integer transactionCountForPreviousYear;
  @JsonProperty("travelDetails")
  private TravelDetails travelDetails;
  @JsonProperty("userLogin")
  private UserLogin userLogin;
  @JsonProperty("browserDetails")
  private BrowserDetails browserDetails;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("maxAuthorizationsForInstalmentPayment")
  private Integer maxAuthorizationsForInstalmentPayment;
  @JsonProperty("electronicDelivery")
  private ElectronicDelivery electronicDelivery;
  @JsonProperty("initialPurchaseTime")
  private String initialPurchaseTime;

  public ThreeDs() {
    super();
  }

  private ThreeDs(Builder builder) {
    setId(builder.id);
    setDeviceFingerprintingId(builder.deviceFingerprintingId);
    setMerchantUrl(builder.merchantUrl);
    setDeviceChannel(builder.deviceChannel);
    setRequestorChallengePreference(builder.requestorChallengePreference);
    setMessageCategory(builder.messageCategory);
    setTransactionIntent(builder.transactionIntent);
    setAuthenticationPurpose(builder.authenticationPurpose);
    setBillingCycle(builder.billingCycle);
    setOrderItemDetails(builder.orderItemDetails);
    setPurchasedGiftCardDetails(builder.purchasedGiftCardDetails);
    setUserAccountDetails(builder.userAccountDetails);
    setPriorThreeDSAuthentication(builder.priorThreeDSAuthentication);
    setShippingDetailsUsage(builder.shippingDetailsUsage);
    setSuspiciousAccountActivity(builder.suspiciousAccountActivity);
    setTotalPurchasesSixMonthCount(builder.totalPurchasesSixMonthCount);
    setTransactionCountForPreviousDay(builder.transactionCountForPreviousDay);
    setTransactionCountForPreviousYear(builder.transactionCountForPreviousYear);
    setTravelDetails(builder.travelDetails);
    setUserLogin(builder.userLogin);
    setBrowserDetails(builder.browserDetails);
    setTxnTime(builder.txnTime);
    setMaxAuthorizationsForInstalmentPayment(builder.maxAuthorizationsForInstalmentPayment);
    setElectronicDelivery(builder.electronicDelivery);
    setInitialPurchaseTime(builder.initialPurchaseTime);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ThreeDs id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the unique ID returned in the response.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDeviceFingerprintingId() {
    return deviceFingerprintingId;
  }

  public void setDeviceFingerprintingId(String deviceFingerprintingId) {
    this.deviceFingerprintingId = deviceFingerprintingId;
  }

  public ThreeDs merchantUrl(String merchantUrl) {
    this.merchantUrl = merchantUrl;
    return this;
  }

  /**
   * This is the fully qualified URL of the merchant's commercial or customer care website.
   *
   * @return merchantUrl
   */
  public String getMerchantUrl() {
    return merchantUrl;
  }

  public void setMerchantUrl(String merchantUrl) {
    this.merchantUrl = merchantUrl;
  }

  public ThreeDs deviceChannel(String deviceChannel) {
    this.deviceChannel = deviceChannel;
    return this;
  }

  /**
   * This is the type of channel interface used to initiate the transaction.
   *
   * @return deviceChannel
   */
  public String getDeviceChannel() {
    return deviceChannel;
  }

  public void setDeviceChannel(String deviceChannel) {
    this.deviceChannel = deviceChannel;
  }

  public ThreeDs requestorChallengePreference(RequesterChallengePreference requestorChallengePreference) {
    this.requestorChallengePreference = requestorChallengePreference;
    return this;
  }

  /**
   * This indicates whether a challenge is requested for this transaction.
   *
   * @return requestorChallengePreference
   */
  public RequesterChallengePreference getRequestorChallengePreference() {
    return requestorChallengePreference;
  }

  public void setRequestorChallengePreference(RequesterChallengePreference requestorChallengePreference) {
    this.requestorChallengePreference = requestorChallengePreference;
  }

  public ThreeDs messageCategory(String messageCategory) {
    this.messageCategory = messageCategory;
    return this;
  }

  /**
   * This is the category of the message for a specific use case. Values: PAYMENT, NON_PAYMENT
   *
   * @return messageCategory
   */
  public String getMessageCategory() {
    return messageCategory;
  }

  public void setMessageCategory(String messageCategory) {
    this.messageCategory = messageCategory;
  }

  public ThreeDs transactionIntent(TransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * This identifies the type of transaction being authenticated.
   *
   * @return transactionIntent
   */
  public TransactionIntent getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(TransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
  }

  public ThreeDs authenticationPurpose(AuthenticationPurpose authenticationPurpose) {
    this.authenticationPurpose = authenticationPurpose;
    return this;
  }

  /**
   * This is the type of Authentication request. This data element provides additional information to the ACS to
   * determine the best approach for handling an authentication request.
   *
   * @return authenticationPurpose
   * *
   */
  public AuthenticationPurpose getAuthenticationPurpose() {
    return authenticationPurpose;
  }

  public void setAuthenticationPurpose(AuthenticationPurpose authenticationPurpose) {
    this.authenticationPurpose = authenticationPurpose;
  }

  public ThreeDs billingCycle(BillingCycle billingCycle) {
    this.billingCycle = billingCycle;
    return this;
  }

  /**
   * Details of the billing cycle information for recurring payments.
   * Mandatory if authenticationPurpose = INSTALMENT_TRANSACTION or RECURRING_TRANSACTION.
   *
   * @return billingCycle
   */
  public BillingCycle getBillingCycle() {
    return billingCycle;
  }

  public void setBillingCycle(BillingCycle billingCycle) {
    this.billingCycle = billingCycle;
  }

  public ThreeDs orderItemDetails(OrderItemDetails orderItemDetails) {
    this.orderItemDetails = orderItemDetails;
    return this;
  }

  /**
   * Get orderItemDetails
   *
   * @return orderItemDetails
   */
  public OrderItemDetails getOrderItemDetails() {
    return orderItemDetails;
  }

  public void setOrderItemDetails(OrderItemDetails orderItemDetails) {
    this.orderItemDetails = orderItemDetails;
  }

  public ThreeDs purchasedGiftCardDetails(PurchasedGiftCardDetails purchasedGiftCardDetails) {
    this.purchasedGiftCardDetails = purchasedGiftCardDetails;
    return this;
  }

  /**
   * Get purchasedGiftCardDetails
   *
   * @return purchasedGiftCardDetails
   */
  public PurchasedGiftCardDetails getPurchasedGiftCardDetails() {
    return purchasedGiftCardDetails;
  }

  public void setPurchasedGiftCardDetails(PurchasedGiftCardDetails purchasedGiftCardDetails) {
    this.purchasedGiftCardDetails = purchasedGiftCardDetails;
  }

  public ThreeDs userAccountDetails(UserAccountDetails userAccountDetails) {
    this.userAccountDetails = userAccountDetails;
    return this;
  }

  /**
   * These are the user account details from the merchant website.
   *
   * @return userAccountDetails
   */
  public UserAccountDetails getUserAccountDetails() {
    return userAccountDetails;
  }

  public void setUserAccountDetails(UserAccountDetails userAccountDetails) {
    this.userAccountDetails = userAccountDetails;
  }

  public ThreeDs priorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
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

  public ThreeDs shippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
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

  public ThreeDs suspiciousAccountActivity(Boolean suspiciousAccountActivity) {
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

  public ThreeDs totalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
    this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
    return this;
  }

  /**
   * Transaction count for last 6 months.  <br>
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

  public ThreeDs transactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
    this.transactionCountForPreviousDay = transactionCountForPreviousDay;
    return this;
  }

  /**
   * Transaction count for last 24 hours
   * maximum: 999
   *
   * @return transactionCountForPreviousDay
   */
  public Integer getTransactionCountForPreviousDay() {
    return transactionCountForPreviousDay;
  }

  public void setTransactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
    this.transactionCountForPreviousDay = transactionCountForPreviousDay;
  }

  public ThreeDs transactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
    this.transactionCountForPreviousYear = transactionCountForPreviousYear;
    return this;
  }

  /**
   * Transaction count for last 1 year.  <br>
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

  public ThreeDs travelDetails(TravelDetails travelDetails) {
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

  public ThreeDs userLogin(UserLogin userLogin) {
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

  public ThreeDs browserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
    return this;
  }

  /**
   * These are the browser details. <b>Note:</b> This object is not required if the Paysafe SDK is used for device fingerprinting.
   *
   * @return browserDetails
   */
  public BrowserDetails getBrowserDetails() {
    return browserDetails;
  }

  public void setBrowserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
  }

  public ThreeDs txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * This is the date and time the request was processed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }

  public ThreeDs maxAuthorizationsForInstalmentPayment(Integer maxAuthorizationsForInstalmentPayment) {
    this.maxAuthorizationsForInstalmentPayment = maxAuthorizationsForInstalmentPayment;
    return this;
  }

  /**
   * This is the maxAuthorizationsForInstalmentPayment of the request, in minor units. <br>
   * minimum: 1  <br>
   * maximum: 999
   *
   * @return maxAuthorizationsForInstalmentPayment
   */
  public Integer getMaxAuthorizationsForInstalmentPayment() {
    return maxAuthorizationsForInstalmentPayment;
  }

  public void setMaxAuthorizationsForInstalmentPayment(Integer maxAuthorizationsForInstalmentPayment) {
    this.maxAuthorizationsForInstalmentPayment = maxAuthorizationsForInstalmentPayment;
  }

  public ThreeDs electronicDelivery(ElectronicDelivery electronicDelivery) {
    this.electronicDelivery = electronicDelivery;
    return this;
  }

  /**
   * Get electronicDelivery
   *
   * @return electronicDelivery
   */
  public ElectronicDelivery getElectronicDelivery() {
    return electronicDelivery;
  }

  public void setElectronicDelivery(ElectronicDelivery electronicDelivery) {
    this.electronicDelivery = electronicDelivery;
  }

  public ThreeDs initialPurchaseTime(String initialPurchaseTime) {
    this.initialPurchaseTime = initialPurchaseTime;
    return this;
  }

  /**
   * This is the date and time of the purchase. The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.  <b>Note:</b> This element is required only
   * if messageCategory=NON_PAYMENT and authenticationPurpose=INSTALMENT_TRANSACTION or RECURRING_TRANSACTION.
   *
   * @return initialPurchaseTime
   */
  public String getInitialPurchaseTime() {
    return initialPurchaseTime;
  }

  public void setInitialPurchaseTime(String initialPurchaseTime) {
    this.initialPurchaseTime = initialPurchaseTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreeDs threeDs = (ThreeDs) o;
    return Objects.equals(this.id, threeDs.id) &&
        Objects.equals(this.deviceFingerprintingId, threeDs.deviceFingerprintingId) &&
        Objects.equals(this.merchantUrl, threeDs.merchantUrl) &&
        Objects.equals(this.deviceChannel, threeDs.deviceChannel) &&
        Objects.equals(this.requestorChallengePreference, threeDs.requestorChallengePreference) &&
        Objects.equals(this.messageCategory, threeDs.messageCategory) &&
        Objects.equals(this.transactionIntent, threeDs.transactionIntent) &&
        Objects.equals(this.authenticationPurpose, threeDs.authenticationPurpose) &&
        Objects.equals(this.billingCycle, threeDs.billingCycle) &&
        Objects.equals(this.orderItemDetails, threeDs.orderItemDetails) &&
        Objects.equals(this.purchasedGiftCardDetails, threeDs.purchasedGiftCardDetails) &&
        Objects.equals(this.userAccountDetails, threeDs.userAccountDetails) &&
        Objects.equals(this.priorThreeDSAuthentication, threeDs.priorThreeDSAuthentication) &&
        Objects.equals(this.shippingDetailsUsage, threeDs.shippingDetailsUsage) &&
        Objects.equals(this.suspiciousAccountActivity, threeDs.suspiciousAccountActivity) &&
        Objects.equals(this.totalPurchasesSixMonthCount, threeDs.totalPurchasesSixMonthCount) &&
        Objects.equals(this.transactionCountForPreviousDay, threeDs.transactionCountForPreviousDay) &&
        Objects.equals(this.transactionCountForPreviousYear, threeDs.transactionCountForPreviousYear) &&
        Objects.equals(this.travelDetails, threeDs.travelDetails) &&
        Objects.equals(this.userLogin, threeDs.userLogin) &&
        Objects.equals(this.browserDetails, threeDs.browserDetails) &&
        Objects.equals(this.txnTime, threeDs.txnTime) &&
        Objects.equals(this.maxAuthorizationsForInstalmentPayment, threeDs.maxAuthorizationsForInstalmentPayment) &&
        Objects.equals(this.electronicDelivery, threeDs.electronicDelivery) &&
        Objects.equals(this.initialPurchaseTime, threeDs.initialPurchaseTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, deviceFingerprintingId, merchantUrl, deviceChannel, requestorChallengePreference, messageCategory, transactionIntent,
        authenticationPurpose, billingCycle, orderItemDetails, purchasedGiftCardDetails, userAccountDetails, priorThreeDSAuthentication, shippingDetailsUsage,
        suspiciousAccountActivity, totalPurchasesSixMonthCount, transactionCountForPreviousDay, transactionCountForPreviousYear, travelDetails, userLogin,
        browserDetails, txnTime, maxAuthorizationsForInstalmentPayment, electronicDelivery, initialPurchaseTime);
  }

  @Override
  public String toString() {

    return "class ThreeDs {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    deviceFingerprintingId: " + toIndentedString(deviceFingerprintingId) + "\n"
        + "    merchantUrl: " + toIndentedString(merchantUrl) + "\n"
        + "    deviceChannel: " + toIndentedString(deviceChannel) + "\n"
        + "    requestorChallengePreference: " + toIndentedString(requestorChallengePreference) + "\n"
        + "    messageCategory: " + toIndentedString(messageCategory) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    authenticationPurpose: " + toIndentedString(authenticationPurpose) + "\n"
        + "    billingCycle: " + toIndentedString(billingCycle) + "\n"
        + "    orderItemDetails: " + toIndentedString(orderItemDetails) + "\n"
        + "    purchasedGiftCardDetails: " + toIndentedString(purchasedGiftCardDetails) + "\n"
        + "    userAccountDetails: " + toIndentedString(userAccountDetails) + "\n"
        + "    priorThreeDSAuthentication: " + toIndentedString(priorThreeDSAuthentication) + "\n"
        + "    shippingDetailsUsage: " + toIndentedString(shippingDetailsUsage) + "\n"
        + "    suspiciousAccountActivity: " + toIndentedString(suspiciousAccountActivity) + "\n"
        + "    totalPurchasesSixMonthCount: " + toIndentedString(totalPurchasesSixMonthCount) + "\n"
        + "    transactionCountForPreviousDay: " + toIndentedString(transactionCountForPreviousDay) + "\n"
        + "    transactionCountForPreviousYear: " + toIndentedString(transactionCountForPreviousYear) + "\n"
        + "    travelDetails: " + toIndentedString(travelDetails) + "\n"
        + "    userLogin: " + toIndentedString(userLogin) + "\n"
        + "    browserDetails: " + toIndentedString(browserDetails) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    maxAuthorizationsForInstalmentPayment: " + toIndentedString(maxAuthorizationsForInstalmentPayment) + "\n"
        + "    electronicDelivery: " + toIndentedString(electronicDelivery) + "\n"
        + "    initialPurchaseTime: " + toIndentedString(initialPurchaseTime) + "\n"
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
   * {@code ThreeDs} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String deviceFingerprintingId;
    private String merchantUrl;
    private String deviceChannel;
    private RequesterChallengePreference requestorChallengePreference;
    private String messageCategory;
    private TransactionIntent transactionIntent;
    private AuthenticationPurpose authenticationPurpose;
    private BillingCycle billingCycle;
    private OrderItemDetails orderItemDetails;
    private PurchasedGiftCardDetails purchasedGiftCardDetails;
    private UserAccountDetails userAccountDetails;
    private PriorThreedsAuthentication priorThreeDSAuthentication;
    private ShippingDetailsUsage shippingDetailsUsage;
    private Boolean suspiciousAccountActivity;
    private Integer totalPurchasesSixMonthCount;
    private Integer transactionCountForPreviousDay;
    private Integer transactionCountForPreviousYear;
    private TravelDetails travelDetails;
    private UserLogin userLogin;
    private BrowserDetails browserDetails;
    private String txnTime;
    private Integer maxAuthorizationsForInstalmentPayment;
    private ElectronicDelivery electronicDelivery;
    private String initialPurchaseTime;

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
     * Sets the {@code deviceFingerprintingId} and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceFingerprintingId the {@code deviceFingerprintingId} to set
     * @return a reference to this Builder
     */
    public Builder deviceFingerprintingId(String deviceFingerprintingId) {
      this.deviceFingerprintingId = deviceFingerprintingId;
      return this;
    }

    /**
     * Sets the {@code merchantUrl} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantUrl the {@code merchantUrl} to set
     * @return a reference to this Builder
     */
    public Builder merchantUrl(String merchantUrl) {
      this.merchantUrl = merchantUrl;
      return this;
    }

    /**
     * Sets the {@code deviceChannel} and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceChannel the {@code deviceChannel} to set
     * @return a reference to this Builder
     */
    public Builder deviceChannel(String deviceChannel) {
      this.deviceChannel = deviceChannel;
      return this;
    }

    /**
     * Sets the {@code requestorChallengePreference} and returns a reference to this Builder enabling method chaining.
     *
     * @param requestorChallengePreference the {@code requestorChallengePreference} to set
     * @return a reference to this Builder
     */
    public Builder requestorChallengePreference(RequesterChallengePreference requestorChallengePreference) {
      this.requestorChallengePreference = requestorChallengePreference;
      return this;
    }

    /**
     * Sets the {@code messageCategory} and returns a reference to this Builder enabling method chaining.
     *
     * @param messageCategory the {@code messageCategory} to set
     * @return a reference to this Builder
     */
    public Builder messageCategory(String messageCategory) {
      this.messageCategory = messageCategory;
      return this;
    }

    /**
     * Sets the {@code transactionIntent} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the {@code transactionIntent} to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(TransactionIntent transactionIntent) {
      this.transactionIntent = transactionIntent;
      return this;
    }

    /**
     * Sets the {@code authenticationPurpose} and returns a reference to this Builder enabling method chaining.
     *
     * @param authenticationPurpose the {@code authenticationPurpose} to set
     * @return a reference to this Builder
     */
    public Builder authenticationPurpose(AuthenticationPurpose authenticationPurpose) {
      this.authenticationPurpose = authenticationPurpose;
      return this;
    }

    /**
     * Sets the {@code billingCycle} and returns a reference to this Builder enabling method chaining.
     *
     * @param billingCycle the {@code billingCycle} to set
     * @return a reference to this Builder
     */
    public Builder billingCycle(BillingCycle billingCycle) {
      this.billingCycle = billingCycle;
      return this;
    }

    /**
     * Sets the {@code orderItemDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param orderItemDetails the {@code orderItemDetails} to set
     * @return a reference to this Builder
     */
    public Builder orderItemDetails(OrderItemDetails orderItemDetails) {
      this.orderItemDetails = orderItemDetails;
      return this;
    }

    /**
     * Sets the {@code purchasedGiftCardDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param purchasedGiftCardDetails the {@code purchasedGiftCardDetails} to set
     * @return a reference to this Builder
     */
    public Builder purchasedGiftCardDetails(PurchasedGiftCardDetails purchasedGiftCardDetails) {
      this.purchasedGiftCardDetails = purchasedGiftCardDetails;
      return this;
    }

    /**
     * Sets the {@code userAccountDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param userAccountDetails the {@code userAccountDetails} to set
     * @return a reference to this Builder
     */
    public Builder userAccountDetails(UserAccountDetails userAccountDetails) {
      this.userAccountDetails = userAccountDetails;
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
     * Sets the {@code browserDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param browserDetails the {@code browserDetails} to set
     * @return a reference to this Builder
     */
    public Builder browserDetails(BrowserDetails browserDetails) {
      this.browserDetails = browserDetails;
      return this;
    }

    /**
     * Sets the {@code txnTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param txnTime the {@code txnTime} to set
     * @return a reference to this Builder
     */
    public Builder txnTime(String txnTime) {
      this.txnTime = txnTime;
      return this;
    }

    /**
     * Sets the {@code maxAuthorizationsForInstalmentPayment} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAuthorizationsForInstalmentPayment the {@code maxAuthorizationsForInstalmentPayment} to set
     * @return a reference to this Builder
     */
    public Builder maxAuthorizationsForInstalmentPayment(Integer maxAuthorizationsForInstalmentPayment) {
      this.maxAuthorizationsForInstalmentPayment = maxAuthorizationsForInstalmentPayment;
      return this;
    }

    /**
     * Sets the {@code electronicDelivery} and returns a reference to this Builder enabling method chaining.
     *
     * @param electronicDelivery the {@code electronicDelivery} to set
     * @return a reference to this Builder
     */
    public Builder electronicDelivery(ElectronicDelivery electronicDelivery) {
      this.electronicDelivery = electronicDelivery;
      return this;
    }

    /**
     * Sets the {@code initialPurchaseTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param initialPurchaseTime the {@code initialPurchaseTime} to set
     * @return a reference to this Builder
     */
    public Builder initialPurchaseTime(String initialPurchaseTime) {
      this.initialPurchaseTime = initialPurchaseTime;
      return this;
    }

    /**
     * Returns a {@code ThreeDs} built from the parameters previously set.
     *
     * @return a {@code ThreeDs} built with parameters of this {@code ThreeDs.Builder}
     */
    public ThreeDs build() {
      return new ThreeDs(this);
    }
  }
}

