# Paysafe Java SDK

A Java SDK to simplify integration with the [Paysafe Payments API](https://developer.paysafe.com/en/payments-api/#/).  
Provides a convenient and type-safe wrapper for the REST endpoints offered by Paysafe.

Paysafe’s server-side SDKs streamline the integration process by significantly reducing the effort required to interact with Paysafe’s REST APIs.
The Java SDK is seamlessly integrated with managed package systems such as Gradle and Maven, facilitating effortless inclusion in development projects.

While incorporating the SDK into payment flows is not strictly necessary, doing so offers substantial benefits, including:

- **Comprehensive API Coverage**: The library encompasses the latest set of APIs, as documented in the Paysafe Developer Portal, ensuring compatibility with the most recent
  features and enhancements.
- **Auto-Generated Models and Request Structures**: The SDK provides pre-defined models and request parameter structures, mitigating the need for manual construction of API
  payloads and reducing the likelihood of errors.
- **Intelligent Request Handling**: The SDK includes built-in mechanisms for automatic request retries, improving resilience and reliability by mitigating transient failures and
  network-related issues.
- **Advanced Exception Management**: The SDK incorporates robust exception-handling mechanisms for API responses, simplifying error detection and recovery while ensuring seamless
  transaction processing

By leveraging the SDK, developers can expedite integration, enhance maintainability, and focus on core business logic rather than low-level API interactions.

---

## Before you begin

Contact your business relationship manager or send an email to [Integrations Support](mailto:integrations@paysafe.com) for your Business Portal credentials.

To obtain the Public API key from the Business Portal:

Log in to the Business Portal.
Go to Integrate > API Keys.

Your API key will have the following format:

- Key Username: `MerchantXYZ`
- Key Password:
  `B-tst1-0-51ed39e4-312d02345d3f123120881dff9bb4020a89e8ac44cdfdcecd702151182fdc952272661d290ab2e5849e31bb03deede7`

The API key is case-sensitive and sent using HTTP Basic Authentication with Base64 encoding.
API key credentials are sent using the Authorization header with every request.

Combine the Key Username and Key Password into a string separated by a colon, e.g., “Key Username:Key Password”.

For more information, see [Authentication](https://developer.paysafe.com/en/support/reference-information/authentication/).

---

## Installation

### Requirements

Java 11 or later.

### Maven

Add this dependency to your project's POM file:

    <dependency>
        <groupId>com.ph.paysafe</groupId>
        <artifactId>paysafe-java-sdk</artifactId>
        <version>1.0.0</version>
    </dependency>

### Gradle:

Add this dependency to your project's build file:

    implementation 'com.ph.paysafe:paysafe-java-sdk:1.0.0'

---

## Usage

### Instantiating new PaysafeClient instance

Instantiate new `PaysafeClient` instance using provided constructor or builder.

`PaysafeClient` provides services and methods to execute specific API requests.
Builders are provided for all classes representing API payloads.

You need to provide `apiKey` in format "username:password", for example:

    MerchantXYZ:B-tst1-0-51ed39e4-312d02345d3f123120881dff9bb4020a89e8ac44cdfdcecd702151182fdc952272661d290ab2e5849e31bb03deede7

Please keep your `apiKey` in safe location, for example load it from HashiCorp vault, Java Keystore, Kubernetes Secrets etc.

PaysafeClient can be configured for either **Live** or **Test** environment.

**Important: Do not use real card numbers or other payment instrument details in the Test environment.**
Test/ Sandbox is not compliant with Payment Card Industry Data Security Standards (PCI-DSS) and does not protect cardholder/ payee information. 
Any upload of real cardholder data is strictly prohibited, as described in the Terms of Use.

---

You can create a PaysafeClient instance using constructor:

    PaysafeClient paysafeClient = new PaysafeClient(apiKey, Environment.TEST);

Such `PaysafeClient` will use default client configuration (connect and response timeout, automatic retries).

### PaysafeClient customizations

`PaysafeClient` can also be instantiated using provided builder. This enables additional API client configurations:

    PaysafeClient paysafeClient = PaysafeClient.builder()
            .apiKey(yourApiKey)
            .environment(environement)
            .maxAutomaticRetries(customMaxRetries)    
            .connectTimeout(customConnectTimeout)     
            .responseTimeout(customResponseTimeout)   
            .sslContext(customSslContext)
            .proxy(customProxy)
            .build();

If some values are not provided in the builder call, default values from `PaysafeConfiguration` will be used.

#### Maximum automatic retries

The client can be configured to automatically retry `GET` requests which have failed due to network problems or
other unpredictable events. 
By default, such requests are retried twice (total three requests).
Maximum allowed value for automatic retries is **five**.

#### Connect and response timeouts

The client can be configured to use provided connect and response timeouts.
Values must be provided in milliseconds. We recommend setting the value cautiously, as some requests may take longer to process.

Default values are:
- 30 seconds for connect timeout
- 60 seconds for response timeout

#### Proxy

The client allows for custom proxies. Proxy object can be provided directly in builder:

    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("localhost", 8443));
    
    PaysafeClient paysafeClient = PaysafeClient.builder()
            .apiKey(yourApiKey)
            .environment(environement)
            .proxy(customProxy)
            .build();

Additionally, proxy can be automatically discerned from system properties:

    System.setProperty("http.proxyHost", "localhost");
    System.setProperty("http.proxyPort", "8443");
    System.setProperty("http.proxyUser", "squid");
    System.setProperty("http.proxyPassword", "ward");

Or: 

    System.setProperty("https.proxyHost", "localhost");
    System.setProperty("https.proxyPort", "8443");
    System.setProperty("https.proxyUser", "squid");
    System.setProperty("https.proxyPassword", "ward");

In both cases, you do not need to provide specific proxy object to the builder. `PaysafeClient` 
will automatically recognize and use system properties for proxy.

#### SSLContext

The client also allows for custom SslContext. For example, custom SSLContext can be created like this:
    
    X509ExtendedKeyManager keyManager = PemUtils.loadIdentityMaterial("certificate-chain.pem", "private-key.pem", "private-key-password".toCharArray());
    X509ExtendedTrustManager trustManager = PemUtils.loadTrustMaterial("some-trusted-certificate.pem");

    SSLFactory sslFactory = SSLFactory.builder()
            .withIdentityMaterial(keyManager)
            .withTrustMaterial(trustManager)
            .build();

    SSLContext sslContext = sslFactory.getSslContext();

This `sslContext` can be used in `PaysafeClient` builder:

    PaysafeClient paysafeClient = PaysafeClient.builder()
            .apiKey(yourApiKey)
            .environment(environement)
            .sslContext(sslContext)
            .build();

---

### Check the status of Payments API

To check the status of Payments API, you can call:

    paysafeClient.monitorService().verifyThatServiceIsAccessible();
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());

