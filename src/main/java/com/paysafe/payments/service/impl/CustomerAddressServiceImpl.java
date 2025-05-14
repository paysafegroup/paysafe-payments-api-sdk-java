// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service.impl;

import static com.paysafe.payments.api.PaysafeApiClient.processDeleteResponse;
import static com.paysafe.payments.api.PaysafeApiClient.processResponse;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.service.CustomerAddressService;

public class CustomerAddressServiceImpl implements CustomerAddressService {

  private static final String CUSTOMER_ADDRESS_ENDPOINT = "/v1/customers/%s/addresses";
  private final PaysafeApiClient paysafeApiClient;

  /**
   * Instantiates new CustomerAddressService object.
   *
   * @param paysafeApiClient instance of paysafeApiClient which executes REST calls
   */
  public CustomerAddressServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override public Address createAddress(final String customerId, final Address address) throws PaysafeSdkException {
    return createAddress(customerId, address, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public Address createAddress(final String customerId, final Address address, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format(CUSTOMER_ADDRESS_ENDPOINT, customerId);
    PaysafeApiResponse response = paysafeApiClient.executePost(path, address, requestOptions);
    return processResponse(response, Address.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public Address getAddressById(final String customerId, final String addressId) throws PaysafeSdkException {
    return getAddressById(customerId, addressId, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public Address getAddressById(final String customerId, final String addressId, final RequestOptions requestOptions) throws PaysafeSdkException {
    final String path = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", customerId, addressId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return processResponse(response, Address.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override public Address updateAddress(final String customerId, final String addressId, final Address address) throws PaysafeSdkException {
    return updateAddress(customerId, addressId, address, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override public Address updateAddress(final String customerId, final String addressId, final Address address,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", customerId, addressId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, address, requestOptions);
    return processResponse(response, Address.class);
  }

  @Override
  public void deleteAddress(final String customerId, final String addressId) throws PaysafeSdkException {
    deleteAddress(customerId, addressId, null);
  }

  @Override
  public void deleteAddress(final String customerId, final String addressId, final RequestOptions requestOptions) throws PaysafeSdkException {
    PaysafeApiResponse response = paysafeApiClient.executeDelete(String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", customerId, addressId),
        requestOptions);
    processDeleteResponse(response);
  }
}