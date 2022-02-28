package com.mile.elasticjdk17toy.repository.es.custom;

import com.mile.elasticjdk17toy.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomUserSearchRepository {
    List<User> searchByName(String name, Pageable pageable);
}
