package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class Component {
    private String path;
    private List<MeasuresItem> measures;
    private String qualifier;
    private String name;
    private String language;
    private String key;
}