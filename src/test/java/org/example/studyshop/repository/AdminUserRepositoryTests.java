package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  private AdminUserRepository adminUserRepository;

  @Test
  public void create(){
    AdminUser adminUser
        = AdminUser.builder()
        .account("admin01")
        .password("11")
        .status("REGISTERED")
        .role("PARTNER")
        .createdAt(LocalDateTime.now())
        .createdBy("AdminServer")
        .build();

    AdminUser newAdminUser = adminUserRepository.save(adminUser);
    Assertions.assertNotNull(newAdminUser);
  }
}
