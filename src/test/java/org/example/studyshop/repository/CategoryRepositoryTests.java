package org.example.studyshop.repository;

import org.example.studyshop.StudyShopApplicationTests;
import org.example.studyshop.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryRepositoryTests extends StudyShopApplicationTests {

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void create() {
    String type = "COMPUTER";
    String title = "컴퓨터";
    LocalDateTime createdAt = LocalDateTime.now();

    String createdBy = "AdminServer";

    Category category
        = Category.builder()
        .type(type)
        .title(title)
        .createdAt(createdAt)
        .createdBy(createdBy)
        .build();

    Category newCategory = categoryRepository.save(category);

    assertNotNull(newCategory);
    assertEquals(type, newCategory.getType());
    assertEquals(title, newCategory.getTitle());

  }

  @Test
  public void read() {
    String type = "COMPUTER";
    Optional<Category> optionalCategory = categoryRepository.findByType(type);

    // SELECT * FROM category WHERE type = 'COMPUTER'

    optionalCategory.ifPresent(c -> {
      assertEquals(type, c.getType());
      System.out.println(c.getId());
      System.out.println(c.getType());
      System.out.println(c.getTitle());
    });
  }

}
