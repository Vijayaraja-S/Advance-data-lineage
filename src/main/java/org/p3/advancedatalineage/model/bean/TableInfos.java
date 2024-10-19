package org.p3.advancedatalineage.model.bean;

import lombok.Data;

import java.util.List;

@Data
public class TableInfos {
    private String id;
    private String name;
    private String type;
    private List<ColumInfos> columnInfos;
}
