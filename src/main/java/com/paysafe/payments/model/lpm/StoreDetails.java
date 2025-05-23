// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StoreDetails
 */
public class StoreDetails {

  @JsonProperty("storeDetailsList")
  private List<StoreDetailsInner> storeDetailsList = null;
  @JsonProperty("message")
  private String message;
  @JsonProperty("status")
  private String status;
  @JsonProperty("errorCode")
  private String errorCode;

  public StoreDetails() {
    super();
  }

  private StoreDetails(Builder builder) {
    setStoreDetailsList(builder.storeDetailsList);
    setMessage(builder.message);
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StoreDetails storeDetailsList(List<StoreDetailsInner> storeDetailsList) {
    this.storeDetailsList = storeDetailsList;
    return this;
  }

  public StoreDetails addStoreDetailsListItem(StoreDetailsInner storeDetailsListItem) {
    if (this.storeDetailsList == null) {
      this.storeDetailsList = new ArrayList<>();
    }
    this.storeDetailsList.add(storeDetailsListItem);
    return this;
  }

  public StoreDetails removeStoreDetailsListItem(StoreDetailsInner storeDetailsListItem) {
    if (storeDetailsListItem != null && this.storeDetailsList != null) {
      this.storeDetailsList.remove(storeDetailsListItem);
    }

    return this;
  }

  /**
   * Get storeDetailsList
   *
   * @return storeDetailsList
   */
  public List<StoreDetailsInner> getStoreDetailsList() {
    return storeDetailsList;
  }

  public void setStoreDetailsList(List<StoreDetailsInner> storeDetailsList) {
    this.storeDetailsList = storeDetailsList;
  }

  public StoreDetails message(String message) {
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

  public StoreDetails status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public StoreDetails errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   *
   * @return errorCode
   */
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreDetails storeDetails = (StoreDetails) o;
    return Objects.equals(this.storeDetailsList, storeDetails.storeDetailsList) &&
        Objects.equals(this.message, storeDetails.message) &&
        Objects.equals(this.status, storeDetails.status) &&
        Objects.equals(this.errorCode, storeDetails.errorCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storeDetailsList, message, status, errorCode);
  }

  @Override
  public String toString() {

    return "class StoreDetails {\n"
        + "    storeDetailsList: " + toIndentedString(storeDetailsList) + "\n"
        + "    message: " + toIndentedString(message) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    errorCode: " + toIndentedString(errorCode) + "\n"
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
   * {@code StoreDetails} builder static inner class.
   */
  public static final class Builder {
    private List<StoreDetailsInner> storeDetailsList;
    private String message;
    private String status;

    private Builder() {
    }

    /**
     * Sets the {@code storeDetailsList} and returns a reference to this Builder enabling method chaining.
     *
     * @param storeDetailsList the {@code storeDetailsList} to set
     * @return a reference to this Builder
     */
    public Builder storeDetailsList(List<StoreDetailsInner> storeDetailsList) {
      this.storeDetailsList = storeDetailsList;
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
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Returns a {@code StoreDetails} built from the parameters previously set.
     *
     * @return a {@code StoreDetails} built with parameters of this {@code StoreDetails.Builder}
     */
    public StoreDetails build() {
      return new StoreDetails(this);
    }
  }
}

