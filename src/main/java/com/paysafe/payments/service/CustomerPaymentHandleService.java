// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.CustomerPaymentHandle;
import com.paysafe.payments.model.customer.CustomerPaymentHandleRequest;

public interface CustomerPaymentHandleService {

  /**
   * <p>Create a Payment Handle For a Customer. Uses PaysafeClient configuration.</p>
   *
   * <p><b>Note:</b> Currently, only CARD, ACH, EFT, BACS and SEPA are supported as a paymentType parameter in Payments API.</p>
   * <p><b>Note:</b> For card processing, the paymentHandleToken returned in the response can be used for payment requests in the Payments API,
   * once it has the status of PAYABLE. To modify its status to PAYABLE, include this paymentHandleToken as the value for the
   * paymentHandleTokenFrom parameter in a request to create a regular Payment Handle.  <br>
   * That response in turn contains a paymentHandleToken with a status of PAYABLE, with the usage parameter set to SINGLE_USE.
   * Once you use this single-use paymentHandleToken in a successful payment request, then the status of the Customer paymentHandleToken
   * created here will change to PAYABLE.</p>
   * <p><b>Note: </b> Although the billingDetails parameter is optional, it is recommended that you include it when you create the customer
   * Payment Handle because a Payment request that uses the paymentHandleToken in the response will fail AVS checks unless there is a billing address
   * associated with it. If you do not include it when creating the customer Payment Handle, you should then update the Payment Handle with the
   * billingDetailsId before using it for transaction requests.</p>
   *
   * <p><b>Create a Multi-Use Payment Handle Using a Single-Use Payment Handle Token:</b></p>
   *
   * <p>This method can also be used to create a multi-use Payment Handle using a single-use Payment Handle Token.
   * to save a payment instrument that was created using a regular single-use Payment Handle Token to a customer.
   * The single-use Payment Handle Token must still be valid – i.e., the timeToLiveSeconds has not expired.</p>
   *
   * <p><b>Note: </b> Currently, single-use Payment Handle tokens that have CARD, ACH and EFT as the paymentType are supported.</p>
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/paymenthandles</strong></p>
   *
   * @param customerId                   id of a customer for whom to create a payment handle
   * @param customerPaymentHandleRequest containing data needed to create a payment handle for customer
   * @return CustomerPaymentHandle, if it was created successfully
   * @throws PaysafeSdkException if an error occurs
   */
  CustomerPaymentHandle createPaymentHandleForCustomer(final String customerId, final CustomerPaymentHandleRequest customerPaymentHandleRequest)
      throws PaysafeSdkException;

