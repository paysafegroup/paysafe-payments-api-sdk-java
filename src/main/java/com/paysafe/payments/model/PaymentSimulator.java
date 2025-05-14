// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model;

/**
 * Defines which Payment Simulator to use for processing test payment transactions.
 * You can choose whether you want to simulate the actual end customer experience or you want to use a page,
 * which lets you simulate all payment handle statuses. Possible values:
 * <ul>
 * <li>INTERNAL, which redirects to the status simulator page.</li>
 * <li>EXTERNAL (default), which redirects/connects to the downstream payment method website, i.e. Skrill authentication page</li>
 * </ul>
 */
public enum PaymentSimulator {

  EXTERNAL,
  INTERNAL
}
