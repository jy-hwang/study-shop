package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.OrderDetail;
import org.example.studyshop.util.LoggingTestWatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(LoggingTestWatcher.class)
public class OrderDetailRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Test
  @DisplayName("Order Detail Repository Tests -  create")
  public void create() {
    OrderDetail orderDetail
        = OrderDetail.builder()
        .status("WAITING")
        .arrivalDate(LocalDateTime.now().plusDays(2))
        .quantity(1)
        .totalPrice(BigDecimal.valueOf(900000))
        .orderGroupId(1L)
        .itemId(1L)
        .createdBy("AdminServer")
        .createdAt(LocalDateTime.now())
        .build();
    OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

    Assertions.assertNotNull(newOrderDetail);
  }

}
