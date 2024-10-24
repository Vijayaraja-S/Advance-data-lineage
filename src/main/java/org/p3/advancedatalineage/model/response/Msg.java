package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Msg{
    public String errorMessage;
    public String errorType;
    public String coordinate;
    public int occurrencesNumber;
    public String originCoordinate;
}
