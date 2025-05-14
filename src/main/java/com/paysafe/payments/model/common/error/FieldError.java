// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.error;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains error info for the given field
 */
public class FieldError {

  @JsonProperty("field")
  private String field;
  @JsonProperty("error")
  private String error;

  public FieldError() {
    super();
  }

  private FieldError(Builder builder) {
    setField(builder.field);
    setError(builder.error);
  }

  public static Builder builder() {
    return new Builder();
  }

  public FieldError field(String field) {
    this.field = field;
    return this;
  }

  /**
   * Identifies the JSON request field.
   *
   * @return field
   */
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public FieldError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * The problem associated with field.
   *
   * @return error
   */
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldError fieldError = (FieldError) o;
    return Objects.equals(this.field, fieldError.field) &&
        Objects.equals(this.error, fieldError.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, error);
  }

  @Override
  public String toString() {

    return "class FieldError {\n"
        + "    field: " + toIndentedString(field) + "\n"
        + "    error: " + toIndentedString(error) + "\n"
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
   * {@code FieldError} builder static inner class.
   */
  public static final class Builder {
    private String field;
    private String error;

    private Builder() {
    }

    /**
     * Sets the {@code field} and returns a reference to this Builder enabling method chaining.
     *
     * @param field the {@code field} to set
     * @return a reference to this Builder
     */
    public Builder field(String field) {
      this.field = field;
      return this;
    }

    /**
     * Sets the {@code error} and returns a reference to this Builder enabling method chaining.
     *
     * @param error the {@code error} to set
     * @return a reference to this Builder
     */
    public Builder error(String error) {
      this.error = error;
      return this;
    }

    /**
     * Returns a {@code FieldError} built from the parameters previously set.
     *
     * @return a {@code FieldError} built with parameters of this {@code FieldError.Builder}
     */
    public FieldError build() {
      return new FieldError(this);
    }
  }
}

