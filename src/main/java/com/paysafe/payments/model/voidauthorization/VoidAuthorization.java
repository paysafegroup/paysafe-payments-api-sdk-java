// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.voidauthorization;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.voidauthorization.enums.VoidAuthorizationStatus;

/**
 * Represents the details of a Void Authorization
 *
 * <p>A Void Authorization allows you to cancel an authorization request, provided the authorization has not yet been settled.
 * If the authorization has already been settled, voiding is not allowed.</p>
 */
public class VoidAuthorization extends BaseApiResponse {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("id")
  private String id;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private VoidAuthorizationStatus status;

  private Map<String, Object> additionalParameters;

  public VoidAuthorization() {
    super();
  }

  private VoidAuthorization(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setId(builder.id);
    setTxnTime(builder.txnTime);
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public VoidAuthorization merchantRefNum(String merchantRefNum) {
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

  public VoidAuthorization amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. <br />
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

  public VoidAuthorization id(String id) {
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

  public VoidAuthorization txnTime(String txnTime) {
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

  public VoidAuthorization status(VoidAuthorizationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request. Possible values are:  <br />
   * - RECEIVED – Our system has received the request and is waiting for the downstream processor's response <br />
   * - COMPLETED – The transaction has been completed. <br />
   * - HELD – The transaction has been placed on hold due to risk considerations. <br />
   * - FAILED – The transaction failed, due to either an error or being declined. <br />
   * - CANCELLED – The request has been fully voided (reversed). <br />
   * - PENDING – The request is pending.
   *
   * @return status
   */
  public VoidAuthorizationStatus getStatus() {
    return status;
  }

  public void setStatus(VoidAuthorizationStatus status) {
    this.status = status;
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
    VoidAuthorization voidAuthorization = (VoidAuthorization) o;
    return Objects.equals(this.merchantRefNum, voidAuthorization.merchantRefNum) &&
        Objects.equals(this.amount, voidAuthorization.amount) &&
        Objects.equals(this.id, voidAuthorization.id) &&
        Objects.equals(this.txnTime, voidAuthorization.txnTime) &&
        Objects.equals(this.status, voidAuthorization.status) &&
        Objects.equals(this.additionalParameters, voidAuthorization.additionalParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, id, txnTime, status, additionalParameters);
  }

  @Override
  public String toString() {

    return "class VoidAuthorization {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * {@code VoidAuthorization} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Long amount;
    private String id;
    private String txnTime;
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
     * Returns a {@code VoidAuthorization} built from the parameters previously set.
     *
     * @return a {@code VoidAuthorization} built with parameters of this {@code VoidAuthorization.Builder}
     */
    public VoidAuthorization build() {
      return new VoidAuthorization(this);
    }
  }
}

