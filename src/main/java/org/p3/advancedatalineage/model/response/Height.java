package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Height{
    public boolean infinite;
    public boolean naN;
}
