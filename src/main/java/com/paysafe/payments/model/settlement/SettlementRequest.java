// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.lpm.Splitpay;

/**
 * SettlementRequest
 */
public class SettlementRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Long amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay = null;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;

  private Map<String, Object> additionalParameters;

  public SettlementRequest() {
    super();
  }

  private SettlementRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSplitpay(builder.splitpay);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setAdditionalParameters(builder.additionalParameters);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SettlementRequest merchantRefNum(String merchantRefNum) {
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

  public SettlementRequest amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units.For example, to process US $10.99, this value should be 1099. <br />
   * Maximum: 99999999999
   *
   * @return amount
   */
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public SettlementRequest dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate.
   * A request is considered a duplicate if the merchantRefNum has already been used in a previous request within the past 90 days. <br />
   * <b>Note:<b> This value defaults to true
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public SettlementRequest splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public SettlementRequest addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public SettlementRequest removeSplitpayItem(Splitpay splitpayItem) {
    if (splitpayItem != null && this.splitpay != null) {
      this.splitpay.remove(splitpayItem);
    }

    return this;
  }

  /**
   * Get splitpay
   *
   * @return splitpay
   */
  public List<Splitpay> getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
  }

  public SettlementRequest airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
    return this;
  }

  /**
   * Contains information about your airline travel. <br /> <b>Note:</b> This object is only for Airline Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return airlineTravelDetails
   */
  public AirlineTravelDetails getAirlineTravelDetails() {
    return airlineTravelDetails;
  }

  public void setAirlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
  }

  public SettlementRequest cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
    return this;
  }

  /**
   * Contains information about your cruise line travel.  <br /> <b>Note:</b> This object is only for Cruise line Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return cruiselineTravelDetails
   */
  public CruiselineTravelDetails getCruiselineTravelDetails() {
    return cruiselineTravelDetails;
  }

  public void setCruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
  }

  public SettlementRequest lodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
    return this;
  }

  /**
   * Contains information about lodging details.  <br /> <b>Note:</b> This object is only for Airline Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return lodgingDetails
   */
  public LodgingDetails getLodgingDetails() {
    return lodgingDetails;
  }

  public void setLodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
  }

  public SettlementRequest carRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
    return this;
  }

  /**
   * Contains information about your car rental. <br /> <b>Note:</b> This object is only for Car rental Merchants.
   * This field has to be passed only in case of card transactions.
   *
   * @return carRentalDetails
   */
  public CarRentalDetails getCarRentalDetails() {
    return carRentalDetails;
  }

  public void setCarRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
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
    SettlementRequest settlementRequest = (SettlementRequest) o;
    return Objects.equals(this.merchantRefNum, settlementRequest.merchantRefNum) &&
        Objects.equals(this.amount, settlementRequest.amount) &&
        Objects.equals(this.dupCheck, settlementRequest.dupCheck) &&
        Objects.equals(this.splitpay, settlementRequest.splitpay) &&
        Objects.equals(this.airlineTravelDetails, settlementRequest.airlineTravelDetails) &&
        Objects.equals(this.cruiselineTravelDetails, settlementRequest.cruiselineTravelDetails) &&
        Objects.equals(this.lodgingDetails, settlementRequest.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, settlementRequest.carRentalDetails) &&
        Objects.equals(this.additionalParameters, settlementRequest.additionalParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, splitpay, airlineTravelDetails, cruiselineTravelDetails, lodgingDetails, carRentalDetails,
        additionalParameters);
  }

  @Override
  public String toString() {

    return "class SettlementRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
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
   * {@code SettlementRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Long amount;
    private Boolean dupCheck;
    private List<Splitpay> splitpay;
    private AirlineTravelDetails airlineTravelDetails;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
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
     * Sets the {@code splitpay} and returns a reference to this Builder enabling method chaining.
     *
     * @param splitpay the {@code splitpay} to set
     * @return a reference to this Builder
     */
    public Builder splitpay(List<Splitpay> splitpay) {
      this.splitpay = splitpay;
      return this;
    }

    /**
     * Sets the {@code airlineTravelDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param airlineTravelDetails the {@code airlineTravelDetails} to set
     * @return a reference to this Builder
     */
    public Builder airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
      this.airlineTravelDetails = airlineTravelDetails;
      return this;
    }

    /**
     * Sets the {@code cruiselineTravelDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param cruiselineTravelDetails the {@code cruiselineTravelDetails} to set
     * @return a reference to this Builder
     */
    public Builder cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
      this.cruiselineTravelDetails = cruiselineTravelDetails;
      return this;
    }

    /**
     * Sets the {@code lodgingDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param lodgingDetails the {@code lodgingDetails} to set
     * @return a reference to this Builder
     */
    public Builder lodgingDetails(LodgingDetails lodgingDetails) {
      this.lodgingDetails = lodgingDetails;
      return this;
    }

    /**
     * Sets the {@code carRentalDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param carRentalDetails the {@code carRentalDetails} to set
     * @return a reference to this Builder
     */
    public Builder carRentalDetails(CarRentalDetails carRentalDetails) {
      this.carRentalDetails = carRentalDetails;
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
     * Returns a {@code SettlementRequest} built from the parameters previously set.
     *
     * @return a {@code SettlementRequest} built with parameters of this {@code SettlementRequest.Builder}
     */
    public SettlementRequest build() {
      return new SettlementRequest(this);
    }
  }
}

