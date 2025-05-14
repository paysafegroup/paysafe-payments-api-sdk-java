// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains meta info for the pagination APIs
 */
public class Meta {

  @JsonProperty("numberOfRecords")
  private Integer numberOfRecords;
  @JsonProperty("limit")
  private Integer limit;
  @JsonProperty("page")
  private Integer page;

  public Meta() {
    super();
  }

  private Meta(Builder builder) {
    setNumberOfRecords(builder.numberOfRecords);
    setLimit(builder.limit);
    setPage(builder.page);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Meta numberOfRecords(Integer numberOfRecords) {
    this.numberOfRecords = numberOfRecords;
    return this;
  }

  /**
   * This is the number of records returned in the  lookup.
   *
   * @return numberOfRecords
   */
  public Integer getNumberOfRecords() {
    return numberOfRecords;
  }

  public void setNumberOfRecords(Integer numberOfRecords) {
    this.numberOfRecords = numberOfRecords;
  }

  public Meta limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * This is the number of records returned per page.
   *
   * @return limit
   */
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Meta page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * This is the page of records on which the lookup  starts.
   *
   * @return page
   */
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meta meta = (Meta) o;
    return Objects.equals(this.numberOfRecords, meta.numberOfRecords) &&
        Objects.equals(this.limit, meta.limit) &&
        Objects.equals(this.page, meta.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfRecords, limit, page);
  }

  @Override
  public String toString() {

    return "class Meta {\n"
        + "    numberOfRecords: " + toIndentedString(numberOfRecords) + "\n"
        + "    limit: " + toIndentedString(limit) + "\n"
        + "    page: " + toIndentedString(page) + "\n"
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
   * {@code Meta} builder static inner class.
   */
  public static final class Builder {
    private Integer numberOfRecords;
    private Integer limit;
    private Integer page;

    private Builder() {
    }

    /**
     * Sets the {@code numberOfRecords} and returns a reference to this Builder enabling method chaining.
     *
     * @param numberOfRecords the {@code numberOfRecords} to set
     * @return a reference to this Builder
     */
    public Builder numberOfRecords(Integer numberOfRecords) {
      this.numberOfRecords = numberOfRecords;
      return this;
    }

    /**
     * Sets the {@code limit} and returns a reference to this Builder enabling method chaining.
     *
     * @param limit the {@code limit} to set
     * @return a reference to this Builder
     */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Sets the {@code page} and returns a reference to this Builder enabling method chaining.
     *
     * @param page the {@code page} to set
     * @return a reference to this Builder
     */
    public Builder page(Integer page) {
      this.page = page;
      return this;
    }

    /**
     * Returns a {@code Meta} built from the parameters previously set.
     *
     * @return a {@code Meta} built with parameters of this {@code Meta.Builder}
     */
    public Meta build() {
      return new Meta(this);
    }
  }
}

