package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schema{
    public String name;
    public List<Table> tables;
    public List<Other> others;
}
