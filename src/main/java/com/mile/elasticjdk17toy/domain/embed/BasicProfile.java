package com.mile.elasticjdk17toy.domain.embed;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasicProfile {
    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}
