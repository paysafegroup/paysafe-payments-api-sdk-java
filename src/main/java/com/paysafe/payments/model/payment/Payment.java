// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.AcquirerData;
import com.paysafe.payments.model.card.CardWithOptionalNetworkTokenOrApplePay;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.enums.ProcessingRails;
import com.paysafe.payments.model.card.threeds.Authentication;
import com.paysafe.payments.model.card.threeds.BrowserDetails;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.DeviceDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Link;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.PaymentDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
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
import com.paysafe.payments.model.payment.enums.PaymentRequestStatus;
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.standalonecredit.Interac;

/**
 * Represents the response of a payment transaction
 *
 * <p>The {@code Payment} class captures essential data returned after processing a payment,
 * including transaction details, customer and billing information, and gateway responses.</p>
 *
 * <p>Key fields:</p>
 * <ul>
 *   <li><strong>id:</strong> The unique identifier for the payment transaction.</li>
 *   <li><strong>availableToSettle:</strong> The amount available to settle from the payment.</li>
 *   <li><strong>childAccountNum:</strong> The child account number if the transaction is processed via a master account.</li>
 *   <li><strong>txnTime:</strong> The date and time of the transaction (e.g., "2023-12-20T15:00:00Z").</li>
 *   <li><strong>paymentType:</strong> The type of payment used (e.g., CREDIT_CARD, PAYPAL, etc.).</li>
 *   <li><strong>status:</strong> The current status of the payment transaction (e.g., "COMPLETED", "FAILED").</li>
 *   <li><strong>riskReasonCode:</strong> A list of risk-related reason codes.</li>
 *   <li><strong>settlements:</strong> A list of settlement objects associated with the payment.</li>
 *   <li><strong>error:</strong> Error details, if any, associated with the transaction.</li>
 *   <li><strong>statusReason:</strong> A description of the reason for the current status.</li>
 *   <li><strong>authenticationDetails:</strong> Details related to payment authentication, such as 3D Secure.</li>
 *   <li><strong>gatewayReconciliationId:</strong> The reconciliation ID returned by the gateway.</li>
 *   <li><strong>updatedTime:</strong> The date and time the payment response was last updated.</li>
 *   <li><strong>statusTime:</strong> The date and time the current status was assigned.</li>
 *   <li><strong>availableToRefund:</strong> The amount available for refund, expressed in minor units.</li>
 *   <li><strong>processingRails:</strong> The processing rails used for the transaction (e.g., Visa, Mastercard).</li>
 *   <li><strong>links:</strong> A list of links for further actions or details related to the transaction.</li>
 *   <li><strong>liveMode:</strong> Indicates whether the transaction was processed in live mode (true) or test mode (false).</li>
 *   <li><strong>billingDetails:</strong> Billing details associated with the payment.</li>
 *   <li><strong>customerProfile:</strong> Information about the customer's profile.</li>
 *   <li><strong>merchantRefNum:</strong> The merchant's reference number for the transaction.</li>
 *   <li><strong>amount:</strong> The total amount of the payment transaction, expressed in minor units.</li>
 *   <li><strong>dupCheck:</strong> Indicates whether duplicate transaction checking was applied.</li>
 *   <li><strong>settleWithAuth:</strong> Indicates whether the payment was settled with authorization.</li>
 *   <li><strong>paymentHandleToken:</strong> The token representing a payment handle for the transaction.</li>
 *   <li><strong>customerIp:</strong> The IP address of the customer making the payment.</li>
 *   <li><strong>currencyCode:</strong> The currency used for the transaction, in ISO 4217 format.</li>
 *   <li><strong>card:</strong> Card details used in the transaction, if applicable.</li>
 *   <li><strong>threeDs:</strong> 3D Secure details for authentication, if applicable.</li>
 *   <li><strong>paymentHandleTokenFrom:</strong> The token from which the payment handle was generated.</li>
 *   <li><strong>transactionIntent:</strong> The intent of the transaction (e.g., AUTHORIZATION, SALE).</li>
 *   <li><strong>gatewayResponse:</strong> The response returned by the payment gateway.</li>
 * </ul>
 */
