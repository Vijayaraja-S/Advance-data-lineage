package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Relation;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

public class RelationHandler implements CommonNode {
  private final Relation relation;
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;

  public RelationHandler(
          Relation relation,
          MetaDataCollector metaDataCollector,
          DefaultDirectedGraph<Object, DefaultEdge> graph, CommonNodeFactory commonNodeFactory) {
    this.relation = relation;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    processRelation(relation);
  }

  private void processRelation(Relation relation) {

  }
}
