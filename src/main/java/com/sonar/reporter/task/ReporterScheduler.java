package com.sonar.reporter.task;

import com.sonar.reporter.service.ReporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReporterScheduler {

    private final ReporterService reporterService;

    @Scheduled(cron = "0 0 0 1 * *")
    public void scheduleMonthlyReport() {
        reporterService.sendMonthlyReport();
    }
}
