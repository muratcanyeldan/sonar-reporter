package com.sonar.reporter.model;

import lombok.Data;

@Data
public class TextRange {
    private int endLine;
    private int endOffset;
    private int startOffset;
    private int startLine;
}