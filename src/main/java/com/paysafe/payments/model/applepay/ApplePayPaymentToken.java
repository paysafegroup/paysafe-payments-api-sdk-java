// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ApplePayPaymentToken
 */
public class ApplePayPaymentToken {

  @JsonProperty("token")
  private ApplePayTokenData token;
  @JsonProperty("billingContact")
  private ApplePayBillingContact billingContact;

  public ApplePayPaymentToken() {
    super();
  }

  private ApplePayPaymentToken(Builder builder) {
    setToken(builder.token);
    setBillingContact(builder.billingContact);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayPaymentToken token(ApplePayTokenData token) {
    this.token = token;
    return this;
  }

  /**
   * This object contains the user's payment credentials.
   *
   * @return token
   */
  public ApplePayTokenData getToken() {
    return token;
  }

  public void setToken(ApplePayTokenData token) {
    this.token = token;
  }

  public ApplePayPaymentToken billingContact(ApplePayBillingContact billingContact) {
    this.billingContact = billingContact;
    return this;
  }

  /**
   * The billing contact provided by the user for this transaction in Apple Pay wallet
   *
   * @return billingContact
   */
  public ApplePayBillingContact getBillingContact() {
    return billingContact;
  }

  public void setBillingContact(ApplePayBillingContact billingContact) {
    this.billingContact = billingContact;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayPaymentToken applePayPaymentToken = (ApplePayPaymentToken) o;
    return Objects.equals(this.token, applePayPaymentToken.token) &&
        Objects.equals(this.billingContact, applePayPaymentToken.billingContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, billingContact);
  }

  @Override
  public String toString() {

    return "class ApplePayPaymentToken {\n"
        + "    token: " + toIndentedString(token) + "\n"
        + "    billingContact: " + toIndentedString(billingContact) + "\n"
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
   * {@code ApplePayPaymentToken} builder static inner class.
   */
  public static final class Builder {
    private ApplePayTokenData token;
    private ApplePayBillingContact billingContact;

    private Builder() {
    }

    /**
     * Sets the {@code token} and returns a reference to this Builder enabling method chaining.
     *
     * @param token the {@code token} to set
     * @return a reference to this Builder
     */
    public Builder token(ApplePayTokenData token) {
      this.token = token;
      return this;
    }

    /**
     * Sets the {@code billingContact} and returns a reference to this Builder enabling method chaining.
     *
     * @param billingContact the {@code billingContact} to set
     * @return a reference to this Builder
     */
    public Builder billingContact(ApplePayBillingContact billingContact) {
      this.billingContact = billingContact;
      return this;
    }

    /**
     * Returns a {@code ApplePayPaymentToken} built from the parameters previously set.
     *
     * @return a {@code ApplePayPaymentToken} built with parameters of this {@code ApplePayPaymentToken.Builder}
     */
    public ApplePayPaymentToken build() {
      return new ApplePayPaymentToken(this);
    }
  }
}

