package com.mile.elasticjdk17toy.repository.es;

import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.repository.es.custom.CustomUserSearchRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserSearchRepository extends ElasticsearchRepository<User, Long>, CustomUserSearchRepository {

    List<User> findByBasicProfile_NameContains(String name);
}
