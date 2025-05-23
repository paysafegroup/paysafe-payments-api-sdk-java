// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents Level 2 and Level 3 transaction data for detailed purchase information.
 * Level 2 and Level 3 (L2/L3) credit card processing refers to certain B2B card transactions for which the merchant might be eligible
 * for lower credit card interchange rates. The lower rates may be available for merchants who provide more detailed information when
 * processing card-not-present transactions. In order to be eligible for L2/L3 transactions:
 * <ul>
 *   <li>Your merchant account must be properly configured by Paysafe.</li>
 *   <li>The BIN of the credit card used for the transaction must be eligible – typically,these are government-issued credit cards.</li>
 * </ul>
 * <b>Note:</b> Not all processing gateways support this parameter. Contact your account manager for more information.
 */
public class Level2Level3 {

  @JsonProperty("exemptLocalTax")
  private Boolean exemptLocalTax = false;
  @JsonProperty("localTaxAmount")
  private Long localTaxAmount;
  @JsonProperty("nationalTaxAmount")
  private Long nationalTaxAmount;
  @JsonProperty("freightAmount")
  private Long freightAmount;
  @JsonProperty("dutyAmount")
  private Long dutyAmount;
  @JsonProperty("destinationZip")
  private String destinationZip;
  @JsonProperty("destinationCountry")
  private String destinationCountry;
  @JsonProperty("shipFromZip")
  private String shipFromZip;
  @JsonProperty("lineItems")
  private LineItems lineItems;

  public Level2Level3() {
    super();
  }

