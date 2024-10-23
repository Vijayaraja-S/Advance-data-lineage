package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Node;
import io.trino.sql.tree.WithQuery;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

import java.util.List;

public class WithQueryHandler implements CommonNode {
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final WithQuery withQuery;
  private final CommonNodeFactory commonNodeFactory;

  public WithQueryHandler(
          WithQuery withQuery,
          MetaDataCollector metaDataCollector,
          DefaultDirectedGraph<Object, DefaultEdge> graph, CommonNodeFactory commonNodeFactory) {
    this.withQuery = withQuery;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    List<Node> children = withQuery.getChildren();
    children.forEach(child -> {
      CommonNode node = commonNodeFactory.createNode(child, metaDataCollector, graph);
      node.accept();
    });

  }
}
