// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Step
 */
public class Step {

  @JsonProperty("number")
  private Long number;
  @JsonProperty("instruction")
  private String instruction;

  public Step() {
    super();
  }

  private Step(Builder builder) {
    setNumber(builder.number);
    setInstruction(builder.instruction);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Step number(Long number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   *
   * @return number
   */
  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Step instruction(String instruction) {
    this.instruction = instruction;
    return this;
  }

  /**
   * Get instruction
   *
   * @return instruction
   */
  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Step step = (Step) o;
    return Objects.equals(this.number, step.number) &&
        Objects.equals(this.instruction, step.instruction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, instruction);
  }

  @Override
  public String toString() {

    return "class Step {\n"
        + "    number: " + toIndentedString(number) + "\n"
        + "    instruction: " + toIndentedString(instruction) + "\n"
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
   * {@code Step} builder static inner class.
   */
  public static final class Builder {
    private Long number;
    private String instruction;

    private Builder() {
    }

    /**
     * Sets the {@code number} and returns a reference to this Builder enabling method chaining.
     *
     * @param number the {@code number} to set
     * @return a reference to this Builder
     */
    public Builder number(Long number) {
      this.number = number;
      return this;
    }

    /**
     * Sets the {@code instruction} and returns a reference to this Builder enabling method chaining.
     *
     * @param instruction the {@code instruction} to set
     * @return a reference to this Builder
     */
    public Builder instruction(String instruction) {
      this.instruction = instruction;
      return this;
    }

    /**
     * Returns a {@code Step} built from the parameters previously set.
     *
     * @return a {@code Step} built with parameters of this {@code Step.Builder}
     */
    public Step build() {
      return new Step(this);
    }
  }
}

