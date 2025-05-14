// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSEl

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets bankNameCodes
 */
public enum BankNameCode {
  ACERTEMOS("ACERTEMOS"),

  ACCIONES_Y_VALORES("ACCIONES_Y_VALORES"),

  ACUENTA("ACUENTA"),

  AGENTE_NIUBIZ("AGENTE_NIUBIZ"),

  APUESTAS_CUCUTA_75("APUESTAS_CUCUTA_75"),

  APUESTAS_UNIDAS("APUESTAS_UNIDAS"),

  BANCO_DE_CREDITO("BANCO_DE_CREDITO"),

  BANCO_ESTADO("BANCO_ESTADO"),

  BANCO_ESTADO_EXPRESS("BANCO_ESTADO_EXPRESS"),

  BANCO_NACIONAL_DE_COSTA_RICA("BANCO_NACIONAL_DE_COSTA_RICA"),

  BANCO_RIPLEY("BANCO_RIPLEY"),

  BBVA_CONTINENTAL("BBVA_CONTINENTAL"),

  BRADESCO("BRADESCO"),

  CAJA_AREQUIPA("CAJA_AREQUIPA"),

  CAJA_HUANCAYO_PERU("CAJA_HUANCAYO_PERU"),

  CAJA_TACNA_PERU("CAJA_TACNA_PERU"),

  CAJA_TRUJILLO_PERU("CAJA_TRUJILLO_PERU"),

  CAJA_VECINA("CAJA_VECINA"),

  CREDIBANCO("CREDIBANCO"),

  DIMONEX("DIMONEX"),

  EFECTY("EFECTY"),

  EXPRESS_DE_LIDER("EXPRESS_DE_LIDER"),

  FULL_CARGA("FULL_CARGA"),

  GANA("GANA"),

  GANA_GANA("GANA_GANA"),

  INTERBANK("INTERBANK"),

  JER("JER"),

  KASNET("KASNET"),

  LA_PERLA("LA_PERLA"),

  LIDER("LIDER"),

  LOTERICAS("LOTERICAS"),

  MOVILRED_COLOMBIA("MOVILRED_COLOMBIA"),

  PAGA_TODO_PARA_TODO("PAGA_TODO_PARA_TODO"),

  PUNTO_DE_PAGO("PUNTO_DE_PAGO"),

  PUNTO_RED("PUNTO_RED"),

  REDEBAN("REDEBAN"),

  SCOTIABANK("SCOTIABANK"),

  SUCHANCE("SUCHANCE"),

  SURED("SURED"),

  TAMBO("TAMBO"),

  WALMART_CHILE("WALMART_CHILE"),

  WESTERN_UNION("WESTERN_UNION");

  private final String value;

  BankNameCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static BankNameCode fromValue(String value) {
    for (BankNameCode b : BankNameCode.values()) {
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