// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.CardWithOptionalNetworkTokenOrApplePay;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.threeds.NetworkTokenCardObjectAuthentication;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.ShippingDetails;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.paymenthandle.enums.Action;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleStatus;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleUsage;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

/**
 * CustomerPaymentHandle
 */
public class CustomerPaymentHandle {

  @JsonProperty("id")
  private String id;
  @JsonProperty("status")
  private PaymentHandleStatus status;
  @JsonProperty("usage")
  private PaymentHandleUsage usage;
  @JsonProperty("action")
  private Action action;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("customerId")
  private String customerId;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("billingDetailsId")
  private String billingDetailsId;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("card")
  private CardWithOptionalNetworkTokenOrApplePay card;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private NetworkTokenCardObjectAuthentication authentication;
  @JsonProperty("transactionIntent")
  private String transactionIntent;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("shippingDetails")
  private ShippingDetails shippingDetails;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates = null;
  @JsonProperty("sepa")
  private Sepa sepa;

  public CustomerPaymentHandle() {
    super();
  }

  private CustomerPaymentHandle(final Builder builder) {
    setId(builder.id);
    setStatus(builder.status);
    setUsage(builder.usage);
    setAction(builder.action);
    setCurrencyCode(builder.currencyCode);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerId(builder.customerId);
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setAmount(builder.amount);
    setCustomerIp(builder.customerIp);
    setBillingDetails(builder.billingDetails);
    setMerchantDescriptor(builder.merchantDescriptor);
    setBillingDetailsId(builder.billingDetailsId);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setCard(builder.card);
    setProfile(builder.profile);
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setTransactionIntent(builder.transactionIntent);
    setGatewayResponse(builder.gatewayResponse);
    setShippingDetails(builder.shippingDetails);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setAch(builder.ach);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CustomerPaymentHandle id(String id) {
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

  public CustomerPaymentHandle status(PaymentHandleStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request.
   *
   * @return status
   */
  public PaymentHandleStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentHandleStatus status) {
    this.status = status;
  }

  public CustomerPaymentHandle usage(PaymentHandleUsage usage) {
    this.usage = usage;
    return this;
  }

  /**
   * This specifies how the Payment Handle will be used for Payments.
   * <ul>
   * <li> SINGLE_USE - The Payment Handle can be used only for one time. </li>
   * <li> MULTI_USE - The Payment Handle can be used multiple times. </li>
   * </ul>
   * @return usage
   */
  public PaymentHandleUsage getUsage() {
    return usage;
  }

  public void setUsage(PaymentHandleUsage usage) {
    this.usage = usage;
  }

  public CustomerPaymentHandle action(Action action) {
    this.action = action;
    return this;
  }

  /**
   * The associated action that needs to be done by merchant for this handle.
   *
   * @return action
   */
  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public CustomerPaymentHandle currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account.
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

  public CustomerPaymentHandle paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used by merchants for Payment API requests, provided its status is PAYABLE.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  public CustomerPaymentHandle customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * The customer's profile Id to whom the payment handle is associated. This will be used to add a payment method to an existing customer.
   *
   * @return customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public CustomerPaymentHandle merchantRefNum(String merchantRefNum) {
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

  public CustomerPaymentHandle paymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type associated with the Payment Handle used for this request.
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public CustomerPaymentHandle amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. <b>Note:</b> This field is mandatory if transactionType is included.
   *
   * @return amount
   */
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public CustomerPaymentHandle customerIp(String customerIp) {
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

  public CustomerPaymentHandle billingDetails(BillingDetails billingDetails) {
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

  public CustomerPaymentHandle merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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

  public CustomerPaymentHandle billingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
    return this;
  }

  /**
   * This is the ID returned in the response to the address creation request (/operations/create-address).
   *
   * @return billingDetailsId
   */
  public String getBillingDetailsId() {
    return billingDetailsId;
  }

  public void setBillingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
  }

  public CustomerPaymentHandle paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * The response returns the original value from the request. This is used in Saved card flow.
   * You will pass this parameter when you want to create single use payment handle using the Saved-card (card-on-file) present in Paysafe customer vault.
   *  <br>
   * This is an existing Customer Payment Handle from which the payment instrument details and profile details are retrieved.  <br>
   * If this parameter is included then you can omit the billingDetails object. If you send a new billingDetails then same will be considered
   * for the transaction, however no change will be made in the billingDetails present against the Saved-card in customer vault.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public CustomerPaymentHandle card(CardWithOptionalNetworkTokenOrApplePay card) {
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

  public CustomerPaymentHandle threeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
    return this;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public ShippingDetails getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
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

  public CustomerPaymentHandle authentication(NetworkTokenCardObjectAuthentication authentication) {
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

  public CustomerPaymentHandle transactionIntent(String transactionIntent) {
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
   * for more information.     *
   *
   * @return transactionIntent
   */
  public String getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
  }

  public CustomerPaymentHandle gatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

  /**
   * This is the read-only raw response returned by an acquirer or PSP.
   *
   * @return gatewayResponse
   */
  public GatewayResponse getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }

  public CustomerPaymentHandle eft(Eft eft) {
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

  public CustomerPaymentHandle dupCheck(Boolean dupCheck) {
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

  public CustomerPaymentHandle ach(Ach ach) {
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

  public CustomerPaymentHandle bacs(Bacs bacs) {
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

  public CustomerPaymentHandle mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public CustomerPaymentHandle addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public CustomerPaymentHandle removeMandatesItem(Mandate mandatesItem) {
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

  public CustomerPaymentHandle sepa(Sepa sepa) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPaymentHandle customerPaymentHandle = (CustomerPaymentHandle) o;
    return Objects.equals(this.id, customerPaymentHandle.id) &&
        Objects.equals(this.status, customerPaymentHandle.status) &&
        Objects.equals(this.usage, customerPaymentHandle.usage) &&
        Objects.equals(this.action, customerPaymentHandle.action) &&
        Objects.equals(this.currencyCode, customerPaymentHandle.currencyCode) &&
        Objects.equals(this.paymentHandleToken, customerPaymentHandle.paymentHandleToken) &&
        Objects.equals(this.customerId, customerPaymentHandle.customerId) &&
        Objects.equals(this.merchantRefNum, customerPaymentHandle.merchantRefNum) &&
        Objects.equals(this.paymentType, customerPaymentHandle.paymentType) &&
        Objects.equals(this.amount, customerPaymentHandle.amount) &&
        Objects.equals(this.customerIp, customerPaymentHandle.customerIp) &&
        Objects.equals(this.billingDetails, customerPaymentHandle.billingDetails) &&
        Objects.equals(this.merchantDescriptor, customerPaymentHandle.merchantDescriptor) &&
        Objects.equals(this.billingDetailsId, customerPaymentHandle.billingDetailsId) &&
        Objects.equals(this.paymentHandleTokenFrom, customerPaymentHandle.paymentHandleTokenFrom) &&
        Objects.equals(this.card, customerPaymentHandle.card) &&
        Objects.equals(this.threeDs, customerPaymentHandle.threeDs) &&
        Objects.equals(this.authentication, customerPaymentHandle.authentication) &&
        Objects.equals(this.transactionIntent, customerPaymentHandle.transactionIntent) &&
        Objects.equals(this.gatewayResponse, customerPaymentHandle.gatewayResponse) &&
        Objects.equals(this.shippingDetails, customerPaymentHandle.shippingDetails) &&
        Objects.equals(this.profile, customerPaymentHandle.profile) &&
        Objects.equals(this.eft, customerPaymentHandle.eft) &&
        Objects.equals(this.dupCheck, customerPaymentHandle.dupCheck) &&
        Objects.equals(this.ach, customerPaymentHandle.ach) &&
        Objects.equals(this.bacs, customerPaymentHandle.bacs) &&
        Objects.equals(this.mandates, customerPaymentHandle.mandates) &&
        Objects.equals(this.sepa, customerPaymentHandle.sepa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, usage, action, currencyCode, paymentHandleToken, customerId, merchantRefNum, paymentType, amount, customerIp,
        billingDetails, merchantDescriptor, billingDetailsId, paymentHandleTokenFrom, card, threeDs, authentication, transactionIntent, gatewayResponse,
        eft, dupCheck, ach, bacs, mandates, sepa);
  }

  @Override
  public String toString() {

    return "class CustomerPaymentHandle {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    usage: " + toIndentedString(usage) + "\n"
        + "    action: " + toIndentedString(action) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerId: " + toIndentedString(customerId) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    billingDetailsId: " + toIndentedString(billingDetailsId) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    shippingDetails: " + toIndentedString(shippingDetails) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
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
   * {@code CustomerPaymentHandle} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private PaymentHandleStatus status;
    private PaymentHandleUsage usage;
    private Action action;
    private CurrencyCode currencyCode;
    private String paymentHandleToken;
    private String customerId;
    private String merchantRefNum;
    private PaymentType paymentType;
    private Long amount;
    private String customerIp;
    private BillingDetails billingDetails;
    private MerchantDescriptor merchantDescriptor;
    private String billingDetailsId;
    private String paymentHandleTokenFrom;
    private CardWithOptionalNetworkTokenOrApplePay card;
    private Profile profile;
    private ThreeDs threeDs;
    private NetworkTokenCardObjectAuthentication authentication;
    private String transactionIntent;
    private GatewayResponse gatewayResponse;
    private ShippingDetails shippingDetails;
    private Eft eft;
    private Boolean dupCheck;
    private Ach ach;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;

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
    public Builder status(PaymentHandleStatus status) {
      this.status = status;
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
     * Sets the {@code billingDetailsId} and returns a reference to this Builder enabling method chaining.
     *
     * @param billingDetailsId the {@code billingDetailsId} to set
     * @return a reference to this Builder
     */
    public Builder billingDetailsId(String billingDetailsId) {
      this.billingDetailsId = billingDetailsId;
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
     * Sets the {@code card} and returns a reference to this Builder enabling method chaining.
     *
     * @param profile the {@code card} to set
     * @return a reference to this Builder
     */
    public Builder profile(Profile profile) {
      this.profile = profile;
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
     * Returns a {@code CustomerPaymentHandle} built from the parameters previously set.
     *
     * @return a {@code CustomerPaymentHandle} built with parameters of this {@code CustomerPaymentHandle.Builder}
     */
    public CustomerPaymentHandle build() {
      return new CustomerPaymentHandle(this);
    }
  }
}

