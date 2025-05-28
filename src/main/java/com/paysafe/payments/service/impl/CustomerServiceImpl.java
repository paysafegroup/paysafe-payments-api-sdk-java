// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.buildQueryParameters;
import static com.paysafe.payments.api.PaysafeApiClient.processDeleteResponse;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import java.util.Optional;
import java.util.Set;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.customer.CustomerRequest;
import com.paysafe.payments.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

  public static final String CUSTOMERS_ENDPOINT = "/v1/customers";

  private final PaysafeApiClient paysafeApiClient;

  /**
   * Instantiates new CustomerService object.
   *
   * @param paysafeApiClient instance of paysafeApiClient which executes REST calls
   */
  public CustomerServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override public Customer createCustomer(final CustomerRequest customerRequest) throws PaysafeSdkException {
    return createCustomer(customerRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public Customer createCustomer(final CustomerRequest customerRequest, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executePost(CUSTOMERS_ENDPOINT, customerRequest, requestOptions);
    return processResponse(response, Customer.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Customer getCustomerById(final String customerId, final Set<String> fields) throws PaysafeSdkException {
    return getCustomerById(customerId, fields, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Customer getCustomerById(final String customerId, final Set<String> fields,
      final RequestOptions requestOptions) throws PaysafeSdkException {
    final String fieldsParamValue = Optional.ofNullable(fields).map(elem -> String.join(",", elem)).orElse(null);
    final String path = String.format("%s/%s%s", CUSTOMERS_ENDPOINT, customerId, buildQueryParameters(
        null, null, null, null, null, null, fieldsParamValue));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);

    return processResponse(response, Customer.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Customer getCustomerByMerchantCustomerId(final String merchantCustomerId, final Set<String> fields) throws PaysafeSdkException {
    return getCustomerByMerchantCustomerId(merchantCustomerId, fields, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Customer getCustomerByMerchantCustomerId(final String merchantCustomerId, final Set<String> fields,
      final RequestOptions requestOptions) throws PaysafeSdkException {
    final String fieldsParamValue = Optional.ofNullable(fields).map(elem -> String.join(",", elem)).orElse(null);
    final String path = String.format("%s%s", CUSTOMERS_ENDPOINT, buildQueryParameters(
        null, null, null, null, null, merchantCustomerId, fieldsParamValue));
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);

    return processResponse(response, Customer.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Customer updateCustomer(final String customerId, final CustomerRequest customerRequest) throws PaysafeSdkException {
    return updateCustomer(customerId, customerRequest, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Customer updateCustomer(final String customerId, final CustomerRequest customerRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format("%s/%s", CUSTOMERS_ENDPOINT, customerId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, customerRequest, requestOptions);

    return processResponse(response, Customer.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteCustomer(final String customerId) throws PaysafeSdkException {
    deleteCustomer(customerId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteCustomer(final String customerId, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executeDelete(String.format("%s/%s", CUSTOMERS_ENDPOINT, customerId),
        requestOptions);
    processDeleteResponse(response);
  }
}
