package org.michaelliu.demo.java;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.reinert.jjschema.v1.JsonSchemaFactory;
import com.github.reinert.jjschema.v1.JsonSchemaV4Factory;
import org.michaelliu.demo.java.beans.AccountForm;

/**
 * Created by Michael on 2016/10/26.
 */
public class TestJsonSchema {

    public static void main(String[] args) {
        JsonSchemaFactory schemaFactory = new JsonSchemaV4Factory();
        schemaFactory.setAutoPutDollarSchema(true);
        JsonNode accountSchema = schemaFactory.createSchema(AccountForm.class);
        System.out.println(accountSchema);
    }
}
