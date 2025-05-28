// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.api;

import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.hc.client5.http.HttpRequestRetryStrategy;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;

import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;

public class AutomaticRetryStrategy implements HttpRequestRetryStrategy {

  private final int maxAutomaticRetries;

  public AutomaticRetryStrategy(int maxAutomaticRetries) throws IllegalArgumentException {
    if (maxAutomaticRetries > 5) {
      throw new IllegalArgumentException(MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES);
    }
    if (maxAutomaticRetries < 0) {
      throw new IllegalArgumentException(MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE);
    }
    this.maxAutomaticRetries = maxAutomaticRetries;
  }

  @Override
  public boolean retryRequest(HttpRequest request, IOException exception, int executionCount, HttpContext context) {
    if (!"GET".equalsIgnoreCase(request.getMethod())) {
      return false;
    }
    return executionCount <= maxAutomaticRetries;
  }

  @Override public boolean retryRequest(HttpResponse response, int execCount, HttpContext context) {
    return false;
  }

  /**
   * Initial retry interval is 100 milliseconds and it is increased exponentially.
   */
  @Override
  public TimeValue getRetryInterval(HttpRequest request, IOException exception, int executionCount, HttpContext context) {
    long delay = 100;
    for (int i = 1; i < executionCount; i++) {
      delay *= 3;
    }
    double jitter = ThreadLocalRandom.current().nextDouble(0.75, 1.00);
    return TimeValue.ofMilliseconds((long) (delay * jitter));
  }

  @Override public TimeValue getRetryInterval(HttpResponse response, int execCount, HttpContext context) {
    return null;
  }
}