// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.enums.StoredCredentialRequestOccurrence;
import com.paysafe.payments.model.common.enums.StoredCredentialRequestType;

/**
 * The storedCredential object is used to identify authorization requests that use stored credentials for a consumer,
 * in order to improve authorization rates and reduce fraud. Stored credentials can be used in two cases:
 * <ul>
 * <li> Using a payment token – An authorization request that uses a paymentToken from the [Customer Vault API]</li>
 * <li> Using a card number – An authorization request that uses a credit card number stored by the merchant.</li>
 * </ul>
 * <b>Notes: </b>
 * <ul>
 * <li>If you use a paymentToken in the authorization request but do not include the storedCredential object, Paysafe
 * will provide default information taken from Customer Vault data.</li>
 * <li>You cannot include both the storedCredential object and the recurring parameter in the same authorization request.
 * Paysafe recommends using the storedCredential object.</li>
 * <li>The cvv parameter of the [card object] is required when the occurrence parameter is set to INITIAL. However, cvv is
 * not required when the occurrence parameter is set to SUBSEQUENT.</li>
 * <li>The storedCredential object cannot be used for Apple Pay or Google Pay transactions.</li>
 * </ul>
 */
public class StoredCredential {

  @JsonProperty("type")
  private StoredCredentialRequestType type = StoredCredentialRequestType.ADHOC;
  @JsonProperty("occurrence")
  private StoredCredentialRequestOccurrence occurrence = StoredCredentialRequestOccurrence.INITIAL;
  @JsonProperty("initialTransactionId")
  private String initialTransactionId;
  @JsonProperty("externalInitialTransactionId")
  private String externalInitialTransactionId;

  public StoredCredential() {
    super();
  }

  private StoredCredential(Builder builder) {
    setType(builder.type);
    setOccurrence(builder.occurrence);
    setInitialTransactionId(builder.initialTransactionId);
    setExternalInitialTransactionId(builder.externalInitialTransactionId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StoredCredential type(StoredCredentialRequestType type) {
    this.type = type;
    return this;
  }

  /**
   * This specifies the type of request being made. <b>Note:</b> This value defaults to ADHOC.
   *
   * @return type
   */
  public StoredCredentialRequestType getType() {
    return type;
  }

  public void setType(StoredCredentialRequestType type) {
    this.type = type;
  }

  public StoredCredential occurrence(StoredCredentialRequestOccurrence occurrence) {
    this.occurrence = occurrence;
    return this;
  }

  /**
   * This specifies whether this stored credential request is initial or recurring. <b>Note:</b> This value defaults to INITIAL.
   *
   * @return occurrence
   */
  public StoredCredentialRequestOccurrence getOccurrence() {
    return occurrence;
  }

  public void setOccurrence(StoredCredentialRequestOccurrence occurrence) {
    this.occurrence = occurrence;
  }

  public StoredCredential initialTransactionId(String initialTransactionId) {
    this.initialTransactionId = initialTransactionId;
    return this;
  }

  /**
   * Id of the initial Recurring Payment transaction.
   * <p>
   * This id should be stored from the auth response of the transaction indicated as initial with the following:
   * <ul>
   * <li>type=RECURRING/TOPUP, occurrence=INITIAL. </li>
   * </ul>
   * <p>
   * This reference should be provided when:
   * <ul>
   * <li>type = RECURRING and occurrence = SUBSEQUENT </li>
   * <li>type = TOPUP and occurrence = SUBSEQUENT </li>
   * </ul>
   *
   * <b>Note:</b> This reference is a must to meet PSD 2 authentication process requirements for merchant initiated transactions successfully.
   *
   * @return initialTransactionId
   */
  public String getInitialTransactionId() {
    return initialTransactionId;
  }

  public void setInitialTransactionId(String initialTransactionId) {
    this.initialTransactionId = initialTransactionId;
  }

  public StoredCredential externalInitialTransactionId(String externalInitialTransactionId) {
    this.externalInitialTransactionId = externalInitialTransactionId;
    return this;
  }

  /**
   * Card Scheme Transaction Id of the initial payment transaction in the recurring plan when it was processed through external service provider.  <br>
   * This reference should be provided only when:
   * <ul>
   * <li> type=RECURRING and occurrence=SUBSEQUENT </li>
   * <li> type=TOPUP and occurrence=SUBSEQUENT  </li>
   * </ul>
   *
   * <b>Note:</b> This reference cannot be provided along with initialTransactionId.
   *
   * @return externalInitialTransactionId
   */
  public String getExternalInitialTransactionId() {
    return externalInitialTransactionId;
  }

  public void setExternalInitialTransactionId(String externalInitialTransactionId) {
    this.externalInitialTransactionId = externalInitialTransactionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoredCredential storedCredential = (StoredCredential) o;
    return Objects.equals(this.type, storedCredential.type) &&
        Objects.equals(this.occurrence, storedCredential.occurrence) &&
        Objects.equals(this.initialTransactionId, storedCredential.initialTransactionId) &&
        Objects.equals(this.externalInitialTransactionId, storedCredential.externalInitialTransactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, occurrence, initialTransactionId, externalInitialTransactionId);
  }

  @Override
  public String toString() {

    return "class StoredCredential {\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    occurrence: " + toIndentedString(occurrence) + "\n"
        + "    initialTransactionId: " + toIndentedString(initialTransactionId) + "\n"
        + "    externalInitialTransactionId: " + toIndentedString(externalInitialTransactionId) + "\n"
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
   * {@code StoredCredential} builder static inner class.
   */
  public static final class Builder {
    private StoredCredentialRequestType type;
    private StoredCredentialRequestOccurrence occurrence;
    private String initialTransactionId;
    private String externalInitialTransactionId;

    private Builder() {
    }

    /**
     * Sets the {@code type} and returns a reference to this Builder enabling method chaining.
     *
     * @param type the {@code type} to set
     * @return a reference to this Builder
     */
    public Builder type(StoredCredentialRequestType type) {
      this.type = type;
      return this;
    }

    /**
     * Sets the {@code occurrence} and returns a reference to this Builder enabling method chaining.
     *
     * @param occurrence the {@code occurrence} to set
     * @return a reference to this Builder
     */
    public Builder occurrence(StoredCredentialRequestOccurrence occurrence) {
      this.occurrence = occurrence;
      return this;
    }

    /**
     * Sets the {@code initialTransactionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param initialTransactionId the {@code initialTransactionId} to set
     * @return a reference to this Builder
     */
    public Builder initialTransactionId(String initialTransactionId) {
      this.initialTransactionId = initialTransactionId;
      return this;
    }

    /**
     * Sets the {@code externalInitialTransactionId} and returns a reference to this Builder enabling method chaining.
     *
     * @param externalInitialTransactionId the {@code externalInitialTransactionId} to set
     * @return a reference to this Builder
     */
    public Builder externalInitialTransactionId(String externalInitialTransactionId) {
      this.externalInitialTransactionId = externalInitialTransactionId;
      return this;
    }

    /**
     * Returns a {@code StoredCredential} built from the parameters previously set.
     *
     * @return a {@code StoredCredential} built with parameters of this {@code StoredCredential.Builder}
     */
    public StoredCredential build() {
      return new StoredCredential(this);
    }
  }
}

