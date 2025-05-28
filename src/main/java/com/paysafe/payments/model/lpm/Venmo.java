// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Venmo
 */
public class Venmo {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("merchantAccountId")
  private String merchantAccountId;
  @JsonProperty("profileId")
  private String profileId;

  public Venmo() {
    super();
  }

  private Venmo(Builder builder) {
    setConsumerId(builder.consumerId);
    setMerchantAccountId(builder.merchantAccountId);
    setProfileId(builder.profileId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Venmo consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is your identifier for your consumer and must be unique per consumer. We store this after your first successful Venmo transaction for a given
   * consumer (during this first transaction the consumer agrees to link their Venmo wallet for future transactions). When you subsequently send in the
   * same consumerId, we debit the consumer’s wallet directly without the consumer having to agree to each transaction.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Venmo merchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
    return this;
  }

  /**
   * You can set up multiple accounts with Braintree, and each account can settle funds into a different bank account.
   * This parameter therefore allows you to control which of your bank accounts is used to receive settlement.  <br>
   * This only applies to pay-ins and not payouts.  <br> If you pass it for payouts the value will be ignored.  <br>
   * If not supplied for pay-ins, your default Braintree account will be used.
   *
   * @return merchantAccountId
   */
  public String getMerchantAccountId() {
    return merchantAccountId;
  }

  public void setMerchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
  }

  public Venmo profileId(String profileId) {
    this.profileId = profileId;
    return this;
  }

  /**
   * You can set up multiple profiles with Braintree, where each profile shows the consumer a different logo and description during checkout on the Venmo app,
   * and on the Venmo statement. This parameter therefore allows you to vary the consumer experience (for example, if you have multiple brands, you can display
   * a different logo for each).  <br>
   * This only applies to pay-ins and not payouts.  <br>
   * If you pass it for payouts the value will be ignored.  <br>
   * If not supplied for pay-ins, your default profile will be used.
   *
   * @return profileId
   */
  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Venmo venmo = (Venmo) o;
    return Objects.equals(this.consumerId, venmo.consumerId) &&
        Objects.equals(this.merchantAccountId, venmo.merchantAccountId) &&
        Objects.equals(this.profileId, venmo.profileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, merchantAccountId, profileId);
  }

  @Override
  public String toString() {

    return "class Venmo {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    merchantAccountId: " + toIndentedString(merchantAccountId) + "\n"
        + "    profileId: " + toIndentedString(profileId) + "\n"
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
   * {@code Venmo} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String merchantAccountId;
    private String profileId;

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
     * Sets the {@code merchantAccountId} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantAccountId the {@code merchantAccountId} to set
     * @return a reference to this Builder
     */
    public Builder merchantAccountId(String merchantAccountId) {
      this.merchantAccountId = merchantAccountId;
      return this;
    }

    /**
     * Sets the {@code profileId} and returns a reference to this Builder enabling method chaining.
     *
     * @param profileId the {@code profileId} to set
     * @return a reference to this Builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Returns a {@code Venmo} built from the parameters previously set.
     *
     * @return a {@code Venmo} built with parameters of this {@code Venmo.Builder}
     */
    public Venmo build() {
      return new Venmo(this);
    }
  }
}

