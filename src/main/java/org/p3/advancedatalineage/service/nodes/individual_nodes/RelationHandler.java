package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Relation;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNode;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNodeVisitor;

public class RelationHandler implements CommonNode {
  private final Relation relation;

  public RelationHandler(Relation relation, MetaDataCollector metaDataCollector) {
    this.relation = relation;
  }

  @Override
  public void accept(CommonNodeVisitor visitor) {
    processRelation(relation);
    visitor.visit(this);
  }

  private void processRelation(Relation relation) {
  }
}
