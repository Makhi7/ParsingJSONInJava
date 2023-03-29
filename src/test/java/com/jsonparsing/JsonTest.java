package com.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.jsonparsing.pojo.SimpleTestCaseJsonPojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simpleTestCaseJsonSource = "{ \"title\":\"Json Code Grind\", \"author\": \"Msholozi\"}";

    @org.junit.jupiter.api.Test
    void parse() throws JsonProcessingException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(),"Json Code Grind");
    }

    @Test
    void fromJson() throws JsonProcessingException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPojo pojo = Json.fromJson(node, SimpleTestCaseJsonPojo.class);
        assertEquals(pojo.getTitle(), "Json Code Grind");

    }

    @Test
    void toJson() {
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setTitle("Part two test");

        JsonNode node = Json.toJson(pojo);
        assertEquals(node.get("title").asText(),"Part two test");
    }

    @Test
    void stringfyNode() throws JsonProcessingException {
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setTitle("Part two test");

        JsonNode node = Json.toJson(pojo);

        System.out.println(Json.stringfyNode(node));
        System.out.println(Json.prettyPrintNode(node));
    }
}