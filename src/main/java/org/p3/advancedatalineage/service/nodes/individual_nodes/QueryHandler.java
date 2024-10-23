package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Node;
import io.trino.sql.tree.Query;
import java.util.List;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

public class QueryHandler implements CommonNode {
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;
  private Query query;

  public QueryHandler(
      Query query,
      MetaDataCollector metaDataCollector,
      DefaultDirectedGraph<Object, DefaultEdge> graph,
      CommonNodeFactory commonNodeFactory) {
    this.query = query;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    List<Node> children = query.getChildren();
    children.forEach(
        child -> {
          CommonNode node = commonNodeFactory.createNode(child, metaDataCollector, graph);
          node.accept();
        });
  }
}
