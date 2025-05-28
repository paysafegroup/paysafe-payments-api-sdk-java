// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling.error;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * This class contains detailed information about the error returned by Paysafe PaymentsAPI.
 */
public class PaysafeError implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Internal error code from Paysafe systems.
   */
  private String code;

  /**
   * Provides an error message that can be displayed to customers.
   */
  private String message;

  /**
   * List of error details that contains more information about the error.
   */
  private List<String> details = null;

  /**
   * List of json fields that caused the error.
   */
  private List<FieldError> fieldErrors = null;

  /**
   * List of additional details about the error.
   */
  private List<AdditionalDetail> additionalDetails = null;

  public PaysafeError() {
    super();
  }

  private PaysafeError(Builder builder) {
    setCode(builder.code);
    setMessage(builder.message);
    setDetails(builder.details);
    setFieldErrors(builder.fieldErrors);
    setAdditionalDetails(builder.additionalDetails);
  }

  public PaysafeError code(String code) {
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

  public PaysafeError message(String message) {
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

  public PaysafeError details(List<String> details) {
    this.details = details;
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

  public PaysafeError fieldErrors(List<FieldError> fieldErrors) {
    this.fieldErrors = fieldErrors;
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

  public PaysafeError additionalDetails(List<AdditionalDetail> additionalDetails) {
    this.additionalDetails = additionalDetails;
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
    PaysafeError paysafeError = (PaysafeError) o;
    return Objects.equals(this.code, paysafeError.code) &&
        Objects.equals(this.message, paysafeError.message) &&
        Objects.equals(this.details, paysafeError.details) &&
        Objects.equals(this.fieldErrors, paysafeError.fieldErrors) &&
        Objects.equals(this.additionalDetails, paysafeError.additionalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, details, fieldErrors, additionalDetails);
  }

  @Override
  public String toString() {

    return "class PaysafeError {\n"
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

    public static Builder builder() {
      return new Builder();
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
     * Returns a {@code PaysafeError} built from the parameters previously set.
     *
     * @return a {@code PaysafeError} built with parameters of this {@code Error.Builder}
     */
    public PaysafeError build() {
      return new PaysafeError(this);
    }
  }
}

