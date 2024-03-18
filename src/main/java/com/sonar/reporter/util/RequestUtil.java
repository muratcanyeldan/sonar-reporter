package com.sonar.reporter.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class RequestUtil {

    private RequestUtil() {
    }

    public static void addItemToQueryParameters(String key, String value, Map<String, String> queryParameters) {
        if (value != null && !value.isEmpty()) {
            queryParameters.put(key, value);
        }
    }

    public static String createURI(String serviceURI, Map<String, String> queryParams) {
        StringBuilder url = new StringBuilder(serviceURI);
        if (!queryParams.isEmpty()) {
            url.append("?");
        }
        queryParams.forEach((key, value) -> url.append(key).append("=").append(value).append("&"));
        return url.toString();
    }
}
