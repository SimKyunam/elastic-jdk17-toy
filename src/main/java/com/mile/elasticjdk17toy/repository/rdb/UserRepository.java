package com.mile.elasticjdk17toy.repository.rdb;

import com.mile.elasticjdk17toy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
