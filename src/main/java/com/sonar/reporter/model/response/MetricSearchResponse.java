package com.sonar.reporter.model.response;

import com.sonar.reporter.model.MetricsItem;
import com.sonar.reporter.model.Paging;
import lombok.Data;

import java.util.List;

@Data
public class MetricSearchResponse {
    private Paging paging;
    private List<MetricsItem> metrics;
}