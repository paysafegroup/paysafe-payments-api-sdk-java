// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing possible AVS (Address Verification Service) response codes.
 *
 * <p>Used by Authorization and Verification processes, this enum defines the outcomes of
 * AVS checks performed during a transaction. AVS is commonly used to verify that the billing
 * address provided by the customer matches the address on file with the card issuer.</p>
 *
 * <p>Enum Values:</p>
 * <ul>
 *   <li><strong>MATCH:</strong> Both the address and zip code match.</li>
 *   <li><strong>MATCH_ADDRESS_ONLY:</strong> Only the address matches, zip code does not.</li>
 *   <li><strong>MATCH_ZIP_ONLY:</strong> Only the zip code matches, address does not.</li>
 *   <li><strong>NO_MATCH:</strong> Neither the address nor the zip code matches.</li>
 *   <li><strong>NOT_PROCESSED:</strong> The AVS check was not processed.</li>
 *   <li><strong>UNKNOWN:</strong> The result of the AVS check is unknown.</li>
 * </ul>
 */
public enum AvsResponse {
  MATCH("MATCH"),

  MATCH_ADDRESS_ONLY("MATCH_ADDRESS_ONLY"),

  MATCH_ZIP_ONLY("MATCH_ZIP_ONLY"),

  NO_MATCH("NO_MATCH"),

  NOT_PROCESSED("NOT_PROCESSED"),

  UNKNOWN("UNKNOWN");

  private final String value;

  AvsResponse(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AvsResponse fromValue(String value) {
    for (AvsResponse b : AvsResponse.values()) {
      if (b.value.equalsIgnoreCase(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