@JsonIgnoreProperties(value = { "cardSchemeTransactionId" })
public class Payment {

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
  @JsonProperty("card")
  private CardWithOptionalNetworkTokenOrApplePay card;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private Authentication authentication;
  @JsonProperty("preAuth")
  private Boolean preAuth;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("transactionIntent")
  private String transactionIntent;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
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
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
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
  @JsonProperty("id")
  private String id;
  @JsonProperty("availableToSettle")
  private Long availableToSettle;
  @JsonProperty("childAccountNum")
  private String childAccountNum;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("paymentType")
  private String paymentType;
  @JsonProperty("status")
  private PaymentRequestStatus status;
  @JsonProperty("riskReasonCode")
  private List<Integer> riskReasonCode = null;
  @JsonProperty("settlements")
  private List<Settlement> settlements;
  @JsonProperty("error")
  private Error error;
  @JsonProperty("statusReason")
  private String statusReason;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("availableToRefund")
  private Long availableToRefund;
  @JsonProperty("processingRails")
  private ProcessingRails processingRails;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("customerProfile")
  private Profile customerProfile;
  @JsonProperty("acquirerData")
  private AcquirerData acquirerData;
  @JsonProperty("paymentFacilitator")
  private PaymentFacilitator paymentFacilitator;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("keywords")
  private List<String> keywords;
  @JsonProperty("description")
  private String description;

  public Payment() {
    super();
  }

