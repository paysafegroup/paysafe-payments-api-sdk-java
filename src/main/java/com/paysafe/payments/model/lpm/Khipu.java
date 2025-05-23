// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.profile.Profile;

/**
 * Khipu
 */
public class Khipu {

  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("paymentExpiryMinutes")
  private Long paymentExpiryMinutes;

  public Khipu() {
    super();
  }

  private Khipu(final Builder builder) {
    setProfile(builder.profile);
    setBillingDetails(builder.billingDetails);
    setPaymentExpiryMinutes(builder.paymentExpiryMinutes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Khipu paymentExpiryMinutes(Long paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at SafetyPay.
   *
   * @return paymentExpiryMinutes
   */
  public Long getPaymentExpiryMinutes() {
    return paymentExpiryMinutes;
  }

  public void setPaymentExpiryMinutes(Long paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(final Profile profile) {
    this.profile = profile;
  }

  public BillingDetails getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(final BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Khipu khipu = (Khipu) o;
    return Objects.equals(this.paymentExpiryMinutes, khipu.paymentExpiryMinutes) &&
        Objects.equals(this.profile, khipu.profile) &&
        Objects.equals(this.billingDetails, khipu.billingDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentExpiryMinutes, profile, billingDetails);
  }

  @Override
  public String toString() {

    return "class Khipu {\n"
        + "    paymentExpiryMinutes: " + toIndentedString(paymentExpiryMinutes) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
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
   * {@code Khipu} builder static inner class.
   */
  public static final class Builder {
    private Long paymentExpiryMinutes;
    private Profile profile;
    private BillingDetails billingDetails;

    private Builder() {
    }

    /**
     * Sets the {@code paymentExpiryMinutes} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentExpiryMinutes the {@code paymentExpiryMinutes} to set
     * @return a reference to this Builder
     */
    public Builder paymentExpiryMinutes(Long paymentExpiryMinutes) {
      this.paymentExpiryMinutes = paymentExpiryMinutes;
      return this;
    }

    /**
     * Returns a {@code Khipu} built from the parameters previously set.
     *
     * @return a {@code Khipu} built with parameters of this {@code Khipu.Builder}
     */
    public Khipu build() {
      return new Khipu(this);
    }

    /**
     * Sets the {@code profile} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code profile} to set
     * @return a reference to this Builder
     */
    public Builder profile(final Profile val) {
      profile = val;
      return this;
    }

    /**
     * Sets the {@code billingDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code billingDetails} to set
     * @return a reference to this Builder
     */
    public Builder billingDetails(final BillingDetails val) {
      billingDetails = val;
      return this;
    }
  }
}

