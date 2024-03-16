package com.sonar.reporter.model;

import lombok.Data;

@Data
public class MsgFormattingsItem {
    private int start;
    private int end;
    private String type;
}