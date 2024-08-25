package com.jo2.server.analysis.dto;

public record AnalysisResponse(
        String result
) {
    public static AnalysisResponse from(String result) {
        return new AnalysisResponse(result);
    }
}
