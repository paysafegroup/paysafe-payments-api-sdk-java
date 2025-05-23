// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DisplayOptions
 */
public class DisplayOptions {

  @JsonProperty("name")
  private String name;
  @JsonProperty("value")
  private String value;
  @JsonProperty("displayLabel")
  private String displayLabel;

  public DisplayOptions() {
    super();
  }

  private DisplayOptions(Builder builder) {
    setName(builder.name);
    setValue(builder.value);
    setDisplayLabel(builder.displayLabel);
  }

  public static Builder builder() {
    return new Builder();
  }

  public DisplayOptions name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DisplayOptions value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   *
   * @return value
   */
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public DisplayOptions displayLabel(String displayLabel) {
    this.displayLabel = displayLabel;
    return this;
  }

  /**
   * Get displayLabel
   *
   * @return displayLabel
   */
  public String getDisplayLabel() {
    return displayLabel;
  }

  public void setDisplayLabel(String displayLabel) {
    this.displayLabel = displayLabel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisplayOptions displayOptions = (DisplayOptions) o;
    return Objects.equals(this.name, displayOptions.name) &&
        Objects.equals(this.value, displayOptions.value) &&
        Objects.equals(this.displayLabel, displayOptions.displayLabel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, displayLabel);
  }

  @Override
  public String toString() {

    return "class DisplayOptions {\n"
        + "    name: " + toIndentedString(name) + "\n"
        + "    value: " + toIndentedString(value) + "\n"
        + "    displayLabel: " + toIndentedString(displayLabel) + "\n"
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
   * {@code DisplayOptions} builder static inner class.
   */
  public static final class Builder {
    private String name;
    private String value;
    private String displayLabel;

    private Builder() {
    }

    /**
     * Sets the {@code name} and returns a reference to this Builder enabling method chaining.
     *
     * @param name the {@code name} to set
     * @return a reference to this Builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Sets the {@code value} and returns a reference to this Builder enabling method chaining.
     *
     * @param value the {@code value} to set
     * @return a reference to this Builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Sets the {@code displayLabel} and returns a reference to this Builder enabling method chaining.
     *
     * @param displayLabel the {@code displayLabel} to set
     * @return a reference to this Builder
     */
    public Builder displayLabel(String displayLabel) {
      this.displayLabel = displayLabel;
      return this;
    }

    /**
     * Returns a {@code DisplayOptions} built from the parameters previously set.
     *
     * @return a {@code DisplayOptions} built with parameters of this {@code DisplayOptions.Builder}
     */
    public DisplayOptions build() {
      return new DisplayOptions(this);
    }
  }
}

