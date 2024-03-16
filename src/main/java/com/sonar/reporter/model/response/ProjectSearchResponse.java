package com.sonar.reporter.model.response;

import com.sonar.reporter.model.ComponentsItem;
import com.sonar.reporter.model.Paging;
import lombok.Data;

import java.util.List;

@Data
public class ProjectSearchResponse {
    private List<ComponentsItem> components;
    private Paging paging;
}