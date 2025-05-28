// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.lpm.enums.VippreferredTransactionStatus;

/**
 * VippreferredRegistration
 */
public class VippreferredRegistration {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private String paymentType;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
  @JsonProperty("vippreferred")
  private Vippreferred vippreferred;
  @JsonProperty("id")
  private String id;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private VippreferredTransactionStatus status;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("enablePlaid")
  private Boolean enablePlaid;

  public VippreferredRegistration() {
    super();
  }

  private VippreferredRegistration(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setProfile(builder.profile);
    setBillingDetails(builder.billingDetails);
    setReturnLinks(builder.returnLinks);
    setVippreferred(builder.vippreferred);
    setId(builder.id);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setLiveMode(builder.liveMode);
    setGatewayResponse(builder.gatewayResponse);
    setEnablePlaid(builder.enablePlaid);
  }

  public static Builder builder() {
    return new Builder();
  }

  public VippreferredRegistration merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the reference number for the merchant.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public VippreferredRegistration paymentType(String paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type. Possible values: VIPPREFERRED
   *
   * @return paymentType
   */
  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public VippreferredRegistration profile(Profile profile) {
    this.profile = profile;
    return this;
  }

  /**
   * This is customer's profile details.
   *
   * @return profile
   */
  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public VippreferredRegistration billingDetails(BillingDetails billingDetails) {
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

  public VippreferredRegistration returnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
    return this;
  }

  /**
   * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site.
   * You can customize the return URL based on the transaction status.
   *
   * @return returnLinks
   */
  public List<ReturnLink> getReturnLinks() {
    return returnLinks;
  }

  public void setReturnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
  }

  public VippreferredRegistration vippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
    return this;
  }

  /**
   * These are the details of the vip preferred account used for the transaction.
   *
   * @return vippreferred
   */
  public Vippreferred getVippreferred() {
    return vippreferred;
  }

  public void setVippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
  }

  public VippreferredRegistration id(String id) {
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

  public VippreferredRegistration txnTime(String txnTime) {
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

  public VippreferredRegistration status(VippreferredTransactionStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request.
   *
   * @return status
   */
  public VippreferredTransactionStatus getStatus() {
    return status;
  }

  public void setStatus(VippreferredTransactionStatus status) {
    this.status = status;
  }

  public VippreferredRegistration liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * 'This flag indicated the environment.  - true - Production Environment - false - Non-Production Environment.
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }

  public VippreferredRegistration gatewayResponse(GatewayResponse gatewayResponse) {
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

  public VippreferredRegistration enablePlaid(Boolean enablePlaid) {
    this.enablePlaid = enablePlaid;
    return this;
  }

  /**
   * This is the flag to indicate the plaid activation status.
   * <ul>
   * <li>true - Plaid flow will be triggered during bank addition. </li>
   * <li>false - Manual entry of Bank Account Number and Routing Number during bank addition. </li>
   * </ul>
   * @return enablePlaid
   */
  public Boolean getEnablePlaid() {
    return enablePlaid;
  }

  public void setEnablePlaid(Boolean enablePlaid) {
    this.enablePlaid = enablePlaid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VippreferredRegistration vippreferredRegistration = (VippreferredRegistration) o;
    return Objects.equals(this.merchantRefNum, vippreferredRegistration.merchantRefNum) &&
        Objects.equals(this.paymentType, vippreferredRegistration.paymentType) &&
        Objects.equals(this.profile, vippreferredRegistration.profile) &&
        Objects.equals(this.billingDetails, vippreferredRegistration.billingDetails) &&
        Objects.equals(this.returnLinks, vippreferredRegistration.returnLinks) &&
        Objects.equals(this.vippreferred, vippreferredRegistration.vippreferred) &&
        Objects.equals(this.id, vippreferredRegistration.id) &&
        Objects.equals(this.txnTime, vippreferredRegistration.txnTime) &&
        Objects.equals(this.status, vippreferredRegistration.status) &&
        Objects.equals(this.liveMode, vippreferredRegistration.liveMode) &&
        Objects.equals(this.gatewayResponse, vippreferredRegistration.gatewayResponse) &&
        Objects.equals(this.enablePlaid, vippreferredRegistration.enablePlaid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, paymentType, profile, billingDetails, returnLinks, vippreferred, id, txnTime, status,
        liveMode, gatewayResponse, enablePlaid);
  }

  @Override
  public String toString() {

    return "class VippreferredRegistration {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    vippreferred: " + toIndentedString(vippreferred) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    enablePlaid: " + toIndentedString(enablePlaid) + "\n"
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
   * {@code VippreferredRegistration} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private String paymentType;
    private Profile profile;
    private BillingDetails billingDetails;
    private List<ReturnLink> returnLinks;
    private Vippreferred vippreferred;
    private String id;
    private String txnTime;
    private VippreferredTransactionStatus status;
    private Boolean liveMode;
    private GatewayResponse gatewayResponse;
    private Boolean enablePlaid;

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
     * Sets the {@code paymentType} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the {@code paymentType} to set. Possible values: VIPPREFERRED
     * @return a reference to this Builder
     */
    public Builder paymentType(String paymentType) {
      this.paymentType = paymentType;
      return this;
    }

    /**
     * Sets the {@code profile} and returns a reference to this Builder enabling method chaining.
     *
     * @param profile the {@code profile} to set
     * @return a reference to this Builder
     */
    public Builder profile(Profile profile) {
      this.profile = profile;
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
     * Sets the {@code returnLinks} and returns a reference to this Builder enabling method chaining.
     *
     * @param returnLinks the {@code returnLinks} to set
     * @return a reference to this Builder
     */
    public Builder returnLinks(List<ReturnLink> returnLinks) {
      this.returnLinks = returnLinks;
      return this;
    }

    /**
     * Sets the {@code vippreferred} and returns a reference to this Builder enabling method chaining.
     *
     * @param vippreferred the {@code vippreferred} to set
     * @return a reference to this Builder
     */
    public Builder vippreferred(Vippreferred vippreferred) {
      this.vippreferred = vippreferred;
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
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(VippreferredTransactionStatus status) {
      this.status = status;
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
     * Sets the {@code enablePlaid} and returns a reference to this Builder enabling method chaining.
     *
     * @param enablePlaid the {@code enablePlaid} to set
     * @return a reference to this Builder
     */
    public Builder enablePlaid(Boolean enablePlaid) {
      this.enablePlaid = enablePlaid;
      return this;
    }

    /**
     * Returns a {@code VippreferredRegistration} built from the parameters previously set.
     *
     * @return a {@code VippreferredRegistration} built with parameters of this {@code VippreferredRegistration.Builder}
     */
    public VippreferredRegistration build() {
      return new VippreferredRegistration(this);
    }
  }
}

