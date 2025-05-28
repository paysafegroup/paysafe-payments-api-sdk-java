// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.applepay;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.CardCategory;

/**
 * These are card details
 */
public class ApplePayResponseObjectCard {

  @JsonProperty("holderName")
  private String holderName;
  @JsonProperty("status")
  private String status;
  @JsonProperty("lastDigits")
  private Long lastDigits;
  @JsonProperty("cardCategory")
  private CardCategory cardCategory;

  public ApplePayResponseObjectCard() {
    super();
  }

  private ApplePayResponseObjectCard(Builder builder) {
    setHolderName(builder.holderName);
    setStatus(builder.status);
    setLastDigits(builder.lastDigits);
    setCardCategory(builder.cardCategory);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ApplePayResponseObjectCard holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * This is the name of the cardholder. HolderName is taken from billing contact information returned by Apple Pay (givenName, familyName)
   *
   * @return holderName
   */
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public ApplePayResponseObjectCard status(String status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of authentication, returned in the response.
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ApplePayResponseObjectCard lastDigits(Long lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last four digits of the card used for the request.
   *
   * @return lastDigits
   */
  public Long getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(Long lastDigits) {
    this.lastDigits = lastDigits;
  }

  public ApplePayResponseObjectCard cardCategory(CardCategory cardCategory) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayResponseObjectCard applePayResponseObjectCard = (ApplePayResponseObjectCard) o;
    return Objects.equals(this.holderName, applePayResponseObjectCard.holderName) &&
        Objects.equals(this.status, applePayResponseObjectCard.status) &&
        Objects.equals(this.lastDigits, applePayResponseObjectCard.lastDigits) &&
        Objects.equals(this.cardCategory, applePayResponseObjectCard.cardCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(holderName, status, lastDigits, cardCategory);
  }

  @Override
  public String toString() {

    return "class ApplePayResponseObjectCard {\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardCategory: " + toIndentedString(cardCategory) + "\n"
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
   * {@code ApplePayResponseObjectCard} builder static inner class.
   */
  public static final class Builder {
    private String holderName;
    private String status;
    private Long lastDigits;
    private CardCategory cardCategory;

    private Builder() {
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
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code lastDigits} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the {@code lastDigits} to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(Long lastDigits) {
      this.lastDigits = lastDigits;
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
     * Returns a {@code ApplePayResponseObjectCard} built from the parameters previously set.
     *
     * @return a {@code ApplePayResponseObjectCard} built with parameters of this {@code ApplePayResponseObjectCard.Builder}
     */
    public ApplePayResponseObjectCard build() {
      return new ApplePayResponseObjectCard(this);
    }
  }
}

