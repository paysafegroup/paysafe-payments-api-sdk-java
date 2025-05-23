// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.applepay.ApplePayTokenDetails;
import com.paysafe.payments.model.card.enums.CardCategory;
import com.paysafe.payments.model.card.enums.CardStatus;
import com.paysafe.payments.model.card.enums.CardType;
import com.paysafe.payments.model.card.enums.TokenType;

/**
 * CardWithOptionalNetworkTokenOrApplePay
 */
public class CardWithOptionalNetworkTokenOrApplePay {

  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("cardId")
  private String cardId;
  @JsonProperty("cardExpiry")
  private CardExpiry cardExpiry;
  @JsonProperty("cardBin")
  private String cardBin;
  @JsonProperty("cardType")
  private CardType cardType;
  @JsonProperty("holderName")
  private String holderName;
  @JsonProperty("status")
  private CardStatus status;
  @JsonProperty("cardCategory")
  private CardCategory cardCategory;
  @JsonProperty("applePay")
  private ApplePayTokenDetails applePay;
  @JsonProperty("tokenType")
  private TokenType tokenType;
  @JsonProperty("networkToken")
  private NetworkToken networkToken;
  @JsonProperty("issuingCountry")
  private String issuingCountry;

  public CardWithOptionalNetworkTokenOrApplePay() {
    super();
  }

