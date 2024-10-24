package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Label{
    public String content;
    public Height height;
    public Width width;
    public X x;
    public Y y;
}
