// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.api;

import static com.paysafe.payments.config.ObjectMapperConfiguration.getObjectMapper;
import static com.paysafe.payments.errorhandling.ExceptionBuilder.buildPaysafeSdkException;
import static com.paysafe.payments.validation.PropertyValidator.validateApiKey;
import static com.paysafe.payments.validation.PropertyValidator.validateConnectTimeout;
import static com.paysafe.payments.validation.PropertyValidator.validateMaxAutomaticRetries;
import static com.paysafe.payments.validation.PropertyValidator.validateResponseTimeout;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.client5.http.ssl.TlsSocketStrategy;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;
import org.apache.hc.core5.util.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paysafe.payments.config.Environment;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;

public class PaysafeApiClient {

  // request headers
  public static final String AUTHORIZATION = "Authorization";
  public static final String CONTENT_TYPE = "Content-Type";
  public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
  public static final String X_TRANSACTION_SOURCE = "x-transaction-source";
  public static final String JAVA_SDK = "JavaSDK";
  public static final String USER_AGENT = "User-Agent";
  public static final String SIMULATOR = "Simulator";

  // system properties for proxy
  public static final String HTTP_PROXY_HOST = "http.proxyHost";
  public static final String HTTP_PROXY_PORT = "http.proxyPort";
  public static final String HTTPS_PROXY_HOST = "https.proxyHost";
  public static final String HTTPS_PROXY_PORT = "https.proxyPort";

  // system properties for building User-Agent header
  public static final String OS_NAME = "os.name";
  public static final String OS_VERSION = "os.version";
  public static final String OS_ARCH = "os.arch";
  public static final String JAVA_VERSION = "java.version";
  public static final String JAVA_VENDOR = "java.vendor";
  public static final String JAVA_VM_VERSION = "java.vm.version";
  public static final String JAVA_VM_VENDOR = "java.vm.vendor";

  private static final Logger logger = LoggerFactory.getLogger(PaysafeApiClient.class);

  // uri parameters
  private static final String PATH = "/paymenthub";
  private static final String URI_FORMAT = "%s%s%s";
  private static final String MERCHANT_REF_NUMBER_PARAM = "merchantRefNum";
  private static final String START_DATE_PARAM = "startDate";
  private static final String END_DATE_PARAM = "endDate";
  private static final String LIMIT_PARAM = "limit";
  private static final String OFFSET_PARAM = "offset";
  private static final String MERCHANT_CUSTOMER_ID_PARAM = "merchantCustomerId";
  private static final String FIELDS_PARAM = "fields";
  private static final String CONNECTION_ERROR_MESSAGE = "Error connecting to %s, reason: %s";

  // default PaysafeApiClient configuration
  private static final int DEFAULT_CONNECT_TIMEOUT = 30 * 1000;
  private static final int DEFAULT_RESPONSE_TIMEOUT = 60 * 1000;
  private static final int DEFAULT_MAX_AUTOMATIC_RETRIES = 2;

  // environments
  private static final String BASE_URL_LIVE = "https://api.paysafe.com";
  private static final String BASE_URL_TEST = "https://api.test.paysafe.com";

  // configuration of this PaysafeApiClient instance
  private final String apiKey;
  private final int clientConnectTimeout;
  private final int clientResponseTimeout;
  private final int clientMaxAutomaticRetries;
  private final SSLContext customSslContext;
  private final Proxy providedProxy;
  private final Environment environment;

  private String baseUrl;

  /**
   * Instantiates new PaysafeApiClient object, using provided api key and environment.
   * Creates new default instances of httpClient.
   *
   * @param apiKey      merchant's credentials in form id:password
   * @param environment to which PaysafeClient connects ("LIVE" or "TEST")
   * @throws IllegalArgumentException in case of invalid api key format
   */
  public PaysafeApiClient(final String apiKey, final Environment environment) throws IllegalArgumentException {
    validateApiKey(apiKey);
    this.apiKey = apiKey;
    this.clientConnectTimeout = DEFAULT_CONNECT_TIMEOUT;
    this.clientResponseTimeout = DEFAULT_RESPONSE_TIMEOUT;
    this.clientMaxAutomaticRetries = DEFAULT_MAX_AUTOMATIC_RETRIES;
    this.customSslContext = null;
    this.providedProxy = null;
    this.environment = environment;

    if (Environment.LIVE.equals(environment)) {
      baseUrl = BASE_URL_LIVE;
    } else {
      baseUrl = BASE_URL_TEST;
    }
  }

