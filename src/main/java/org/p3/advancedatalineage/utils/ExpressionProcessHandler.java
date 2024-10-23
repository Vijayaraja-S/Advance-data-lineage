package org.p3.advancedatalineage.utils;

import io.trino.sql.tree.*;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ExpressionProcessHandler {
  public void processQueryObject(Node query) {
    final List<? extends Node> children = query.getChildren();
    for (Node child : children) {
      checkNode(child);
    }
  }

  private void checkNode(Node child) {
    if (child instanceof DereferenceExpression expression) {
//      processDereference(expression);
    } else if (child instanceof Identifier identifier) {
//      processIdentifier(identifier);
    } else {
      processQueryObject(child);
    }
  }
}
