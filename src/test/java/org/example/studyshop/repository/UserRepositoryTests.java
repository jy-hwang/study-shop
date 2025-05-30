package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.User;
import org.example.studyshop.util.LoggingTestWatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@ExtendWith(LoggingTestWatcher.class)
public class UserRepositoryTests extends StudyShopApplicationTests {
  //Dependency Injection (DI)
  @Autowired
  private UserRepository userRepository;

  @Test
  @DisplayName("User Repository Test - create")
  public void create() {
    String account = "Test01";
    String password = "11";
    String status = "REGISTERED";
    String email = "Test01@abc.com";
    String phoneNumber = "010-1234-5678";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";

    User user = User.builder()
        .account(account)
        .password(password)
        .status(status)
        .email(email)
        .phoneNumber(phoneNumber)
        .registeredAt(registeredAt)
        .createdAt(createdAt)
        .createdBy(createdBy)
        .build();

    User newUser = userRepository.save(user);
    Assertions.assertNotNull(newUser);
    Assertions.assertEquals(account, newUser.getAccount());
    Assertions.assertEquals(status, newUser.getStatus());
  }

  @Test
  @DisplayName("User Repository Test - read")
  @Transactional
  public void read() {
    User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1234-5678");

    if (user != null) {
      user.getOrderGroupList().forEach(orderGroup -> {
        System.out.println("--------------- 주문묶음 ----------------");
        System.out.println("수령인 : " + orderGroup.getRevName());
        System.out.println("수령지 : " + orderGroup.getRevAddress());
        System.out.println("총금액 : " + orderGroup.getTotalPrice());
        System.out.println("총수량 : " + orderGroup.getTotalQuantity());

        orderGroup.getOrderDetailList().forEach(orderDetail -> {
          System.out.println("--------------- 주문상세 ----------------");
          System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
          System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
          System.out.println("주문상품 : " + orderDetail.getItem().getName());
          System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
          System.out.println("주문상태 : " + orderDetail.getStatus());
          System.out.println("도착 예정일자 : " + orderDetail.getArrivalDate());
        });
      });
    }
    Assertions.assertNotNull(user);
  }

  @Disabled
  @Test
  @DisplayName("User Repository Test - update")
  public void update() {

  }

  @Disabled
  @Test
  @DisplayName("User Repository Test - delete")
  public void delete() {

  }

}
