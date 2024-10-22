package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import org.p3.advancedatalineage.model.metadata_beans.ColumnInfos;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNode;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNodeVisitor;

public class SelectHandler implements CommonNode {
  private final Select select;

  private Map<String, LinkedList<ColumnInfos>> columInfos = new LinkedHashMap<>();
  

  public SelectHandler(Select select, MetaDataCollector metaDataCollector) {
    this.select = select;
  }

  @Override
  public void accept(CommonNodeVisitor visitor) {
    processSelectNode(select);
    visitor.visit(this);
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
    Expression expression = singleColumn.getExpression();
  }


}
