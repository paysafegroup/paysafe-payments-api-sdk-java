// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.InitialUsageRange;

/**
 * This is the shipping usage information.
 * <ul>
 *   <li>
 *     <b>cardHolderNameMatch:</b> This indicates whether the cardholder name on the account is identical
 *     to the shipping name used for this transaction.
 *   </li>
 *   <li>
 *     <b>initialUsageDate:</b> This is the date when the shipping address for this transaction was first used with the 3DS Requestor.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
 *   </li>
 *   <li>
 *     <b>initialUsageRange:</b> This is the card expiry month.  <br>
 *     <i>Allowed values: CURRENT_TRANSACTION, LESS_THAN_THIRTY_DAYS, THIRTY_TO_SIXTY_DAYS, MORE_THAN_SIXTY_DAYS</i>
 *   </li>
 * </ul>
 */
public class ShippingDetailsUsage {

  @JsonProperty("cardHolderNameMatch")
  private Boolean cardHolderNameMatch;
  @JsonProperty("initialUsageDate")
  private String initialUsageDate;
  @JsonProperty("initialUsageRange")
  private InitialUsageRange initialUsageRange;

  public ShippingDetailsUsage() {
    super();
  }

  private ShippingDetailsUsage(Builder builder) {
    setCardHolderNameMatch(builder.cardHolderNameMatch);
    setInitialUsageDate(builder.initialUsageDate);
    setInitialUsageRange(builder.initialUsageRange);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ShippingDetailsUsage cardHolderNameMatch(Boolean cardHolderNameMatch) {
    this.cardHolderNameMatch = cardHolderNameMatch;
    return this;
  }

  /**
   * This indicates whether the cardholder name on the account is identical to the shipping name used for this transaction.
   *
   * @return cardHolderNameMatch
   */
  public Boolean getCardHolderNameMatch() {
    return cardHolderNameMatch;
  }

  public void setCardHolderNameMatch(Boolean cardHolderNameMatch) {
    this.cardHolderNameMatch = cardHolderNameMatch;
  }

  public ShippingDetailsUsage initialUsageDate(String initialUsageDate) {
    this.initialUsageDate = initialUsageDate;
    return this;
  }

  /**
   * This is the date when the shipping address for this transaction was first used with the 3DS Requestor.
   * The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return initialUsageDate
   */
  public String getInitialUsageDate() {
    return initialUsageDate;
  }

  public void setInitialUsageDate(String initialUsageDate) {
    this.initialUsageDate = initialUsageDate;
  }

  public ShippingDetailsUsage initialUsageRange(InitialUsageRange initialUsageRange) {
    this.initialUsageRange = initialUsageRange;
    return this;
  }

  /**
   * Get initialUsageRange
   *
   * @return initialUsageRange
   */
  public InitialUsageRange getInitialUsageRange() {
    return initialUsageRange;
  }

  public void setInitialUsageRange(InitialUsageRange initialUsageRange) {
    this.initialUsageRange = initialUsageRange;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingDetailsUsage shippingDetailsUsage = (ShippingDetailsUsage) o;
    return Objects.equals(this.cardHolderNameMatch, shippingDetailsUsage.cardHolderNameMatch) &&
        Objects.equals(this.initialUsageDate, shippingDetailsUsage.initialUsageDate) &&
        Objects.equals(this.initialUsageRange, shippingDetailsUsage.initialUsageRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardHolderNameMatch, initialUsageDate, initialUsageRange);
  }

  @Override
  public String toString() {

    return "class ShippingDetailsUsage {\n"
        + "    cardHolderNameMatch: " + toIndentedString(cardHolderNameMatch) + "\n"
        + "    initialUsageDate: " + toIndentedString(initialUsageDate) + "\n"
        + "    initialUsageRange: " + toIndentedString(initialUsageRange) + "\n"
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
   * {@code ShippingDetailsUsage} builder static inner class.
   */
  public static final class Builder {
    private Boolean cardHolderNameMatch;
    private String initialUsageDate;
    private InitialUsageRange initialUsageRange;

    private Builder() {
    }

    /**
     * Sets the {@code cardHolderNameMatch} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardHolderNameMatch the {@code cardHolderNameMatch} to set
     * @return a reference to this Builder
     */
    public Builder cardHolderNameMatch(Boolean cardHolderNameMatch) {
      this.cardHolderNameMatch = cardHolderNameMatch;
      return this;
    }

    /**
     * Sets the {@code initialUsageDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param initialUsageDate the {@code initialUsageDate} to set
     * @return a reference to this Builder
     */
    public Builder initialUsageDate(String initialUsageDate) {
      this.initialUsageDate = initialUsageDate;
      return this;
    }

    /**
     * Sets the {@code initialUsageRange} and returns a reference to this Builder enabling method chaining.
     *
     * @param initialUsageRange the {@code initialUsageRange} to set
     * @return a reference to this Builder
     */
    public Builder initialUsageRange(InitialUsageRange initialUsageRange) {
      this.initialUsageRange = initialUsageRange;
      return this;
    }

    /**
     * Returns a {@code ShippingDetailsUsage} built from the parameters previously set.
     *
     * @return a {@code ShippingDetailsUsage} built with parameters of this {@code ShippingDetailsUsage.Builder}
     */
    public ShippingDetailsUsage build() {
      return new ShippingDetailsUsage(this);
    }
  }
}

