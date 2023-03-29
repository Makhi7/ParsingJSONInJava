package com.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;


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

    //convert node to String
    public static String stringfyNode(JsonNode node) throws JsonProcessingException {

        return generateString(node, false);
    }

    //method to make converted node from string to be readable
    public static String prettyPrintNode(JsonNode node) throws JsonProcessingException {
        return generateString(node , true);
    }

    private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException{
        ObjectWriter objectWriter = objectMapper.writer();
        if(pretty){
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(node);
    }
}
