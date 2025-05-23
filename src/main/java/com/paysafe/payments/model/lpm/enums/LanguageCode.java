// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The 2-character preferred language code for the consumer (e.g., AU, AT, BE, BR, CA, CH, CN, DE, ES, GB, FR, IT, NL, PL, PT, RU, or US.)  <br>
 * A five-character code is also valid for following languages (e.g: da_DK, he_IL, id_ID, ja_JP, no_NO, pt_BR, ru_RU, sv_SE, th_TH,
 * zh_CN, zh_HK, and zh_TW).
 */
public enum LanguageCode {
  AT("AT"),

  AU("AU"),

  BE("BE"),

  BR("BR"),

  CA("CA"),

  CH("CH"),

  CN("CN"),

  DE("DE"),

  ES("ES"),

  FR("FR"),

  GB("GB"),

  IT("IT"),

  NL("NL"),

  PL("PL"),

  PT("PT"),

  RU("RU"),

  US("US"),

  DA_DK("da_DK"),

  HE_IL("he_IL"),

  ID_ID("id_ID"),

  JA_JP("ja_JP"),

  NO_NO("no_NO"),

  PT_BR("pt_BR"),

  RU_RU("ru_RU"),

  SV_SE("sv_SE"),

  TH_TH("th_TH"),

  ZH_CN("zh_CN"),

  ZH_HK("zh_HK"),

  ZH_TW("zh_TW");

  private final String value;

  LanguageCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static LanguageCode fromValue(String value) {
    for (LanguageCode b : LanguageCode.values()) {
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