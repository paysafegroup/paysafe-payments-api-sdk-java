// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;

/**
 * URL link to redirect customer during transaction flow.
 * <ul>
 *   <li>
 *     <b>href:</b> The url to be used for further actions.  <br>
 *     Example: http://api.paysafe.com/card/redirect/372b5ee7-6360-4403-b444-164f8f1d2709
 *   </li>
 *   <li>
 *     <b>method:</b> The corresponding HTTP request method to be invoked on url.  <br>
 *     Example: GET
 *   </li>
 *   <li>
 *     <b>rel:</b> This is the link type that allows different endpoints to be targeted depending on the end state of the transaction.  <br>
 *     <i>Allowed values: redirect_payment, redirect_registration, on_completed, default, on_failed, on_cancelled</i>
 *   </li>
 *   <li>
 * </ul>
 */
public class Link {

  @JsonProperty("rel")
  private ReturnLinkRel rel;
  @JsonProperty("href")
  private String href;
  @JsonProperty("method")
  private String method;

  public Link() {
    super();
  }

  private Link(Builder builder) {
    setRel(builder.rel);
    setHref(builder.href);
    setMethod(builder.method);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Link rel(ReturnLinkRel rel) {
    this.rel = rel;
    return this;
  }

  /**
   * This is the link type that allows different endpoints to be targeted depending on the end state of the transaction.
   * <ul>
   * <li>redirect_registration - Merchant needs to redirect consumer to this url to complete registration. </li>
   * <li>redirect_payment - Merchant needs to redirect consumer to this url to complete authentication. </li>
   * <li>on_completed - Paysafe will return to this merchant url post successful payment. </li>
   * <li>on_failed - Paysafe will return to this merchant url post if payment is failed. </li>
   * <li>on_cancelled - Paysafe will return to this merchant url post if payment is cancelled. </li>
   * <li>default - The default return URL that will be used if specific status return URL is not defined. </li>
   *</ul>
   * @return rel
   */
  public ReturnLinkRel getRel() {
    return rel;
  }

  public void setRel(ReturnLinkRel rel) {
    this.rel = rel;
  }

  public Link href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The url to be used for further actions.
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Link method(String method) {
    this.method = method;
    return this;
  }

  /**
   * The corresponding HTTP request method to be invoked on url.
   *
   * @return method
   */
  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Link link = (Link) o;
    return Objects.equals(this.rel, link.rel) &&
        Objects.equals(this.href, link.href) &&
        Objects.equals(this.method, link.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rel, href, method);
  }

  @Override
  public String toString() {

    return "class Link {\n"
        + "    rel: " + toIndentedString(rel) + "\n"
        + "    href: " + toIndentedString(href) + "\n"
        + "    method: " + toIndentedString(method) + "\n"
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
   * {@code Links} builder static inner class.
   */
  public static final class Builder {
    private ReturnLinkRel rel;
    private String href;
    private String method;

    private Builder() {
    }

    /**
     * Sets the {@code rel} and returns a reference to this Builder enabling method chaining.
     *
     * @param rel the {@code rel} to set
     * @return a reference to this Builder
     */
    public Builder rel(ReturnLinkRel rel) {
      this.rel = rel;
      return this;
    }

    /**
     * Sets the {@code href} and returns a reference to this Builder enabling method chaining.
     *
     * @param href the {@code href} to set
     * @return a reference to this Builder
     */
    public Builder href(String href) {
      this.href = href;
      return this;
    }

    /**
     * Sets the {@code method} and returns a reference to this Builder enabling method chaining.
     *
     * @param method the {@code method} to set
     * @return a reference to this Builder
     */
    public Builder method(String method) {
      this.method = method;
      return this;
    }

    /**
     * Returns a {@code Links} built from the parameters previously set.
     *
     * @return a {@code Links} built with parameters of this {@code Links.Builder}
     */
    public Link build() {
      return new Link(this);
    }
  }
}
