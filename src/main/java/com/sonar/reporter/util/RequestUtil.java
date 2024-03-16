package com.sonar.reporter.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Slf4j
public class RequestUtil {

    private RequestUtil() {
    }

    public static URI createURI(String baseUrl, String serviceURI, Map<String, String> queryParams) {
        StringBuilder url = new StringBuilder(baseUrl);
        url.append(serviceURI);
        if (!queryParams.isEmpty()) {
            url.append("?");
        }
        queryParams.forEach((key, value) -> url.append(key).append("=").append(value).append("&"));
        URI uri = null;
        try {
            uri = new URI(StringUtils.chop(url.toString()));
        } catch (URISyntaxException e) {
            log.error("createURI error " + serviceURI + " " + e.getMessage());
        }
        return uri;
    }

    public static URI createURI(String baseUrl, String serviceURI) {
        StringBuilder url = new StringBuilder(baseUrl);
        url.append(serviceURI);
        URI uri = null;
        try {
            uri = new URI(url.toString());
        } catch (URISyntaxException e) {
            log.error("createURI error" + serviceURI + " " + e.getMessage());
        }
        return uri;
    }

    public static HttpHeaders buildHttpHeaders(HttpServletRequest request, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        return headers;
    }

    public static void addItemToQueryParameters(String key, String value, Map<String, String> queryParameters) {
        if (value != null && !value.isEmpty()) {
            queryParameters.put(key, value);
        }
    }
}
