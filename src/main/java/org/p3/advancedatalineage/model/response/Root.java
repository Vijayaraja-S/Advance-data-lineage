package org.p3.advancedatalineage.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@lombok.Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Root {
  public int code;
  public Data data;
  public List<Msg> msg;
}
