// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the cardholder login information.
 * <ul>
 *   <li>
 *     <b>authenticationMethod:</b> This is the mechanism used by the cardholder to authenticate to the 3DS Requestor.  <br>
 *     <i>Allowed values: NO_LOGIN, INTERNAL_CREDENTIALS, FEDERATED_ID, ISSUER_CREDENTIALS, THIRD_PARY_AUTHENTICATION,
 *     FIDO_AUTHENTICATOR</i>
 *   </li>
 *   <li>
 *     <b>data:</b> This field is reserved for future iterations of 3D Secure 2.  <br>
 *   </li>
 *   <li>
 *     <b>time:</b> This is the date and time of the cardholder authentication.
 *     The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.  <br>
 *   </li>
 * </ul>
 */
public class UserLogin {

  @JsonProperty("authenticationMethod")
  private AuthenticationMethod authenticationMethod;
  @JsonProperty("data")
  private String data;
  @JsonProperty("time")
  private String time;

  public UserLogin() {
    super();
  }

  private UserLogin(Builder builder) {
    setAuthenticationMethod(builder.authenticationMethod);
    setData(builder.data);
    setTime(builder.time);
  }

  public static Builder builder() {
    return new Builder();
  }

  public UserLogin authenticationMethod(AuthenticationMethod authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
    return this;
  }

  /**
   * This is the mechanism used by the cardholder to authenticate to the 3DS Requestor.
   *
   * @return authenticationMethod
   */
  public AuthenticationMethod getAuthenticationMethod() {
    return authenticationMethod;
  }

  public void setAuthenticationMethod(AuthenticationMethod authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
  }

  public UserLogin data(String data) {
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

  public UserLogin time(String time) {
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
    UserLogin userLogin = (UserLogin) o;
    return Objects.equals(this.authenticationMethod, userLogin.authenticationMethod) &&
        Objects.equals(this.data, userLogin.data) &&
        Objects.equals(this.time, userLogin.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authenticationMethod, data, time);
  }

  @Override
  public String toString() {

    return "class UserLogin {\n"
        + "    authenticationMethod: " + toIndentedString(authenticationMethod) + "\n"
        + "    data: " + toIndentedString(data) + "\n"
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
   * {@code UserLogin} builder static inner class.
   */
  public static final class Builder {
    private AuthenticationMethod authenticationMethod;
    private String data;
    private String time;

    private Builder() {
    }

    /**
     * Sets the {@code authenticationMethod} and returns a reference to this Builder enabling method chaining.
     *
     * @param authenticationMethod the {@code authenticationMethod} to set
     * @return a reference to this Builder
     */
    public Builder authenticationMethod(AuthenticationMethod authenticationMethod) {
      this.authenticationMethod = authenticationMethod;
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
     * Returns a {@code UserLogin} built from the parameters previously set.
     *
     * @return a {@code UserLogin} built with parameters of this {@code UserLogin.Builder}
     */
    public UserLogin build() {
      return new UserLogin(this);
    }
  }
}

