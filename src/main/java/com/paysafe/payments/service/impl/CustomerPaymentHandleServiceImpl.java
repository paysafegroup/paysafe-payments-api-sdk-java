// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.processDeleteResponse;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.CustomerPaymentHandle;
import com.paysafe.payments.model.customer.CustomerPaymentHandleRequest;
import com.paysafe.payments.service.CustomerPaymentHandleService;

public class CustomerPaymentHandleServiceImpl implements CustomerPaymentHandleService {

  public static final String CUSTOMER_PAYMENT_HANDLES_ENDPOINT = "/v1/customers/%s/paymenthandles/%s";
  public static final String CREATE_CUSTOMER_PAYMENT_HANDLE_ENDPOINT = "/v1/customers/%s/paymenthandles";

  private final PaysafeApiClient paysafeApiClient;

  /**
   * Instantiates new CustomerPaymentHandleServiceImpl object.
   *
   * @param paysafeApiClient instance of paysafeApiClient which executes REST calls
   */
  public CustomerPaymentHandleServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CustomerPaymentHandle createPaymentHandleForCustomer(final String customerId, final CustomerPaymentHandleRequest customerPaymentHandleRequest)
      throws PaysafeSdkException {
    return createPaymentHandleForCustomer(customerId, customerPaymentHandleRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CustomerPaymentHandle createPaymentHandleForCustomer(final String customerId, final CustomerPaymentHandleRequest customerPaymentHandleRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(CREATE_CUSTOMER_PAYMENT_HANDLE_ENDPOINT, customerId);
    PaysafeApiResponse response = paysafeApiClient.executePost(path, customerPaymentHandleRequest, requestOptions);
    return processResponse(response, CustomerPaymentHandle.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public CustomerPaymentHandle getCustomerPaymentHandleByPaymentHandleId(final String customerId, final String paymentHandleId)
      throws PaysafeSdkException {
    return getCustomerPaymentHandleByPaymentHandleId(customerId, paymentHandleId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public CustomerPaymentHandle getCustomerPaymentHandleByPaymentHandleId(final String customerId, final String paymentHandleId,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, customerId, paymentHandleId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, CustomerPaymentHandle.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public CustomerPaymentHandle updateCustomerPaymentHandle(final String customerId, final String paymentHandleId,
      CustomerPaymentHandleRequest customerPaymentHandleRequest) throws PaysafeSdkException {
    return updateCustomerPaymentHandle(customerId, paymentHandleId, customerPaymentHandleRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public CustomerPaymentHandle updateCustomerPaymentHandle(final String customerId, final String paymentHandleId,
      final CustomerPaymentHandleRequest customerPaymentHandleRequest, final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, customerId, paymentHandleId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, customerPaymentHandleRequest, requestOptions);
    return processResponse(response, CustomerPaymentHandle.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public void deleteCustomerPaymentHandle(final String customerId, final String paymentHandleId) throws PaysafeSdkException {
    deleteCustomerPaymentHandle(customerId, paymentHandleId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public void deleteCustomerPaymentHandle(final String customerId, final String paymentHandleId,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    PaysafeApiResponse response = paysafeApiClient.executeDelete(String.format(CUSTOMER_PAYMENT_HANDLES_ENDPOINT, customerId, paymentHandleId),
        requestOptions);
    processDeleteResponse(response);
  }
}
