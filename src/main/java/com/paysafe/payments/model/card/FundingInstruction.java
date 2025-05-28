// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.paymenthandle.DisplayOptions;

/**
 * FundingInstruction
 */
public class FundingInstruction {

  @JsonProperty("bankName")
  private String bankName;
  @JsonProperty("expirationTime")
  private String expirationTime;
  @JsonProperty("displayOptions")
  private List<DisplayOptions> displayOptions = null;
  @JsonProperty("steps")
  private List<Step> steps = null;

  public FundingInstruction() {
    super();
  }

  private FundingInstruction(Builder builder) {
    setBankName(builder.bankName);
    setExpirationTime(builder.expirationTime);
    setDisplayOptions(builder.displayOptions);
    setSteps(builder.steps);
  }

  public static Builder builder() {
    return new Builder();
  }

  public FundingInstruction bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * Get bankName
   *
   * @return bankName
   */
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public FundingInstruction expirationTime(String expirationTime) {
    this.expirationTime = expirationTime;
    return this;
  }

  /**
   * Get expirationTime
   *
   * @return expirationTime
   */
  public String getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(String expirationTime) {
    this.expirationTime = expirationTime;
  }

  public FundingInstruction displayOptions(List<DisplayOptions> displayOptions) {
    this.displayOptions = displayOptions;
    return this;
  }

  public FundingInstruction addDisplayOptionsItem(DisplayOptions displayOptionsItem) {
    if (this.displayOptions == null) {
      this.displayOptions = new ArrayList<>();
    }
    this.displayOptions.add(displayOptionsItem);
    return this;
  }

  public FundingInstruction removeDisplayOptionsItem(DisplayOptions displayOptionsItem) {
    if (displayOptionsItem != null && this.displayOptions != null) {
      this.displayOptions.remove(displayOptionsItem);
    }

    return this;
  }

  /**
   * Get displayOptions
   *
   * @return displayOptions
   */
  public List<DisplayOptions> getDisplayOptions() {
    return displayOptions;
  }

  public void setDisplayOptions(List<DisplayOptions> displayOptions) {
    this.displayOptions = displayOptions;
  }

  public FundingInstruction steps(List<Step> steps) {
    this.steps = steps;
    return this;
  }

  public FundingInstruction addStepsItem(Step stepsItem) {
    if (this.steps == null) {
      this.steps = new ArrayList<>();
    }
    this.steps.add(stepsItem);
    return this;
  }

  public FundingInstruction removeStepsItem(Step stepsItem) {
    if (stepsItem != null && this.steps != null) {
      this.steps.remove(stepsItem);
    }

    return this;
  }

  /**
   * Get steps
   *
   * @return steps
   */
  public List<Step> getSteps() {
    return steps;
  }

  public void setSteps(List<Step> steps) {
    this.steps = steps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FundingInstruction fundingInstruction = (FundingInstruction) o;
    return Objects.equals(this.bankName, fundingInstruction.bankName) &&
        Objects.equals(this.expirationTime, fundingInstruction.expirationTime) &&
        Objects.equals(this.displayOptions, fundingInstruction.displayOptions) &&
        Objects.equals(this.steps, fundingInstruction.steps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankName, expirationTime, displayOptions, steps);
  }

  @Override
  public String toString() {

    return "class FundingInstruction {\n"
        + "    bankName: " + toIndentedString(bankName) + "\n"
        + "    expirationTime: " + toIndentedString(expirationTime) + "\n"
        + "    displayOptions: " + toIndentedString(displayOptions) + "\n"
        + "    steps: " + toIndentedString(steps) + "\n"
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
   * {@code FundingInstruction} builder static inner class.
   */
  public static final class Builder {
    private String bankName;
    private String expirationTime;
    private List<DisplayOptions> displayOptions;
    private List<Step> steps;

    private Builder() {
    }

    /**
     * Sets the {@code bankName} and returns a reference to this Builder enabling method chaining.
     *
     * @param bankName the {@code bankName} to set
     * @return a reference to this Builder
     */
    public Builder bankName(String bankName) {
      this.bankName = bankName;
      return this;
    }

    /**
     * Sets the {@code expirationTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationTime the {@code expirationTime} to set
     * @return a reference to this Builder
     */
    public Builder expirationTime(String expirationTime) {
      this.expirationTime = expirationTime;
      return this;
    }

    /**
     * Sets the {@code displayOptions} and returns a reference to this Builder enabling method chaining.
     *
     * @param displayOptions the {@code displayOptions} to set
     * @return a reference to this Builder
     */
    public Builder displayOptions(List<DisplayOptions> displayOptions) {
      this.displayOptions = displayOptions;
      return this;
    }

    /**
     * Sets the {@code steps} and returns a reference to this Builder enabling method chaining.
     *
     * @param steps the {@code steps} to set
     * @return a reference to this Builder
     */
    public Builder steps(List<Step> steps) {
      this.steps = steps;
      return this;
    }

    /**
     * Returns a {@code FundingInstruction} built from the parameters previously set.
     *
     * @return a {@code FundingInstruction} built with parameters of this {@code FundingInstruction.Builder}
     */
    public FundingInstruction build() {
      return new FundingInstruction(this);
    }
  }
}

