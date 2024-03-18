package com.sonar.reporter.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueSearchRequest {

    private String components;
    private String issueStatuses;
    private String timeZone;
    private String createdInLast;
    private String p;
    private String ps;
    private String impactSeverities;
    private String impactSoftwareQualities;
    private String s;
    private String asc;
    private String resolved;
    private String additionalFields;
}
