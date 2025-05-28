// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object should be used only for Splitpay transactions only, an array containing the linked accounts and the amount shared with each.
 * You must include either amount or percent. However, you cannot include both values.
 */
public class Splitpay {

  @JsonProperty("linkedAccount")
  private String linkedAccount;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("percent")
  private Long percent;

  public Splitpay() {
    super();
  }

  private Splitpay(Builder builder) {
    setLinkedAccount(builder.linkedAccount);
    setAmount(builder.amount);
    setPercent(builder.percent);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Splitpay linkedAccount(String linkedAccount) {
    this.linkedAccount = linkedAccount;
    return this;
  }

  /**
   * This is the ID of the linked account. This account must already be linked to the merchant account.
   *
   * @return linkedAccount
   */
  public String getLinkedAccount() {
    return linkedAccount;
  }

  public void setLinkedAccount(String linkedAccount) {
    this.linkedAccount = linkedAccount;
  }

  public Splitpay amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount to transfer to the linked account in minor currency units. The total amount to all linked accounts cannot exceed the transaction total.
   *
   * @return amount
   */
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public Splitpay percent(Long percent) {
    this.percent = percent;
    return this;
  }

  /**
   * This is the percentage of the total transaction amount to transfer to that account. The total percentage to all linked accounts cannot exceed 100%.
   *
   * @return percent
   */
  public Long getPercent() {
    return percent;
  }

  public void setPercent(Long percent) {
    this.percent = percent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Splitpay splitpay = (Splitpay) o;
    return Objects.equals(this.linkedAccount, splitpay.linkedAccount) &&
        Objects.equals(this.amount, splitpay.amount) &&
        Objects.equals(this.percent, splitpay.percent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkedAccount, amount, percent);
  }

  @Override
  public String toString() {

    return "class Splitpay {\n"
        + "    linkedAccount: " + toIndentedString(linkedAccount) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    percent: " + toIndentedString(percent) + "\n"
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
   * {@code Splitpay} builder static inner class.
   */
  public static final class Builder {
    private String linkedAccount;
    private Long amount;
    private Long percent;

    private Builder() {
    }

    /**
     * Sets the {@code linkedAccount} and returns a reference to this Builder enabling method chaining.
     *
     * @param linkedAccount the {@code linkedAccount} to set
     * @return a reference to this Builder
     */
    public Builder linkedAccount(String linkedAccount) {
      this.linkedAccount = linkedAccount;
      return this;
    }

    /**
     * Sets the {@code amount} and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the {@code amount} to set
     * @return a reference to this Builder
     */
    public Builder amount(Long amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Sets the {@code percent} and returns a reference to this Builder enabling method chaining.
     *
     * @param percent the {@code percent} to set
     * @return a reference to this Builder
     */
    public Builder percent(Long percent) {
      this.percent = percent;
      return this;
    }

    /**
     * Returns a {@code Splitpay} built from the parameters previously set.
     *
     * @return a {@code Splitpay} built with parameters of this {@code Splitpay.Builder}
     */
    public Splitpay build() {
      return new Splitpay(this);
    }
  }
}

