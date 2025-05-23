// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.card.enums.AuthenticationStatus;
import com.paysafe.payments.model.card.enums.ExemptionIndicator;
import com.paysafe.payments.model.card.enums.SignatureString;
import com.paysafe.payments.model.card.enums.ThreeDEnrollment;
import com.paysafe.payments.model.card.enums.ThreeDResult;

/**
 * Represents the authentication details for a 3D Secure transaction.e
 *
 * <p>Key fields:</p>
 * <ul>
 *   <li><strong>id:</strong> A unique identifier for the authentication transaction. Example: "123456789".</li>
 *   <li><strong>eci:</strong> The ECI (Electronic Commerce Indicator) value indicating the level of security.
 *       Example: 5 (indicating 3D Secure authentication was performed).</li>
 *   <li><strong>cavv:</strong> The Cardholder Authentication Verification Value, used to confirm the authentication.
 *       Example: "A1B2C3D4E5F67890123456789ABCDEF".</li>
 *   <li><strong>xid:</strong> The unique transaction identifier used in 3D Secure, typically provided by the
 *       directory server. Example: "XID12345ABCDE".</li>
 *   <li><strong>status:</strong> The overall status of the 3D Secure authentication process, such as "COMPLETED" or "FAILED".
 *       Example: "COMPLETED".</li>
 *   <li><strong>merchantRefNum:</strong> The reference number used by the merchant to track the transaction.
 *       Example: "TXN123456789".</li>
 *   <li><strong>threeDEnrollment:</strong> The enrollment status of the cardholder in 3D Secure, such as "AVAILABLE",
 *       "NOT_ENROLLED", or "UNAVAILABLE". Example: "AVAILABLE".</li>
 *   <li><strong>directoryServerTransactionId:</strong> The transaction identifier provided by the 3D Secure directory server.
 *       Example: "DS12345678".</li>
 *   <li><strong>threeDSecureVersion:</strong> The version of 3D Secure used in the transaction (e.g., "2.0"). Example: "2.0".</li>
 *   <li><strong>threeDResult:</strong> The result of the 3D Secure authentication, indicating success or failure.
 *       Example: "Y" (authenticated), "N" (not authenticated).</li>
 *   <li><strong>signatureStatus:</strong> The status of the 3D Secure signature verification. Values include "Y" (signature verified)
 *       or "N" (signature failed). Example: "Y".</li>
 *   <li><strong>exemptionIndicator:</strong> Indicates whether the transaction is exempt from 3D Secure authentication,
 *       based on specific criteria. Example: "N" (no exemption).</li>
 *   <li><strong>error:</strong> An object representing any error encountered during the authentication process.
 *       Example: a specific error code such as "500" indicating server error.</li>
 * </ul>
 */
public class Authentication {

  @JsonProperty("id")
  private String id;
  @JsonProperty("eci")
  private Long eci;
  @JsonProperty("cavv")
  private String cavv;
  @JsonProperty("xid")
  private String xid;
  @JsonProperty("status")
  private AuthenticationStatus status;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("threeDEnrollment")
  private ThreeDEnrollment threeDEnrollment;
  @JsonProperty("directoryServerTransactionId")
  private String directoryServerTransactionId;
  @JsonProperty("threeDSecureVersion")
  private String threeDSecureVersion;
  @JsonProperty("threeDResult")
  private ThreeDResult threeDResult;
  @JsonProperty("signatureStatus")
  private SignatureString signatureStatus;
  @JsonProperty("exemptionIndicator")
  private ExemptionIndicator exemptionIndicator;
  @JsonProperty("error")
  private Error error;

  public Authentication() {
    super();
  }

