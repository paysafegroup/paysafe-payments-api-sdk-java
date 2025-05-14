// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.profile.Profile;

/**
 * Pix
 */
public class Pix {

  @JsonProperty("paymentExpiryMinutes")
  private Long paymentExpiryMinutes;
  @JsonProperty("profile")
  private Profile profile;

  public Pix() {
    super();
  }

  private Pix(final Builder builder) {
    setPaymentExpiryMinutes(builder.paymentExpiryMinutes);
    setProfile(builder.profile);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Pix paymentExpiryMinutes(Long paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
    return this;
  }

  /**
   * It is the transaction expiry in minutes at Safetypay.
   *
   * @return paymentExpiryMinutes
   */
  public Long getPaymentExpiryMinutes() {
    return paymentExpiryMinutes;
  }

  public void setPaymentExpiryMinutes(Long paymentExpiryMinutes) {
    this.paymentExpiryMinutes = paymentExpiryMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pix pix = (Pix) o;
    return Objects.equals(this.paymentExpiryMinutes, pix.paymentExpiryMinutes) &&
        Objects.equals(this.profile, pix.profile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentExpiryMinutes, profile);
  }

  @Override
  public String toString() {

    return "class Pix {\n"
        + "    paymentExpiryMinutes: " + toIndentedString(paymentExpiryMinutes) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
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

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(final Profile profile) {
    this.profile = profile;
  }

  /**
   * {@code Pix} builder static inner class.
   */
  public static final class Builder {
    private Long paymentExpiryMinutes;
    private Profile profile;

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
     * Returns a {@code Pix} built from the parameters previously set.
     *
     * @return a {@code Pix} built with parameters of this {@code Pix.Builder}
     */
    public Pix build() {
      return new Pix(this);
    }
  }
}

