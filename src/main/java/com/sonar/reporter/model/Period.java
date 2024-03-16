package com.sonar.reporter.model;

import lombok.Data;

@Data
public class Period {
    private String mode;
    private String date;
    private String parameter;
    private boolean bestValue;
    private String value;
}