  private Level2Level3(Builder builder) {
    setExemptLocalTax(builder.exemptLocalTax);
    setLocalTaxAmount(builder.localTaxAmount);
    setNationalTaxAmount(builder.nationalTaxAmount);
    setFreightAmount(builder.freightAmount);
    setDutyAmount(builder.dutyAmount);
    setDestinationZip(builder.destinationZip);
    setDestinationCountry(builder.destinationCountry);
    setShipFromZip(builder.shipFromZip);
    setLineItems(builder.lineItems);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Level2Level3 exemptLocalTax(Boolean exemptLocalTax) {
    this.exemptLocalTax = exemptLocalTax;
    return this;
  }

  /**
   * This indicates whether local tax is exempted for the request. If set to true, then the localTaxAmount parameter will be ignored.
   * <b>Note:</b> This value defaults to false.
   *
   * @return exemptLocalTax
   */
  public Boolean getExemptLocalTax() {
    return exemptLocalTax;
  }

  public void setExemptLocalTax(Boolean exemptLocalTax) {
    this.exemptLocalTax = exemptLocalTax;
  }

  public Level2Level3 localTaxAmount(Long localTaxAmount) {
    this.localTaxAmount = localTaxAmount;
    return this;
  }

  /**
   * This is the local sales tax applied to the purchase.
   *
   * @return localTaxAmount
   */
  public Long getLocalTaxAmount() {
    return localTaxAmount;
  }

  public void setLocalTaxAmount(Long localTaxAmount) {
    this.localTaxAmount = localTaxAmount;
  }

  public Level2Level3 nationalTaxAmount(Long nationalTaxAmount) {
    this.nationalTaxAmount = nationalTaxAmount;
    return this;
  }

  /**
   * This is the national tax included in the transaction amount.  <br>
   * Maximum: 99999999999
   *
   * @return nationalTaxAmount
   */
  public Long getNationalTaxAmount() {
    return nationalTaxAmount;
  }

  public void setNationalTaxAmount(Long nationalTaxAmount) {
    this.nationalTaxAmount = nationalTaxAmount;
  }

  public Level2Level3 freightAmount(Long freightAmount) {
    this.freightAmount = freightAmount;
    return this;
  }

  /**
   * This is the freight or shipping portion of the total transaction amount.  <br>
   * Maximum: 99999999999
   *
   * @return freightAmount
   */
  public Long getFreightAmount() {
    return freightAmount;
  }

  public void setFreightAmount(Long freightAmount) {
    this.freightAmount = freightAmount;
  }

  public Level2Level3 dutyAmount(Long dutyAmount) {
    this.dutyAmount = dutyAmount;
    return this;
  }

  /**
   * This is the duty associated with the import of the purchased goods.  <br>
   * Maximum: 99999999999
   *
   * @return dutyAmount
   */
  public Long getDutyAmount() {
    return dutyAmount;
  }

  public void setDutyAmount(Long dutyAmount) {
    this.dutyAmount = dutyAmount;
  }

  public Level2Level3 destinationZip(String destinationZip) {
    this.destinationZip = destinationZip;
    return this;
  }

  /**
   * This is the postal/zip code of the address to which the purchased goods will be delivered.
   * This field  can be identical to the shipFromZip if the customer is present and takes immediate possession of the goods.
   *
   * @return destinationZip
   */
  public String getDestinationZip() {
    return destinationZip;
  }

  public void setDestinationZip(String destinationZip) {
    this.destinationZip = destinationZip;
  }

  public Level2Level3 destinationCountry(String destinationCountry) {
    this.destinationCountry = destinationCountry;
    return this;
  }

  /**
   * This is the country to which the goods are being shipped.
   *
   * @return destinationCountry
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public String getDestinationCountry() {
    return destinationCountry;
  }

  public void setDestinationCountry(String destinationCountry) {
    this.destinationCountry = destinationCountry;
  }

  public Level2Level3 shipFromZip(String shipFromZip) {
    this.shipFromZip = shipFromZip;
    return this;
  }

  /**
   * This is the postal/zip code of the address from which the purchased goods are being shipped.
   *
   * @return shipFromZip
   */
  public String getShipFromZip() {
    return shipFromZip;
  }

  public void setShipFromZip(String shipFromZip) {
    this.shipFromZip = shipFromZip;
  }

  public Level2Level3 lineItems(LineItems lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  /**
   * This is more detailed information about the items that are being purchased for Level2Level3 merchants
   *
   * @return lineItems
   */
  public LineItems getLineItems() {
    return lineItems;
  }

  public void setLineItems(LineItems lineItems) {
    this.lineItems = lineItems;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Level2Level3 level2level3 = (Level2Level3) o;
    return Objects.equals(this.exemptLocalTax, level2level3.exemptLocalTax) &&
        Objects.equals(this.localTaxAmount, level2level3.localTaxAmount) &&
        Objects.equals(this.nationalTaxAmount, level2level3.nationalTaxAmount) &&
        Objects.equals(this.freightAmount, level2level3.freightAmount) &&
        Objects.equals(this.dutyAmount, level2level3.dutyAmount) &&
        Objects.equals(this.destinationZip, level2level3.destinationZip) &&
        Objects.equals(this.destinationCountry, level2level3.destinationCountry) &&
        Objects.equals(this.shipFromZip, level2level3.shipFromZip) &&
        Objects.equals(this.lineItems, level2level3.lineItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exemptLocalTax, localTaxAmount, nationalTaxAmount, freightAmount, dutyAmount, destinationZip, destinationCountry,
        shipFromZip, lineItems);
  }

  @Override
  public String toString() {

    return "class Level2Level3 {\n"
        + "    exemptLocalTax: " + toIndentedString(exemptLocalTax) + "\n"
        + "    localTaxAmount: " + toIndentedString(localTaxAmount) + "\n"
        + "    nationalTaxAmount: " + toIndentedString(nationalTaxAmount) + "\n"
        + "    freightAmount: " + toIndentedString(freightAmount) + "\n"
        + "    dutyAmount: " + toIndentedString(dutyAmount) + "\n"
        + "    destinationZip: " + toIndentedString(destinationZip) + "\n"
        + "    destinationCountry: " + toIndentedString(destinationCountry) + "\n"
        + "    shipFromZip: " + toIndentedString(shipFromZip) + "\n"
        + "    lineItems: " + toIndentedString(lineItems) + "\n"
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
   * {@code Level2Level3} builder static inner class.
   */
  public static final class Builder {
    private Boolean exemptLocalTax;
    private Long localTaxAmount;
    private Long nationalTaxAmount;
    private Long freightAmount;
    private Long dutyAmount;
    private String destinationZip;
    private String destinationCountry;
    private String shipFromZip;
    private LineItems lineItems;

    private Builder() {
    }

    /**
     * Sets the {@code exemptLocalTax} and returns a reference to this Builder enabling method chaining.
     *
     * @param exemptLocalTax the {@code exemptLocalTax} to set
     * @return a reference to this Builder
     */
    public Builder exemptLocalTax(Boolean exemptLocalTax) {
      this.exemptLocalTax = exemptLocalTax;
      return this;
    }

    /**
     * Sets the {@code localTaxAmount} and returns a reference to this Builder enabling method chaining.
     *
     * @param localTaxAmount the {@code localTaxAmount} to set
     * @return a reference to this Builder
     */
    public Builder localTaxAmount(Long localTaxAmount) {
      this.localTaxAmount = localTaxAmount;
      return this;
    }

    /**
     * Sets the {@code nationalTaxAmount} and returns a reference to this Builder enabling method chaining.
     *
     * @param nationalTaxAmount the {@code nationalTaxAmount} to set
     * @return a reference to this Builder
     */
    public Builder nationalTaxAmount(Long nationalTaxAmount) {
      this.nationalTaxAmount = nationalTaxAmount;
      return this;
    }

    /**
     * Sets the {@code freightAmount} and returns a reference to this Builder enabling method chaining.
     *
     * @param freightAmount the {@code freightAmount} to set
     * @return a reference to this Builder
     */
    public Builder freightAmount(Long freightAmount) {
      this.freightAmount = freightAmount;
      return this;
    }

    /**
     * Sets the {@code dutyAmount} and returns a reference to this Builder enabling method chaining.
     *
     * @param dutyAmount the {@code dutyAmount} to set
     * @return a reference to this Builder
     */
    public Builder dutyAmount(Long dutyAmount) {
      this.dutyAmount = dutyAmount;
      return this;
    }

    /**
     * Sets the {@code destinationZip} and returns a reference to this Builder enabling method chaining.
     *
     * @param destinationZip the {@code destinationZip} to set
     * @return a reference to this Builder
     */
    public Builder destinationZip(String destinationZip) {
      this.destinationZip = destinationZip;
      return this;
    }

    /**
     * Sets the {@code destinationCountry} and returns a reference to this Builder enabling method chaining.
     *
     * @param destinationCountry the {@code destinationCountry} to set
     * @return a reference to this Builder
     */
    public Builder destinationCountry(String destinationCountry) {
      this.destinationCountry = destinationCountry;
      return this;
    }

    /**
     * Sets the {@code shipFromZip} and returns a reference to this Builder enabling method chaining.
     *
     * @param shipFromZip the {@code shipFromZip} to set
     * @return a reference to this Builder
     */
    public Builder shipFromZip(String shipFromZip) {
      this.shipFromZip = shipFromZip;
      return this;
    }

    /**
     * Sets the {@code lineItems} and returns a reference to this Builder enabling method chaining.
     *
     * @param lineItems the {@code lineItems} to set
     * @return a reference to this Builder
     */
    public Builder lineItems(LineItems lineItems) {
      this.lineItems = lineItems;
      return this;
    }

    /**
     * Returns a {@code Level2Level3} built from the parameters previously set.
     *
     * @return a {@code Level2Level3} built with parameters of this {@code Level2Level3.Builder}
     */
    public Level2Level3 build() {
      return new Level2Level3(this);
    }
  }
}

