// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ApplePay
 */
public class ApplePay {

  @JsonProperty("label")
  private String label;
  @JsonProperty("requestBillingAddress")
  private Boolean requestBillingAddress;
  @JsonProperty("applePayPaymentToken")
  private ApplePayPaymentToken applePayPaymentToken;
  @JsonProperty("billingContact")
  private ApplePayBillingContact billingContact;

  public ApplePay() {
    super();
  }

  private ApplePay(Builder builder) {
    setLabel(builder.label);
    setRequestBillingAddress(builder.requestBillingAddress);
    setApplePayPaymentToken(builder.token);
    setBillingContact(builder.billingContact);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePay token(ApplePayPaymentToken token) {
    this.applePayPaymentToken = token;
    return this;
  }

  /**
   * This object contains the user's payment credentials.
   *
   * @return token
   */
  public ApplePayPaymentToken getApplePayPaymentToken() {
    return applePayPaymentToken;
  }

  public void setApplePayPaymentToken(ApplePayPaymentToken applePayPaymentToken) {
    this.applePayPaymentToken = applePayPaymentToken;
  }

  public ApplePay billingContact(ApplePayBillingContact billingContact) {
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

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Boolean getRequestBillingAddress() {
    return requestBillingAddress;
  }

  public void setRequestBillingAddress(Boolean requestBillingAddress) {
    this.requestBillingAddress = requestBillingAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePay applePay = (ApplePay) o;
    return Objects.equals(this.applePayPaymentToken, applePay.applePayPaymentToken) &&
        Objects.equals(this.billingContact, applePay.billingContact)
        && Objects.equals(this.label, applePay.label)
        && Objects.equals(this.requestBillingAddress, applePay.requestBillingAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applePayPaymentToken, billingContact);
  }

  @Override
  public String toString() {

    return "class ApplePay {\n"
        + "    label: " + toIndentedString(label) + "\n"
        + "    requestBillingAddress: " + toIndentedString(requestBillingAddress) + "\n"
        + "    applePayPaymentToken: " + toIndentedString(applePayPaymentToken) + "\n"
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
   * {@code ApplePay} builder static inner class.
   */
  public static final class Builder {
    private String label;
    private Boolean requestBillingAddress;
    private ApplePayPaymentToken token;
    private ApplePayBillingContact billingContact;

    private Builder() {
    }

    /**
     * Sets the {@code label} and returns a reference to this Builder enabling method chaining.
     *
     * @param label the {@code label} to set
     * @return a reference to this Builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Sets the {@code requestBillingAddress} and returns a reference to this Builder enabling method chaining.
     *
     * @param requestBillingAddress the {@code requestBillingAddress} to set
     * @return a reference to this Builder
     */
    public Builder requestBillingAddress(Boolean requestBillingAddress) {
      this.requestBillingAddress = requestBillingAddress;
      return this;
    }

    /**
     * Sets the {@code token} and returns a reference to this Builder enabling method chaining.
     *
     * @param token the {@code token} to set
     * @return a reference to this Builder
     */
    public Builder token(ApplePayPaymentToken token) {
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
     * Returns a {@code ApplePay} built from the parameters previously set.
     *
     * @return a {@code ApplePay} built with parameters of this {@code ApplePay.Builder}
     */
    public ApplePay build() {
      return new ApplePay(this);
    }
  }
}

