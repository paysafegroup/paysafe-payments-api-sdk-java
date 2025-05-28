// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer.singleusecustomertoken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.customer.enums.SingleUseTokenPaymentType;

/**
 * SingleUseCustomerTokenRequest
 */
public class SingleUseCustomerTokenRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private List<SingleUseTokenPaymentType> paymentType = null;

  private Map<String, Object> additionalParameters;

  public SingleUseCustomerTokenRequest() {
    super();
  }

  private SingleUseCustomerTokenRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SingleUseCustomerTokenRequest merchantRefNum(String merchantRefNum) {
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

  public SingleUseCustomerTokenRequest paymentType(List<SingleUseTokenPaymentType> paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * This specifies the payment type for which you are creating the single-use token.
   *
   * @return paymentType
   */
  public List<SingleUseTokenPaymentType> getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(List<SingleUseTokenPaymentType> paymentType) {
    this.paymentType = paymentType;
  }

  public SingleUseCustomerTokenRequest addPaymentTypeItem(SingleUseTokenPaymentType paymentTypeItem) {
    if (this.paymentType == null) {
      this.paymentType = new ArrayList<>();
    }
    this.paymentType.add(paymentTypeItem);
    return this;
  }

  public SingleUseCustomerTokenRequest removePaymentTypeItem(SingleUseTokenPaymentType paymentTypeItem) {
    if (paymentTypeItem != null && this.paymentType != null) {
      this.paymentType.remove(paymentTypeItem);
    }

    return this;
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
    SingleUseCustomerTokenRequest singleUseCustomerTokenRequest = (SingleUseCustomerTokenRequest) o;
    return Objects.equals(this.merchantRefNum, singleUseCustomerTokenRequest.merchantRefNum) &&
        Objects.equals(this.paymentType, singleUseCustomerTokenRequest.paymentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, paymentType, additionalParameters);
  }

  @Override
  public String toString() {

    return "class SingleUseCustomerTokenRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
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
   * {@code SingleUseCustomerTokenRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private List<SingleUseTokenPaymentType> paymentType;
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
     * Sets the {@code paymentType} and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the {@code paymentType} to set
     * @return a reference to this Builder
     */
    public Builder paymentType(List<SingleUseTokenPaymentType> paymentType) {
      this.paymentType = paymentType;
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
     * Returns a {@code SingleUseCustomerTokenRequest} built from the parameters previously set.
     *
     * @return a {@code SingleUseCustomerTokenRequest} built with parameters of this {@code SingleUseCustomerTokenRequest.Builder}
     */
    public SingleUseCustomerTokenRequest build() {
      return new SingleUseCustomerTokenRequest(this);
    }
  }
}

