// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * These are 3D Secure authentication details. If you are using your own 3D Secure service provider and you want to process Card transaction with 3DS
 * then you need to pass Authentication object in Payment handle request.
 */
public class CardAuthentication {

  @JsonProperty("eci")
  private String eci = null;
  @JsonProperty("cavv")
  private String cavv = null;
  @JsonProperty("threeDResult")
  private String threeDResult = null;
  @JsonProperty("directoryServerTransactionId")
  private String directoryServerTransactionId = null;
  @JsonProperty("threeDSecureVersion")
  private String threeDSecureVersion = null;
  @JsonProperty("exemptionIndicator")
  private String exemptionIndicator = null;

  public CardAuthentication() {
    super();
  }

  private CardAuthentication(Builder builder) {
    setEci(builder.eci);
    setCavv(builder.cavv);
    setThreeDResult(builder.threeDResult);
    setDirectoryServerTransactionId(builder.directoryServerTransactionId);
    setThreeDSecureVersion(builder.threeDSecureVersion);
    setExemptionIndicator(builder.exemptionIndicator);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CardAuthentication eci(String eci) {
    this.eci = eci;
    return this;
  }

  /**
   * Get eci
   *
   * @return eci
   */
  public String getEci() {
    return eci;
  }

  public void setEci(String eci) {
    this.eci = eci;
  }

  public CardAuthentication cavv(String cavv) {
    this.cavv = cavv;
    return this;
  }

  /**
   * Get cavv
   *
   * @return cavv
   */
  public String getCavv() {
    return cavv;
  }

  public void setCavv(String cavv) {
    this.cavv = cavv;
  }

  public CardAuthentication threeDResult(String threeDResult) {
    this.threeDResult = threeDResult;
    return this;
  }

  /**
   * Get threeDResult
   *
   * @return threeDResult
   */
  public String getThreeDResult() {
    return threeDResult;
  }

  public void setThreeDResult(String threeDResult) {
    this.threeDResult = threeDResult;
  }

  public CardAuthentication directoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
    return this;
  }

  /**
   * Get directoryServerTransactionId
   *
   * @return directoryServerTransactionId
   */
  public String getDirectoryServerTransactionId() {
    return directoryServerTransactionId;
  }

  public void setDirectoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
  }

  public CardAuthentication threeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
    return this;
  }

  /**
   * Get threeDSecureVersion
   *
   * @return threeDSecureVersion
   */
  public String getThreeDSecureVersion() {
    return threeDSecureVersion;
  }

  public void setThreeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
  }

  public CardAuthentication exemptionIndicator(String exemptionIndicator) {
    this.exemptionIndicator = exemptionIndicator;
    return this;
  }

  /**
   * Get exemptionIndicator
   *
   * @return exemptionIndicator
   */
  public String getExemptionIndicator() {
    return exemptionIndicator;
  }

  public void setExemptionIndicator(String exemptionIndicator) {
    this.exemptionIndicator = exemptionIndicator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardAuthentication cardAuthentication = (CardAuthentication) o;
    return Objects.equals(this.eci, cardAuthentication.eci) &&
        Objects.equals(this.cavv, cardAuthentication.cavv) &&
        Objects.equals(this.threeDResult, cardAuthentication.threeDResult) &&
        Objects.equals(this.directoryServerTransactionId, cardAuthentication.directoryServerTransactionId) &&
        Objects.equals(this.threeDSecureVersion, cardAuthentication.threeDSecureVersion) &&
        Objects.equals(this.exemptionIndicator, cardAuthentication.exemptionIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eci, cavv, threeDResult, directoryServerTransactionId, threeDSecureVersion, exemptionIndicator);
  }

  @Override
  public String toString() {

    return "class CardAuthentication {\n"
        + "    eci: " + toIndentedString(eci) + "\n"
        + "    cavv: " + toIndentedString(cavv) + "\n"
        + "    threeDResult: " + toIndentedString(threeDResult) + "\n"
        + "    directoryServerTransactionId: " + toIndentedString(directoryServerTransactionId) + "\n"
        + "    threeDSecureVersion: " + toIndentedString(threeDSecureVersion) + "\n"
        + "    exemptionIndicator: " + toIndentedString(exemptionIndicator) + "\n"
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
   * {@code CardAuthentication} builder static inner class.
   */
  public static final class Builder {
    private String eci;
    private String cavv;
    private String threeDResult;
    private String directoryServerTransactionId;
    private String threeDSecureVersion;
    private String exemptionIndicator;

    private Builder() {
    }

    /**
     * Sets the {@code eci} and returns a reference to this Builder enabling method chaining.
     *
     * @param eci the {@code eci} to set
     * @return a reference to this Builder
     */
    public Builder eci(String eci) {
      this.eci = eci;
      return this;
    }

    /**
     * Sets the {@code cavv} and returns a reference to this Builder enabling method chaining.
     *
     * @param cavv the {@code cavv} to set
     * @return a reference to this Builder
     */
    public Builder cavv(String cavv) {
      this.cavv = cavv;
      return this;
    }

    /**
     * Sets the {@code threeDResult} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDResult the {@code threeDResult} to set
     * @return a reference to this Builder
     */
    public Builder threeDResult(String threeDResult) {
      this.threeDResult = threeDResult;
      return this;
    }

    /**
     * Sets the {@code directoryServerTransactionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param directoryServerTransactionId the {@code directoryServerTransactionId} to set
     * @return a reference to this Builder
     */
    public Builder directoryServerTransactionId(String directoryServerTransactionId) {
      this.directoryServerTransactionId = directoryServerTransactionId;
      return this;
    }

    /**
     * Sets the {@code threeDSecureVersion} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDSecureVersion the {@code threeDSecureVersion} to set
     * @return a reference to this Builder
     */
    public Builder threeDSecureVersion(String threeDSecureVersion) {
      this.threeDSecureVersion = threeDSecureVersion;
      return this;
    }

    /**
     * Sets the {@code exemptionIndicator} and returns a reference to this Builder enabling method chaining.
     *
     * @param exemptionIndicator the {@code exemptionIndicator} to set
     * @return a reference to this Builder
     */
    public Builder exemptionIndicator(String exemptionIndicator) {
      this.exemptionIndicator = exemptionIndicator;
      return this;
    }

    /**
     * Returns a {@code CardAuthentication} built from the parameters previously set.
     *
     * @return a {@code CardAuthentication} built with parameters of this {@code CardAuthentication.Builder}
     */
    public CardAuthentication build() {
      return new CardAuthentication(this);
    }
  }
}

