// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;

/**
 * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site.
 * You can customize the return URL based on the transaction status.
 * <ul>
 *   <li>
 *     <b>rel:</b> This is the link type that allows different endpoints to be targeted depending on the end state of the transaction.  <br>
 *     <i>Allowed values: default, on_completed, on_failed, on_cancelled</i>
 *   </li>
 *   <li>
 *     <b>href:</b> This is the URI of the resource.  <br>
 *     Example: https://US_commerce_site/payment/return/success
 *   </li>
 *   <li>
 *     <b>method:</b> This is the HTTP method.  <br>
 *     Example: GET
 *   </li>
 * </ul>
 */
public class ReturnLink {

  @JsonProperty("rel")
  private ReturnLinkRel rel;
  @JsonProperty("href")
  private String href;
  @JsonProperty("method")
  private String method;

  public ReturnLink() {
    super();
  }

  private ReturnLink(Builder builder) {
    setRel(builder.rel);
    setHref(builder.href);
    setMethod(builder.method);
  }

  public static Builder builder() {
    return new Builder();
  }

  public ReturnLink rel(ReturnLinkRel rel) {
    this.rel = rel;
    return this;
  }

  /**
   * This is the link type that allows different endpoints to be targeted depending on the end state of the transaction.  <br>
   * <b>Note: </b> It is mandatory to provide <b>default</b> return url.
   * <ul>
   * <li>on_completed - Paysafe will return to this merchant url post successful payment</li>
   * <li>on_failed - Paysafe will return to this merchant url post if payment is failed.</li>
   * <li>on_cancelled - Paysafe will return to this merchant url post if payment is cancelled.</li>
   * <li>default - The default return URL that will be used if specific status return URL is not defined.</li>
   * </ul>
   * @return rel
   */
  public ReturnLinkRel getRel() {
    return rel;
  }

  public void setRel(ReturnLinkRel rel) {
    this.rel = rel;
  }

  public ReturnLink href(String href) {
    this.href = href;
    return this;
  }

  /**
   * This is the URI of the resource. <br>Supported protocols: http and https
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ReturnLink method(String method) {
    this.method = method;
    return this;
  }

  /**
   * This is the HTTP method.
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
    ReturnLink returnLinks = (ReturnLink) o;
    return Objects.equals(this.rel, returnLinks.rel) &&
        Objects.equals(this.href, returnLinks.href) &&
        Objects.equals(this.method, returnLinks.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rel, href, method);
  }

  @Override
  public String toString() {

    return "class ReturnLink {\n"
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
   * {@code ReturnLink} builder static inner class.
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
     * Returns a {@code ReturnLink} built from the parameters previously set.
     *
     * @return a {@code ReturnLink} built with parameters of this {@code ReturnLink.Builder}
     */
    public ReturnLink build() {
      return new ReturnLink(this);
    }
  }
}

