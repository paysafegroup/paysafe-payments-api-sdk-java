// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * This class creates a singleton instance of ObjectMapper, which cannot be modified dynamically.
 */
public class ObjectMapperConfiguration {

  private static final ObjectMapper objectMapper = initializeObjectMapper();

  private ObjectMapperConfiguration() {
  }

  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  private static ObjectMapper initializeObjectMapper() {
    return new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
