package com.devsuperior.hruser.repositories;

import com.devsuperior.hruser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
