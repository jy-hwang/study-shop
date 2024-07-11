package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyShopApplicationTests {


    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;


    @Test
    public void create(){
        //String sql = insert into user (%s,%s,%d) values(account, email, age);
        User user = new User();
        //user.setId();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-2233");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("Admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){}

}
