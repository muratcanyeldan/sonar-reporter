package com.sonar.reporter.controller;

import com.sonar.reporter.model.request.IssueSearchRequest;
import com.sonar.reporter.model.response.IssueSearchResponse;
import com.sonar.reporter.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/issue")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IssueSearchResponse> getProjectIssues(@RequestParam(name = "components", required = false) String components,
                                                                @RequestParam(name = "issueStatuses", required = false) String issueStatuses,
                                                                @RequestParam(name = "timeZone", required = false) String timeZone,
                                                                @RequestParam(name = "createdInLast", required = false) String createdInLast,
                                                                @RequestParam(name = "p", required = false) String p,
                                                                @RequestParam(name = "ps", required = false) String ps,
                                                                @RequestParam(name = "impactSeverities", required = false) String impactSeverities,
                                                                @RequestParam(name = "impactSoftwareQualities", required = false) String impactSoftwareQualities) {
        return new ResponseEntity<>(issueService.getProjectIssues(new IssueSearchRequest(components, issueStatuses, timeZone, createdInLast, p, ps, impactSeverities, impactSoftwareQualities)), HttpStatus.OK);
    }
}
