// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.CardBillingDetailsRequest;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

/**
 * CustomerPaymentHandleRequest
 */
public class CustomerPaymentHandleRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("billingDetails")
  private CardBillingDetailsRequest billingDetails;
  @JsonProperty("billingDetailsId")
  private String billingDetailsId;
  @JsonProperty("card")
  private UpdateCustomerRequestCard card;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates = null;
  @JsonProperty("sepa")
  private Sepa sepa;
  @JsonProperty("paymentType")
  private PaymentType paymentType;

  private Map<String, Object> additionalParameters;

  public CustomerPaymentHandleRequest() {
    super();
  }

  private CustomerPaymentHandleRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setCustomerIp(builder.customerIp);
    setBillingDetails(builder.billingDetails);
    setBillingDetailsId(builder.billingDetailsId);
    setCard(builder.card);
    setAmount(builder.amount);
    setCurrencyCode(builder.currencyCode);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setAch(builder.ach);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
    setPaymentType(builder.paymentType);
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public CustomerPaymentHandleRequest merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  /**
   * This is the currency of the merchant account.
   *
   * @return currencyCode
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#currency-codes>Currency codes reference documentation</a>
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public CustomerPaymentHandleRequest customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * This is the customer's IP address.
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }

  public CustomerPaymentHandleRequest billingDetails(CardBillingDetailsRequest billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Customer's billing details
   *
   * @return billingDetails
   */
  public CardBillingDetailsRequest getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(CardBillingDetailsRequest billingDetails) {
    this.billingDetails = billingDetails;
  }

  public CustomerPaymentHandleRequest billingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
    return this;
  }

  /**
   * This is the ID returned in the response to the [address creation request](/operations/create-address).
   *
   * @return billingDetailsId
   */
  public String getBillingDetailsId() {
    return billingDetailsId;
  }

  public void setBillingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
  }

  public CustomerPaymentHandleRequest card(UpdateCustomerRequestCard card) {
    this.card = card;
    return this;
  }

  /**
   * Card details to be used for the transaction
   *
   * @return card
   */
  public UpdateCustomerRequestCard getCard() {
    return card;
  }

  public void setCard(UpdateCustomerRequestCard card) {
    this.card = card;
  }

  public CustomerPaymentHandleRequest paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is an existing Customer Payment Handle, from which the payment instrument and profile details are retrieved.
   * If this parameter is included you can omit the billingDetails object.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value  should be 1099.
   * <b>Note:<b> The amount specified in the Payment request must match the amount specified in the Payment Handle request
   * from which the paymentHandleToken is taken.
   *
   * @return amount
   * maximum: 99999999999
   */
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public CustomerPaymentHandleRequest eft(Eft eft) {
    this.eft = eft;
    return this;
  }

  /**
   * Details of the EFT account to be used for the transaction
   *
   * @return eft
   */
  public Eft getEft() {
    return eft;
  }

  public void setEft(Eft eft) {
    this.eft = eft;
  }

  public CustomerPaymentHandleRequest dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Get dupCheck
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public CustomerPaymentHandleRequest ach(Ach ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Details of the ach account to be used for the transaction.
   *
   * @return ach
   */
  public Ach getAch() {
    return ach;
  }

  public void setAch(Ach ach) {
    this.ach = ach;
  }

  public CustomerPaymentHandleRequest bacs(Bacs bacs) {
    this.bacs = bacs;
    return this;
  }

  /**
   * Details of the bacs account to be used for the transaction.
   *
   * @return bacs
   */
  public Bacs getBacs() {
    return bacs;
  }

  public void setBacs(Bacs bacs) {
    this.bacs = bacs;
  }

  public CustomerPaymentHandleRequest mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public CustomerPaymentHandleRequest addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public CustomerPaymentHandleRequest removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * Get mandates
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }

  public CustomerPaymentHandleRequest sepa(Sepa sepa) {
    this.sepa = sepa;
    return this;
  }

  /**
   * These are the details of the sepa account used for the transaction.
   *
   * @return sepa
   */
  public Sepa getSepa() {
    return sepa;
  }

  public void setSepa(Sepa sepa) {
    this.sepa = sepa;
  }

  /**
   * This is the payment type.
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(final PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  /**
   * This map holds additional parameters that can be used for features not available in this client library.
   * During serialization, each key-value pair is treated as if the key were a top-level field in the serialized object,
   * i.e. <code>{"merchantRefNum" : "uuid", "additionalParameter1" : 100, "additionalParameter2" : "string" }</code> .
   *
   * @return additionalParameters
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalParameters() {
    return additionalParameters;
  }

  public void setAdditionalParameters(Map<String, Object> additionalParameters) {
    this.additionalParameters = additionalParameters;
  }

  public void addAdditionalParameter(String key, Object value) {
    if (additionalParameters == null) {
      additionalParameters = new HashMap<>();
    }
    additionalParameters.put(key, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPaymentHandleRequest customerPaymentHandleRequest = (CustomerPaymentHandleRequest) o;
    return Objects.equals(this.merchantRefNum, customerPaymentHandleRequest.merchantRefNum) &&
        Objects.equals(this.customerIp, customerPaymentHandleRequest.customerIp) &&
        Objects.equals(this.amount, customerPaymentHandleRequest.amount) &&
        Objects.equals(this.currencyCode, customerPaymentHandleRequest.currencyCode) &&
        Objects.equals(this.billingDetails, customerPaymentHandleRequest.billingDetails) &&
        Objects.equals(this.billingDetailsId, customerPaymentHandleRequest.billingDetailsId) &&
        Objects.equals(this.card, customerPaymentHandleRequest.card) &&
        Objects.equals(this.paymentHandleTokenFrom, customerPaymentHandleRequest.paymentHandleTokenFrom) &&
        Objects.equals(this.eft, customerPaymentHandleRequest.eft) &&
        Objects.equals(this.dupCheck, customerPaymentHandleRequest.dupCheck) &&
        Objects.equals(this.ach, customerPaymentHandleRequest.ach) &&
        Objects.equals(this.bacs, customerPaymentHandleRequest.bacs) &&
        Objects.equals(this.mandates, customerPaymentHandleRequest.mandates) &&
        Objects.equals(this.sepa, customerPaymentHandleRequest.sepa) &&
        Objects.equals(this.paymentType, customerPaymentHandleRequest.paymentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, currencyCode, customerIp, billingDetails, billingDetailsId, card, paymentHandleTokenFrom,
        eft, dupCheck, ach, bacs, mandates, sepa, paymentType, additionalParameters);
  }

  @Override
  public String toString() {

    return "class CustomerPaymentHandleRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    billingDetailsId: " + toIndentedString(billingDetailsId) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    additionalParameters: " + toIndentedString(additionalParameters) + "\n"
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
   * {@code CustomerPaymentHandleRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private String customerIp;
    private CardBillingDetailsRequest billingDetails;
    private String billingDetailsId;
    private UpdateCustomerRequestCard card;
    private Long amount;
    private CurrencyCode currencyCode;
    private String paymentHandleTokenFrom;
    private Eft eft;
    private Boolean dupCheck;
    private Ach ach;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;
    private PaymentType paymentType;
    private Map<String, Object> additionalParameters;

    private Builder() {
    }

    /**
     * Sets the {@code merchantRefNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the {@code merchantRefNum} to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * Sets the {@code customerIp} and returns a reference to this Builder enabling method chaining.
     *
     * @param customerIp the {@code customerIp} to set
     * @return a reference to this Builder
     */
    public Builder customerIp(String customerIp) {
      this.customerIp = customerIp;
      return this;
    }

    /**
     * Sets the {@code billingDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param billingDetails the {@code billingDetails} to set
     * @return a reference to this Builder
     */
    public Builder billingDetails(CardBillingDetailsRequest billingDetails) {
      this.billingDetails = billingDetails;
      return this;
    }

    /**
     * Sets the {@code billingDetailsId} and returns a reference to this Builder enabling method chaining.
     *
     * @param billingDetailsId the {@code billingDetailsId} to set
     * @return a reference to this Builder
     */
    public Builder billingDetailsId(String billingDetailsId) {
      this.billingDetailsId = billingDetailsId;
      return this;
    }

    /**
     * Sets the {@code card} and returns a reference to this Builder enabling method chaining.
     *
     * @param card the {@code card} to set
     * @return a reference to this Builder
     */
    public Builder card(UpdateCustomerRequestCard card) {
      this.card = card;
      return this;
    }

    /**
     * Sets the {@code amount} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code amount} to set
     * @return a reference to this Builder
     */
    public Builder amount(final Long val) {
      amount = val;
      return this;
    }

    /**
     * Sets the {@code currencyCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code currencyCode} to set
     * @return a reference to this Builder
     */
    public Builder currencyCode(final CurrencyCode val) {
      currencyCode = val;
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
     * Sets the {@code eft} and returns a reference to this Builder enabling method chaining.
     *
     * @param eft the {@code eft} to set
     * @return a reference to this Builder
     */
    public Builder eft(Eft eft) {
      this.eft = eft;
      return this;
    }

    /**
     * Sets the {@code dupCheck} and returns a reference to this Builder enabling method chaining.
     *
     * @param dupCheck the {@code dupCheck} to set
     * @return a reference to this Builder
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(Ach ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Sets the {@code bacs} and returns a reference to this Builder enabling method chaining.
     *
     * @param bacs the {@code bacs} to set
     * @return a reference to this Builder
     */
    public Builder bacs(Bacs bacs) {
      this.bacs = bacs;
      return this;
    }

    /**
     * Sets the {@code mandates} and returns a reference to this Builder enabling method chaining.
     *
     * @param mandates the {@code mandates} to set
     * @return a reference to this Builder
     */
    public Builder mandates(List<Mandate> mandates) {
      this.mandates = mandates;
      return this;
    }

    /**
     * Sets the {@code sepa} and returns a reference to this Builder enabling method chaining.
     *
     * @param sepa the {@code sepa} to set
     * @return a reference to this Builder
     */
    public Builder sepa(Sepa sepa) {
      this.sepa = sepa;
      return this;
    }

    /**
     * Sets the {@code paymentType} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code paymentType} to set
     * @return a reference to this Builder
     */
    public Builder paymentType(final PaymentType val) {
      paymentType = val;
      return this;
    }

    /**
     * Inserts one key/value pair to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @return a reference to this Builder
     */
    public Builder putAdditionalParameter(String key, Object value) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.put(key, value);
      return this;
    }

    /**
     * Inserts provided key/value pairs to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @return a reference to this Builder
     */
    public Builder putAllAdditionalParameters(Map<String, Object> additionalParameters) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.putAll(additionalParameters);
      return this;
    }

    /**
     * Sets the {@code additionalParameters} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the {@code additionalParameters} to set
     * @return a reference to this Builder
     */
    public Builder additionalParameters(Map<String, Object> additionalParameters) {
      this.additionalParameters = additionalParameters;
      return this;
    }

    /**
     * Returns a {@code CustomerPaymentHandleRequest} built from the parameters previously set.
     *
     * @return a {@code CustomerPaymentHandleRequest} built with parameters of this {@code CustomerPaymentHandleRequest.Builder}
     */
    public CustomerPaymentHandleRequest build() {
      return new CustomerPaymentHandleRequest(this);
    }
  }
}

