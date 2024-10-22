package org.p3.advancedatalineage.model.metadata_beans;

import java.util.UUID;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ColumnInfos {
    @Builder.Default private String id ="";
    private UUID referenceId;
    @Builder.Default private String columnName="";
    @Builder.Default private String columnAliasName="";
    @Builder.Default private String columnSource = "DEFAULT_TABLE";
}
