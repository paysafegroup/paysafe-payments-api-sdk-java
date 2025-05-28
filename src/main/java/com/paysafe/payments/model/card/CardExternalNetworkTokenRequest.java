// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CardExternalNetworkTokenRequest
 */
public class CardExternalNetworkTokenRequest {

  @JsonProperty("tokenType")
  private String tokenType;
  @JsonProperty("networkToken")
  private ExternalNetworkTokenRequest networkToken;

  public CardExternalNetworkTokenRequest() {
    super();
  }

  private CardExternalNetworkTokenRequest(Builder builder) {
    setTokenType(builder.tokenType);
    setNetworkToken(builder.networkToken);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CardExternalNetworkTokenRequest tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType
   *
   * @return tokenType
   */
  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public CardExternalNetworkTokenRequest networkToken(ExternalNetworkTokenRequest networkToken) {
    this.networkToken = networkToken;
    return this;
  }

  /**
   * Get networkToken. Possible value: NETWORK_TOKEN
   *
   * @return networkToken
   */
  public ExternalNetworkTokenRequest getNetworkToken() {
    return networkToken;
  }

  public void setNetworkToken(ExternalNetworkTokenRequest networkToken) {
    this.networkToken = networkToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardExternalNetworkTokenRequest cardExternalNetworkTokenRequest = (CardExternalNetworkTokenRequest) o;
    return Objects.equals(this.tokenType, cardExternalNetworkTokenRequest.tokenType) &&
        Objects.equals(this.networkToken, cardExternalNetworkTokenRequest.networkToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenType, networkToken);
  }

  @Override
  public String toString() {

    return "class CardExternalNetworkTokenRequest {\n"
        + "    tokenType: " + toIndentedString(tokenType) + "\n"
        + "    networkToken: " + toIndentedString(networkToken) + "\n"
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
   * {@code CardExternalNetworkTokenRequest} builder static inner class.
   */
  public static final class Builder {
    private String tokenType;
    private ExternalNetworkTokenRequest networkToken;

    private Builder() {
    }

    /**
     * Sets the {@code tokenType} and returns a reference to this Builder enabling method chaining.
     *
     * @param tokenType the {@code tokenType} to set
     * @return a reference to this Builder
     */
    public Builder tokenType(String tokenType) {
      this.tokenType = tokenType;
      return this;
    }

    /**
     * Sets the {@code networkToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param networkToken the {@code networkToken} to set
     * @return a reference to this Builder
     */
    public Builder networkToken(ExternalNetworkTokenRequest networkToken) {
      this.networkToken = networkToken;
      return this;
    }

    /**
     * Returns a {@code CardExternalNetworkTokenRequest} built from the parameters previously set.
     *
     * @return a {@code CardExternalNetworkTokenRequest} built with parameters of this {@code CardExternalNetworkTokenRequest.Builder}
     */
    public CardExternalNetworkTokenRequest build() {
      return new CardExternalNetworkTokenRequest(this);
    }
  }
}

