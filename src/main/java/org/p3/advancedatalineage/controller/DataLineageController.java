package org.p3.advancedatalineage.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.p3.advancedatalineage.model.DataflowRequest;
import org.p3.advancedatalineage.model.Result;
import org.p3.advancedatalineage.model.response.Root;
import org.p3.advancedatalineage.service.AdvanceDataLineageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataLineageController {
  private final AdvanceDataLineageService advanceDataLineageService;

  @PostMapping("/init")
  public Object initAdvanceLineageProcess(@RequestBody DataflowRequest dataflowRequest)
      throws Exception {
    Result<Object> objectResult =
        advanceDataLineageService.generateAdvanceLineageGraph(dataflowRequest);
    Object data = objectResult.getData();
    if (data instanceof String s) {
      Root root = new Gson().fromJson(s, Root.class);
      System.out.println(data);
    }
    return data;
  }
}
