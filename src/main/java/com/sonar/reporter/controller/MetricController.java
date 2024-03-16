package com.sonar.reporter.controller;

import com.sonar.reporter.model.request.AvailableMetricRequest;
import com.sonar.reporter.model.response.MetricSearchResponse;
import com.sonar.reporter.service.MetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/metric")
@RequiredArgsConstructor
public class MetricController {

    private final MetricService metricService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MetricSearchResponse> getAvailableMetrics(@RequestParam(name = "p", required = false) String p,
                                                                    @RequestParam(name = "ps", required = false) String ps) {
        return new ResponseEntity<>(metricService.getAvailableMetrics(new AvailableMetricRequest(p, ps)), HttpStatus.OK);
    }
}