  private CardWithOptionalNetworkTokenOrApplePay(Builder builder) {
    setLastDigits(builder.lastDigits);
    setCardId(builder.cardId);
    setCardExpiry(builder.cardExpiry);
    setCardBin(builder.cardBin);
    setCardType(builder.cardType);
    setHolderName(builder.holderName);
    setStatus(builder.status);
    setCardCategory(builder.cardCategory);
    setApplePay(builder.applePay);
    setTokenType(builder.tokenType);
    setNetworkToken(builder.networkToken);
    setIssuingCountry(builder.issuingCountry);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CardWithOptionalNetworkTokenOrApplePay lastDigits(String lastDigits) {
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

  public CardWithOptionalNetworkTokenOrApplePay cardId(String cardId) {
    this.cardId = cardId;
    return this;
  }

  /**
   * This is the card id returned in the response during save card flow.
   *
   * @return cardId
   */
  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public CardWithOptionalNetworkTokenOrApplePay cardExpiry(CardExpiry cardExpiry) {
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

  public CardWithOptionalNetworkTokenOrApplePay cardBin(String cardBin) {
    this.cardBin = cardBin;
    return this;
  }

  /**
   * These are the first 6 digits of the card Bank Identification Number (BIN), for example: the first 6 digits of the card number.
   *
   * @return cardBin
   */
  public String getCardBin() {
    return cardBin;
  }

  public void setCardBin(String cardBin) {
    this.cardBin = cardBin;
  }

  public CardWithOptionalNetworkTokenOrApplePay cardType(CardType cardType) {
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

  public CardWithOptionalNetworkTokenOrApplePay holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * This is the name of the cardholder.
   * For 3DS2, Holder name must contain only Latin characters (English Alphabet), Space, Apostrophe ('), Dot (.) or Hyphen (-).
   *
   * @return holderName
   */
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public CardWithOptionalNetworkTokenOrApplePay status(CardStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Optional. Present only if the card is stored for the Customer.
   *
   * @return status
   */
  public CardStatus getStatus() {
    return status;
  }

  public void setStatus(CardStatus status) {
    this.status = status;
  }

  public CardWithOptionalNetworkTokenOrApplePay cardCategory(CardCategory cardCategory) {
    this.cardCategory = cardCategory;
    return this;
  }

  /**
   * The type of card being used. CREDIT or DEBIT
   *
   * @return cardCategory
   */
  public CardCategory getCardCategory() {
    return cardCategory;
  }

  public void setCardCategory(CardCategory cardCategory) {
    this.cardCategory = cardCategory;
  }

  public CardWithOptionalNetworkTokenOrApplePay applePay(ApplePayTokenDetails applePay) {
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

  public CardWithOptionalNetworkTokenOrApplePay tokenType(TokenType tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType. Possible values: NETWORK_TOKEN
   *
   * @return tokenType
   */
  public TokenType getTokenType() {
    return tokenType;
  }

  public void setTokenType(TokenType tokenType) {
    this.tokenType = tokenType;
  }

  public CardWithOptionalNetworkTokenOrApplePay networkToken(NetworkToken networkToken) {
    this.networkToken = networkToken;
    return this;
  }

  /**
   * Holds the external network token fields
   *
   * @return networkToken
   */
  public NetworkToken getNetworkToken() {
    return networkToken;
  }

  public void setNetworkToken(NetworkToken networkToken) {
    this.networkToken = networkToken;
  }

  public CardWithOptionalNetworkTokenOrApplePay issuingCountry(String issuingCountry) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardWithOptionalNetworkTokenOrApplePay cardWithOptionalNetworkTokenOrApplePay = (CardWithOptionalNetworkTokenOrApplePay) o;
    return Objects.equals(this.lastDigits, cardWithOptionalNetworkTokenOrApplePay.lastDigits) &&
        Objects.equals(this.cardId, cardWithOptionalNetworkTokenOrApplePay.cardId) &&
        Objects.equals(this.cardExpiry, cardWithOptionalNetworkTokenOrApplePay.cardExpiry) &&
        Objects.equals(this.cardBin, cardWithOptionalNetworkTokenOrApplePay.cardBin) &&
        Objects.equals(this.cardType, cardWithOptionalNetworkTokenOrApplePay.cardType) &&
        Objects.equals(this.holderName, cardWithOptionalNetworkTokenOrApplePay.holderName) &&
        Objects.equals(this.status, cardWithOptionalNetworkTokenOrApplePay.status) &&
        Objects.equals(this.cardCategory, cardWithOptionalNetworkTokenOrApplePay.cardCategory) &&
        Objects.equals(this.applePay, cardWithOptionalNetworkTokenOrApplePay.applePay) &&
        Objects.equals(this.tokenType, cardWithOptionalNetworkTokenOrApplePay.tokenType) &&
        Objects.equals(this.networkToken, cardWithOptionalNetworkTokenOrApplePay.networkToken) &&
        Objects.equals(this.issuingCountry, cardWithOptionalNetworkTokenOrApplePay.issuingCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastDigits, cardId, cardExpiry, cardBin, cardType, holderName, status, cardCategory, applePay, tokenType, networkToken, issuingCountry);
  }

  @Override
  public String toString() {

    return "class CardWithOptionalNetworkTokenOrApplePay {\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardId: " + toIndentedString(cardId) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    cardBin: " + toIndentedString(cardBin) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    cardCategory: " + toIndentedString(cardCategory) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
        + "    tokenType: " + toIndentedString(tokenType) + "\n"
        + "    networkToken: " + toIndentedString(networkToken) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
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
   * {@code CardWithOptionalNetworkTokenOrApplePay} builder static inner class.
   */
  public static final class Builder {
    private String lastDigits;
    private String cardId;
    private CardExpiry cardExpiry;
    private String cardBin;
    private CardType cardType;
    private String holderName;
    private CardStatus status;
    private CardCategory cardCategory;
    private ApplePayTokenDetails applePay;
    private TokenType tokenType;
    private NetworkToken networkToken;
    private String issuingCountry;

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
     * Sets the {@code cardId} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardId the {@code cardId} to set
     * @return a reference to this Builder
     */
    public Builder cardId(String cardId) {
      this.cardId = cardId;
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
     * Sets the {@code cardBin} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardBin the {@code cardBin} to set
     * @return a reference to this Builder
     */
    public Builder cardBin(String cardBin) {
      this.cardBin = cardBin;
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
     * Sets the {@code holderName} and returns a reference to this Builder enabling method chaining.
     *
     * @param holderName the {@code holderName} to set
     * @return a reference to this Builder
     */
    public Builder holderName(String holderName) {
      this.holderName = holderName;
      return this;
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(CardStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code cardCategory} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardCategory the {@code cardCategory} to set
     * @return a reference to this Builder
     */
    public Builder cardCategory(CardCategory cardCategory) {
      this.cardCategory = cardCategory;
      return this;
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
    public Builder networkToken(NetworkToken networkToken) {
      this.networkToken = networkToken;
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
     * Returns a {@code CardWithOptionalNetworkTokenOrApplePay} built from the parameters previously set.
     *
     * @return a {@code CardWithOptionalNetworkTokenOrApplePay} built with parameters of this
     * {@code CardWithOptionalNetworkTokenOrApplePay.Builder}
     */
    public CardWithOptionalNetworkTokenOrApplePay build() {
      return new CardWithOptionalNetworkTokenOrApplePay(this);
    }
  }
}

