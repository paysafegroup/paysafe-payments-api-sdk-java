// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds network token card art fields  <br>
 * <ul>
 *   <li>
 *     <b>cardArtUrl:</b> The url for loading the card art url.  <br>
 *   </li>
 *   <li>
 *     <b>isCobranded:</b> Boolean value whether the card is cobranded.  <br>
 *     Example: 2024
 *   </li>
 * </ul>
 */
public class NetworkTokenCardArt {

  @JsonProperty("cardArtUrl")
  private String cardArtUrl;
  @JsonProperty("isCobranded")
  private Boolean isCobranded;

  public NetworkTokenCardArt() {
    super();
  }

  private NetworkTokenCardArt(Builder builder) {
    setCardArtUrl(builder.cardArtUrl);
    setIsCobranded(builder.isCobranded);
  }

  public static Builder builder() {
    return new Builder();
  }

  public NetworkTokenCardArt cardArtUrl(String cardArtUrl) {
    this.cardArtUrl = cardArtUrl;
    return this;
  }

  /**
   * The url for loading the card art url
   *
   * @return cardArtUrl
   */
  public String getCardArtUrl() {
    return cardArtUrl;
  }

  public void setCardArtUrl(String cardArtUrl) {
    this.cardArtUrl = cardArtUrl;
  }

  public NetworkTokenCardArt isCobranded(Boolean isCobranded) {
    this.isCobranded = isCobranded;
    return this;
  }

  /**
   * Boolean value whether the card is cobranded
   *
   * @return isCobranded
   */
  public Boolean getIsCobranded() {
    return isCobranded;
  }

  public void setIsCobranded(Boolean isCobranded) {
    this.isCobranded = isCobranded;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkTokenCardArt networkTokenCardArt = (NetworkTokenCardArt) o;
    return Objects.equals(this.cardArtUrl, networkTokenCardArt.cardArtUrl) &&
        Objects.equals(this.isCobranded, networkTokenCardArt.isCobranded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardArtUrl, isCobranded);
  }

  @Override
  public String toString() {

    return "class NetworkTokenCardArt {\n"
        + "    cardArtUrl: " + toIndentedString(cardArtUrl) + "\n"
        + "    isCobranded: " + toIndentedString(isCobranded) + "\n"
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
   * {@code NetworkTokenCardArt} builder static inner class.
   */
  public static final class Builder {
    private String cardArtUrl;
    private Boolean isCobranded;

    private Builder() {
    }

    /**
     * Sets the {@code cardArtUrl} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardArtUrl the {@code cardArtUrl} to set
     * @return a reference to this Builder
     */
    public Builder cardArtUrl(String cardArtUrl) {
      this.cardArtUrl = cardArtUrl;
      return this;
    }

    /**
     * Sets the {@code isCobranded} and returns a reference to this Builder enabling method chaining.
     *
     * @param isCobranded the {@code isCobranded} to set
     * @return a reference to this Builder
     */
    public Builder isCobranded(Boolean isCobranded) {
      this.isCobranded = isCobranded;
      return this;
    }

    /**
     * Returns a {@code NetworkTokenCardArt} built from the parameters previously set.
     *
     * @return a {@code NetworkTokenCardArt} built with parameters of this {@code NetworkTokenCardArt.Builder}
     */
    public NetworkTokenCardArt build() {
      return new NetworkTokenCardArt(this);
    }
  }
}

