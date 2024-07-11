package org.example.studyshop.repository;

import jakarta.transaction.Transactional;
import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyShopApplicationTests {


    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;


    @Test
    public void create() {
        //String sql = insert into user (%s,%s,%d) values(account, email, age);
        User user = new User();
        //user.setId();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-2233");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("Admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    public void read() {
        Long id = 4L;
        Optional<User> user = userRepository.findById(id);
        user.ifPresentOrElse(selectUser -> System.out.println("user : " + selectUser),
                () -> System.out.println("The id you entered '" + id + "' is not exist user"));
    }

    @Test
    public void update() {
        Long id = 2L;
        Optional<User> user = userRepository.findById(id);
        user.ifPresentOrElse(selectUser -> {
                    selectUser.setAccount("PPPPP");
                    selectUser.setUpdatedAt(LocalDateTime.now());
                    selectUser.setUpdatedBy("Admin");
                    userRepository.save(selectUser);
                    System.out.println("user : " + selectUser);
                },
                () -> System.out.println("The id you entered '" + id + "' is not exist user"));
    }

    @Test
    @Transactional
    public void delete() {
        Long id = 3L;
        Optional<User> user = userRepository.findById(id);

        //Assert.assertTrue(user.isPresent()); junit4
        Assertions.assertTrue(user.isPresent()); // junit5


        user.ifPresent(selectUser -> userRepository.delete(selectUser));

        Optional<User> deletedUser = userRepository.findById(id);
//        if (deletedUser.isPresent()) {
//            System.out.println("not deleted user : " + deletedUser.get());
//        } else {
//            System.out.println("no exist user");
//        }
        Assertions.assertFalse(deletedUser.isPresent());
    }

}
