package org.example.studyshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "app_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String account;

  private String email;

  private String phoneNumber;

  private LocalDateTime createdAt;

  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // 1 : N ,mappedBy="user" -> OrderDetail Entity 에 있는 User user 를 말함.
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderDetail> orderDetails;

}
