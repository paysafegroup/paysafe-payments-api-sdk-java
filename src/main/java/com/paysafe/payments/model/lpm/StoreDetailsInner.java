// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StoreDetailsInner
 */
public class StoreDetailsInner {

  @JsonProperty("posId")
  private String posId;
  @JsonProperty("name")
  private String name;
  @JsonProperty("address")
  private String address;
  @JsonProperty("latitude")
  private String latitude;
  @JsonProperty("longitude")
  private String longitude;
  @JsonProperty("postalCode")
  private String postalCode;
  @JsonProperty("city")
  private String city;
  @JsonProperty("cheatSheetUrl")
  private String cheatSheetUrl;
  @JsonProperty("distributorId")
  private String distributorId;
  @JsonProperty("country")
  private String country;
  @JsonProperty("posTypeLogo")
  private String posTypeLogo;
  @JsonProperty("productType")
  private String productType;
  @JsonProperty("media")
  private String media;
  @JsonProperty("productLogo")
  private String productLogo;
  @JsonProperty("specialImage")
  private String specialImage;
  @JsonProperty("specialText")
  private String specialText;
  @JsonProperty("cheatSheetText")
  private String cheatSheetText;
  @JsonProperty("recommended")
  private Boolean recommended;
  @JsonProperty("distanceFromOrigin")
  private String distanceFromOrigin;
  @JsonProperty("directload")
  private Boolean directload;
  @JsonProperty("storeFeedbacks")
  private List<String> storeFeedbacks = null;

  public StoreDetailsInner() {
    super();
  }

