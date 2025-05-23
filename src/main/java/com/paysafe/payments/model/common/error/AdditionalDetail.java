// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.error;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional details
 */
public class AdditionalDetail {

  @JsonProperty("type")
  private String type;
  @JsonProperty("code")
  private String code;
  @JsonProperty("message")
  private String message;

  public AdditionalDetail() {
    super();
  }

  private AdditionalDetail(Builder builder) {
    setType(builder.type);
    setCode(builder.code);
    setMessage(builder.message);
  }

  public static Builder builder() {
    return new Builder();
  }

  public AdditionalDetail type(String type) {
    this.type = type;
    return this;
  }

  /**
   * This is the type of the additional detail.
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AdditionalDetail code(String code) {
    this.code = code;
    return this;
  }

  /**
   * This is the code of the additional detail.
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public AdditionalDetail message(String message) {
    this.message = message;
    return this;
  }

  /**
   * This is the message of the additional detail.
   *
   * @return message
   */
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdditionalDetail additionalDetail = (AdditionalDetail) o;
    return Objects.equals(this.type, additionalDetail.type) &&
        Objects.equals(this.code, additionalDetail.code) &&
        Objects.equals(this.message, additionalDetail.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, code, message);
  }

  @Override
  public String toString() {

    return "class AdditionalDetail {\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    message: " + toIndentedString(message) + "\n"
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
   * {@code AdditionalDetail} builder static inner class.
   */
  public static final class Builder {
    private String type;
    private String code;
    private String message;

    private Builder() {
    }

    /**
     * Sets the {@code type} and returns a reference to this Builder enabling method chaining.
     *
     * @param type the {@code type} to set
     * @return a reference to this Builder
     */
    public Builder type(String type) {
      this.type = type;
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
     * Returns a {@code AdditionalDetail} built from the parameters previously set.
     *
     * @return a {@code AdditionalDetail} built with parameters of this {@code AdditionalDetail.Builder}
     */
    public AdditionalDetail build() {
      return new AdditionalDetail(this);
    }
  }
}
