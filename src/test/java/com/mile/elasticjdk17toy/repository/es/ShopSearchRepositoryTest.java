package com.mile.elasticjdk17toy.repository.es;

import com.mile.elasticjdk17toy.domain.Shop;
import com.mile.elasticjdk17toy.domain.embed.BasicShop;
import com.mile.elasticjdk17toy.domain.enums.BusinessType;
import com.mile.elasticjdk17toy.helper.ShopHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ShopSearchRepositoryTest {
    @Autowired
    ShopSearchRepository shopSearchRepository;

    ShopHelper shopHelper;

    @BeforeEach
    void init() {
        shopHelper = new ShopHelper(shopSearchRepository);
    }

    @Test
    void 가게_생성() {
        shopHelper.insertShop(1L,
                "홍콩반점",
                "서울",
                "성동구",
                "02-1234-1234",
                BusinessType.FOOD);

        shopHelper.insertShop(2L,
                "이바돔감자탕",
                "인천",
                "부평구",
                "032-1111-1111",
                BusinessType.FOOD);

        shopHelper.insertShop(3L,
                "포율헬스장",
                "인천",
                "부평구",
                "032-111-2222",
                BusinessType.HEALTH);

        shopHelper.insertShop(4L,
                "소울필라테스",
                "서울",
                "마포구",
                "02-333-4444",
                BusinessType.HEALTH);

        List<Shop> userList = StreamSupport
                .stream(shopSearchRepository.findAll().spliterator(), false)
                .peek(System.out::println)
                .collect(Collectors.toList());

        assertEquals(4, userList.size());
    }

    @Test
    void 가게_조회() {
        Shop shop = ShopHelper.makeShop(1L,
                "홍콩반점",
                "서울",
                "성동구",
                "02-1234-1234",
                BusinessType.FOOD);

        shopSearchRepository.save(shop);

        Shop selectShop = shopSearchRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("결과 없습니다."));

        assertEquals(shop.getId(), selectShop.getId());
        assertEquals(shop.getName(), selectShop.getName());
    }

    @Test
    void 가게_단어_찾기() {
        Shop shop1 = Shop.builder()
                .name("홍콩짬뽕")
                .basicShop(new BasicShop("서울", "성동구", "02-1234-1234"))
                .businessType(BusinessType.FOOD)
                .build();
        Shop shop2 = Shop.builder()
                .name("짜장면홍콩")
                .basicShop(new BasicShop("서울", "성동구", "02-1234-1234"))
                .businessType(BusinessType.FOOD)
                .build();
        Shop shop3 = Shop.builder()
                .name("홍탕수육콩")
                .basicShop(new BasicShop("서울", "성동구", "02-1234-1234"))
                .businessType(BusinessType.FOOD)
                .build();
        Shop shop4 = Shop.builder()
                .name("홍투도콩")
                .basicShop(new BasicShop("서울", "성동구", "02-1234-1234"))
                .businessType(BusinessType.FOOD)
                .build();
        Shop shop5 = Shop.builder()
                .name("뉴투홍도콩")
                .basicShop(new BasicShop("서울", "성동구", "02-1234-1234"))
                .businessType(BusinessType.FOOD)
                .build();

        shopSearchRepository.save(shop1);
        shopSearchRepository.save(shop2);
        shopSearchRepository.save(shop3);
        shopSearchRepository.save(shop4);
        shopSearchRepository.save(shop5);

        shopSearchRepository.findByName("홍콩짬뽕")
                .stream()
                .peek(System.out::println);
    }
}