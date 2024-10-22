package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Expression;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNode;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNodeVisitor;

public class ExpressionHandler implements CommonNode {
  private final Expression expression;

  public ExpressionHandler(Expression expression, MetaDataCollector metaDataCollector) {
      this.expression = expression;
  }

  @Override
  public void accept(CommonNodeVisitor visitor) {
    processExpression(expression);
    visitor.visit(this);
  }

  private void processExpression(Expression expression) {

  }


}
