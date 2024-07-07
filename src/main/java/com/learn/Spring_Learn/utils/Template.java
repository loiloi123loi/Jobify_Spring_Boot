package com.learn.Spring_Learn.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Template {
    public static Map<String, Object> createResponse(String message, Map<String, ?> result) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("message", message);
        map.put("result", result);
        return map;
    }

    public static Map<String, Object> createResponse(String message) {
        return createResponse(message, new HashMap<>());
    }
}
