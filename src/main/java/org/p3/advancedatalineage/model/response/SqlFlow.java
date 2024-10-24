package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SqlFlow {
    public DbObjs dbobjs;
    public List<Relationship> relationships;
    public List<Object> processes;
    public List<Error> errors;
}
