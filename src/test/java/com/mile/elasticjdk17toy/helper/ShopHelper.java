package com.mile.elasticjdk17toy.helper;

import com.mile.elasticjdk17toy.domain.Shop;
import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.domain.embed.BasicProfile;
import com.mile.elasticjdk17toy.domain.embed.BasicShop;
import com.mile.elasticjdk17toy.domain.enums.BusinessType;

public class ShopHelper {

    public static Shop makeUser(Long id,
                                String name,
                                String address,
                                String detailAddress,
                                String phoneNumber,
                                BusinessType businessType) {
        return Shop.builder()
                .id(id)
                .name(name)
                .basicShop(new BasicShop(address, detailAddress, phoneNumber))
                .businessType(businessType)
                .build();
    }
}
