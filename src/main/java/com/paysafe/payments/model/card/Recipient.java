// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.common.profile.DateOfBirth;

/**
 * Represents a recipient's information for a transaction, including personal details and account information.
 *
 * <p>The recipient is the individual or entity with the contractual relationship
 * with the merchant or financial institution, which may differ from the cardholder.</p>
 *
 * <p>Key fields:</p>
 * <ul>
 *   <li><strong>dateOfBirth:</strong> The date of birth of the recipient.</li>
 *   <li><strong>accountNumber:</strong> The recipient's account number, used for payment or identification purposes.</li>
 *   <li><strong>lastName:</strong> The recipient's last name.</li>
 *   <li><strong>zipCode:</strong> The postal or ZIP code associated with the recipient's address.</li>
 * </ul>
 */
public class Recipient {

  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("zip")
  private String zip;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("accountNumber")
  private String accountNumber;

  public Recipient() {
    super();
  }

  private Recipient(Builder builder) {
    setDateOfBirth(builder.dateOfBirth);
    setZip(builder.zip);
    setLastName(builder.lastName);
    setAccountNumber(builder.accountNumber);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Recipient dateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * This is the recipient's date of birth.  <b>Note:</b> Required for Pay by Bank.
   *
   * @return dateOfBirth
   */
  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Recipient zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * This is the zip/postal code of the recipient.  <b>Note:</b> The last 3 characters are not sent to the banking network.
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public Recipient lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * This is the recipient's last name.  <b>Note:</b> Only the first 6 characters are sent to the banking network.
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Recipient accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * This is the recipient's account number, e.g., a  loan agreement number or customer ID. In the case where the recipient account is a prepaid card,
   * the card number may be sent in full. <b>Note:</b> Only the first 6 and last 4 characters are sent to the banking network and will be masked accordingly
   * within the back office and any other reports, to comply with PCI regulations.
   *
   * @return accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(this.dateOfBirth, recipient.dateOfBirth) &&
        Objects.equals(this.zip, recipient.zip) &&
        Objects.equals(this.lastName, recipient.lastName) &&
        Objects.equals(this.accountNumber, recipient.accountNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfBirth, zip, lastName, accountNumber);
  }

  @Override
  public String toString() {

    return "class Recipient {\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
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
   * {@code Recipient} builder static inner class.
   */
  public static final class Builder {
    private DateOfBirth dateOfBirth;
    private String zip;
    private String lastName;
    private String accountNumber;

    private Builder() {
    }

    /**
     * Sets the {@code dateOfBirth} and returns a reference to this Builder enabling method chaining.
     *
     * @param dateOfBirth the {@code dateOfBirth} to set
     * @return a reference to this Builder
     */
    public Builder dateOfBirth(DateOfBirth dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    /**
     * Sets the {@code zip} and returns a reference to this Builder enabling method chaining.
     *
     * @param zip the {@code zip} to set
     * @return a reference to this Builder
     */
    public Builder zip(String zip) {
      this.zip = zip;
      return this;
    }

    /**
     * Sets the {@code lastName} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastName the {@code lastName} to set
     * @return a reference to this Builder
     */
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    /**
     * Sets the {@code accountNumber} and returns a reference to this Builder enabling method chaining.
     *
     * @param accountNumber the {@code accountNumber} to set
     * @return a reference to this Builder
     */
    public Builder accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    /**
     * Returns a {@code Recipient} built from the parameters previously set.
     *
     * @return a {@code Recipient} built with parameters of this {@code Recipient.Builder}
     */
    public Recipient build() {
      return new Recipient(this);
    }
  }
}
