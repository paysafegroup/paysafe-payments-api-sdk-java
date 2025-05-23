// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.enums.CurrencyCode;

/**
 * Purchased gift card details
 * <ul>
 *   <li>
 *     <b>amount:</b> This is the amount of the gift card, in minor units.  <br>
 *     Example: 1234
 *   </li>
 *   <li>
 *     <b>count:</b> This is the total count of individual prepaid or gift cards or codes purchased.  <br>
 *     Example: 2
 *   </li>
 *   <li>
 *     <b>currency:</b> This is the currency of the gift card. See
 *     <a href="https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes">Currency Codes</a> <br>
 *     Example: USD
 *   </li>
 * </ul>
 */
public class PurchasedGiftCardDetails {

  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("count")
  private Integer count;
  @JsonProperty("currency")
  private CurrencyCode currency;

  public PurchasedGiftCardDetails() {
    super();
  }

  private PurchasedGiftCardDetails(Builder builder) {
    setAmount(builder.amount);
    setCount(builder.count);
    setCurrency(builder.currency);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PurchasedGiftCardDetails amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the gift card, in minor units.  <br>
   * Maximum: 99999999999
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public PurchasedGiftCardDetails count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * This is the total count of individual prepaid or gift cards or codes purchased.  <br>
   * Maximum: 99
   *
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public PurchasedGiftCardDetails currency(CurrencyCode currency) {
    this.currency = currency;
    return this;
  }

  /**
   * This is the currency of the gift card, e.g., USD or CAD.
   *
   * @return currency
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes>Currency codes reference documentation</a>
   */
  public CurrencyCode getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyCode currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchasedGiftCardDetails purchasedGiftCardDetails = (PurchasedGiftCardDetails) o;
    return Objects.equals(this.amount, purchasedGiftCardDetails.amount) &&
        Objects.equals(this.count, purchasedGiftCardDetails.count) &&
        Objects.equals(this.currency, purchasedGiftCardDetails.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, count, currency);
  }

  @Override
  public String toString() {

    return "class PurchasedGiftCardDetails {\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    count: " + toIndentedString(count) + "\n"
        + "    currency: " + toIndentedString(currency) + "\n"
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
   * {@code PurchasedGiftCardDetails} builder static inner class.
   */
  public static final class Builder {
    private Integer amount;
    private Integer count;
    private CurrencyCode currency;

    private Builder() {
    }

    /**
     * Sets the {@code amount} and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the {@code amount} to set
     * @return a reference to this Builder
     */
    public Builder amount(Integer amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Sets the {@code count} and returns a reference to this Builder enabling method chaining.
     *
     * @param count the {@code count} to set
     * @return a reference to this Builder
     */
    public Builder count(Integer count) {
      this.count = count;
      return this;
    }

    /**
     * Sets the {@code currency} and returns a reference to this Builder enabling method chaining.
     *
     * @param currency the {@code currency} to set
     * @return a reference to this Builder
     */
    public Builder currency(CurrencyCode currency) {
      this.currency = currency;
      return this;
    }

    /**
     * Returns a {@code PurchasedGiftCardDetails} built from the parameters previously set.
     *
     * @return a {@code PurchasedGiftCardDetails} built with parameters of this {@code PurchasedGiftCardDetails.Builder}
     */
    public PurchasedGiftCardDetails build() {
      return new PurchasedGiftCardDetails(this);
    }
  }
}

