package com.sonar.reporter.model;

import lombok.Data;

@Data
public class CommentsItem {
    private String createdAt;
    private String markdown;
    private boolean updatable;
    private String login;
    private String key;
    private String htmlText;
}