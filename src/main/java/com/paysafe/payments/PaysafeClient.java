// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments;

import static com.paysafe.payments.validation.PropertyValidator.validateApiKey;
import static com.paysafe.payments.validation.PropertyValidator.validateConnectTimeout;
import static com.paysafe.payments.validation.PropertyValidator.validateMaxAutomaticRetries;
import static com.paysafe.payments.validation.PropertyValidator.validateResponseTimeout;

import java.net.Proxy;

import javax.net.ssl.SSLContext;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.config.Environment;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;
import com.paysafe.payments.service.CustomerAddressService;
import com.paysafe.payments.service.CustomerPaymentHandleService;
import com.paysafe.payments.service.CustomerService;
import com.paysafe.payments.service.CustomerSingleUseTokenService;
import com.paysafe.payments.service.MonitorService;
import com.paysafe.payments.service.OriginalCreditService;
import com.paysafe.payments.service.PaymentHandleService;
import com.paysafe.payments.service.PaymentMethodsService;
import com.paysafe.payments.service.PaymentService;
import com.paysafe.payments.service.RefundService;
import com.paysafe.payments.service.SettlementService;
import com.paysafe.payments.service.StandaloneCreditService;
import com.paysafe.payments.service.VerificationService;
import com.paysafe.payments.service.VoidAuthorizationService;
import com.paysafe.payments.service.impl.CustomerAddressServiceImpl;
import com.paysafe.payments.service.impl.CustomerPaymentHandleServiceImpl;
import com.paysafe.payments.service.impl.CustomerServiceImpl;
import com.paysafe.payments.service.impl.CustomerSingleUseTokenServiceImpl;
import com.paysafe.payments.service.impl.MonitorServiceImpl;
import com.paysafe.payments.service.impl.OriginalCreditServiceImpl;
import com.paysafe.payments.service.impl.PaymentHandleServiceImpl;
import com.paysafe.payments.service.impl.PaymentMethodsServiceImpl;
import com.paysafe.payments.service.impl.PaymentServiceImpl;
import com.paysafe.payments.service.impl.RefundServiceImpl;
import com.paysafe.payments.service.impl.SettlementServiceImpl;
import com.paysafe.payments.service.impl.StandaloneCreditServiceImpl;
import com.paysafe.payments.service.impl.VerificationServiceImpl;
import com.paysafe.payments.service.impl.VoidAuthorizationServiceImpl;

/**
 * This is the primary class used to make requests against Paysafe's PaymentsAPI. It allows you to access all the methods
 * publicly provided by the API. It also allows to set various configuration such as client credentials, connection timeout etc.
 */
public class PaysafeClient {

  private PaysafeApiClient paysafeApiClient;

  private MonitorService monitorService;
  private PaymentMethodsService paymentMethodsService;
  private PaymentHandleService paymentHandleService;
  private PaymentService paymentService;
  private VerificationService verificationService;
  private VoidAuthorizationService voidAuthorizationService;
  private SettlementService settlementService;
  private RefundService refundService;
  private StandaloneCreditService standaloneCreditService;
  private OriginalCreditService originalCreditService;
  private CustomerService customerService;
  private CustomerAddressService customerAddressService;
  private CustomerPaymentHandleService customerPaymentHandleService;
  private CustomerSingleUseTokenService customerSingleUseTokenService;

  private PaysafeClient() {
  }

  /**
   * Constructs a PaysafeClient with provided credentials and environment, using default settings. Example:  <br>
   * {@code paysafeClient = new PaysafeClient("id:password", Environment.TEST)] }
   *
   * @param apiKey      private API key in format id:password
   * @param environment Paysafe environment against which API requests will be executed. Possible values: TEST, LIVE.
   * @throws IllegalArgumentException in case of invalid api key format
   */
  public PaysafeClient(String apiKey, Environment environment) throws IllegalArgumentException {
    validateApiKey(apiKey);
    paysafeApiClient = new PaysafeApiClient(apiKey, environment);
  }

  private PaysafeClient(Builder builder) throws IllegalArgumentException {
    paysafeApiClient = PaysafeApiClient.builder()
        .apiKey(builder.apiKey)
        .environment(builder.environment)
        .maxAutomaticRetries(builder.maxAutomaticRetries)
        .connectTimeout(builder.connectTimeout)
        .responseTimeout(builder.responseTimeout)
        .sslContext(builder.sslContext)
        .proxy(builder.proxy)
        .build();
  }

  public static Builder builder() {
    return new Builder();
  }

  public MonitorService monitorService() {
    if (monitorService == null) {
      monitorService = new MonitorServiceImpl(paysafeApiClient);
    }
    return monitorService;
  }

  public PaymentMethodsService lookUpPaymentMethodsService() {
    if (paymentMethodsService == null) {
      paymentMethodsService = new PaymentMethodsServiceImpl(paysafeApiClient);
    }
    return paymentMethodsService;
  }

  public PaymentHandleService paymentHandleService() {
    if (paymentHandleService == null) {
      paymentHandleService = new PaymentHandleServiceImpl(paysafeApiClient);
    }
    return paymentHandleService;
  }

  public VerificationService verificationService() {
    if (verificationService == null) {
      verificationService = new VerificationServiceImpl(paysafeApiClient);
    }

    return verificationService;
  }

  public PaymentService paymentService() {
    if (paymentService == null) {
      paymentService = new PaymentServiceImpl(paysafeApiClient) {
      };
    }
    return paymentService;
  }

