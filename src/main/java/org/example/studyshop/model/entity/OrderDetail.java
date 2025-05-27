package org.example.studyshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"user", "item"})
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime orderAt;

  // N : 1
  @ManyToOne
  private User user; // user_id

  // N : 1
  @ManyToOne
  private Item item;

}
