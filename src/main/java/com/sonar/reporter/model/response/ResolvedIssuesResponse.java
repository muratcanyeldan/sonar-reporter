package com.sonar.reporter.model.response;

import com.sonar.reporter.model.IssuesItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedIssuesResponse {
    private List<IssuesItem> issuesList;
    private int pageCount;
}
