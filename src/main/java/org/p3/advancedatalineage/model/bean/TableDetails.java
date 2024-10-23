package org.p3.advancedatalineage.model.bean;

import lombok.Data;

import java.util.List;

@Data
public class TableDetails {
    private String id;
    private String name;
    private String type;
    private List<ColumnDetails> columnInfos;
}
