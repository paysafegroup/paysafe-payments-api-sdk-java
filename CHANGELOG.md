# Change Log

## [2.0.1] - 2026-07-23

### Fixed

- Fixed direct request issue when payload is already serialized.

## [2.0.0] - 2026-06-25

### Changed

- Replaced deprecated Apache HttpClient API calls.
- Replaced deprecated ObjectMapper serialization configuration.

### Dependencies

- Updated dependencies:
  - Apache HttpClient: 5.6.2
  - Jackson: 2.22.2

### Added

- Support for Local Payment Methods (LPM): Skrill, PaysafeCash, PaysafeCard, Neteller, PayPal payment handles.
- Webhook handler utility for secure webhook event validation and parsing.
- Pluggable logging: use default JSON SLF4J logger or provide custom implementation via SdkLogger interface.
- New /examples module with runnable Spring Boot applications for all payment flows, including LPMs and webhooks.

### Changed

- **Breaking change:** Some model classes and enums might have a different package structure starting with v2.0.0. Please update your imports accordingly.
- Improved error handling for unsupported HTTP requests.

## [1.0.1] - 2026-05-05

### Fixed

- Corrected values in the `Authentication` enum.

### Dependencies

- Updated dependencies:
    - Jacoco: 0.8.15
    - Jackson: 2.21.2
    - JUnit: 5.14.3
    - WireMock: 3.13.2
    - SLF4J: 2.0.17
    - Apache HttpClient: 5.6

## [1.0.0] - 2025-05-28

_First release._

### API Coverage

Full API details are available in the Paysafe API Reference.

#### Transactions types and functionalities supported in the SDK:

- [Verify That The Service Is Accessible](https://developer.paysafe.com/en/payments-api/#/operations/verify-that-the-service-is-accessible)
- [Payment Methods](https://developer.paysafe.com/en/payments-api/#/operations/look-up-payment-methods)
- [Payment Handles](https://developer.paysafe.com/en/payments-api/#/operations/create-payment-handle)
- [Verifications](https://developer.paysafe.com/en/payments-api/#/operations/verification)
- [Payments](https://developer.paysafe.com/en/payments-api/#/operations/process-payment)
- [Void Authorizations](https://developer.paysafe.com/en/payments-api/#/operations/void-authorization)
- [Settlements](https://developer.paysafe.com/en/payments-api/#/operations/process-settlement)
- [Refunds](https://developer.paysafe.com/en/payments-api/#/operations/process-refund)
- [Standalone Credits](https://developer.paysafe.com/en/payments-api/#/operations/process-standalone-credit)
- [Original Credits](https://developer.paysafe.com/en/payments-api/#/operations/process-original-credit)
- [Customers](https://developer.paysafe.com/en/payments-api/#/operations/create-customer)
- [Customer Payment Handles](https://developer.paysafe.com/en/payments-api/#/operations/create-payment-handle-for-customer)
- [Customer Addresses](https://developer.paysafe.com/en/payments-api/#/operations/create-address)
- [Customer Single-Use Tokens](https://developer.paysafe.com/en/payments-api/#/operations/create-single-use-customer-token)

#### Not supported in current version of the SDK:

- [Mandate](https://developer.paysafe.com/en/payments-api/#/operations/create-mandate)
- [Sightline Registration](https://developer.paysafe.com/en/payments-api/#/operations/create-a-sightline-registration-call)
- [Vippreferred Registration](https://developer.paysafe.com/en/payments-api/#/operations/create-a-vippreferred-registration-call)
- [Paysafecash Store Locator](https://developer.paysafe.com/en/payments-api/#/operations/store-locator)
- [Get Balance](https://developer.paysafe.com/en/payments-api/#/operations/get-balance)
- [Get Bank](https://developer.paysafe.com/en/payments-api/#/operations/get-bank)

---