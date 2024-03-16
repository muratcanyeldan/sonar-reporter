package com.sonar.reporter.controller;

import com.sonar.reporter.model.request.ProjectListRequest;
import com.sonar.reporter.model.response.ProjectSearchResponse;
import com.sonar.reporter.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectSearchResponse> getSonarProjects(@RequestParam(name = "p", required = false) String p,
                                                                  @RequestParam(name = "ps", required = false) String ps,
                                                                  @RequestParam(name = "q", required = false) String q,
                                                                  @RequestParam(name = "projects", required = false) String projects) {
        return new ResponseEntity<>(projectService.getSonarProjects(new ProjectListRequest(p, ps, q, projects)), HttpStatus.OK);
    }

}
