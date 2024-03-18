package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class IssuesItem {
    private String updateDate;
    private int line;
    private String rule;
    private String project;
    private String effort;
    private List<String> transitions;
    private String type;
    private String cleanCodeAttribute;
    private String issueStatus;
    private List<Object> flows;
    private String scope;
    private String key;
    private String severity;
    private List<Object> comments;
    private String author;
    private String cleanCodeAttributeCategory;
    private List<Object> messageFormattings;
    private List<ImpactsItem> impacts;
    private String message;
    private String creationDate;
    private boolean quickFixAvailable;
    private List<String> tags;
    private List<Object> codeVariants;
    private String component;
    private TextRange textRange;
    private String debt;
    private List<String> actions;
    private String hash;
    private String status;
}