package com.sonar.reporter.controller;

import com.sonar.reporter.service.ReporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/report")
@RequiredArgsConstructor
public class ReporterController {

    private final ReporterService reporterService;

    @GetMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> sendMonthlyReport() {
        reporterService.sendMonthlyReport();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
