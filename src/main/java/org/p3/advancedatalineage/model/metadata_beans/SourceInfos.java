package org.p3.advancedatalineage.model.metadata_beans;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SourceInfos {
    private String sourceId;
    private String sourceName;
    private String sourceType;
}
