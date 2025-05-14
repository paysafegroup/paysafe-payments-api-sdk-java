// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Neteller details to be used for the request
 */
public class Neteller {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("recipientDescription")
  private String recipientDescription;
  @JsonProperty("logoUrl")
  private String logoUrl;

  public Neteller() {
    super();
  }

  private Neteller(Builder builder) {
    setConsumerId(builder.consumerId);
    setRecipientDescription(builder.recipientDescription);
    setLogoUrl(builder.logoUrl);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Neteller consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the email address of the customer who is making or receiving the payment.This is to be provided by merchant while making a payout.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Neteller recipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
    return this;
  }

  /**
   * This is a description to be shown on the Skrill payment page in the logo area if there is no logo url parameter.
   * If no value is submitted and there is no logo, the pay_to_email value is shown as the recipient of the payment.
   *
   * @return recipientDescription
   */
  public String getRecipientDescription() {
    return recipientDescription;
  }

  public void setRecipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
  }

  public Neteller logoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
    return this;
  }

  /**
   * Neteller logo url.
   *
   * @return logoUrl
   */
  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Neteller neteller = (Neteller) o;
    return Objects.equals(this.consumerId, neteller.consumerId) &&
        Objects.equals(this.recipientDescription, neteller.recipientDescription) &&
        Objects.equals(this.logoUrl, neteller.logoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, recipientDescription, logoUrl);
  }

  @Override
  public String toString() {

    return "class Neteller {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    recipientDescription: " + toIndentedString(recipientDescription) + "\n"
        + "    logoUrl: " + toIndentedString(logoUrl) + "\n"
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
   * {@code Neteller} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String recipientDescription;
    private String logoUrl;

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
     * Sets the {@code recipientDescription} and returns a reference to this Builder enabling method chaining.
     *
     * @param recipientDescription the {@code recipientDescription} to set
     * @return a reference to this Builder
     */
    public Builder recipientDescription(String recipientDescription) {
      this.recipientDescription = recipientDescription;
      return this;
    }

    /**
     * Sets the {@code logoUrl} and returns a reference to this Builder enabling method chaining.
     *
     * @param logoUrl the {@code logoUrl} to set
     * @return a reference to this Builder
     */
    public Builder logoUrl(String logoUrl) {
      this.logoUrl = logoUrl;
      return this;
    }

    /**
     * Returns a {@code Neteller} built from the parameters previously set.
     *
     * @return a {@code Neteller} built with parameters of this {@code Neteller.Builder}
     */
    public Neteller build() {
      return new Neteller(this);
    }
  }
}