  private PaysafeApiClient(Builder builder) {
    apiKey = builder.apiKey;
    clientConnectTimeout = builder.connectTimeout == null ? DEFAULT_CONNECT_TIMEOUT : builder.connectTimeout;
    clientResponseTimeout = builder.responseTimeout == null ? DEFAULT_RESPONSE_TIMEOUT : builder.responseTimeout;
    clientMaxAutomaticRetries = builder.maxAutomaticRetries == null ? DEFAULT_MAX_AUTOMATIC_RETRIES : builder.maxAutomaticRetries;
    customSslContext = builder.sslContext;
    providedProxy = builder.proxy;
    environment = builder.environment == null ? Environment.TEST : builder.environment;

    if (Environment.LIVE.equals(builder.environment)) {
      baseUrl = BASE_URL_LIVE;
    } else {
      baseUrl = BASE_URL_TEST;
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static String getBasicAuthenticationHeader(final String apiKey) {
    return "Basic " + Base64.getEncoder().encodeToString(apiKey.getBytes());
  }

  /**
   * Helper method for building json request body for POST requests.
   *
   * @param requestBody to write as json
   * @return json string representing requestBody
   * @throws PaysafeSdkException in case of JsonProcessingException, not expected to happen
   */
  public static <T> String buildJsonRequestBody(final T requestBody) throws PaysafeSdkException {
    try {
      return getObjectMapper().writeValueAsString(requestBody);
    } catch (JsonProcessingException e) {
      logger.error("Exception while creating json request body: {}", e.getMessage(), e);
      throw new PaysafeSdkException("Error creating json request body");
    }
  }

  /**
   * Generic method for processing http response - mapping from json response to corresponding Java class.
   *
   * @param response   which to process
   * @param returnType which to return, i.e. PaymentHandle.class
   * @return T
   * @throws PaysafeSdkException containing error details, correlation id and http status code, if present
   */
  public static <R> R processResponse(final PaysafeApiResponse response, final Class<R> returnType)
      throws PaysafeSdkException {

    try {
      if (requestSuccessful(response)) {
        return getObjectMapper().readValue(response.getResponseBody(), returnType);
      } else {
        throw buildPaysafeSdkException("Paysafe Payments API request unsuccessful", response, returnType);
      }
    } catch (JsonProcessingException e) {
      logger.error("Exception while processing response from PaymentsAPI: {}", e.getMessage(), e);
      throw buildPaysafeSdkException(String.format("Error processing json response: %s", e.getMessage()), response, returnType);
    }
  }

  /**
   * Method for processing http response for DELETE requests
   *
   * @param response which to process
   * @throws PaysafeSdkException containing error details, correlation id and http status code, if present
   */
  public static void processDeleteResponse(final PaysafeApiResponse response) throws PaysafeSdkException {
    if (!requestSuccessful(response)) {
      throw buildPaysafeSdkException("Paysafe Payments API request unsuccessful", response, null);
    }
  }

  private static boolean requestSuccessful(final PaysafeApiResponse response) {
    return response.getHttpStatusCode() == 200 || response.getHttpStatusCode() == 201;
  }

  /**
   * Helper method for building query parameters for all endpoints which are using Merchant Reference Number,
   * Customer ID or Merchant Customer ID:
   * <ul>
   *   <li>Get Payment Handle Using Merchant Reference Number</li>
   *   <li>Get Verification Using Merchant Reference Number</li>
   *   <li>Get Payments Using Merchant Reference Number</li>
   *   <li>Get Void Authorization Using Merchant Reference Number</li>
   *   <li>Get Settlements Using Merchant Reference Number</li>
   *   <li>Get Refunds Using Merchant Reference Number</li>
   *   <li>Get Standalone Credits Using Merchant Reference Number</li>
   *   <li>Get Original Credits Using Merchant Reference Number</li>
   *   <li>Get Customers Using Customer ID or Merchant Customer ID</li>
   * </ul>
   *
   * @param merchantRefNum     the merchant reference number created by the merchant
   * @param endDate            the end date in UTC, default = current date and time
   * @param limit              the total number of records to return
   * @param offset             the starting position, where 0 is the first record
   * @param startDate          the start date in UTC, default = 30 days before the endDate
   * @param merchantCustomerId customer ID that the merchant provided for their own internal customer identification
   * @param fields             comma-separated list of sub-components
   * @return formatted query string containing non-null parameters
   */
  public static String buildQueryParameters(final String merchantRefNum, final String endDate, final Integer limit,
      final Integer offset, final String startDate, final String merchantCustomerId, final String fields) {

    Map<String, String> queryParams = new LinkedHashMap<>();

    Optional.ofNullable(merchantRefNum).ifPresent(value -> queryParams.put(MERCHANT_REF_NUMBER_PARAM, value));
    Optional.ofNullable(endDate).ifPresent(value -> queryParams.put(END_DATE_PARAM, value));
    Optional.ofNullable(limit).ifPresent(value -> queryParams.put(LIMIT_PARAM, value.toString()));
    Optional.ofNullable(offset).ifPresent(value -> queryParams.put(OFFSET_PARAM, value.toString()));
    Optional.ofNullable(startDate).ifPresent(value -> queryParams.put(START_DATE_PARAM, value));
    Optional.ofNullable(merchantCustomerId).ifPresent(value -> queryParams.put(MERCHANT_CUSTOMER_ID_PARAM, value));
    Optional.ofNullable(fields).ifPresent(value -> queryParams.put(FIELDS_PARAM, value));

    return queryParams.entrySet().stream()
        .map(entry -> entry.getKey() + "=" + entry.getValue())
        .collect(Collectors.joining("&", "?", ""));
  }

  private static DefaultProxyRoutePlanner buildProxyRoutePlanner(final Proxy proxyToUse) {
    InetSocketAddress proxyAddress = (InetSocketAddress) proxyToUse.address();

    HttpHost proxyHost = new HttpHost(proxyAddress.getHostName(), proxyAddress.getPort());
    return new DefaultProxyRoutePlanner(proxyHost);
  }

  private CloseableHttpClient buildHttpClient(final RequestOptions requestOptions) throws IllegalArgumentException {

    validateRequestOptions(requestOptions);

    RequestOptions optionsToUse = buildRequestOptionsToUse(requestOptions);
    PoolingHttpClientConnectionManager connectionManager = buildConnectionManager(optionsToUse);
    Proxy proxyToUse = attemptToBuildProxy();

    // build httpClient with proxy
    if (proxyToUse != null && proxyToUse.address() instanceof InetSocketAddress) {
      DefaultProxyRoutePlanner routePlanner = buildProxyRoutePlanner(proxyToUse);

      return HttpClients.custom()
          .setConnectionManager(connectionManager)
          .setDefaultRequestConfig(RequestConfig.custom()
              .setResponseTimeout(Timeout.ofMilliseconds(optionsToUse.getResponseTimeout()))
              .build())
          .setRetryStrategy(new AutomaticRetryStrategy(optionsToUse.getMaxAutomaticRetries()))
          .setRoutePlanner(routePlanner)
          .build();
    }

    // or return httpClient without proxy
    return HttpClients.custom()
        .setConnectionManager(connectionManager)
        .setDefaultRequestConfig(RequestConfig.custom()
            .setResponseTimeout(Timeout.ofMilliseconds(optionsToUse.getResponseTimeout()))
            .build())
        .setRetryStrategy(new AutomaticRetryStrategy(optionsToUse.getMaxAutomaticRetries()))
        .build();
  }

  private void validateRequestOptions(final RequestOptions requestOptions) throws IllegalArgumentException {
    if (requestOptions == null) {
      return;
    }
    validateMaxAutomaticRetries(requestOptions.getMaxAutomaticRetries());
    validateConnectTimeout(requestOptions.getConnectTimeout());
    validateResponseTimeout(requestOptions.getResponseTimeout());
  }

  private Proxy attemptToBuildProxy() {
    Proxy proxyToUse = providedProxy;
    // if no proxy was provided, check system properties for proxy configuration
    if (providedProxy == null) {
      String httpProxyHost = System.getProperty(HTTP_PROXY_HOST);
      String httpProxyPort = System.getProperty(HTTP_PROXY_PORT);
      if (httpProxyHost != null && httpProxyPort != null) {
        proxyToUse = new Proxy(Type.HTTP, new InetSocketAddress(httpProxyHost, Integer.parseInt(httpProxyPort)));
      } else {
        String httpsProxyHost = System.getProperty(HTTPS_PROXY_HOST);
        String httpsProxyPort = System.getProperty(HTTPS_PROXY_PORT);
        if (httpsProxyHost != null && httpsProxyPort != null) {
          proxyToUse = new Proxy(Type.HTTP, new InetSocketAddress(httpsProxyHost, Integer.parseInt(httpsProxyPort)));
        }
      }
    }
    return proxyToUse;
  }

  private RequestOptions buildRequestOptionsToUse(final RequestOptions requestOptions) {
    RequestOptions optionsToUse = new RequestOptions();
    if (requestOptions != null) {
      optionsToUse.setConnectTimeout(requestOptions.getConnectTimeout() == null ? clientConnectTimeout : requestOptions.getConnectTimeout());
      optionsToUse.setResponseTimeout(requestOptions.getResponseTimeout() == null ? clientResponseTimeout : requestOptions.getResponseTimeout());
      optionsToUse.setMaxAutomaticRetries(requestOptions.getMaxAutomaticRetries() == null ? clientMaxAutomaticRetries
          : requestOptions.getMaxAutomaticRetries());
    } else {
      optionsToUse.setConnectTimeout(clientConnectTimeout);
      optionsToUse.setResponseTimeout(clientResponseTimeout);
      optionsToUse.setMaxAutomaticRetries(clientMaxAutomaticRetries);
    }
    return optionsToUse;
  }

  private PoolingHttpClientConnectionManager buildConnectionManager(final RequestOptions optionsToUse) {
    PoolingHttpClientConnectionManager connectionManager;
    if (customSslContext != null) {
      connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
          .setDefaultConnectionConfig(ConnectionConfig.custom()
              .setConnectTimeout(Timeout.ofMilliseconds(optionsToUse.getConnectTimeout()))
              .build())
          .setTlsSocketStrategy((TlsSocketStrategy) ClientTlsStrategyBuilder.create()
              .setSslContext(customSslContext)
              .build())
          .build();
    } else {
      connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
          .setDefaultConnectionConfig(ConnectionConfig.custom()
              .setConnectTimeout(Timeout.ofMilliseconds(optionsToUse.getConnectTimeout()))
              .build())
          .build();
    }
    return connectionManager;
  }

  /**
   * <b>Use only for testing.</b> Overrides the base url for Paysafe Payments API endpoints
   * with provided value, i.e. of your mocked server.
   */
  public void overrideBaseUrl(final String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public PaysafeApiResponse executeGet(final String endpoint, final RequestOptions requestOptions) throws PaysafeSdkException {
    URI uri = buildRequestUri(endpoint);
    final HttpGet httpGet = new HttpGet(uri);
    setRequestHeaders(httpGet);

    try (CloseableHttpClient httpClient = buildHttpClient(requestOptions)) {
      return httpClient.execute(httpGet, this::handleApiResponse);
    } catch (IOException e) {
      logger.error("Exception while executing GET request at {}: {}", httpGet.getRequestUri(), e.getMessage(), e);
      throw new ApiConnectionException(String.format(CONNECTION_ERROR_MESSAGE, uri, e.getMessage()));
    }
  }

  public <T> PaysafeApiResponse executePost(final String endpoint, final T requestBody, final RequestOptions requestOptions) throws PaysafeSdkException {
    URI uri = buildRequestUri(endpoint);
    final HttpPost httpPost = new HttpPost(uri);
    setRequestHeaders(httpPost);

    if (Environment.TEST.equals(environment) && (requestOptions != null && requestOptions.getSimulator() != null)) {
      httpPost.setHeader(SIMULATOR, requestOptions.getSimulator());
    }

    String jsonRequestBody = buildJsonRequestBody(requestBody);
    StringEntity requestEntity = new StringEntity(jsonRequestBody, ContentType.APPLICATION_JSON);
    httpPost.setEntity(requestEntity);

    try (CloseableHttpClient httpClient = buildHttpClient(requestOptions)) {
      return httpClient.execute(httpPost, this::handleApiResponse);
    } catch (IOException e) {
      logger.error("Exception while executing POST request at {}: {}", httpPost.getRequestUri(), e.getMessage(), e);
      throw new ApiConnectionException(String.format(CONNECTION_ERROR_MESSAGE, uri, e.getMessage()));
    }
  }

  public <T> PaysafeApiResponse executePut(final String endpoint, final T requestBody, final RequestOptions requestOptions) throws PaysafeSdkException {
    URI uri = buildRequestUri(endpoint);
    final HttpPut httpPut = new HttpPut(uri);
    setRequestHeaders(httpPut);

    if (Environment.TEST.equals(environment) && (requestOptions != null && requestOptions.getSimulator() != null)) {
      httpPut.setHeader(SIMULATOR, requestOptions.getSimulator());
    }

    String jsonRequestBody = buildJsonRequestBody(requestBody);
    StringEntity requestEntity = new StringEntity(jsonRequestBody, ContentType.APPLICATION_JSON);
    httpPut.setEntity(requestEntity);

    try (CloseableHttpClient httpClient = buildHttpClient(requestOptions)) {
      return httpClient.execute(httpPut, this::handleApiResponse);
    } catch (IOException e) {
      logger.error("Exception while executing PUT request at {}: {}", httpPut.getRequestUri(), e.getMessage(), e);
      throw new ApiConnectionException(String.format(CONNECTION_ERROR_MESSAGE, uri, e.getMessage()));
    }
  }

  public <T> PaysafeApiResponse executePatch(final String endpoint, final T requestBody, final RequestOptions requestOptions) throws PaysafeSdkException {
    URI uri = buildRequestUri(endpoint);
    final HttpPatch httpPatch = new HttpPatch(uri);
    setRequestHeaders(httpPatch);

    if (Environment.TEST.equals(environment) && (requestOptions != null && requestOptions.getSimulator() != null)) {
      httpPatch.setHeader(SIMULATOR, requestOptions.getSimulator());
    }

    String jsonRequestBody = buildJsonRequestBody(requestBody);
    StringEntity requestEntity = new StringEntity(jsonRequestBody, ContentType.APPLICATION_JSON);
    httpPatch.setEntity(requestEntity);

    try (CloseableHttpClient httpClient = buildHttpClient(requestOptions)) {
      return httpClient.execute(httpPatch, this::handleApiResponse);
    } catch (IOException e) {
      logger.error("Exception while executing PATCH request at {}: {}", httpPatch.getRequestUri(), e.getMessage(), e);
      throw new ApiConnectionException(String.format(CONNECTION_ERROR_MESSAGE, uri, e.getMessage()));
    }
  }

  public PaysafeApiResponse executeDelete(final String endpoint, final RequestOptions requestOptions) throws PaysafeSdkException {
    URI uri = buildRequestUri(endpoint);
    final HttpDelete httpDelete = new HttpDelete(uri);
    setRequestHeaders(httpDelete);

    if (Environment.TEST.equals(environment) && (requestOptions != null && requestOptions.getSimulator() != null)) {
      httpDelete.setHeader(SIMULATOR, requestOptions.getSimulator());
    }

    try (CloseableHttpClient httpClient = buildHttpClient(requestOptions)) {
      return httpClient.execute(httpDelete, this::handleApiResponse);
    } catch (IOException e) {
      logger.error("Exception while executing DELETE request at {}: {}", httpDelete.getRequestUri(), e.getMessage(), e);
      throw new ApiConnectionException(String.format(CONNECTION_ERROR_MESSAGE, uri, e.getMessage()));
    }
  }

  private URI buildRequestUri(final String endpoint) {
    return URI.create(String.format(URI_FORMAT, this.baseUrl, PATH, endpoint));
  }

  private void setRequestHeaders(final BasicClassicHttpRequest httpRequest) {
    httpRequest.setHeader(AUTHORIZATION, getBasicAuthenticationHeader(apiKey));
    httpRequest.setHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
    httpRequest.setHeader(X_TRANSACTION_SOURCE, JAVA_SDK);
    httpRequest.setHeader(USER_AGENT, buildUserAgentHeader());
  }

  private String buildUserAgentHeader() {

    String sdkVersion = "unknown";
    try (InputStream inputStream = PaysafeApiClient.class.getResourceAsStream("/VERSION")) {
      if (inputStream != null) {
        sdkVersion = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8).trim();
      }
    } catch (IOException e) {
      logger.error("IOException while parsing sdk version from VERSION file", e);
    }

    String osDetails = System.getProperty(OS_NAME) + "; "
        + System.getProperty(OS_VERSION) + "; "
        + System.getProperty(OS_ARCH);

    String javaDetails = System.getProperty(JAVA_VERSION) + "; "
        + System.getProperty(JAVA_VENDOR) + "; "
        + System.getProperty(JAVA_VM_VERSION) + "; "
        + System.getProperty(JAVA_VM_VENDOR);

    return String.format("PaymentsAPI JAVASDK/%s (%s) JAVA (%s)", sdkVersion, osDetails, javaDetails);
  }

  private PaysafeApiResponse handleApiResponse(final ClassicHttpResponse response) throws IOException, ParseException {
    PaysafeApiResponse paysafeApiResponse = new PaysafeApiResponse();
    paysafeApiResponse.setHttpStatusCode(response.getCode());

    Map<String, String> headers = new HashMap<>();
    for (Header header : response.getHeaders()) {
      headers.put(header.getName().toUpperCase(), header.getValue());
    }
    paysafeApiResponse.setHeaders(headers);

    HttpEntity entity = response.getEntity();
    if (entity != null) {
      paysafeApiResponse.setResponseBody(EntityUtils.toString(entity));
    }
    return paysafeApiResponse;
  }

  /**
   * {@code PaysafeApiClient} builder static inner class.
   */
  public static final class Builder {

    private String apiKey;
    private Environment environment;
    private Integer connectTimeout;
    private Integer responseTimeout;
    private Integer maxAutomaticRetries;
    private SSLContext sslContext;
    private Proxy proxy;

    /**
     * Sets the {@code apiKey} and returns a reference to this Builder enabling method chaining.
     *
     * @param apiKey the {@code apiKey} to set
     * @return a reference to this Builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder environment(Environment environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Sets the time limit, in miliseconds, for both connecting to the Paysafe Payments API and retrieving the data
     * from this connection. We recommend setting the value cautiously, as some requests may take longer to process.
     * Method returns a reference to this Builder enabling method chaining.
     *
     * @param responseTimeout the {@code responseTimeout} to set
     * @return a reference to this Builder
     */
    public Builder responseTimeout(Integer responseTimeout) {
      this.responseTimeout = responseTimeout;
      return this;
    }

    /**
     * Sets the timeout value, in miliseconds, that will be used for establishing new connections to the Payments API.
     * Method returns a reference to this Builder enabling method chaining.
     *
     * @param connectTimeout the {@code connectTimeout} to set
     * @return a reference to this Builder
     */
    public Builder connectTimeout(Integer connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    /**
     * Sets the {@code maxAutomaticRetries} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAutomaticRetries the {@code maxAutomaticRetries} to set
     * @return a reference to this Builder
     */
    public Builder maxAutomaticRetries(Integer maxAutomaticRetries) {
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
     * Returns a {@code PaysafeApiClient} built from the parameters previously set.Performs following validations:
     * <ul>
     * <li>api key format validation</li>
     * <li>max automatic retries validation</li>
     * <li>connect and response timeout validations</li>
     * </ul>
     *
     * @return a {@code PaysafeApiClient} built with parameters of this {@code PaysafeApiClient.Builder}
     * @throws IllegalArgumentException if any of provided arguments was invalid
     */
    public PaysafeApiClient build() throws IllegalArgumentException {
      validateApiKey(apiKey);
      validateMaxAutomaticRetries(maxAutomaticRetries);
      validateConnectTimeout(connectTimeout);
      validateResponseTimeout(responseTimeout);
      return new PaysafeApiClient(this);
    }
  }
}
