// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.enums.MandateRequestResponseStatusReason;
import com.paysafe.payments.model.common.enums.MandateRequestStatus;

/**
 * Contains customer bank's mandate details
 */
public class Mandate {

  @JsonProperty("id")
  private String id;
  @JsonProperty("reference")
  private String reference;
  @JsonProperty("status")
  private MandateRequestStatus status;
  @JsonProperty("statusReason")
  private MandateRequestResponseStatusReason statusReason;

  public Mandate() {
    super();
  }

  private Mandate(Builder builder) {
    setId(builder.id);
    setReference(builder.reference);
    setStatus(builder.status);
    setStatusReason(builder.statusReason);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Mandate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the id of the mandate that got created.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Mandate reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * This is the identifier of the mandate in the  banking system.
   *
   * @return reference
   */
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Mandate status(MandateRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the mandate request response.
   *
   * @return status
   */
  public MandateRequestStatus getStatus() {
    return status;
  }

  public void setStatus(MandateRequestStatus status) {
    this.status = status;
  }

  public Mandate statusReason(MandateRequestResponseStatusReason statusReason) {
    this.statusReason = statusReason;
    return this;
  }

  /**
   * This is the status reason of the mandate request response.
   *
   * @return statusReason
   */
  public MandateRequestResponseStatusReason getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(MandateRequestResponseStatusReason statusReason) {
    this.statusReason = statusReason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mandate mandate = (Mandate) o;
    return Objects.equals(this.id, mandate.id) &&
        Objects.equals(this.reference, mandate.reference) &&
        Objects.equals(this.status, mandate.status) &&
        Objects.equals(this.statusReason, mandate.statusReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reference, status, statusReason);
  }

  @Override
  public String toString() {

    return "class Mandate {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    reference: " + toIndentedString(reference) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    statusReason: " + toIndentedString(statusReason) + "\n"
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
   * {@code Mandate} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String reference;
    private MandateRequestStatus status;
    private MandateRequestResponseStatusReason statusReason;

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
     * Sets the {@code reference} and returns a reference to this Builder enabling method chaining.
     *
     * @param reference the {@code reference} to set
     * @return a reference to this Builder
     */
    public Builder reference(String reference) {
      this.reference = reference;
      return this;
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(MandateRequestStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code statusReason} and returns a reference to this Builder enabling method chaining.
     *
     * @param statusReason the {@code statusReason} to set
     * @return a reference to this Builder
     */
    public Builder statusReason(MandateRequestResponseStatusReason statusReason) {
      this.statusReason = statusReason;
      return this;
    }

    /**
     * Returns a {@code Mandate} built from the parameters previously set.
     *
     * @return a {@code Mandate} built with parameters of this {@code Mandate.Builder}
     */
    public Mandate build() {
      return new Mandate(this);
    }
  }
}

