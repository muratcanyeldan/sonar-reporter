package com.sonar.reporter.controller;

import com.sonar.reporter.model.request.GetMeasuresRequest;
import com.sonar.reporter.model.response.MeasureResponse;
import com.sonar.reporter.service.MeasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/measure")
@RequiredArgsConstructor
public class MeasureController {

    private final MeasureService measureService;

    @GetMapping(value = "/component", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MeasureResponse> getMeasures(@RequestParam(name = "component") String component,
                                                       @RequestParam(name = "metricKeys") String metricKeys) {
        return new ResponseEntity<>(measureService.getMeasures(new GetMeasuresRequest(component, metricKeys)), HttpStatus.OK);
    }
}
