package com.sonar.reporter.model.response;

import com.sonar.reporter.model.ComponentsItem;
import com.sonar.reporter.model.FacetsItem;
import com.sonar.reporter.model.IssuesItem;
import com.sonar.reporter.model.Paging;
import com.sonar.reporter.model.RulesItem;
import com.sonar.reporter.model.UsersItem;
import lombok.Data;

import java.util.List;

@Data
public class IssueSearchResponse {
    private List<ComponentsItem> components;
    private Paging paging;
    private List<RulesItem> rules;
    private List<IssuesItem> issues;
    private List<UsersItem> users;
    private List<FacetsItem> facets;
}