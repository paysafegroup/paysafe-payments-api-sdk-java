// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Electronic delivery details.
 * <ul>
 *   <li>
 *     <b>email:</b> This is the email address to which the merchandise was delivered.  <br>
 *     Example: example@example.com
 *   </li>
 *   <li>
 *     <b>isElectronicDelivery:</b> This indicates whether there is an electronic delivery for the product.
 *   </li>
 * </ul>
 */
public class ElectronicDelivery {

  @JsonProperty("email")
  private String email;
  @JsonProperty("isElectronicDelivery")
  private Boolean isElectronicDelivery;

  public ElectronicDelivery() {
    super();
  }

  private ElectronicDelivery(Builder builder) {
    setEmail(builder.email);
    setIsElectronicDelivery(builder.isElectronicDelivery);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ElectronicDelivery email(String email) {
    this.email = email;
    return this;
  }

  /**
   * This is the email address to which the merchandise was delivered.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ElectronicDelivery isElectronicDelivery(Boolean isElectronicDelivery) {
    this.isElectronicDelivery = isElectronicDelivery;
    return this;
  }

  /**
   * This indicates whether there is an electronic delivery for the product.
   *
   * @return isElectronicDelivery
   */
  public Boolean getIsElectronicDelivery() {
    return isElectronicDelivery;
  }

  public void setIsElectronicDelivery(Boolean isElectronicDelivery) {
    this.isElectronicDelivery = isElectronicDelivery;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElectronicDelivery electronicDelivery = (ElectronicDelivery) o;
    return Objects.equals(this.email, electronicDelivery.email) &&
        Objects.equals(this.isElectronicDelivery, electronicDelivery.isElectronicDelivery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, isElectronicDelivery);
  }

  @Override
  public String toString() {

    return "class ElectronicDelivery {\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    isElectronicDelivery: " + toIndentedString(isElectronicDelivery) + "\n"
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
   * {@code ElectronicDelivery} builder static inner class.
   */
  public static final class Builder {
    private String email;
    private Boolean isElectronicDelivery;

    private Builder() {
    }

    /**
     * Sets the {@code email} and returns a reference to this Builder enabling method chaining.
     *
     * @param email the {@code email} to set
     * @return a reference to this Builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Sets the {@code isElectronicDelivery} and returns a reference to this Builder enabling method chaining.
     *
     * @param isElectronicDelivery the {@code isElectronicDelivery} to set
     * @return a reference to this Builder
     */
    public Builder isElectronicDelivery(Boolean isElectronicDelivery) {
      this.isElectronicDelivery = isElectronicDelivery;
      return this;
    }

    /**
     * Returns a {@code ElectronicDelivery} built from the parameters previously set.
     *
     * @return a {@code ElectronicDelivery} built with parameters of this {@code ElectronicDelivery.Builder}
     */
    public ElectronicDelivery build() {
      return new ElectronicDelivery(this);
    }
  }
}

