package com.sonar.reporter.service;

import com.sonar.reporter.constants.SonarAPIConstants;
import com.sonar.reporter.model.request.ProjectListRequest;
import com.sonar.reporter.model.response.ProjectSearchResponse;
import com.sonar.reporter.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final RestClient restClient;

    public ProjectSearchResponse getSonarProjects(ProjectListRequest projectListRequest) {

        Map<String, String> queryParams = new HashMap<>();
        RequestUtil.addItemToQueryParameters("p", projectListRequest.getP(), queryParams);
        RequestUtil.addItemToQueryParameters("ps", projectListRequest.getPs(), queryParams);
        RequestUtil.addItemToQueryParameters("q", projectListRequest.getQ(), queryParams);
        RequestUtil.addItemToQueryParameters("projects", projectListRequest.getProjects(), queryParams);

        return restClient.get()
                .uri(SonarAPIConstants.API_PROJECT_SEARCH, queryParams)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ProjectSearchResponse.class);
    }
}
