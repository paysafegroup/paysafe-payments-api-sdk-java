// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.lpm.enums.CountryCode;
import com.paysafe.payments.model.lpm.enums.LanguageCode;

/**
 * These are the details of the customer used for the transaction.
 */
public class Skrill {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("emailSubject")
  private String emailSubject;
  @JsonProperty("emailMessage")
  private String emailMessage;
  @JsonProperty("recipientDescription")
  private String recipientDescription;
  @JsonProperty("language")
  private LanguageCode language;
  @JsonProperty("logoUrl")
  private String logoUrl;
  @JsonProperty("detail1Description")
  private String detail1Description;
  @JsonProperty("detail1Text")
  private String detail1Text;
  @JsonProperty("countryCode")
  private CountryCode countryCode;

  public Skrill() {
    super();
  }

  private Skrill(Builder builder) {
    setConsumerId(builder.consumerId);
    setEmailSubject(builder.emailSubject);
    setEmailMessage(builder.emailMessage);
    setRecipientDescription(builder.recipientDescription);
    setLanguage(builder.language);
    setLogoUrl(builder.logoUrl);
    setDetail1Description(builder.detail1Description);
    setDetail1Text(builder.detail1Text);
    setCountryCode(builder.countryCode);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Skrill consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the email address of the customer who is  making or receiving the payment. This is to be provided by merchant.
   * This is sent as \"pay_from_email\" to Skrill.
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public Skrill emailSubject(String emailSubject) {
    this.emailSubject = emailSubject;
    return this;
  }

  /**
   * <b>Note:</b> Mandatory field for payout only. This is the Subject line to use in the customer email.
   * This is to be provided by merchant while making a payout.
   *
   * @return emailSubject
   */
  public String getEmailSubject() {
    return emailSubject;
  }

  public void setEmailSubject(String emailSubject) {
    this.emailSubject = emailSubject;
  }

  public Skrill emailMessage(String emailMessage) {
    this.emailMessage = emailMessage;
    return this;
  }

  /**
   * <b>Note:</b> Mandatory field for payout. This is the message to use in the customer email. This is to be provided by merchant while  making a payout.
   *
   * @return emailMessage
   */
  public String getEmailMessage() {
    return emailMessage;
  }

  public void setEmailMessage(String emailMessage) {
    this.emailMessage = emailMessage;
  }

  public Skrill recipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
    return this;
  }

  /**
   * This is a description to be shown on the Skrill payment page in the logo area if there is no logo_url parameter.
   * If no value is submitted and  there is no logo, the pay_to_email value is shown as the recipient of the payment.
   *
   * @return recipientDescription
   */
  public String getRecipientDescription() {
    return recipientDescription;
  }

