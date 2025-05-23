// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.applepay.ApplePay;
import com.paysafe.payments.model.card.CardWithOptionalNetworkTokenOrApplePay;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.threeds.BrowserDetails;
import com.paysafe.payments.model.card.threeds.NetworkTokenCardObjectAuthentication;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.DeviceDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Link;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.PaymentDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.ShippingDetails;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.googlepay.GooglePay;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Mazooma;
import com.paysafe.payments.model.lpm.Neteller;
import com.paysafe.payments.model.lpm.PayByBank;
import com.paysafe.payments.model.lpm.Paypal;
import com.paysafe.payments.model.lpm.Paysafecard;
import com.paysafe.payments.model.lpm.Paysafecash;
import com.paysafe.payments.model.lpm.RapidTransfer;
import com.paysafe.payments.model.lpm.SafetyPayCash;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.lpm.Sightline;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.lpm.Skrill1Tap;
import com.paysafe.payments.model.lpm.Venmo;
import com.paysafe.payments.model.lpm.Vippreferred;
import com.paysafe.payments.model.paymenthandle.enums.Action;
import com.paysafe.payments.model.paymenthandle.enums.ExecutionMode;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleUsage;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;
import com.paysafe.payments.model.standalonecredit.Interac;

/**
 * A Payment Handle represents tokenized information about the payment method that you set up for a customer.
 * Once the Payment Handle is created, you then include the paymentHandleToken in a new Payment / Standalone Credit /
 * Original Credit / Verification request.
 */
