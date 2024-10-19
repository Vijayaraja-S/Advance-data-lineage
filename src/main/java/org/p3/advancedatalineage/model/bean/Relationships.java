package org.p3.advancedatalineage.model.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Relationships {
    private String id;
    private String type;
    private String effectType;
    private TargetInfo targetInfo;
    private List<SourceInfo> sourceInfo;
}
