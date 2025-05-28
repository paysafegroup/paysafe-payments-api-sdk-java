// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.CardType;
import com.paysafe.payments.model.card.enums.TokenType;

/**
 * ExternalNetworkTokenResponse
 */
public class ExternalNetworkTokenResponse {

  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("cardExpiry")
  private CardExpiry cardExpiry;
  @JsonProperty("cardType")
  private CardType cardType;
  @JsonProperty("issuingCountry")
  private String issuingCountry;
  @JsonProperty("tokenType")
  private TokenType tokenType;
  @JsonProperty("networkToken")
  private ExternalNetworkTokenResponseNetworkToken networkToken;

  public ExternalNetworkTokenResponse() {
    super();
  }

  private ExternalNetworkTokenResponse(Builder builder) {
    setLastDigits(builder.lastDigits);
    setCardExpiry(builder.cardExpiry);
    setCardType(builder.cardType);
    setIssuingCountry(builder.issuingCountry);
    setTokenType(builder.tokenType);
    setNetworkToken(builder.networkToken);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ExternalNetworkTokenResponse lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last four digits of the network token.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  public ExternalNetworkTokenResponse cardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
    return this;
  }

  /**
   * This is the card's expiry date.
   *
   * @return cardExpiry
   */
  public CardExpiry getCardExpiry() {
    return cardExpiry;
  }

  public void setCardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
  }

  public ExternalNetworkTokenResponse cardType(CardType cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * Get cardType.
   *
   * @return cardType
   */
  public CardType getCardType() {
    return cardType;
  }

  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }

  public ExternalNetworkTokenResponse issuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
    return this;
  }

  /**
   * This is the card issuing country.
   *
   * @return issuingCountry
   */
  public String getIssuingCountry() {
    return issuingCountry;
  }

  public void setIssuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
  }

  public ExternalNetworkTokenResponse tokenType(TokenType tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType. Possible value: NETWORK_TOKEN
   *
   * @return tokenType
   */
  public TokenType getTokenType() {
    return tokenType;
  }

  public void setTokenType(TokenType tokenType) {
    this.tokenType = tokenType;
  }

  public ExternalNetworkTokenResponse networkToken(ExternalNetworkTokenResponseNetworkToken networkToken) {
    this.networkToken = networkToken;
    return this;
  }

  /**
   * Holds the external network token fields
   *
   * @return networkToken
   */
  public ExternalNetworkTokenResponseNetworkToken getNetworkToken() {
    return networkToken;
  }

  public void setNetworkToken(ExternalNetworkTokenResponseNetworkToken networkToken) {
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
    ExternalNetworkTokenResponse externalNetworkTokenResponse = (ExternalNetworkTokenResponse) o;
    return Objects.equals(this.lastDigits, externalNetworkTokenResponse.lastDigits) &&
        Objects.equals(this.cardExpiry, externalNetworkTokenResponse.cardExpiry) &&
        Objects.equals(this.cardType, externalNetworkTokenResponse.cardType) &&
        Objects.equals(this.issuingCountry, externalNetworkTokenResponse.issuingCountry) &&
        Objects.equals(this.tokenType, externalNetworkTokenResponse.tokenType) &&
        Objects.equals(this.networkToken, externalNetworkTokenResponse.networkToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastDigits, cardExpiry, cardType, issuingCountry, tokenType, networkToken);
  }

  @Override
  public String toString() {

    return "class ExternalNetworkTokenResponse {\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
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
   * {@code ExternalNetworkTokenResponse} builder static inner class.
   */
  public static final class Builder {
    private String lastDigits;
    private CardExpiry cardExpiry;
    private CardType cardType;
    private String issuingCountry;
    private TokenType tokenType;
    private ExternalNetworkTokenResponseNetworkToken networkToken;

    private Builder() {
    }

    /**
     * Sets the {@code lastDigits} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the {@code lastDigits} to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * Sets the {@code cardExpiry} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardExpiry the {@code cardExpiry} to set
     * @return a reference to this Builder
     */
    public Builder cardExpiry(CardExpiry cardExpiry) {
      this.cardExpiry = cardExpiry;
      return this;
    }

    /**
     * Sets the {@code cardType} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardType the {@code cardType} to set
     * @return a reference to this Builder
     */
    public Builder cardType(CardType cardType) {
      this.cardType = cardType;
      return this;
    }

    /**
     * Sets the {@code issuingCountry} and returns a reference to this Builder enabling method chaining.
     *
     * @param issuingCountry the {@code issuingCountry} to set
     * @return a reference to this Builder
     */
    public Builder issuingCountry(String issuingCountry) {
      this.issuingCountry = issuingCountry;
      return this;
    }

    /**
     * Sets the {@code tokenType} and returns a reference to this Builder enabling method chaining.
     *
     * @param tokenType the {@code tokenType} to set
     * @return a reference to this Builder
     */
    public Builder tokenType(TokenType tokenType) {
      this.tokenType = tokenType;
      return this;
    }

    /**
     * Sets the {@code networkToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param networkToken the {@code networkToken} to set
     * @return a reference to this Builder
     */
    public Builder networkToken(ExternalNetworkTokenResponseNetworkToken networkToken) {
      this.networkToken = networkToken;
      return this;
    }

    /**
     * Returns a {@code ExternalNetworkTokenResponse} built from the parameters previously set.
     *
     * @return a {@code ExternalNetworkTokenResponse} built with parameters of this {@code ExternalNetworkTokenResponse.Builder}
     */
    public ExternalNetworkTokenResponse build() {
      return new ExternalNetworkTokenResponse(this);
    }
  }
}

