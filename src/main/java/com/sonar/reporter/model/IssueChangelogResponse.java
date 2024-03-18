package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class IssueChangelogResponse {
    private List<ChangelogItem> changelog;
}
