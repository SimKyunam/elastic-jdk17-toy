package com.mile.elasticjdk17toy.domain;

import com.mile.elasticjdk17toy.domain.embed.BasicShop;
import com.mile.elasticjdk17toy.domain.enums.BusinessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Document(indexName = "shops")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private BasicShop basicShop;

    private BusinessType businessType;
}
