// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.FundingInstruction;

/**
 * These are the details of the spei account used for the request. Only one payment instrument object (for example, card or spei)
 * can be included in the request.
 */
public class Spei {

  @JsonProperty("fundingInstructions")
  private List<FundingInstruction> fundingInstructions = null;

  public Spei() {
    super();
  }

  private Spei(Builder builder) {
    setFundingInstructions(builder.fundingInstructions);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Spei fundingInstructions(List<FundingInstruction> fundingInstructions) {
    this.fundingInstructions = fundingInstructions;
    return this;
  }

  public Spei addFundingInstructionsItem(FundingInstruction fundingInstructionsItem) {
    if (this.fundingInstructions == null) {
      this.fundingInstructions = new ArrayList<>();
    }
    this.fundingInstructions.add(fundingInstructionsItem);
    return this;
  }

  public Spei removeFundingInstructionsItem(FundingInstruction fundingInstructionsItem) {
    if (fundingInstructionsItem != null && this.fundingInstructions != null) {
      this.fundingInstructions.remove(fundingInstructionsItem);
    }

    return this;
  }

  /**
   * Get fundingInstructions
   *
   * @return fundingInstructions
   */
  public List<FundingInstruction> getFundingInstructions() {
    return fundingInstructions;
  }

  public void setFundingInstructions(List<FundingInstruction> fundingInstructions) {
    this.fundingInstructions = fundingInstructions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Spei spei = (Spei) o;
    return Objects.equals(this.fundingInstructions, spei.fundingInstructions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fundingInstructions);
  }

  @Override
  public String toString() {

    return "class Spei {\n"
        + "    fundingInstructions: " + toIndentedString(fundingInstructions) + "\n"
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
   * {@code Spei} builder static inner class.
   */
  public static final class Builder {
    private List<FundingInstruction> fundingInstructions;

    private Builder() {
    }

    /**
     * Sets the {@code fundingInstructions} and returns a reference to this Builder enabling method chaining.
     *
     * @param fundingInstructions the {@code fundingInstructions} to set
     * @return a reference to this Builder
     */
    public Builder fundingInstructions(List<FundingInstruction> fundingInstructions) {
      this.fundingInstructions = fundingInstructions;
      return this;
    }

    /**
     * Returns a {@code Spei} built from the parameters previously set.
     *
     * @return a {@code Spei} built with parameters of this {@code Spei.Builder}
     */
    public Spei build() {
      return new Spei(this);
    }
  }
}