  /**
   * <p>Create a Payment Handle For a Customer. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.</p>
   *
   * <p><b>Note:</b> Currently, only CARD, ACH, EFT, BACS and SEPA are supported as a paymentType parameter in Payments API.</p>
   * <p><b>Note:</b> For card processing, the paymentHandleToken returned in the response can be used for payment requests in the Payments API,
   * once it has the status of PAYABLE. To modify its status to PAYABLE, include this paymentHandleToken as the value for the
   * paymentHandleTokenFrom parameter in a request to create a regular Payment Handle.  <br>
   * That response in turn contains a paymentHandleToken with a status of PAYABLE, with the usage parameter set to SINGLE_USE.
   * Once you use this single-use paymentHandleToken in a successful payment request, then the status of the Customer paymentHandleToken
   * created here will change to PAYABLE.</p>
   * <p><b>Note: </b> Although the billingDetails parameter is optional, it is recommended that you include it when you create the customer
   * Payment Handle because a Payment request that uses the paymentHandleToken in the response will fail AVS checks unless there is a billing address
   * associated with it. If you do not include it when creating the customer Payment Handle, you should then update the Payment Handle with the
   * billingDetailsId before using it for transaction requests.</p>
   *
   * <p><b>Create a Multi-Use Payment Handle Using a Single-Use Payment Handle Token:</b></p>
   *
   * <p>This method can also be used to create a multi-use Payment Handle using a single-use Payment Handle Token.
   * to save a payment instrument that was created using a regular single-use Payment Handle Token to a customer.
   * The single-use Payment Handle Token must still be valid – i.e., the timeToLiveSeconds has not expired.</p>
   *
   * <p><b>Note: </b> Currently, single-use Payment Handle tokens that have CARD, ACH and EFT as the paymentType are supported.</p>
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/paymenthandles</strong></p>
   *
   * @param customerId                   id of a customer for whom to create a payment handle
   * @param customerPaymentHandleRequest containing data needed to create a payment handle for customer
   * @param requestOptions               Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return CustomerPaymentHandle, if it was created successfully
   * @throws PaysafeSdkException if an error occurs
   */
  CustomerPaymentHandle createPaymentHandleForCustomer(final String customerId,
      final CustomerPaymentHandleRequest customerPaymentHandleRequest,
      final RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * <p>Gets a Customer Payment Handle using the customerId and paymenthandleId.
   * Uses PaysafeClient configuration.</p>
   *
   * <p><b>Note:</b> This method retrieves all details related to a previously created Payment Handle,
   * including its status, usage type, payment token, and associated billing information.</p>
   *
   * <p><b>Use Case:</b> You can use this method to check the status of a Payment Handle (e.g., PAYABLE, EXPIRED, etc.)
   * or retrieve the paymentHandleToken for further transaction requests. It's essential when managing saved cards
   * or reusing multi-use handles in customer-related flows.</p>
   *
   * <p>Endpoint:
   * <strong>GET /v1/customers/{customerId}/paymenthandles/{paymentHandleId}</strong></p>
   *
   * @param customerId      The unique identifier of the customer for whom the payment handle was created.
   *                        This ID is returned in the response when a customer is created.
   * @param paymentHandleId The unique identifier of the payment handle created for the customer.
   *                        This ID is returned in the response to the "Create Payment Handle for a Customer" request.
   * @return CustomerPaymentHandleDetails if the retrieval is successful
   * @throws PaysafeSdkException if an error occurs during the API call
   */
  CustomerPaymentHandle getCustomerPaymentHandleByPaymentHandleId(final String customerId, final String paymentHandleId) throws PaysafeSdkException;

  /**
   * <p>Gets a Customer Payment Handle using the customerId and paymenthandleId.
   * Uses custom request options (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.</p>
   *
   * <p><b>Note:</b> This method retrieves all details related to a previously created Payment Handle,
   * including its status, usage type, payment token, and associated billing information.</p>
   *
   * <p><b>Use Case:</b> You can use this method to check the status of a Payment Handle (e.g., PAYABLE, EXPIRED, etc.)
   * or retrieve the paymentHandleToken for further transaction requests. It's essential when managing saved cards
   * or reusing multi-use handles in customer-related flows.</p>
   *
   * <p>Endpoint:
   * <strong>GET /v1/customers/{customerId}/paymenthandles/{paymentHandleId}</strong></p>
   * <p>
   *
   * @param customerId      The unique identifier of the customer for whom the payment handle was created.
   *                        This ID is returned in the response when a customer is created.
   * @param paymentHandleId The unique identifier of the payment handle created for the customer.
   *                        This ID is returned in the response to the "Create Payment Handle for a Customer" request.
   * @param requestOptions  Custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request.
   * @return CustomerPaymentHandleDetails if the retrieval is successful
   * @throws PaysafeSdkException if an error occurs during the API call
   */
  CustomerPaymentHandle getCustomerPaymentHandleByPaymentHandleId(final String customerId, final String paymentHandleId, final RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * <p>Update a Customer Payment Handle using its ID and customer ID. Uses default PaysafeClient configuration.</p>
   *
   * <p><b>Note:</b> When updating a Payment Handle, you must provide all elements of the original handle,
   * including unchanged fields. Any omitted fields (except cardNum) will be set to null in the updated object.</p>
   *
   * @param customerId                   the customer ID
   * @param paymentHandleId              the ID of the payment handle to update
   * @param customerPaymentHandleRequest updated data for the payment handle
   * @return Updated CustomerPaymentHandle
   * @throws PaysafeSdkException if update fails
   */
  CustomerPaymentHandle updateCustomerPaymentHandle(final String customerId, final String paymentHandleId,
      final CustomerPaymentHandleRequest customerPaymentHandleRequest)
      throws PaysafeSdkException;

  /**
   * <p>Update a Customer Payment Handle using its ID and customer ID. The request will be executed using custom RequestOptions
   * (connectTimeout, readTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of default values from PaysafeClient.</p>
   *
   * <p><b>Note:</b> When updating a Payment Handle, you must provide all elements of the original handle,
   * including unchanged fields. Any omitted fields (except cardNum) will be set to null in the updated object.</p>
   *
   * @param customerId                   the customer ID
   * @param paymentHandleId              the ID of the payment handle to update
   * @param customerPaymentHandleRequest updated data for the payment handle
   * @param requestOptions               custom options for the request
   * @return Updated CustomerPaymentHandle
   * @throws PaysafeSdkException if update fails
   */
  CustomerPaymentHandle updateCustomerPaymentHandle(final String customerId, final String paymentHandleId,
      final CustomerPaymentHandleRequest customerPaymentHandleRequest,
      final RequestOptions requestOptions)
      throws PaysafeSdkException;

  /**
   * Delete an existing Customer Payment Handle by customer ID and payment handle ID.
   * Uses PaysafeClient configuration.
   *
   * <p>Endpoint:
   * <strong>DELETE /v1/customers/{customerId}/paymenthandles/{paymenthandleId}</strong></p>
   *
   * @param customerId      the unique ID returned in the response to the Create a Customer request
   * @param paymentHandleId the unique ID returned in the response to the Create a Payment Handle for a Customer request
   * @throws PaysafeSdkException if an error occurs
   */
  void deleteCustomerPaymentHandle(final String customerId, final String paymentHandleId) throws PaysafeSdkException;

  /**
   * Delete an existing Customer Payment Handle by customer ID and payment handle ID.
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout,
   * maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>DELETE /v1/customers/{customerId}/paymenthandles/{paymenthandleId}</strong></p>
   *
   * @param customerId      the unique ID returned in the response to the Create a Customer request
   * @param paymentHandleId the unique ID returned in the response to the Create a Payment Handle for a Customer request
   * @param requestOptions  custom connectTimeout, responseTimeout and/or maxAutomaticRetries for this request
   * @throws PaysafeSdkException if an error occurs
   */
  void deleteCustomerPaymentHandle(final String customerId, final String paymentHandleId,
      final RequestOptions requestOptions) throws PaysafeSdkException;
}
