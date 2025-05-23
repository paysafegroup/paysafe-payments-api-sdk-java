// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.payment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.AccordD;
import com.paysafe.payments.model.card.AcquirerData;
import com.paysafe.payments.model.card.FundingTransaction;
import com.paysafe.payments.model.card.Level2Level3;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.Recipient;
import com.paysafe.payments.model.common.StoredCredential;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.lpm.Splitpay;

/**
 * Represents the body of a payment request, containing all the necessary details for processing a transaction.
 *
 * <p>The {@code PaymentReqBody} class includes fields related to the payment amount, merchant information,
 * customer data, transaction details, and specific travel or service-related details.</p>
 *
 * <p>Key fields:</p>
 * <ul>
 *   <li><strong>merchantRefNum:</strong> The merchant's unique reference number for the transaction.</li>
 *   <li><strong>amount:</strong> The amount for the transaction, expressed in minor units.</li>
 *   <li><strong>dupCheck:</strong> This validates that this request is not a duplicate.
 *   A duplicate request is when the merchantRefNum has already been used in a previous request within the past 90 days.</li>
 *   <li><strong>settleWithAuth:</strong> A flag indicating whether the transaction should be settled with authorization.</li>
 *   <li><strong>paymentHandleToken:</strong> The token that represents a payment handle for the transaction.</li>
 *   <li><strong>customerIp:</strong> The IP address of the customer making the payment.</li>
 *   <li><strong>currencyCode:</strong> The currency code used for the transaction.</li>
 *   <li><strong>preAuth:</strong> A flag indicating whether this is a pre-authorization transaction.</li>
 *   <li><strong>description:</strong> A description of the transaction.</li>
 *   <li><strong>level2Level3TransactionDetails:</strong> Additional transaction details for Level 2 and Level 3 processing.</li>
 *   <li><strong>financingDetails:</strong> Details related to financing options for the transaction.</li>
 *   <li><strong>recipient:</strong> Information about the recipient of the payment.</li>
 *   <li><strong>splitPay:</strong> Details about how the payment should be split across multiple recipients.</li>
 *   <li><strong>StoredCredential:</strong> Details of the stored credentials for recurring payments.</li>
 *   <li><strong>airlineTravelDetails:</strong> Details related to airline travel transactions.</li>
 *   <li><strong>fundingTransaction:</strong> Details for a funding transaction in the payment request.</li>
 *   <li><strong>cruiseLineTravelDetails:</strong> Details related to cruise line travel transactions.</li>
 *   <li><strong>lodgingDetails:</strong> Details related to lodging transactions, including hotel stays.</li>
 *   <li><strong>carRentalDetails:</strong> Details related to car rental transactions.</li>
 *   <li><strong>paymentFacilitator:</strong> Information about the payment facilitator handling the transaction.</li>
 *   <li><strong>merchantDescriptor:</strong> Describes the merchant details for the transaction.</li>
 *   <li><strong>acquirerData:</strong> Data from the acquirer associated with the transaction.</li>
 * </ul>
 */
