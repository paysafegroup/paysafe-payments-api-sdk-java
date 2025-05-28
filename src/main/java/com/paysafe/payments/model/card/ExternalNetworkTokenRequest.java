// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExternalNetworkTokenRequest
 */
public class ExternalNetworkTokenRequest {

  @JsonProperty("token")
  private String token;
  @JsonProperty("cryptogram")
  private String cryptogram;
  @JsonProperty("expiry")
  private CardExpiry expiry;

  public ExternalNetworkTokenRequest() {
    super();
  }

  private ExternalNetworkTokenRequest(Builder builder) {
    setToken(builder.token);
    setCryptogram(builder.cryptogram);
    setExpiry(builder.expiry);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ExternalNetworkTokenRequest token(String token) {
    this.token = token;
    return this;
  }

  /**
   * This is the actual network token.
   *
   * @return token
   */
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ExternalNetworkTokenRequest cryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
    return this;
  }

  /**
   * This is the cryptogram that will be used.
   *
   * @return cryptogram
   */
  public String getCryptogram() {
    return cryptogram;
  }

  public void setCryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
  }

  public ExternalNetworkTokenRequest expiry(CardExpiry expiry) {
    this.expiry = expiry;
    return this;
  }

  /**
   * This is the card's expiry date.
   *
   * @return expiry
   */
  public CardExpiry getExpiry() {
    return expiry;
  }

  public void setExpiry(CardExpiry expiry) {
    this.expiry = expiry;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalNetworkTokenRequest externalNetworkTokenRequest = (ExternalNetworkTokenRequest) o;
    return Objects.equals(this.token, externalNetworkTokenRequest.token) &&
        Objects.equals(this.cryptogram, externalNetworkTokenRequest.cryptogram) &&
        Objects.equals(this.expiry, externalNetworkTokenRequest.expiry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, cryptogram, expiry);
  }

  @Override
  public String toString() {

    return "class ExternalNetworkTokenRequest {\n"
        + "    token: " + toIndentedString(token) + "\n"
        + "    cryptogram: " + toIndentedString(cryptogram) + "\n"
        + "    expiry: " + toIndentedString(expiry) + "\n"
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
   * {@code ExternalNetworkTokenRequest} builder static inner class.
   */
  public static final class Builder {
    private String token;
    private String cryptogram;
    private CardExpiry expiry;

    private Builder() {
    }

    /**
     * Sets the {@code token} and returns a reference to this Builder enabling method chaining.
     *
     * @param token the {@code token} to set
     * @return a reference to this Builder
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }

    /**
     * Sets the {@code cryptogram} and returns a reference to this Builder enabling method chaining.
     *
     * @param cryptogram the {@code cryptogram} to set
     * @return a reference to this Builder
     */
    public Builder cryptogram(String cryptogram) {
      this.cryptogram = cryptogram;
      return this;
    }

    /**
     * Sets the {@code expiry} and returns a reference to this Builder enabling method chaining.
     *
     * @param expiry the {@code expiry} to set
     * @return a reference to this Builder
     */
    public Builder expiry(CardExpiry expiry) {
      this.expiry = expiry;
      return this;
    }

    /**
     * Returns a {@code ExternalNetworkTokenRequest} built from the parameters previously set.
     *
     * @return a {@code ExternalNetworkTokenRequest} built with parameters of this {@code ExternalNetworkTokenRequest.Builder}
     */
    public ExternalNetworkTokenRequest build() {
      return new ExternalNetworkTokenRequest(this);
    }
  }
}

