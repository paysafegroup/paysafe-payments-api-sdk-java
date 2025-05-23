// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.voidauthorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * These are internal details of the void authorization response.
 */
public class VoidAuthorizationsList {

  @JsonProperty("voidAuths")
  private List<VoidAuthorization> voidAuths = null;
  @JsonProperty("meta")
  private Meta meta;

  public VoidAuthorizationsList() {
    super();
  }

  private VoidAuthorizationsList(Builder builder) {
    setVoidAuths(builder.voidAuths);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public VoidAuthorizationsList voidAuths(List<VoidAuthorization> voidAuths) {
    this.voidAuths = voidAuths;
    return this;
  }

  public VoidAuthorizationsList addVoidAuthsItem(VoidAuthorization voidAuthsItem) {
    if (this.voidAuths == null) {
      this.voidAuths = new ArrayList<>();
    }
    this.voidAuths.add(voidAuthsItem);
    return this;
  }

  public VoidAuthorizationsList removeVoidAuthsItem(VoidAuthorization voidAuthsItem) {
    if (voidAuthsItem != null && this.voidAuths != null) {
      this.voidAuths.remove(voidAuthsItem);
    }

    return this;
  }

  /**
   * Get voidAuths
   *
   * @return voidAuths
   */
  public List<VoidAuthorization> getVoidAuths() {
    return voidAuths;
  }

  public void setVoidAuths(List<VoidAuthorization> voidAuths) {
    this.voidAuths = voidAuths;
  }

  public VoidAuthorizationsList meta(Meta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Contains meta info for the pagination APIs
   *
   * @return meta
   */
  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoidAuthorizationsList voidAuthorizationsList = (VoidAuthorizationsList) o;
    return Objects.equals(this.voidAuths, voidAuthorizationsList.voidAuths) &&
        Objects.equals(this.meta, voidAuthorizationsList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(voidAuths, meta);
  }

  @Override
  public String toString() {

    return "class VoidAuthorizationsList {\n"
        + "    voidAuths: " + toIndentedString(voidAuths) + "\n"
        + "    meta: " + toIndentedString(meta) + "\n"
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
   * {@code VoidAuthorizationsList} builder static inner class.
   */
  public static final class Builder {
    private List<VoidAuthorization> voidAuths;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the {@code voidAuths} and returns a reference to this Builder enabling method chaining.
     *
     * @param voidAuths the {@code voidAuths} to set
     * @return a reference to this Builder
     */
    public Builder voidAuths(List<VoidAuthorization> voidAuths) {
      this.voidAuths = voidAuths;
      return this;
    }

    /**
     * Sets the {@code meta} and returns a reference to this Builder enabling method chaining.
     *
     * @param meta the {@code meta} to set
     * @return a reference to this Builder
     */
    public Builder meta(Meta meta) {
      this.meta = meta;
      return this;
    }

    /**
     * Returns a {@code VoidAuthorizationsList} built from the parameters previously set.
     *
     * @return a {@code VoidAuthorizationsList} built with parameters of this {@code VoidAuthorizationsList.Builder}
     */
    public VoidAuthorizationsList build() {
      return new VoidAuthorizationsList(this);
    }
  }
}