---

### Creating a payment handle

To create a payment handle for new transaction, first use the provided builder to create request body:

    PaymentHandleRequest paymentHandleRequest = PaymentHandleRequest.builder()
        .merchantRefNum(MERCHANT_REF_NUM)
        .transactionType(TransactionType.PAYMENT)
        .paymentType(PaymentType.CARD)
        .threeDs(ThreeDs.builder()
            .merchantUrl("https://api.qa.paysafe.com/checkout/v2/index.html#/desktop")
            .deviceChannel("BROWSER")
            .messageCategory("PAYMENT")
            .transactionIntent(TransactionIntent.CHECK_ACCEPTANCE)
            .authenticationPurpose(AuthenticationPurpose.PAYMENT_TRANSACTION)
            .build())
        .card(Card.builder()
            .cardNum("4000000000001026")
            .cardExpiry(CardExpiry.builder()
                .month(10)
                .year(2025)
                .build())
            .cvv("111")
            .issuingCountry("US")
            .build())
        .accountId("1009688230")
        .amount(500L)
        .currencyCode(CurrencyCode.USD)
        .billingDetails(BillingDetails.builder()
            .nickName("Home")
            .street("Street name")
            .city("City Name")
            .state("AL")
            .country("US")
            .zip("94404")
            .build())
        .returnLinks(List.of(ReturnLink.builder()
            .rel(ReturnLinkRel.DEFAULT)
            .href("https://usgaminggamblig.com/payment/return/")
            .method("GET")
            .build()))
        .build();

