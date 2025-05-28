// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.singleusecustomertoken.SingleUseCustomerToken;
import com.paysafe.payments.model.customer.singleusecustomertoken.SingleUseCustomerTokenRequest;
import com.paysafe.payments.service.CustomerSingleUseTokenService;

public class CustomerSingleUseTokenServiceImpl implements CustomerSingleUseTokenService {

  private static final String CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT = "/v1/customers/%s/singleusecustomertokens";
  private static final String GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT = "/v1/singleusecustomertokens/%s";

  private final PaysafeApiClient paysafeApiClient;

  /**
   * Instantiates new CustomerSingleUseTokenServiceImpl object.
   *
   * @param paysafeApiClient instance of paysafeApiClient which executes REST calls
   */
  public CustomerSingleUseTokenServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SingleUseCustomerToken createSingleUseCustomerToken(final String customerId,
      final SingleUseCustomerTokenRequest requestBody) throws PaysafeSdkException {
    return createSingleUseCustomerToken(customerId, requestBody, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SingleUseCustomerToken createSingleUseCustomerToken(final String customerId,
      final SingleUseCustomerTokenRequest requestBody, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executePost(String.format(CREATE_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, customerId),
        requestBody, requestOptions);

    return processResponse(response, SingleUseCustomerToken.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SingleUseCustomerToken getSingleUseCustomerToken(final String singleUseCustomerTokenId) throws PaysafeSdkException {
    return getSingleUseCustomerToken(singleUseCustomerTokenId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SingleUseCustomerToken getSingleUseCustomerToken(final String singleUseCustomerTokenId,
      final RequestOptions requestOptions) throws PaysafeSdkException {
    String endpoint = String.format(GET_CUSTOMER_SINGLE_USE_TOKEN_ENDPOINT, singleUseCustomerTokenId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(endpoint, requestOptions);

    return processResponse(response, SingleUseCustomerToken.class);
  }
}
