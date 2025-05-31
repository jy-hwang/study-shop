package org.example.studyshop.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderGroupStatus {
  CONFIRMED(0, "주문완료", "주문 완료 상태"),
  PREPARING(1, "준비중", "상품 준비 상태"),
  SHIPPING(2, "배송중", "배송 중 상태"),
  DELIVERED(3, "배송완료", "배송 완료 상태");

  private final int id;
  private final String title;
  private final String description;
}
