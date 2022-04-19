package com.mile.elasticjdk17toy.domain.embed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasicShop {

    private String address;

    private String detailAddress;

    private String phoneNumber;
}
