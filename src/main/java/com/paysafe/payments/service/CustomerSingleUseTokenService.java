// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.singleusecustomertoken.SingleUseCustomerToken;
import com.paysafe.payments.model.customer.singleusecustomertoken.SingleUseCustomerTokenRequest;

public interface CustomerSingleUseTokenService {

  /**
   * Create a Single-Use Token for an existing Customer. <br>
   * The <i>singleUseCustomerToken</i> returned in the response is then used in the PaymentsCheckout SDK (for the <i>singleUseCustomerToken</i> parameter)
   * when you want to use saved cards and addresses. Any addresses and/or payment details that have been saved for this {@code customerId}
   * would then be displayed in the Payments Checkout.  <br>
   * <b>Note:</b> The {@code customerId} used in this request must be taken from a Customer created using a single-use Payment Handle Token. <br> <br>
   * Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/singleusecustomertokens</strong></p>
   *
   * @param customerId  the unique ID returned in the response to the Create a Customer request
   * @param requestBody details used for single-use token creation
   * @return a {@code SingleUseCustomerToken} object which contains Customer data and the generated single-use token
   * @throws PaysafeSdkException if an error occurs
   */
  SingleUseCustomerToken createSingleUseCustomerToken(final String customerId,
      final SingleUseCustomerTokenRequest requestBody) throws PaysafeSdkException;

  /**
   * Create a Single-Use Token for an existing Customer. <br>
   * The <i>singleUseCustomerToken</i> returned in the response is then used in the PaymentsCheckout SDK (for the <i>singleUseCustomerToken</i> parameter)
   * when you want to use saved cards and addresses. Any addresses and/or payment details that have been saved for this {@code customerId}
   * would then be displayed in the Payments Checkout.  <br>
   * <b>Note:</b> The {@code customerId} used in this request must be taken from a Customer created using a single-use Payment Handle Token. <br> <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout and/or automaticRetries),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/singleusecustomertokens</strong></p>
   *
   * @param customerId     the unique ID returned in the response to the Create a Customer request
   * @param requestBody    details used for single-use token creation
   * @param requestOptions custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request
   * @return a {@code SingleUseCustomerToken} object which contains Customer data and the generated single-use token
   * @throws PaysafeSdkException if an error occurs
   */
  SingleUseCustomerToken createSingleUseCustomerToken(final String customerId,
      final SingleUseCustomerTokenRequest requestBody, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Get a Single-Use Customer Token by its unique ID. <br>
   * Use the <i>singleUseCustomerToken</i> returned in the response in the Payments Checkout SDK when you want to use
   * saved cards and addresses, provided the <i>timeToLiveSeconds</i> has not expired.  <br> <br>
   * The request will be executed using custom RequestOptions (connectTimeout, readTimeout and/or maxAutomaticRetries),
   * instead of default values from PaysafeClient.
   *
   * @param singleUseCustomerTokenId the Single-Use Customer Token ID returned in the response of the Single-Use Customer Token creation request
   * @return a {@code SingleUseCustomerToken} object which contains Customer data and its single-use token
   * @throws PaysafeSdkException if an error occurs
   */
  SingleUseCustomerToken getSingleUseCustomerToken(final String singleUseCustomerTokenId) throws PaysafeSdkException;

  /**
   * Get a Single-Use Customer Token by its unique ID. <br>
   * Use the <i>singleUseCustomerToken</i> returned in the response in the Payments Checkout SDK when you want to use
   * saved cards and addresses, provided the <i>timeToLiveSeconds</i> has not expired.  <br> <br>
   * The request will be executed using custom RequestOptions (connectTimeout, readTimeout and/or maxAutomaticRetries),
   * instead of default values from PaysafeClient.
   *
   * @param singleUseCustomerTokenId the Single-Use Customer Token ID returned in the response of the Single-Use Customer Token creation request
   * @param requestOptions           custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request
   * @return a {@code SingleUseCustomerToken} object which contains Customer data and its single-use token
   * @throws PaysafeSdkException if an error occurs
   */
  SingleUseCustomerToken getSingleUseCustomerToken(final String singleUseCustomerTokenId,
      final RequestOptions requestOptions) throws PaysafeSdkException;
}
