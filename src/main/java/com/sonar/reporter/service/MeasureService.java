package com.sonar.reporter.service;

import com.sonar.reporter.constants.SonarAPIConstants;
import com.sonar.reporter.model.request.GetMeasuresRequest;
import com.sonar.reporter.model.response.MeasureResponse;
import com.sonar.reporter.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MeasureService {

    private final RestClient restClient;

    public MeasureResponse getMeasures(GetMeasuresRequest getMeasuresRequest) {
        Map<String, String> queryParams = new HashMap<>();
        RequestUtil.addItemToQueryParameters("component", getMeasuresRequest.getComponent(), queryParams);
        RequestUtil.addItemToQueryParameters("metricKeys", getMeasuresRequest.getMetricKeys(), queryParams);

        return restClient.get()
                .uri(SonarAPIConstants.API_MEASURE_COMPONENT, queryParams)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(MeasureResponse.class);
    }
}
