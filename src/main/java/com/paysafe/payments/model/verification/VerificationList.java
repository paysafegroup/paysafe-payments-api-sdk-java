// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.verification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * VerificationList
 */
public class VerificationList {

  @JsonProperty("verifications")
  private List<Verification> verifications = null;
  @JsonProperty("meta")
  private Meta meta;

  public VerificationList() {
    super();
  }

  private VerificationList(Builder builder) {
    setVerifications(builder.verifications);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public VerificationList verifications(List<Verification> verifications) {
    this.verifications = verifications;
    return this;
  }

  public VerificationList addVerificationsItem(Verification verificationsItem) {
    if (this.verifications == null) {
      this.verifications = new ArrayList<>();
    }
    this.verifications.add(verificationsItem);
    return this;
  }

  public VerificationList removeVerificationsItem(Verification verificationsItem) {
    if (verificationsItem != null && this.verifications != null) {
      this.verifications.remove(verificationsItem);
    }

    return this;
  }

  /**
   * An array of Verifications.
   *
   * @return verifications
   */
  public List<Verification> getVerifications() {
    return verifications;
  }

  public void setVerifications(List<Verification> verifications) {
    this.verifications = verifications;
  }

  public VerificationList meta(Meta meta) {
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
    VerificationList verificationList = (VerificationList) o;
    return Objects.equals(this.verifications, verificationList.verifications) &&
        Objects.equals(this.meta, verificationList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verifications, meta);
  }

  @Override
  public String toString() {

    return "class VerificationList {\n"
        + "    verifications: " + toIndentedString(verifications) + "\n"
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
   * {@code VerificationList} builder static inner class.
   */
  public static final class Builder {
    private List<Verification> verifications;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the {@code verifications} and returns a reference to this Builder enabling method chaining.
     *
     * @param verifications the {@code verifications} to set
     * @return a reference to this Builder
     */
    public Builder verifications(List<Verification> verifications) {
      this.verifications = verifications;
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
     * Returns a {@code VerificationList} built from the parameters previously set.
     *
     * @return a {@code VerificationList} built with parameters of this {@code VerificationList.Builder}
     */
    public VerificationList build() {
      return new VerificationList(this);
    }
  }
}

