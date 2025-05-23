// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysafe.payments.model.applepay.ApplePayTokenDetails;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.card.ExternalNetworkTokenRequest;
import com.paysafe.payments.model.card.enums.CardStatus;
import com.paysafe.payments.model.card.enums.CardType;
import com.paysafe.payments.model.card.threeds.BrowserDetails;
import com.paysafe.payments.model.common.DeviceDetails;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Mazooma;
import com.paysafe.payments.model.lpm.Neteller;
import com.paysafe.payments.model.lpm.Paypal;
import com.paysafe.payments.model.lpm.RapidTransfer;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.lpm.Sightline;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.lpm.Skrill1Tap;
import com.paysafe.payments.model.lpm.SkrillPaymentGatewayResponse;
import com.paysafe.payments.model.lpm.Venmo;
import com.paysafe.payments.model.lpm.Vippreferred;

/**
 * StandaloneCreditPaymentInstrumentInner
 */
public class StandaloneCreditPaymentInstrumentInner {

  @JsonProperty("cardNum")
  private String cardNum;
  @JsonProperty("cardId")
  private String cardId;
  @JsonProperty("cardExpiry")
  private CardExpiry cardExpiry;
  @JsonProperty("cvv")
  private String cvv;
  @JsonProperty("holderName")
  private String holderName;
  @JsonProperty("cardType")
  private CardType cardType;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("cardBin")
  private String cardBin;
  @JsonProperty("issuingCountry")
  private String issuingCountry;
  @JsonProperty("status")
  private CardStatus status;
  @JsonProperty("applePay")
  private ApplePayTokenDetails applePay;
  @JsonProperty("tokenType")
  private String tokenType;
  @JsonProperty("networkToken")
  private ExternalNetworkTokenRequest networkToken;
  @JsonProperty("skrill")
  private Skrill skrill;
  @JsonProperty("gatewayResponse")
  private SkrillPaymentGatewayResponse gatewayResponse;
  @JsonProperty("neteller")
  private Neteller neteller;
  @JsonProperty("payPal")
  private Paypal payPal;
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
  @JsonProperty("venmo")
  private Venmo venmo;
  @JsonProperty("vippreferred")
  private Vippreferred vippreferred;
  @JsonProperty("mazooma")
  private Mazooma mazooma;
  @JsonProperty("sightline")
  private Sightline sightline;
  @JsonProperty("interacETransfer")
  private Interac interacETransfer;
  @JsonProperty("browserDetails")
  private BrowserDetails browserDetails = null;
  @JsonProperty("deviceDetails")
  private DeviceDetails deviceDetails;
  @JsonProperty("rapidTransfer")
  private RapidTransfer rapidTransfer;
  @JsonProperty("skrill1Tap")
  private Skrill1Tap skrill1Tap;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates = null;
  @JsonProperty("sepa")
  private Sepa sepa;

  public StandaloneCreditPaymentInstrumentInner() {
    super();
  }

  private StandaloneCreditPaymentInstrumentInner(Builder builder) {
    setCardNum(builder.cardNum);
    setCardId(builder.cardId);
    setCardExpiry(builder.cardExpiry);
    setCvv(builder.cvv);
    setCardType(builder.cardType);
    setLastDigits(builder.lastDigits);
    setCardBin(builder.cardBin);
    setIssuingCountry(builder.issuingCountry);
    setStatus(builder.status);
    setApplePay(builder.applePay);
    setTokenType(builder.tokenType);
    setNetworkToken(builder.networkToken);
    setSkrill(builder.skrill);
    setGatewayResponse(builder.gatewayResponse);
    setNeteller(builder.neteller);
    setPayPal(builder.payPal);
    setReturnLinks(builder.returnLinks);
    setVenmo(builder.venmo);
    setVippreferred(builder.vippreferred);
    setMazooma(builder.mazooma);
    setSightline(builder.sightline);
    setInteracETransfer(builder.interacETransfer);
    setBrowserDetails(builder.browserDetails);
    setDeviceDetails(builder.deviceDetails);
    setRapidTransfer(builder.rapidTransfer);
    setSkrill1Tap(builder.skrill1Tap);
    setAch(builder.ach);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StandaloneCreditPaymentInstrumentInner cardNum(String cardNum) {
    this.cardNum = cardNum;
    return this;
  }

  /**
   * This is the card number used for the request.
   *
   * @return cardNum
   */
  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public StandaloneCreditPaymentInstrumentInner cardId(String cardId) {
    this.cardId = cardId;
    return this;
  }

  /**
   * This is the card id returned in the response during save card flow.
   *
   * @return cardId
   */
  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public StandaloneCreditPaymentInstrumentInner cardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
    return this;
  }

