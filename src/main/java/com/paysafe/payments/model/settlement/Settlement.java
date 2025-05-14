// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.settlement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.enums.CreditRequestStatus;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.lpm.Splitpay;
import com.paysafe.payments.model.settlement.enums.SettlementPaymentType;

/**
 * Represents the details of a settlement transaction, including payment type, amount available for refund, transaction time, status and other related fields.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Settlement extends BaseApiResponse {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay = null;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  @JsonProperty("id")
  private String id;
  @JsonProperty("paymentType")
  private SettlementPaymentType paymentType;
  @JsonProperty("availableToRefund")
  private Long availableToRefund;
  @JsonProperty("childAccountNum")
  private String childAccountNum;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private CreditRequestStatus status;
  @JsonProperty("error")
  private Error error;
  @JsonProperty("riskReasonCode")
  private List<Integer> riskReasonCode = null;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;

  public Settlement() {
    super();
  }

  private Settlement(final Builder builder) {
    setError(builder.error);
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSplitpay(builder.splitpay);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setId(builder.id);
    setPaymentType(builder.paymentType);
    setAvailableToRefund(builder.availableToRefund);
    setChildAccountNum(builder.childAccountNum);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setError(builder.error);
    setRiskReasonCode(builder.riskReasonCode);
    setGatewayResponse(builder.gatewayResponse);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setLiveMode(builder.liveMode);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Settlement merchantRefNum(String merchantRefNum) {
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

  public Settlement amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units.For example, to process US $10.99, this value should be 1099. <br />
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

  public Settlement dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate. A request is considered a duplicate if the merchantRefNum has already been used in a previous
   * request within the past 90 days. <b>Note:<b> This value defaults to true
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public Settlement splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public Settlement addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public Settlement removeSplitpayItem(Splitpay splitpayItem) {
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

  public Settlement airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
    return this;
  }

  /**
   * Contains information about your airline travel. <br /> <b>Note:</b> This object is only for Airline Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return airlineTravelDetails
   */
  public AirlineTravelDetails getAirlineTravelDetails() {
    return airlineTravelDetails;
  }

  public void setAirlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
  }

  public Settlement cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
    return this;
  }

  /**
   * Contains information about your cruise line travel. <br /> <b>Note:</b> This object is only for Cruise line Merchants.
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

  public Settlement lodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
    return this;
  }

  /**
   * Contains information about lodging details.  <br /> <b>Note:</b> This object is only for Airline Merchants.
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

  public Settlement carRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
    return this;
  }

  /**
   * Contains information about your car rental. <br />
   * <b>Note:<b> This object is only for Car rental Merchants.<br />
   * <b>Note:<b> This field has to be passed only in case of card transactions.
   *
   * @return carRentalDetails
   */
  public CarRentalDetails getCarRentalDetails() {
    return carRentalDetails;
  }

  public void setCarRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
  }

  public Settlement id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated request.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Settlement paymentType(SettlementPaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type associated with the settlement used for this request.
   *
   * @return paymentType
   */
  public SettlementPaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(SettlementPaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public Settlement availableToRefund(Long availableToRefund) {
    this.availableToRefund = availableToRefund;
    return this;
  }

  /**
   * This is the remaining amount of the refund, in minor units.99. <br />
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

  public Settlement childAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
    return this;
  }

  /**
   * This is the child merchant account number. It is returned only if the transaction was processed via a master account.
   *
   * @return childAccountNum
   */
  public String getChildAccountNum() {
    return childAccountNum;
  }

  public void setChildAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
  }

  public Settlement txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * This is the date and time the request was processed. For example: 2014-01-26T10:32:28Z
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }

  public Settlement status(CreditRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request. Possible values are: <br />
   * • RECEIVED – Our system has received the request and is waiting for the downstream processor’s response. <br />
   * • INITIATED – The transaction was initiated with the downstream provider. <br />
   * • PENDING - The transaction is awaiting the payment service provider's response. <br />
   * • FAILED – The transaction failed, due to either an error or being declined. <br />
   * • CANCELLED – The transaction request is cancelled. <br />
   * • EXPIRED – The transaction request is expired. <br />
   * • COMPLETED – The transaction request is completed. <br />
   * <p>
   *
   * @return status
   */
  public CreditRequestStatus getStatus() {
    return status;
  }

  public void setStatus(CreditRequestStatus status) {
    this.status = status;
  }

  public Settlement riskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
    return this;
  }

  public Settlement addRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (this.riskReasonCode == null) {
      this.riskReasonCode = new ArrayList<>();
    }
    this.riskReasonCode.add(riskReasonCodeItem);
    return this;
  }

  public Settlement removeRiskReasonCodeItem(Integer riskReasonCodeItem) {
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

  public Settlement gatewayResponse(GatewayResponse gatewayResponse) {
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

  public Settlement gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * It is the id which is common between paysafe and payment serivce provider.
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }

  public Settlement liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * This flag indicates the envrionment.  - true - Production - false - Non-Production
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }

  public Settlement updatedTime(String updatedTime) {
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

  public Settlement statusTime(String statusTime) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Settlement settlement = (Settlement) o;
    return Objects.equals(this.merchantRefNum, settlement.merchantRefNum) &&
        Objects.equals(this.amount, settlement.amount) &&
        Objects.equals(this.dupCheck, settlement.dupCheck) &&
        Objects.equals(this.splitpay, settlement.splitpay) &&
        Objects.equals(this.airlineTravelDetails, settlement.airlineTravelDetails) &&
        Objects.equals(this.cruiselineTravelDetails, settlement.cruiselineTravelDetails) &&
        Objects.equals(this.lodgingDetails, settlement.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, settlement.carRentalDetails) &&
        Objects.equals(this.id, settlement.id) &&
        Objects.equals(this.paymentType, settlement.paymentType) &&
        Objects.equals(this.availableToRefund, settlement.availableToRefund) &&
        Objects.equals(this.childAccountNum, settlement.childAccountNum) &&
        Objects.equals(this.txnTime, settlement.txnTime) &&
        Objects.equals(this.status, settlement.status) &&
        Objects.equals(this.error, settlement.error) &&
        Objects.equals(this.riskReasonCode, settlement.riskReasonCode) &&
        Objects.equals(this.gatewayResponse, settlement.gatewayResponse) &&
        Objects.equals(this.gatewayReconciliationId, settlement.gatewayReconciliationId) &&
        Objects.equals(this.liveMode, settlement.liveMode) &&
        Objects.equals(this.updatedTime, settlement.updatedTime) &&
        Objects.equals(this.statusTime, settlement.statusTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, splitpay, airlineTravelDetails, cruiselineTravelDetails, lodgingDetails, carRentalDetails,
        id, paymentType, availableToRefund, childAccountNum, txnTime, status, error, riskReasonCode, gatewayResponse, gatewayReconciliationId, liveMode,
        updatedTime, statusTime);
  }

  @Override
  public String toString() {

    return "class Settlement {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    availableToRefund: " + toIndentedString(availableToRefund) + "\n"
        + "    childAccountNum: " + toIndentedString(childAccountNum) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    error: " + toIndentedString(error) + "\n"
        + "    riskReasonCode: " + toIndentedString(riskReasonCode) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
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
   * {@code Settlement} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Long amount;
    private Boolean dupCheck = true;
    private List<Splitpay> splitpay;
    private AirlineTravelDetails airlineTravelDetails;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private String id;
    private SettlementPaymentType paymentType;
    private Long availableToRefund;
    private String childAccountNum;
    private String txnTime;
    private CreditRequestStatus status;
    private Error error;
    private List<Integer> riskReasonCode;
    private GatewayResponse gatewayResponse;
    private String gatewayReconciliationId;
    private Boolean liveMode;
    private String updatedTime;
    private String statusTime;

    private Builder() {
    }

    /**
     * Sets the merchant reference number.
     *
     * @param merchantRefNum Merchant reference number.
     * @return Builder instance.
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * Sets the amount.
     *
     * @param amount Amount value.
     * @return Builder instance.
     */
    public Builder amount(Long amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Sets the duplicate check flag.
     *
     * @param dupCheck Duplicate check flag.
     * @return Builder instance.
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * Sets the split pay details.
     *
     * @param splitpay List of split pay details.
     * @return Builder instance.
     */
    public Builder splitpay(List<Splitpay> splitpay) {
      this.splitpay = splitpay;
      return this;
    }

    /**
     * Sets airline travel details.
     *
     * @param airlineTravelDetails Airline travel details.
     * @return Builder instance.
     */
    public Builder airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
      this.airlineTravelDetails = airlineTravelDetails;
      return this;
    }

    /**
     * Sets cruise line travel details.
     *
     * @param cruiselineTravelDetails Cruise line travel details.
     * @return Builder instance.
     */
    public Builder cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
      this.cruiselineTravelDetails = cruiselineTravelDetails;
      return this;
    }

    /**
     * Sets lodging details.
     *
     * @param lodgingDetails Lodging details.
     * @return Builder instance.
     */
    public Builder lodgingDetails(LodgingDetails lodgingDetails) {
      this.lodgingDetails = lodgingDetails;
      return this;
    }

    /**
     * Sets car rental details.
     *
     * @param carRentalDetails Car rental details.
     * @return Builder instance.
     */
    public Builder carRentalDetails(CarRentalDetails carRentalDetails) {
      this.carRentalDetails = carRentalDetails;
      return this;
    }

    /**
     * Sets the settlement ID.
     *
     * @param id Settlement ID.
     * @return Builder instance.
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the payment type.
     *
     * @param paymentType Payment type.
     * @return Builder instance.
     */
    public Builder paymentType(SettlementPaymentType paymentType) {
      this.paymentType = paymentType;
      return this;
    }

    /**
     * Sets the available refund amount.
     *
     * @param availableToRefund Refund amount available.
     * @return Builder instance.
     */
    public Builder availableToRefund(Long availableToRefund) {
      this.availableToRefund = availableToRefund;
      return this;
    }

    /**
     * Sets the child account number.
     *
     * @param childAccountNum Child account number.
     * @return Builder instance.
     */
    public Builder childAccountNum(String childAccountNum) {
      this.childAccountNum = childAccountNum;
      return this;
    }

    /**
     * Sets transaction time.
     *
     * @param txnTime Transaction time.
     * @return Builder instance.
     */
    public Builder txnTime(String txnTime) {
      this.txnTime = txnTime;
      return this;
    }

    /**
     * Sets the settlement status.
     *
     * @param status Settlement status.
     * @return Builder instance.
     */
    public Builder status(CreditRequestStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets error details.
     *
     * @param error Error details.
     * @return Builder instance.
     */
    public Builder error(Error error) {
      this.error = error;
      return this;
    }

    /**
     * Sets risk reason codes.
     *
     * @param riskReasonCode List of risk reason codes.
     * @return Builder instance.
     */
    public Builder riskReasonCode(List<Integer> riskReasonCode) {
      this.riskReasonCode = riskReasonCode;
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
     * Builds a new {@code Settlement} instance using the configured values.
     *
     * @return A new Settlement instance.
     */
    public Settlement build() {
      return new Settlement(this);
    }
  }
}

