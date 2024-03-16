package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class IssuesItem {
    private String updateDate;
    private int line;
    private String project;
    private String rule;
    private String effort;
    private String ruleDescriptionContextKey;
    private List<String> transitions;
    private String cleanCodeAttribute;
    private String issueStatus;
    private List<FlowsItem> flows;
    private Attr attr;
    private String key;
    private List<CommentsItem> comments;
    private String author;
    private String cleanCodeAttributeCategory;
    private List<MessageFormattingsItem> messageFormattings;
    private List<ImpactsItem> impacts;
    private String message;
    private String creationDate;
    private boolean quickFixAvailable;
    private List<String> tags;
    private List<String> codeVariants;
    private String component;
    private TextRange textRange;
    private List<String> actions;
    private String hash;
}