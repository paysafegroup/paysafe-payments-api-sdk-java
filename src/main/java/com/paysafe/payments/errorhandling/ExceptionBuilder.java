// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.errorhandling;

import static com.paysafe.payments.config.ObjectMapperConfiguration.getObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.errorhandling.error.AdditionalDetail;
import com.paysafe.payments.errorhandling.error.FieldError;
import com.paysafe.payments.errorhandling.error.PaysafeError;
import com.paysafe.payments.errorhandling.exception.ApiException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.InvalidRequestException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.RequestConflictException;
import com.paysafe.payments.errorhandling.exception.RequestDeclinedException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.common.error.ErrorResponse;

/**
 * Utility class for mapping various exceptions to PaysafeSdkException or its subclasses.
 */
public class ExceptionBuilder {

  public static final String HEADER_X_INTERNAL_CORRELATION_ID = "X-INTERNAL-CORRELATION-ID";

  private static final int HTTP_RESPONSE_CODE_BAD_REQUEST = 400;
  private static final int HTTP_RESPONSE_CODE_UNAUTHORIZED = 401;
  private static final int HTTP_RESPONSE_CODE_REQUEST_DECLINED = 402;
  private static final int HTTP_RESPONSE_CODE_FORBIDDEN = 403;
  private static final int HTTP_RESPONSE_CODE_CONFLICT = 409;
  private static final int HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR = 500;

  private static final Logger logger = LoggerFactory.getLogger(ExceptionBuilder.class);

  private ExceptionBuilder() {
  }

  /**
   * Builds a PaysafeSdkException. Extracts internalCorrelationId and http response status code, if they exist.
   *
   * @param customMessage to use for building exception
   * @param response      Payments API response containing status code, internal correlation id header and error details
   * @return PaysafeSdkException or one of its subclasses
   */
  public static <T> PaysafeSdkException buildPaysafeSdkException(final String customMessage, final PaysafeApiResponse response,
      final Class<T> responseType) {

    Integer httpStatusCode = response.getHttpStatusCode();
    String internalCorrelationId = response.getHeaders().get(HEADER_X_INTERNAL_CORRELATION_ID);

    try {
      if (httpStatusCode == HTTP_RESPONSE_CODE_REQUEST_DECLINED) {
        BaseApiResponse apiResponse = (BaseApiResponse) getObjectMapper().readValue(response.getResponseBody(), responseType);

        PaysafeError paysafeError = PaysafeError.Builder.builder()
            .code(apiResponse.getError().getCode())
            .message(apiResponse.getError().getMessage())
            .details(apiResponse.getError().getDetails())
            .additionalDetails(buildAdditionalDetails(apiResponse.getError().getAdditionalDetails()))
            .fieldErrors(buildFieldErrors(apiResponse.getError().getFieldErrors()))
            .build();

        return new RequestDeclinedException(customMessage, httpStatusCode, internalCorrelationId, paysafeError, apiResponse);
      }

      // in other cases, we receive only error responses
      ErrorResponse errorResponse = getObjectMapper().readValue(response.getResponseBody(), ErrorResponse.class);
      PaysafeError paysafeError = PaysafeError.Builder.builder()
          .code(errorResponse.getError().getCode())
          .message(errorResponse.getError().getMessage())
          .details(errorResponse.getError().getDetails())
          .additionalDetails(buildAdditionalDetails(errorResponse.getError().getAdditionalDetails()))
          .fieldErrors(buildFieldErrors(errorResponse.getError().getFieldErrors()))
          .build();

      if (httpStatusCode == HTTP_RESPONSE_CODE_BAD_REQUEST) {
        return new InvalidRequestException(customMessage, httpStatusCode, internalCorrelationId, paysafeError);
      } else if (httpStatusCode == HTTP_RESPONSE_CODE_UNAUTHORIZED) {
        return new InvalidCredentialsException(customMessage, httpStatusCode, internalCorrelationId, paysafeError);
      } else if (httpStatusCode == HTTP_RESPONSE_CODE_FORBIDDEN) {
        return new UnauthorizedException(customMessage, httpStatusCode, internalCorrelationId, paysafeError);
      } else if (httpStatusCode == HTTP_RESPONSE_CODE_CONFLICT) {
        return new RequestConflictException(customMessage, httpStatusCode, internalCorrelationId, paysafeError);
      } else if (httpStatusCode >= HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR) {
        return new ApiException(customMessage, httpStatusCode, internalCorrelationId, paysafeError);
      }
      return new PaysafeSdkException(customMessage, httpStatusCode, internalCorrelationId, paysafeError);
    } catch (IOException e) {
      logger.error("Exception while processing error response from PaymentsAPI: {}", e.getMessage(), e);
      return new PaysafeSdkException("Exception while processing error response from PaymentsAPI", httpStatusCode, internalCorrelationId);
    }
  }

  private static List<AdditionalDetail> buildAdditionalDetails(
      final List<com.paysafe.payments.model.common.error.AdditionalDetail> additionalDetails) {

    if (additionalDetails == null) {
      return null;
    }
    return additionalDetails.stream()
        .map(detail -> AdditionalDetail.Builder.builder()
            .code(detail.getCode())
            .message(detail.getMessage())
            .type(detail.getType())
            .build())
        .collect(Collectors.toList());
  }

  private static List<FieldError> buildFieldErrors(
      final List<com.paysafe.payments.model.common.error.FieldError> fieldErrors) {

    if (fieldErrors == null) {
      return null;
    }
    return fieldErrors.stream()
        .map(fieldError -> FieldError.Builder.builder()
            .field(fieldError.getField())
            .error(fieldError.getError())
            .build())
        .collect(Collectors.toList());
  }
}
