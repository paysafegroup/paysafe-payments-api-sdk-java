// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <b>Note:</b> Not all processing gateways support this parameter. To use the fundingTransaction object your account must be configured by Paysafe.
 * If you want to support funding transactions for additional MCCs, please contact Paysafe's operational support.
 */
public class Auths {

  @JsonProperty("fundingTransaction")
  private FundingTransaction fundingTransaction;

  public Auths() {
    super();
  }

  private Auths(Builder builder) {
    setFundingTransaction(builder.fundingTransaction);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Auths fundingTransaction(FundingTransaction fundingTransaction) {
    this.fundingTransaction = fundingTransaction;
    return this;
  }

  /**
   * <b>Note:</b> Acquirers and processors do not necessarily support all available MCCs; before integrating, you should contact
   * <a href="https://developer.paysafe.com/en/support/">Integration Support</a> for details.
   * <p>
   * The fundingTransaction object is used to identify authorization requests that are categorized as funding transactions by the merchant
   * in order to provide additional information for the purpose of a transaction. It can be used by merchants registered with MCC 4722, 4829,
   * 6012, 6051, 6211, 6540, 7800, 7801, 7802, 7994, 7995 or 9406.
   * The relevant value will be assigned automatically by the Payments API as per the merchant registration with card schemes and his applicable MCC.
   * </p>
   * More information can be found on
   * <a href="https://developer.paysafe.com/en/payments-api/#/schemas/fundingTransaction">Funding Transaction reference</a> page.
   *
   * @return fundingTransaction
   */
  public FundingTransaction getFundingTransaction() {
    return fundingTransaction;
  }

  public void setFundingTransaction(FundingTransaction fundingTransaction) {
    this.fundingTransaction = fundingTransaction;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Auths auths = (Auths) o;
    return Objects.equals(this.fundingTransaction, auths.fundingTransaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fundingTransaction);
  }

  @Override
  public String toString() {

    return "class Auths {\n"
        + "    fundingTransaction: " + toIndentedString(fundingTransaction) + "\n"
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
   * {@code Auths} builder static inner class.
   */
  public static final class Builder {
    private FundingTransaction fundingTransaction;

    private Builder() {
    }

    /**
     * Sets the {@code fundingTransaction} and returns a reference to this Builder enabling method chaining.
     *
     * @param fundingTransaction the {@code fundingTransaction} to set
     * @return a reference to this Builder
     */
    public Builder fundingTransaction(FundingTransaction fundingTransaction) {
      this.fundingTransaction = fundingTransaction;
      return this;
    }

    /**
     * Returns a {@code Auths} built from the parameters previously set.
     *
     * @return a {@code Auths} built with parameters of this {@code Auths.Builder}
     */
    public Auths build() {
      return new Auths(this);
    }
  }
}

