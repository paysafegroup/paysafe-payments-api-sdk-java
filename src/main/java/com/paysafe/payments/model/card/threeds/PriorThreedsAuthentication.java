// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.PriorThreeDsAuthenticationMethod;

/**
 * This is the previous authentication information used with current merchant, cardholder and card.
 * <ul>
 *   <li>
 *     <b>id:</b> This is the previous authentication ID for the cardholder.  <br>
 *     <b>Note:</b> For recurring payments, this is the authenticationId of the first authentication.
 *   </li>
 *   <li>
 *     <b>data:</b> This field is reserved for future iterations of 3D Secure 2.
 *   </li>
 *   <li>
 *     <b>method:</b> This is the mechanism used previously by the cardholder to authenticate to the 3DS Requestor.
 *     <i>Allowed values: FRICTIONLESS_AUTHENTICATION, ACS_CHALLENGE, AVS_VERIFIED, OTHER_ISSUER_METHOD</i>
 *   </li>
 *   <li>
 *     <b>time:</b> This is the date and time of the cardholder authentication.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.
 *   </li>
 * </ul>
 */
public class PriorThreedsAuthentication {

  @JsonProperty("id")
  private String id;
  @JsonProperty("data")
  private String data;
  @JsonProperty("method")
  private PriorThreeDsAuthenticationMethod method;
  @JsonProperty("time")
  private String time;

  public PriorThreedsAuthentication() {
    super();
  }

  private PriorThreedsAuthentication(Builder builder) {
    setId(builder.id);
    setData(builder.data);
    setMethod(builder.method);
    setTime(builder.time);
  }

  public static Builder builder() {
    return new Builder();
  }

  public PriorThreedsAuthentication id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the previous authentication ID for the cardholder.  <b>Note:</b> For recurring payments, this is the authenticationId of the first authentication.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PriorThreedsAuthentication data(String data) {
    this.data = data;
    return this;
  }

  /**
   * This field is reserved for future iterations of 3D Secure 2.
   *
   * @return data
   */
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public PriorThreedsAuthentication method(PriorThreeDsAuthenticationMethod method) {
    this.method = method;
    return this;
  }

  /**
   * This is the mechanism used previously by the cardholder to authenticate to the 3DS Requestor.
   *
   * @return method
   */
  public PriorThreeDsAuthenticationMethod getMethod() {
    return method;
  }

  public void setMethod(PriorThreeDsAuthenticationMethod method) {
    this.method = method;
  }

  public PriorThreedsAuthentication time(String time) {
    this.time = time;
    return this;
  }

  /**
   * This is the date and time of the cardholder authentication. The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.
   *
   * @return time
   */
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriorThreedsAuthentication priorThreedsAuthentication = (PriorThreedsAuthentication) o;
    return Objects.equals(this.id, priorThreedsAuthentication.id) &&
        Objects.equals(this.data, priorThreedsAuthentication.data) &&
        Objects.equals(this.method, priorThreedsAuthentication.method) &&
        Objects.equals(this.time, priorThreedsAuthentication.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, method, time);
  }

  @Override
  public String toString() {

    return "class PriorThreedsAuthentication {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    data: " + toIndentedString(data) + "\n"
        + "    method: " + toIndentedString(method) + "\n"
        + "    time: " + toIndentedString(time) + "\n"
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
   * {@code PriorThreedsAuthentication} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String data;
    private PriorThreeDsAuthenticationMethod method;
    private String time;

    private Builder() {
    }

    /**
     * Sets the {@code id} and returns a reference to this Builder enabling method chaining.
     *
     * @param id the {@code id} to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the {@code data} and returns a reference to this Builder enabling method chaining.
     *
     * @param data the {@code data} to set
     * @return a reference to this Builder
     */
    public Builder data(String data) {
      this.data = data;
      return this;
    }

    /**
     * Sets the {@code method} and returns a reference to this Builder enabling method chaining.
     *
     * @param method the {@code method} to set
     * @return a reference to this Builder
     */
    public Builder method(PriorThreeDsAuthenticationMethod method) {
      this.method = method;
      return this;
    }

    /**
     * Sets the {@code time} and returns a reference to this Builder enabling method chaining.
     *
     * @param time the {@code time} to set
     * @return a reference to this Builder
     */
    public Builder time(String time) {
      this.time = time;
      return this;
    }

    /**
     * Returns a {@code PriorThreedsAuthentication} built from the parameters previously set.
     *
     * @return a {@code PriorThreedsAuthentication} built with parameters of this {@code PriorThreedsAuthentication.Builder}
     */
    public PriorThreedsAuthentication build() {
      return new PriorThreedsAuthentication(this);
    }
  }
}

