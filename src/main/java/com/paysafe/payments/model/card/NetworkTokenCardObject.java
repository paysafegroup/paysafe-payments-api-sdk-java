// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.TransactionIntent;
import com.paysafe.payments.model.card.threeds.NetworkTokenCardObjectAuthentication;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.GatewayResponse;

/**
 * NetworkTokenCardObject
 */
public class NetworkTokenCardObject {

  @JsonProperty("card")
  private CardWithOptionalNetworkTokenOrApplePay card;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private NetworkTokenCardObjectAuthentication authentication;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("transactionIntent")
  private TransactionIntent transactionIntent;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;

  public NetworkTokenCardObject() {
    super();
  }

  private NetworkTokenCardObject(Builder builder) {
    setCard(builder.card);
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setTransactionIntent(builder.transactionIntent);
    setGatewayResponse(builder.gatewayResponse);
  }

  public static Builder builder() {
    return new Builder();
  }

  public NetworkTokenCardObject card(CardWithOptionalNetworkTokenOrApplePay card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   *
   * @return card
   */
  public CardWithOptionalNetworkTokenOrApplePay getCard() {
    return card;
  }

  public void setCard(CardWithOptionalNetworkTokenOrApplePay card) {
    this.card = card;
  }

  public NetworkTokenCardObject threeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
    return this;
  }

  /**
   * This is the threeDs object. You need to send this object when you want to process CARD transaction with 3DS.
   * Required if account is enabled for 3DS.  <br>
   * Not required if account is non-3DS or if you are using your own 3DS service provider. Please refer authentication
   * object if you are using your own 3DS service provider.
   *
   * @return threeDs
   */
  public ThreeDs getThreeDs() {
    return threeDs;
  }

  public void setThreeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
  }

  public NetworkTokenCardObject authentication(NetworkTokenCardObjectAuthentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * 3D Secure authentication details.
   *
   * @return authentication
   */
  public NetworkTokenCardObjectAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(NetworkTokenCardObjectAuthentication authentication) {
    this.authentication = authentication;
  }

  public NetworkTokenCardObject paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * The response returns the original value from the request. This is used in Saved card flow. You will pass this parameter when you want to create
   * single use payment handle using the Saved-card (card-on-file) present in Paysafe customer vault.  <br>
   * This is an existing Customer Payment Handle, from which the payment instrument details and profile details are retrieved.  <br>
   * If this parameter is included then you can omit the billingDetails object.  <br>
   * If you send a new billingDetails then same will be considered for the transaction, however no change will be made in the billingDetails present
   * against the Saved-card in customer vault.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  public NetworkTokenCardObject transactionIntent(TransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * The transactionIntent property is used to identify the intent of the authorization requests.
   * The value of the transactionIntent shows if the transaction is crypto or quasi-cash related one.  <br>
   * This field is mandatory for Visa card - cross-border fundingTransactions where the recipient is from any of the
   * following countries: India, Bangladesh, Argentina, and Egypt. <br>
   * It is also required for specific use cases. Check
   * <a href="https://developer.paysafe.com/en/payments-api/#/schemas/transactionIntent">on Transaction Intent reference page</a>
   * for more information.
   *
   * @return transactionIntent
   */
  public TransactionIntent getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(TransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
  }

  public NetworkTokenCardObject gatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

  /**
   * This is the read-only raw response returned by an acquirer or PSP.
   *
   * @return gatewayResponse
   */
  public GatewayResponse getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkTokenCardObject networkTokenCardObject = (NetworkTokenCardObject) o;
    return Objects.equals(this.card, networkTokenCardObject.card) &&
        Objects.equals(this.threeDs, networkTokenCardObject.threeDs) &&
        Objects.equals(this.authentication, networkTokenCardObject.authentication) &&
        Objects.equals(this.paymentHandleTokenFrom, networkTokenCardObject.paymentHandleTokenFrom) &&
        Objects.equals(this.transactionIntent, networkTokenCardObject.transactionIntent) &&
        Objects.equals(this.gatewayResponse, networkTokenCardObject.gatewayResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(card, threeDs, authentication, paymentHandleTokenFrom, transactionIntent, gatewayResponse);
  }

  @Override
  public String toString() {

    return "class NetworkTokenCardObject {\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
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
   * {@code NetworkTokenCardObject} builder static inner class.
   */
  public static final class Builder {
    private CardWithOptionalNetworkTokenOrApplePay card;
    private ThreeDs threeDs;
    private NetworkTokenCardObjectAuthentication authentication;
    private String paymentHandleTokenFrom;
    private TransactionIntent transactionIntent;
    private GatewayResponse gatewayResponse;

    private Builder() {
    }

    /**
     * Sets the {@code card} and returns a reference to this Builder enabling method chaining.
     *
     * @param card the {@code card} to set
     * @return a reference to this Builder
     */
    public Builder card(CardWithOptionalNetworkTokenOrApplePay card) {
      this.card = card;
      return this;
    }

    /**
     * Sets the {@code threeDs} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDs the {@code threeDs} to set
     * @return a reference to this Builder
     */
    public Builder threeDs(ThreeDs threeDs) {
      this.threeDs = threeDs;
      return this;
    }

    /**
     * Sets the {@code authentication} and returns a reference to this Builder enabling method chaining.
     *
     * @param authentication the {@code authentication} to set
     * @return a reference to this Builder
     */
    public Builder authentication(NetworkTokenCardObjectAuthentication authentication) {
      this.authentication = authentication;
      return this;
    }

    /**
     * Sets the {@code paymentHandleTokenFrom} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleTokenFrom the {@code paymentHandleTokenFrom} to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleTokenFrom(String paymentHandleTokenFrom) {
      this.paymentHandleTokenFrom = paymentHandleTokenFrom;
      return this;
    }

    /**
     * Sets the {@code transactionIntent} and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the {@code transactionIntent} to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(TransactionIntent transactionIntent) {
      this.transactionIntent = transactionIntent;
      return this;
    }

    /**
     * Sets the {@code gatewayResponse} and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayResponse the {@code gatewayResponse} to set
     * @return a reference to this Builder
     */
    public Builder gatewayResponse(GatewayResponse gatewayResponse) {
      this.gatewayResponse = gatewayResponse;
      return this;
    }

    /**
     * Returns a {@code NetworkTokenCardObject} built from the parameters previously set.
     *
     * @return a {@code NetworkTokenCardObject} built with parameters of this {@code NetworkTokenCardObject.Builder}
     */
    public NetworkTokenCardObject build() {
      return new NetworkTokenCardObject(this);
    }
  }
}

