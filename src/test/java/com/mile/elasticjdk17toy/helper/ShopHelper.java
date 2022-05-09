package com.mile.elasticjdk17toy.helper;

import com.mile.elasticjdk17toy.domain.Shop;
import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.domain.embed.BasicProfile;
import com.mile.elasticjdk17toy.domain.embed.BasicShop;
import com.mile.elasticjdk17toy.domain.enums.BusinessType;
import com.mile.elasticjdk17toy.repository.es.ShopSearchRepository;

public class ShopHelper {

    ShopSearchRepository shopSearchRepository;
    public ShopHelper(ShopSearchRepository shopSearchRepository) {
        this.shopSearchRepository = shopSearchRepository;
    }

    public static Shop makeShop(Long id,
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

    public Shop insertShop(Long id,
                           String name,
                           String address,
                           String detailAddress,
                           String phoneNumber,
                           BusinessType businessType) {
        Shop shop = ShopHelper.makeShop(id, name, address, detailAddress, phoneNumber, businessType);
        return shopSearchRepository.save(shop);
    }
}
