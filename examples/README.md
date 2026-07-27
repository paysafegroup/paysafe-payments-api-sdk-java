# Paysafe Java SDK – Merchant Demo

A Spring Boot demo application showcasing the Paysafe Payments SDK.

## Features

- Card payments with 3DS authentication (frictionless and challenge)
- Manual settlement/void for card payments
- Redirect flow and automatic settlement for PaysafeCard, PaysafeCash, and PayPal
- Refunds (with customer account ID for PaysafeCard/PaysafeCash)
- Simple, readable code for easy integration reference

## Requirements

- Java 17 or newer
- Paysafe API credentials (test or live)
- If manually providing the SDK, ensure the JAR version in `libs/` matches the version referenced in your build configuration

## Setup

1. Place the correct Paysafe SDK JAR (e.g., `sdk-java-2.0.1.jar`) in `examples/libs/` (or update `build.gradle.kts` to use a Maven dependency).
2. You can run the app using our provided API credentials, or you can use your own credentials.   
To use your own API credentials, edit `src/main/resources/application.properties` with:

   ```
   paysafe.apiKey=YOUR_BASE64_API_KEY
   paysafe.accountId=YOUR_CARD_ACCOUNT_ID
   paysafe.environment=TEST

   # Optional: base URL for redirect/3DS return links (defaults to http://127.0.0.1:8080)
   # paysafe.returnUrlBase=http://localhost:8080
   ```

3. Run the application:

   ```
   ./gradlew :examples:bootRun
   ```

4. Open http://localhost:8080 in your browser.

## Usage

- Select a payment method (Card, PaysafeCard, PaysafeCash, PayPal) from the dropdown.
- Enter payment and billing details (see test cards below for Card payments).
- For PaysafeCard/PaysafeCash refunds, enter the user account ID or registered email as prompted.
- All transactions are shown in the Transactions section.

## What this demonstrates

| Feature                                                       | Payment Methods |
|---------------------------------------------------------------|---|
| 3DS authentication + manual settle/void                       | Card |
| Redirect flow + automatic settlement                          | PaysafeCard, PaysafeCash, PayPal |
| Refund (with customer email for PaysafeCard / PaysafeCash) | All settled transactions |

## Test cards

| Scenario | Card number |
|---|---|
| 3DS frictionless + success | 4000000000002719 |
| 3DS challenge + success | 4000000000002503 |
| 3DS rejected | 4000000000002537 |
| 3DS error | 4000000000002446 |

> **Never** hardcode production credentials in source code. Use environment variables or a secrets manager.

## Troubleshooting

- **Missing credentials**: Ensure your API key and account ID are set in `application.properties`.
- **Port conflicts**: Change the server port in `application.properties` if 8080 is in use.
- **SDK errors**: Check that the SDK JAR version matches your code and dependencies.
- **Payment method not available**: Make sure your Paysafe account is enabled for the selected method.

## Running Tests

To run the example tests:

```
./gradlew :examples:test
```

## Further reading

- [Paysafe Java SDK Documentation](https://developer.paysafe.com/en/api-docs/server-side-sdks-payments-api/java/)
- [Paysafe Payments API Reference](https://developer.paysafe.com/en/payments-api)

## License

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/paysafegroup/paysafe-payments-api-sdk-java/blob/main/LICENSE.txt)

