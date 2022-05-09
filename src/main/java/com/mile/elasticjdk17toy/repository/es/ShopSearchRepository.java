package com.mile.elasticjdk17toy.repository.es;

import com.mile.elasticjdk17toy.domain.Shop;
import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.repository.es.custom.CustomUserSearchRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ShopSearchRepository extends ElasticsearchRepository<Shop, Long> {
    List<Shop> findByName(String name);
}
