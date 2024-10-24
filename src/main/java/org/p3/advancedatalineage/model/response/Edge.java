package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Edge{
    public String id;
    public String sourceId;
    public String targetId;
}
