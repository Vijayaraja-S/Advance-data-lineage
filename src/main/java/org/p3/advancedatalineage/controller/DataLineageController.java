package org.p3.advancedatalineage.controller;

import lombok.RequiredArgsConstructor;
import org.p3.advancedatalineage.service.AdvanceDataLineageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataLineageController {
  private final AdvanceDataLineageService advanceDataLineageService;

  @PostMapping("/init/{query}")
  public String initAdvanceLineageProcess(@PathVariable  String query) {
     advanceDataLineageService.generateAdvanceLineageGraph(query);
     return "";
  }
}
