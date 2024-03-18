package com.sonar.reporter.service;

import com.sonar.reporter.constants.SonarAPIConstants;
import com.sonar.reporter.model.IssueChangelogResponse;
import com.sonar.reporter.model.request.IssueSearchRequest;
import com.sonar.reporter.model.response.IssueSearchResponse;
import com.sonar.reporter.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final RestClient restClient;

    public IssueSearchResponse getProjectIssues(IssueSearchRequest issueSearchRequest) {

        Map<String, String> queryParams = new HashMap<>();
        RequestUtil.addItemToQueryParameters("components", issueSearchRequest.getComponents(), queryParams);
        RequestUtil.addItemToQueryParameters("issueStatuses", issueSearchRequest.getIssueStatuses(), queryParams);
        RequestUtil.addItemToQueryParameters("timeZone", issueSearchRequest.getTimeZone(), queryParams);
        RequestUtil.addItemToQueryParameters("createdInLast", issueSearchRequest.getCreatedInLast(), queryParams);
        RequestUtil.addItemToQueryParameters("p", issueSearchRequest.getP(), queryParams);
        RequestUtil.addItemToQueryParameters("ps", issueSearchRequest.getPs(), queryParams);
        RequestUtil.addItemToQueryParameters("impactSeverities", issueSearchRequest.getImpactSeverities(), queryParams);
        RequestUtil.addItemToQueryParameters("impactSoftwareQualities", issueSearchRequest.getImpactSoftwareQualities(), queryParams);
        RequestUtil.addItemToQueryParameters("s", issueSearchRequest.getS(), queryParams);
        RequestUtil.addItemToQueryParameters("asc", issueSearchRequest.getAsc(), queryParams);
        RequestUtil.addItemToQueryParameters("resolved", issueSearchRequest.getResolved(), queryParams);
        RequestUtil.addItemToQueryParameters("additionalFields", issueSearchRequest.getAdditionalFields(), queryParams);

        return restClient.get()
                .uri(RequestUtil.createURI(SonarAPIConstants.API_ISSUE_SEARCH, queryParams))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(IssueSearchResponse.class);
    }

    public IssueChangelogResponse getIssueChangelog(String issue) {

        Map<String, String> queryParams = new HashMap<>();
        RequestUtil.addItemToQueryParameters("issue", issue, queryParams);

        return restClient.get()
                .uri(RequestUtil.createURI(SonarAPIConstants.API_ISSUE_CHANGELOG, queryParams))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(IssueChangelogResponse.class);
    }
}
