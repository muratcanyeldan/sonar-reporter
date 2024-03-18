package com.sonar.reporter.service;

import com.sonar.reporter.constants.SonarAPIConstants;
import com.sonar.reporter.model.request.AvailableMetricRequest;
import com.sonar.reporter.model.response.MetricSearchResponse;
import com.sonar.reporter.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MetricService {

    private final RestClient restClient;

    public MetricSearchResponse getAvailableMetrics(AvailableMetricRequest availableMetricRequest) {
        Map<String, String> queryParams = new HashMap<>();
        RequestUtil.addItemToQueryParameters("p", availableMetricRequest.getP(), queryParams);
        RequestUtil.addItemToQueryParameters("ps", availableMetricRequest.getPs(), queryParams);

        return restClient.get()
                .uri(RequestUtil.createURI(SonarAPIConstants.API_METRIC_SEARCH, queryParams))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(MetricSearchResponse.class);
    }
}
