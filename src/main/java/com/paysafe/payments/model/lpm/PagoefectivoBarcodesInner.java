// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PagoefectivoBarcodesInner
 */
public class PagoefectivoBarcodesInner {

  @JsonProperty("barcode")
  private String barcode;
  @JsonProperty("visualization")
  private String visualization;
  @JsonProperty("country")
  private String country;
  @JsonProperty("expiresAt")
  private String expiresAt;
  @JsonProperty("message")
  private String message;
  @JsonProperty("code")
  private String code;

  public PagoefectivoBarcodesInner() {
    super();
  }

  private PagoefectivoBarcodesInner(Builder builder) {
    setBarcode(builder.barcode);
    setVisualization(builder.visualization);
    setCountry(builder.country);
    setExpiresAt(builder.expiresAt);
    setMessage(builder.message);
    setCode(builder.code);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PagoefectivoBarcodesInner barcode(String barcode) {
    this.barcode = barcode;
    return this;
  }

  /**
   * Get barcode
   *
   * @return barcode
   */
  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public PagoefectivoBarcodesInner visualization(String visualization) {
    this.visualization = visualization;
    return this;
  }

  /**
   * Get visualization
   *
   * @return visualization
   */
  public String getVisualization() {
    return visualization;
  }

  public void setVisualization(String visualization) {
    this.visualization = visualization;
  }

  public PagoefectivoBarcodesInner country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   *
   * @return country
   * @see <a href=https://developer.paysafe.com/en/support/reference-information/codes/#country-codes>Country codes</a>
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public PagoefectivoBarcodesInner expiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * Get expiresAt
   *
   * @return expiresAt
   */
  public String getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }

  public PagoefectivoBarcodesInner message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   *
   * @return message
   */
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PagoefectivoBarcodesInner code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagoefectivoBarcodesInner pagoefectivoBarcodesInner = (PagoefectivoBarcodesInner) o;
    return Objects.equals(this.barcode, pagoefectivoBarcodesInner.barcode) &&
        Objects.equals(this.visualization, pagoefectivoBarcodesInner.visualization) &&
        Objects.equals(this.country, pagoefectivoBarcodesInner.country) &&
        Objects.equals(this.expiresAt, pagoefectivoBarcodesInner.expiresAt) &&
        Objects.equals(this.message, pagoefectivoBarcodesInner.message) &&
        Objects.equals(this.code, pagoefectivoBarcodesInner.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(barcode, visualization, country, expiresAt, message, code);
  }

  @Override
  public String toString() {

    return "class PagoefectivoBarcodesInner {\n"
        + "    barcode: " + toIndentedString(barcode) + "\n"
        + "    visualization: " + toIndentedString(visualization) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    expiresAt: " + toIndentedString(expiresAt) + "\n"
        + "    message: " + toIndentedString(message) + "\n"
        + "    code: " + toIndentedString(code) + "\n"
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
   * {@code PagoefectivoBarcodesInner} builder static inner class.
   */
  public static final class Builder {
    private String barcode;
    private String visualization;
    private String country;
    private String expiresAt;
    private String message;
    private String code;

    private Builder() {
    }

    /**
     * Sets the {@code barcode} and returns a reference to this Builder enabling method chaining.
     *
     * @param barcode the {@code barcode} to set
     * @return a reference to this Builder
     */
    public Builder barcode(String barcode) {
      this.barcode = barcode;
      return this;
    }

    /**
     * Sets the {@code visualization} and returns a reference to this Builder enabling method chaining.
     *
     * @param visualization the {@code visualization} to set
     * @return a reference to this Builder
     */
    public Builder visualization(String visualization) {
      this.visualization = visualization;
      return this;
    }

    /**
     * Sets the {@code country} and returns a reference to this Builder enabling method chaining.
     *
     * @param country the {@code country} to set
     * @return a reference to this Builder
     */
    public Builder country(String country) {
      this.country = country;
      return this;
    }

    /**
     * Sets the {@code expiresAt} and returns a reference to this Builder enabling method chaining.
     *
     * @param expiresAt the {@code expiresAt} to set
     * @return a reference to this Builder
     */
    public Builder expiresAt(String expiresAt) {
      this.expiresAt = expiresAt;
      return this;
    }

    /**
     * Sets the {@code message} and returns a reference to this Builder enabling method chaining.
     *
     * @param message the {@code message} to set
     * @return a reference to this Builder
     */
    public Builder message(String message) {
      this.message = message;
      return this;
    }

    /**
     * Sets the {@code code} and returns a reference to this Builder enabling method chaining.
     *
     * @param code the {@code code} to set
     * @return a reference to this Builder
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }

    /**
     * Returns a {@code PagoefectivoBarcodesInner} built from the parameters previously set.
     *
     * @return a {@code PagoefectivoBarcodesInner} built with parameters of this {@code PagoefectivoBarcodesInner.Builder}
     */
    public PagoefectivoBarcodesInner build() {
      return new PagoefectivoBarcodesInner(this);
    }
  }
}