public class PaymentHandle extends BaseApiResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private String status;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("usage")
  private PaymentHandleUsage usage;
  @JsonProperty("action")
  private Action action;
  @JsonProperty("executionMode")
  private ExecutionMode executionMode;
  @JsonProperty("timeToLiveSeconds")
  private Long timeToLiveSeconds;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("links")
  private List<Link> links;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("transactionType")
  private TransactionType transactionType;
  @JsonProperty("accountId")
  private String accountId;
  @JsonProperty("paymentType")
  private String paymentType;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("shippingDetails")
  private ShippingDetails shippingDetails;
  @JsonProperty("card")
  private CardWithOptionalNetworkTokenOrApplePay card;
  @JsonProperty("skip3ds")
  private Boolean skip3ds;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private NetworkTokenCardObjectAuthentication authentication;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("transactionIntent")
  private String transactionIntent;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("applePay")
  private ApplePay applePay;
  @JsonProperty("googlePay")
  private GooglePay googlePay;
  @JsonProperty("skrill")
  private Skrill skrill;
  @JsonProperty("neteller")
  private Neteller neteller;
  @JsonProperty("paysafecash")
  private Paysafecash paysafecash;
  @JsonProperty("paysafecard")
  private Paysafecard paysafecard;
  @JsonProperty("payPal")
  private Paypal payPal;
  @JsonProperty("venmo")
  private Venmo venmo;
  @JsonProperty("vippreferred")
  private Vippreferred vippreferred;
  @JsonProperty("mazooma")
  private Mazooma mazooma;
  @JsonProperty("sightline")
  private Sightline sightline;
  @JsonProperty("payByBank")
  private PayByBank payByBank;
  @JsonProperty("interacETransfer")
  private Interac interacETransfer;
  @JsonProperty("browserDetails")
  private BrowserDetails browserDetails = null;
  @JsonProperty("deviceDetails")
  private DeviceDetails deviceDetails;
  @JsonProperty("rapidTransfer")
  private RapidTransfer rapidTransfer;
  @JsonProperty("skrill1Tap")
  private Skrill1Tap skrill1Tap;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates = null;
  @JsonProperty("sepa")
  private Sepa sepa;
  @JsonProperty("safetyPayCash")
  private SafetyPayCash safetyPayCash;
  @JsonProperty("paymentExpiryInMinutes")
  private Long paymentExpiryInMinutes;
  @JsonProperty("paymentDetails")
  private PaymentDetails paymentDetails;
  @JsonProperty("paymentExpiryMinutes")
  private Long paymentExpiryMinutes;

  public PaymentHandle() {
    super();
  }

  private PaymentHandle(final Builder builder) {
    setError(builder.error);
    setId(builder.id);
    setPaymentHandleToken(builder.paymentHandleToken);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setLiveMode(builder.liveMode);
    setUsage(builder.usage);
    setAction(builder.action);
    setExecutionMode(builder.executionMode);
    setTimeToLiveSeconds(builder.timeToLiveSeconds);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setLinks(builder.links);
    setMerchantRefNum(builder.merchantRefNum);
    setTransactionType(builder.transactionType);
    setAccountId(builder.accountId);
    setPaymentType(builder.paymentType);
    setAmount(builder.amount);
    setCurrencyCode(builder.currencyCode);
    setProfile(builder.profile);
    setBillingDetails(builder.billingDetails);
    setMerchantDescriptor(builder.merchantDescriptor);
    setReturnLinks(builder.returnLinks);
    setCustomerIp(builder.customerIp);
    setShippingDetails(builder.shippingDetails);
    setCard(builder.card);
    setSkip3ds(builder.skip3ds);
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setTransactionIntent(builder.transactionIntent);
    setGatewayResponse(builder.gatewayResponse);
    setApplePay(builder.applePay);
    setGooglePay(builder.googlePay);
    setSkrill(builder.skrill);
    setNeteller(builder.neteller);
    setPaysafecash(builder.paysafecash);
    setPaysafecard(builder.paysafecard);
    setPayPal(builder.payPal);
    setVenmo(builder.venmo);
    setVippreferred(builder.vippreferred);
    setMazooma(builder.mazooma);
    setSightline(builder.sightline);
    setPayByBank(builder.payByBank);
    setInteracETransfer(builder.interacETransfer);
    setBrowserDetails(builder.browserDetails);
    setDeviceDetails(builder.deviceDetails);
    setRapidTransfer(builder.rapidTransfer);
    setSkrill1Tap(builder.skrill1Tap);
    setAch(builder.ach);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
    setSafetyPayCash(builder.safetyPayCash);
    setPaymentExpiryInMinutes(builder.paymentExpiryInMinutes);
    setPaymentDetails(builder.paymentDetails);
    setPaymentExpiryMinutes(builder.paymentExpiryMinutes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentHandle id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests, for example, to look up the Payment Handle.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PaymentHandle paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used by merchants for Payment API requests.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  public PaymentHandle txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * This is the date and time the transaction was processed.
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }

  public PaymentHandle status(String status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the payment handle. Possible values are: <ul>
   * <li>INITIATED – The transaction was initiated with the downstream provider.</li>
   * <li>PAYABLE – The merchant can use the Payment Handle for a Payment request.</li>
   * <li>PROCESSING – The Payment Handle was authorized by customer, awaiting PSP response.</li>
   * <li>FAILED – The transaction failed due to either an error or being declined.</li>
   * <li>EXPIRED – The Payment Handle expired because the merchant did not proceed with the Payment request.</li>
   * <li>COMPLETED – The Payment request was initiated successfully using the Payment Handle.</li>
   * </ul>
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PaymentHandle liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * This flag indicates the environment.  - true - Production - false - Non-Production
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }

  public PaymentHandle usage(PaymentHandleUsage usage) {
    this.usage = usage;
    return this;
  }

  /**
   * This specifies how the Payment Handle will be used for Payments. Possible values are:
   * <ul>
   * <li>SINGLE_USE – The Payment Handle can be used for one transaction only and expires if not used. </li>
   * <li>MULTI_USE – The Payment Handle can be used multiple times. </li>
   * </ul>
   * @return usage
   */
  public PaymentHandleUsage getUsage() {
    return usage;
  }

  public void setUsage(PaymentHandleUsage usage) {
    this.usage = usage;
  }

  public PaymentHandle action(Action action) {
    this.action = action;
    return this;
  }

  /**
   * This specifies the next step of the user journey once they proceed to the Payment.
   *
   * @return action
   */
  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public PaymentHandle executionMode(ExecutionMode executionMode) {
    this.executionMode = executionMode;
    return this;
  }

  /**
   * This specifies the action of the merchant server in order to complete the Payment.
   *
   * @return executionMode
   */
  public ExecutionMode getExecutionMode() {
    return executionMode;
  }

  public void setExecutionMode(ExecutionMode executionMode) {
    this.executionMode = executionMode;
  }

  public PaymentHandle timeToLiveSeconds(Long timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
    return this;
  }

  /**
   * This is the period of time, in seconds, the  paymentHandleToken is valid before expiration.
   *
   * @return timeToLiveSeconds
   */
  public Long getTimeToLiveSeconds() {
    return timeToLiveSeconds;
  }

  public void setTimeToLiveSeconds(Long timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
  }

  public PaymentHandle gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * Not applicable for CARD. Transaction identifier that can be used to reconcile this transaction with the provider gateway.
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }

  public PaymentHandle updatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * Indicates the last updated time for the resource.
   *
   * @return updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }

  public PaymentHandle statusTime(String statusTime) {
    this.statusTime = statusTime;
    return this;
  }

  /**
   * Indicates the last updated time for the resource.
   *
   * @return statusTime
   */
  public String getStatusTime() {
    return statusTime;
  }

  public void setStatusTime(String statusTime) {
    this.statusTime = statusTime;
  }

  public PaymentHandle links(List<Link> links) {
    this.links = links;
    return this;
  }

  /**
   * URL links to redirect customer during transaction flow
   *
   * @return links
   */
  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  public PaymentHandle merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request. <br>
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public PaymentHandle transactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * This specifies the transaction type for which the Payment Handle is created.
   *
   * @return transactionType
   */
  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public PaymentHandle accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * This is the accountId which is sent in the Payment handle request. <br>**Same as request**.
   *
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public PaymentHandle paymentType(String paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type associated with the Payment Handle used for this request. <br>**Same as request**.
   *
   * @return paymentType
   */
  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public PaymentHandle amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units.
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

  public PaymentHandle currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account, e.g., USD or CAD.
   * See (<a href="https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes">Currency Codes</a>) <br>
   *  <br> Same as in request.
   *
   * @return currencyCode
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public PaymentHandle profile(Profile profile) {
    this.profile = profile;
    return this;
  }

  /**
   * This is customer's profile details.  <br>**Same as request**.
   *
   * @return profile
   */
  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public PaymentHandle billingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Customer's billing details. Required if AVS (Address verification) is enabled. <br>
   * If included in the request, this will serve as the billing address for transaction processing.  <br>
   * Any billing details returned in Apple Pay Token by Apple Pay will be ignored.  <br>
   * 3DS Flow: It is recommended to send billingDetails to improve acceptance rate.     *
   *
   * @return billingDetails
   */
  public BillingDetails getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
  }

  public PaymentHandle merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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

  public PaymentHandle returnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
    return this;
  }

  /**
   * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site.
   * You can customize the return URL based on the transaction status.
   *
   * @return returnLinks
   */
  public List<ReturnLink> getReturnLinks() {
    return returnLinks;
  }

  public void setReturnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
  }

  public PaymentHandle customerIp(String customerIp) {
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

  public PaymentHandle shippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
    return this;
  }

  /**
   * Get shippingDetails
   *
   * @return shippingDetails
   */
  public ShippingDetails getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
  }

  public PaymentHandle card(CardWithOptionalNetworkTokenOrApplePay card) {
    this.card = card;
    return this;
  }

  /**
   * These are card details
   *
   * @return card
   */
  public CardWithOptionalNetworkTokenOrApplePay getCard() {
    return card;
  }

  public void setCard(CardWithOptionalNetworkTokenOrApplePay card) {
    this.card = card;
  }

  public PaymentHandle threeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
    return this;
  }

  /**
   * This is the threeDs object. You need to send this object when you want to process CARD transaction with 3DS.
   * Required if account is enabled for 3DS.  <br>
   * Not required if account is non-3DS or if you are using your own 3DS service provider. Please refer authentication
   * object if you are using your own 3DS service provider.
   *
   * @return threeDs
   */
  public ThreeDs getThreeDs() {
    return threeDs;
  }

  public void setThreeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
  }

  public Boolean getSkip3ds() {
    return skip3ds;
  }

  public void setSkip3ds(Boolean skip3ds) {
    this.skip3ds = skip3ds;
  }

  public PaymentHandle authentication(NetworkTokenCardObjectAuthentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * 3D Secure authentication details.
   *
   * @return authentication
   */
  public NetworkTokenCardObjectAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(NetworkTokenCardObjectAuthentication authentication) {
    this.authentication = authentication;
  }

  public PaymentHandle paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * The response returns the original value from the request. This is used in Saved card flow. You will pass this parameter when you want to create
   * single use payment handle using the Saved-card (card-on-file) present in Paysafe customer vault.  <br>
   * This is an existing Customer Payment Handle from which the payment instrument details and profile details are retrieved.  <br>
   * If this parameter is included then you can omit the billingDetails object.  <br>
   * If you send a new billingDetails then same will be considered for the transaction, however no change will be made in the billingDetails present against
   * the Saved-card in customer vault.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public PaymentHandle transactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * The transactionIntent property is used to identify the intent of the authorization requests. See
   * <a href="https://developer.paysafe.com/en/payments-api/#/schemas/transactionIntent">Transaction Intent documentation</a> for more information.
   *
   * @return transactionIntent
   */
  public String getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
  }

  public PaymentHandle gatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

  /**
   * This contains parameters returned by Skrill gateway
   *
   * @return gatewayResponse
   */
  public GatewayResponse getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }

  public PaymentHandle applePay(ApplePay applePay) {
    this.applePay = applePay;
    return this;
  }

  /**
   * Get applePay
   *
   * @return applePay
   */
  public ApplePay getApplePay() {
    return applePay;
  }

  public void setApplePay(ApplePay applePay) {
    this.applePay = applePay;
  }

  public PaymentHandle googlePay(GooglePay googlePay) {
    this.googlePay = googlePay;
    return this;
  }

  /**
   * It has GooglePay details.
   *
   * @return googlePay
   */
  public GooglePay getGooglePay() {
    return googlePay;
  }

  public void setGooglePay(GooglePay googlePay) {
    this.googlePay = googlePay;
  }

  public PaymentHandle skrill(Skrill skrill) {
    this.skrill = skrill;
    return this;
  }

  /**
   * These are the details of the customer used for the transaction.
   *
   * @return skrill
   */
  public Skrill getSkrill() {
    return skrill;
  }

  public void setSkrill(Skrill skrill) {
    this.skrill = skrill;
  }

  public PaymentHandle neteller(Neteller neteller) {
    this.neteller = neteller;
    return this;
  }

  /**
   * Neteller details to be used for the request
   *
   * @return neteller
   */
  public Neteller getNeteller() {
    return neteller;
  }

  public void setNeteller(Neteller neteller) {
    this.neteller = neteller;
  }

  public PaymentHandle paysafecash(Paysafecash paysafecash) {
    this.paysafecash = paysafecash;
    return this;
  }

  /**
   * These are the details of the paysafecash account used for the transaction.
   *
   * @return paysafecash
   */
  public Paysafecash getPaysafecash() {
    return paysafecash;
  }

  public void setPaysafecash(Paysafecash paysafecash) {
    this.paysafecash = paysafecash;
  }

  public PaymentHandle paysafecard(Paysafecard paysafecard) {
    this.paysafecard = paysafecard;
    return this;
  }

  /**
   * These are the details of the paysafecard used for the transaction.
   *
   * @return paysafecard
   */
  public Paysafecard getPaysafecard() {
    return paysafecard;
  }

  public void setPaysafecard(Paysafecard paysafecard) {
    this.paysafecard = paysafecard;
  }

  public PaymentHandle payPal(Paypal payPal) {
    this.payPal = payPal;
    return this;
  }

  /**
   * These are the details of the PayPal account used for the transaction.
   *
   * @return payPal
   */
  public Paypal getPayPal() {
    return payPal;
  }

  public void setPayPal(Paypal payPal) {
    this.payPal = payPal;
  }

  public PaymentHandle venmo(Venmo venmo) {
    this.venmo = venmo;
    return this;
  }

  /**
   * Get venmo
   *
   * @return venmo
   */
  public Venmo getVenmo() {
    return venmo;
  }

  public void setVenmo(Venmo venmo) {
    this.venmo = venmo;
  }

  public PaymentHandle vippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
    return this;
  }

  /**
   * These are the details of the vip preferred account used for the transaction.
   *
   * @return vippreferred
   */
  public Vippreferred getVippreferred() {
    return vippreferred;
  }

  public void setVippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
  }

  public PaymentHandle mazooma(Mazooma mazooma) {
    this.mazooma = mazooma;
    return this;
  }

  /**
   * Mazooma details to be used for the transaction
   *
   * @return mazooma
   */
  public Mazooma getMazooma() {
    return mazooma;
  }

  public void setMazooma(Mazooma mazooma) {
    this.mazooma = mazooma;
  }

  public PaymentHandle sightline(Sightline sightline) {
    this.sightline = sightline;
    return this;
  }

  /**
   * These are the details of the Play+ (Sightline) used for the transaction.
   *
   * @return sightline
   */
  public Sightline getSightline() {
    return sightline;
  }

  public void setSightline(Sightline sightline) {
    this.sightline = sightline;
  }

  public PaymentHandle payByBank(PayByBank payByBank) {
    this.payByBank = payByBank;
    return this;
  }

  /**
   * This object should be used only for pay by bank transactions.
   *
   * @return payByBank
   */
  public PayByBank getPayByBank() {
    return payByBank;
  }

  public void setPayByBank(PayByBank payByBank) {
    this.payByBank = payByBank;
  }

  public PaymentHandle interacETransfer(Interac interacETransfer) {
    this.interacETransfer = interacETransfer;
    return this;
  }

  /**
   * Details of the interac E-Transfer used for the transaction.
   *
   * @return interacETransfer
   */
  public Interac getInteracETransfer() {
    return interacETransfer;
  }

  public void setInteracETransfer(Interac interacETransfer) {
    this.interacETransfer = interacETransfer;
  }

  public PaymentHandle browserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
    return this;
  }

  /**
   * Get browserDetails
   *
   * @return browserDetails
   */
  public BrowserDetails getBrowserDetails() {
    return browserDetails;
  }

  public void setBrowserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
  }

  public PaymentHandle deviceDetails(DeviceDetails deviceDetails) {
    this.deviceDetails = deviceDetails;
    return this;
  }

  /**
   * For Interac e-Transfer withdrawal only. <br>  This is part of Interac e-Transfer withdrawal payment handle request.
   * It is used for risk assessment by Interac.  <br>
   * This parameter is mandatory if browserDetails object is not passed as a part of Interac e-Transfer withdrawal payment handle request.
   *
   * @return deviceDetails
   */
  public DeviceDetails getDeviceDetails() {
    return deviceDetails;
  }

  public void setDeviceDetails(DeviceDetails deviceDetails) {
    this.deviceDetails = deviceDetails;
  }

  public PaymentHandle rapidTransfer(RapidTransfer rapidTransfer) {
    this.rapidTransfer = rapidTransfer;
    return this;
  }

  /**
   * These are the details of the rapid transfer used for the transaction.
   *
   * @return rapidTransfer
   */
  public RapidTransfer getRapidTransfer() {
    return rapidTransfer;
  }

  public void setRapidTransfer(RapidTransfer rapidTransfer) {
    this.rapidTransfer = rapidTransfer;
  }

  public PaymentHandle skrill1Tap(Skrill1Tap skrill1Tap) {
    this.skrill1Tap = skrill1Tap;
    return this;
  }

  /**
   * These are the details of the skrill 1-Tap account used for the transaction.
   *
   * @return skrill1Tap
   */
  public Skrill1Tap getSkrill1Tap() {
    return skrill1Tap;
  }

  public void setSkrill1Tap(Skrill1Tap skrill1Tap) {
    this.skrill1Tap = skrill1Tap;
  }

  public PaymentHandle ach(Ach ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Details of the ach account to be used for the transaction.
   *
   * @return ach
   */
  public Ach getAch() {
    return ach;
  }

  public void setAch(Ach ach) {
    this.ach = ach;
  }

  public PaymentHandle eft(Eft eft) {
    this.eft = eft;
    return this;
  }

  /**
   * Details of the EFT account to be used for the transaction
   *
   * @return eft
   */
  public Eft getEft() {
    return eft;
  }

  public void setEft(Eft eft) {
    this.eft = eft;
  }

  public PaymentHandle dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Get dupCheck
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public PaymentHandle bacs(Bacs bacs) {
    this.bacs = bacs;
    return this;
  }

  /**
   * Details of the bacs account to be used for the transaction.
   *
   * @return bacs
   */
  public Bacs getBacs() {
    return bacs;
  }

  public void setBacs(Bacs bacs) {
    this.bacs = bacs;
  }

  public PaymentHandle mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public PaymentHandle addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public PaymentHandle removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * Get mandates
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }

  public PaymentHandle sepa(Sepa sepa) {
    this.sepa = sepa;
    return this;
  }

  /**
   * These are the details of the sepa account used for the transaction.
   *
   * @return sepa
   */
  public Sepa getSepa() {
    return sepa;
  }

  public void setSepa(Sepa sepa) {
    this.sepa = sepa;
  }

  public PaymentHandle safetyPayCash(SafetyPayCash safetyPayCash) {
    this.safetyPayCash = safetyPayCash;
    return this;
  }

  /**
   * @return safetyPayCash
   */
  public SafetyPayCash getSafetyPayCash() {
    return safetyPayCash;
  }

  public void setSafetyPayCash(SafetyPayCash safetyPayCash) {
    this.safetyPayCash = safetyPayCash;
  }

  public PaymentHandle paymentExpiryInMinutes(Long paymentExpiryInMinutes) {
    this.paymentExpiryInMinutes = paymentExpiryInMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at Safetypay.
   *
   * @return paymentExpiryInMinutes
   */
  public Long getPaymentExpiryInMinutes() {
    return paymentExpiryInMinutes;
  }

  public void setPaymentExpiryInMinutes(Long paymentExpiryInMinutes) {
    this.paymentExpiryInMinutes = paymentExpiryInMinutes;
  }

  public PaymentHandle paymentDetails(PaymentDetails paymentDetails) {
    this.paymentDetails = paymentDetails;
    return this;
  }

  /**
   * Get paymentDetails
   *
   * @return paymentDetails
   */
  public PaymentDetails getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(PaymentDetails paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public PaymentHandle paymentExpiryMinutes(Long paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at Safetypay.
   *
   * @return paymentExpiryMinutes
   */
  public Long getPaymentExpiryMinutes() {
    return paymentExpiryMinutes;
  }

  public void setPaymentExpiryMinutes(Long paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentHandle paymentHandle = (PaymentHandle) o;
    return Objects.equals(this.getError(), paymentHandle.getError()) &&
        Objects.equals(this.id, paymentHandle.id) &&
        Objects.equals(this.paymentHandleToken, paymentHandle.paymentHandleToken) &&
        Objects.equals(this.txnTime, paymentHandle.txnTime) &&
        Objects.equals(this.status, paymentHandle.status) &&
        Objects.equals(this.liveMode, paymentHandle.liveMode) &&
        Objects.equals(this.usage, paymentHandle.usage) &&
        Objects.equals(this.action, paymentHandle.action) &&
        Objects.equals(this.executionMode, paymentHandle.executionMode) &&
        Objects.equals(this.timeToLiveSeconds, paymentHandle.timeToLiveSeconds) &&
        Objects.equals(this.gatewayReconciliationId, paymentHandle.gatewayReconciliationId) &&
        Objects.equals(this.updatedTime, paymentHandle.updatedTime) &&
        Objects.equals(this.statusTime, paymentHandle.statusTime) &&
        Objects.equals(this.links, paymentHandle.links) &&
        Objects.equals(this.merchantRefNum, paymentHandle.merchantRefNum) &&
        Objects.equals(this.transactionType, paymentHandle.transactionType) &&
        Objects.equals(this.accountId, paymentHandle.accountId) &&
        Objects.equals(this.paymentType, paymentHandle.paymentType) &&
        Objects.equals(this.amount, paymentHandle.amount) &&
        Objects.equals(this.currencyCode, paymentHandle.currencyCode) &&
        Objects.equals(this.profile, paymentHandle.profile) &&
        Objects.equals(this.billingDetails, paymentHandle.billingDetails) &&
        Objects.equals(this.merchantDescriptor, paymentHandle.merchantDescriptor) &&
        Objects.equals(this.returnLinks, paymentHandle.returnLinks) &&
        Objects.equals(this.customerIp, paymentHandle.customerIp) &&
        Objects.equals(this.shippingDetails, paymentHandle.shippingDetails) &&
        Objects.equals(this.card, paymentHandle.card) &&
        Objects.equals(this.threeDs, paymentHandle.threeDs) &&
        Objects.equals(this.authentication, paymentHandle.authentication) &&
        Objects.equals(this.paymentHandleTokenFrom, paymentHandle.paymentHandleTokenFrom) &&
        Objects.equals(this.transactionIntent, paymentHandle.transactionIntent) &&
        Objects.equals(this.gatewayResponse, paymentHandle.gatewayResponse) &&
        Objects.equals(this.applePay, paymentHandle.applePay) &&
        Objects.equals(this.googlePay, paymentHandle.googlePay) &&
        Objects.equals(this.skrill, paymentHandle.skrill) &&
        Objects.equals(this.neteller, paymentHandle.neteller) &&
        Objects.equals(this.paysafecash, paymentHandle.paysafecash) &&
        Objects.equals(this.paysafecard, paymentHandle.paysafecard) &&
        Objects.equals(this.payPal, paymentHandle.payPal) &&
        Objects.equals(this.venmo, paymentHandle.venmo) &&
        Objects.equals(this.vippreferred, paymentHandle.vippreferred) &&
        Objects.equals(this.mazooma, paymentHandle.mazooma) &&
        Objects.equals(this.sightline, paymentHandle.sightline) &&
        Objects.equals(this.payByBank, paymentHandle.payByBank) &&
        Objects.equals(this.interacETransfer, paymentHandle.interacETransfer) &&
        Objects.equals(this.browserDetails, paymentHandle.browserDetails) &&
        Objects.equals(this.deviceDetails, paymentHandle.deviceDetails) &&
        Objects.equals(this.rapidTransfer, paymentHandle.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, paymentHandle.skrill1Tap) &&
        Objects.equals(this.ach, paymentHandle.ach) &&
        Objects.equals(this.eft, paymentHandle.eft) &&
        Objects.equals(this.dupCheck, paymentHandle.dupCheck) &&
        Objects.equals(this.bacs, paymentHandle.bacs) &&
        Objects.equals(this.mandates, paymentHandle.mandates) &&
        Objects.equals(this.sepa, paymentHandle.sepa) &&
        Objects.equals(this.safetyPayCash, paymentHandle.safetyPayCash) &&
        Objects.equals(this.paymentExpiryInMinutes, paymentHandle.paymentExpiryInMinutes) &&
        Objects.equals(this.paymentDetails, paymentHandle.paymentDetails) &&
        Objects.equals(this.paymentExpiryMinutes, paymentHandle.paymentExpiryMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getError(), id, paymentHandleToken, txnTime, status, liveMode, usage, action, executionMode, timeToLiveSeconds,
        gatewayReconciliationId, updatedTime, statusTime, links, merchantRefNum, transactionType, accountId, paymentType, amount, currencyCode, profile,
        billingDetails, merchantDescriptor, returnLinks, customerIp, shippingDetails, card, threeDs, authentication, paymentHandleTokenFrom, transactionIntent,
        gatewayResponse, applePay, googlePay, skrill, neteller, paysafecash, paysafecard, payPal, venmo, skip3ds, vippreferred, mazooma, sightline, payByBank,
        interacETransfer, browserDetails, deviceDetails, rapidTransfer, skrill1Tap, ach, eft, dupCheck, bacs, mandates, sepa,
        safetyPayCash, paymentExpiryInMinutes, paymentDetails, paymentExpiryMinutes);
  }

  @Override
  public String toString() {

    return "class PaymentHandle {\n"
        + "    errorResponse: " + toIndentedString(getError()) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    usage: " + toIndentedString(usage) + "\n"
        + "    action: " + toIndentedString(action) + "\n"
        + "    executionMode: " + toIndentedString(executionMode) + "\n"
        + "    timeToLiveSeconds: " + toIndentedString(timeToLiveSeconds) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    links: " + toIndentedString(links) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    transactionType: " + toIndentedString(transactionType) + "\n"
        + "    accountId: " + toIndentedString(accountId) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    shippingDetails: " + toIndentedString(shippingDetails) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    skip3ds: " + toIndentedString(skip3ds) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
        + "    googlePay: " + toIndentedString(googlePay) + "\n"
        + "    skrill: " + toIndentedString(skrill) + "\n"
        + "    neteller: " + toIndentedString(neteller) + "\n"
        + "    paysafecash: " + toIndentedString(paysafecash) + "\n"
        + "    paysafecard: " + toIndentedString(paysafecard) + "\n"
        + "    payPal: " + toIndentedString(payPal) + "\n"
        + "    venmo: " + toIndentedString(venmo) + "\n"
        + "    vippreferred: " + toIndentedString(vippreferred) + "\n"
        + "    mazooma: " + toIndentedString(mazooma) + "\n"
        + "    sightline: " + toIndentedString(sightline) + "\n"
        + "    payByBank: " + toIndentedString(payByBank) + "\n"
        + "    interacETransfer: " + toIndentedString(interacETransfer) + "\n"
        + "    browserDetails: " + toIndentedString(browserDetails) + "\n"
        + "    deviceDetails: " + toIndentedString(deviceDetails) + "\n"
        + "    rapidTransfer: " + toIndentedString(rapidTransfer) + "\n"
        + "    skrill1Tap: " + toIndentedString(skrill1Tap) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
        + "    safetyPayCash: " + toIndentedString(safetyPayCash) + "\n"
        + "    paymentExpiryInMinutes: " + toIndentedString(paymentExpiryInMinutes) + "\n"
        + "    paymentDetails: " + toIndentedString(paymentDetails) + "\n"
        + "    paymentExpiryMinutes: " + toIndentedString(paymentExpiryMinutes) + "\n"
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
   * {@code PaymentHandle} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String paymentHandleToken;
    private String txnTime;
    private String status;
    private Boolean liveMode;
    private PaymentHandleUsage usage;
    private Action action;
    private ExecutionMode executionMode;
    private Long timeToLiveSeconds;
    private String gatewayReconciliationId;
    private String updatedTime;
    private String statusTime;
    private List<Link> links;
    private String merchantRefNum;
    private TransactionType transactionType;
    private String accountId;
    private String paymentType;
    private Long amount;
    private CurrencyCode currencyCode;
    private Profile profile;
    private BillingDetails billingDetails;
    private MerchantDescriptor merchantDescriptor;
    private List<ReturnLink> returnLinks;
    private String customerIp;
    private ShippingDetails shippingDetails;
    private CardWithOptionalNetworkTokenOrApplePay card;
    private Boolean skip3ds;
    private ThreeDs threeDs;
    private NetworkTokenCardObjectAuthentication authentication;
    private String paymentHandleTokenFrom;
    private String transactionIntent;
    private GatewayResponse gatewayResponse;
    private ApplePay applePay;
    private GooglePay googlePay;
    private Skrill skrill;
    private Neteller neteller;
    private Paysafecash paysafecash;
    private Paysafecard paysafecard;
    private Paypal payPal;
    private Venmo venmo;
    private Vippreferred vippreferred;
    private Mazooma mazooma;
    private Sightline sightline;
    private PayByBank payByBank;
    private Interac interacETransfer;
    private BrowserDetails browserDetails;
    private DeviceDetails deviceDetails;
    private RapidTransfer rapidTransfer;
    private Skrill1Tap skrill1Tap;
    private Ach ach;
    private Eft eft;
    private Boolean dupCheck;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;
    private SafetyPayCash safetyPayCash;
    private Long paymentExpiryInMinutes;
    private PaymentDetails paymentDetails;
    private Long paymentExpiryMinutes;
    private Error error;

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
     * Sets the {@code liveMode} and returns a reference to this Builder enabling method chaining.
     *
     * @param liveMode the {@code liveMode} to set
     * @return a reference to this Builder
     */
    public Builder liveMode(Boolean liveMode) {
      this.liveMode = liveMode;
      return this;
    }

    /**
     * Sets the {@code usage} and returns a reference to this Builder enabling method chaining.
     *
     * @param usage the {@code usage} to set
     * @return a reference to this Builder
     */
    public Builder usage(PaymentHandleUsage usage) {
      this.usage = usage;
      return this;
    }

    /**
     * Sets the {@code action} and returns a reference to this Builder enabling method chaining.
     *
     * @param action the {@code action} to set
     * @return a reference to this Builder
     */
    public Builder action(Action action) {
      this.action = action;
      return this;
    }

    /**
     * Sets the {@code executionMode} and returns a reference to this Builder enabling method chaining.
     *
     * @param executionMode the {@code executionMode} to set
     * @return a reference to this Builder
     */
    public Builder executionMode(ExecutionMode executionMode) {
      this.executionMode = executionMode;
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
     * Sets the {@code gatewayReconciliationId} and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayReconciliationId the {@code gatewayReconciliationId} to set
     * @return a reference to this Builder
     */
    public Builder gatewayReconciliationId(String gatewayReconciliationId) {
      this.gatewayReconciliationId = gatewayReconciliationId;
      return this;
    }

    /**
     * Sets the {@code updatedTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param updatedTime the {@code updatedTime} to set
     * @return a reference to this Builder
     */
    public Builder updatedTime(String updatedTime) {
      this.updatedTime = updatedTime;
      return this;
    }

    /**
     * Sets the {@code statusTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param statusTime the {@code statusTime} to set
     * @return a reference to this Builder
     */
    public Builder statusTime(String statusTime) {
      this.statusTime = statusTime;
      return this;
    }

    /**
     * Sets the {@code links} and returns a reference to this Builder enabling method chaining.
     *
     * @param links the {@code links} to set
     * @return a reference to this Builder
     */
    public Builder links(List<Link> links) {
      this.links = links;
      return this;
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
     * Sets the {@code transactionType} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionType the {@code transactionType} to set
     * @return a reference to this Builder
     */
    public Builder transactionType(TransactionType transactionType) {
      this.transactionType = transactionType;
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
     * Sets the {@code paymentType} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the {@code paymentType} to set
     * @return a reference to this Builder
     */
    public Builder paymentType(String paymentType) {
      this.paymentType = paymentType;
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
     * Sets the {@code profile} and returns a reference to this Builder enabling method chaining.
     *
     * @param profile the {@code profile} to set
     * @return a reference to this Builder
     */
    public Builder profile(Profile profile) {
      this.profile = profile;
      return this;
    }

    /**
     * Sets the {@code billingDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param billingDetails the {@code billingDetails} to set
     * @return a reference to this Builder
     */
    public Builder billingDetails(BillingDetails billingDetails) {
      this.billingDetails = billingDetails;
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
     * Sets the {@code returnLinks} and returns a reference to this Builder enabling method chaining.
     *
     * @param returnLinks the {@code returnLinks} to set
     * @return a reference to this Builder
     */
    public Builder returnLinks(List<ReturnLink> returnLinks) {
      this.returnLinks = returnLinks;
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
     * Sets the {@code shippingDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingDetails the {@code shippingDetails} to set
     * @return a reference to this Builder
     */
    public Builder shippingDetails(ShippingDetails shippingDetails) {
      this.shippingDetails = shippingDetails;
      return this;
    }

    /**
     * Sets the {@code card} and returns a reference to this Builder enabling method chaining.
     *
     * @param card the {@code card} to set
     * @return a reference to this Builder
     */
    public Builder card(CardWithOptionalNetworkTokenOrApplePay card) {
      this.card = card;
      return this;
    }

    /**
     * Sets the {@code skip3ds} and returns a reference to this Builder enabling method chaining.
     *
     * @param skip3ds the {@code skip3ds} to set
     * @return a reference to this Builder
     */
    public Builder skip3ds(Boolean skip3ds) {
      this.skip3ds = skip3ds;
      return this;
    }

    /**
     * Sets the {@code threeDs} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDs the {@code threeDs} to set
     * @return a reference to this Builder
     */
    public Builder threeDs(ThreeDs threeDs) {
      this.threeDs = threeDs;
      return this;
    }

    /**
     * Sets the {@code authentication} and returns a reference to this Builder enabling method chaining.
     *
     * @param authentication the {@code authentication} to set
     * @return a reference to this Builder
     */
    public Builder authentication(NetworkTokenCardObjectAuthentication authentication) {
      this.authentication = authentication;
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
     * Sets the {@code transactionIntent} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the {@code transactionIntent} to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(String transactionIntent) {
      this.transactionIntent = transactionIntent;
      return this;
    }

    /**
     * Sets the {@code gatewayResponse} and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayResponse the {@code gatewayResponse} to set
     * @return a reference to this Builder
     */
    public Builder gatewayResponse(GatewayResponse gatewayResponse) {
      this.gatewayResponse = gatewayResponse;
      return this;
    }

    /**
     * Sets the {@code applePay} and returns a reference to this Builder enabling method chaining.
     *
     * @param applePay the {@code applePay} to set
     * @return a reference to this Builder
     */
    public Builder applePay(ApplePay applePay) {
      this.applePay = applePay;
      return this;
    }

    /**
     * Sets the {@code googlePay} and returns a reference to this Builder enabling method chaining.
     *
     * @param googlePay the {@code googlePay} to set
     * @return a reference to this Builder
     */
    public Builder googlePay(GooglePay googlePay) {
      this.googlePay = googlePay;
      return this;
    }

    /**
     * Sets the {@code skrill} and returns a reference to this Builder enabling method chaining.
     *
     * @param skrill the {@code skrill} to set
     * @return a reference to this Builder
     */
    public Builder skrill(Skrill skrill) {
      this.skrill = skrill;
      return this;
    }

    /**
     * Sets the {@code neteller} and returns a reference to this Builder enabling method chaining.
     *
     * @param neteller the {@code neteller} to set
     * @return a reference to this Builder
     */
    public Builder neteller(Neteller neteller) {
      this.neteller = neteller;
      return this;
    }

    /**
     * Sets the {@code paysafecash} and returns a reference to this Builder enabling method chaining.
     *
     * @param paysafecash the {@code paysafecash} to set
     * @return a reference to this Builder
     */
    public Builder paysafecash(Paysafecash paysafecash) {
      this.paysafecash = paysafecash;
      return this;
    }

    /**
     * Sets the {@code paysafecard} and returns a reference to this Builder enabling method chaining.
     *
     * @param paysafecard the {@code paysafecard} to set
     * @return a reference to this Builder
     */
    public Builder paysafecard(Paysafecard paysafecard) {
      this.paysafecard = paysafecard;
      return this;
    }

    /**
     * Sets the {@code payPal} and returns a reference to this Builder enabling method chaining.
     *
     * @param payPal the {@code payPal} to set
     * @return a reference to this Builder
     */
    public Builder payPal(Paypal payPal) {
      this.payPal = payPal;
      return this;
    }

    /**
     * Sets the {@code venmo} and returns a reference to this Builder enabling method chaining.
     *
     * @param venmo the {@code venmo} to set
     * @return a reference to this Builder
     */
    public Builder venmo(Venmo venmo) {
      this.venmo = venmo;
      return this;
    }

    /**
     * Sets the {@code vippreferred} and returns a reference to this Builder enabling method chaining.
     *
     * @param vippreferred the {@code vippreferred} to set
     * @return a reference to this Builder
     */
    public Builder vippreferred(Vippreferred vippreferred) {
      this.vippreferred = vippreferred;
      return this;
    }

    /**
     * Sets the {@code mazooma} and returns a reference to this Builder enabling method chaining.
     *
     * @param mazooma the {@code mazooma} to set
     * @return a reference to this Builder
     */
    public Builder mazooma(Mazooma mazooma) {
      this.mazooma = mazooma;
      return this;
    }

    /**
     * Sets the {@code sightline} and returns a reference to this Builder enabling method chaining.
     *
     * @param sightline the {@code sightline} to set
     * @return a reference to this Builder
     */
    public Builder sightline(Sightline sightline) {
      this.sightline = sightline;
      return this;
    }

    /**
     * Sets the {@code payByBank} and returns a reference to this Builder enabling method chaining.
     *
     * @param payByBank the {@code payByBank} to set
     * @return a reference to this Builder
     */
    public Builder payByBank(PayByBank payByBank) {
      this.payByBank = payByBank;
      return this;
    }

    /**
     * Sets the {@code interacETransfer} and returns a reference to this Builder enabling method chaining.
     *
     * @param interacETransfer the {@code interacETransfer} to set
     * @return a reference to this Builder
     */
    public Builder interacETransfer(Interac interacETransfer) {
      this.interacETransfer = interacETransfer;
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
     * Sets the {@code deviceDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceDetails the {@code deviceDetails} to set
     * @return a reference to this Builder
     */
    public Builder deviceDetails(DeviceDetails deviceDetails) {
      this.deviceDetails = deviceDetails;
      return this;
    }

    /**
     * Sets the {@code rapidTransfer} and returns a reference to this Builder enabling method chaining.
     *
     * @param rapidTransfer the {@code rapidTransfer} to set
     * @return a reference to this Builder
     */
    public Builder rapidTransfer(RapidTransfer rapidTransfer) {
      this.rapidTransfer = rapidTransfer;
      return this;
    }

    /**
     * Sets the {@code skrill1Tap} and returns a reference to this Builder enabling method chaining.
     *
     * @param skrill1Tap the {@code skrill1Tap} to set
     * @return a reference to this Builder
     */
    public Builder skrill1Tap(Skrill1Tap skrill1Tap) {
      this.skrill1Tap = skrill1Tap;
      return this;
    }

    /**
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(Ach ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Sets the {@code eft} and returns a reference to this Builder enabling method chaining.
     *
     * @param eft the {@code eft} to set
     * @return a reference to this Builder
     */
    public Builder eft(Eft eft) {
      this.eft = eft;
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
     * Sets the {@code bacs} and returns a reference to this Builder enabling method chaining.
     *
     * @param bacs the {@code bacs} to set
     * @return a reference to this Builder
     */
    public Builder bacs(Bacs bacs) {
      this.bacs = bacs;
      return this;
    }

    /**
     * Sets the {@code mandates} and returns a reference to this Builder enabling method chaining.
     *
     * @param mandates the {@code mandates} to set
     * @return a reference to this Builder
     */
    public Builder mandates(List<Mandate> mandates) {
      this.mandates = mandates;
      return this;
    }

    /**
     * Sets the {@code sepa} and returns a reference to this Builder enabling method chaining.
     *
     * @param sepa the {@code sepa} to set
     * @return a reference to this Builder
     */
    public Builder sepa(Sepa sepa) {
      this.sepa = sepa;
      return this;
    }

    /**
     * Sets the {@code safetyPayCash} and returns a reference to this Builder enabling method chaining.
     *
     * @param safetyPayCash the {@code safetyPayCash} to set
     * @return a reference to this Builder
     */
    public Builder safetyPayCash(SafetyPayCash safetyPayCash) {
      this.safetyPayCash = safetyPayCash;
      return this;
    }

    /**
     * Sets the {@code paymentExpiryInMinutes} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentExpiryInMinutes the {@code paymentExpiryInMinutes} to set
     * @return a reference to this Builder
     */
    public Builder paymentExpiryInMinutes(Long paymentExpiryInMinutes) {
      this.paymentExpiryInMinutes = paymentExpiryInMinutes;
      return this;
    }

    /**
     * Sets the {@code paymentDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentDetails the {@code paymentDetails} to set
     * @return a reference to this Builder
     */
    public Builder paymentDetails(PaymentDetails paymentDetails) {
      this.paymentDetails = paymentDetails;
      return this;
    }

    /**
     * Sets the {@code paymentExpiryMinutes} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentExpiryMinutes the {@code paymentExpiryMinutes} to set
     * @return a reference to this Builder
     */
    public Builder paymentExpiryMinutes(Long paymentExpiryMinutes) {
      this.paymentExpiryMinutes = paymentExpiryMinutes;
      return this;
    }

    /**
     * Returns a {@code PaymentHandle} built from the parameters previously set.
     *
     * @return a {@code PaymentHandle} built with parameters of this {@code PaymentHandle.Builder}
     */
    public PaymentHandle build() {
      return new PaymentHandle(this);
    }

    /**
     * Sets the {@code error} and returns a reference to this Builder enabling method chaining.
     *
     * @param error the {@code error} to set
     * @return a reference to this Builder
     */
    public Builder error(final Error error) {
      this.error = error;
      return this;
    }
  }
}

