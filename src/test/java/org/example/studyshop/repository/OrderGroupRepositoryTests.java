package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.OrderGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  private OrderGroupRepository orderGroupRepository;

  @Test
  public void create() {

    OrderGroup orderGroup
        = OrderGroup.builder()
        .status("COMPLETE")
        .orderType("ALL")
        .revAddress("서울시 강남구")
        .revName("홍길동")
        .paymentType("CARD")
        .totalPrice(BigDecimal.valueOf(900000))
        .totalQuantity(1)
        .orderAt(LocalDateTime.now().minusDays(2))
        .arrivalDate(LocalDateTime.now())
        .createdAt(LocalDateTime.now())
        .createdBy("AdminServer")
        //.userId(1L)
        .build();

    OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

    Assertions.assertNotNull(newOrderGroup);

  }
}
