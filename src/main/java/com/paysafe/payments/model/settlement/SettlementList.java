// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.settlement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * SettlementList
 */
public class SettlementList {

  @JsonProperty("settlements")
  private List<Settlement> settlements = null;
  @JsonProperty("meta")
  private Meta meta;

  public SettlementList() {
    super();
  }

  private SettlementList(Builder builder) {
    setSettlements(builder.settlements);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public SettlementList settlements(List<Settlement> settlements) {
    this.settlements = settlements;
    return this;
  }

  public SettlementList addSettlementsItem(Settlement settlementsItem) {
    if (this.settlements == null) {
      this.settlements = new ArrayList<>();
    }
    this.settlements.add(settlementsItem);
    return this;
  }

  public SettlementList removeSettlementsItem(Settlement settlementsItem) {
    if (settlementsItem != null && this.settlements != null) {
      this.settlements.remove(settlementsItem);
    }

    return this;
  }

  /**
   * An array of Settlements.
   *
   * @return settlements
   */
  public List<Settlement> getSettlements() {
    return settlements;
  }

  public void setSettlements(List<Settlement> settlements) {
    this.settlements = settlements;
  }

  public SettlementList meta(Meta meta) {
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
    SettlementList settlementList = (SettlementList) o;
    return Objects.equals(this.settlements, settlementList.settlements) &&
        Objects.equals(this.meta, settlementList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(settlements, meta);
  }

  @Override
  public String toString() {

    return "class SettlementList {\n"
        + "    settlements: " + toIndentedString(settlements) + "\n"
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
   * {@code SettlementList} builder static inner class.
   */
  public static final class Builder {
    private List<Settlement> settlements;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the {@code settlements} and returns a reference to this Builder enabling method chaining.
     *
     * @param settlements the {@code settlements} to set
     * @return a reference to this Builder
     */
    public Builder settlements(List<Settlement> settlements) {
      this.settlements = settlements;
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
     * Returns a {@code SettlementList} built from the parameters previously set.
     *
     * @return a {@code SettlementList} built with parameters of this {@code SettlementList.Builder}
     */
    public SettlementList build() {
      return new SettlementList(this);
    }
  }
}

