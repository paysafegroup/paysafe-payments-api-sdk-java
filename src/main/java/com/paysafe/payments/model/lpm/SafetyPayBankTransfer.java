// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are the details of the SafetyPay Bank Transfer account used for the request. Only one payment instrument object (for example, card or SafetyPay
 * Bank Transfer) can be included in the request.
 */
public class SafetyPayBankTransfer {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("minAgeRestriction")
  private Long minAgeRestriction;
  @JsonProperty("kycLevelRestriction")
  private String kycLevelRestriction;
  @JsonProperty("submerchantId")
  private String submerchantId;
  @JsonProperty("expirationTime")
  private String expirationTime;
  @JsonProperty("barcodes")
  private List<PagoefectivoBarcodesInner> barcodes = null;

  public SafetyPayBankTransfer() {
    super();
  }

  private SafetyPayBankTransfer(Builder builder) {
    setConsumerId(builder.consumerId);
    setMinAgeRestriction(builder.minAgeRestriction);
    setKycLevelRestriction(builder.kycLevelRestriction);
    setSubmerchantId(builder.submerchantId);
    setExpirationTime(builder.expirationTime);
    setBarcodes(builder.barcodes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SafetyPayBankTransfer consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * The ID of the consumer at the merchant site
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public SafetyPayBankTransfer minAgeRestriction(Long minAgeRestriction) {
    this.minAgeRestriction = minAgeRestriction;
    return this;
  }

  /**
   * payment can be restricted for a certain minimum consumer age (implicitly restricts payment to registered consumers only)
   * minimum: 1
   * maximum: 99
   *
   * @return minAgeRestriction
   */
  public Long getMinAgeRestriction() {
    return minAgeRestriction;
  }

  public void setMinAgeRestriction(Long minAgeRestriction) {
    this.minAgeRestriction = minAgeRestriction;
  }

  public SafetyPayBankTransfer kycLevelRestriction(String kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
    return this;
  }

  /**
   * payment can be restricted for a certain minimum kyc level (implicitly restricts payment to registered consumers only)
   *
   * @return kycLevelRestriction
   */
  public String getKycLevelRestriction() {
    return kycLevelRestriction;
  }

  public void setKycLevelRestriction(String kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
  }

  public SafetyPayBankTransfer submerchantId(String submerchantId) {
    this.submerchantId = submerchantId;
    return this;
  }

  /**
   * sub-merchant id of APM customer
   *
   * @return submerchantId
   */
  public String getSubmerchantId() {
    return submerchantId;
  }

  public void setSubmerchantId(String submerchantId) {
    this.submerchantId = submerchantId;
  }

  public SafetyPayBankTransfer expirationTime(String expirationTime) {
    this.expirationTime = expirationTime;
    return this;
  }

  /**
   * expiration time in minutes
   *
   * @return expirationTime
   */
  public String getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(String expirationTime) {
    this.expirationTime = expirationTime;
  }

  public SafetyPayBankTransfer barcodes(List<PagoefectivoBarcodesInner> barcodes) {
    this.barcodes = barcodes;
    return this;
  }

  public SafetyPayBankTransfer addBarcodesItem(PagoefectivoBarcodesInner barcodesItem) {
    if (this.barcodes == null) {
      this.barcodes = new ArrayList<>();
    }
    this.barcodes.add(barcodesItem);
    return this;
  }

  public SafetyPayBankTransfer removeBarcodesItem(PagoefectivoBarcodesInner barcodesItem) {
    if (barcodesItem != null && this.barcodes != null) {
      this.barcodes.remove(barcodesItem);
    }

    return this;
  }

  /**
   * Get barcodes
   *
   * @return barcodes
   */
  public List<PagoefectivoBarcodesInner> getBarcodes() {
    return barcodes;
  }

  public void setBarcodes(List<PagoefectivoBarcodesInner> barcodes) {
    this.barcodes = barcodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SafetyPayBankTransfer safetyPayBankTransfer = (SafetyPayBankTransfer) o;
    return Objects.equals(this.consumerId, safetyPayBankTransfer.consumerId) &&
        Objects.equals(this.minAgeRestriction, safetyPayBankTransfer.minAgeRestriction) &&
        Objects.equals(this.kycLevelRestriction, safetyPayBankTransfer.kycLevelRestriction) &&
        Objects.equals(this.submerchantId, safetyPayBankTransfer.submerchantId) &&
        Objects.equals(this.expirationTime, safetyPayBankTransfer.expirationTime) &&
        Objects.equals(this.barcodes, safetyPayBankTransfer.barcodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, minAgeRestriction, kycLevelRestriction, submerchantId, expirationTime, barcodes);
  }

  @Override
  public String toString() {

    return "class SafetyPayBankTransfer {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    minAgeRestriction: " + toIndentedString(minAgeRestriction) + "\n"
        + "    kycLevelRestriction: " + toIndentedString(kycLevelRestriction) + "\n"
        + "    submerchantId: " + toIndentedString(submerchantId) + "\n"
        + "    expirationTime: " + toIndentedString(expirationTime) + "\n"
        + "    barcodes: " + toIndentedString(barcodes) + "\n"
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
   * {@code SafetyPayBankTransfer} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private Long minAgeRestriction;
    private String kycLevelRestriction;
    private String submerchantId;
    private String expirationTime;
    private List<PagoefectivoBarcodesInner> barcodes;

    private Builder() {
    }

    /**
     * Sets the {@code consumerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the {@code consumerId} to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * Sets the {@code minAgeRestriction} and returns a reference to this Builder enabling method chaining.
     *
     * @param minAgeRestriction the {@code minAgeRestriction} to set
     * @return a reference to this Builder
     */
    public Builder minAgeRestriction(Long minAgeRestriction) {
      this.minAgeRestriction = minAgeRestriction;
      return this;
    }

    /**
     * Sets the {@code kycLevelRestriction} and returns a reference to this Builder enabling method chaining.
     *
     * @param kycLevelRestriction the {@code kycLevelRestriction} to set
     * @return a reference to this Builder
     */
    public Builder kycLevelRestriction(String kycLevelRestriction) {
      this.kycLevelRestriction = kycLevelRestriction;
      return this;
    }

    /**
     * Sets the {@code submerchantId} and returns a reference to this Builder enabling method chaining.
     *
     * @param submerchantId the {@code submerchantId} to set
     * @return a reference to this Builder
     */
    public Builder submerchantId(String submerchantId) {
      this.submerchantId = submerchantId;
      return this;
    }

    /**
     * Sets the {@code expirationTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationTime the {@code expirationTime} to set
     * @return a reference to this Builder
     */
    public Builder expirationTime(String expirationTime) {
      this.expirationTime = expirationTime;
      return this;
    }

    /**
     * Sets the {@code barcodes} and returns a reference to this Builder enabling method chaining.
     *
     * @param barcodes the {@code barcodes} to set
     * @return a reference to this Builder
     */
    public Builder barcodes(List<PagoefectivoBarcodesInner> barcodes) {
      this.barcodes = barcodes;
      return this;
    }

    /**
     * Returns a {@code SafetyPayBankTransfer} built from the parameters previously set.
     *
     * @return a {@code SafetyPayBankTransfer} built with parameters of this {@code SafetyPayBankTransfer.Builder}
     */
    public SafetyPayBankTransfer build() {
      return new SafetyPayBankTransfer(this);
    }
  }
}

