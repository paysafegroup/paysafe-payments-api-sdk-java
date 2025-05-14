// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Discretionary Data consists of three user-defined data fields containing additional information about your card acquirer.
 * Contact your account manager for more information.
 * <p>Field Details:</p>
 * <ul>
 *   <li><strong>field1:</strong> A user-defined string with a maximum length of 35 characters. Example: "CustomField1".</li>
 *   <li><strong>field2:</strong> A user-defined string with a maximum length of 20 characters. Example: "CustomField2".</li>
 *   <li><strong>field3:</strong> A user-defined string with a maximum length of 20 characters. Example: "CustomField3".</li>
 * </ul>
 */
public class DiscretionaryData {

  @JsonProperty("field1")
  private String field1;
  @JsonProperty("field2")
  private String field2;
  @JsonProperty("field3")
  private String field3;

  public DiscretionaryData() {
    super();
  }

  private DiscretionaryData(Builder builder) {
    setField1(builder.field1);
    setField2(builder.field2);
    setField3(builder.field3);
  }

  public static Builder builder() {
    return new Builder();
  }

  public DiscretionaryData field1(String field1) {
    this.field1 = field1;
    return this;
  }

  /**
   * Get field1
   *
   * @return field1
   */
  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public DiscretionaryData field2(String field2) {
    this.field2 = field2;
    return this;
  }

  /**
   * Get field2
   *
   * @return field2
   */
  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public DiscretionaryData field3(String field3) {
    this.field3 = field3;
    return this;
  }

  /**
   * Get field3
   *
   * @return field3
   */
  public String getField3() {
    return field3;
  }

  public void setField3(String field3) {
    this.field3 = field3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscretionaryData discretionaryData = (DiscretionaryData) o;
    return Objects.equals(this.field1, discretionaryData.field1) &&
        Objects.equals(this.field2, discretionaryData.field2) &&
        Objects.equals(this.field3, discretionaryData.field3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field1, field2, field3);
  }

  @Override
  public String toString() {

    return "class DiscretionaryData {\n"
        + "    field1: " + toIndentedString(field1) + "\n"
        + "    field2: " + toIndentedString(field2) + "\n"
        + "    field3: " + toIndentedString(field3) + "\n"
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
   * {@code DiscretionaryData} builder static inner class.
   */
  public static final class Builder {
    private String field1;
    private String field2;
    private String field3;

    private Builder() {
    }

    /**
     * Sets the {@code field1} and returns a reference to this Builder enabling method chaining.
     *
     * @param field1 the {@code field1} to set
     * @return a reference to this Builder
     */
    public Builder field1(String field1) {
      this.field1 = field1;
      return this;
    }

    /**
     * Sets the {@code field2} and returns a reference to this Builder enabling method chaining.
     *
     * @param field2 the {@code field2} to set
     * @return a reference to this Builder
     */
    public Builder field2(String field2) {
      this.field2 = field2;
      return this;
    }

    /**
     * Sets the {@code field3} and returns a reference to this Builder enabling method chaining.
     *
     * @param field3 the {@code field3} to set
     * @return a reference to this Builder
     */
    public Builder field3(String field3) {
      this.field3 = field3;
      return this;
    }

    /**
     * Returns a {@code DiscretionaryData} built from the parameters previously set.
     *
     * @return a {@code DiscretionaryData} built with parameters of this {@code DiscretionaryData.Builder}
     */
    public DiscretionaryData build() {
      return new DiscretionaryData(this);
    }
  }
}