  private Authentication(final Builder builder) {
    setId(builder.id);
    setEci(builder.eci);
    setCavv(builder.cavv);
    setXid(builder.xid);
    setStatus(builder.status);
    setMerchantRefNum(builder.merchantRefNum);
    setThreeDEnrollment(builder.threeDEnrollment);
    setDirectoryServerTransactionId(builder.directoryServerTransactionId);
    setThreeDSecureVersion(builder.threeDSecureVersion);
    setThreeDResult(builder.threeDResult);
    setSignatureStatus(builder.signatureStatus);
    setExemptionIndicator(builder.exemptionIndicator);
    setError(builder.error);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Authentication id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID of authentication, returned in the response.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Authentication eci(Long eci) {
    this.eci = eci;
    return this;
  }

  /**
   * This is the Electronic Commerce Indicator code, which gets returned by the card issuer indicating whether the
   * cardholder was successfully authenticated. Note that in some cases the eci value includes a leading zero, e.g., 01 or 02.
   * <p>
   * Visa:
   * <ul>
   * <li> 5 - Identifies a successfully authenticated transaction. </li>
   * <li> 6 - Identifies an attempts authenticated transaction. </li>
   * <li> 7 - Identifies a non-authenticated transaction. </li>
   * </ul>
   * <br>
   * Mastercard:
   * <ul>
   * <li> 2 - Identifies a successfully authenticated transaction. </li>
   * <li> 1 - Identifies an attempts authenticated transaction. </li>
   * <li> 0 - Identifies a non-authenticated transaction. </li>
   * </ul>
   * @return eci
   */
  public Long getEci() {
    return eci;
  }

  public void setEci(Long eci) {
    this.eci = eci;
  }

  public Authentication cavv(String cavv) {
    this.cavv = cavv;
    return this;
  }

  /**
   * This is the Cardholder Authentication Verification Value, which gets returned by the card issuer, indicating that the transaction has been authenticated.
   *
   * @return cavv
   */
  public String getCavv() {
    return cavv;
  }

  public void setCavv(String cavv) {
    this.cavv = cavv;
  }

  public Authentication xid(String xid) {
    this.xid = xid;
    return this;
  }

  /**
   * This is the transaction identifier returned by the card issuer.
   *
   * @return xid
   */
  public String getXid() {
    return xid;
  }

  public void setXid(String xid) {
    this.xid = xid;
  }

  public Authentication status(AuthenticationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * This is the status of the Enrollment Lookup request.
   * @return status
   */
  public AuthenticationStatus getStatus() {
    return status;
  }

  public void setStatus(AuthenticationStatus status) {
    this.status = status;
  }

  public Authentication merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by  the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public Authentication threeDEnrollment(ThreeDEnrollment threeDEnrollment) {
    this.threeDEnrollment = threeDEnrollment;
    return this;
  }

  /**
   * This indicates whether the cardholder is enrolled in 3D Secure.
   *
   * @return threeDEnrollment
   */
  public ThreeDEnrollment getThreeDEnrollment() {
    return threeDEnrollment;
  }

  public void setThreeDEnrollment(ThreeDEnrollment threeDEnrollment) {
    this.threeDEnrollment = threeDEnrollment;
  }

  public Authentication directoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
    return this;
  }

  /**
   * This is the unique directory server transaction ID required for Mastercard.
   * <b>Note:</b> This is field is required when the card brand is Mastercard. This exists only for 3D Secure 2.
   *
   * @return directoryServerTransactionId
   */
  public String getDirectoryServerTransactionId() {
    return directoryServerTransactionId;
  }

  public void setDirectoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
  }

