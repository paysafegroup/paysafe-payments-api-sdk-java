// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StandaloneCreditUpdateRequest
 */
public class StandaloneCreditUpdateRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("interacEtransfer")
  private Interac interacEtransfer;

  public StandaloneCreditUpdateRequest() {
    super();
  }

  private StandaloneCreditUpdateRequest(Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setInteracEtransfer(builder.interacEtransfer);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StandaloneCreditUpdateRequest merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public StandaloneCreditUpdateRequest interacEtransfer(Interac interacEtransfer) {
    this.interacEtransfer = interacEtransfer;
    return this;
  }

  /**
   * Details of the interac E-Transfer used for the transaction.
   *
   * @return interacEtransfer
   */
  public Interac getInteracEtransfer() {
    return interacEtransfer;
  }

  public void setInteracEtransfer(Interac interacEtransfer) {
    this.interacEtransfer = interacEtransfer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StandaloneCreditUpdateRequest standaloneCreditUpdateRequest = (StandaloneCreditUpdateRequest) o;
    return Objects.equals(this.merchantRefNum, standaloneCreditUpdateRequest.merchantRefNum) &&
        Objects.equals(this.interacEtransfer, standaloneCreditUpdateRequest.interacEtransfer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, interacEtransfer);
  }

  @Override
  public String toString() {

    return "class StandaloneCreditUpdateRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    interacEtransfer: " + toIndentedString(interacEtransfer) + "\n"
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
   * {@code StandaloneCreditUpdateRequest} builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Interac interacEtransfer;

    private Builder() {
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
     * Sets the {@code interacEtransfer} and returns a reference to this Builder enabling method chaining.
     *
     * @param interacEtransfer the {@code interacEtransfer} to set
     * @return a reference to this Builder
     */
    public Builder interacEtransfer(Interac interacEtransfer) {
      this.interacEtransfer = interacEtransfer;
      return this;
    }

    /**
     * Returns a {@code StandaloneCreditUpdateRequest} built from the parameters previously set.
     *
     * @return a {@code StandaloneCreditUpdateRequest} built with parameters of this {@code StandaloneCreditUpdateRequest.Builder}
     */
    public StandaloneCreditUpdateRequest build() {
      return new StandaloneCreditUpdateRequest(this);
    }
  }
}

