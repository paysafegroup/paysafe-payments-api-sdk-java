// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Map of CardBrand and its ThreeDsVersion.  Possible values for CardBrand are:
 * <ul>
 * <li> VI - Visa  </li>
 * <li> MC - MasterCard  </li>
 * <li> DI - Discover  </li>
 * <li> AM - American Express  </li>
 * <li> DC - Diners Club  </li>
 * <li> VE - Visa Electron  </li>
 * <li> MD - Maestro  </li>
 * </ul>
 * <p>
 * Possible values for ThreeDsVersion are:
 * <ul>
 * <li> SKIP_3DS  </li>
 * <li> THREE_D_S_ONE  </li>
 * <li> THREE_D_S_TWO  </li>
 * <li> EXTERNAL_3DS  </li>
 * </ul>
 */
public class ThreeDsVersionConfig {

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

  public ThreeDsVersionConfig() {
    super();
  }

  public ThreeDsVersionConfig VI(VIEnum VI) {
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

  public ThreeDsVersionConfig MC(MCEnum MC) {
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

  public ThreeDsVersionConfig DI(DIEnum DI) {
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

  public ThreeDsVersionConfig AM(AMEnum AM) {
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

  public ThreeDsVersionConfig DC(DCEnum DC) {
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

  public ThreeDsVersionConfig VE(VEEnum VE) {
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

  public ThreeDsVersionConfig MD(MDEnum MD) {
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
    ThreeDsVersionConfig threeDsVersionConfig = (ThreeDsVersionConfig) o;
    return Objects.equals(this.VI, threeDsVersionConfig.VI) &&
        Objects.equals(this.MC, threeDsVersionConfig.MC) &&
        Objects.equals(this.DI, threeDsVersionConfig.DI) &&
        Objects.equals(this.AM, threeDsVersionConfig.AM) &&
        Objects.equals(this.DC, threeDsVersionConfig.DC) &&
        Objects.equals(this.VE, threeDsVersionConfig.VE) &&
        Objects.equals(this.MD, threeDsVersionConfig.MD);
  }

  @Override
  public int hashCode() {
    return Objects.hash(VI, MC, DI, AM, DC, VE, MD);
  }

  @Override
  public String toString() {

    return "class ThreeDsVersionConfig {\n"
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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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
    SKIP_3DS("SKIP_3DS"),

    THREE_D_S_ONE("THREE_D_S_ONE"),

    THREE_D_S_TWO("THREE_D_S_TWO"),

    EXTERNAL_3DS("EXTERNAL_3DS");

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