After which you can call the corresponding method:

    try {
        PaymentHandle paymentHandle = paysafeClient.paymentHandleService().createPaymentHandle(paymentHandleRequest);
    }
    catch (PaysafeSdkException e) {
        log.error(e);
    }

---

### Request customizations

Besides client level customizations, following values can also be customized at request level:

- `automaticRetries`
- `connectTimeout`
- `responseTimeout`
- `simulator` header - used only on `TEST` environment, for `POST`, `PUT`, `PATCH`, `DELETE` requests

To customize a request, simply provide `RequestOptions` object in method calls:

    RequestOptions requestOptions = RequestOptions.builder()
        .connectTimeout(90000)
        .simulator(PaymentSimulator.INTERNAL)
        .automaticRetries(3)
        .build();

    PaymentHandle paymentHandle = paymentHandleService.createPaymentHandle(paymentHandleRequest, requestOptions);

If some value is not provided (in this case, `responseTimeout`), value from `PaysafeClient` will be used.

---

### Error handling

Paysafe Java SDK automatically handles various error cases. All exceptions thrown by the `PaysafeClient` are subclasses of
[PaysafeSdkException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FPaysafeSdkException.java).
Specific HTTP response codes or situations are mapped to corresponding exceptions for clearer and more structured error handling:

- [ApiConnectionException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FApiConnectionException.java)
- [ApiException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FApiException.java)
- [IllegalArgumentException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FIllegalArgumentException.java)
- [InvalidCredentialsException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FInvalidCredentialsException.java)
- [InvalidRequestException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FInvalidRequestException.java)
- [RequestConflictException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FRequestConflictException.java)
- [RequestDeclinedException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FRequestDeclinedException.java)
- [UnauthorizedException.java](main%2Fjava%2Fcom%2Fpaysafe%2Fpayments%2Ferrorhandling%2Fexception%2FUnauthorizedException.java)

The following fields may be included in each exception, when available:

- `internalCorrelationId` - unique ID returned by Payments API, that can be provided to the Paysafe Support team as a reference for investigation
- `code` - HTTP status code returned by Payments API
- `error` - contains details about the error, returned from Payments API

---

### Overriding base url

**For testing purposes**, it is possible to override default URL for Payments API:

- LIVE environment: https://api.paysafe.com
- TEST environment: https://api.test.paysafe.com

Use the method `overrideBaseUrl(String url)` to point your `PaysafeClient` instance to local mock server.

---

### Using undocumented parameters

Paysafe Java SDK is strongly typed and designed to support all officially released API fields. 
However, the Payments API includes some undocumented or experimental properties, which are not part of the public API.

To use such parameters in classes representing API payloads (for example `PaymentHandleRequest`), 
we have provided field `additionalParameters` which can be added one-by-one or as a complete map:

    public Map<String, Object> getAdditionalParameters() {
      return additionalParameters;
    }
    
    public void setAdditionalParameters(Map<String, Object> additionalParameters) {
      this.additionalParameters = additionalParameters;
    }
    
    public void addAdditionalParameter(String key, Object value) {
      if (additionalParameters == null) {
        additionalParameters = new HashMap<>();
      }
      additionalParameters.put(key, value);
    }

Usage:

    paymentHandleRequest.addAdditionalParameter("booleanParameter", true);
    paymentHandleRequest.addAdditionalParameter("objectParameter",
        Address.builder()
            .city("London")
            .country("United Kingdom")
            .phone("+2139243")
            .build()
    );


---

## API Coverage

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

## License

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)