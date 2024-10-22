package org.p3.advancedatalineage.service.nodes;

import io.trino.sql.tree.*;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.individual_nodes.ExpressionHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.GroupByHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.RelationHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.SelectHandler;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNode;
import org.springframework.stereotype.Component;

@Component
public class CommonNodeFactory {
    
    public CommonNode createNode(Node node, MetaDataCollector metaDataCollector) {
        if (node instanceof Select select) {
            return new SelectHandler(select,metaDataCollector);
        }else if(node instanceof Relation relation) {
            return new RelationHandler(relation,metaDataCollector);
        }else if(node instanceof Expression expression) {
            return new ExpressionHandler(expression,metaDataCollector);
        }else if (node instanceof GroupBy groupBy) {
            return new GroupByHandler(groupBy,metaDataCollector);
        }
        return null;
    }
}
