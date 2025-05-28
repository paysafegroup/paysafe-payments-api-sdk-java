// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.applepay.ApplePayTokenDetails;
import com.paysafe.payments.model.card.enums.CardStatus;
import com.paysafe.payments.model.card.enums.CardType;

/**
 * Card information
 * <ul>
 *   <li>
 *     <b>lastDigits:</b> These are the last four digits of the card used for the request.
 *   </li>
 *   <li>
 *     <b>cardExpiry:</b> This is the card's expiry date.
 *   </li>
 *   <li>
 *     <b>cardBin:</b> These are the first 6 digits of the card Bank Identification Number (BIN).
 *     For example: the first 6 digits of the card number.  <br>
 *     Example: 411111
 *   </li>
 *   <li>
 *     <b>cardType:</b> This is type of card used for the request.  <br>
 *     <i>Allowed values: AM, DI, JC, MC, MD, SO, VI, VD, VE</i>
 *   </li>
 *   <li>
 *     <b>holderName:</b> This is the name of the card holder.  <br>
 *     For 3DS2, Holder name must contain only Latin characters (English Alphabet), Space, Apostrophe ('), Dot (.) or Hyphen (-)  <br>
 *     Example: Suresh
 *   </li>
 *   <li>
 *     <b>status:</b> This is <b>Optional</b> - it is present only if the card is stored for the Customer.  <br>
 *     <i>Allowed values: ACTIVE, SUSPENDED</i>
 *   </li>
 *   <li>
 *     <b>cardCategory:</b> The type of card being used.  <br>
 *     <i>Allowed values: CREDIT, DEBIT</i>
 *   </li>
 *   <li>
 *     <b>tokenType:</b> This is the token type.  <br>
 *     <i>Allowed values: APPLE_PAY, NETWORK_TOKEN</i>
 *   </li>
 *   <li>
 *     <b>applePay:</b> When tokenType=APPLE_PAY. Apple Pay token information.
 *     Returned when the stored payment method is an Apple Pay token.
 *   </li>
 *   <li>
 *     <b>networkToken:</b> Holds network token fields.
 *   </li>
 *   <li>
 *     <b>issuingCountry:</b> This is the card issuing country.  <br>
 *     Example: US
 *   </li>
 * </ul>
 */
public class Card {

  @JsonProperty("cardNum")
  private String cardNum;
  @JsonProperty("cardId")
  private String cardId;
  @JsonProperty("cardExpiry")
  private CardExpiry cardExpiry;
  @JsonProperty("cvv")
  private String cvv;
  @JsonProperty("holderName")
  private String holderName;
  @JsonProperty("cardType")
  private CardType cardType;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("cardBin")
  private String cardBin;
  @JsonProperty("issuingCountry")
  private String issuingCountry;
  @JsonProperty("status")
  private CardStatus status;
  @JsonProperty("applePay")
  private ApplePayTokenDetails applePay;
  @JsonProperty("tokenType")
  private String tokenType;
  @JsonProperty("networkToken")
  private ExternalNetworkTokenRequest networkToken;

  public Card() {
    super();
  }

  private Card(Builder builder) {
    setCardNum(builder.cardNum);
    setCardId(builder.cardId);
    setCardExpiry(builder.cardExpiry);
    setCvv(builder.cvv);
    setHolderName(builder.holderName);
    setCardType(builder.cardType);
    setLastDigits(builder.lastDigits);
    setCardBin(builder.cardBin);
    setIssuingCountry(builder.issuingCountry);
    setStatus(builder.status);
    setApplePay(builder.applePay);
    setTokenType(builder.tokenType);
    setNetworkToken(builder.networkToken);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Card cardNum(String cardNum) {
    this.cardNum = cardNum;
    return this;
  }

  /**
   * This is the card number used for the request.
   *
   * @return cardNum
   */
  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public Card cardId(String cardId) {
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

  public Card cardExpiry(CardExpiry cardExpiry) {
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

  public Card cvv(String cvv) {
    this.cvv = cvv;
    return this;
  }

  /**
   * This is the 3- or 4-digit security code that appears on the card following the card number.
   *
   * @return cvv
   */
  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public Card holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * This is the name of the cardholder. Mandatory for 3DS flow. Holder name must contain only Latin characters (English
   * Alphabet), Space, Apostrophe('), Dot(.) or Hyphen(-). <br>
   * Unicode normalization is done.
   *
   * @return holderName
   */
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public Card cardType(CardType cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * This is type of card used for the request.
   *
   * @return cardType
   */
  public CardType getCardType() {
    return cardType;
  }

  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }

  public Card lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last four digits of the card used for the request.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  public Card cardBin(String cardBin) {
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

  public Card issuingCountry(String issuingCountry) {
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

  public Card status(CardStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Optional.  Present only if the card is part of a Customer.
   *
   * @return status
   */
  public CardStatus getStatus() {
    return status;
  }

  public void setStatus(CardStatus status) {
    this.status = status;
  }

  public Card applePay(ApplePayTokenDetails applePay) {
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

  public Card tokenType(String tokenType) {
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

  public Card networkToken(ExternalNetworkTokenRequest networkToken) {
    this.networkToken = networkToken;
    return this;
  }

  /**
   * Get networkToken
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
    Card card = (Card) o;
    return Objects.equals(this.cardNum, card.cardNum) &&
        Objects.equals(this.cardId, card.cardId) &&
        Objects.equals(this.cardExpiry, card.cardExpiry) &&
        Objects.equals(this.cvv, card.cvv) &&
        Objects.equals(this.holderName, card.holderName) &&
        Objects.equals(this.cardType, card.cardType) &&
        Objects.equals(this.lastDigits, card.lastDigits) &&
        Objects.equals(this.cardBin, card.cardBin) &&
        Objects.equals(this.issuingCountry, card.issuingCountry) &&
        Objects.equals(this.status, card.status) &&
        Objects.equals(this.applePay, card.applePay) &&
        Objects.equals(this.tokenType, card.tokenType) &&
        Objects.equals(this.networkToken, card.networkToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNum, cardId, cardExpiry, cvv, holderName, cardType, lastDigits, cardBin, issuingCountry, status, applePay, tokenType, networkToken);
  }

  @Override
  public String toString() {

    return "class Card {\n"
        + "    cardNum: " + toIndentedString(cardNum) + "\n"
        + "    cardId: " + toIndentedString(cardId) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    cvv: " + toIndentedString(cvv) + "\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardBin: " + toIndentedString(cardBin) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
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
   * {@code Card} builder static inner class.
   */
  public static final class Builder {
    private String cardNum;
    private String cardId;
    private CardExpiry cardExpiry;
    private String cvv;
    private String holderName;
    private CardType cardType;
    private String lastDigits;
    private String cardBin;
    private String issuingCountry;
    private CardStatus status;
    private ApplePayTokenDetails applePay;
    private String tokenType;
    private ExternalNetworkTokenRequest networkToken;

    private Builder() {
    }

    /**
     * Sets the {@code cardNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardNum the {@code cardNum} to set
     * @return a reference to this Builder
     */
    public Builder cardNum(String cardNum) {
      this.cardNum = cardNum;
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
     * Sets the {@code cvv} and returns a reference to this Builder enabling method chaining.
     *
     * @param cvv the {@code cvv} to set
     * @return a reference to this Builder
     */
    public Builder cvv(String cvv) {
      this.cvv = cvv;
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
     * Returns a {@code Card} built from the parameters previously set.
     *
     * @return a {@code Card} built with parameters of this {@code Card.Builder}
     */
    public Card build() {
      return new Card(this);
    }
  }
}