  public VoidAuthorizationService voidAuthorizationService() {
    if (voidAuthorizationService == null) {
      voidAuthorizationService = new VoidAuthorizationServiceImpl(paysafeApiClient);
    }
    return voidAuthorizationService;
  }

  public SettlementService settlementService() {
    if (settlementService == null) {
      settlementService = new SettlementServiceImpl(paysafeApiClient);
    }
    return settlementService;
  }

  public RefundService refundService() {
    if (refundService == null) {
      refundService = new RefundServiceImpl(paysafeApiClient);
    }
    return refundService;
  }

  public StandaloneCreditService standaloneCreditService() {
    if (standaloneCreditService == null) {
      standaloneCreditService = new StandaloneCreditServiceImpl(paysafeApiClient);
    }
    return standaloneCreditService;
  }

  public OriginalCreditService originalCreditService() {
    if (originalCreditService == null) {
      originalCreditService = new OriginalCreditServiceImpl(paysafeApiClient);
    }

    return originalCreditService;
  }

  public CustomerService customerService() {
    if (customerService == null) {
      customerService = new CustomerServiceImpl(paysafeApiClient);
    }
    return customerService;
  }

  public CustomerAddressService customerAddressService() {
    if (customerAddressService == null) {
      customerAddressService = new CustomerAddressServiceImpl(paysafeApiClient);
    }
    return customerAddressService;
  }

  public CustomerPaymentHandleService customerPaymentHandleService() {
    if (customerPaymentHandleService == null) {
      customerPaymentHandleService = new CustomerPaymentHandleServiceImpl(paysafeApiClient);
    }
    return customerPaymentHandleService;
  }

  public CustomerSingleUseTokenService customerSingleUseTokenService() {
    if (customerSingleUseTokenService == null) {
      customerSingleUseTokenService = new CustomerSingleUseTokenServiceImpl(paysafeApiClient);
    }
    return customerSingleUseTokenService;
  }

  /**
   * <b>Use only for testing.</b> Overrides the base url for Paysafe Payments API endpoints with provided value, i.e. of your mocked server.
   */
  public void overrideBaseUrl(final String baseUrl) {
    this.paysafeApiClient.overrideBaseUrl(baseUrl);
  }

  /**
   * {@code PaysafeClient} builder static inner class.
   */
  public static final class Builder {
    private String apiKey;
    private Environment environment;
    private Integer connectTimeout;
    private Integer responseTimeout;
    private Integer maxAutomaticRetries;
    private SSLContext sslContext;
    private Proxy proxy;

    private Builder() {
    }

    /**
     * Sets the {@code apiKey} and returns a reference to this Builder enabling method chaining.
     *
     * @param apiKey merchant credentials in form clientId:clientPassword
     * @return a reference to this Builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Sets the {@code environment} and returns a reference to this Builder enabling method chaining.
     *
     * @param environment either the test or production environment
     * @return a reference to this Builder
     * @see Environment
     */
    public Builder environment(Environment environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Sets the timeout value, in milliseconds, that will be used for establishing new connections to the Payments API.
     * Method returns a reference to this Builder enabling method chaining.
     *
     * @param connectTimeout the {@code connectTimeout} to set
     * @return a reference to this Builder
     */
    public Builder connectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    /**
     * Sets the time limit, in milliseconds, for retrieving the response from existing connection.
     * We recommend setting the value cautiously, as some requests may take longer to process.
     * Method returns a reference to this Builder enabling method chaining.
     *
     * @param responseTimeout the {@code connectTimeout} to set
     * @return a reference to this Builder
     */
    public Builder responseTimeout(int responseTimeout) {
      this.responseTimeout = responseTimeout;
      return this;
    }

    /**
     * Sets the maximum number of automatic retries for requests. Only GET requests that encountered IOException
     * while connecting to Paysafe Payments API will be retried automatically. Maximum allowed automatic retries: 5  <br>
     * The method returns a reference to this Builder enabling method chaining.
     *
     * @param maxAutomaticRetries the {@code maxAutomaticRetries} to set
     * @return a reference to this Builder
     */
    public Builder maxAutomaticRetries(int maxAutomaticRetries) {
      this.maxAutomaticRetries = maxAutomaticRetries;
      return this;
    }

    /**
     * Sets the {@code sslContext} and returns a reference to this Builder enabling method chaining.
     *
     * @param sslContext the {@code sslContext} to set
     * @return a reference to this Builder
     */
    public Builder sslContext(SSLContext sslContext) {
      this.sslContext = sslContext;
      return this;
    }

    /**
     * Sets the {@code proxy} and returns a reference to this Builder enabling method chaining.
     *
     * @param proxy the {@code proxy} to set
     * @return a reference to this Builder
     */
    public Builder proxy(Proxy proxy) {
      this.proxy = proxy;
      return this;
    }

    /**
     * Returns a {@code PaysafeClient} built from the parameters previously set. Performs following validations:
     * <ul>
     * <li>api key format validation</li>
     * <li>max automatic retries validation</li>
     * <li>connect and response timeout validations</li>
     * </ul>
     *
     * @return a {@code PaysafeClient} built with parameters of this {@code PaysafeClient.Builder}
     * @throws IllegalArgumentException if any of provided arguments was invalid
     */
    public PaysafeClient build() throws IllegalArgumentException {
      validateApiKey(apiKey);
      validateMaxAutomaticRetries(maxAutomaticRetries);
      validateConnectTimeout(connectTimeout);
      validateResponseTimeout(responseTimeout);
      return new PaysafeClient(this);
    }
  }
}