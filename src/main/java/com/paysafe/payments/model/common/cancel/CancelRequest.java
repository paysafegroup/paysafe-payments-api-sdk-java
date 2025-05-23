// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.cancel;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;

/**
 * This class contains the internal details required for processing a cancel request.
 * This object represents the request body for following operations:
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
public class CancelRequest {

  @JsonProperty("status")
  private TransactionRequestStatus status;

  public CancelRequest() {
    super();
  }

  private CancelRequest(Builder builder) {
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CancelRequest status(TransactionRequestStatus status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelRequest cancelRequest = (CancelRequest) o;
    return Objects.equals(this.status, cancelRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {

    return "class CancelRequest {\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * {@code CancelRequest} builder static inner class.
   */
  public static final class Builder {
    private TransactionRequestStatus status;

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
     * Returns a {@code CancelRequest} built from the parameters previously set.
     *
     * @return a {@code CancelRequest} built with parameters of this {@code CancelRequest.Builder}
     */
    public CancelRequest build() {
      return new CancelRequest(this);
    }
  }
}

