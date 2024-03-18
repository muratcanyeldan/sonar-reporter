package com.sonar.reporter.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectListRequest {

    private String p;
    private String ps;
    private String q;
    private String projects;
}
