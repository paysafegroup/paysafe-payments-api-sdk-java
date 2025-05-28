// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Map of cardBrand and card type for CardType config.
 * Possible Values for the CardBrand are:
 * <ul>
 * <li> VI - Visa</li>
 * <li> MC - MasterCard</li>
 * <li> DI - Discover</li>
 * <li> AM - American Express </li>
 * <li> DC - Diners Club </li>
 * <li> VE - Visa Electron </li>
 * <li> MD - Maestro</li>
 * </ul>
 * Possible values for the CardType are:
 * <ul>
 * <li> CREDIT</li>
 * <li> DEBIT </li>
 * <li> BOTH </li>
 * <li> PREPAID </li>
 * <li> DEFERREDDEBIT</li>
 * </ul>
 */
public class CardTypeConfig {

  @JsonProperty("VI")
  private VIEnum VI;
  @JsonProperty("MC")
  private MCEnum MC;
  @JsonProperty("DI")
  private DIEnum DI;
  @JsonProperty("AM")
  private AMEnum AM;
  @JsonProperty("DC")
  private DCEnum DC;
  @JsonProperty("VE")
  private VEEnum VE;
  @JsonProperty("MD")
  private MDEnum MD;

  public CardTypeConfig() {
    super();
  }

  public CardTypeConfig VI(VIEnum VI) {
    this.VI = VI;
    return this;
  }

  /**
   * Get VI
   *
   * @return VI
   */
  public VIEnum getVI() {
    return VI;
  }

  public void setVI(VIEnum VI) {
    this.VI = VI;
  }

  public CardTypeConfig MC(MCEnum MC) {
    this.MC = MC;
    return this;
  }

  /**
   * Get MC
   *
   * @return MC
   */
  public MCEnum getMC() {
    return MC;
  }

  public void setMC(MCEnum MC) {
    this.MC = MC;
  }

  public CardTypeConfig DI(DIEnum DI) {
    this.DI = DI;
    return this;
  }

  /**
   * Get DI
   *
   * @return DI
   */
  public DIEnum getDI() {
    return DI;
  }

  public void setDI(DIEnum DI) {
    this.DI = DI;
  }

  public CardTypeConfig AM(AMEnum AM) {
    this.AM = AM;
    return this;
  }

  /**
   * Get AM
   *
   * @return AM
   */
  public AMEnum getAM() {
    return AM;
  }

  public void setAM(AMEnum AM) {
    this.AM = AM;
  }

  public CardTypeConfig DC(DCEnum DC) {
    this.DC = DC;
    return this;
  }

  /**
   * Get DC
   *
   * @return DC
   */
  public DCEnum getDC() {
    return DC;
  }

  public void setDC(DCEnum DC) {
    this.DC = DC;
  }

  public CardTypeConfig VE(VEEnum VE) {
    this.VE = VE;
    return this;
  }

  /**
   * Get VE
   *
   * @return VE
   */
  public VEEnum getVE() {
    return VE;
  }

  public void setVE(VEEnum VE) {
    this.VE = VE;
  }

  public CardTypeConfig MD(MDEnum MD) {
    this.MD = MD;
    return this;
  }

  /**
   * Get MD
   *
   * @return MD
   */
  public MDEnum getMD() {
    return MD;
  }

  public void setMD(MDEnum MD) {
    this.MD = MD;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardTypeConfig cardTypeConfig = (CardTypeConfig) o;
    return Objects.equals(this.VI, cardTypeConfig.VI) &&
        Objects.equals(this.MC, cardTypeConfig.MC) &&
        Objects.equals(this.DI, cardTypeConfig.DI) &&
        Objects.equals(this.AM, cardTypeConfig.AM) &&
        Objects.equals(this.DC, cardTypeConfig.DC) &&
        Objects.equals(this.VE, cardTypeConfig.VE) &&
        Objects.equals(this.MD, cardTypeConfig.MD);
  }

  @Override
  public int hashCode() {
    return Objects.hash(VI, MC, DI, AM, DC, VE, MD);
  }

  @Override
  public String toString() {

    return "class CardTypeConfig {\n"
        + "    VI: " + toIndentedString(VI) + "\n"
        + "    MC: " + toIndentedString(MC) + "\n"
        + "    DI: " + toIndentedString(DI) + "\n"
        + "    AM: " + toIndentedString(AM) + "\n"
        + "    DC: " + toIndentedString(DC) + "\n"
        + "    VE: " + toIndentedString(VE) + "\n"
        + "    MD: " + toIndentedString(MD) + "\n"
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
   * Gets or Sets VI
   */
  public enum VIEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBIT("DEFERREDDEBIT");

    private final String value;

    VIEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static VIEnum fromValue(String value) {
      for (VIEnum b : VIEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  /**
   * Gets or Sets MC
   */
  public enum MCEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBIT("DEFERREDDEBIT");

    private final String value;

    MCEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static MCEnum fromValue(String value) {
      for (MCEnum b : MCEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  /**
   * Gets or Sets DI
   */
  public enum DIEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBIT("DEFERREDDEBIT");

    private final String value;

    DIEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static DIEnum fromValue(String value) {
      for (DIEnum b : DIEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  /**
   * Gets or Sets AM
   */
  public enum AMEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBI("DEFERREDDEBI");

    private final String value;

    AMEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static AMEnum fromValue(String value) {
      for (AMEnum b : AMEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  /**
   * Gets or Sets DC
   */
  public enum DCEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBIT("DEFERREDDEBIT");

    private final String value;

    DCEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static DCEnum fromValue(String value) {
      for (DCEnum b : DCEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  /**
   * Gets or Sets VE
   */
  public enum VEEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBIT("DEFERREDDEBIT");

    private final String value;

    VEEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static VEEnum fromValue(String value) {
      for (VEEnum b : VEEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  /**
   * Gets or Sets MD
   */
  public enum MDEnum {
    CREDIT("CREDIT"),

    DEBIT("DEBIT"),

    BOTH("BOTH"),

    PREPAID("PREPAID"),

    DEFERREDDEBIT("DEFERREDDEBIT");

    private final String value;

    MDEnum(String value) {
      this.value = value;
    }

    @JsonCreator
    public static MDEnum fromValue(String value) {
      for (MDEnum b : MDEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }
}

