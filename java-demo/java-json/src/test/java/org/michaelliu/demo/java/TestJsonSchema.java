package org.michaelliu.demo.java;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.JsonLoader;

import java.io.IOException;

/**
 * Created by Michael on 2016/10/26.
 */
public class TestJsonSchema {

//    private void testCreateJsonSchema() {
//        JsonSchemaFactory schemaFactory = new JsonSchemaV4Factory();
//        schemaFactory.setAutoPutDollarSchema(true);
//        JsonNode accountSchema = schemaFactory.createSchema(AccountForm.class);
//        System.out.println(accountSchema);
//    }

    /**
     * daveclayton/json-schema-validator
     */
    private void testValidateJSONSchema1() {
        try {
            String rawSchema = "{\n" +
                    "    \"id\": \"http://some.site.somewhere/entry-schema#\",\n" +
                    "    \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                    "    \"description\": \"student form\",\n" +
                    "    \"type\": \"object\",\n" +
                    "    \"required\": [\n" +
                    "        \"id\",\n" +
                    "        \"name\"\n" +
                    "    ],\n" +
                    "    \"properties\": {\n" +
                    "        \"id\": {\n" +
                    "            \"labelName\": \"student id\",\n" +
                    "            \"component\": \"TEXT\",\n" +
                    "            \"type\": \"INTEGER\",\n" +
                    "            \"minimum\": 0\n" +
                    "        },\n" +
                    "        \"name\": {\n" +
                    "            \"labelName\": \"student name\",\n" +
                    "            \"component\": \"TEXT\",\n" +
                    "            \"type\": \"STRING\",\n" +
                    "            \"pattern\": \"^[a-zA-Z]+$\"\n" +
                    "        },\n" +
                    "        \"age\": {\n" +
                    "            \"labelName\": \"student age\",\n" +
                    "            \"component\": \"TEXT\",\n" +
                    "            \"type\": \"INTEGER\",\n" +
                    "            \"minimum\": 18\n" +
                    "        },\n" +
                    "        \"gender\": {\n" +
                    "            \"labelName\": \"student gender\",\n" +
                    "            \"component\": \"TEXT\",\n" +
                    "            \"type\": \"INTEGER\",\n" +
                    "            \"enum\": [0, 1]\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            String rawData = "{\n" +
                    "    \"id\":10086,\n" +
                    "    \"name\": \"michael\",\n" +
                    "    \"age\": 22,\n" +
                    "    \"gender\": 0\n" +
                    "}";
            final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            final JsonSchema schema = factory.getJsonSchema(JsonLoader.fromString(rawSchema));
            final JsonNode data = JsonLoader.fromString(rawData);
            ProcessingReport report = schema.validate(data);
            System.out.println(report);
        } catch (IOException | ProcessingException e) {
            System.out.println(e);
        }
    }

//    /**
//     * everit-org/json-schema
//     */
//    private void testValidateJSONSchema2() {
//        try {
//            String rawSchema = "{\n" +
//                    "    \"id\": \"http://some.site.somewhere/entry-schema#\",\n" +
//                    "    \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
//                    "    \"description\": \"student form\",\n" +
//                    "    \"type\": \"object\",\n" +
//                    "    \"required\": [\n" +
//                    "        \"id\",\n" +
//                    "        \"name\"\n" +
//                    "    ],\n" +
//                    "    \"properties\": {\n" +
//                    "        \"id\": {\n" +
//                    "            \"labelName\": \"student id\",\n" +
//                    "            \"component\": \"TEXT\",\n" +
//                    "            \"type\": \"INTEGER\",\n" +
//                    "            \"minimum\": 0\n" +
//                    "        },\n" +
//                    "        \"name\": {\n" +
//                    "            \"labelName\": \"student name\",\n" +
//                    "            \"component\": \"TEXT\",\n" +
//                    "            \"type\": \"STRING\",\n" +
//                    "            \"pattern\": \"^[a-zA-Z]+$\"\n" +
//                    "        },\n" +
//                    "        \"age\": {\n" +
//                    "            \"labelName\": \"student age\",\n" +
//                    "            \"component\": \"TEXT\",\n" +
//                    "            \"type\": \"INTEGER\",\n" +
//                    "            \"minimum\": 18\n" +
//                    "        },\n" +
//                    "        \"gender\": {\n" +
//                    "            \"labelName\": \"student gender\",\n" +
//                    "            \"component\": \"TEXT\",\n" +
//                    "            \"type\": \"INTEGER\",\n" +
//                    "            \"enum\": [0, 1]\n" +
//                    "        }\n" +
//                    "    }\n" +
//                    "}";
//            JSONObject schemaJson = new JSONObject(rawSchema);
//            Schema schema = SchemaLoader.load(schemaJson);
//
//            String rawData = "{\n" +
//                    "    \"id\":10086,\n" +
//                    "    \"name\": \"michael\",\n" +
//                    "    \"age\": 22,\n" +
//                    "    \"gender\": 0\n" +
//                    "}";
//
//            // need to jdk 1.8, otherwise throw UnsupportedClassVersionError
//            schema.validate(new JSONObject(rawData));
//            System.out.println("JSON Schema Validation passed!");
//        } catch (ValidationException e) {
//            System.out.println(e);
//        }
//    }

    public static void main(String[] args) {
        new TestJsonSchema().testValidateJSONSchema1();
//        new TestJsonSchema().testValidateJSONSchema2();
    }
}
