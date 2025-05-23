// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.Meta;

/**
 * StandaloneCreditList
 */
public class StandaloneCreditList {

  @JsonProperty("standaloneCredits")
  private List<StandaloneCredit> standaloneCredits = null;
  @JsonProperty("meta")
  private Meta meta;

  public StandaloneCreditList() {
    super();
  }

  private StandaloneCreditList(final Builder builder) {
    setStandaloneCredits(builder.standaloneCredits);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StandaloneCreditList standaloneCredits(List<StandaloneCredit> standalonecredits) {
    this.standaloneCredits = standalonecredits;
    return this;
  }

  public StandaloneCreditList addStandaloneCreditsItem(StandaloneCredit standalonecreditsItem) {
    if (this.standaloneCredits == null) {
      this.standaloneCredits = new ArrayList<>();
    }
    this.standaloneCredits.add(standalonecreditsItem);
    return this;
  }

  public StandaloneCreditList removeStandaloneCreditsItem(StandaloneCredit standalonecreditsItem) {
    if (standalonecreditsItem != null && this.standaloneCredits != null) {
      this.standaloneCredits.remove(standalonecreditsItem);
    }

    return this;
  }

  /**
   * An array of Standalone Credits.
   *
   * @return standaloneCredits
   */
  public List<StandaloneCredit> getStandaloneCredits() {
    return standaloneCredits;
  }

  public void setStandaloneCredits(List<StandaloneCredit> standaloneCredits) {
    this.standaloneCredits = standaloneCredits;
  }

  public StandaloneCreditList meta(Meta meta) {
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
    StandaloneCreditList standaloneCreditList = (StandaloneCreditList) o;
    return Objects.equals(this.standaloneCredits, standaloneCreditList.standaloneCredits) &&
        Objects.equals(this.meta, standaloneCreditList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(standaloneCredits, meta);
  }

  @Override
  public String toString() {
    return "class StandaloneCreditList{\n"
        + "    standaloneCredits: " + toIndentedString(standaloneCredits) + "\n"
        + "    meta: " + toIndentedString(meta) + "\n"
        + "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  public String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * {@code StandaloneCreditList} builder static inner class.
   */
  public static final class Builder {
    private Meta meta;
    private List<StandaloneCredit> standaloneCredits;

    private Builder() {
    }

    /**
     * Sets the {@code standaloneCredits} and returns a reference to this Builder enabling method chaining.
     *
     * @param standaloneCredits the {@code standaloneCredits} to set
     * @return a reference to this Builder
     */
    public Builder standaloneCredits(List<StandaloneCredit> standaloneCredits) {
      this.standaloneCredits = standaloneCredits;
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
     * Returns a {@code StandaloneCreditList} built from the parameters previously set.
     *
     * @return a {@code StandaloneCreditList} built with parameters of this {@code StandaloneCreditList.Builder}
     */
    public StandaloneCreditList build() {
      return new StandaloneCreditList(this);
    }
  }
}

