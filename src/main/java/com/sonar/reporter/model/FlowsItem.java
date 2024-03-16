package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class FlowsItem {
    private List<LocationsItem> locations;
}