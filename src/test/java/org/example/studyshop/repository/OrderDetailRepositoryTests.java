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

import java.time.LocalDateTime;

@DataJpaTest
@ExtendWith(LoggingTestWatcher.class)
public class OrderDetailRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Test
  @DisplayName("Order Detail Repository Tests -  create")
  public void create() {
    OrderDetail orderDetail
        = OrderDetail.builder()
        .orderAt(LocalDateTime.now())
        .build();
    OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);

    Assertions.assertNotNull(orderDetail1);
  }

}
