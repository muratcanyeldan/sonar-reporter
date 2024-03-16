package com.sonar.reporter.model;

import lombok.Data;

@Data
public class UsersItem {
    private String name;
    private boolean active;
    private String avatar;
    private String login;
}