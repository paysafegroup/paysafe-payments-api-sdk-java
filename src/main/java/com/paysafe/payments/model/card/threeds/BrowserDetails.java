// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.ColorDepthBits;

/**
 * These are the browser details
 * <ul>
 *   <li>
 *     <b>acceptHeader:</b> This is the exact content of the HTTP accept header as sent to the 3DS Requestor from the cardholder’s browser.
 *   </li>
 *   <li>
 *     <b>colorDepthBits:</b> TThis is the bit depth of the color palette for displaying images, in bits per pixel.  <br>
 *     <i>Allowed values: 1, 4, 5, 15, 24, 32, 48</i>
 *   </li>
 *   <li>
 *     <b>customerIp:</b> This is the customer's IP address. Valid Ip address format are IPv4 / IPv6.
 *   </li>
 *   <li>
 *     <b>javaEnabled:</b> This indicates whether the cardholder's browser is able to execute Java.
 *   </li>
 *   <li>
 *     <b>javascriptEnabled:</b> This indicates whether the cardholder's browser is able to execute JavaScript.
 *   </li>
 *   <li>
 *     <b>language:</b> This is the language in the browser.
 *   </li>
 *   <li>
 *     <b>screenHeight:</b> This is the total height of the cardholder’s screen in pixels.
 *   </li>
 *   <li>
 *     <b>screenWidth:</b> This is the total width of the cardholder’s screen in pixels.
 *   </li>
 *   <li>
 *     <b>timezoneOffset:</b> This is the time-zone offset in minutes between UTC and the local time of the cardholder's browser.
 *   </li>
 *   <li>
 *     <b>userAgent:</b> This is the User-Agent header from the customer's browser.  <br>
 *     For example: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36
 *   </li>
 * </ul>
 */
public class BrowserDetails {

  @JsonProperty("acceptHeader")
  private String acceptHeader;
  @JsonProperty("colorDepthBits")
  private ColorDepthBits colorDepthBits;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("javaEnabled")
  private Boolean javaEnabled;
  @JsonProperty("javascriptEnabled")
  private Boolean javascriptEnabled;
  @JsonProperty("language")
  private String language;
  @JsonProperty("screenHeight")
  private Long screenHeight;
  @JsonProperty("screenWidth")
  private Long screenWidth;
  @JsonProperty("timezoneOffset")
  private Long timezoneOffset;
  @JsonProperty("userAgent")
  private String userAgent;

  public BrowserDetails() {
    super();
  }

  private BrowserDetails(Builder builder) {
    setAcceptHeader(builder.acceptHeader);
    setColorDepthBits(builder.colorDepthBits);
    setCustomerIp(builder.customerIp);
    setJavaEnabled(builder.javaEnabled);
    setJavascriptEnabled(builder.javascriptEnabled);
    setLanguage(builder.language);
    setScreenHeight(builder.screenHeight);
    setScreenWidth(builder.screenWidth);
    setTimezoneOffset(builder.timezoneOffset);
    setUserAgent(builder.userAgent);
  }

  public static Builder builder() {
    return new Builder();
  }

  public BrowserDetails acceptHeader(String acceptHeader) {
    this.acceptHeader = acceptHeader;
    return this;
  }

  /**
   * This is the exact content of the HTTP accept header as sent to the 3DS Requestor from the cardholder’s browser.
   *
   * @return acceptHeader
   */
  public String getAcceptHeader() {
    return acceptHeader;
  }

  public void setAcceptHeader(String acceptHeader) {
    this.acceptHeader = acceptHeader;
  }

  public BrowserDetails colorDepthBits(ColorDepthBits colorDepthBits) {
    this.colorDepthBits = colorDepthBits;
    return this;
  }

  /**
   * This is the bit depth of the color palette for displaying images, in bits per pixel.
   *
   * @return colorDepthBits
   */
  public ColorDepthBits getColorDepthBits() {
    return colorDepthBits;
  }

  public void setColorDepthBits(ColorDepthBits colorDepthBits) {
    this.colorDepthBits = colorDepthBits;
  }

