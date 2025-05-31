package org.example.studyshop.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PartnerStatus {
  REGISTERED(0, "등록상태", "파트너 등록상태"),
  UNREGISTERED(1, "해지", "파트너 해지상태");

  private final int id;
  private final String title;
  private final String description;

}
