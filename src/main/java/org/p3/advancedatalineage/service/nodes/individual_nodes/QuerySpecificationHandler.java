package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Node;
import io.trino.sql.tree.QuerySpecification;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

import java.util.List;

public class QuerySpecificationHandler implements CommonNode {
  private final QuerySpecification querySpecification;
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;

  public QuerySpecificationHandler(
      QuerySpecification querySpecification,
      MetaDataCollector metaDataCollector,
      DefaultDirectedGraph<Object, DefaultEdge> graph,
      CommonNodeFactory commonNodeFactory) {
    this.querySpecification = querySpecification;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    List<Node> children = querySpecification.getChildren();
    children.forEach(child -> {
      CommonNode node = commonNodeFactory.createNode(child, metaDataCollector, graph);
      node.accept();
    });
  }
}
