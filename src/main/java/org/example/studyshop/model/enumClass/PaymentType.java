package org.example.studyshop.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
  CARD(0, "카드", "신용카드"),
  BANK(1, "무통장입금", "무통장입금"),
  ETC(2, "기타", "간편결제 등");

  private final int id;
  private final String title;
  private final String description;
}
