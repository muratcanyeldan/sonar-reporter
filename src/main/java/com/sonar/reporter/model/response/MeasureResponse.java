package com.sonar.reporter.model.response;

import com.sonar.reporter.model.Component;
import com.sonar.reporter.model.MetricsItem;
import com.sonar.reporter.model.Period;
import lombok.Data;

import java.util.List;

@Data
public class MeasureResponse {
    private Component component;
    private Period period;
    private List<MetricsItem> metrics;
}