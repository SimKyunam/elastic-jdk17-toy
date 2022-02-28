package com.mile.elasticjdk17toy.domain;

import com.mile.elasticjdk17toy.domain.embed.BasicProfile;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.lang.annotation.Documented;

@Document(indexName = "users")
@Entity
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BasicProfile basicProfile;
}
