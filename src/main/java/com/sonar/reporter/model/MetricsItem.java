package com.sonar.reporter.model;

import lombok.Data;

@Data
public class MetricsItem {
    private boolean hidden;
    private boolean qualitative;
    private String domain;
    private boolean custom;
    private String name;
    private String description;
    private String id;
    private String type;
    private String key;
    private int direction;
}