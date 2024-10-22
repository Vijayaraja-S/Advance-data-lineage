package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.GroupBy;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNode;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNodeVisitor;

public class GroupByHandler implements CommonNode {
    private final GroupBy groupBy;

    public GroupByHandler(GroupBy groupBy, MetaDataCollector metaDataCollector) {
        this.groupBy = groupBy;
    }

    @Override
    public void accept(CommonNodeVisitor visitor) {
        processExpression(groupBy);
        visitor.visit(this);
    }

    private void processExpression(GroupBy groupBy) {
        
    }

}
