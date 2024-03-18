package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class ChangelogItem {
    private String creationDate;
    private List<DiffsItem> diffs;
    private boolean isUserActive;
    private String externalUser;
    private String avatar;
    private String userName;
    private String user;
    private String webhookSource;
}
