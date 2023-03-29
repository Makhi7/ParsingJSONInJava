package com.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Json {
//    class to process everything

    private static ObjectMapper objectMapper = getDefObjectMapper();

    private static ObjectMapper getDefObjectMapper(){
        ObjectMapper defObjectMapper = new ObjectMapper();
        defObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defObjectMapper;
    }

    public static JsonNode parse(String src) throws JsonProcessingException {

        return objectMapper.readTree(src);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {

        return objectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object a){
        return objectMapper.valueToTree(a);
    }
}