  public void setRecipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
  }

  public Skrill language(LanguageCode language) {
    this.language = language;
    return this;
  }

  /**
   * The 2-character preferred language code for the consumer (e.g. AU, AT, BE, BR, CA, CH, CN, DE, ES, GB, FR, IT, NL, PL, PT, RU, or US.)
   * or A five-character code is also valid for languages in these countries (e.g. da_DK, he_IL, id_ID, ja_JP, no_NO, pt_BR, ru_RU, sv_SE,
   * th_TH, zh_CN, zh_HK, and zh_TW).  <br>
   *
   * @return language
   */
  public LanguageCode getLanguage() {
    return language;
  }

  public void setLanguage(LanguageCode language) {
    this.language = language;
  }

  public Skrill logoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
    return this;
  }

  /**
   * This is the URL of the logo that you would like to appear in the top right of the Skrill. The logo must be accessible via HTTPS or it will not be shown.
   * The logo will be resized to fit. To avoid scaling distortion, the minimum size should be as  follows:  <br>
   * If the logo width is greater than height - at least 107px wide.  <br>
   * If logo width is greater than height - at least 65px high.  <br>
   * Avoid large images (much greater than 256 by 256px) to minimize the page loading time.
   *
   * @return logoUrl
   */
  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public Skrill detail1Description(String detail1Description) {
    this.detail1Description = detail1Description;
    return this;
  }

  /**
   * You can show additional details about the product  in the More information section in the header.
   *
   * @return detail1Description
   */
  public String getDetail1Description() {
    return detail1Description;
  }

  public void setDetail1Description(String detail1Description) {
    this.detail1Description = detail1Description;
  }

  public Skrill detail1Text(String detail1Text) {
    this.detail1Text = detail1Text;
    return this;
  }

  /**
   * The detail1Text is shown next to the  detail1Description in the More Information section in the header of the payment form with the other payment details.
   * The detail1Description combined with the detail1Text is shown in the more information field of the merchant account history CSV file.
   *
   * @return detail1Text
   */
  public String getDetail1Text() {
    return detail1Text;
  }

  public void setDetail1Text(String detail1Text) {
    this.detail1Text = detail1Text;
  }

  public Skrill countryCode(CountryCode countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * This is Customer's country of residence
   *
   * @return countryCode
   */
  public CountryCode getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(CountryCode countryCode) {
    this.countryCode = countryCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Skrill skrill = (Skrill) o;
    return Objects.equals(this.consumerId, skrill.consumerId) &&
        Objects.equals(this.emailSubject, skrill.emailSubject) &&
        Objects.equals(this.emailMessage, skrill.emailMessage) &&
        Objects.equals(this.recipientDescription, skrill.recipientDescription) &&
        Objects.equals(this.language, skrill.language) &&
        Objects.equals(this.logoUrl, skrill.logoUrl) &&
        Objects.equals(this.detail1Description, skrill.detail1Description) &&
        Objects.equals(this.detail1Text, skrill.detail1Text) &&
        Objects.equals(this.countryCode, skrill.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, emailSubject, emailMessage, recipientDescription, language, logoUrl, detail1Description, detail1Text, countryCode);
  }

  @Override
  public String toString() {

    return "class Skrill {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    emailSubject: " + toIndentedString(emailSubject) + "\n"
        + "    emailMessage: " + toIndentedString(emailMessage) + "\n"
        + "    recipientDescription: " + toIndentedString(recipientDescription) + "\n"
        + "    language: " + toIndentedString(language) + "\n"
        + "    logoUrl: " + toIndentedString(logoUrl) + "\n"
        + "    detail1Description: " + toIndentedString(detail1Description) + "\n"
        + "    detail1Text: " + toIndentedString(detail1Text) + "\n"
        + "    countryCode: " + toIndentedString(countryCode) + "\n"
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
   * {@code Skrill} builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String emailSubject;
    private String emailMessage;
    private String recipientDescription;
    private LanguageCode language;
    private String logoUrl;
    private String detail1Description;
    private String detail1Text;
    private CountryCode countryCode;

    private Builder() {
    }

    /**
     * Sets the {@code consumerId} and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the {@code consumerId} to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * Sets the {@code emailSubject} and returns a reference to this Builder enabling method chaining.
     *
     * @param emailSubject the {@code emailSubject} to set
     * @return a reference to this Builder
     */
    public Builder emailSubject(String emailSubject) {
      this.emailSubject = emailSubject;
      return this;
    }

    /**
     * Sets the {@code emailMessage} and returns a reference to this Builder enabling method chaining.
     *
     * @param emailMessage the {@code emailMessage} to set
     * @return a reference to this Builder
     */
    public Builder emailMessage(String emailMessage) {
      this.emailMessage = emailMessage;
      return this;
    }

    /**
     * Sets the {@code recipientDescription} and returns a reference to this Builder enabling method chaining.
     *
     * @param recipientDescription the {@code recipientDescription} to set
     * @return a reference to this Builder
     */
    public Builder recipientDescription(String recipientDescription) {
      this.recipientDescription = recipientDescription;
      return this;
    }

    /**
     * Sets the {@code language} and returns a reference to this Builder enabling method chaining.
     *
     * @param language the {@code language} to set
     * @return a reference to this Builder
     */
    public Builder language(LanguageCode language) {
      this.language = language;
      return this;
    }

    /**
     * Sets the {@code logoUrl} and returns a reference to this Builder enabling method chaining.
     *
     * @param logoUrl the {@code logoUrl} to set
     * @return a reference to this Builder
     */
    public Builder logoUrl(String logoUrl) {
      this.logoUrl = logoUrl;
      return this;
    }

    /**
     * Sets the {@code detail1Description} and returns a reference to this Builder enabling method chaining.
     *
     * @param detail1Description the {@code detail1Description} to set
     * @return a reference to this Builder
     */
    public Builder detail1Description(String detail1Description) {
      this.detail1Description = detail1Description;
      return this;
    }

    /**
     * Sets the {@code detail1Text} and returns a reference to this Builder enabling method chaining.
     *
     * @param detail1Text the {@code detail1Text} to set
     * @return a reference to this Builder
     */
    public Builder detail1Text(String detail1Text) {
      this.detail1Text = detail1Text;
      return this;
    }

    /**
     * Sets the {@code countryCode} and returns a reference to this Builder enabling method chaining.
     *
     * @param countryCode the {@code countryCode} to set
     * @return a reference to this Builder
     */
    public Builder countryCode(CountryCode countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Returns a {@code Skrill} built from the parameters previously set.
     *
     * @return a {@code Skrill} built with parameters of this {@code Skrill.Builder}
     */
    public Skrill build() {
      return new Skrill(this);
    }
  }
}

