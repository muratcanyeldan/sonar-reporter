package com.sonar.reporter.model;

import lombok.Data;

@Data
public class RulesItem {
    private String name;
    private String langName;
    private String lang;
    private String key;
    private String status;
}