package org.michaelliu.demo.java.collection.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * Created by Michael on 2016/11/2.
 */
public class TestSetWithJson {

    private static void testJsonKey() {
        String json = "{\"a\":\"111\", \"b\": \"222\", \"c\": \"333\", \"d\": \"444\"}";
        JSONObject jo = JSON.parseObject(json);
        Set<String> keySet = jo.keySet();
//        Sets.newLin
        System.out.println(keySet);
    }

    public static void main(String[] args) {
        testJsonKey();
    }
}
