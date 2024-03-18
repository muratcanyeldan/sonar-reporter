package com.sonar.reporter.model;

import lombok.Data;

@Data
public class DiffsItem {
    private String newValue;
    private String oldValue;
    private String key;
}
