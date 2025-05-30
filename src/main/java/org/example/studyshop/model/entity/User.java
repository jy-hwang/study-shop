package org.example.studyshop.model.entity;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
@ToString(exclude = {"orderGroupList"})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String account;

  private String password;

  private String status;

  private String email;

  private String phoneNumber;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  private LocalDateTime createdAt;

  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // User 1 : N OrderGroup
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderGroup> orderGroupList;
}
