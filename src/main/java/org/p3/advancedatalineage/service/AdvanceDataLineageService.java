package org.p3.advancedatalineage.service;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.dlineage.DataFlowAnalyzer;
import gudusoft.gsqlparser.dlineage.dataflow.model.Option;
import gudusoft.gsqlparser.dlineage.dataflow.model.RelationshipType;
import gudusoft.gsqlparser.dlineage.dataflow.model.xml.dataflow;
import gudusoft.gsqlparser.dlineage.graph.DataFlowGraphGenerator;
import gudusoft.gsqlparser.dlineage.util.DataflowUtility;
import java.util.ArrayList;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.p3.advancedatalineage.model.DataflowRequest;
import org.p3.advancedatalineage.model.Result;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvanceDataLineageService {
  private final CommonNodeFactory nodeFactory;

  private final MetaDataCollector metaDataCollector;

  public Result<Object> generateAdvanceLineageGraph(DataflowRequest req) throws Exception {
    Option option = new Option();
    option.setVendor(EDbVendor.valueOf(req.getDbVendor()));
    option.setSimpleOutput(false);
    option.setIgnoreRecordSet(false);
    option.filterRelationTypes("fdd,fddi,frd,fdr".split(","));
    option.setLinkOrphanColumnToFirstTable(true);
    option.setOutput(false);
    option.setSimpleShowFunction(req.isSimpleShowFunction());
    option.setShowConstantTable(req.isShowConstantTable());
    option.setTransform(req.isShowTransform());
    option.setTransformCoordinate(req.isShowTransform());
    option.setShowCountTableColumn(true);
    if (Objects.nonNull(req.getShowResultSetTypes())) {
      option.showResultSetTypes(req.getShowResultSetTypes().split(","));
      option.setIgnoreRecordSet(true);
      option.setSimpleOutput(false);
    }
    DataFlowAnalyzer analyzer = new DataFlowAnalyzer(req.getSqlText(), option);
    analyzer.generateDataFlow(true);
    dataflow dataflow = analyzer.getDataFlow();
    if (req.isIgnoreRecordSet() && Objects.isNull(req.getShowResultSetTypes())) {
      analyzer = new DataFlowAnalyzer("", option.getVendor(), false);
      analyzer.setIgnoreRecordSet(req.isIgnoreRecordSet());
      analyzer.getOption().setShowERDiagram(true);
      ArrayList types = new ArrayList();
      types.add(RelationshipType.fdd.name());
      types.add(RelationshipType.fdr.name());
      dataflow = analyzer.getSimpleDataflow(dataflow, false, types);
    }
    if (req.isTableLevel()) {
      dataflow = DataflowUtility.convertToTableLevelDataflow(dataflow);
    }
    if (dataflow.getRelationships().size() > 2000) {
      return Result.error(
          500, "More than 2,000 relationships, the front end can not be displayed!");
    }
    DataFlowGraphGenerator generator = new DataFlowGraphGenerator();
    String result = generator.genDlineageGraph(option.getVendor(), req.isIndirect(), dataflow);
    return Result.success(result);
  }
}
