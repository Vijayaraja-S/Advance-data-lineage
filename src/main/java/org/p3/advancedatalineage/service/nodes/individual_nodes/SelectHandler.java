package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.*;
import java.util.Optional;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.model.metadata_beans.ColumnInfos;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

public class SelectHandler implements CommonNode {
  private final Select select;
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;

  public SelectHandler(
      Select select,
      MetaDataCollector metaDataCollector,
      DefaultDirectedGraph<Object, DefaultEdge> graph,
      CommonNodeFactory commonNodeFactory) {
    this.select = select;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    processSelectNode(select);
  }

  private void processSelectNode(Select selectNode) {
    selectNode
        .getSelectItems()
        .forEach(
            selectItem -> {
              if (selectItem instanceof SingleColumn singleColumn) {
                processSingleColumn(singleColumn);
              } else if (selectItem instanceof AllColumns allColumns) {
                //
              } else {
                throw new IllegalArgumentException("Unsupported select item: " + selectItem);
              }
            });
  }

  void processSingleColumn(SingleColumn singleColumn) {
    final Optional<Identifier> alias = singleColumn.getAlias();
    ColumnInfos column = ColumnInfos.builder().build();
    column.setColumnAliasName(alias.isPresent() ? String.valueOf(alias.get()) : "");
    if (singleColumn.getExpression() instanceof DereferenceExpression dereferenceExpression) {
//      saveColumDetails(dereferenceExpression, column);
    } else {
//      checkNode(singleColumn.getExpression());
    }
  }
}
