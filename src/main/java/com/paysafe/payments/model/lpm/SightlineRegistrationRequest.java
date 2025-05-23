// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.profile.Profile;

/**
 * SightlineRegistrationRequest
 */
public class SightlineRegistrationRequest {

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
  @JsonProperty("sightline")
  private Sightline sightline;

  public SightlineRegistrationRequest() {
    super();
  }

  private SightlineRegistrationRequest(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setProfile(builder.profile);
    setBillingDetails(builder.billingDetails);
    setReturnLinks(builder.returnLinks);
    setSightline(builder.sightline);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SightlineRegistrationRequest merchantRefNum(String merchantRefNum) {
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

  public SightlineRegistrationRequest paymentType(String paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This is the payment type. Possible value: SIGHTLINE
   *
   * @return paymentType
   */
  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public SightlineRegistrationRequest profile(Profile profile) {
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

  public SightlineRegistrationRequest billingDetails(BillingDetails billingDetails) {
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

  public SightlineRegistrationRequest returnLinks(List<ReturnLink> returnLinks) {
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

  public SightlineRegistrationRequest sightline(Sightline sightline) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SightlineRegistrationRequest sightlineRegistrationRequest = (SightlineRegistrationRequest) o;
    return Objects.equals(this.merchantRefNum, sightlineRegistrationRequest.merchantRefNum) &&
        Objects.equals(this.paymentType, sightlineRegistrationRequest.paymentType) &&
        Objects.equals(this.profile, sightlineRegistrationRequest.profile) &&
        Objects.equals(this.billingDetails, sightlineRegistrationRequest.billingDetails) &&
        Objects.equals(this.returnLinks, sightlineRegistrationRequest.returnLinks) &&
        Objects.equals(this.sightline, sightlineRegistrationRequest.sightline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, paymentType, profile, billingDetails, returnLinks, sightline);
  }

  @Override
  public String toString() {

    return "class SightlineRegistrationRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    sightline: " + toIndentedString(sightline) + "\n"
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
   * {@code SightlineRegistrationRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private String paymentType;
    private Profile profile;
    private BillingDetails billingDetails;
    private List<ReturnLink> returnLinks;
    private Sightline sightline;

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
     * @param paymentType the {@code paymentType} to set
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
     * Returns a {@code SightlineRegistrationRequest} built from the parameters previously set.
     *
     * @return a {@code SightlineRegistrationRequest} built with parameters of this {@code SightlineRegistrationRequest.Builder}
     */
    public SightlineRegistrationRequest build() {
      return new SightlineRegistrationRequest(this);
    }
  }
}

