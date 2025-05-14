// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mazooma details to be used for the transaction
 */
public class Mazooma {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("ach")
  private MazoomaAch ach;

  public Mazooma() {
    super();
  }

  private Mazooma(Builder builder) {
    setConsumerId(builder.consumerId);
    setAch(builder.ach);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Mazooma consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is a field identifying the customer.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Mazooma ach(MazoomaAch ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Get ach
   *
   * @return ach
   */
  public MazoomaAch getAch() {
    return ach;
  }

  public void setAch(MazoomaAch ach) {
    this.ach = ach;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mazooma mazooma = (Mazooma) o;
    return Objects.equals(this.consumerId, mazooma.consumerId) &&
        Objects.equals(this.ach, mazooma.ach);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, ach);
  }

  @Override
  public String toString() {

    return "class Mazooma {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
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
   * {@code Mazooma} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private MazoomaAch ach;

    private Builder() {
    }

    /**
     * Sets the {@code consumerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the {@code consumerId} to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(MazoomaAch ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Returns a {@code Mazooma} built from the parameters previously set.
     *
     * @return a {@code Mazooma} built with parameters of this {@code Mazooma.Builder}
     */
    public Mazooma build() {
      return new Mazooma(this);
    }
  }
}

