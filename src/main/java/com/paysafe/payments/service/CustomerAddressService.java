// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.Address;

public interface CustomerAddressService {

  /**
   * Creates an address for a previously created customer. Uses PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/addresses</strong></p>
   *
   * @param customerId The ID of the customer for whom the address is to be created.
   * @param address    The {@code Address} object containing address details.
   * @return An {@code Address} object containing the created address data.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Address createAddress(final String customerId, final Address address) throws PaysafeSdkException;

  /**
   * Creates an address for a previously created customer. <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, automaticRetries, and/or simulator, if applicable)
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/addresses</strong></p>
   *
   * @param customerId     The ID of the customer for whom the address is to be created.
   * @param address        The {@code Address} object containing address details.
   * @param requestOptions Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return An {@code Address} object containing the created address data.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Address createAddress(final String customerId, final Address address, final RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * Gets the details of a customer address using the unique address ID and customer ID. <br>
   * Uses PaysafeClient configuration to execute the request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/customers/{customerId}/addresses/{addressId}</strong></p>
   *
   * @param customerId The unique ID of the customer who owns the address.
   * @param addressId  The unique ID of the address to retrieve.
   * @return An {@code Address} object containing the address details for the given customer.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Address getAddressById(final String customerId, final String addressId) throws PaysafeSdkException;

  /**
   * Gets the details of a customer address using the unique address ID and customer ID with custom request options. <br>
   * The request will be executed using custom RequestOptions (e.g., connectTimeout, responseTimeout) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/customers/{customerId}/addresses/{addressId}</strong></p>
   *
   * @param customerId     The unique ID of the customer who owns the address.
   * @param addressId      The unique ID of the address to retrieve.
   * @param requestOptions Custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request.
   * @return An {@code Address} object containing the address details for the given customer.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Address getAddressById(final String customerId, final String addressId, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Updates an existing address for a customer using the unique address ID and customer ID.
   * Uses PaysafeClient configuration to execute the request.
   *
   * <p><strong>Note:</strong> All fields of the address must be provided in the request body.
   * Fields omitted will be set to {@code null}.</p>
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}/addresses/{addressId}</strong></p>
   *
   * @param customerId The unique ID of the customer who owns the address.
   * @param addressId  The unique ID of the address to be updated.
   * @param address    The {@code Address} object containing updated address details.
   * @return An {@code Address} object containing the updated address data.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Address updateAddress(final String customerId, final String addressId, final Address address) throws PaysafeSdkException;

  /**
   * Updates an existing address for a customer using the unique address ID and customer ID. <br>
   * The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}/addresses/{addressId}</strong></p>
   *
   * @param customerId     The unique ID of the customer who owns the address.
   * @param addressId      The unique ID of the address to be updated.
   * @param address        The {@code Address} object containing updated address details.
   * @param requestOptions Custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request.
   * @return An {@code Address} object containing the updated address data.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  Address updateAddress(final String customerId, final String addressId, final Address address, final RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * Deletes an existing address for a specific customer.
   * Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>DELETE /v1/customers/{customerId}/addresses/{addressId}</strong></p>
   *
   * @param customerId The unique identifier of the customer.
   * @param addressId  The unique identifier of the address to be deleted.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  void deleteAddress(final String customerId, final String addressId) throws PaysafeSdkException;

  /**
   * Deletes an existing address for a specific customer using custom request options
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient. <br>
   *
   * <p>Endpoint:
   * <strong>DELETE /v1/customers/{customerId}/addresses/{addressId}</strong></p>
   *
   * @param customerId     The unique identifier of the customer.
   * @param addressId      The unique identifier of the address to be deleted.
   * @param requestOptions Custom connectTimeout, responseTimeout, and/or automaticRetries.
   * @throws PaysafeSdkException If the request fails or the response cannot be processed.
   */
  void deleteAddress(final String customerId, final String addressId, final RequestOptions requestOptions) throws PaysafeSdkException;
}