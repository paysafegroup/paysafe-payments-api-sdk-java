// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is part of Interac e-Transfer withdrawal Payment Handle request. It is used by Interac Online for risk assessment.
 */
public class DeviceDetails {

  @JsonProperty("deviceId")
  private String deviceId;

  public DeviceDetails() {
    super();
  }

  private DeviceDetails(Builder builder) {
    setDeviceId(builder.deviceId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public DeviceDetails deviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  /**
   * This is part of Interac e-Transfer withdrawal payment handle request.
   *
   * @return deviceId
   */
  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceDetails deviceDetails = (DeviceDetails) o;
    return Objects.equals(this.deviceId, deviceDetails.deviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId);
  }

  @Override
  public String toString() {

    return "class DeviceDetails {\n"
        + "    deviceId: " + toIndentedString(deviceId) + "\n"
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
   * {@code DeviceDetails} builder static inner class.
   */
  public static final class Builder {
    private String deviceId;

    private Builder() {
    }

    /**
     * Sets the {@code deviceId} and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceId the {@code deviceId} to set
     * @return a reference to this Builder
     */
    public Builder deviceId(String deviceId) {
      this.deviceId = deviceId;
      return this;
    }

    /**
     * Returns a {@code DeviceDetails} built from the parameters previously set.
     *
     * @return a {@code DeviceDetails} built with parameters of this {@code DeviceDetails.Builder}
     */
    public DeviceDetails build() {
      return new DeviceDetails(this);
    }
  }
}