  /**
   * This is the card's expiry date.
   *
   * @return cardExpiry
   */
  public CardExpiry getCardExpiry() {
    return cardExpiry;
  }

  public void setCardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
  }

  public StandaloneCreditPaymentInstrumentInner cvv(String cvv) {
    this.cvv = cvv;
    return this;
  }

  /**
   * This is the 3- or 4-digit security code that appears on the card following the card number.
   *
   * @return cvv
   */
  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public StandaloneCreditPaymentInstrumentInner holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * This is the name of the card holder. Holder name must contain only Latin characters (English
   * Alphabet), Space, Apostrophe('), Dot(.) or Hyphen(-). <br>
   * Unicode normalization is done.
   *
   * @return holderName
   */
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public StandaloneCreditPaymentInstrumentInner cardType(CardType cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * This is type of card used for the request
   *
   * @return cardType
   */
  public CardType getCardType() {
    return cardType;
  }

  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }

  public StandaloneCreditPaymentInstrumentInner lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last four digits of the card used for the request.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  public StandaloneCreditPaymentInstrumentInner cardBin(String cardBin) {
    this.cardBin = cardBin;
    return this;
  }

  /**
   * These are the first 6 digits of the card Bank Identification Number (BIN), for example: the first 6 digits of the card number.
   *
   * @return cardBin
   */
  public String getCardBin() {
    return cardBin;
  }

  public void setCardBin(String cardBin) {
    this.cardBin = cardBin;
  }

  public StandaloneCreditPaymentInstrumentInner issuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
    return this;
  }

  /**
   * This is the card issuing country.
   *
   * @return issuingCountry
   */
  public String getIssuingCountry() {
    return issuingCountry;
  }

  public void setIssuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
  }

  public StandaloneCreditPaymentInstrumentInner status(CardStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Optional.  Present only if the card is part of a Customer.
   *
   * @return status
   */
  public CardStatus getStatus() {
    return status;
  }

  public void setStatus(CardStatus status) {
    this.status = status;
  }

  public StandaloneCreditPaymentInstrumentInner applePay(ApplePayTokenDetails applePay) {
    this.applePay = applePay;
    return this;
  }

  /**
   * When tokenType=APPLE_PAY. Apple Pay token information. Returned when the stored payment method is an Apple Pay token.
   *
   * @return applePay
   */
  public ApplePayTokenDetails getApplePay() {
    return applePay;
  }

  public void setApplePay(ApplePayTokenDetails applePay) {
    this.applePay = applePay;
  }

  public StandaloneCreditPaymentInstrumentInner tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType. Possible value: NETWORK_TOKEN
   *
   * @return tokenType
   */
  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public StandaloneCreditPaymentInstrumentInner networkToken(ExternalNetworkTokenRequest networkToken) {
    this.networkToken = networkToken;
    return this;
  }

  /**
   * Get networkToken
   *
   * @return networkToken
   */
  public ExternalNetworkTokenRequest getNetworkToken() {
    return networkToken;
  }

  public void setNetworkToken(ExternalNetworkTokenRequest networkToken) {
    this.networkToken = networkToken;
  }

  public StandaloneCreditPaymentInstrumentInner skrill(Skrill skrill) {
    this.skrill = skrill;
    return this;
  }

  /**
   * These are the details of the customer used for the transaction.
   *
   * @return skrill
   */
  public Skrill getSkrill() {
    return skrill;
  }

  public void setSkrill(Skrill skrill) {
    this.skrill = skrill;
  }

  public StandaloneCreditPaymentInstrumentInner gatewayResponse(SkrillPaymentGatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

  /**
   * This contains parameters returned by Skrill gateway
   *
   * @return gatewayResponse
   */
  public SkrillPaymentGatewayResponse getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(SkrillPaymentGatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }

  public StandaloneCreditPaymentInstrumentInner neteller(Neteller neteller) {
    this.neteller = neteller;
    return this;
  }

  /**
   * Neteller details to be used for the request
   *
   * @return neteller
   */
  public Neteller getNeteller() {
    return neteller;
  }

  public void setNeteller(Neteller neteller) {
    this.neteller = neteller;
  }

  public StandaloneCreditPaymentInstrumentInner payPal(Paypal payPal) {
    this.payPal = payPal;
    return this;
  }

  /**
   * These are the details of the PayPal account used for the transaction.
   *
   * @return payPal
   */
  public Paypal getPayPal() {
    return payPal;
  }

  public void setPayPal(Paypal payPal) {
    this.payPal = payPal;
  }

  public StandaloneCreditPaymentInstrumentInner returnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
    return this;
  }

  /**
   * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site.
   * You can customize the return URL based on the transaction status.
   *
   * @return returnLinks
   */
  public List<ReturnLink> getReturnLinks() {
    return returnLinks;
  }

  public void setReturnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
  }

  public StandaloneCreditPaymentInstrumentInner venmo(Venmo venmo) {
    this.venmo = venmo;
    return this;
  }

  /**
   * Get venmo
   *
   * @return venmo
   */
  public Venmo getVenmo() {
    return venmo;
  }

  public void setVenmo(Venmo venmo) {
    this.venmo = venmo;
  }

  public StandaloneCreditPaymentInstrumentInner vippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
    return this;
  }

  /**
   * These are the details of the vip preferred account used for the transaction.
   *
   * @return vippreferred
   */
  public Vippreferred getVippreferred() {
    return vippreferred;
  }

  public void setVippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
  }

  public StandaloneCreditPaymentInstrumentInner mazooma(Mazooma mazooma) {
    this.mazooma = mazooma;
    return this;
  }

  /**
   * Mazooma details to be used for the transaction
   *
   * @return mazooma
   */
  public Mazooma getMazooma() {
    return mazooma;
  }

  public void setMazooma(Mazooma mazooma) {
    this.mazooma = mazooma;
  }

  public StandaloneCreditPaymentInstrumentInner sightline(Sightline sightline) {
    this.sightline = sightline;
    return this;
  }

  /**
   * These are the details of the Play+ (Sightline) used for the transaction.
   *
   * @return sightline
   */
  public Sightline getSightline() {
    return sightline;
  }

  public void setSightline(Sightline sightline) {
    this.sightline = sightline;
  }

  public StandaloneCreditPaymentInstrumentInner interacETransfer(Interac interacETransfer) {
    this.interacETransfer = interacETransfer;
    return this;
  }

  /**
   * Details of the interac E-Transfer used for the transaction.
   *
   * @return interacETransfer
   */
  public Interac getInteracETransfer() {
    return interacETransfer;
  }

  public void setInteracETransfer(Interac interacETransfer) {
    this.interacETransfer = interacETransfer;
  }

  public StandaloneCreditPaymentInstrumentInner browserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
    return this;
  }

  /**
   * Get browserDetails
   *
   * @return browserDetails
   */
  public BrowserDetails getBrowserDetails() {
    return browserDetails;
  }

  public void setBrowserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
  }

  public StandaloneCreditPaymentInstrumentInner deviceDetails(DeviceDetails deviceDetails) {
    this.deviceDetails = deviceDetails;
    return this;
  }

  /**
   * For Interac e-Transfer withdrawal only. <br>  This is part of Interac e-Transfer withdrawal payment handle request.
   * It is used for risk assessment by Interac.  <br>
   * This parameter is mandatory if browserDetails object is not passed as a part of Interac e-Transfer withdrawal payment handle request.
   *
   * @return deviceDetails
   */
  public DeviceDetails getDeviceDetails() {
    return deviceDetails;
  }

  public void setDeviceDetails(DeviceDetails deviceDetails) {
    this.deviceDetails = deviceDetails;
  }

  public StandaloneCreditPaymentInstrumentInner rapidTransfer(RapidTransfer rapidTransfer) {
    this.rapidTransfer = rapidTransfer;
    return this;
  }

  /**
   * These are the details of the rapid transfer used for the transaction.
   *
   * @return rapidTransfer
   */
  public RapidTransfer getRapidTransfer() {
    return rapidTransfer;
  }

  public void setRapidTransfer(RapidTransfer rapidTransfer) {
    this.rapidTransfer = rapidTransfer;
  }

  public StandaloneCreditPaymentInstrumentInner skrill1Tap(Skrill1Tap skrill1Tap) {
    this.skrill1Tap = skrill1Tap;
    return this;
  }

  /**
   * These are the details of the skrill 1-Tap account used for the transaction.
   *
   * @return skrill1Tap
   */
  public Skrill1Tap getSkrill1Tap() {
    return skrill1Tap;
  }

  public void setSkrill1Tap(Skrill1Tap skrill1Tap) {
    this.skrill1Tap = skrill1Tap;
  }

  public StandaloneCreditPaymentInstrumentInner ach(Ach ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Details of the ach account to be used for the transaction.
   *
   * @return ach
   */
  public Ach getAch() {
    return ach;
  }

  public void setAch(Ach ach) {
    this.ach = ach;
  }

  public StandaloneCreditPaymentInstrumentInner eft(Eft eft) {
    this.eft = eft;
    return this;
  }

  /**
   * Details of the EFT account to be used for the transaction
   *
   * @return eft
   */
  public Eft getEft() {
    return eft;
  }

  public void setEft(Eft eft) {
    this.eft = eft;
  }

  public StandaloneCreditPaymentInstrumentInner dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Get dupCheck
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }

  public StandaloneCreditPaymentInstrumentInner bacs(Bacs bacs) {
    this.bacs = bacs;
    return this;
  }

  /**
   * Details of the bacs account to be used for the transaction.
   *
   * @return bacs
   */
  public Bacs getBacs() {
    return bacs;
  }

  public void setBacs(Bacs bacs) {
    this.bacs = bacs;
  }

  public StandaloneCreditPaymentInstrumentInner mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public StandaloneCreditPaymentInstrumentInner addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public StandaloneCreditPaymentInstrumentInner removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * Get mandates
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }

  public StandaloneCreditPaymentInstrumentInner sepa(Sepa sepa) {
    this.sepa = sepa;
    return this;
  }

  /**
   * These are the details of the sepa account used for the transaction.
   *
   * @return sepa
   */
  public Sepa getSepa() {
    return sepa;
  }

  public void setSepa(Sepa sepa) {
    this.sepa = sepa;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StandaloneCreditPaymentInstrumentInner standaloneCreditPaymentInstrumentInner = (StandaloneCreditPaymentInstrumentInner) o;
    return Objects.equals(this.cardNum, standaloneCreditPaymentInstrumentInner.cardNum) &&
        Objects.equals(this.cardId, standaloneCreditPaymentInstrumentInner.cardId) &&
        Objects.equals(this.cardExpiry, standaloneCreditPaymentInstrumentInner.cardExpiry) &&
        Objects.equals(this.cvv, standaloneCreditPaymentInstrumentInner.cvv) &&
        Objects.equals(this.holderName, standaloneCreditPaymentInstrumentInner.holderName) &&
        Objects.equals(this.cardType, standaloneCreditPaymentInstrumentInner.cardType) &&
        Objects.equals(this.lastDigits, standaloneCreditPaymentInstrumentInner.lastDigits) &&
        Objects.equals(this.cardBin, standaloneCreditPaymentInstrumentInner.cardBin) &&
        Objects.equals(this.issuingCountry, standaloneCreditPaymentInstrumentInner.issuingCountry) &&
        Objects.equals(this.status, standaloneCreditPaymentInstrumentInner.status) &&
        Objects.equals(this.applePay, standaloneCreditPaymentInstrumentInner.applePay) &&
        Objects.equals(this.tokenType, standaloneCreditPaymentInstrumentInner.tokenType) &&
        Objects.equals(this.networkToken, standaloneCreditPaymentInstrumentInner.networkToken) &&
        Objects.equals(this.skrill, standaloneCreditPaymentInstrumentInner.skrill) &&
        Objects.equals(this.gatewayResponse, standaloneCreditPaymentInstrumentInner.gatewayResponse) &&
        Objects.equals(this.neteller, standaloneCreditPaymentInstrumentInner.neteller) &&
        Objects.equals(this.payPal, standaloneCreditPaymentInstrumentInner.payPal) &&
        Objects.equals(this.returnLinks, standaloneCreditPaymentInstrumentInner.returnLinks) &&
        Objects.equals(this.venmo, standaloneCreditPaymentInstrumentInner.venmo) &&
        Objects.equals(this.vippreferred, standaloneCreditPaymentInstrumentInner.vippreferred) &&
        Objects.equals(this.mazooma, standaloneCreditPaymentInstrumentInner.mazooma) &&
        Objects.equals(this.sightline, standaloneCreditPaymentInstrumentInner.sightline) &&
        Objects.equals(this.interacETransfer, standaloneCreditPaymentInstrumentInner.interacETransfer) &&
        Objects.equals(this.browserDetails, standaloneCreditPaymentInstrumentInner.browserDetails) &&
        Objects.equals(this.deviceDetails, standaloneCreditPaymentInstrumentInner.deviceDetails) &&
        Objects.equals(this.rapidTransfer, standaloneCreditPaymentInstrumentInner.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, standaloneCreditPaymentInstrumentInner.skrill1Tap) &&
        Objects.equals(this.ach, standaloneCreditPaymentInstrumentInner.ach) &&
        Objects.equals(this.eft, standaloneCreditPaymentInstrumentInner.eft) &&
        Objects.equals(this.dupCheck, standaloneCreditPaymentInstrumentInner.dupCheck) &&
        Objects.equals(this.bacs, standaloneCreditPaymentInstrumentInner.bacs) &&
        Objects.equals(this.mandates, standaloneCreditPaymentInstrumentInner.mandates) &&
        Objects.equals(this.sepa, standaloneCreditPaymentInstrumentInner.sepa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNum, cardId, cardExpiry, cvv, holderName, cardType, lastDigits, cardBin, issuingCountry, status, applePay, tokenType,
        networkToken, skrill, gatewayResponse, neteller, payPal, returnLinks, venmo, vippreferred, mazooma, sightline, interacETransfer, browserDetails,
        deviceDetails, rapidTransfer, skrill1Tap, ach, eft, dupCheck, bacs, mandates, sepa);
  }

  @Override
  public String toString() {

    return "class StandaloneCreditPaymentInstrumentInner {\n"
        + "    cardNum: " + toIndentedString(cardNum) + "\n"
        + "    cardId: " + toIndentedString(cardId) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    cvv: " + toIndentedString(cvv) + "\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardBin: " + toIndentedString(cardBin) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
        + "    tokenType: " + toIndentedString(tokenType) + "\n"
        + "    networkToken: " + toIndentedString(networkToken) + "\n"
        + "    skrill: " + toIndentedString(skrill) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    neteller: " + toIndentedString(neteller) + "\n"
        + "    payPal: " + toIndentedString(payPal) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    venmo: " + toIndentedString(venmo) + "\n"
        + "    vippreferred: " + toIndentedString(vippreferred) + "\n"
        + "    mazooma: " + toIndentedString(mazooma) + "\n"
        + "    sightline: " + toIndentedString(sightline) + "\n"
        + "    interacETransfer: " + toIndentedString(interacETransfer) + "\n"
        + "    browserDetails: " + toIndentedString(browserDetails) + "\n"
        + "    deviceDetails: " + toIndentedString(deviceDetails) + "\n"
        + "    rapidTransfer: " + toIndentedString(rapidTransfer) + "\n"
        + "    skrill1Tap: " + toIndentedString(skrill1Tap) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
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
   * {@code StandaloneCreditPaymentInstrumentInner} builder static inner class.
   */
  public static final class Builder {
    private String cardNum;
    private String cardId;
    private CardExpiry cardExpiry;
    private String cvv;
    private CardType cardType;
    private String lastDigits;
    private String cardBin;
    private String issuingCountry;
    private CardStatus status;
    private ApplePayTokenDetails applePay;
    private String tokenType;
    private ExternalNetworkTokenRequest networkToken;
    private Skrill skrill;
    private SkrillPaymentGatewayResponse gatewayResponse;
    private Neteller neteller;
    private Paypal payPal;
    private List<ReturnLink> returnLinks;
    private Venmo venmo;
    private Vippreferred vippreferred;
    private Mazooma mazooma;
    private Sightline sightline;
    private Interac interacETransfer;
    private BrowserDetails browserDetails;
    private DeviceDetails deviceDetails;
    private RapidTransfer rapidTransfer;
    private Skrill1Tap skrill1Tap;
    private Ach ach;
    private Eft eft;
    private Boolean dupCheck;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;

    private Builder() {
    }

    /**
     * Sets the {@code cardNum} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardNum the {@code cardNum} to set
     * @return a reference to this Builder
     */
    public Builder cardNum(String cardNum) {
      this.cardNum = cardNum;
      return this;
    }

    /**
     * Sets the {@code cardId} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardId the {@code cardId} to set
     * @return a reference to this Builder
     */
    public Builder cardId(String cardId) {
      this.cardId = cardId;
      return this;
    }

    /**
     * Sets the {@code cardExpiry} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardExpiry the {@code cardExpiry} to set
     * @return a reference to this Builder
     */
    public Builder cardExpiry(CardExpiry cardExpiry) {
      this.cardExpiry = cardExpiry;
      return this;
    }

    /**
     * Sets the {@code cvv} and returns a reference to this Builder enabling method chaining.
     *
     * @param cvv the {@code cvv} to set
     * @return a reference to this Builder
     */
    public Builder cvv(String cvv) {
      this.cvv = cvv;
      return this;
    }

    /**
     * Sets the {@code cardType} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardType the {@code cardType} to set
     * @return a reference to this Builder
     */
    public Builder cardType(CardType cardType) {
      this.cardType = cardType;
      return this;
    }

    /**
     * Sets the {@code lastDigits} and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the {@code lastDigits} to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * Sets the {@code cardBin} and returns a reference to this Builder enabling method chaining.
     *
     * @param cardBin the {@code cardBin} to set
     * @return a reference to this Builder
     */
    public Builder cardBin(String cardBin) {
      this.cardBin = cardBin;
      return this;
    }

    /**
     * Sets the {@code issuingCountry} and returns a reference to this Builder enabling method chaining.
     *
     * @param issuingCountry the {@code issuingCountry} to set
     * @return a reference to this Builder
     */
    public Builder issuingCountry(String issuingCountry) {
      this.issuingCountry = issuingCountry;
      return this;
    }

    /**
     * Sets the {@code status} and returns a reference to this Builder enabling method chaining.
     *
     * @param status the {@code status} to set
     * @return a reference to this Builder
     */
    public Builder status(CardStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@code applePay} and returns a reference to this Builder enabling method chaining.
     *
     * @param applePay the {@code applePay} to set
     * @return a reference to this Builder
     */
    public Builder applePay(ApplePayTokenDetails applePay) {
      this.applePay = applePay;
      return this;
    }

    /**
     * Sets the {@code tokenType} and returns a reference to this Builder enabling method chaining.
     *
     * @param tokenType the {@code tokenType} to set
     * @return a reference to this Builder
     */
    public Builder tokenType(String tokenType) {
      this.tokenType = tokenType;
      return this;
    }

    /**
     * Sets the {@code networkToken} and returns a reference to this Builder enabling method chaining.
     *
     * @param networkToken the {@code networkToken} to set
     * @return a reference to this Builder
     */
    public Builder networkToken(ExternalNetworkTokenRequest networkToken) {
      this.networkToken = networkToken;
      return this;
    }

    /**
     * Sets the {@code skrill} and returns a reference to this Builder enabling method chaining.
     *
     * @param skrill the {@code skrill} to set
     * @return a reference to this Builder
     */
    public Builder skrill(Skrill skrill) {
      this.skrill = skrill;
      return this;
    }

    /**
     * Sets the {@code gatewayResponse} and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayResponse the {@code gatewayResponse} to set
     * @return a reference to this Builder
     */
    public Builder gatewayResponse(SkrillPaymentGatewayResponse gatewayResponse) {
      this.gatewayResponse = gatewayResponse;
      return this;
    }

    /**
     * Sets the {@code neteller} and returns a reference to this Builder enabling method chaining.
     *
     * @param neteller the {@code neteller} to set
     * @return a reference to this Builder
     */
    public Builder neteller(Neteller neteller) {
      this.neteller = neteller;
      return this;
    }

    /**
     * Sets the {@code payPal} and returns a reference to this Builder enabling method chaining.
     *
     * @param payPal the {@code payPal} to set
     * @return a reference to this Builder
     */
    public Builder payPal(Paypal payPal) {
      this.payPal = payPal;
      return this;
    }

    /**
     * Sets the {@code returnLinks} and returns a reference to this Builder enabling method chaining.
     *
     * @param returnLinks the {@code returnLinks} to set
     * @return a reference to this Builder
     */
    public Builder returnLinks(List<ReturnLink> returnLinks) {
      this.returnLinks = returnLinks;
      return this;
    }

    /**
     * Sets the {@code venmo} and returns a reference to this Builder enabling method chaining.
     *
     * @param venmo the {@code venmo} to set
     * @return a reference to this Builder
     */
    public Builder venmo(Venmo venmo) {
      this.venmo = venmo;
      return this;
    }

    /**
     * Sets the {@code vippreferred} and returns a reference to this Builder enabling method chaining.
     *
     * @param vippreferred the {@code vippreferred} to set
     * @return a reference to this Builder
     */
    public Builder vippreferred(Vippreferred vippreferred) {
      this.vippreferred = vippreferred;
      return this;
    }

    /**
     * Sets the {@code mazooma} and returns a reference to this Builder enabling method chaining.
     *
     * @param mazooma the {@code mazooma} to set
     * @return a reference to this Builder
     */
    public Builder mazooma(Mazooma mazooma) {
      this.mazooma = mazooma;
      return this;
    }

    /**
     * Sets the {@code sightline} and returns a reference to this Builder enabling method chaining.
     *
     * @param sightline the {@code sightline} to set
     * @return a reference to this Builder
     */
    public Builder sightline(Sightline sightline) {
      this.sightline = sightline;
      return this;
    }

    /**
     * Sets the {@code interacETransfer} and returns a reference to this Builder enabling method chaining.
     *
     * @param interacETransfer the {@code interacETransfer} to set
     * @return a reference to this Builder
     */
    public Builder interacETransfer(Interac interacETransfer) {
      this.interacETransfer = interacETransfer;
      return this;
    }

    /**
     * Sets the {@code browserDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param browserDetails the {@code browserDetails} to set
     * @return a reference to this Builder
     */
    public Builder browserDetails(BrowserDetails browserDetails) {
      this.browserDetails = browserDetails;
      return this;
    }

    /**
     * Sets the {@code deviceDetails} and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceDetails the {@code deviceDetails} to set
     * @return a reference to this Builder
     */
    public Builder deviceDetails(DeviceDetails deviceDetails) {
      this.deviceDetails = deviceDetails;
      return this;
    }

    /**
     * Sets the {@code rapidTransfer} and returns a reference to this Builder enabling method chaining.
     *
     * @param rapidTransfer the {@code rapidTransfer} to set
     * @return a reference to this Builder
     */
    public Builder rapidTransfer(RapidTransfer rapidTransfer) {
      this.rapidTransfer = rapidTransfer;
      return this;
    }

    /**
     * Sets the {@code skrill1Tap} and returns a reference to this Builder enabling method chaining.
     *
     * @param skrill1Tap the {@code skrill1Tap} to set
     * @return a reference to this Builder
     */
    public Builder skrill1Tap(Skrill1Tap skrill1Tap) {
      this.skrill1Tap = skrill1Tap;
      return this;
    }

    /**
     * Sets the {@code ach} and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the {@code ach} to set
     * @return a reference to this Builder
     */
    public Builder ach(Ach ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Sets the {@code eft} and returns a reference to this Builder enabling method chaining.
     *
     * @param eft the {@code eft} to set
     * @return a reference to this Builder
     */
    public Builder eft(Eft eft) {
      this.eft = eft;
      return this;
    }

    /**
     * Sets the {@code dupCheck} and returns a reference to this Builder enabling method chaining.
     *
     * @param dupCheck the {@code dupCheck} to set
     * @return a reference to this Builder
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * Sets the {@code bacs} and returns a reference to this Builder enabling method chaining.
     *
     * @param bacs the {@code bacs} to set
     * @return a reference to this Builder
     */
    public Builder bacs(Bacs bacs) {
      this.bacs = bacs;
      return this;
    }

    /**
     * Sets the {@code mandates} and returns a reference to this Builder enabling method chaining.
     *
     * @param mandates the {@code mandates} to set
     * @return a reference to this Builder
     */
    public Builder mandates(List<Mandate> mandates) {
      this.mandates = mandates;
      return this;
    }

    /**
     * Sets the {@code sepa} and returns a reference to this Builder enabling method chaining.
     *
     * @param sepa the {@code sepa} to set
     * @return a reference to this Builder
     */
    public Builder sepa(Sepa sepa) {
      this.sepa = sepa;
      return this;
    }

    /**
     * Returns a {@code StandaloneCreditPaymentInstrumentInner} built from the parameters previously set.
     *
     * @return a {@code StandaloneCreditPaymentInstrumentInner} built with parameters of this {@code StandaloneCreditPaymentInstrumentInner.Builder}
     */
    public StandaloneCreditPaymentInstrumentInner build() {
      return new StandaloneCreditPaymentInstrumentInner(this);
    }
  }
}

