// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.PreOrderPurchaseIndicator;
import com.paysafe.payments.model.card.enums.ReOrderItemsIndicator;
import com.paysafe.payments.model.card.enums.ShippingIndicator;

/**
 * Order details
 * <ul>
 *   <li>
 *     <b>preOrderItemAvailabilityDate:</b> For a pre-ordered purchase, this is the date that the merchandise is expected to be available.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
 *   </li>
 *   <li>
 *     <b>preOrderPurchaseIndicator:</b> This indicates whether the cardholder is placing an order for available merchandise or merchandise
 *     with a future availability or release date.  <br>
 *     <i>Allowed values: MERCHANDISE_AVAILABLE, FUTURE_AVAILABILITY</i>
 *   </li>
 *   <li>
 *     <b>reorderItemsIndicator:</b> This indicates whether the cardholder is reordering merchandise.  <br>
 *     <i>Allowed values: FIRST_TIME_ORDER, REORDER</i>
 *   </li>
 *   <li>
 *     <b>shippingIndicator:</b> This is the card expiry year.  <br>
 *     Example: 2024
 *   </li>
 * </ul>
 */
public class OrderItemDetails {

  @JsonProperty("preOrderItemAvailabilityDate")
  private String preOrderItemAvailabilityDate;
  @JsonProperty("preOrderPurchaseIndicator")
  private PreOrderPurchaseIndicator preOrderPurchaseIndicator;
  @JsonProperty("reorderItemsIndicator")
  private ReOrderItemsIndicator reorderItemsIndicator;
  @JsonProperty("shippingIndicator")
  private ShippingIndicator shippingIndicator;

  public OrderItemDetails() {
    super();
  }

  private OrderItemDetails(Builder builder) {
    setPreOrderItemAvailabilityDate(builder.preOrderItemAvailabilityDate);
    setPreOrderPurchaseIndicator(builder.preOrderPurchaseIndicator);
    setReorderItemsIndicator(builder.reorderItemsIndicator);
    setShippingIndicator(builder.shippingIndicator);
  }

  public static Builder builder() {
    return new Builder();
  }

  public OrderItemDetails preOrderItemAvailabilityDate(String preOrderItemAvailabilityDate) {
    this.preOrderItemAvailabilityDate = preOrderItemAvailabilityDate;
    return this;
  }

  /**
   * For a pre-ordered purchase, this is the date that the merchandise is expected to be available. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return preOrderItemAvailabilityDate
   */
  public String getPreOrderItemAvailabilityDate() {
    return preOrderItemAvailabilityDate;
  }

  public void setPreOrderItemAvailabilityDate(String preOrderItemAvailabilityDate) {
    this.preOrderItemAvailabilityDate = preOrderItemAvailabilityDate;
  }

  public OrderItemDetails preOrderPurchaseIndicator(PreOrderPurchaseIndicator preOrderPurchaseIndicator) {
    this.preOrderPurchaseIndicator = preOrderPurchaseIndicator;
    return this;
  }

  /**
   * This indicates whether the cardholder is placing an order for available merchandise or merchandise with a future availability or release date.
   *
   * @return preOrderPurchaseIndicator
   */
  public PreOrderPurchaseIndicator getPreOrderPurchaseIndicator() {
    return preOrderPurchaseIndicator;
  }

  public void setPreOrderPurchaseIndicator(PreOrderPurchaseIndicator preOrderPurchaseIndicator) {
    this.preOrderPurchaseIndicator = preOrderPurchaseIndicator;
  }

  public OrderItemDetails reorderItemsIndicator(ReOrderItemsIndicator reorderItemsIndicator) {
    this.reorderItemsIndicator = reorderItemsIndicator;
    return this;
  }

  /**
   * This indicates whether the cardholder is reordering merchandise.
   *
   * @return reorderItemsIndicator
   */
  public ReOrderItemsIndicator getReorderItemsIndicator() {
    return reorderItemsIndicator;
  }

  public void setReorderItemsIndicator(ReOrderItemsIndicator reorderItemsIndicator) {
    this.reorderItemsIndicator = reorderItemsIndicator;
  }

