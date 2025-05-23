// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.applepay.ApplePayTokenDetails;

/**
 * CardApplePayTokenDetails
 */
public class CardApplePayTokenDetails {

  @JsonProperty("applePay")
  private ApplePayTokenDetails applePay;

  public CardApplePayTokenDetails() {
    super();
  }

  private CardApplePayTokenDetails(Builder builder) {
    setApplePay(builder.applePay);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CardApplePayTokenDetails applePay(ApplePayTokenDetails applePay) {
    this.applePay = applePay;
    return this;
  }

  /**
   * When tokenType=APPLE_PAY. Apple Pay token information. Returned when the stored payment method is an Apple Pay token.
   *
   * @return applePay
   */
  public ApplePayTokenDetails getApplePay() {
    return applePay;
  }

  public void setApplePay(ApplePayTokenDetails applePay) {
    this.applePay = applePay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardApplePayTokenDetails cardApplePayTokenDetails = (CardApplePayTokenDetails) o;
    return Objects.equals(this.applePay, cardApplePayTokenDetails.applePay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applePay);
  }

  @Override
  public String toString() {

    return "class CardApplePayTokenDetails {\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
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
   * {@code CardApplePayTokenDetails} builder static inner class.
   */
  public static final class Builder {
    private ApplePayTokenDetails applePay;

    private Builder() {
    }

    /**
     * Sets the {@code applePay} and returns a reference to this Builder enabling method chaining.
     *
     * @param applePay the {@code applePay} to set
     * @return a reference to this Builder
     */
    public Builder applePay(ApplePayTokenDetails applePay) {
      this.applePay = applePay;
      return this;
    }

    /**
     * Returns a {@code CardApplePayTokenDetails} built from the parameters previously set.
     *
     * @return a {@code CardApplePayTokenDetails} built with parameters of this {@code CardApplePayTokenDetails.Builder}
     */
    public CardApplePayTokenDetails build() {
      return new CardApplePayTokenDetails(this);
    }
  }
}

