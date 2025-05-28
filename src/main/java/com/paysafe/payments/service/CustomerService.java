// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import java.util.Set;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.customer.CustomerRequest;

public interface CustomerService {

  /**
   * Create new Customer. Uses PaysafeClient configuration.
   * <b>Note:</b> You can create a customer and store his/her credit card information to the customer profile by adding a Customer Payment Handle.
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers</strong></p>
   * <p>
   *
   * @param customerRequest containing new Customer's data
   * @return Customer, if it was created successfully
   * @throws PaysafeSdkException if an error occurs
   */
  Customer createCustomer(final CustomerRequest customerRequest) throws PaysafeSdkException;

  /**
   * Create new Customer. The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator,
   * if applicable), instead of values from PaysafeClient. <br>
   * <b>Note:</b> You can create a customer and store his/her credit card information to the customer profile by adding a Customer Payment Handle.
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers</strong></p>
   * <p>
   *
   * @param customerRequest containing new Customer's data
   * @param requestOptions  Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return Customer, if it was created successfully
   * @throws PaysafeSdkException if an error occurs
   */
  Customer createCustomer(final CustomerRequest customerRequest, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Get an existing Customer profile details by Customer ID. Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}</strong></p>
   * <p>
   *
   * @param customerId the unique ID returned in the response to the Create a Customer request
   * @param fields     list of sub-components (Possible values: addresses, paymenthandles)
   * @return Customer, if found
   * @throws PaysafeSdkException if an error occurs
   */
  Customer getCustomerById(final String customerId, final Set<String> fields) throws PaysafeSdkException;

  /**
   * Get an existing Customer profile details by Customer ID. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout and/or automaticRetries), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}</strong></p>
   * <p>
   *
   * @param customerId     the unique ID returned in the response to the Create a Customer request
   * @param fields         list of sub-components (Possible values: addresses, paymenthandles)
   * @param requestOptions custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request.
   * @return Customer, if found
   * @throws PaysafeSdkException if an error occurs
   */
  Customer getCustomerById(final String customerId, final Set<String> fields, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Get an existing Customer profile details by Merchant Customer ID. Uses PaysafeClient configuration.
   * <p>Endpoint:
   * <strong>GET /v1/customers</strong></p>
   * <p>
   *
   * @param merchantCustomerId customer ID that the merchant provided with the customer creation request for their own internal customer identification
   * @param fields             list of sub-components (Possible values: addresses, paymenthandles)
   * @return Customer, if found
   * @throws PaysafeSdkException if an error occurs
   */
  Customer getCustomerByMerchantCustomerId(final String merchantCustomerId, final Set<String> fields) throws PaysafeSdkException;

  /**
   * Get an existing Customer profile details by Merchant Customer ID. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   * <p>Endpoint:
   * <strong>GET /v1/customers</strong></p>
   * <p>
   *
   * @param merchantCustomerId customer ID that the merchant provided with the customer creation request for their own internal customer identification
   * @param fields             list of sub-components (Possible values: addresses, paymenthandles)
   * @param requestOptions     custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request.
   * @return Customer, if found
   * @throws PaysafeSdkException if an error occurs
   */
  Customer getCustomerByMerchantCustomerId(final String merchantCustomerId, final Set<String> fields,
      final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Update a Customer details.  <br>
   * <b>Note: </b> You must provide all the elements of the customer when you are updating it, including the elements that are not changing.
   * Elements that are part of an existing customer but that are not included in the update request will be set to null in the resulting customer.  <br> <br>
   * Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}</strong></p>
   * <p>
   *
   * @param customerId      the unique ID returned in the response to the Create a Customer request
   * @param customerRequest Customer's new details
   * @return the resulting Customer with updated data
   * @throws PaysafeSdkException if an error occurs
   */
  Customer updateCustomer(final String customerId, final CustomerRequest customerRequest) throws PaysafeSdkException;

  /**
   * Update a Customer details.  <br>
   * <b>Note: </b> You must provide all the elements of the customer when you are updating it, including the elements that are not changing.
   * Elements that are part of an existing customer but that are not included in the update request will be set to null in the resulting customer.  <br> <br>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout and/or automaticRetries),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}</strong></p>
   * <p>
   *
   * @param customerId      the unique ID returned in the response to the Create a Customer request
   * @param customerRequest Customer's new details
   * @param requestOptions  custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request.
   * @return the resulting Customer with updated data
   * @throws PaysafeSdkException if an error occurs
   */
  Customer updateCustomer(final String customerId, final CustomerRequest customerRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Delete an existing Customer by its unique ID. Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>DELETE /v1/customers/{customerId}</strong></p>
   * <p>
   *
   * @param customerId the unique ID returned in the response to the Create a Customer request
   * @throws PaysafeSdkException if an error occurs
   */
  void deleteCustomer(final String customerId) throws PaysafeSdkException;

  /**
   * Delete an existing Customer by its unique ID. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>DELETE /v1/customers/{customerId}</strong></p>
   * <p>
   *
   * @param customerId     the unique ID returned in the response to the Create a Customer request
   * @param requestOptions custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request.
   * @throws PaysafeSdkException if an error occurs
   */
  void deleteCustomer(final String customerId, final RequestOptions requestOptions) throws PaysafeSdkException;
}
