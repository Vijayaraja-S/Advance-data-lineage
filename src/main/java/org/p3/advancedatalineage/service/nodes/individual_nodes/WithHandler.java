package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Node;
import io.trino.sql.tree.With;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

import java.util.List;

public class WithHandler implements CommonNode {
  private final With with;
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;

  public WithHandler(
          With with,
          MetaDataCollector metaDataCollector,
          DefaultDirectedGraph<Object, DefaultEdge> graph, CommonNodeFactory commonNodeFactory) {
    this.with = with;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    List<? extends Node> children = with.getChildren();
    children.forEach(child -> {
      CommonNode node = commonNodeFactory.createNode(child, metaDataCollector, graph);
      node.accept();
    });

  }
}
