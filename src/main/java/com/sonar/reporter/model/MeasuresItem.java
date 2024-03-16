package com.sonar.reporter.model;

import lombok.Data;

@Data
public class MeasuresItem {
    private String metric;
    private String value;
    private Period period;
}