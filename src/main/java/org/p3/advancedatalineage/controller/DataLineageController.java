package org.p3.advancedatalineage.controller;

import lombok.RequiredArgsConstructor;
import org.p3.advancedatalineage.model.DataflowRequest;
import org.p3.advancedatalineage.model.Result;
import org.p3.advancedatalineage.service.AdvanceDataLineageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataLineageController {
  private final AdvanceDataLineageService advanceDataLineageService;

  @PostMapping("/init")
  public Result<Object> initAdvanceLineageProcess(@RequestBody DataflowRequest dataflowRequest ) throws Exception {
     return  advanceDataLineageService.generateAdvanceLineageGraph(dataflowRequest);

  }
}
