package org.p3.advancedatalineage.model.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TargetInfo {
    private String id;
    private String column;
    private String parentId;
    private String parentName;
}
