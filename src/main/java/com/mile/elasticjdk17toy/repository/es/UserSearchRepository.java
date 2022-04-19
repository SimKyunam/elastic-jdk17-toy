package com.mile.elasticjdk17toy.repository.es;

import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.repository.es.custom.CustomUserSearchRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserSearchRepository extends ElasticsearchRepository<User, Long>, CustomUserSearchRepository {
}
