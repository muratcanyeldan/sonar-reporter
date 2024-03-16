package com.sonar.reporter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMeasuresRequest {

    private String component;
    private String metricKeys;
}
