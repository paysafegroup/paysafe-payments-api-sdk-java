// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.error;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error as returned in json.
 */
public class ErrorResponse {

  @JsonProperty("error")
  private Error error;

  public ErrorResponse() {
  }

  public ErrorResponse(Error error) {
    this.error = error;
  }

  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }
}

