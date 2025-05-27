package org.example.studyshop.repository;

import org.example.studyshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByAccount(String account);

  Optional<User> findByEmail(String email);

  Optional<User> findByAccountAndEmail(String account, String email);
}