  public Authentication threeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
    return this;
  }

  /**
   * This is the 3D secure protocol version.
   *
   * @return threeDSecureVersion
   */
  public String getThreeDSecureVersion() {
    return threeDSecureVersion;
  }

  public void setThreeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
  }

  public Authentication threeDResult(ThreeDResult threeDResult) {
    this.threeDResult = threeDResult;
    return this;
  }

  /**
   * This indicates the outcome of the Authentication.
   *
   * @return threeDResult
   */
  public ThreeDResult getThreeDResult() {
    return threeDResult;
  }

  public void setThreeDResult(ThreeDResult threeDResult) {
    this.threeDResult = threeDResult;
  }

  public Authentication signatureStatus(SignatureString signatureStatus) {
    this.signatureStatus = signatureStatus;
    return this;
  }

  /**
   * This is the 3D Secure signature verification result value.
   * @return signatureStatus
   */
  public SignatureString getSignatureStatus() {
    return signatureStatus;
  }

  public void setSignatureStatus(SignatureString signatureStatus) {
    this.signatureStatus = signatureStatus;
  }

  public Authentication exemptionIndicator(ExemptionIndicator exemptionIndicator) {
    this.exemptionIndicator = exemptionIndicator;
    return this;
  }

  /**
   * This exemption gives the Merchant the option to bypass the Strong Customer Authentication or 3DS.  <br>
   * <b>Note:</b> This exists only for 3D Secure 2.
   *
   * @return exemptionIndicator
   */
  public ExemptionIndicator getExemptionIndicator() {
    return exemptionIndicator;
  }

  public void setExemptionIndicator(ExemptionIndicator exemptionIndicator) {
    this.exemptionIndicator = exemptionIndicator;
  }

  public Authentication error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Details of the error.
   *
   * @return error
   */
  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authentication authentication = (Authentication) o;
    return Objects.equals(this.id, authentication.id) &&
        Objects.equals(this.eci, authentication.eci) &&
        Objects.equals(this.cavv, authentication.cavv) &&
        Objects.equals(this.xid, authentication.xid) &&
        Objects.equals(this.status, authentication.status) &&
        Objects.equals(this.merchantRefNum, authentication.merchantRefNum) &&
        Objects.equals(this.threeDEnrollment, authentication.threeDEnrollment) &&
        Objects.equals(this.directoryServerTransactionId, authentication.directoryServerTransactionId) &&
        Objects.equals(this.threeDSecureVersion, authentication.threeDSecureVersion) &&
        Objects.equals(this.threeDResult, authentication.threeDResult) &&
        Objects.equals(this.signatureStatus, authentication.signatureStatus) &&
        Objects.equals(this.exemptionIndicator, authentication.exemptionIndicator) &&
        Objects.equals(this.error, authentication.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, eci, cavv, xid, status, merchantRefNum, threeDEnrollment, directoryServerTransactionId,
        threeDSecureVersion, threeDResult, signatureStatus, exemptionIndicator, error);
  }

  @Override
  public String toString() {

    return "class Authentication {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    eci: " + toIndentedString(eci) + "\n"
        + "    cavv: " + toIndentedString(cavv) + "\n"
        + "    xid: " + toIndentedString(xid) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    threeDEnrollment: " + toIndentedString(threeDEnrollment) + "\n"
        + "    directoryServerTransactionId: " + toIndentedString(directoryServerTransactionId) + "\n"
        + "    threeDSecureVersion: " + toIndentedString(threeDSecureVersion) + "\n"
        + "    threeDResult: " + toIndentedString(threeDResult) + "\n"
        + "    signatureStatus: " + toIndentedString(signatureStatus) + "\n"
        + "    exemptionIndicator: " + toIndentedString(exemptionIndicator) + "\n"
        + "    error: " + toIndentedString(error) + "\n"
        + "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * {@code Authentication} builder static inner class.
   */
  public static final class Builder {
    private String id;
    private Long eci;
    private String cavv;
    private String xid;
    private AuthenticationStatus status;
    private String merchantRefNum;
    private ThreeDEnrollment threeDEnrollment;
    private String directoryServerTransactionId;
    private String threeDSecureVersion;
    private ThreeDResult threeDResult;
    private SignatureString signatureStatus;
    private ExemptionIndicator exemptionIndicator;
    private Error error;

    private Builder() {
    }

    /**
     * Sets the {@code id} and returns a reference to this Builder enabling method chaining.
     *
     * @param id the {@code id} to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the {@code eci} and returns a reference to this Builder enabling method chaining.
     *
     * @param eci the {@code eci} to set
     * @return a reference to this Builder
     */
    public Builder eci(Long eci) {
      this.eci = eci;
      return this;
    }

    /**
     * Sets the {@code cavv} and returns a reference to this Builder enabling method chaining.
     *
     * @param cavv the {@code cavv} to set
     * @return a reference to this Builder
     */
    public Builder cavv(String cavv) {
      this.cavv = cavv;
      return this;
    }

    /**
     * Sets the {@code xid} and returns a reference to this Builder enabling method chaining.
     *
     * @param xid the {@code xid} to set
     * @return a reference to this Builder
     */
    public Builder xid(String xid) {
      this.xid = xid;
      return this;
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(AuthenticationStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code merchantRefNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the {@code merchantRefNum} to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * Sets the {@code threeDEnrollment} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDEnrollment the {@code threeDEnrollment} to set
     * @return a reference to this Builder
     */
    public Builder threeDEnrollment(ThreeDEnrollment threeDEnrollment) {
      this.threeDEnrollment = threeDEnrollment;
      return this;
    }

    /**
     * Sets the {@code directoryServerTransactionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param directoryServerTransactionId the {@code directoryServerTransactionId} to set
     * @return a reference to this Builder
     */
    public Builder directoryServerTransactionId(String directoryServerTransactionId) {
      this.directoryServerTransactionId = directoryServerTransactionId;
      return this;
    }

    /**
     * Sets the {@code threeDSecureVersion} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDSecureVersion the {@code threeDSecureVersion} to set
     * @return a reference to this Builder
     */
    public Builder threeDSecureVersion(String threeDSecureVersion) {
      this.threeDSecureVersion = threeDSecureVersion;
      return this;
    }

    /**
     * Sets the {@code threeDResult} and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDResult the {@code threeDResult} to set
     * @return a reference to this Builder
     */
    public Builder threeDResult(ThreeDResult threeDResult) {
      this.threeDResult = threeDResult;
      return this;
    }

    /**
     * Sets the {@code signatureStatus} and returns a reference to this Builder enabling method chaining.
     *
     * @param signatureStatus the {@code signatureStatus} to set
     * @return a reference to this Builder
     */
    public Builder signatureStatus(SignatureString signatureStatus) {
      this.signatureStatus = signatureStatus;
      return this;
    }

    /**
     * Sets the {@code exemptionIndicator} and returns a reference to this Builder enabling method chaining.
     *
     * @param exemptionIndicator the {@code exemptionIndicator} to set
     * @return a reference to this Builder
     */
    public Builder exemptionIndicator(ExemptionIndicator exemptionIndicator) {
      this.exemptionIndicator = exemptionIndicator;
      return this;
    }

    /**
     * Sets the {@code error} and returns a reference to this Builder enabling method chaining.
     *
     * @param error the {@code error} to set
     * @return a reference to this Builder
     */
    public Builder error(Error error) {
      this.error = error;
      return this;
    }

    /**
     * Returns a {@code Authentication} built from the parameters previously set.
     *
     * @return a {@code Authentication} built with parameters of this {@code Authentication.Builder}
     */
    public Authentication build() {
      return new Authentication(this);
    }
  }
}

