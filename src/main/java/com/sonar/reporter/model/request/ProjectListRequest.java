package com.sonar.reporter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectListRequest {

    private String p;
    private String ps;
    private String q;
    private String projects;
}
