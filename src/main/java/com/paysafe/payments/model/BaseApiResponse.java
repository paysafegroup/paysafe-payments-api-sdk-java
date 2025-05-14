// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.error.Error;

public abstract class BaseApiResponse {

  @JsonProperty("error")
  private Error error;

  public Error getError() {
    return error;
  }

  public void setError(final Error error) {
    this.error = error;
  }
}