  private StoreDetailsInner(Builder builder) {
    setPosId(builder.posId);
    setName(builder.name);
    setAddress(builder.address);
    setLatitude(builder.latitude);
    setLongitude(builder.longitude);
    setPostalCode(builder.postalCode);
    setCity(builder.city);
    setCheatSheetUrl(builder.cheatSheetUrl);
    setDistributorId(builder.distributorId);
    setCountry(builder.country);
    setPosTypeLogo(builder.posTypeLogo);
    setProductType(builder.productType);
    setMedia(builder.media);
    setProductLogo(builder.productLogo);
    setSpecialImage(builder.specialImage);
    setSpecialText(builder.specialText);
    setCheatSheetText(builder.cheatSheetText);
    setRecommended(builder.recommended);
    setDistanceFromOrigin(builder.distanceFromOrigin);
    setDirectload(builder.directload);
    setStoreFeedbacks(builder.storeFeedbacks);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StoreDetailsInner posId(String posId) {
    this.posId = posId;
    return this;
  }

  /**
   * The payment point ID.
   *
   * @return posId
   */
  public String getPosId() {
    return posId;
  }

  public void setPosId(String posId) {
    this.posId = posId;
  }

  public StoreDetailsInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The payment point name.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StoreDetailsInner address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The payment point address.
   *
   * @return address
   */
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public StoreDetailsInner latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * The payment point latitudinal coordinates.
   *
   * @return latitude
   */
  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public StoreDetailsInner longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * The payment point longitudinal coordinates.
   *
   * @return longitude
   */
  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public StoreDetailsInner postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * The payment point postal code.
   *
   * @return postalCode
   */
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public StoreDetailsInner city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The payment city.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public StoreDetailsInner cheatSheetUrl(String cheatSheetUrl) {
    this.cheatSheetUrl = cheatSheetUrl;
    return this;
  }

  /**
   * The payment cheat sheet url.
   *
   * @return cheatSheetUrl
   */
  public String getCheatSheetUrl() {
    return cheatSheetUrl;
  }

  public void setCheatSheetUrl(String cheatSheetUrl) {
    this.cheatSheetUrl = cheatSheetUrl;
  }

  public StoreDetailsInner distributorId(String distributorId) {
    this.distributorId = distributorId;
    return this;
  }

  /**
   * The payment point distributor id.
   *
   * @return distributorId
   */
  public String getDistributorId() {
    return distributorId;
  }

  public void setDistributorId(String distributorId) {
    this.distributorId = distributorId;
  }

  public StoreDetailsInner country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The payment point country.
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public StoreDetailsInner posTypeLogo(String posTypeLogo) {
    this.posTypeLogo = posTypeLogo;
    return this;
  }

  /**
   * The payment point logo.
   *
   * @return posTypeLogo
   */
  public String getPosTypeLogo() {
    return posTypeLogo;
  }

  public void setPosTypeLogo(String posTypeLogo) {
    this.posTypeLogo = posTypeLogo;
  }

  public StoreDetailsInner productType(String productType) {
    this.productType = productType;
    return this;
  }

  /**
   * The payment point accepted product.
   *
   * @return productType
   */
  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public StoreDetailsInner media(String media) {
    this.media = media;
    return this;
  }

  /**
   * The payment point media type.
   *
   * @return media
   */
  public String getMedia() {
    return media;
  }

  public void setMedia(String media) {
    this.media = media;
  }

  public StoreDetailsInner productLogo(String productLogo) {
    this.productLogo = productLogo;
    return this;
  }

  /**
   * The payment point icon/marker to be shown on the map.
   *
   * @return productLogo
   */
  public String getProductLogo() {
    return productLogo;
  }

  public void setProductLogo(String productLogo) {
    this.productLogo = productLogo;
  }

  public StoreDetailsInner specialImage(String specialImage) {
    this.specialImage = specialImage;
    return this;
  }

  /**
   * The payment point special image.
   *
   * @return specialImage
   */
  public String getSpecialImage() {
    return specialImage;
  }

  public void setSpecialImage(String specialImage) {
    this.specialImage = specialImage;
  }

  public StoreDetailsInner specialText(String specialText) {
    this.specialText = specialText;
    return this;
  }

  /**
   * The payment point special text.
   *
   * @return specialText
   */
  public String getSpecialText() {
    return specialText;
  }

  public void setSpecialText(String specialText) {
    this.specialText = specialText;
  }

  public StoreDetailsInner cheatSheetText(String cheatSheetText) {
    this.cheatSheetText = cheatSheetText;
    return this;
  }

  /**
   * The payment point cheat sheet text.
   *
   * @return cheatSheetText
   */
  public String getCheatSheetText() {
    return cheatSheetText;
  }

  public void setCheatSheetText(String cheatSheetText) {
    this.cheatSheetText = cheatSheetText;
  }

  public StoreDetailsInner recommended(Boolean recommended) {
    this.recommended = recommended;
    return this;
  }

  /**
   * The payment point recommended status.
   *
   * @return recommended
   */
  public Boolean getRecommended() {
    return recommended;
  }

  public void setRecommended(Boolean recommended) {
    this.recommended = recommended;
  }

  public StoreDetailsInner distanceFromOrigin(String distanceFromOrigin) {
    this.distanceFromOrigin = distanceFromOrigin;
    return this;
  }

  /**
   * The payment point distance from the origin coordinates, in meters.
   *
   * @return distanceFromOrigin
   */
  public String getDistanceFromOrigin() {
    return distanceFromOrigin;
  }

  public void setDistanceFromOrigin(String distanceFromOrigin) {
    this.distanceFromOrigin = distanceFromOrigin;
  }

  public StoreDetailsInner directload(Boolean directload) {
    this.directload = directload;
    return this;
  }

  /**
   * The payment point acceptance of directload.
   *
   * @return directload
   */
  public Boolean getDirectload() {
    return directload;
  }

  public void setDirectload(Boolean directload) {
    this.directload = directload;
  }

  public StoreDetailsInner storeFeedbacks(List<String> storeFeedbacks) {
    this.storeFeedbacks = storeFeedbacks;
    return this;
  }

  public StoreDetailsInner addStoreFeedbacksItem(String storeFeedbacksItem) {
    if (this.storeFeedbacks == null) {
      this.storeFeedbacks = new ArrayList<>();
    }
    this.storeFeedbacks.add(storeFeedbacksItem);
    return this;
  }

  public StoreDetailsInner removeStoreFeedbacksItem(String storeFeedbacksItem) {
    if (storeFeedbacksItem != null && this.storeFeedbacks != null) {
      this.storeFeedbacks.remove(storeFeedbacksItem);
    }

    return this;
  }

  /**
   * Get storeFeedbacks
   *
   * @return storeFeedbacks
   */
  public List<String> getStoreFeedbacks() {
    return storeFeedbacks;
  }

  public void setStoreFeedbacks(List<String> storeFeedbacks) {
    this.storeFeedbacks = storeFeedbacks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreDetailsInner storeDetailsInner = (StoreDetailsInner) o;
    return Objects.equals(this.posId, storeDetailsInner.posId) &&
        Objects.equals(this.name, storeDetailsInner.name) &&
        Objects.equals(this.address, storeDetailsInner.address) &&
        Objects.equals(this.latitude, storeDetailsInner.latitude) &&
        Objects.equals(this.longitude, storeDetailsInner.longitude) &&
        Objects.equals(this.postalCode, storeDetailsInner.postalCode) &&
        Objects.equals(this.city, storeDetailsInner.city) &&
        Objects.equals(this.cheatSheetUrl, storeDetailsInner.cheatSheetUrl) &&
        Objects.equals(this.distributorId, storeDetailsInner.distributorId) &&
        Objects.equals(this.country, storeDetailsInner.country) &&
        Objects.equals(this.posTypeLogo, storeDetailsInner.posTypeLogo) &&
        Objects.equals(this.productType, storeDetailsInner.productType) &&
        Objects.equals(this.media, storeDetailsInner.media) &&
        Objects.equals(this.productLogo, storeDetailsInner.productLogo) &&
        Objects.equals(this.specialImage, storeDetailsInner.specialImage) &&
        Objects.equals(this.specialText, storeDetailsInner.specialText) &&
        Objects.equals(this.cheatSheetText, storeDetailsInner.cheatSheetText) &&
        Objects.equals(this.recommended, storeDetailsInner.recommended) &&
        Objects.equals(this.distanceFromOrigin, storeDetailsInner.distanceFromOrigin) &&
        Objects.equals(this.directload, storeDetailsInner.directload) &&
        Objects.equals(this.storeFeedbacks, storeDetailsInner.storeFeedbacks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(posId, name, address, latitude, longitude, postalCode, city, cheatSheetUrl, distributorId, country, posTypeLogo, productType, media,
        productLogo, specialImage, specialText, cheatSheetText, recommended, distanceFromOrigin, directload, storeFeedbacks);
  }

  @Override
  public String toString() {

    return "class StoreDetailsInner {\n"
        + "    posId: " + toIndentedString(posId) + "\n"
        + "    name: " + toIndentedString(name) + "\n"
        + "    address: " + toIndentedString(address) + "\n"
        + "    latitude: " + toIndentedString(latitude) + "\n"
        + "    longitude: " + toIndentedString(longitude) + "\n"
        + "    postalCode: " + toIndentedString(postalCode) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    cheatSheetUrl: " + toIndentedString(cheatSheetUrl) + "\n"
        + "    distributorId: " + toIndentedString(distributorId) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    posTypeLogo: " + toIndentedString(posTypeLogo) + "\n"
        + "    productType: " + toIndentedString(productType) + "\n"
        + "    media: " + toIndentedString(media) + "\n"
        + "    productLogo: " + toIndentedString(productLogo) + "\n"
        + "    specialImage: " + toIndentedString(specialImage) + "\n"
        + "    specialText: " + toIndentedString(specialText) + "\n"
        + "    cheatSheetText: " + toIndentedString(cheatSheetText) + "\n"
        + "    recommended: " + toIndentedString(recommended) + "\n"
        + "    distanceFromOrigin: " + toIndentedString(distanceFromOrigin) + "\n"
        + "    directload: " + toIndentedString(directload) + "\n"
        + "    storeFeedbacks: " + toIndentedString(storeFeedbacks) + "\n"
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
   * {@code StoreDetailsInner} builder static inner class.
   */
  public static final class Builder {
    private String posId;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String postalCode;
    private String city;
    private String cheatSheetUrl;
    private String distributorId;
    private String country;
    private String posTypeLogo;
    private String productType;
    private String media;
    private String productLogo;
    private String specialImage;
    private String specialText;
    private String cheatSheetText;
    private Boolean recommended;
    private String distanceFromOrigin;
    private Boolean directload;
    private List<String> storeFeedbacks;

    private Builder() {
    }

    /**
     * Sets the {@code posId} and returns a reference to this Builder enabling method chaining.
     *
     * @param posId the {@code posId} to set
     * @return a reference to this Builder
     */
    public Builder posId(String posId) {
      this.posId = posId;
      return this;
    }

    /**
     * Sets the {@code name} and returns a reference to this Builder enabling method chaining.
     *
     * @param name the {@code name} to set
     * @return a reference to this Builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Sets the {@code address} and returns a reference to this Builder enabling method chaining.
     *
     * @param address the {@code address} to set
     * @return a reference to this Builder
     */
    public Builder address(String address) {
      this.address = address;
      return this;
    }

    /**
     * Sets the {@code latitude} and returns a reference to this Builder enabling method chaining.
     *
     * @param latitude the {@code latitude} to set
     * @return a reference to this Builder
     */
    public Builder latitude(String latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     * Sets the {@code longitude} and returns a reference to this Builder enabling method chaining.
     *
     * @param longitude the {@code longitude} to set
     * @return a reference to this Builder
     */
    public Builder longitude(String longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     * Sets the {@code postalCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param postalCode the {@code postalCode} to set
     * @return a reference to this Builder
     */
    public Builder postalCode(String postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    /**
     * Sets the {@code city} and returns a reference to this Builder enabling method chaining.
     *
     * @param city the {@code city} to set
     * @return a reference to this Builder
     */
    public Builder city(String city) {
      this.city = city;
      return this;
    }

    /**
     * Sets the {@code cheatSheetUrl} and returns a reference to this Builder enabling method chaining.
     *
     * @param cheatSheetUrl the {@code cheatSheetUrl} to set
     * @return a reference to this Builder
     */
    public Builder cheatSheetUrl(String cheatSheetUrl) {
      this.cheatSheetUrl = cheatSheetUrl;
      return this;
    }

    /**
     * Sets the {@code distributorId} and returns a reference to this Builder enabling method chaining.
     *
     * @param distributorId the {@code distributorId} to set
     * @return a reference to this Builder
     */
    public Builder distributorId(String distributorId) {
      this.distributorId = distributorId;
      return this;
    }

    /**
     * Sets the {@code country} and returns a reference to this Builder enabling method chaining.
     *
     * @param country the {@code country} to set
     * @return a reference to this Builder
     */
    public Builder country(String country) {
      this.country = country;
      return this;
    }

    /**
     * Sets the {@code posTypeLogo} and returns a reference to this Builder enabling method chaining.
     *
     * @param posTypeLogo the {@code posTypeLogo} to set
     * @return a reference to this Builder
     */
    public Builder posTypeLogo(String posTypeLogo) {
      this.posTypeLogo = posTypeLogo;
      return this;
    }

    /**
     * Sets the {@code productType} and returns a reference to this Builder enabling method chaining.
     *
     * @param productType the {@code productType} to set
     * @return a reference to this Builder
     */
    public Builder productType(String productType) {
      this.productType = productType;
      return this;
    }

    /**
     * Sets the {@code media} and returns a reference to this Builder enabling method chaining.
     *
     * @param media the {@code media} to set
     * @return a reference to this Builder
     */
    public Builder media(String media) {
      this.media = media;
      return this;
    }

    /**
     * Sets the {@code productLogo} and returns a reference to this Builder enabling method chaining.
     *
     * @param productLogo the {@code productLogo} to set
     * @return a reference to this Builder
     */
    public Builder productLogo(String productLogo) {
      this.productLogo = productLogo;
      return this;
    }

    /**
     * Sets the {@code specialImage} and returns a reference to this Builder enabling method chaining.
     *
     * @param specialImage the {@code specialImage} to set
     * @return a reference to this Builder
     */
    public Builder specialImage(String specialImage) {
      this.specialImage = specialImage;
      return this;
    }

    /**
     * Sets the {@code specialText} and returns a reference to this Builder enabling method chaining.
     *
     * @param specialText the {@code specialText} to set
     * @return a reference to this Builder
     */
    public Builder specialText(String specialText) {
      this.specialText = specialText;
      return this;
    }

    /**
     * Sets the {@code cheatSheetText} and returns a reference to this Builder enabling method chaining.
     *
     * @param cheatSheetText the {@code cheatSheetText} to set
     * @return a reference to this Builder
     */
    public Builder cheatSheetText(String cheatSheetText) {
      this.cheatSheetText = cheatSheetText;
      return this;
    }

    /**
     * Sets the {@code recommended} and returns a reference to this Builder enabling method chaining.
     *
     * @param recommended the {@code recommended} to set
     * @return a reference to this Builder
     */
    public Builder recommended(Boolean recommended) {
      this.recommended = recommended;
      return this;
    }

    /**
     * Sets the {@code distanceFromOrigin} and returns a reference to this Builder enabling method chaining.
     *
     * @param distanceFromOrigin the {@code distanceFromOrigin} to set
     * @return a reference to this Builder
     */
    public Builder distanceFromOrigin(String distanceFromOrigin) {
      this.distanceFromOrigin = distanceFromOrigin;
      return this;
    }

    /**
     * Sets the {@code directload} and returns a reference to this Builder enabling method chaining.
     *
     * @param directload the {@code directload} to set
     * @return a reference to this Builder
     */
    public Builder directload(Boolean directload) {
      this.directload = directload;
      return this;
    }

    /**
     * Sets the {@code storeFeedbacks} and returns a reference to this Builder enabling method chaining.
     *
     * @param storeFeedbacks the {@code storeFeedbacks} to set
     * @return a reference to this Builder
     */
    public Builder storeFeedbacks(List<String> storeFeedbacks) {
      this.storeFeedbacks = storeFeedbacks;
      return this;
    }

    /**
     * Returns a {@code StoreDetailsInner} built from the parameters previously set.
     *
     * @return a {@code StoreDetailsInner} built with parameters of this {@code StoreDetailsInner.Builder}
     */
    public StoreDetailsInner build() {
      return new StoreDetailsInner(this);
    }
  }
}

