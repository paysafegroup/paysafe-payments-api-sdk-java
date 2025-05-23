// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.api;

import com.paysafe.payments.model.PaymentSimulator;

/**
 * This class is used to define configuration for each request. Fields that may be modified per request: <ul>
 * <li>connectTimeout: maximum time allowed to establish connection to Paysafe API, in milliseconds. Default: 30000</li>
 * <li>responseTimeout: maximum time allowed to read the data from established connection, in milliseconds. Default: 6000</li>
 * <li>maxAutomaticRetries: the number of times that the request will be automatically retried in case of ApiConnectionException.
 * In case of other exceptions, the request will not be retried.  <br>
 * Default: 0  <br>
 * Maximum allowed value: 5</li>
 * <li>simulator: The simulator is only applicable in the test environment and its default value is set as EXTERNAL.
 * In the production environment, the simulator value is disregarded, even if provided, and the experience will be the same as
 * if the simulator value were set as EXTERNAL.</li>
 * </ul>
 * <p>
 * If any of the configuration value is not provided when executing API request, default value will be used.
 */
public class RequestOptions {

  private Integer connectTimeout;
  private Integer responseTimeout;
  private Integer maxAutomaticRetries;
  private PaymentSimulator simulator = PaymentSimulator.EXTERNAL;

  public RequestOptions() {
  }

  private RequestOptions(Builder builder) {
    connectTimeout = builder.connectionTimeout;
    responseTimeout = builder.responseTimeout;
    maxAutomaticRetries = builder.maxAutomaticRetries;
    simulator = builder.simulator;
  }

  public static Builder builder() {
    return new Builder();
  }

  public Integer getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Integer connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Integer getResponseTimeout() {
    return responseTimeout;
  }

  public void setResponseTimeout(Integer responseTimeout) {
    this.responseTimeout = responseTimeout;
  }

  public Integer getMaxAutomaticRetries() {
    return maxAutomaticRetries;
  }

  public void setMaxAutomaticRetries(Integer maxAutomaticRetries) {
    this.maxAutomaticRetries = maxAutomaticRetries;
  }

  public PaymentSimulator getSimulator() {
    return simulator;
  }

  public void setSimulator(final PaymentSimulator simulator) {
    this.simulator = simulator;
  }

  /**
   * {@code RequestConfig} builder static inner class.
   */
  public static final class Builder {
    private Integer connectionTimeout;
    private Integer responseTimeout;
    private Integer maxAutomaticRetries;
    private PaymentSimulator simulator;

    private Builder() {
    }

    /**
     * Sets the {@code connectionTimeout} and returns a reference to this Builder enabling method chaining.
     *
     * @param connectionTimeout the {@code connectionTimeout} to set
     * @return a reference to this Builder
     */
    public Builder connectTimeout(Integer connectionTimeout) {
      this.connectionTimeout = connectionTimeout;
      return this;
    }

    /**
     * Sets the {@code responseTimeout} and returns a reference to this Builder enabling method chaining.
     *
     * @param responseTimeout the {@code responseTimeout} to set
     * @return a reference to this Builder
     */
    public Builder responseTimeout(Integer responseTimeout) {
      this.responseTimeout = responseTimeout;
      return this;
    }

    /**
     * Sets the {@code maxAutomaticRetries} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAutomaticRetries the {@code maxAutomaticRetries} to set
     * @return a reference to this Builder
     */
    public Builder automaticRetries(Integer maxAutomaticRetries) {
      this.maxAutomaticRetries = maxAutomaticRetries;
      return this;
    }

    /**
     * Sets the {@code simulator} and returns a reference to this Builder enabling method chaining.
     *
     * @param simulator the {@code simulator} to set
     * @return a reference to this Builder
     */
    public Builder simulator(PaymentSimulator simulator) {
      this.simulator = simulator;
      return this;
    }

    /**
     * Returns a {@code RequestConfig} built from the parameters previously set.
     *
     * @return a {@code RequestConfig} built with parameters of this {@code RequestConfig.Builder}
     */
    public RequestOptions build() {
      return new RequestOptions(this);
    }
  }
}
