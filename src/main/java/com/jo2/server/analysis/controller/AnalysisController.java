package com.jo2.server.analysis.controller;

import com.jo2.server.analysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnalysisController {
    private final AnalysisService analysisService;
}
