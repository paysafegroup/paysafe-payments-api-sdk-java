// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.Link;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

/**
 * SightlineRegistration
 */
public class SightlineRegistration {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
  @JsonProperty("sightline")
  private Sightline sightline;
  @JsonProperty("id")
  private String id;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private String status;
  @JsonProperty("links")
  private List<Link> links = null;
  @JsonProperty("liveMode")
  private Boolean liveMode;

  public SightlineRegistration() {
    super();
  }

  private SightlineRegistration(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setProfile(builder.profile);
    setBillingDetails(builder.billingDetails);
    returnLinks = builder.returnLinks;
    setSightline(builder.sightline);
    setId(builder.id);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    links = builder.links;
    setLiveMode(builder.liveMode);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SightlineRegistration merchantRefNum(String merchantRefNum) {
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

  public SightlineRegistration paymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type. Possible values: SIGHTLINE
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public SightlineRegistration profile(Profile profile) {
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

  public SightlineRegistration billingDetails(BillingDetails billingDetails) {
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

  public SightlineRegistration returnLink(List<ReturnLink> returnLink) {
    this.returnLinks = returnLink;
    return this;
  }

  /**
   * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site.
   * You can customize the return URL based on the transaction status.
   *
   * @return returnLink
   */
  public List<ReturnLink> getReturnLink() {
    return returnLinks;
  }

  public void setReturnLink(List<ReturnLink> returnLink) {
    this.returnLinks = returnLink;
  }

  public SightlineRegistration sightline(Sightline sightline) {
    this.sightline = sightline;
    return this;
  }

  /**
   * These are the details of the Play+ (Sightline) used for the transaction.
   *
   * @return sightline
   */
  public Sightline getSightline() {
    return sightline;
  }

  public void setSightline(Sightline sightline) {
    this.sightline = sightline;
  }

  public SightlineRegistration id(String id) {
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

  public SightlineRegistration txnTime(String txnTime) {
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

  public SightlineRegistration status(String status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the transaction request. Possible values are:
   * <ul>
   * <li> INITIATED - The transaction has been initiated.   </li>
   * <li> RECEIVED – Our system has received the request and is waiting for the downstream processor’s response.   </li>
   * <li> COMPLETED – The transaction has been completed.  </li>
   * <li> PENDING – Our system has received the request but it has not yet been batched.  </li>
   * <li> FAILED – The transaction failed, due to either an error or being declined.  </li>
   * <li> CANCELLED – The request has been fully voided (reversed).
   * </ul>
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SightlineRegistration links(List<Link> links) {
    this.links = links;
    return this;
  }

  public SightlineRegistration addLinkItem(Link linkItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.links.add(linkItem);
    return this;
  }

  public SightlineRegistration removeLinkItem(Link linkItem) {
    if (linkItem != null && this.links != null) {
      this.links.remove(linkItem);
    }

    return this;
  }

  /**
   * Get links
   *
   * @return links
   */
  public List<Link> getLink() {
    return links;
  }

  public void setLink(List<Link> links) {
    this.links = links;
  }

  public SightlineRegistration liveMode(Boolean liveMode) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SightlineRegistration sightlineRegistration = (SightlineRegistration) o;
    return Objects.equals(this.merchantRefNum, sightlineRegistration.merchantRefNum) &&
        Objects.equals(this.paymentType, sightlineRegistration.paymentType) &&
        Objects.equals(this.profile, sightlineRegistration.profile) &&
        Objects.equals(this.billingDetails, sightlineRegistration.billingDetails) &&
        Objects.equals(this.returnLinks, sightlineRegistration.returnLinks) &&
        Objects.equals(this.sightline, sightlineRegistration.sightline) &&
        Objects.equals(this.id, sightlineRegistration.id) &&
        Objects.equals(this.txnTime, sightlineRegistration.txnTime) &&
        Objects.equals(this.status, sightlineRegistration.status) &&
        Objects.equals(this.links, sightlineRegistration.links) &&
        Objects.equals(this.liveMode, sightlineRegistration.liveMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, paymentType, profile, billingDetails, returnLinks, sightline, id, txnTime, status, links, liveMode);
  }

  @Override
  public String toString() {

    return "class SightlineRegistration {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    sightline: " + toIndentedString(sightline) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    links: " + toIndentedString(links) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
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
   * {@code SightlineRegistration} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private PaymentType paymentType;
    private Profile profile;
    private BillingDetails billingDetails;
    private List<ReturnLink> returnLinks;
    private Sightline sightline;
    private String id;
    private String txnTime;
    private String status;
    private List<Link> links;
    private Boolean liveMode;

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
     * @param paymentType the {@code paymentType} to set. Possible value: SIGHTLINE
     * @return a reference to this Builder
     */
    public Builder paymentType(PaymentType paymentType) {
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
     * Sets the {@code sightline} and returns a reference to this Builder enabling method chaining.
     *
     * @param sightline the {@code sightline} to set
     * @return a reference to this Builder
     */
    public Builder sightline(Sightline sightline) {
      this.sightline = sightline;
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
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code links} and returns a reference to this Builder enabling method chaining.
     *
     * @param links the {@code links} to set
     * @return a reference to this Builder
     */
    public Builder links(List<Link> links) {
      this.links = links;
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
     * Returns a {@code SightlineRegistration} built from the parameters previously set.
     *
     * @return a {@code SightlineRegistration} built with parameters of this {@code SightlineRegistration.Builder}
     */
    public SightlineRegistration build() {
      return new SightlineRegistration(this);
    }
  }
}

