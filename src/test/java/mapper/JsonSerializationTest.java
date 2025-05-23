// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysafe.payments.config.ObjectMapperConfiguration;
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;

public class JsonSerializationTest {

  @Test
  void testMappingAdditionalParameters() throws JsonProcessingException {

    ObjectMapper objectMapper = ObjectMapperConfiguration.getObjectMapper();
    Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");

    Map<String, Object> additionalParameters = new LinkedHashMap<>();
    additionalParameters.put("thirdParameter", "value3");
    additionalParameters.put("fourthParameter", Address.builder().city("London").country("United Kingdom").phone("+2139243").build());

    PaymentHandleRequest paymentHandleRequest = PaymentHandleRequest.builder()
        .merchantRefNum("10000")
        .transactionType(TransactionType.PAYMENT)
        .accountId("5555")
        .putAdditionalParameter("firstParameter", "test")
        .putAdditionalParameter("secondParameter", map)
        .putAllAdditionalParameters(additionalParameters)
        .build();

    String actualJson = objectMapper.writeValueAsString(paymentHandleRequest);
    String expectedJson = "{"
        + "\"merchantRefNum\":\"10000\","
        + "\"transactionType\":\"PAYMENT\","
        + "\"accountId\":\"5555\","
        + "\"firstParameter\":\"test\","
        + "\"secondParameter\":{"
        + "\"key1\":\"value1\","
        + "\"key2\":\"value2\""
        + "},"
        + "\"thirdParameter\":\"value3\","
        + "\"fourthParameter\":{\"city\":\"London\",\"country\":\"United Kingdom\",\"phone\":\"+2139243\"}"
        + "}";

    JsonNode actualJsonNode = objectMapper.readTree(actualJson);
    JsonNode expectedJsonNode = objectMapper.readTree(expectedJson);
    assertEquals(expectedJsonNode, actualJsonNode);
  }
}
