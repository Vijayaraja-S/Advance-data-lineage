package org.p3.advancedatalineage.model.metadata_beans;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class SchemaInfos {
    private String id;
    private UUID referenceId;
    private String schemaName;
}
