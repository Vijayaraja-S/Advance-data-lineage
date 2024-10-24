package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coordinate{
    public int x;
    public int y;
    public String hashCode;
}
