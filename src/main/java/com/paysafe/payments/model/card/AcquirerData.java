// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.AcquirerCode;

/**
 * Represents the data provided by the acquirer in a transaction.
 * Acquirer data is additional information about your card acquirer, applicable only when you are using Worldpay (VAN)
 * as your acquirer for authorizations. Contact your account manager for more information.
 */
public class AcquirerData {

  @JsonProperty("code")
  private AcquirerCode code;
  @JsonProperty("discretionaryData")
  private DiscretionaryData discretionaryData;

  public AcquirerData() {
    super();
  }

  private AcquirerData(Builder builder) {
    setCode(builder.code);
    setDiscretionaryData(builder.discretionaryData);
  }

  public static Builder builder() {
    return new Builder();
  }

  public AcquirerData code(AcquirerCode code) {
    this.code = code;
    return this;
  }

  /**
   * This is the code for your card acquirer. Possible values: VAN
   *
   * @return code
   */
  public AcquirerCode getCode() {
    return code;
  }

  public void setCode(AcquirerCode code) {
    this.code = code;
  }

  public AcquirerData discretionaryData(DiscretionaryData discretionaryData) {
    this.discretionaryData = discretionaryData;
    return this;
  }

  /**
   * Discretionary Data consists of three user-defined data fields containing additional information about your card acquirer.
   * Contact your account manager for more information.
   *
   * @return discretionaryData
   */
  public DiscretionaryData getDiscretionaryData() {
    return discretionaryData;
  }

  public void setDiscretionaryData(DiscretionaryData discretionaryData) {
    this.discretionaryData = discretionaryData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcquirerData acquirerData = (AcquirerData) o;
    return Objects.equals(this.code, acquirerData.code) &&
        Objects.equals(this.discretionaryData, acquirerData.discretionaryData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, discretionaryData);
  }

  @Override
  public String toString() {

    return "class AcquirerData {\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    discretionaryData: " + toIndentedString(discretionaryData) + "\n"
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
   * {@code AcquirerData} builder static inner class.
   */
  public static final class Builder {
    private AcquirerCode code;
    private DiscretionaryData discretionaryData;

    private Builder() {
    }

    /**
     * Sets the {@code code} and returns a reference to this Builder enabling method chaining.
     *
     * @param code the {@code code} to set
     * @return a reference to this Builder
     */
    public Builder code(AcquirerCode code) {
      this.code = code;
      return this;
    }

    /**
     * Sets the {@code discretionaryData} and returns a reference to this Builder enabling method chaining.
     *
     * @param discretionaryData the {@code discretionaryData} to set
     * @return a reference to this Builder
     */
    public Builder discretionaryData(DiscretionaryData discretionaryData) {
      this.discretionaryData = discretionaryData;
      return this;
    }

    /**
     * Returns a {@code AcquirerData} built from the parameters previously set.
     *
     * @return a {@code AcquirerData} built with parameters of this {@code AcquirerData.Builder}
     */
    public AcquirerData build() {
      return new AcquirerData(this);
    }
  }
}

