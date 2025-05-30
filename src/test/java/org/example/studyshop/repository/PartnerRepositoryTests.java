package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  PartnerRepository partnerRepository;

  @Test
  public void create() {
    String name = "Partner01";
    String status = "REGISTERED";
    String address = "서울시 강남구";
    String callCenter = "070-1111-2222";
    String partnerNumber = "010-1111-2222";
    String businessNumber = "1234567890123";
    String ceoName = "홍길동";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";
    Long categoryId = 1L;

    Partner partner = Partner.builder()
        .name(name)
        .status(status)
        .address(address)
        .callCenter(callCenter)
        .partnerNumber(partnerNumber)
        .businessNumber(businessNumber)
        .ceoName(ceoName)
        .registeredAt(registeredAt)
//        .categoryId(categoryId)
        .build();

    Partner newPartner = partnerRepository.save(partner);
    Assertions.assertNotNull(newPartner);
    Assertions.assertEquals(name, newPartner.getName());
    Assertions.assertEquals(status, newPartner.getStatus());
  }

}
