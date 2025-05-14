// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds the external network token fields
 */
public class ExternalNetworkTokenResponseNetworkToken {

  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("expiry")
  private CardExpiry expiry;

  public ExternalNetworkTokenResponseNetworkToken() {
    super();
  }

  private ExternalNetworkTokenResponseNetworkToken(Builder builder) {
    setLastDigits(builder.lastDigits);
    setExpiry(builder.expiry);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ExternalNetworkTokenResponseNetworkToken lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last four digits of the network token.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  public ExternalNetworkTokenResponseNetworkToken expiry(CardExpiry expiry) {
    this.expiry = expiry;
    return this;
  }

  /**
   * This is the card's expiry date.
   *
   * @return expiry
   */
  public CardExpiry getExpiry() {
    return expiry;
  }

  public void setExpiry(CardExpiry expiry) {
    this.expiry = expiry;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalNetworkTokenResponseNetworkToken externalNetworkTokenResponseNetworkToken = (ExternalNetworkTokenResponseNetworkToken) o;
    return Objects.equals(this.lastDigits, externalNetworkTokenResponseNetworkToken.lastDigits) &&
        Objects.equals(this.expiry, externalNetworkTokenResponseNetworkToken.expiry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastDigits, expiry);
  }

  @Override
  public String toString() {

    return "class ExternalNetworkTokenResponseNetworkToken {\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    expiry: " + toIndentedString(expiry) + "\n"
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
   * {@code ExternalNetworkTokenResponseNetworkToken} builder static inner class.
   */
  public static final class Builder {
    private String lastDigits;
    private CardExpiry expiry;

    private Builder() {
    }

    /**
     * Sets the {@code lastDigits} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the {@code lastDigits} to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * Sets the {@code expiry} and returns a reference to this Builder enabling method chaining.
     *
     * @param expiry the {@code expiry} to set
     * @return a reference to this Builder
     */
    public Builder expiry(CardExpiry expiry) {
      this.expiry = expiry;
      return this;
    }

    /**
     * Returns a {@code ExternalNetworkTokenResponseNetworkToken} built from the parameters previously set.
     *
     * @return a {@code ExternalNetworkTokenResponseNetworkToken} built with parameters of this {@code ExternalNetworkTokenResponseNetworkToken.Builder}
     */
    public ExternalNetworkTokenResponseNetworkToken build() {
      return new ExternalNetworkTokenResponseNetworkToken(this);
    }
  }
}

