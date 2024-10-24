package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Error{
    public String errorMessage;
    public String errorType;
    public List<Coordinate> coordinates;
    public List<OriginCoordinate> originCoordinates;
}