  private Payment(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSettleWithAuth(builder.settleWithAuth);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerIp(builder.customerIp);
    setCurrencyCode(builder.currencyCode);
    setCard(builder.card);
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setPreAuth(builder.preAuth);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setTransactionIntent(builder.transactionIntent);
    setGatewayResponse(builder.gatewayResponse);
    setSkrill(builder.skrill);
    setNeteller(builder.neteller);
    setPaysafecash(builder.paysafecash);
    setPaysafecard(builder.paysafecard);
    setPayPal(builder.payPal);
    setReturnLinks(builder.returnLinks);
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
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
    setSafetyPayCash(builder.safetyPayCash);
    setPaymentExpiryInMinutes(builder.paymentExpiryInMinutes);
    setPaymentDetails(builder.paymentDetails);
    setPaymentExpiryMinutes(builder.paymentExpiryMinutes);
    setId(builder.id);
    setAvailableToSettle(builder.availableToSettle);
    setChildAccountNum(builder.childAccountNum);
    setTxnTime(builder.txnTime);
    setPaymentType(builder.paymentType);
    setStatus(builder.status);
    setRiskReasonCode(builder.riskReasonCode);
    setSettlements(builder.settlements);
    setError(builder.error);
    setStatusReason(builder.statusReason);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setAvailableToRefund(builder.availableToRefund);
    setProcessingRails(builder.processingRails);
    setLiveMode(builder.liveMode);
    setBillingDetails(builder.billingDetails);
    setCustomerProfile(builder.customerProfile);
    setAcquirerData(builder.acquirerData);
    setPaymentFacilitator(builder.paymentFacilitator);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setMerchantDescriptor(builder.merchantDescriptor);
    setKeywords(builder.keywords);
    setDescription(builder.description);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Payment merchantRefNum(String merchantRefNum) {
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

  public Payment amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value  should be 1099.
   * <b>Note:</b> The amount specified in the Payment request must match the amount specified in the Payment Handle request
   * from which the paymentHandleToken is taken. <br>
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

  public Payment dupCheck(Boolean dupCheck) {
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

  public Payment settleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
    return this;
  }

  /**
   * This indicates whether the request is an  Authorization only (no Settlement), or a Purchase (Authorization and Settlement).
   * <ul>
   * <li>false – The request is not settled   </li>
   * <li>true – The request is settled   </li>
   *</ul>
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

  public Payment paymentHandleToken(String paymentHandleToken) {
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

  public Payment customerIp(String customerIp) {
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

  public Payment currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account, e.g., USD or CAD, returned in the request response.
   * <b>Note:</b> The currencyCode specified in the Payment request must match the currencyCode specified in the Payment Handle request from which
   * the paymentHandleToken is taken.
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

  public Payment card(CardWithOptionalNetworkTokenOrApplePay card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   *
   * @return card
   */
  public CardWithOptionalNetworkTokenOrApplePay getCard() {
    return card;
  }

  public void setCard(CardWithOptionalNetworkTokenOrApplePay card) {
    this.card = card;
  }

  public Payment threeDs(ThreeDs threeDs) {
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

  public Payment authentication(Authentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * 3D Secure authentication details.
   *
   * @return authentication
   */
  public Authentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Authentication authentication) {
    this.authentication = authentication;
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

  public Payment paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * The response returns the original value from the request. This is used in Saved card flow. You will pass this parameter when you want to create
   * single use payment handle using the Saved-card (card-on-file) present in Paysafe customer vault.  <br>
   * This is an existing Customer Payment Handle, from which the payment instrument details and profile details are retrieved.  <br>
   * If this parameter is included then you can omit the billingDetails object.  <br>
   * If you send a new billingDetails then same will be considered for the transaction, however no change will be made in the billingDetails present
   * against the Saved-card in customer vault.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public Payment transactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * The transactionIntent property is used to identify the intent of the authorization requests.
   * The value of the transactionIntent shows if the transaction is crypto or quasi-cash related one.  <br>
   * This field is mandatory for Visa card - cross-border fundingTransactions where the recipient is from any of the
   * following countries: India, Bangladesh, Argentina, and Egypt. <br>
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

  public Payment gatewayResponse(GatewayResponse gatewayResponse) {
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

  public Payment skrill(Skrill skrill) {
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

  public Payment neteller(Neteller neteller) {
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

  public Payment paysafecash(Paysafecash paysafecash) {
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

  public Payment paysafecard(Paysafecard paysafecard) {
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

  public Payment payPal(Paypal payPal) {
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

  public Payment returnLinks(List<ReturnLink> returnLink) {
    this.returnLinks = returnLink;
    return this;
  }

  /**
   * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site.
   * You can customize the return URL based on the transaction status.
   *
   * @return returnLink
   */
  public List<ReturnLink> getReturnLink() {
    return returnLinks;
  }

  public void setReturnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
  }

  public Payment venmo(Venmo venmo) {
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

  public Payment vippreferred(Vippreferred vippreferred) {
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

  public Payment mazooma(Mazooma mazooma) {
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

  public Payment sightline(Sightline sightline) {
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

  public Payment payByBank(PayByBank payByBank) {
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

  public Payment interacETransfer(Interac interacETransfer) {
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

  public Payment browserDetails(BrowserDetails browserDetails) {
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

  public Payment deviceDetails(DeviceDetails deviceDetails) {
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

  public Payment rapidTransfer(RapidTransfer rapidTransfer) {
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

  public Payment skrill1Tap(Skrill1Tap skrill1Tap) {
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

  public Payment ach(Ach ach) {
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

  public Payment eft(Eft eft) {
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

  public Payment bacs(Bacs bacs) {
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

  public Payment mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public Payment addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public Payment removeMandatesItem(Mandate mandatesItem) {
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

  public Payment sepa(Sepa sepa) {
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

  public Payment safetyPayCash(SafetyPayCash safetyPayCash) {
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

  public Payment paymentExpiryInMinutes(Long paymentExpiryInMinutes) {
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

  public Payment paymentDetails(PaymentDetails paymentDetails) {
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

  public Payment paymentExpiryMinutes(Long paymentExpiryMinutes) {
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

  public Payment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID  can be used for future associated requests.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Payment availableToSettle(Long availableToSettle) {
    this.availableToSettle = availableToSettle;
    return this;
  }

  /**
   * This is the amount of the Authorization remaining  to settle, in minor units.
   *
   * @return availableToSettle
   */
  public Long getAvailableToSettle() {
    return availableToSettle;
  }

  public void setAvailableToSettle(Long availableToSettle) {
    this.availableToSettle = availableToSettle;
  }

  public Payment childAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
    return this;
  }

  /**
   * This is the child merchant account number. It is  returned only if the transaction was processed via a master account.
   *
   * @return childAccountNum
   */
  public String getChildAccountNum() {
    return childAccountNum;
  }

  public void setChildAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
  }

  public Payment txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * This is the date and time the request was  processed. For example: 2022-12-16T17:45:28Z
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }

  public Payment paymentType(String paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type associated with the Payment Handle used for this request.
   *
   * @return paymentType
   */
  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public Payment status(PaymentRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request.
   *
   * @return status
   */
  public PaymentRequestStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentRequestStatus status) {
    this.status = status;
  }

  public Payment riskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
    return this;
  }

  public Payment addRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (this.riskReasonCode == null) {
      this.riskReasonCode = new ArrayList<>();
    }
    this.riskReasonCode.add(riskReasonCodeItem);
    return this;
  }

  public Payment removeRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (riskReasonCodeItem != null && this.riskReasonCode != null) {
      this.riskReasonCode.remove(riskReasonCodeItem);
    }

    return this;
  }

  /**
   * For CARD. An array of integers is returned, displaying the  detailed Risk reason codes if your transaction was declined.
   * It is returned only if your account is configured accordingly.
   *
   * @return riskReasonCode
   */
  public List<Integer> getRiskReasonCode() {
    return riskReasonCode;
  }

  public void setRiskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
  }

  public Payment settlements(List<Settlement> settlements) {
    this.settlements = settlements;
    return this;
  }

  /**
   * Get settlements
   *
   * @return settlements
   */
  public List<Settlement> getSettlements() {
    return settlements;
  }

  public void setSettlements(List<Settlement> settlements) {
    this.settlements = settlements;
  }

  public Payment error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Details of the error.
   *
   * @return error
   */
  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  public Payment statusReason(String statusReason) {
    this.statusReason = statusReason;
    return this;
  }

  /**
   * This is reason for the status. This is present in the case where status is ERROR, FAILURE, or HELD.
   *
   * @return statusReason
   */
  public String getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(String statusReason) {
    this.statusReason = statusReason;
  }

  public Payment gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * Not for CARD. Transaction identifier that can be used to reconcile this transaction with the provider gateway.
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }

  public Payment updatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * ISO 8601 format (UTC) This is the date and time the resource was last updated, e.g., 2014-01-26T10:32:28Z
   *
   * @return updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }

  public Payment statusTime(String statusTime) {
    this.statusTime = statusTime;
    return this;
  }

  /**
   * ISO 8601 format (UTC) This is the date and time the resource status was last updated, e.g., 2014-01-26T10:32:28Z
   *
   * @return statusTime
   */
  public String getStatusTime() {
    return statusTime;
  }

  public void setStatusTime(String statusTime) {
    this.statusTime = statusTime;
  }

  public Payment availableToRefund(Long availableToRefund) {
    this.availableToRefund = availableToRefund;
    return this;
  }

  /**
   * This is the amount of this Settlement that is available to Refund, in minor units. For example, US $10.99 would be 1099.  <br>
   * Maximum: 99999999999
   *
   * @return availableToRefund
   */
  public Long getAvailableToRefund() {
    return availableToRefund;
  }

  public void setAvailableToRefund(Long availableToRefund) {
    this.availableToRefund = availableToRefund;
  }

  public Payment processingRails(ProcessingRails processingRails) {
    this.processingRails = processingRails;
    return this;
  }

  /**
   * For CARD.Defines the processing rails options used for this transaction, indicating whether it is processed via pinless or regular card scheme network.
   * Possible values: PINLESS, CARD_SCHEME_ROUTED
   *
   * @return processingRails
   */
  public ProcessingRails getProcessingRails() {
    return processingRails;
  }

  public void setProcessingRails(ProcessingRails processingRails) {
    this.processingRails = processingRails;
  }

  public Payment links(Link link) {
    return this;
  }

  public Payment liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * This flag indicates the environment.  - true - production - false - Non-Production
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }

  public Payment billingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Customer's billing details. Required if AVS (Address verification) is enabled. <br>
   * If included in the request, this will serve as the billing address for transaction processing.  <br>
   * Any billing details returned in Apple Pay Token by Apple Pay will be ignored.  <br>
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

  public Payment customerProfile(Profile customerProfile) {
    this.customerProfile = customerProfile;
    return this;
  }

  /**
   * This is customer's profile details.  <br>**Same as request**.
   *
   * @return customerProfile
   */
  public Profile getCustomerProfile() {
    return customerProfile;
  }

  public void setCustomerProfile(Profile customerProfile) {
    this.customerProfile = customerProfile;
  }

  public AcquirerData getAcquirerData() {
    return acquirerData;
  }

  public void setAcquirerData(AcquirerData acquirerData) {
    this.acquirerData = acquirerData;
  }

  public PaymentFacilitator getPaymentFacilitator() {
    return paymentFacilitator;
  }

  public void setPaymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
  }

  public AirlineTravelDetails getAirlineTravelDetails() {
    return airlineTravelDetails;
  }

  public void setAirlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
  }

  /**
   * This is the merchant descriptor that will be displayed on the customer's card or bank statement.
   *
   * @return merchantDescriptor
   */
  public MerchantDescriptor getMerchantDescriptor() {
    return merchantDescriptor;
  }

  public void setMerchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
  }

  public List<String> getKeywords() {
    return keywords;
  }

  public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
  }

  /**
   * Same as in PaymentRequest.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LodgingDetails getLodgingDetails() {
    return lodgingDetails;
  }

  public void setLodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
  }

  public CarRentalDetails getCarRentalDetails() {
    return carRentalDetails;
  }

  public void setCarRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
  }

  public CruiselineTravelDetails getCruiselineTravelDetails() {
    return cruiselineTravelDetails;
  }

  public void setCruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.merchantRefNum, payment.merchantRefNum) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.dupCheck, payment.dupCheck) &&
        Objects.equals(this.settleWithAuth, payment.settleWithAuth) &&
        Objects.equals(this.paymentHandleToken, payment.paymentHandleToken) &&
        Objects.equals(this.customerIp, payment.customerIp) &&
        Objects.equals(this.currencyCode, payment.currencyCode) &&
        Objects.equals(this.card, payment.card) &&
        Objects.equals(this.threeDs, payment.threeDs) &&
        Objects.equals(this.authentication, payment.authentication) &&
        Objects.equals(this.paymentHandleTokenFrom, payment.paymentHandleTokenFrom) &&
        Objects.equals(this.transactionIntent, payment.transactionIntent) &&
        Objects.equals(this.gatewayResponse, payment.gatewayResponse) &&
        Objects.equals(this.skrill, payment.skrill) &&
        Objects.equals(this.neteller, payment.neteller) &&
        Objects.equals(this.paysafecash, payment.paysafecash) &&
        Objects.equals(this.paysafecard, payment.paysafecard) &&
        Objects.equals(this.payPal, payment.payPal) &&
        Objects.equals(this.returnLinks, payment.returnLinks) &&
        Objects.equals(this.venmo, payment.venmo) &&
        Objects.equals(this.vippreferred, payment.vippreferred) &&
        Objects.equals(this.mazooma, payment.mazooma) &&
        Objects.equals(this.sightline, payment.sightline) &&
        Objects.equals(this.payByBank, payment.payByBank) &&
        Objects.equals(this.interacETransfer, payment.interacETransfer) &&
        Objects.equals(this.browserDetails, payment.browserDetails) &&
        Objects.equals(this.deviceDetails, payment.deviceDetails) &&
        Objects.equals(this.rapidTransfer, payment.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, payment.skrill1Tap) &&
        Objects.equals(this.ach, payment.ach) &&
        Objects.equals(this.eft, payment.eft) &&
        Objects.equals(this.bacs, payment.bacs) &&
        Objects.equals(this.mandates, payment.mandates) &&
        Objects.equals(this.sepa, payment.sepa) &&
        Objects.equals(this.safetyPayCash, payment.safetyPayCash) &&
        Objects.equals(this.paymentExpiryInMinutes, payment.paymentExpiryInMinutes) &&
        Objects.equals(this.paymentDetails, payment.paymentDetails) &&
        Objects.equals(this.paymentExpiryMinutes, payment.paymentExpiryMinutes) &&
        Objects.equals(this.id, payment.id) &&
        Objects.equals(this.availableToSettle, payment.availableToSettle) &&
        Objects.equals(this.childAccountNum, payment.childAccountNum) &&
        Objects.equals(this.txnTime, payment.txnTime) &&
        Objects.equals(this.paymentType, payment.paymentType) &&
        Objects.equals(this.status, payment.status) &&
        Objects.equals(this.riskReasonCode, payment.riskReasonCode) &&
        Objects.equals(this.settlements, payment.settlements) &&
        Objects.equals(this.error, payment.error) &&
        Objects.equals(this.statusReason, payment.statusReason) &&
        Objects.equals(this.gatewayReconciliationId, payment.gatewayReconciliationId) &&
        Objects.equals(this.updatedTime, payment.updatedTime) &&
        Objects.equals(this.statusTime, payment.statusTime) &&
        Objects.equals(this.availableToRefund, payment.availableToRefund) &&
        Objects.equals(this.processingRails, payment.processingRails) &&
        Objects.equals(this.liveMode, payment.liveMode) &&
        Objects.equals(this.billingDetails, payment.billingDetails) &&
        Objects.equals(this.customerProfile, payment.customerProfile) &&
        Objects.equals(this.acquirerData, payment.acquirerData) &&
        Objects.equals(this.paymentFacilitator, payment.paymentFacilitator) &&
        Objects.equals(this.airlineTravelDetails, payment.airlineTravelDetails) &&
        Objects.equals(this.lodgingDetails, payment.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, payment.carRentalDetails) &&
        Objects.equals(this.merchantDescriptor, payment.merchantDescriptor) &&
        Objects.equals(this.description, payment.description) &&
        Objects.equals(this.preAuth, payment.preAuth) &&
        Objects.equals(this.cruiselineTravelDetails, payment.cruiselineTravelDetails) &&
        Objects.equals(this.keywords, payment.keywords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, settleWithAuth, paymentHandleToken, customerIp, currencyCode, card, threeDs, authentication,
        paymentHandleTokenFrom, transactionIntent, gatewayResponse, skrill, neteller, paysafecash, paysafecard, payPal, returnLinks, venmo, vippreferred,
        mazooma, sightline, payByBank, interacETransfer, browserDetails, deviceDetails, rapidTransfer, skrill1Tap, ach, eft, bacs, mandates, sepa,
        safetyPayCash, paymentExpiryInMinutes, paymentDetails, paymentExpiryMinutes, id, availableToSettle, childAccountNum, txnTime, paymentType,
        status, riskReasonCode, settlements, error, statusReason, gatewayReconciliationId, updatedTime, statusTime, availableToRefund, processingRails,
        liveMode, billingDetails, customerProfile, merchantDescriptor, keywords, description, preAuth, cruiselineTravelDetails);
  }

  @Override
  public String toString() {

    return "class Payment {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    settleWithAuth: " + toIndentedString(settleWithAuth) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    skrill: " + toIndentedString(skrill) + "\n"
        + "    neteller: " + toIndentedString(neteller) + "\n"
        + "    paysafecash: " + toIndentedString(paysafecash) + "\n"
        + "    paysafecard: " + toIndentedString(paysafecard) + "\n"
        + "    payPal: " + toIndentedString(payPal) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
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
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
        + "    safetyPayCash: " + toIndentedString(safetyPayCash) + "\n"
        + "    paymentExpiryInMinutes: " + toIndentedString(paymentExpiryInMinutes) + "\n"
        + "    paymentDetails: " + toIndentedString(paymentDetails) + "\n"
        + "    paymentExpiryMinutes: " + toIndentedString(paymentExpiryMinutes) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    availableToSettle: " + toIndentedString(availableToSettle) + "\n"
        + "    childAccountNum: " + toIndentedString(childAccountNum) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    riskReasonCode: " + toIndentedString(riskReasonCode) + "\n"
        + "    settlements: " + toIndentedString(settlements) + "\n"
        + "    error: " + toIndentedString(error) + "\n"
        + "    statusReason: " + toIndentedString(statusReason) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    availableToRefund: " + toIndentedString(availableToRefund) + "\n"
        + "    processingRails: " + toIndentedString(processingRails) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    customerProfile: " + toIndentedString(customerProfile) + "\n"
        + "    acquirerData: " + toIndentedString(acquirerData) + "\n"
        + "    paymentFacilitator: " + toIndentedString(paymentFacilitator) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    keywords: " + toIndentedString(keywords) + "\n"
        + "    preAuth: " + toIndentedString(preAuth) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
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
   * {@code Payment} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Long amount;
    private Boolean dupCheck;
    private Boolean settleWithAuth;
    private String paymentHandleToken;
    private String customerIp;
    private CurrencyCode currencyCode;
    private CardWithOptionalNetworkTokenOrApplePay card;
    private ThreeDs threeDs;
    private Authentication authentication;
    private Boolean preAuth;
    private String paymentHandleTokenFrom;
    private String transactionIntent;
    private GatewayResponse gatewayResponse;
    private Skrill skrill;
    private Neteller neteller;
    private Paysafecash paysafecash;
    private Paysafecard paysafecard;
    private Paypal payPal;
    private List<ReturnLink> returnLinks;
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
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;
    private SafetyPayCash safetyPayCash;
    private Long paymentExpiryInMinutes;
    private PaymentDetails paymentDetails;
    private Long paymentExpiryMinutes;
    private String id;
    private Long availableToSettle;
    private String childAccountNum;
    private String txnTime;
    private String paymentType;
    private PaymentRequestStatus status;
    private List<Integer> riskReasonCode;
    private List<Settlement> settlements;
    private Error error;
    private String statusReason;
    private String gatewayReconciliationId;
    private String updatedTime;
    private String statusTime;
    private Long availableToRefund;
    private ProcessingRails processingRails;
    private Boolean liveMode;
    private BillingDetails billingDetails;
    private Profile customerProfile;
    private AcquirerData acquirerData;
    private PaymentFacilitator paymentFacilitator;
    private AirlineTravelDetails airlineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private MerchantDescriptor merchantDescriptor;
    private List<String> keywords;
    private String description;

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
    public Builder authentication(Authentication authentication) {
      this.authentication = authentication;
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
     * Sets the {@code availableToSettle} and returns a reference to this Builder enabling method chaining.
     *
     * @param availableToSettle the {@code availableToSettle} to set
     * @return a reference to this Builder
     */
    public Builder availableToSettle(Long availableToSettle) {
      this.availableToSettle = availableToSettle;
      return this;
    }

    /**
     * Sets the {@code childAccountNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param childAccountNum the {@code childAccountNum} to set
     * @return a reference to this Builder
     */
    public Builder childAccountNum(String childAccountNum) {
      this.childAccountNum = childAccountNum;
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
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(PaymentRequestStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code riskReasonCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param riskReasonCode the {@code riskReasonCode} to set
     * @return a reference to this Builder
     */
    public Builder riskReasonCode(List<Integer> riskReasonCode) {
      this.riskReasonCode = riskReasonCode;
      return this;
    }

    /**
     * Sets the {@code settlements} and returns a reference to this Builder enabling method chaining.
     *
     * @param settlements the {@code settlements} to set
     * @return a reference to this Builder
     */
    public Builder settlements(List<Settlement> settlements) {
      this.settlements = settlements;
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
     * Sets the {@code statusReason} and returns a reference to this Builder enabling method chaining.
     *
     * @param statusReason the {@code statusReason} to set
     * @return a reference to this Builder
     */
    public Builder statusReason(String statusReason) {
      this.statusReason = statusReason;
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
     * Sets the {@code availableToRefund} and returns a reference to this Builder enabling method chaining.
     *
     * @param availableToRefund the {@code availableToRefund} to set
     * @return a reference to this Builder
     */
    public Builder availableToRefund(Long availableToRefund) {
      this.availableToRefund = availableToRefund;
      return this;
    }

    /**
     * Sets the {@code processingRails} and returns a reference to this Builder enabling method chaining.
     *
     * @param processingRails the {@code processingRails} to set
     * @return a reference to this Builder
     */
    public Builder processingRails(ProcessingRails processingRails) {
      this.processingRails = processingRails;
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
     * Sets the {@code customerProfile} and returns a reference to this Builder enabling method chaining.
     *
     * @param customerProfile the {@code customerProfile} to set
     * @return a reference to this Builder
     */
    public Builder customerProfile(Profile customerProfile) {
      this.customerProfile = customerProfile;
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
     * Returns a {@code Payment} built from the parameters previously set.
     *
     * @return a {@code Payment} built with parameters of this {@code Payment.Builder}
     */
    public Payment build() {
      return new Payment(this);
    }
  }
}
