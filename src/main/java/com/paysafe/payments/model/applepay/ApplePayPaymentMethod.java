// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payment method parameter returned by Apple Pay JS
 */
public class ApplePayPaymentMethod {

  @JsonProperty("displayName")
  private String displayName;
  @JsonProperty("network")
  private String network;
  @JsonProperty("type")
  private String type;

  public ApplePayPaymentMethod() {
    super();
  }

  private ApplePayPaymentMethod(Builder builder) {
    setDisplayName(builder.displayName);
    setNetwork(builder.network);
    setType(builder.type);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayPaymentMethod displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Display name property returned by Apple Pay JS
   *
   * @return displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ApplePayPaymentMethod network(String network) {
    this.network = network;
    return this;
  }

  /**
   * Network property returned by Apple Pay JS
   *
   * @return network
   */
  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public ApplePayPaymentMethod type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type property returned by Apple Pay JS
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayPaymentMethod applePayPaymentMethod = (ApplePayPaymentMethod) o;
    return Objects.equals(this.displayName, applePayPaymentMethod.displayName) &&
        Objects.equals(this.network, applePayPaymentMethod.network) &&
        Objects.equals(this.type, applePayPaymentMethod.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, network, type);
  }

  @Override
  public String toString() {

    return "class ApplePayPaymentMethod {\n"
        + "    displayName: " + toIndentedString(displayName) + "\n"
        + "    network: " + toIndentedString(network) + "\n"
        + "    type: " + toIndentedString(type) + "\n"
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
   * {@code ApplePayPaymentMethod} builder static inner class.
   */
  public static final class Builder {
    private String displayName;
    private String network;
    private String type;

    private Builder() {
    }

    /**
     * Sets the {@code displayName} and returns a reference to this Builder enabling method chaining.
     *
     * @param displayName the {@code displayName} to set
     * @return a reference to this Builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Sets the {@code network} and returns a reference to this Builder enabling method chaining.
     *
     * @param network the {@code network} to set
     * @return a reference to this Builder
     */
    public Builder network(String network) {
      this.network = network;
      return this;
    }

    /**
     * Sets the {@code type} and returns a reference to this Builder enabling method chaining.
     *
     * @param type the {@code type} to set
     * @return a reference to this Builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Returns a {@code ApplePayPaymentMethod} built from the parameters previously set.
     *
     * @return a {@code ApplePayPaymentMethod} built with parameters of this
     * {@code ApplePayPaymentMethod.Builder}
     */
    public ApplePayPaymentMethod build() {
      return new ApplePayPaymentMethod(this);
    }
  }
}

