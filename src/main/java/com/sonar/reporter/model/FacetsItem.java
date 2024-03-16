package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class FacetsItem {
    private List<ValuesItem> values;
    private String property;
}