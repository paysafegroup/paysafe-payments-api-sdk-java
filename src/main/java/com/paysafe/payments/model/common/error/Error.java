// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.error;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Details of the error.
 */
@JsonRootName("error")
public class Error {

  @JsonProperty("code")
  private String code;
  @JsonProperty("message")
  private String message;
  @JsonProperty("details")
  private List<String> details = null;
  @JsonProperty("fieldErrors")
  private List<FieldError> fieldErrors = null;
  @JsonProperty("additionalDetails")
  private List<AdditionalDetail> additionalDetails = null;

  public Error() {
    super();
  }

  private Error(Builder builder) {
    setCode(builder.code);
    setMessage(builder.message);
    setDetails(builder.details);
    setFieldErrors(builder.fieldErrors);
    setAdditionalDetails(builder.additionalDetails);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The error code. Also shown in the X-Application-Status-Code response header.
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A description of the error.
   *
   * @return message
   */
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error details(List<String> details) {
    this.details = details;
    return this;
  }

  public Error addDetailsItem(String detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  public Error removeDetailsItem(String detailsItem) {
    if (detailsItem != null && this.details != null) {
      this.details.remove(detailsItem);
    }

    return this;
  }

  /**
   * Details of any parameter value errors.
   *
   * @return details
   */
  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

  public Error fieldErrors(List<FieldError> fieldErrors) {
    this.fieldErrors = fieldErrors;
    return this;
  }

  public Error addFieldErrorsItem(FieldError fieldErrorsItem) {
    if (this.fieldErrors == null) {
      this.fieldErrors = new ArrayList<>();
    }
    this.fieldErrors.add(fieldErrorsItem);
    return this;
  }

  public Error removeFieldErrorsItem(FieldError fieldErrorsItem) {
    if (fieldErrorsItem != null && this.fieldErrors != null) {
      this.fieldErrors.remove(fieldErrorsItem);
    }

    return this;
  }

  /**
   * If applicable, this is a list of fields that have issues.
   *
   * @return fieldErrors
   */
  public List<FieldError> getFieldErrors() {
    return fieldErrors;
  }

  public void setFieldErrors(List<FieldError> fieldErrors) {
    this.fieldErrors = fieldErrors;
  }

  public Error additionalDetails(List<AdditionalDetail> additionalDetails) {
    this.additionalDetails = additionalDetails;
    return this;
  }

  public Error addAdditionalDetailsItem(AdditionalDetail additionalDetailsItem) {
    if (this.additionalDetails == null) {
      this.additionalDetails = new ArrayList<>();
    }
    this.additionalDetails.add(additionalDetailsItem);
    return this;
  }

  public Error removeAdditionalDetailsItem(AdditionalDetail additionalDetailsItem) {
    if (additionalDetailsItem != null && this.additionalDetails != null) {
      this.additionalDetails.remove(additionalDetailsItem);
    }

    return this;
  }

  /**
   * This is an optional field that provides additional data in case of a reject.
   *
   * @return additionalDetails
   */
  public List<AdditionalDetail> getAdditionalDetails() {
    return additionalDetails;
  }

  public void setAdditionalDetails(List<AdditionalDetail> additionalDetails) {
    this.additionalDetails = additionalDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.details, error.details) &&
        Objects.equals(this.fieldErrors, error.fieldErrors) &&
        Objects.equals(this.additionalDetails, error.additionalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, details, fieldErrors, additionalDetails);
  }

  @Override
  public String toString() {

    return "class Error {\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    message: " + toIndentedString(message) + "\n"
        + "    details: " + toIndentedString(details) + "\n"
        + "    fieldErrors: " + toIndentedString(fieldErrors) + "\n"
        + "    additionalDetails: " + toIndentedString(additionalDetails) + "\n"
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
   * {@code Error} builder static inner class.
   */
  public static final class Builder {
    private String code;
    private String message;
    private List<String> details;
    private List<FieldError> fieldErrors;
    private List<AdditionalDetail> additionalDetails;

    private Builder() {
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
     * Sets the {@code details} and returns a reference to this Builder enabling method chaining.
     *
     * @param details the {@code details} to set
     * @return a reference to this Builder
     */
    public Builder details(List<String> details) {
      this.details = details;
      return this;
    }

    /**
     * Sets the {@code fieldErrors} and returns a reference to this Builder enabling method chaining.
     *
     * @param fieldErrors the {@code fieldErrors} to set
     * @return a reference to this Builder
     */
    public Builder fieldErrors(List<FieldError> fieldErrors) {
      this.fieldErrors = fieldErrors;
      return this;
    }

    /**
     * Sets the {@code additionalDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalDetails the {@code additionalDetails} to set
     * @return a reference to this Builder
     */
    public Builder additionalDetails(List<AdditionalDetail> additionalDetails) {
      this.additionalDetails = additionalDetails;
      return this;
    }

    /**
     * Returns a {@code Error} built from the parameters previously set.
     *
     * @return a {@code Error} built with parameters of this {@code Error.Builder}
     */
    public Error build() {
      return new Error(this);
    }
  }
}

