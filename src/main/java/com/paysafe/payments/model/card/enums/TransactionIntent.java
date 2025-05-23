// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The transactionIntent property is used to identify the intent of the authorization requests.
 * The value of the transactionIntent shows if the transaction is crypto or quasi-cash related one. <br>
 * It is an optional enum field applicable for every MCC.  <br>
 * It is required only if the use cases explained below are applicable for the merchants
 * or the default behavior is not acceptable for them.  <br>
 *
 * The merchant needs to add in the request transactionIntent property value as shown in the example below. <br>
 *
 * Use cases and applicable valid enum transactionIntent options:
 * <table>
 *   <caption>Transaction intent mappings</caption>
 *   <tr>
 *     <th>Use case</th>
 *     <th>MCC</th>
 *     <th>Valid transactionIntent value</th>
 *   </tr>
 *   <tr>
 *     <td>The consumer is acquiring cryptocurrency in a transaction.</td>
 *     <td>6012, 6051</td>
 *     <td>CRYPTO_ON_RAMP</td>
 *   </tr>
 *   <tr>
 *     <td>The consumer is loading a cryptocurrency wallet or exchange account with fiat.
 *     *Applicable only in combination with valid fundingTransaction object.</td>
 *     <td>6012, 6051</td>
 *     <td>WALLET_CRYPTO_ON_RAMP</td>
 *   </tr>
 *   <tr>
 *     <td>The consumer is acquiring quasi-cash in a transaction. *Quasi cash transactions represent the purchase of foreign
 *     currencies or items (including, but not limited to, casino chips, money orders, lottery tickets and travelers cheques)
 *     which may be convertible to cash.</td>
 *     <td>4829, 6012, 6051</td>
 *     <td>QUASI_CASH</td>
 *   </tr>
 *   <tr>
 *     <td>For purchases of goods or services that leverage a live conversion of fiat into non - fiat currency.</td>
 *     <td>ANY</td>
 *     <td>BUY_WITH_CRYPTO</td>
 *   </tr>
 * </table>
 * <div>
 *   <b>Default transactionIntent definition by Paysafe:</b>
 *   <ul>
 *   <li>
 *     All authorizations processed by MCC 6051 will be classified as crypto related with transactionIntent "CRYPTO_ON_RAMP"
 *     or "WALLET_CRYPTO_ON_RAMP" (when funding a wallet), except their account is not configured by Paysafe for quasi-cash transactions.
 *   </li>
 *   <li>
 *     All authorizations processed by MCC 6051 will be classified as crypto related with transactionIntent "CRYPTO_ON_RAMP"
 *     or "WALLET_CRYPTO_ON_RAMP" (when funding a wallet), except their account is not configured by Paysafe for quasi-cash transactions.
 *     All authorizations processed by MCC 6051 or 4829 with quasi-cash configuration turned on will be classified as quasi-cash
 *     related with transactionIntent "QUASI_CASH" .
 *   </li>
 *   </ul>
 * </div>
 * <div>
 *   <b>Expected errors related to invalid transactionIntent values:</b>
 *   <ul>
 *   <li>
 *     If you send transactionIntent type in the authorization request with value not applicable for your MCC, the transaction will be
 *     declined with error 3072 - "Your request has been declined because the requested transactionIntent value is not applicable
 *     for your merchant category code (MCC)".
 *   </li>
 *   <li>
 *     If you send transactionIntent type WALLET_CRYPTO_ON_RAMP in the authorization request, but you didn't classify the transaction
 *     as "funding" one with the respective valid fundingTransaction object, the transaction will be declined with error 3071
 *     - Your request has been declined because of mismatch between the requested transactionIntent and fundingTransaction type.
 *    </li>
 *    </ul>
 * </div>
 */
public enum TransactionIntent {
  GOODS_OR_SERVICE_PURCHASE("GOODS_OR_SERVICE_PURCHASE"),

  CHECK_ACCEPTANCE("CHECK_ACCEPTANCE"),

  ACCOUNT_FUNDING("ACCOUNT_FUNDING"),

  QUASI_CASH_TRANSACTION("QUASI_CASH_TRANSACTION"),

  PREPAID_ACTIVATION("PREPAID_ACTIVATION");

  private final String value;

  TransactionIntent(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransactionIntent fromValue(String value) {
    for (TransactionIntent b : TransactionIntent.values()) {
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