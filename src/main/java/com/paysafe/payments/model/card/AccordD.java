// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.FinancingType;

/**
 * These are parameters for financing plans supported for certain merchant configurations.
 * Include this element only when instructed to do so by your account manager.
 * <b>Note:<b> Not all processing gateways support this parameter. Contact your account manager for more information.
 *
 * <p>Key Fields:</p>
 * <ul>
 *   <li><strong>financingType:</strong> Specifies the type of financing applied (e.g., installment financing).</li>
 *   <li><strong>plan:</strong> Represents the financing plan, typically defined by a unique identifier or name.</li>
 *   <li><strong>gracePeriod:</strong> Defines the number of months or days before payments are required.</li>
 *   <li><strong>term:</strong> Specifies the duration of the financing agreement, typically in months.</li>
 * </ul>
 *
 * <p>This class is commonly used when detailed financing agreements need to be processed or displayed.</p>
 */
public class AccordD {

  @JsonProperty("financingType")
  private FinancingType financingType;
  @JsonProperty("plan")
  private String plan;
  @JsonProperty("gracePeriod")
  private Long gracePeriod;
  @JsonProperty("term")
  private Long term;

  public AccordD() {
    super();
  }

  private AccordD(Builder builder) {
    setFinancingType(builder.financingType);
    setPlan(builder.plan);
    setGracePeriod(builder.gracePeriod);
    setTerm(builder.term);
  }

  public static Builder builder() {
    return new Builder();
  }

  public AccordD financingType(FinancingType financingType) {
    this.financingType = financingType;
    return this;
  }

  /**
   * This is the type of financing offered.  - DEFERRED_PAYMENT – Deferred payment financing. - EQUAL_PAYMENT – Equal payment financing
   *
   * @return financingType
   */
  public FinancingType getFinancingType() {
    return financingType;
  }

  public void setFinancingType(FinancingType financingType) {
    this.financingType = financingType;
  }

  public AccordD plan(String plan) {
    this.plan = plan;
    return this;
  }

  /**
   * This is the plan number for this financing transaction.
   *
   * @return plan
   */
  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public AccordD gracePeriod(Long gracePeriod) {
    this.gracePeriod = gracePeriod;
    return this;
  }

  /**
   * This is the grace period, in months, associated with deferred payment transactions. <br />
   * Maximum: 99
   *
   * @return gracePeriod
   */
  public Long getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(Long gracePeriod) {
    this.gracePeriod = gracePeriod;
  }

  public AccordD term(Long term) {
    this.term = term;
    return this;
  }

  /**
   * This is the number of payments, in months, for equal payment transactions. <br />
   * Maximum: 99
   *
   * @return term
   */
  public Long getTerm() {
    return term;
  }

  public void setTerm(Long term) {
    this.term = term;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccordD accordD = (AccordD) o;
    return Objects.equals(this.financingType, accordD.financingType) &&
        Objects.equals(this.plan, accordD.plan) &&
        Objects.equals(this.gracePeriod, accordD.gracePeriod) &&
        Objects.equals(this.term, accordD.term);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financingType, plan, gracePeriod, term);
  }

  @Override
  public String toString() {

    return "class AccordD {\n"
        + "    financingType: " + toIndentedString(financingType) + "\n"
        + "    plan: " + toIndentedString(plan) + "\n"
        + "    gracePeriod: " + toIndentedString(gracePeriod) + "\n"
        + "    term: " + toIndentedString(term) + "\n"
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
   * {@code AccordD} builder static inner class.
   */
  public static final class Builder {
    private FinancingType financingType;
    private String plan;
    private Long gracePeriod;
    private Long term;

    private Builder() {
    }

    /**
     * Sets the {@code financingType} and returns a reference to this Builder enabling method chaining.
     *
     * @param financingType the {@code financingType} to set
     * @return a reference to this Builder
     */
    public Builder financingType(FinancingType financingType) {
      this.financingType = financingType;
      return this;
    }

    /**
     * Sets the {@code plan} and returns a reference to this Builder enabling method chaining.
     *
     * @param plan the {@code plan} to set
     * @return a reference to this Builder
     */
    public Builder plan(String plan) {
      this.plan = plan;
      return this;
    }

    /**
     * Sets the {@code gracePeriod} and returns a reference to this Builder enabling method chaining.
     *
     * @param gracePeriod the {@code gracePeriod} to set
     * @return a reference to this Builder
     */
    public Builder gracePeriod(Long gracePeriod) {
      this.gracePeriod = gracePeriod;
      return this;
    }

    /**
     * Sets the {@code term} and returns a reference to this Builder enabling method chaining.
     *
     * @param term the {@code term} to set
     * @return a reference to this Builder
     */
    public Builder term(Long term) {
      this.term = term;
      return this;
    }

    /**
     * Returns a {@code AccordD} built from the parameters previously set.
     *
     * @return a {@code AccordD} built with parameters of this {@code AccordD.Builder}
     */
    public AccordD build() {
      return new AccordD(this);
    }
  }
}

