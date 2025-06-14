// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.originalcredit;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

/**
 * OriginalCredit
 */
public class OriginalCredit {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("description")
  private String description;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("paymentFacilitator")
  private PaymentFacilitator paymentFacilitator;
  @JsonProperty("id")
  private String id;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("status")
  private TransactionRequestStatus status;
  @JsonProperty("card")
  private Card card;
  @JsonProperty("cardSchemeTransactionId")
  private String cardSchemeTransactionId;

  public OriginalCredit() {
    super();
  }

  private OriginalCredit(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerIp(builder.customerIp);
    setDescription(builder.description);
    setMerchantDescriptor(builder.merchantDescriptor);
    setPaymentFacilitator(builder.paymentFacilitator);
    setId(builder.id);
    setPaymentType(builder.paymentType);
    setTxnTime(builder.txnTime);
    setBillingDetails(builder.billingDetails);
    setStatus(builder.status);
    setCard(builder.card);
    setCardSchemeTransactionId(builder.cardSchemeTransactionId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public OriginalCredit merchantRefNum(String merchantRefNum) {
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

  public OriginalCredit amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099.
   * <b>Note:</b> The amount specified in the Original Credit request must match the amount specified in the Payment Handle
   * request from which the paymentHandleToken is taken.  <br>
   * <p>
   * Maximum: 99999999999
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public OriginalCredit currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account, e.g., USD or CAD, returned in the request response.
   * <p>
   * See <a href="https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes">Currency Codes.</a> <br>
   * <b>Note:</b> The currencyCode specified in the Credit request must match the currencyCode specified in the Payment Handle request from
   * which the paymentHandleToken is taken.
   *
   * @return currencyCode
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public OriginalCredit paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used by merchants for Original Credit requests.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  public OriginalCredit customerIp(String customerIp) {
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

  public OriginalCredit description(String description) {
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

  public OriginalCredit merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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

  public OriginalCredit paymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
    return this;
  }

  /**
   * Contains information about Payment facilitator. <b>Note:</b> This object is only for Payment facilitator merchants.
   *
   * @return paymentFacilitator
   */
  public PaymentFacilitator getPaymentFacilitator() {
    return paymentFacilitator;
  }

  public void setPaymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
  }

  public OriginalCredit id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OriginalCredit paymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * Get paymentType. Possible value: CARD.
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public OriginalCredit txnTime(String txnTime) {
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

  public OriginalCredit billingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Customer's billing details. Required if AVS (Address verification) is enabled. <br>
   * If included in the request, this will serve as the billing address for transaction processing.  <br>
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

  public OriginalCredit status(TransactionRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the payment handle.
   * @return status
   */
  public TransactionRequestStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionRequestStatus status) {
    this.status = status;
  }

  public OriginalCredit card(Card card) {
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

  public String getCardSchemeTransactionId() {
    return cardSchemeTransactionId;
  }

  public void setCardSchemeTransactionId(String cardSchemeTransactionId) {
    this.cardSchemeTransactionId = cardSchemeTransactionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginalCredit originalCredit = (OriginalCredit) o;
    return Objects.equals(this.merchantRefNum, originalCredit.merchantRefNum) &&
        Objects.equals(this.amount, originalCredit.amount) &&
        Objects.equals(this.currencyCode, originalCredit.currencyCode) &&
        Objects.equals(this.paymentHandleToken, originalCredit.paymentHandleToken) &&
        Objects.equals(this.customerIp, originalCredit.customerIp) &&
        Objects.equals(this.description, originalCredit.description) &&
        Objects.equals(this.merchantDescriptor, originalCredit.merchantDescriptor) &&
        Objects.equals(this.paymentFacilitator, originalCredit.paymentFacilitator) &&
        Objects.equals(this.id, originalCredit.id) &&
        Objects.equals(this.paymentType, originalCredit.paymentType) &&
        Objects.equals(this.txnTime, originalCredit.txnTime) &&
        Objects.equals(this.billingDetails, originalCredit.billingDetails) &&
        Objects.equals(this.status, originalCredit.status) &&
        Objects.equals(this.card, originalCredit.card) &&
        Objects.equals(this.cardSchemeTransactionId, originalCredit.cardSchemeTransactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, currencyCode, paymentHandleToken, customerIp, description, merchantDescriptor, paymentFacilitator, id,
        paymentType, txnTime, billingDetails, status, card);
  }

  @Override
  public String toString() {

    return "class OriginalCredit {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    paymentFacilitator: " + toIndentedString(paymentFacilitator) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    cardSchemeTransactionId: " + toIndentedString(cardSchemeTransactionId) + "\n"
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
   * {@code OriginalCredit} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Integer amount;
    private String paymentHandleToken;
    private String customerIp;
    private String description;
    private MerchantDescriptor merchantDescriptor;
    private PaymentFacilitator paymentFacilitator;
    private String id;
    private PaymentType paymentType;
    private String txnTime;
    private BillingDetails billingDetails;
    private TransactionRequestStatus status;
    private Card card;
    private String cardSchemeTransactionId;

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
    public Builder amount(Integer amount) {
      this.amount = amount;
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
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(TransactionRequestStatus status) {
      this.status = status;
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
     * Sets the {@code cardSchemeTransactionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardSchemeTransactionId the {@code card} to set
     * @return a reference to this Builder
     */
    public Builder cardSchemeTransactionId(String cardSchemeTransactionId) {
      this.cardSchemeTransactionId = cardSchemeTransactionId;
      return this;
    }

    /**
     * Returns a {@code OriginalCredit} built from the parameters previously set.
     *
     * @return a {@code OriginalCredit} built with parameters of this {@code OriginalCredit.Builder}
     */
    public OriginalCredit build() {
      return new OriginalCredit(this);
    }
  }
}