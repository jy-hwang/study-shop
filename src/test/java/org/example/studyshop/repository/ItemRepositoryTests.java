package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.Item;
import org.example.studyshop.util.LoggingTestWatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(LoggingTestWatcher.class)
public class ItemRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  @DisplayName("Item Repository Test - create")
  public void create() {
    Item item
        = Item.builder()
        .status("UNREGISTERED")
        .name("삼성 노트북")
        .title("삼성 노트북 A100")
        .content("2025년형 노트북 입니다")
        .price(900000)
        .brandName("삼성")
        .registeredAt(LocalDateTime.now())
        .createdAt(LocalDateTime.now())
        .createdBy("Partner01")
        //.partnerId(1L)
        .build();

    Item newItem = itemRepository.save(item);

    Assertions.assertNotNull(newItem); // junit5
  }

  @Test
  @DisplayName("Item Repository Test - read")
  public void read() {
    Long id = 1L;

    Optional<Item> item = itemRepository.findById(id);

    Assertions.assertTrue(item.isPresent());
  }

}