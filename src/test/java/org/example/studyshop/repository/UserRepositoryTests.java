package org.example.studyshop.repository;

import jakarta.transaction.Transactional;
import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.Item;
import org.example.studyshop.model.entity.User;
import org.example.studyshop.util.LoggingTestWatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(LoggingTestWatcher.class)
public class UserRepositoryTests extends StudyShopApplicationTests {
  //Dependency Injection (DI)
  @Autowired
  private UserRepository userRepository;

  @Test
  @DisplayName("User Repository Test - create")
  public void create() {
    //String sql = insert into user (%s,%s,%d) values(account, email, age);
    User user = User.builder()
        .account("TestUser03")
        .email("TestUser03@gmail.com")
        .phoneNumber("010-1111-2233")
        .createdAt(LocalDateTime.now())
        .createdBy("ADMIN")
        .build();

    User newUser = userRepository.save(user);
    System.out.println("newUser : " + newUser);
  }

  @Test
  @DisplayName("User Repository Test - read")
  @Transactional
  public void read() {
    Optional<User> user = userRepository.findByAccount("TestUser03");

    user.ifPresent(selectUser -> {
      selectUser.getOrderDetails().forEach(detail -> {
        Item item = detail.getItem();
        System.out.println("item : " + item);
      });
    });
  }

  @Test
  @DisplayName("User Repository Test - update")
  public void update() {
    Long id = 2L;
    Optional<User> user = userRepository.findById(id);
    user.ifPresentOrElse(selectUser -> {
          selectUser.setAccount("PPPPP");
          selectUser.setUpdatedAt(LocalDateTime.now());
          selectUser.setUpdatedBy("ADMIN");
          userRepository.save(selectUser);
          System.out.println("user : " + selectUser);
        },
        () -> System.out.println("The id you entered '" + id + "' is not exist user"));
  }

  @Test
  @Transactional
  @DisplayName("User Repository Test - delete")
  public void delete() {
    Long id = 1L;
    Optional<User> user = userRepository.findById(id);

    //Assert.assertTrue(user.isPresent()); junit4
    Assertions.assertTrue(user.isPresent()); // junit5

    user.ifPresent(selectUser -> userRepository.delete(selectUser));

    Optional<User> deletedUser = userRepository.findById(id);

    Assertions.assertFalse(deletedUser.isPresent());
  }

}