  public OrderItemDetails shippingIndicator(ShippingIndicator shippingIndicator) {
    this.shippingIndicator = shippingIndicator;
    return this;
  }

  /**
   * This is the shipping method for the transaction.
   *
   * @return shippingIndicator
   */
  public ShippingIndicator getShippingIndicator() {
    return shippingIndicator;
  }

  public void setShippingIndicator(ShippingIndicator shippingIndicator) {
    this.shippingIndicator = shippingIndicator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemDetails orderItemDetails = (OrderItemDetails) o;
    return Objects.equals(this.preOrderItemAvailabilityDate, orderItemDetails.preOrderItemAvailabilityDate) &&
        Objects.equals(this.preOrderPurchaseIndicator, orderItemDetails.preOrderPurchaseIndicator) &&
        Objects.equals(this.reorderItemsIndicator, orderItemDetails.reorderItemsIndicator) &&
        Objects.equals(this.shippingIndicator, orderItemDetails.shippingIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preOrderItemAvailabilityDate, preOrderPurchaseIndicator, reorderItemsIndicator, shippingIndicator);
  }

  @Override
  public String toString() {

    return "class OrderItemDetails {\n"
        + "    preOrderItemAvailabilityDate: " + toIndentedString(preOrderItemAvailabilityDate) + "\n"
        + "    preOrderPurchaseIndicator: " + toIndentedString(preOrderPurchaseIndicator) + "\n"
        + "    reorderItemsIndicator: " + toIndentedString(reorderItemsIndicator) + "\n"
        + "    shippingIndicator: " + toIndentedString(shippingIndicator) + "\n"
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
   * {@code OrderItemDetails} builder static inner class.
   */
  public static final class Builder {
    private String preOrderItemAvailabilityDate;
    private PreOrderPurchaseIndicator preOrderPurchaseIndicator;
    private ReOrderItemsIndicator reorderItemsIndicator;
    private ShippingIndicator shippingIndicator;

    private Builder() {
    }

    /**
     * Sets the {@code preOrderItemAvailabilityDate} and returns a reference to this Builder enabling method chaining.
     *
     * @param preOrderItemAvailabilityDate the {@code preOrderItemAvailabilityDate} to set
     * @return a reference to this Builder
     */
    public Builder preOrderItemAvailabilityDate(String preOrderItemAvailabilityDate) {
      this.preOrderItemAvailabilityDate = preOrderItemAvailabilityDate;
      return this;
    }

    /**
     * Sets the {@code preOrderPurchaseIndicator} and returns a reference to this Builder enabling method chaining.
     *
     * @param preOrderPurchaseIndicator the {@code preOrderPurchaseIndicator} to set
     * @return a reference to this Builder
     */
    public Builder preOrderPurchaseIndicator(PreOrderPurchaseIndicator preOrderPurchaseIndicator) {
      this.preOrderPurchaseIndicator = preOrderPurchaseIndicator;
      return this;
    }

    /**
     * Sets the {@code reorderItemsIndicator} and returns a reference to this Builder enabling method chaining.
     *
     * @param reorderItemsIndicator the {@code reorderItemsIndicator} to set
     * @return a reference to this Builder
     */
    public Builder reorderItemsIndicator(ReOrderItemsIndicator reorderItemsIndicator) {
      this.reorderItemsIndicator = reorderItemsIndicator;
      return this;
    }

    /**
     * Sets the {@code shippingIndicator} and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingIndicator the {@code shippingIndicator} to set
     * @return a reference to this Builder
     */
    public Builder shippingIndicator(ShippingIndicator shippingIndicator) {
      this.shippingIndicator = shippingIndicator;
      return this;
    }

    /**
     * Returns a {@code OrderItemDetails} built from the parameters previously set.
     *
     * @return a {@code OrderItemDetails} built with parameters of this {@code OrderItemDetails.Builder}
     */
    public OrderItemDetails build() {
      return new OrderItemDetails(this);
    }
  }
}

