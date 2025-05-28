// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.card.enums.CardStatus;
import com.paysafe.payments.model.card.enums.CardType;

/**
 * Card details to be used for the transaction
 */
public class UpdateCustomerRequestCard {

  @JsonProperty("cardNum")
  private String cardNum;
  @JsonProperty("cardCategory")
  private String cardCategory;
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

  public UpdateCustomerRequestCard() {
    super();
  }

  private UpdateCustomerRequestCard(final Builder builder) {
    setCardNum(builder.cardNum);
    setCardCategory(builder.cardCategory);
    setCardId(builder.cardId);
    setCardExpiry(builder.cardExpiry);
    setCvv(builder.cvv);
    setHolderName(builder.holderName);
    setCardType(builder.cardType);
    setLastDigits(builder.lastDigits);
    setCardBin(builder.cardBin);
    setIssuingCountry(builder.issuingCountry);
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }

  public UpdateCustomerRequestCard cardId(String cardId) {
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

  /**
   * This is the card number.
   *
   * @return cardId
   */
  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public UpdateCustomerRequestCard cardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
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

  public UpdateCustomerRequestCard holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * This is the name of the card holder. <b>Note:</b> Holder name must contain only Latin characters (English Alphabet), Space, Apostrophe('), Dot(.)
   * or Hyphen(-). <br> Unicode normalization is done.
   *
   * @return holderName
   */
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public UpdateCustomerRequestCard cardType(CardType cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * This is type of card used for the request.
   * @return cardType
   */
  public CardType getCardType() {
    return cardType;
  }

  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }

  public UpdateCustomerRequestCard lastDigits(String lastDigits) {
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

  public UpdateCustomerRequestCard cardBin(String cardBin) {
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

  public UpdateCustomerRequestCard issuingCountry(String issuingCountry) {
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

  public UpdateCustomerRequestCard status(CardStatus status) {
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

  /**
   * DEBIT or CREDIT.
   *
   * @return cardCategory
   */
  public String getCardCategory() {
    return cardCategory;
  }

  public void setCardCategory(final String cardCategory) {
    this.cardCategory = cardCategory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCustomerRequestCard updateCustomerRequestCard = (UpdateCustomerRequestCard) o;
    return Objects.equals(this.cardId, updateCustomerRequestCard.cardId) &&
        Objects.equals(this.cardNum, updateCustomerRequestCard.cardNum) &&
        Objects.equals(this.cardExpiry, updateCustomerRequestCard.cardExpiry) &&
        Objects.equals(this.cvv, updateCustomerRequestCard.cvv) &&
        Objects.equals(this.holderName, updateCustomerRequestCard.holderName) &&
        Objects.equals(this.cardType, updateCustomerRequestCard.cardType) &&
        Objects.equals(this.lastDigits, updateCustomerRequestCard.lastDigits) &&
        Objects.equals(this.cardBin, updateCustomerRequestCard.cardBin) &&
        Objects.equals(this.cardCategory, updateCustomerRequestCard.cardCategory) &&
        Objects.equals(this.issuingCountry, updateCustomerRequestCard.issuingCountry) &&
        Objects.equals(this.status, updateCustomerRequestCard.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId, cardNum, cardExpiry, cvv, holderName, cardType, lastDigits, cardBin, cardCategory, issuingCountry, status);
  }

  @Override
  public String toString() {

    return "class UpdateCustomerRequestCard {\n"
        + "    cardId: " + toIndentedString(cardId) + "\n"
        + "    cardNum: " + toIndentedString(cardNum) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    cvv: " + toIndentedString(cvv) + "\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardBin: " + toIndentedString(cardBin) + "\n"
        + "    cardCategory: " + toIndentedString(cardCategory) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * {@code UpdateCustomerRequestCard} builder static inner class.
   */
  public static final class Builder {
    private String cardId;
    private CardExpiry cardExpiry;
    private String cvv;
    private String holderName;
    private CardType cardType;
    private String lastDigits;
    private String cardBin;
    private String cardCategory;
    private String issuingCountry;
    private CardStatus status;
    private String cardNum;

    private Builder() {
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
     * @param val the {@code cvv} to set
     * @return a reference to this Builder
     */
    public Builder cvv(final String val) {
      cvv = val;
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
     * Sets the {@code cardType} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardCategory the {@code cardCategory} to set
     * @return a reference to this Builder
     */
    public Builder cardCategory(String cardCategory) {
      this.cardCategory = cardCategory;
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
     * Returns a {@code UpdateCustomerRequestCard} built from the parameters previously set.
     *
     * @return a {@code UpdateCustomerRequestCard} built with parameters of this {@code UpdateCustomerRequestCard.Builder}
     */
    public UpdateCustomerRequestCard build() {
      return new UpdateCustomerRequestCard(this);
    }

    /**
     * Sets the {@code cardNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code cardNum} to set
     * @return a reference to this Builder
     */
    public Builder cardNum(final String val) {
      cardNum = val;
      return this;
    }
  }
}

