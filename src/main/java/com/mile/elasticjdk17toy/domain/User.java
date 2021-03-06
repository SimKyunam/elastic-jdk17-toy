package com.mile.elasticjdk17toy.domain;

import com.mile.elasticjdk17toy.domain.embed.BasicProfile;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.lang.annotation.Documented;

@Document(indexName = "users")
@Entity
@Data
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BasicProfile basicProfile;

    protected User() {
    }

    public User(String name) {
        this(name, null);
    }

    public User(String name, String description) {
        this(null, new BasicProfile(name, description));
    }

    @PersistenceConstructor
    public User(Long id, BasicProfile basicProfile) {
        this.id = id;
        this.basicProfile = basicProfile;
    }

    public String getName() {
        return basicProfile.getName();
    }

    public String getDescription() {
        return basicProfile.getDescription();
    }
}
