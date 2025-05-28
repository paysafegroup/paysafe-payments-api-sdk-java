// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.cancel;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;

/**
 * This class represents the response of the following operations:
 * <ul>
 * <li>Cancel Payment</li>
 * <li>Cancel Settlement</li>
 * <li>Cancel Refund</li>
 * <li>Cancel Standalone Credit</li>
 * <li>Cancel Original Credit</li>
 * <li>Cancel Mandate</li>
 * </ul>
 *
 * <p>
 * Allowed value for status: <code>CANCELLED</code>
 * </p>
 */
public class CancelResponse {

  @JsonProperty("status")
  private TransactionRequestStatus status;
  @JsonProperty("id")
  private String id;
  @JsonProperty("txnTime")
  private String txnTime;

  public CancelResponse() {
    super();
  }

  private CancelResponse(Builder builder) {
    setStatus(builder.status);
    setId(builder.id);
    setTxnTime(builder.txnTime);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CancelResponse status(TransactionRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the cancel request. Possible values: CANCELLED.
   *
   * @return status
   */
  public TransactionRequestStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionRequestStatus status) {
    this.status = status;
  }

  public CancelResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests, for example, to look up the Payment.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CancelResponse txnTime(String txnTime) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelResponse cancelResponse = (CancelResponse) o;
    return Objects.equals(this.status, cancelResponse.status) &&
        Objects.equals(this.id, cancelResponse.id) &&
        Objects.equals(this.txnTime, cancelResponse.txnTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, id, txnTime);
  }

  @Override
  public String toString() {

    return "class CancelResponse {\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
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
   * {@code CancelResponse} builder static inner class.
   */
  public static final class Builder {
    private TransactionRequestStatus status;
    private String id;
    private String txnTime;

    private Builder() {
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
     * Returns a {@code CancelResponse} built from the parameters previously set.
     *
     * @return a {@code CancelResponse} built with parameters of this {@code CancelResponse.Builder}
     */
    public CancelResponse build() {
      return new CancelResponse(this);
    }
  }
}

