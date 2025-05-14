// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.applepay.ApplePay;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.card.CardAuthentication;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.threeds.BrowserDetails;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.DeviceDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.PaymentDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.ShippingDetails;
import com.paysafe.payments.model.common.enums.CurrencyCode;
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
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;
import com.paysafe.payments.model.standalonecredit.Interac;

/**
 * Payment handle request body details.
 * <ul>
 *   <li>
 *     <b>merchantRefNum:</b> This is the merchant reference number created by the merchant and submitted as part of the request.
 *     It must be unique for each request. <br />
 *     Example: merchantRefNum-101
 *   </li>
 *   <li>
 *     <b>transactionType:</b> This specifies the transaction type for which the Payment Handle is created. <br />
 *     <i>Allowed values: PAYMENT, STANDALONE_CREDIT, ORIGINAL_CREDIT, VERIFICATION</i>
 *   </li>
 *   <li>
 *     <b>accountId:</b> If you are a merchant, then this field is required only if you have more than one account configured
 *     for the same payment method and currency. If you are a partner using a shared API key, then this field is mandatory. <br />
 *     Example: 9876543210
 *   </li>
 *   <li>
 *     <b>paymentType:</b> This is the payment type associated with the Payment Handle used for this request. <br />
 *     <i>Allowed values: CARD, APPLEPAY, SKRILL, NETELLER, PAYSAFECASH, PAYSAFECARD, PAYPAL, PAY BY BANK, VENMO
 *     VIPPREFERRED, MAZOOMA, MBWAY, MULTIBANCO, SIGHTLINE, INTERAC_ETRANSFER, RAPID_TRANSFER, SKRILL1TAP, ACH,
 *     EFT, BACS, SEPA, ONLINE_BANK_TRANSFER, PIX, KHIPU, MACH, BOLETO_BANCARIO, SAFETYPAY_CASH</i>
 *   </li>
 *   <li>
 *     <b>amount:</b> This is the amount of the request, in minor units. See
 *     <a href="This is the amount of the request, in minor units. See Currency Codes.">Currency Codes.</a> <br />
 *     <b>Note:<b> This field is mandatory if transactionType is included. The amount specified in the Payment Handle request
 *     must match the amount specified in the Payments API request the paymentHandleToken is used for. <br />
 *     Example: 500
 *   </li>
 *   <li>
 *     <b>currencyCode:</b> This is the currency of the merchant account, e.g., USD or CAD. <br />
 *     <b>Note:<b> This field is mandatory if transactionType is included. The currencyCode specified in the Payment Handle
 *     request must match the currencyCode specified in the Payments API request the paymentHandleToken is used for. <br />
 *     Example: USD
 *   </li>
 *   <li>
 *     <b>profile:</b> This is customer's profile details.
 *   </li>
 *   <li>
 *     <b>billingDetails:</b> Customer's billing details. <br />
 *     <b>Note:<b> For single-use Payment Handles, this address information will be ignored if the paymentHandleTokenFrom parameter
 *     is included in the Payment Handle creation request and there is already address information associated with that customer.
 *   </li>
 *   <li>
 *     <b>merchantDescriptor:</b> This is the merchant descriptor that will be displayed on the
 *     customer's card or bank statement. <br />
 *   </li>
 *   <li>
 *     <b>returnLinks:</b> The URL endpoints to redirect the customer to after a redirection to an alternative payment or
 *     3D Secure site. You can customize the return URL based on the transaction status.
 *   </li>
 *   <li>
 *     <b>customerIp:</b> This is the customer's IP address. <br />
 *     Example: 111.111.111.111
 *   </li>
 *   <li>
 *     <b>singleUseCustomerToken:</b> This is the single use customer token of the profile on which customer operation
 *     (ADD/EDIT/DELETE) needs to be done. <br />
 *     <b>Note:<b> Mandatory, if customerOperation is EDIT or DELETE.
 *   </li>
 *   <li>
 *     <b>deviceDetails:</b> This is part of Interac e-Transfer withdrawal Payment Handle request.
 *     It is used by Interac Online for risk assessment. <br />
 *   </li>
 *   <li>
 *     <b>shippingDetails:</b> Details about the shipping.
 *   </li>
 *   <li>
 *     <b>card:</b> Card details <br />
 *   </li>
 *   <li>
 *     <b>splitPay:</b> This object should be used only for Splitpay transactions only, an array containing the linked accounts
 *     and the amount shared with each. You must include either amount or percent. However, you cannot include both values.
 *   </li>
 *   <li>
 *     <b>threeDs:</b> Denotes the status of threeDs object. If true and is configured in the backend for the respective accountId,
 *     it is mandatory to pass these parameters. If false, parameters need not to be passed.
 *   </li>
 *   <li>
 *     <b>authentication:</b> 3D Secure authentication details.
 *   </li>
 *   <li>
 *     <b>paymentHandleTokenFrom:</b> This is an existing
 *     <a href=https://developer.paysafe.com/en/payments-api/#/operations/create-payment-handle-for-customer">
 *     Customer Payment Handle</a>, from which the payment instrument and profile details are retrieved.
 *     If this parameter is included you can omit the billingDetails object.
 *   </li>
 *   <li>
 *     <b>transactionIntent:</b> The transactionIntent property is used to identify the intent of the authorization requests.
 *     The value of the transactionIntent shows if the transaction is crypto or quasi-cash related one. <br />
 *   </li>
 * </ul>
 */