public class PaymentRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("settleWithAuth")
  private Boolean settleWithAuth;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("preAuth")
  private Boolean preAuth;
  @JsonProperty("description")
  private String description;
  @JsonProperty("level2level3")
  private Level2Level3 level2level3;
  @JsonProperty("accordD")
  private AccordD accordD;
  @JsonProperty("recipient")
  private Recipient recipient;
  @JsonProperty("splitpay")
  private Splitpay splitpay;
  @JsonProperty("storedCredentialDetails")
  private StoredCredential storedCredentialDetails;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("fundingTransaction")
  private FundingTransaction fundingTransaction;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  @JsonProperty("paymentFacilitator")
  private PaymentFacilitator paymentFacilitator;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("acquirerData")
  private AcquirerData acquirerData;
  @JsonProperty("keywords")
  private List<String> keywords;

  private Map<String, Object> additionalParameters;

  public PaymentRequest() {
    super();
  }

  private PaymentRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSettleWithAuth(builder.settleWithAuth);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerIp(builder.customerIp);
    setCurrencyCode(builder.currencyCode);
    setPreAuth(builder.preAuth);
    setDescription(builder.description);
    setLevel2level3(builder.level2level3);
    setAccordD(builder.accordD);
    setRecipient(builder.recipient);
    setSplitpay(builder.splitpay);
    setStoredCredentialDetails(builder.storedCredentialDetails);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setFundingTransaction(builder.fundingTransaction);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setPaymentFacilitator(builder.paymentFacilitator);
    setMerchantDescriptor(builder.merchantDescriptor);
    setAcquirerData(builder.acquirerData);
    setKeywords(builder.keywords);
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentRequest merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. <br>
   * It must be unique for each request if dupCheck parameter is sent as "true".
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public PaymentRequest amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value  should be 1099.
   * <b>Note:</b> The amount specified in the Payment request must match the amount specified in the Payment Handle request from which the
   * paymentHandleToken is taken.
   *
   * @return amount
   * maximum: 99999999999
   */
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public PaymentRequest dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate. A duplicate request is when the merchantRefNum has already been used in a previous request
   * within the past 90 days.
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public PaymentRequest settleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
    return this;
  }

  /**
   * This indicates whether the request is an  Authorization only (no Settlement), or a Purchase (Authorization and Settlement).
   * <ul>
   * <li>false – The request is not settled </li>
   * <li>true – The request is settled </li>
   * </ul>
   * <b>Note:</b> Defaults to false for cards and true for APMs.
   *
   * @return settleWithAuth
   */
  public Boolean getSettleWithAuth() {
    return settleWithAuth;
  }

  public void setSettleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
  }

  public PaymentRequest paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used for the Payment request. For Payment, Payment handle must be in PAYABLE state
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  public PaymentRequest customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * This is the customer's IP address.
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }

  public PaymentRequest currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account, e.g., USD or CAD, returned in the request response.
   * <b>Note:</b> The currencyCode specified in the Payment request must match the currencyCode specified in the Payment Handle request from
   * which the paymentHandleToken is taken.
   *
   * @return currencyCode
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes>Currency codes reference documentation</a>
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public PaymentRequest preAuth(Boolean preAuth) {
    this.preAuth = preAuth;
    return this;
  }

  /**
   * This indicates whether the Authorization request should be sent as a Pre-Authorization.
   * <b>Note:</b> You should use the preAuth element in cases where you are not sure that you can fully settle the Authorization within 4 days.
   * Contact your account manager for more information.
   *
   * @return preAuth
   */
  public Boolean getPreAuth() {
    return preAuth;
  }

  public void setPreAuth(Boolean preAuth) {
    this.preAuth = preAuth;
  }

  public PaymentRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * This is a description of the transaction, provided by the merchant.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PaymentRequest level2level3(Level2Level3 level2level3) {
    this.level2level3 = level2level3;
    return this;
  }

  /**
   * Level 2 and Level 3 (L2/L3) credit card processing refers to certain B2B card transactions for which the merchant might be eligible for
   * lower credit card interchange rates. The lower rates may be available for merchants who provide more detailed information when processing
   * card-not-present transactions. In order to be eligible for L2/L3 transactions:
   * <ul>
   * <li>Your merchant account must be properly configured by Paysafe. </li>
   * <li>The BIN of the credit card used for the transaction must be eligible – typically,these are government-issued credit cards. </li>
   *</ul>
   * <b>Note:</b> Not all processing gateways support this parameter. Contact your account manager for more information.
   *
   * @return level2level3
   */
  public Level2Level3 getLevel2level3() {
    return level2level3;
  }

  public void setLevel2level3(Level2Level3 level2level3) {
    this.level2level3 = level2level3;
  }

  public PaymentRequest accordD(AccordD accordD) {
    this.accordD = accordD;
    return this;
  }

  /**
   * These are parameters for financing plans supported for certain merchant configurations. Include this element only when instructed to do so by
   * your account manager.  <br>
   * <b>Note:</b> Not all processing gateways support this parameter. Contact your account manager for more information.
   *
   * @return accordD
   */
  public AccordD getAccordD() {
    return accordD;
  }

  public void setAccordD(AccordD accordD) {
    this.accordD = accordD;
  }

  public PaymentRequest recipient(Recipient recipient) {
    this.recipient = recipient;
    return this;
  }

  /**
   * <p>The recipient is deemed to be the person or party who has the contractual relationship with the merchant / financial institution.
   * This may be different from the cardholder, e.g., in the case of a parent topping up a child's savings account.
   * Therefore, the fields should not be collected on the same page as cardholder information, but instead be passed in the background from the
   * merchant's records.</p>
   *
   * <b>Note:</b> You can include recipient elements in your <a href="https://developer.paysafe.com/en/cards-api/#/operations/authorization">
   * Authorization request</a> only if your Merchant Category Code is <b>6012</b> and your registered trading address is in the United Kingdom.
   * <p>All fields are optional. However, scheme fines may apply if data is consistently not supplied and chargebacks persist.
   * If you have any questions, contact your account manager. </p>
   *
   * <p>If you are using a payment token for an Authorization request and there is already recipient data for the consumer profile associated with the
   * payment token, then if you include the recipient object in the Authorization, this data will override the recipient data already in the profile.</p>
   *
   * <p>If you <a href="https://developer.paysafe.com/en/cards-api/#/operations/get-authorization">look up an Authorization request</a>,
   * that used the visaAdditionalAuthData parameter (now deprecated), the response will contain the relevant data in both the recipient and the
   * visaAdditionalAuthData objects.
   *
   * @return recipient
   */
  public Recipient getRecipient() {
    return recipient;
  }

  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }

  public PaymentRequest splitpay(Splitpay splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  /**
   * This object should be used only for Splitpay transactions only, an array containing the linked accounts and the amount shared with each.
   * You must include either amount or percent. However, you cannot include both values.
   *
   * @return splitpay
   */
  public Splitpay getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(Splitpay splitpay) {
    this.splitpay = splitpay;
  }

  public PaymentRequest storedCredentialDetails(StoredCredential storedCredentialDetails) {
    this.storedCredentialDetails = storedCredentialDetails;
    return this;
  }

  /**
   * The storedCredential object is used to identify authorization requests that use stored credentials for a consumer,
   * in order to improve authorization rates and reduce fraud. Stored credentials can be used in two cases:
   * <ul>
   * <li> Using a payment token – An authorization request that uses a paymentToken from the Customer Vault API  </li>
   * <li> Using a card number – An authorization request that uses a credit card number stored by the merchant. </li>
   * </ul>
   * <b>Notes: </b>
   * <ul>
   * <li> If you use a paymentToken in the authorization request but do not include the storedCredential object, Paysafe will provide
   * default information taken from Customer Vault data. </li>
   * <li> You cannot include both the storedCredential object and the recurring parameter in the same authorization request.Paysafe recommends
   * using the storedCredential object. </li>
   * <li> The cvv parameter of the [card object] is required when the occurrence parameter is set to INITIAL. However, cvv is not required
   * when the occurrence parameter is set to SUBSEQUENT. </li>
   * <li> The storedCredential object cannot be used for Apple Pay or Google Pay transactions. </li>
   * </ul>
   * @return storedCredentialDetails
   */
  public StoredCredential getStoredCredentialDetails() {
    return storedCredentialDetails;
  }

  public void setStoredCredentialDetails(StoredCredential storedCredentialDetails) {
    this.storedCredentialDetails = storedCredentialDetails;
  }

  public PaymentRequest airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
    return this;
  }

  /**
   * Contains information about your airline travel.  <br>
   * <b>Notes:</b>  <br>
   * This object is only for Airline Merchants. <br>
   * This field has to be passed only in case of card transactiions.*
   *
   * @return airlineTravelDetails
   */
  public AirlineTravelDetails getAirlineTravelDetails() {
    return airlineTravelDetails;
  }

  public void setAirlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
  }

  public PaymentRequest fundingTransaction(FundingTransaction fundingTransaction) {
    this.fundingTransaction = fundingTransaction;
    return this;
  }

  /**
   * <b>Note:</b> Acquirers and processors do not necessarily support all available MCCs; before integrating, you should contact
   * <a href="https://developer.paysafe.com/en/support/">Integration Support</a> for details.
   * <br>
   * The fundingTransaction object is used to identify authorization requests that are categorized as funding transactions by the merchant
   * in order to provide additional information for the purpose of a transaction. It can be used by merchants registered with MCC 4722, 4829,
   * 6012, 6051, 6211, 6540, 7800, 7801, 7802, 7994, 7995 or 9406.
   * The relevant value will be assigned automatically by the Payments API as per the merchant registration with card schemes and his applicable MCC.
   * <br>
   * More information can be found on
   * <a href="https://developer.paysafe.com/en/payments-api/#/schemas/fundingTransaction">Funding Transaction reference</a> page.
   *
   * @return fundingTransaction
   */
  public FundingTransaction getFundingTransaction() {
    return fundingTransaction;
  }

  public void setFundingTransaction(FundingTransaction fundingTransaction) {
    this.fundingTransaction = fundingTransaction;
  }

  public PaymentRequest cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
    return this;
  }

  /**
   * Contains information about your cruise line travel.  <br> <b>Note:</b> This object is only for Cruise line Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return cruiselineTravelDetails
   */
  public CruiselineTravelDetails getCruiselineTravelDetails() {
    return cruiselineTravelDetails;
  }

  public void setCruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
  }

  public PaymentRequest lodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
    return this;
  }

  /**
   * Contains information about lodging details.   <br> <b>Note:</b> This object is only for Airline Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return lodgingDetails
   */
  public LodgingDetails getLodgingDetails() {
    return lodgingDetails;
  }

  public void setLodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
  }

  public PaymentRequest carRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
    return this;
  }

  /**
   * Contains information about your car rental.  <br> <b>Note:</b> This object is only for Car rental Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return carRentalDetails
   */
  public CarRentalDetails getCarRentalDetails() {
    return carRentalDetails;
  }

  public void setCarRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
  }

  public PaymentRequest paymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
    return this;
  }

  /**
   * Contains information about Payment facilitator.  <b>Note:</b> This object is only for Payment facilitator merchants.
   *
   * @return paymentFacilitator
   */
  public PaymentFacilitator getPaymentFacilitator() {
    return paymentFacilitator;
  }

  public void setPaymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
  }

  public PaymentRequest merchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
    return this;
  }

  /**
   * For Card payment method only. This is the merchant descriptor that will be displayed on the customer's card or bank statement.
   *
   * @return merchantDescriptor
   */
  public MerchantDescriptor getMerchantDescriptor() {
    return merchantDescriptor;
  }

  public void setMerchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
  }

  public PaymentRequest acquirerData(AcquirerData acquirerData) {
    this.acquirerData = acquirerData;
    return this;
  }

  /**
   * Acquirer data is additional information about your card acquirer, applicable only when you are using Worldpay (VAN) as your acquirer for authorizations.
   * Contact your account manager for more information.
   *
   * @return acquirerData
   */
  public AcquirerData getAcquirerData() {
    return acquirerData;
  }

  public void setAcquirerData(AcquirerData acquirerData) {
    this.acquirerData = acquirerData;
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
    PaymentRequest paymentRequest = (PaymentRequest) o;
    return Objects.equals(this.merchantRefNum, paymentRequest.merchantRefNum) &&
        Objects.equals(this.amount, paymentRequest.amount) &&
        Objects.equals(this.dupCheck, paymentRequest.dupCheck) &&
        Objects.equals(this.settleWithAuth, paymentRequest.settleWithAuth) &&
        Objects.equals(this.paymentHandleToken, paymentRequest.paymentHandleToken) &&
        Objects.equals(this.customerIp, paymentRequest.customerIp) &&
        Objects.equals(this.currencyCode, paymentRequest.currencyCode) &&
        Objects.equals(this.preAuth, paymentRequest.preAuth) &&
        Objects.equals(this.description, paymentRequest.description) &&
        Objects.equals(this.level2level3, paymentRequest.level2level3) &&
        Objects.equals(this.accordD, paymentRequest.accordD) &&
        Objects.equals(this.recipient, paymentRequest.recipient) &&
        Objects.equals(this.splitpay, paymentRequest.splitpay) &&
        Objects.equals(this.storedCredentialDetails, paymentRequest.storedCredentialDetails) &&
        Objects.equals(this.airlineTravelDetails, paymentRequest.airlineTravelDetails) &&
        Objects.equals(this.fundingTransaction, paymentRequest.fundingTransaction) &&
        Objects.equals(this.cruiselineTravelDetails, paymentRequest.cruiselineTravelDetails) &&
        Objects.equals(this.lodgingDetails, paymentRequest.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, paymentRequest.carRentalDetails) &&
        Objects.equals(this.paymentFacilitator, paymentRequest.paymentFacilitator) &&
        Objects.equals(this.merchantDescriptor, paymentRequest.merchantDescriptor) &&
        Objects.equals(this.acquirerData, paymentRequest.acquirerData) &&
        Objects.equals(this.keywords, paymentRequest.keywords) &&
        Objects.equals(this.additionalParameters, paymentRequest.additionalParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, settleWithAuth, paymentHandleToken, customerIp, currencyCode, preAuth, description, level2level3,
        accordD, recipient, splitpay, storedCredentialDetails, airlineTravelDetails, fundingTransaction, cruiselineTravelDetails, lodgingDetails,
        carRentalDetails, paymentFacilitator, merchantDescriptor, acquirerData, keywords, additionalParameters);
  }

  @Override
  public String toString() {

    return "class PaymentRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    settleWithAuth: " + toIndentedString(settleWithAuth) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    preAuth: " + toIndentedString(preAuth) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    level2level3: " + toIndentedString(level2level3) + "\n"
        + "    accordD: " + toIndentedString(accordD) + "\n"
        + "    recipient: " + toIndentedString(recipient) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    storedCredentialDetails: " + toIndentedString(storedCredentialDetails) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    fundingTransaction: " + toIndentedString(fundingTransaction) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
        + "    paymentFacilitator: " + toIndentedString(paymentFacilitator) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    acquirerData: " + toIndentedString(acquirerData) + "\n"
        + "    keywords: " + toIndentedString(keywords) + "\n"
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

  public List<String> getKeywords() {
    return keywords;
  }

  public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
  }

  /**
   * {@code PaymentRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Long amount;
    private Boolean dupCheck;
    private Boolean settleWithAuth;
    private String paymentHandleToken;
    private String customerIp;
    private CurrencyCode currencyCode;
    private Boolean preAuth;
    private String description;
    private Level2Level3 level2level3;
    private AccordD accordD;
    private Recipient recipient;
    private Splitpay splitpay;
    private StoredCredential storedCredentialDetails;
    private AirlineTravelDetails airlineTravelDetails;
    private FundingTransaction fundingTransaction;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private PaymentFacilitator paymentFacilitator;
    private MerchantDescriptor merchantDescriptor;
    private AcquirerData acquirerData;
    private List<String> keywords;
    private Map<String, Object> additionalParameters;

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
     * Sets the {@code amount} and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the {@code amount} to set
     * @return a reference to this Builder
     */
    public Builder amount(Long amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Sets the {@code dupCheck} and returns a reference to this Builder enabling method chaining.
     *
     * @param dupCheck the {@code dupCheck} to set
     * @return a reference to this Builder
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * Sets the {@code settleWithAuth} and returns a reference to this Builder enabling method chaining.
     *
     * @param settleWithAuth the {@code settleWithAuth} to set
     * @return a reference to this Builder
     */
    public Builder settleWithAuth(Boolean settleWithAuth) {
      this.settleWithAuth = settleWithAuth;
      return this;
    }

    /**
     * Sets the {@code paymentHandleToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleToken the {@code paymentHandleToken} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleToken(String paymentHandleToken) {
      this.paymentHandleToken = paymentHandleToken;
      return this;
    }

    /**
     * Sets the {@code customerIp} and returns a reference to this Builder enabling method chaining.
     *
     * @param customerIp the {@code customerIp} to set
     * @return a reference to this Builder
     */
    public Builder customerIp(String customerIp) {
      this.customerIp = customerIp;
      return this;
    }

    /**
     * Sets the {@code currencyCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param currencyCode the {@code currencyCode} to set
     * @return a reference to this Builder
     */
    public Builder currencyCode(CurrencyCode currencyCode) {
      this.currencyCode = currencyCode;
      return this;
    }

    /**
     * Sets the {@code preAuth} and returns a reference to this Builder enabling method chaining.
     *
     * @param preAuth the {@code preAuth} to set
     * @return a reference to this Builder
     */
    public Builder preAuth(Boolean preAuth) {
      this.preAuth = preAuth;
      return this;
    }

    /**
     * Sets the {@code description} and returns a reference to this Builder enabling method chaining.
     *
     * @param description the {@code description} to set
     * @return a reference to this Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Sets the {@code level2level3} and returns a reference to this Builder enabling method chaining.
     *
     * @param level2level3 the {@code level2level3} to set
     * @return a reference to this Builder
     */
    public Builder level2level3(Level2Level3 level2level3) {
      this.level2level3 = level2level3;
      return this;
    }

    /**
     * Sets the {@code accordD} and returns a reference to this Builder enabling method chaining.
     *
     * @param accordD the {@code accordD} to set
     * @return a reference to this Builder
     */
    public Builder accordD(AccordD accordD) {
      this.accordD = accordD;
      return this;
    }

    /**
     * Sets the {@code recipient} and returns a reference to this Builder enabling method chaining.
     *
     * @param recipient the {@code recipient} to set
     * @return a reference to this Builder
     */
    public Builder recipient(Recipient recipient) {
      this.recipient = recipient;
      return this;
    }

    /**
     * Sets the {@code splitpay} and returns a reference to this Builder enabling method chaining.
     *
     * @param splitpay the {@code splitpay} to set
     * @return a reference to this Builder
     */
    public Builder splitpay(Splitpay splitpay) {
      this.splitpay = splitpay;
      return this;
    }

    /**
     * Sets the {@code storedCredentialDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param storedCredentialDetails the {@code storedCredentialDetails} to set
     * @return a reference to this Builder
     */
    public Builder storedCredentialDetails(StoredCredential storedCredentialDetails) {
      this.storedCredentialDetails = storedCredentialDetails;
      return this;
    }

    /**
     * Sets the {@code airlineTravelDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param airlineTravelDetails the {@code airlineTravelDetails} to set
     * @return a reference to this Builder
     */
    public Builder airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
      this.airlineTravelDetails = airlineTravelDetails;
      return this;
    }

    /**
     * Sets the {@code fundingTransaction} and returns a reference to this Builder enabling method chaining.
     *
     * @param fundingTransaction the {@code fundingTransaction} to set
     * @return a reference to this Builder
     */
    public Builder fundingTransaction(FundingTransaction fundingTransaction) {
      this.fundingTransaction = fundingTransaction;
      return this;
    }

    /**
     * Sets the {@code cruiselineTravelDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param cruiselineTravelDetails the {@code cruiselineTravelDetails} to set
     * @return a reference to this Builder
     */
    public Builder cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
      this.cruiselineTravelDetails = cruiselineTravelDetails;
      return this;
    }

    /**
     * Sets the {@code lodgingDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param lodgingDetails the {@code lodgingDetails} to set
     * @return a reference to this Builder
     */
    public Builder lodgingDetails(LodgingDetails lodgingDetails) {
      this.lodgingDetails = lodgingDetails;
      return this;
    }

    /**
     * Sets the {@code carRentalDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param carRentalDetails the {@code carRentalDetails} to set
     * @return a reference to this Builder
     */
    public Builder carRentalDetails(CarRentalDetails carRentalDetails) {
      this.carRentalDetails = carRentalDetails;
      return this;
    }

    /**
     * Sets the {@code paymentFacilitator} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentFacilitator the {@code paymentFacilitator} to set
     * @return a reference to this Builder
     */
    public Builder paymentFacilitator(PaymentFacilitator paymentFacilitator) {
      this.paymentFacilitator = paymentFacilitator;
      return this;
    }

    /**
     * Sets the {@code merchantDescriptor} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantDescriptor the {@code merchantDescriptor} to set
     * @return a reference to this Builder
     */
    public Builder merchantDescriptor(MerchantDescriptor merchantDescriptor) {
      this.merchantDescriptor = merchantDescriptor;
      return this;
    }

    /**
     * Sets the {@code acquirerData} and returns a reference to this Builder enabling method chaining.
     *
     * @param acquirerData the {@code acquirerData} to set
     * @return a reference to this Builder
     */
    public Builder acquirerData(AcquirerData acquirerData) {
      this.acquirerData = acquirerData;
      return this;
    }

    /**
     * Sets the {@code keywords} and returns a reference to this Builder enabling method chaining.
     *
     * @param keywords the {@code keywords} to set
     * @return a reference to this Builder
     */
    public Builder keywords(List<String> keywords) {
      this.keywords = keywords;
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
     * Returns a {@code PaymentRequest} built from the parameters previously set.
     *
     * @return a {@code PaymentRequest} built with parameters of this {@code PaymentRequest.Builder}
     */
    public PaymentRequest build() {
      return new PaymentRequest(this);
    }
  }
}

