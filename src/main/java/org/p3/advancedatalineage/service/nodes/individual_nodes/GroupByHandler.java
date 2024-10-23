package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.GroupBy;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

public class GroupByHandler implements CommonNode {
  private final GroupBy groupBy;
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;

  public GroupByHandler(
          GroupBy groupBy,
          MetaDataCollector metaDataCollector,
          DefaultDirectedGraph<Object, DefaultEdge> graph, CommonNodeFactory commonNodeFactory) {
    this.groupBy = groupBy;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    processExpression(groupBy);
  }

  private void processExpression(GroupBy groupBy) {}
}