  public BrowserDetails customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * This is the customer's IP address. Valid Ip address format are IPv4 / IPv6.
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }

  public BrowserDetails javaEnabled(Boolean javaEnabled) {
    this.javaEnabled = javaEnabled;
    return this;
  }

  /**
   * This indicates whether the cardholder's browser is able to execute Java.
   *
   * @return javaEnabled
   */
  public Boolean getJavaEnabled() {
    return javaEnabled;
  }

  public void setJavaEnabled(Boolean javaEnabled) {
    this.javaEnabled = javaEnabled;
  }

  public BrowserDetails javascriptEnabled(Boolean javascriptEnabled) {
    this.javascriptEnabled = javascriptEnabled;
    return this;
  }

  /**
   * This indicates whether the cardholder's browser is able to execute JavaScript.
   *
   * @return javascriptEnabled
   */
  public Boolean getJavascriptEnabled() {
    return javascriptEnabled;
  }

  public void setJavascriptEnabled(Boolean javascriptEnabled) {
    this.javascriptEnabled = javascriptEnabled;
  }

  public BrowserDetails language(String language) {
    this.language = language;
    return this;
  }

  /**
   * This is the language in the browser.
   *
   * @return language
   */
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public BrowserDetails screenHeight(Long screenHeight) {
    this.screenHeight = screenHeight;
    return this;
  }

  /**
   * This is the total height of the cardholder’s screen in pixels.  <br>
   * Maximum: 999999
   *
   * @return screenHeight
   */
  public Long getScreenHeight() {
    return screenHeight;
  }

  public void setScreenHeight(Long screenHeight) {
    this.screenHeight = screenHeight;
  }

  public BrowserDetails screenWidth(Long screenWidth) {
    this.screenWidth = screenWidth;
    return this;
  }

  /**
   * This is the total width of the cardholder’s screen in pixels.  <br>
   * Maximum: 999999
   *
   * @return screenWidth
   */
  public Long getScreenWidth() {
    return screenWidth;
  }

  public void setScreenWidth(Long screenWidth) {
    this.screenWidth = screenWidth;
  }

  public BrowserDetails timezoneOffset(Long timezoneOffset) {
    this.timezoneOffset = timezoneOffset;
    return this;
  }

  /**
   * This is the time-zone offset in minutes between UTC and the local time of the cardholder's browser.  <br>
   * Maximum: 99999
   *
   * @return timezoneOffset
   */
  public Long getTimezoneOffset() {
    return timezoneOffset;
  }

  public void setTimezoneOffset(Long timezoneOffset) {
    this.timezoneOffset = timezoneOffset;
  }

  public BrowserDetails userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  /**
   * This is the User-Agent header from the customer's browser. For example: <br>
   * Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125
   * Safari/537.36
   *
   * @return userAgent
   */
  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrowserDetails browserDetails = (BrowserDetails) o;
    return Objects.equals(this.acceptHeader, browserDetails.acceptHeader) &&
        Objects.equals(this.colorDepthBits, browserDetails.colorDepthBits) &&
        Objects.equals(this.customerIp, browserDetails.customerIp) &&
        Objects.equals(this.javaEnabled, browserDetails.javaEnabled) &&
        Objects.equals(this.javascriptEnabled, browserDetails.javascriptEnabled) &&
        Objects.equals(this.language, browserDetails.language) &&
        Objects.equals(this.screenHeight, browserDetails.screenHeight) &&
        Objects.equals(this.screenWidth, browserDetails.screenWidth) &&
        Objects.equals(this.timezoneOffset, browserDetails.timezoneOffset) &&
        Objects.equals(this.userAgent, browserDetails.userAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptHeader, colorDepthBits, customerIp, javaEnabled, javascriptEnabled, language,
        screenHeight, screenWidth, timezoneOffset, userAgent);
  }

  @Override
  public String toString() {

    return "class BrowserDetails {\n"
        + "    acceptHeader: " + toIndentedString(acceptHeader) + "\n"
        + "    colorDepthBits: " + toIndentedString(colorDepthBits) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    javaEnabled: " + toIndentedString(javaEnabled) + "\n"
        + "    javascriptEnabled: " + toIndentedString(javascriptEnabled) + "\n"
        + "    language: " + toIndentedString(language) + "\n"
        + "    screenHeight: " + toIndentedString(screenHeight) + "\n"
        + "    screenWidth: " + toIndentedString(screenWidth) + "\n"
        + "    timezoneOffset: " + toIndentedString(timezoneOffset) + "\n"
        + "    userAgent: " + toIndentedString(userAgent) + "\n"
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
   * {@code BrowserDetails} builder static inner class.
   */
  public static final class Builder {
    private String acceptHeader;
    private ColorDepthBits colorDepthBits;
    private String customerIp;
    private Boolean javaEnabled;
    private Boolean javascriptEnabled;
    private String language;
    private Long screenHeight;
    private Long screenWidth;
    private Long timezoneOffset;
    private String userAgent;

    private Builder() {
    }

    /**
     * Sets the {@code acceptHeader} and returns a reference to this Builder enabling method chaining.
     *
     * @param acceptHeader the {@code acceptHeader} to set
     * @return a reference to this Builder
     */
    public Builder acceptHeader(String acceptHeader) {
      this.acceptHeader = acceptHeader;
      return this;
    }

    /**
     * Sets the {@code colorDepthBits} and returns a reference to this Builder enabling method chaining.
     *
     * @param colorDepthBits the {@code colorDepthBits} to set
     * @return a reference to this Builder
     */
    public Builder colorDepthBits(ColorDepthBits colorDepthBits) {
      this.colorDepthBits = colorDepthBits;
      return this;
    }

    /**
     * Sets the {@code customerIp} and returns a reference to this Builder enabling method chaining.
     *
     * @param customerIp the {@code customerIp} to set
     * @return a reference to this Builder
     */
    public Builder customerIp(String customerIp) {
      this.customerIp = customerIp;
      return this;
    }

    /**
     * Sets the {@code javaEnabled} and returns a reference to this Builder enabling method chaining.
     *
     * @param javaEnabled the {@code javaEnabled} to set
     * @return a reference to this Builder
     */
    public Builder javaEnabled(Boolean javaEnabled) {
      this.javaEnabled = javaEnabled;
      return this;
    }

    /**
     * Sets the {@code javascriptEnabled} and returns a reference to this Builder enabling method chaining.
     *
     * @param javascriptEnabled the {@code javascriptEnabled} to set
     * @return a reference to this Builder
     */
    public Builder javascriptEnabled(Boolean javascriptEnabled) {
      this.javascriptEnabled = javascriptEnabled;
      return this;
    }

    /**
     * Sets the {@code language} and returns a reference to this Builder enabling method chaining.
     *
     * @param language the {@code language} to set
     * @return a reference to this Builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Sets the {@code screenHeight} and returns a reference to this Builder enabling method chaining.
     *
     * @param screenHeight the {@code screenHeight} to set
     * @return a reference to this Builder
     */
    public Builder screenHeight(Long screenHeight) {
      this.screenHeight = screenHeight;
      return this;
    }

    /**
     * Sets the {@code screenWidth} and returns a reference to this Builder enabling method chaining.
     *
     * @param screenWidth the {@code screenWidth} to set
     * @return a reference to this Builder
     */
    public Builder screenWidth(Long screenWidth) {
      this.screenWidth = screenWidth;
      return this;
    }

    /**
     * Sets the {@code timezoneOffset} and returns a reference to this Builder enabling method chaining.
     *
     * @param timezoneOffset the {@code timezoneOffset} to set
     * @return a reference to this Builder
     */
    public Builder timezoneOffset(Long timezoneOffset) {
      this.timezoneOffset = timezoneOffset;
      return this;
    }

    /**
     * Sets the {@code userAgent} and returns a reference to this Builder enabling method chaining.
     *
     * @param userAgent the {@code userAgent} to set
     * @return a reference to this Builder
     */
    public Builder userAgent(String userAgent) {
      this.userAgent = userAgent;
      return this;
    }

    /**
     * Returns a {@code BrowserDetails} built from the parameters previously set.
     *
     * @return a {@code BrowserDetails} built with parameters of this {@code BrowserDetails.Builder}
     */
    public BrowserDetails build() {
      return new BrowserDetails(this);
    }
  }
}

