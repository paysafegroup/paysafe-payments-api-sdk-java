// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.AvsResponse;
import com.paysafe.payments.model.common.enums.CvvVerification;
import com.paysafe.payments.model.common.enums.NameVerification;

/**
 * This is the read-only raw response returned by an acquirer or PSP.
 */
public class GatewayResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("processor")
  private String processor;
  @JsonProperty("code")
  private String code;
  @JsonProperty("responseCode")
  private String responseCode;
  @JsonProperty("responseCodeDescription")
  private String responseCodeDescription;
  @JsonProperty("avsCode")
  private String avsCode;
  @JsonProperty("avsResponse")
  private AvsResponse avsResponse;
  @JsonProperty("nameVerification")
  private NameVerification nameVerification;
  @JsonProperty("firstNameVerification")
  private NameVerification firstNameVerification;
  @JsonProperty("lastNameVerification")
  private NameVerification lastNameVerification;
  @JsonProperty("balanceResponse")
  private String balanceResponse;
  @JsonProperty("mid")
  private String mid;
  @JsonProperty("terminalId")
  private String terminalId;
  @JsonProperty("batchNumber")
  private String batchNumber;
  @JsonProperty("seqNumber")
  private String seqNumber;
  @JsonProperty("effectiveDate")
  private String effectiveDate;
  @JsonProperty("financingType")
  private String financingType;
  @JsonProperty("plan")
  private String plan;
  @JsonProperty("gracePeriod")
  private String gracePeriod;
  @JsonProperty("term")
  private String term;
  @JsonProperty("responseId")
  private String responseId;
  @JsonProperty("requestId")
  private String requestId;
  @JsonProperty("description")
  private String description;
  @JsonProperty("authCode")
  private String authCode;
  @JsonProperty("txnDateTime")
  private String txnDateTime;
  @JsonProperty("referenceNbr")
  private String referenceNbr;
  @JsonProperty("responseReasonCode")
  private String responseReasonCode;
  @JsonProperty("cvvVerification")
  private CvvVerification cvvVerification;
  @JsonProperty("cvv2Result")
  private String cvv2Result;
  @JsonProperty("status")
  private String status;
  @JsonProperty("orderId")
  private String orderId;
  @JsonProperty("operationId")
  private String operationId;

  public GatewayResponse() {
    super();
  }

  private GatewayResponse(Builder builder) {
    setId(builder.id);
    setProcessor(builder.processor);
    setCode(builder.code);
    setResponseCode(builder.responseCode);
    setResponseCodeDescription(builder.responseCodeDescription);
    setAvsCode(builder.avsCode);
    setAvsResponse(builder.avsResponse);
    setNameVerification(builder.nameVerification);
    setFirstNameVerification(builder.firstNameVerification);
    setLastNameVerification(builder.lastNameVerification);
    setBalanceResponse(builder.balanceResponse);
    setMid(builder.mid);
    setTerminalId(builder.terminalId);
    setBatchNumber(builder.batchNumber);
    setSeqNumber(builder.seqNumber);
    setEffectiveDate(builder.effectiveDate);
    setFinancingType(builder.financingType);
    setPlan(builder.plan);
    setGracePeriod(builder.gracePeriod);
    setTerm(builder.term);
    setResponseId(builder.responseId);
    setRequestId(builder.requestId);
    setDescription(builder.description);
    setAuthCode(builder.authCode);
    setTxnDateTime(builder.txnDateTime);
    setReferenceNbr(builder.referenceNbr);
    setResponseReasonCode(builder.responseReasonCode);
    setCvvVerification(builder.cvvVerification);
    setCvv2Result(builder.cvv2Result);
    setStatus(builder.status);
    setOrderId(builder.orderId);
    setOperationId(builder.operationId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public GatewayResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the response id returned by the processor
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GatewayResponse processor(String processor) {
    this.processor = processor;
    return this;
  }

  /**
   * This is the processor code of the transaction at Paysafe side
   *
   * @return processor
   */
  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public GatewayResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * This is acquirer identification code, such as VPS, GPS, etc.
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GatewayResponse responseCode(String responseCode) {
    this.responseCode = responseCode;
    return this;
  }

  /**
   * This is the raw response returned by the acquirer.
   *
   * @return responseCode
   */
  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public GatewayResponse responseCodeDescription(String responseCodeDescription) {
    this.responseCodeDescription = responseCodeDescription;
    return this;
  }

  /**
   * This is the raw response code description returned by the acquirer.
   *
   * @return responseCodeDescription
   */
  public String getResponseCodeDescription() {
    return responseCodeDescription;
  }

  public void setResponseCodeDescription(String responseCodeDescription) {
    this.responseCodeDescription = responseCodeDescription;
  }

  public GatewayResponse avsCode(String avsCode) {
    this.avsCode = avsCode;
    return this;
  }

  /**
   * This is the raw AVS code returned by the acquirer.
   *
   * @return avsCode
   */
  public String getAvsCode() {
    return avsCode;
  }

  public void setAvsCode(String avsCode) {
    this.avsCode = avsCode;
  }

  public GatewayResponse avsResponse(AvsResponse avsResponse) {
    this.avsResponse = avsResponse;
    return this;
  }

  /**
   * This is the AVS response returned from the card issuer.
   *
   * @return avsResponse
   */
  public AvsResponse getAvsResponse() {
    return avsResponse;
  }

  public void setAvsResponse(AvsResponse avsResponse) {
    this.avsResponse = avsResponse;
  }

  public GatewayResponse nameVerification(NameVerification nameVerification) {
    this.nameVerification = nameVerification;
    return this;
  }

  /**
   * This is the account name inquiry full name set result returned by the acquirer.
   *
   * @return nameVerification
   */
  public NameVerification getNameVerification() {
    return nameVerification;
  }

  public void setNameVerification(NameVerification nameVerification) {
    this.nameVerification = nameVerification;
  }

  public GatewayResponse firstNameVerification(NameVerification firstNameVerification) {
    this.firstNameVerification = firstNameVerification;
    return this;
  }

  /**
   * This is the account name inquiry first name result returned by the acquirer.
   *
   * @return firstNameVerification
   */
  public NameVerification getFirstNameVerification() {
    return firstNameVerification;
  }

  public void setFirstNameVerification(NameVerification firstNameVerification) {
    this.firstNameVerification = firstNameVerification;
  }

  public GatewayResponse lastNameVerification(NameVerification lastNameVerification) {
    this.lastNameVerification = lastNameVerification;
    return this;
  }

  /**
   * This is the account name inquiry for the last name returned by the acquirer.
   *
   * @return lastNameVerification
   */
  public NameVerification getLastNameVerification() {
    return lastNameVerification;
  }

  public void setLastNameVerification(NameVerification lastNameVerification) {
    this.lastNameVerification = lastNameVerification;
  }

  public GatewayResponse balanceResponse(String balanceResponse) {
    this.balanceResponse = balanceResponse;
    return this;
  }

  /**
   * This is the balance remaining on a gift card, if a gift card was used for the original transaction.
   *
   * @return balanceResponse
   */
  public String getBalanceResponse() {
    return balanceResponse;
  }

  public void setBalanceResponse(String balanceResponse) {
    this.balanceResponse = balanceResponse;
  }

  public GatewayResponse mid(String mid) {
    this.mid = mid;
    return this;
  }

  /**
   * This is the acquirer MID that was sent to the clearing house.
   *
   * @return mid
   */
  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  public GatewayResponse terminalId(String terminalId) {
    this.terminalId = terminalId;
    return this;
  }

  /**
   * This is the merchant's terminal ID.
   *
   * @return terminalId
   */
  public String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }

  public GatewayResponse batchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
    return this;
  }

  /**
   * This is the batch number.
   *
   * @return batchNumber
   */
  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public GatewayResponse seqNumber(String seqNumber) {
    this.seqNumber = seqNumber;
    return this;
  }

  /**
   * This is the merchant's sequence number.
   *
   * @return seqNumber
   */
  public String getSeqNumber() {
    return seqNumber;
  }

  public void setSeqNumber(String seqNumber) {
    this.seqNumber = seqNumber;
  }

  public GatewayResponse effectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

  /**
   * This is the date of the bank deposit associated  with the transaction.
   *
   * @return effectiveDate
   */
  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public GatewayResponse financingType(String financingType) {
    this.financingType = financingType;
    return this;
  }

  /**
   * This is the type of financing offered.
   *
   * @return financingType
   */
  public String getFinancingType() {
    return financingType;
  }

  public void setFinancingType(String financingType) {
    this.financingType = financingType;
  }

  public GatewayResponse plan(String plan) {
    this.plan = plan;
    return this;
  }

  /**
   * This is the plan number for this financing  transaction.
   *
   * @return plan
   */
  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public GatewayResponse gracePeriod(String gracePeriod) {
    this.gracePeriod = gracePeriod;
    return this;
  }

  /**
   * This is the grace period, in months, associated  with deferred payment transactions.
   *
   * @return gracePeriod
   */
  public String getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(String gracePeriod) {
    this.gracePeriod = gracePeriod;
  }

  public GatewayResponse term(String term) {
    this.term = term;
    return this;
  }

  /**
   * This is the number of payments, in months, for  equal payment transactions.
   *
   * @return term
   */
  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public GatewayResponse responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * This is the response ID assigned by Credorax.
   *
   * @return responseId
   */
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public GatewayResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * This is the request ID assigned by Paysafe.
   *
   * @return requestId
   */
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public GatewayResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * This is a description of the response.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GatewayResponse authCode(String authCode) {
    this.authCode = authCode;
    return this;
  }

  /**
   * This is the authorization code.
   *
   * @return authCode
   */
  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public GatewayResponse txnDateTime(String txnDateTime) {
    this.txnDateTime = txnDateTime;
    return this;
  }

  /**
   * This is the transaction date and time.
   *
   * @return txnDateTime
   */
  public String getTxnDateTime() {
    return txnDateTime;
  }

  public void setTxnDateTime(String txnDateTime) {
    this.txnDateTime = txnDateTime;
  }

  public GatewayResponse referenceNbr(String referenceNbr) {
    this.referenceNbr = referenceNbr;
    return this;
  }

  /**
   * This is the Bank net transaction ID/Merch Tran Ref
   *
   * @return referenceNbr
   */
  public String getReferenceNbr() {
    return referenceNbr;
  }

  public void setReferenceNbr(String referenceNbr) {
    this.referenceNbr = referenceNbr;
  }

  public GatewayResponse responseReasonCode(String responseReasonCode) {
    this.responseReasonCode = responseReasonCode;
    return this;
  }

  /**
   * This is the raw response reason code returned by  Credorax.
   *
   * @return responseReasonCode
   */
  public String getResponseReasonCode() {
    return responseReasonCode;
  }

  public void setResponseReasonCode(String responseReasonCode) {
    this.responseReasonCode = responseReasonCode;
  }

  public GatewayResponse cvvVerification(CvvVerification cvvVerification) {
    this.cvvVerification = cvvVerification;
    return this;
  }

  /**
   * This is the response to the cvv submitted with the transaction request.
   *
   * @return cvvVerification
   */
  public CvvVerification getCvvVerification() {
    return cvvVerification;
  }

  public void setCvvVerification(CvvVerification cvvVerification) {
    this.cvvVerification = cvvVerification;
  }

  public GatewayResponse cvv2Result(String cvv2Result) {
    this.cvv2Result = cvv2Result;
    return this;
  }

  /**
   * This is the raw cvv2 result code.
   *
   * @return cvv2Result
   */
  public String getCvv2Result() {
    return cvv2Result;
  }

  public void setCvv2Result(String cvv2Result) {
    this.cvv2Result = cvv2Result;
  }

  public GatewayResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction at the processor side.
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GatewayResponse orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Unique NETELLER reference for the order.
   *
   * @return orderId
   */
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public GatewayResponse operationId(String operationId) {
    this.operationId = operationId;
    return this;
  }

  /**
   * It is a transaction identifier at Safetypay.
   *
   * @return operationId
   */
  public String getOperationId() {
    return operationId;
  }

  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GatewayResponse gatewayResponse = (GatewayResponse) o;
    return Objects.equals(this.id, gatewayResponse.id) &&
        Objects.equals(this.processor, gatewayResponse.processor) &&
        Objects.equals(this.code, gatewayResponse.code) &&
        Objects.equals(this.responseCode, gatewayResponse.responseCode) &&
        Objects.equals(this.responseCodeDescription, gatewayResponse.responseCodeDescription) &&
        Objects.equals(this.avsCode, gatewayResponse.avsCode) &&
        Objects.equals(this.avsResponse, gatewayResponse.avsResponse) &&
        Objects.equals(this.nameVerification, gatewayResponse.nameVerification) &&
        Objects.equals(this.firstNameVerification, gatewayResponse.firstNameVerification) &&
        Objects.equals(this.lastNameVerification, gatewayResponse.lastNameVerification) &&
        Objects.equals(this.balanceResponse, gatewayResponse.balanceResponse) &&
        Objects.equals(this.mid, gatewayResponse.mid) &&
        Objects.equals(this.terminalId, gatewayResponse.terminalId) &&
        Objects.equals(this.batchNumber, gatewayResponse.batchNumber) &&
        Objects.equals(this.seqNumber, gatewayResponse.seqNumber) &&
        Objects.equals(this.effectiveDate, gatewayResponse.effectiveDate) &&
        Objects.equals(this.financingType, gatewayResponse.financingType) &&
        Objects.equals(this.plan, gatewayResponse.plan) &&
        Objects.equals(this.gracePeriod, gatewayResponse.gracePeriod) &&
        Objects.equals(this.term, gatewayResponse.term) &&
        Objects.equals(this.responseId, gatewayResponse.responseId) &&
        Objects.equals(this.requestId, gatewayResponse.requestId) &&
        Objects.equals(this.description, gatewayResponse.description) &&
        Objects.equals(this.authCode, gatewayResponse.authCode) &&
        Objects.equals(this.txnDateTime, gatewayResponse.txnDateTime) &&
        Objects.equals(this.referenceNbr, gatewayResponse.referenceNbr) &&
        Objects.equals(this.responseReasonCode, gatewayResponse.responseReasonCode) &&
        Objects.equals(this.cvvVerification, gatewayResponse.cvvVerification) &&
        Objects.equals(this.cvv2Result, gatewayResponse.cvv2Result) &&
        Objects.equals(this.status, gatewayResponse.status) &&
        Objects.equals(this.orderId, gatewayResponse.orderId) &&
        Objects.equals(this.operationId, gatewayResponse.operationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, processor, code, responseCode, responseCodeDescription, avsCode, avsResponse, nameVerification, firstNameVerification,
        lastNameVerification, balanceResponse, mid, terminalId, batchNumber, seqNumber, effectiveDate, financingType, plan, gracePeriod, term, responseId,
        requestId, description, authCode, txnDateTime, referenceNbr, responseReasonCode, cvvVerification, cvv2Result, status, orderId, operationId);
  }

  @Override
  public String toString() {

    return "class GatewayResponse {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    processor: " + toIndentedString(processor) + "\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    responseCode: " + toIndentedString(responseCode) + "\n"
        + "    responseCodeDescription: " + toIndentedString(responseCodeDescription) + "\n"
        + "    avsCode: " + toIndentedString(avsCode) + "\n"
        + "    avsResponse: " + toIndentedString(avsResponse) + "\n"
        + "    nameVerification: " + toIndentedString(nameVerification) + "\n"
        + "    firstNameVerification: " + toIndentedString(firstNameVerification) + "\n"
        + "    lastNameVerification: " + toIndentedString(lastNameVerification) + "\n"
        + "    balanceResponse: " + toIndentedString(balanceResponse) + "\n"
        + "    mid: " + toIndentedString(mid) + "\n"
        + "    terminalId: " + toIndentedString(terminalId) + "\n"
        + "    batchNumber: " + toIndentedString(batchNumber) + "\n"
        + "    seqNumber: " + toIndentedString(seqNumber) + "\n"
        + "    effectiveDate: " + toIndentedString(effectiveDate) + "\n"
        + "    financingType: " + toIndentedString(financingType) + "\n"
        + "    plan: " + toIndentedString(plan) + "\n"
        + "    gracePeriod: " + toIndentedString(gracePeriod) + "\n"
        + "    term: " + toIndentedString(term) + "\n"
        + "    responseId: " + toIndentedString(responseId) + "\n"
        + "    requestId: " + toIndentedString(requestId) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    authCode: " + toIndentedString(authCode) + "\n"
        + "    txnDateTime: " + toIndentedString(txnDateTime) + "\n"
        + "    referenceNbr: " + toIndentedString(referenceNbr) + "\n"
        + "    responseReasonCode: " + toIndentedString(responseReasonCode) + "\n"
        + "    cvvVerification: " + toIndentedString(cvvVerification) + "\n"
        + "    cvv2Result: " + toIndentedString(cvv2Result) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    orderId: " + toIndentedString(orderId) + "\n"
        + "    operationId: " + toIndentedString(operationId) + "\n"
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
   * {@code GatewayResponse} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String processor;
    private String code;
    private String responseCode;
    private String responseCodeDescription;
    private String avsCode;
    private AvsResponse avsResponse;
    private NameVerification nameVerification;
    private NameVerification firstNameVerification;
    private NameVerification lastNameVerification;
    private String balanceResponse;
    private String mid;
    private String terminalId;
    private String batchNumber;
    private String seqNumber;
    private String effectiveDate;
    private String financingType;
    private String plan;
    private String gracePeriod;
    private String term;
    private String responseId;
    private String requestId;
    private String description;
    private String authCode;
    private String txnDateTime;
    private String referenceNbr;
    private String responseReasonCode;
    private CvvVerification cvvVerification;
    private String cvv2Result;
    private String status;
    private String orderId;
    private String operationId;

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
     * Sets the {@code processor} and returns a reference to this Builder enabling method chaining.
     *
     * @param processor the {@code processor} to set
     * @return a reference to this Builder
     */
    public Builder processor(String processor) {
      this.processor = processor;
      return this;
    }

    /**
     * Sets the {@code code} and returns a reference to this Builder enabling method chaining.
     *
     * @param code the {@code code} to set
     * @return a reference to this Builder
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }

    /**
     * Sets the {@code responseCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param responseCode the {@code responseCode} to set
     * @return a reference to this Builder
     */
    public Builder responseCode(String responseCode) {
      this.responseCode = responseCode;
      return this;
    }

    /**
     * Sets the {@code responseCodeDescription} and returns a reference to this Builder enabling method chaining.
     *
     * @param responseCodeDescription the {@code responseCodeDescription} to set
     * @return a reference to this Builder
     */
    public Builder responseCodeDescription(String responseCodeDescription) {
      this.responseCodeDescription = responseCodeDescription;
      return this;
    }

    /**
     * Sets the {@code avsCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param avsCode the {@code avsCode} to set
     * @return a reference to this Builder
     */
    public Builder avsCode(String avsCode) {
      this.avsCode = avsCode;
      return this;
    }

    /**
     * Sets the {@code avsResponse} and returns a reference to this Builder enabling method chaining.
     *
     * @param avsResponse the {@code avsResponse} to set
     * @return a reference to this Builder
     */
    public Builder avsResponse(AvsResponse avsResponse) {
      this.avsResponse = avsResponse;
      return this;
    }

    /**
     * Sets the {@code nameVerification} and returns a reference to this Builder enabling method chaining.
     *
     * @param nameVerification the {@code nameVerification} to set
     * @return a reference to this Builder
     */
    public Builder nameVerification(NameVerification nameVerification) {
      this.nameVerification = nameVerification;
      return this;
    }

    /**
     * Sets the {@code firstNameVerification} and returns a reference to this Builder enabling method chaining.
     *
     * @param firstNameVerification the {@code firstNameVerification} to set
     * @return a reference to this Builder
     */
    public Builder firstNameVerification(NameVerification firstNameVerification) {
      this.firstNameVerification = firstNameVerification;
      return this;
    }

    /**
     * Sets the {@code lastNameVerification} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastNameVerification the {@code lastNameVerification} to set
     * @return a reference to this Builder
     */
    public Builder lastNameVerification(NameVerification lastNameVerification) {
      this.lastNameVerification = lastNameVerification;
      return this;
    }

    /**
     * Sets the {@code balanceResponse} and returns a reference to this Builder enabling method chaining.
     *
     * @param balanceResponse the {@code balanceResponse} to set
     * @return a reference to this Builder
     */
    public Builder balanceResponse(String balanceResponse) {
      this.balanceResponse = balanceResponse;
      return this;
    }

    /**
     * Sets the {@code mid} and returns a reference to this Builder enabling method chaining.
     *
     * @param mid the {@code mid} to set
     * @return a reference to this Builder
     */
    public Builder mid(String mid) {
      this.mid = mid;
      return this;
    }

    /**
     * Sets the {@code terminalId} and returns a reference to this Builder enabling method chaining.
     *
     * @param terminalId the {@code terminalId} to set
     * @return a reference to this Builder
     */
    public Builder terminalId(String terminalId) {
      this.terminalId = terminalId;
      return this;
    }

    /**
     * Sets the {@code batchNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param batchNumber the {@code batchNumber} to set
     * @return a reference to this Builder
     */
    public Builder batchNumber(String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
    }

    /**
     * Sets the {@code seqNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param seqNumber the {@code seqNumber} to set
     * @return a reference to this Builder
     */
    public Builder seqNumber(String seqNumber) {
      this.seqNumber = seqNumber;
      return this;
    }

    /**
     * Sets the {@code effectiveDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param effectiveDate the {@code effectiveDate} to set
     * @return a reference to this Builder
     */
    public Builder effectiveDate(String effectiveDate) {
      this.effectiveDate = effectiveDate;
      return this;
    }

    /**
     * Sets the {@code financingType} and returns a reference to this Builder enabling method chaining.
     *
     * @param financingType the {@code financingType} to set
     * @return a reference to this Builder
     */
    public Builder financingType(String financingType) {
      this.financingType = financingType;
      return this;
    }

    /**
     * Sets the {@code plan} and returns a reference to this Builder enabling method chaining.
     *
     * @param plan the {@code plan} to set
     * @return a reference to this Builder
     */
    public Builder plan(String plan) {
      this.plan = plan;
      return this;
    }

    /**
     * Sets the {@code gracePeriod} and returns a reference to this Builder enabling method chaining.
     *
     * @param gracePeriod the {@code gracePeriod} to set
     * @return a reference to this Builder
     */
    public Builder gracePeriod(String gracePeriod) {
      this.gracePeriod = gracePeriod;
      return this;
    }

    /**
     * Sets the {@code term} and returns a reference to this Builder enabling method chaining.
     *
     * @param term the {@code term} to set
     * @return a reference to this Builder
     */
    public Builder term(String term) {
      this.term = term;
      return this;
    }

    /**
     * Sets the {@code responseId} and returns a reference to this Builder enabling method chaining.
     *
     * @param responseId the {@code responseId} to set
     * @return a reference to this Builder
     */
    public Builder responseId(String responseId) {
      this.responseId = responseId;
      return this;
    }

    /**
     * Sets the {@code requestId} and returns a reference to this Builder enabling method chaining.
     *
     * @param requestId the {@code requestId} to set
     * @return a reference to this Builder
     */
    public Builder requestId(String requestId) {
      this.requestId = requestId;
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
     * Sets the {@code authCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param authCode the {@code authCode} to set
     * @return a reference to this Builder
     */
    public Builder authCode(String authCode) {
      this.authCode = authCode;
      return this;
    }

    /**
     * Sets the {@code txnDateTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param txnDateTime the {@code txnDateTime} to set
     * @return a reference to this Builder
     */
    public Builder txnDateTime(String txnDateTime) {
      this.txnDateTime = txnDateTime;
      return this;
    }

    /**
     * Sets the {@code referenceNbr} and returns a reference to this Builder enabling method chaining.
     *
     * @param referenceNbr the {@code referenceNbr} to set
     * @return a reference to this Builder
     */
    public Builder referenceNbr(String referenceNbr) {
      this.referenceNbr = referenceNbr;
      return this;
    }

    /**
     * Sets the {@code responseReasonCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param responseReasonCode the {@code responseReasonCode} to set
     * @return a reference to this Builder
     */
    public Builder responseReasonCode(String responseReasonCode) {
      this.responseReasonCode = responseReasonCode;
      return this;
    }

    /**
     * Sets the {@code cvvVerification} and returns a reference to this Builder enabling method chaining.
     *
     * @param cvvVerification the {@code cvvVerification} to set
     * @return a reference to this Builder
     */
    public Builder cvvVerification(CvvVerification cvvVerification) {
      this.cvvVerification = cvvVerification;
      return this;
    }

    /**
     * Sets the {@code cvv2Result} and returns a reference to this Builder enabling method chaining.
     *
     * @param cvv2Result the {@code cvv2Result} to set
     * @return a reference to this Builder
     */
    public Builder cvv2Result(String cvv2Result) {
      this.cvv2Result = cvv2Result;
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
     * Sets the {@code orderId} and returns a reference to this Builder enabling method chaining.
     *
     * @param orderId the {@code orderId} to set
     * @return a reference to this Builder
     */
    public Builder orderId(String orderId) {
      this.orderId = orderId;
      return this;
    }

    /**
     * Sets the {@code operationId} and returns a reference to this Builder enabling method chaining.
     *
     * @param operationId the {@code operationId} to set
     * @return a reference to this Builder
     */
    public Builder operationId(String operationId) {
      this.operationId = operationId;
      return this;
    }

    /**
     * Returns a {@code GatewayResponse} built from the parameters previously set.
     *
     * @return a {@code GatewayResponse} built with parameters of this {@code GatewayResponse.Builder}
     */
    public GatewayResponse build() {
      return new GatewayResponse(this);
    }
  }
}