public class PaymentHandleRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("transactionType")
  private TransactionType transactionType;
  @JsonProperty("accountId")
  private String accountId;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
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
  private Card card;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private CardAuthentication authentication;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("transactionIntent")
  private String transactionIntent;
  @JsonProperty("applePay")
  private ApplePay applePay;
  @JsonProperty("googlePay")
  private GooglePay googlePay;
  @JsonProperty("skrill")
  private Skrill skrill;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
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
  private Integer paymentExpiryInMinutes;
  @JsonProperty("paymentDetails")
  private PaymentDetails paymentDetails;
  @JsonProperty("paymentExpiryMinutes")
  private Integer paymentExpiryMinutes;

  private Map<String, Object> additionalParameters;

  public PaymentHandleRequest() {
    super();
  }

  private PaymentHandleRequest(Builder builder) {
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
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setTransactionIntent(builder.transactionIntent);
    setApplePay(builder.applePay);
    setGooglePay(builder.googlePay);
    setSkrill(builder.skrill);
    setGatewayResponse(builder.gatewayResponse);
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
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PaymentHandleRequest merchantRefNum(String merchantRefNum) {
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

  public PaymentHandleRequest transactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * This specifies the transaction type for which the Payment Handle is created. <br />
   * - PAYMENT - Payment Handle is created to continue the Payment. <br />
   * - STANDALONE_CREDIT - Payment Handle is created to continue the Standalone Credit. <br />
   * - ORIGINAL_CREDIT - Payment Handle is created to continue the Original Credit. <br />
   * - VERIFICATION - Payment Handle is created to continue the Verification request.
   *
   * @return transactionType
   */
  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public PaymentHandleRequest accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * If you are a merchant, then this field is required only if you have more than one account configured for the same payment method and currency. <br />
   * If you are a partner/ISV using a shared API key, then this field is mandatory.
   *
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public PaymentHandleRequest paymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type associated with the Payment Handle used for this request.  >For Apple Pay and Google Pay, paymentType is 'CARD'
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public PaymentHandleRequest amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units.
   * Maximum: 99999999999
   *
   * @return amount
   */
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public PaymentHandleRequest currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account, e.g., USD or CAD. See
   * <a href="https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes">Currency Codes.</a>
   *
   * @return currencyCode
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public PaymentHandleRequest profile(Profile profile) {
    this.profile = profile;
    return this;
  }

  /**
   * This is customer's profile details.
   *
   * @return profile
   */
  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public PaymentHandleRequest billingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Customer's billing details. Required if AVS (Address verification) is enabled.<br />
   * If included in the request, this will serve as the billing address for transaction processing. <br />
   * Any billing details returned in Apple Pay Token by Apple Pay will be ignored. <br />
   * 3DS Flow: It is recommended to send billingDetails to improve acceptance rate.
   *
   * @return billingDetails
   */
  public BillingDetails getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
  }

  public PaymentHandleRequest merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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

  public PaymentHandleRequest returnLinks(List<ReturnLink> returnLinks) {
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

  public PaymentHandleRequest customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * This is the customer's IP address. Optional. <br />
   * If included in request, this is used as Customer's IP. <br />
   * If not sent in request, IP value is taken from request headers.
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }

  public PaymentHandleRequest shippingDetails(ShippingDetails shippingDetails) {
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

  public PaymentHandleRequest card(Card card) {
    this.card = card;
    return this;
  }

  /**
   * Card details to be used for the transaction
   *
   * @return card
   */
  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public PaymentHandleRequest threeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
    return this;
  }

  /**
   * This is the threeDs object. You need to send this object when you want to process CARD transaction with 3DS.
   * Required if account is enabled for 3DS. < /br>
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

  public PaymentHandleRequest authentication(CardAuthentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * These are 3D Secure authentication details.If you are using your own 3D Secure service provider and you want to
   * process Card transaction with 3DS then you need to pass Authetication object in Payment handle request.
   *
   * @return authentication
   */
  public CardAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(CardAuthentication authentication) {
    this.authentication = authentication;
  }

  public PaymentHandleRequest paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is used in Saved card flow. You will pass this parameter when you want to create single use payment handle using the Saved-card (card-on-file)
   * present in Paysafe customer vault. <br />
   * This is an existing Customer Payment Handle, from which the payment instrument details and profile details are retrieved. <br />
   * If this parameter is included then you can omit the billingDetails object. <br />
   * If you send a new billingDetails then same will be considered for the transaction, however no change will be made in the billingDetails
   * present against the Saved-card in customer vault.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public PaymentHandleRequest transactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * The transactionIntent property is used to identify the intent of the authorization requests.
   * The value of the transactionIntent shows if the transaction is crypto or quasi-cash related one. <br />
   * This field is mandatory for Visa card - cross-border fundingTransactions where the recipient is from any of the
   * following countries: India, Bangladesh, Argentina, and Egypt.<br />
   * It is also required for specific use cases. Check
   * <a href="https://developer.paysafe.com/en/payments-api/#/schemas/transactionIntent">on Transaction Intent reference page</a>
   * for more information.
   *
   * @return transactionIntent
   */
  public String getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
  }

  public PaymentHandleRequest applePay(ApplePay applePay) {
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

  public PaymentHandleRequest googlePay(GooglePay googlePay) {
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

  public PaymentHandleRequest skrill(Skrill skrill) {
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

  public PaymentHandleRequest gatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

  /**
   * This contains parameters returned by gateway
   *
   * @return gatewayResponse
   */
  public GatewayResponse getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }

  public PaymentHandleRequest neteller(Neteller neteller) {
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

  public PaymentHandleRequest paysafecash(Paysafecash paysafecash) {
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

  public PaymentHandleRequest paysafecard(Paysafecard paysafecard) {
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

  public PaymentHandleRequest payPal(Paypal payPal) {
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

  public PaymentHandleRequest venmo(Venmo venmo) {
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

  public PaymentHandleRequest vippreferred(Vippreferred vippreferred) {
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

  public PaymentHandleRequest mazooma(Mazooma mazooma) {
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

  public PaymentHandleRequest sightline(Sightline sightline) {
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

  public PaymentHandleRequest payByBank(PayByBank payByBank) {
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

  public PaymentHandleRequest interacETransfer(Interac interacETransfer) {
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

  public PaymentHandleRequest browserDetails(BrowserDetails browserDetails) {
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

  public PaymentHandleRequest deviceDetails(DeviceDetails deviceDetails) {
    this.deviceDetails = deviceDetails;
    return this;
  }

  /**
   * For Interac e-Transfer withdrawal only.<br />  This is part of Interac e-Transfer withdrawal payment handle request.
   * It is used for risk assessment by Interac. <br />
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

  public PaymentHandleRequest rapidTransfer(RapidTransfer rapidTransfer) {
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

  public PaymentHandleRequest skrill1Tap(Skrill1Tap skrill1Tap) {
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

  public PaymentHandleRequest ach(Ach ach) {
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

  public PaymentHandleRequest eft(Eft eft) {
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

  public PaymentHandleRequest dupCheck(Boolean dupCheck) {
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

  public PaymentHandleRequest bacs(Bacs bacs) {
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

  public PaymentHandleRequest mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public PaymentHandleRequest addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public PaymentHandleRequest removeMandatesItem(Mandate mandatesItem) {
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

  public PaymentHandleRequest sepa(Sepa sepa) {
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

  public PaymentHandleRequest safetyPayCash(SafetyPayCash safetyPayCash) {
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

  public PaymentHandleRequest paymentExpiryInMinutes(Integer paymentExpiryInMinutes) {
    this.paymentExpiryInMinutes = paymentExpiryInMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at Safetypay.
   *
   * @return paymentExpiryInMinutes
   */
  public Integer getPaymentExpiryInMinutes() {
    return paymentExpiryInMinutes;
  }

  public void setPaymentExpiryInMinutes(Integer paymentExpiryInMinutes) {
    this.paymentExpiryInMinutes = paymentExpiryInMinutes;
  }

  public PaymentHandleRequest paymentDetails(PaymentDetails paymentDetails) {
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

  public PaymentHandleRequest paymentExpiryMinutes(Integer paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at Safetypay.
   *
   * @return paymentExpiryMinutes
   */
  public Integer getPaymentExpiryMinutes() {
    return paymentExpiryMinutes;
  }

  public void setPaymentExpiryMinutes(Integer paymentExpiryMinutes) {
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
    PaymentHandleRequest paymentHandleRequest = (PaymentHandleRequest) o;
    return Objects.equals(this.merchantRefNum, paymentHandleRequest.merchantRefNum) &&
        Objects.equals(this.transactionType, paymentHandleRequest.transactionType) &&
        Objects.equals(this.accountId, paymentHandleRequest.accountId) &&
        Objects.equals(this.paymentType, paymentHandleRequest.paymentType) &&
        Objects.equals(this.amount, paymentHandleRequest.amount) &&
        Objects.equals(this.currencyCode, paymentHandleRequest.currencyCode) &&
        Objects.equals(this.profile, paymentHandleRequest.profile) &&
        Objects.equals(this.billingDetails, paymentHandleRequest.billingDetails) &&
        Objects.equals(this.merchantDescriptor, paymentHandleRequest.merchantDescriptor) &&
        Objects.equals(this.returnLinks, paymentHandleRequest.returnLinks) &&
        Objects.equals(this.customerIp, paymentHandleRequest.customerIp) &&
        Objects.equals(this.shippingDetails, paymentHandleRequest.shippingDetails) &&
        Objects.equals(this.card, paymentHandleRequest.card) &&
        Objects.equals(this.threeDs, paymentHandleRequest.threeDs) &&
        Objects.equals(this.authentication, paymentHandleRequest.authentication) &&
        Objects.equals(this.paymentHandleTokenFrom, paymentHandleRequest.paymentHandleTokenFrom) &&
        Objects.equals(this.transactionIntent, paymentHandleRequest.transactionIntent) &&
        Objects.equals(this.applePay, paymentHandleRequest.applePay) &&
        Objects.equals(this.googlePay, paymentHandleRequest.googlePay) &&
        Objects.equals(this.skrill, paymentHandleRequest.skrill) &&
        Objects.equals(this.gatewayResponse, paymentHandleRequest.gatewayResponse) &&
        Objects.equals(this.neteller, paymentHandleRequest.neteller) &&
        Objects.equals(this.paysafecash, paymentHandleRequest.paysafecash) &&
        Objects.equals(this.paysafecard, paymentHandleRequest.paysafecard) &&
        Objects.equals(this.payPal, paymentHandleRequest.payPal) &&
        Objects.equals(this.venmo, paymentHandleRequest.venmo) &&
        Objects.equals(this.vippreferred, paymentHandleRequest.vippreferred) &&
        Objects.equals(this.mazooma, paymentHandleRequest.mazooma) &&
        Objects.equals(this.sightline, paymentHandleRequest.sightline) &&
        Objects.equals(this.payByBank, paymentHandleRequest.payByBank) &&
        Objects.equals(this.interacETransfer, paymentHandleRequest.interacETransfer) &&
        Objects.equals(this.browserDetails, paymentHandleRequest.browserDetails) &&
        Objects.equals(this.deviceDetails, paymentHandleRequest.deviceDetails) &&
        Objects.equals(this.rapidTransfer, paymentHandleRequest.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, paymentHandleRequest.skrill1Tap) &&
        Objects.equals(this.ach, paymentHandleRequest.ach) &&
        Objects.equals(this.eft, paymentHandleRequest.eft) &&
        Objects.equals(this.dupCheck, paymentHandleRequest.dupCheck) &&
        Objects.equals(this.bacs, paymentHandleRequest.bacs) &&
        Objects.equals(this.mandates, paymentHandleRequest.mandates) &&
        Objects.equals(this.sepa, paymentHandleRequest.sepa) &&
        Objects.equals(this.safetyPayCash, paymentHandleRequest.safetyPayCash) &&
        Objects.equals(this.paymentExpiryInMinutes, paymentHandleRequest.paymentExpiryInMinutes) &&
        Objects.equals(this.paymentDetails, paymentHandleRequest.paymentDetails) &&
        Objects.equals(this.paymentExpiryMinutes, paymentHandleRequest.paymentExpiryMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, transactionType, accountId, paymentType, amount, currencyCode, profile, billingDetails, merchantDescriptor,
        returnLinks, customerIp, shippingDetails, card, threeDs, authentication, paymentHandleTokenFrom, transactionIntent, applePay, googlePay, skrill,
        gatewayResponse, neteller, paysafecash, paysafecard, payPal, venmo, vippreferred, mazooma, sightline, payByBank, interacETransfer, browserDetails,
        deviceDetails, rapidTransfer, skrill1Tap, ach, eft, dupCheck, bacs, mandates, sepa, safetyPayCash, paymentExpiryInMinutes, paymentDetails,
        paymentExpiryMinutes, additionalParameters);
  }

  @Override
  public String toString() {

    return "class PaymentHandleRequest {\n"
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
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
        + "    googlePay: " + toIndentedString(googlePay) + "\n"
        + "    skrill: " + toIndentedString(skrill) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
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

  /**
   * {@code PaymentHandleRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private TransactionType transactionType;
    private String accountId;
    private PaymentType paymentType;
    private Long amount;
    private CurrencyCode currencyCode;
    private Profile profile;
    private BillingDetails billingDetails;
    private MerchantDescriptor merchantDescriptor;
    private List<ReturnLink> returnLinks;
    private String customerIp;
    private ShippingDetails shippingDetails;
    private Card card;
    private ThreeDs threeDs;
    private CardAuthentication authentication;
    private String paymentHandleTokenFrom;
    private String transactionIntent;
    private ApplePay applePay;
    private GooglePay googlePay;
    private Skrill skrill;
    private GatewayResponse gatewayResponse;
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
    private Integer paymentExpiryInMinutes;
    private PaymentDetails paymentDetails;
    private Integer paymentExpiryMinutes;
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
    public Builder paymentType(PaymentType paymentType) {
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
    public Builder card(Card card) {
      this.card = card;
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
    public Builder authentication(CardAuthentication authentication) {
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
    public Builder paymentExpiryInMinutes(Integer paymentExpiryInMinutes) {
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
    public Builder paymentExpiryMinutes(Integer paymentExpiryMinutes) {
      this.paymentExpiryMinutes = paymentExpiryMinutes;
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
     * Returns a {@code PaymentHandleRequest} built from the parameters previously set.
     *
     * @return a {@code PaymentHandleRequest} built with parameters of this {@code PaymentHandleRequest.Builder}
     */
    public PaymentHandleRequest build() {
      return new PaymentHandleRequest(this);
    }
  }
}
