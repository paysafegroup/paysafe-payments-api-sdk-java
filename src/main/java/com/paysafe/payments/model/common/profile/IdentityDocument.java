// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.profile;

/**
 * Required if at time of onboarding with Paysafe enrolmentType is selected as "OPEN_LOOP" else optional.
 * <ul>
 *   <li>
 *     <b>type:</b> Value will always be "SOCIAL_SECURITY" This is part of 1st JSON object.
 *   </li>
 *   <li>
 *     <b>documentNumber:</b> The customer’s social security number.
 *   </li>
 * </ul>
 */
public class IdentityDocument {
  private String type;
  private String documentNumber;

  private IdentityDocument(final Builder builder) {
    setType(builder.type);
    setDocumentNumber(builder.documentNumber);
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  /**
   * {@code IdentityDocument} builder static inner class.
   */
  public static final class Builder {
    private String type;
    private String documentNumber;

    private Builder() {
    }

    /**
     * Sets the {@code type} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code type} to set
     * @return a reference to this Builder
     */
    public Builder type(final String val) {
      type = val;
      return this;
    }

    /**
     * Sets the {@code documentNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param val the {@code documentNumber} to set
     * @return a reference to this Builder
     */
    public Builder documentNumber(final String val) {
      documentNumber = val;
      return this;
    }

    /**
     * Returns a {@code IdentityDocument} built from the parameters previously set.
     *
     * @return a {@code IdentityDocument} built with parameters of this {@code IdentityDocument.Builder}
     */
    public IdentityDocument build() {
      return new IdentityDocument(this);
    }
  }
}
