package com.sonar.reporter.model;

import lombok.Data;

@Data
public class ComponentsItem {
    private String visibility;
    private boolean managed;
    private String qualifier;
    private String name;
    private String lastAnalysisDate;
    private String key;
    private String revision;
}