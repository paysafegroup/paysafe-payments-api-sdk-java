// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.refund;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.lpm.Splitpay;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

/**
 * Represents the details of a Refund
 */
public class Refund extends BaseApiResponse {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay = null;
  @JsonProperty("id")
  private String id;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private TransactionRequestStatus status;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("source")
  private String source;
  @JsonProperty("childAccountNum")
  private String childAccountNum;
  @JsonProperty("riskReasonCode")
  private List<Integer> riskReasonCode = null;

  public Refund() {
    super();
  }

  private Refund(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSplitpay(builder.splitpay);
    setPaymentType(builder.paymentType);
    setCurrencyCode(builder.currencyCode);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setLiveMode(builder.liveMode);
    setGatewayResponse(builder.gatewayResponse);
    setSource(builder.source);
    setChildAccountNum(builder.childAccountNum);
    setError(builder.error);
    setRiskReasonCode(builder.riskReasonCode);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Refund merchantRefNum(String merchantRefNum) {
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

  public Refund amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099.  <br>
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

  public Refund dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate. A request is considered a duplicate if the merchantRefNum has already been used in a previous
   * request within the past 90 days.  <b>Note:</b> This value defaults to true.
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public Refund splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public Refund addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public Refund removeSplitpayItem(Splitpay splitpayItem) {
    if (splitpayItem != null && this.splitpay != null) {
      this.splitpay.remove(splitpayItem);
    }

    return this;
  }

  /**
   * Get splitpay
   *
   * @return splitpay
   */
  public List<Splitpay> getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
  }

  public Refund id(String id) {
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

  public Refund paymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type of the transaction.
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public Refund currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * This is the currency of the merchant account, e.g., USD or CAD.
   * See <a href="https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes">Currency Codes.</a>
   *
   * @return currencyCode
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Refund txnTime(String txnTime) {
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

  public Refund status(TransactionRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request.
   * @return status
   */
  public TransactionRequestStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionRequestStatus status) {
    this.status = status;
  }

  public Refund gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * Transaction identifier that can be used to reconcile this transaction with the provider gateway.
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }

  public Refund updatedTime(String updatedTime) {
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

  public Refund statusTime(String statusTime) {
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

  public Refund liveMode(Boolean liveMode) {
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

  public Refund gatewayResponse(GatewayResponse gatewayResponse) {
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

  public Refund source(String source) {
    this.source = source;
    return this;
  }

  /**
   * This is the source of the transaction. Possible value: SingleAPI
   *
   * @return source
   */
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Refund childAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
    return this;
  }

  /**
   * This is child merchant account number. It is returned only if the transaction was processed via a master account.
   *
   * @return childAccountNum
   */
  public String getChildAccountNum() {
    return childAccountNum;
  }

  public void setChildAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
  }

  public Refund riskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
    return this;
  }

  public Refund addRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (this.riskReasonCode == null) {
      this.riskReasonCode = new ArrayList<>();
    }
    this.riskReasonCode.add(riskReasonCodeItem);
    return this;
  }

  public Refund removeRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (riskReasonCodeItem != null && this.riskReasonCode != null) {
      this.riskReasonCode.remove(riskReasonCodeItem);
    }

    return this;
  }

  /**
   * An array of integers is returned, displaying the detailed Risk reason codes if your transaction was declined.
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Refund refund = (Refund) o;
    return Objects.equals(this.merchantRefNum, refund.merchantRefNum) &&
        Objects.equals(this.amount, refund.amount) &&
        Objects.equals(this.dupCheck, refund.dupCheck) &&
        Objects.equals(this.splitpay, refund.splitpay) &&
        Objects.equals(this.id, refund.id) &&
        Objects.equals(this.paymentType, refund.paymentType) &&
        Objects.equals(this.currencyCode, refund.currencyCode) &&
        Objects.equals(this.txnTime, refund.txnTime) &&
        Objects.equals(this.status, refund.status) &&
        Objects.equals(this.gatewayReconciliationId, refund.gatewayReconciliationId) &&
        Objects.equals(this.updatedTime, refund.updatedTime) &&
        Objects.equals(this.statusTime, refund.statusTime) &&
        Objects.equals(this.liveMode, refund.liveMode) &&
        Objects.equals(this.gatewayResponse, refund.gatewayResponse) &&
        Objects.equals(this.source, refund.source) &&
        Objects.equals(this.childAccountNum, refund.childAccountNum) &&
        Objects.equals(this.getError(), refund.getError()) &&
        Objects.equals(this.riskReasonCode, refund.riskReasonCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, splitpay, id, paymentType, currencyCode, txnTime, status, gatewayReconciliationId, updatedTime,
        statusTime, liveMode, gatewayResponse, source, childAccountNum, getError(), riskReasonCode);
  }

  @Override
  public String toString() {

    return "class Refund {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    source: " + toIndentedString(source) + "\n"
        + "    childAccountNum: " + toIndentedString(childAccountNum) + "\n"
        + "    error: " + toIndentedString(getError()) + "\n"
        + "    riskReasonCode: " + toIndentedString(riskReasonCode) + "\n"
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
   * {@code Refund} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Long amount;
    private Boolean dupCheck;
    private List<Splitpay> splitpay;
    private PaymentType paymentType;
    private CurrencyCode currencyCode;
    private String txnTime;
    private TransactionRequestStatus status;
    private String gatewayReconciliationId;
    private String updatedTime;
    private String statusTime;
    private Boolean liveMode;
    private GatewayResponse gatewayResponse;
    private String source;
    private String childAccountNum;
    private Error error;
    private List<Integer> riskReasonCode;

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
     * Sets the {@code splitpay} and returns a reference to this Builder enabling method chaining.
     *
     * @param splitpay the {@code splitpay} to set
     * @return a reference to this Builder
     */
    public Builder splitpay(List<Splitpay> splitpay) {
      this.splitpay = splitpay;
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
    public Builder status(TransactionRequestStatus status) {
      this.status = status;
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
     * Sets the {@code source} and returns a reference to this Builder enabling method chaining.
     *
     * @param source the {@code source} to set
     * @return a reference to this Builder
     */
    public Builder source(String source) {
      this.source = source;
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
     * Returns a {@code Refund} built from the parameters previously set.
     *
     * @return a {@code Refund} built with parameters of this {@code Refund.Builder}
     */
    public Refund build() {
      return new Refund(this);
    }
  }
}

