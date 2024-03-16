package com.sonar.reporter.model;

import lombok.Data;

@Data
public class ImpactsItem {
    private String severity;
    private String softwareQuality;
}