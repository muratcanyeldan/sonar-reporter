package com.sonar.reporter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReporterService {

    public void sendMonthlyReport() {
        log.info("Sending monthly report");
    }
}
