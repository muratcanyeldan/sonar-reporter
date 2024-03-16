package com.sonar.reporter.model;

import lombok.Data;

import java.util.List;

@Data
public class LocationsItem {
    private String msg;
    private TextRange textRange;
    private List<MsgFormattingsItem> msgFormattings;
}