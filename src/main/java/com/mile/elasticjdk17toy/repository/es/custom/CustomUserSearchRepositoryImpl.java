package com.mile.elasticjdk17toy.repository.es.custom;

import com.mile.elasticjdk17toy.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomUserSearchRepositoryImpl implements CustomUserSearchRepository{

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<User> searchByName(String name, Pageable pageable) {
        return null;
    }
}
