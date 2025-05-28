// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.monitor;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonitorResponse {

  @JsonProperty("status")
  private ServiceStatus status;

  public MonitorResponse() {
    super();
  }

  private MonitorResponse(Builder builder) {
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }

  public MonitorResponse status(ServiceStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the service. Expected value: READY
   *
   * @return status
   */
  public ServiceStatus getStatus() {
    return status;
  }

  public void setStatus(ServiceStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorResponse verifyThatTheServiceIsAccessible = (MonitorResponse) o;
    return Objects.equals(this.status, verifyThatTheServiceIsAccessible.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    return "class MonitorResponse {\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * {@code MonitorResponse} builder static inner class.
   */
  public static final class Builder {
    private ServiceStatus status;

    private Builder() {
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(ServiceStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Returns a {@code MonitorResponse} built from the parameters previously set.
     *
     * @return a {@code MonitorResponse} built with parameters of this {@code MonitorResponse.Builder}
     */
    public MonitorResponse build() {
      return new MonitorResponse(this);
    }
  }
}
