// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.config;

/**
 * Defines the environment in use. Possible values:
 * <ul>
 * <li> LIVE environment, located on <i>https://api.paysafe.com</i>
 * <li> TEST environment, located on <i>https://api.test.paysafe.com</i>
 * </ul>
 */
public enum Environment {

  /**
   * The live environment, located on <i>https://api.paysafe.com</i>.
   */
  LIVE,

  /**
   * The test environment, located on <i>https://api.test.paysafe.com</i>.
   */
  TEST
}
