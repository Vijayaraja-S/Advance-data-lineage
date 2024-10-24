package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Relationship{
    public String id;
    public String type;
    public String effectType;
    public Target target;
    public List<Source> sources;
    public String function;
}
