// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.originalcredit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * OriginalCreditList
 */
public class OriginalCreditList {

  @JsonProperty("originalCredits")
  private List<OriginalCredit> originalCredits = null;

  @JsonProperty("meta")
  private Meta meta;

  public OriginalCreditList() {
    super();
  }

  private OriginalCreditList(Builder builder) {
    setOriginalCredits(builder.originalCredits);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public OriginalCreditList originalCredits(List<OriginalCredit> originalCredits) {
    this.originalCredits = originalCredits;
    return this;
  }

  public OriginalCreditList addOriginalCreditItem(OriginalCredit creditItem) {
    if (this.originalCredits == null) {
      this.originalCredits = new ArrayList<>();
    }
    this.originalCredits.add(creditItem);
    return this;
  }

  public OriginalCreditList removeOriginalCreditItem(OriginalCredit creditItem) {
    if (creditItem != null && this.originalCredits != null) {
      this.originalCredits.remove(creditItem);
    }
    return this;
  }

  /**
   * Get originalCredits
   *
   * @return originalCredits
   */
  public List<OriginalCredit> getOriginalCredits() {
    return originalCredits;
  }

  public void setOriginalCredits(List<OriginalCredit> originalCredits) {
    this.originalCredits = originalCredits;
  }

  public OriginalCreditList meta(Meta meta) {
    this.meta = meta;
    return this;
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  @Override public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override public int hashCode() {
    return Objects.hash(originalCredits, meta);
  }

  @Override public String toString() {
    return "OriginalCreditList { \n" +
        "originalCredits=" + originalCredits +
        ", meta=" + meta +
        '}';
  }

  /**
   * {@code OriginalCreditList} builder static inner class.
   */
  public static final class Builder {
    private List<OriginalCredit> originalCredits;
    private Meta meta;

    private Builder() {
    }

    public Builder originalCredits(List<OriginalCredit> originalCredits) {
      this.originalCredits = originalCredits;
      return this;
    }

    public Builder meta(Meta meta) {
      this.meta = meta;
      return this;
    }

    public OriginalCreditList build() {
      return new OriginalCreditList(this);
    }
  }
}
