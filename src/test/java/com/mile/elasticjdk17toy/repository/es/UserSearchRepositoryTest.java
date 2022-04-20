package com.mile.elasticjdk17toy.repository.es;

import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.helper.UserHelper;
import com.mile.elasticjdk17toy.repository.rdb.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserSearchRepositoryTest {

    @Autowired
    UserSearchRepository userSearchRepository;

    @Test
    void 사용자_생성() {
        User user = UserHelper.makeUser(1L, "홍길동", "홍길동 사람");
        User user1 = UserHelper.makeUser(2L, "이순신", "이순신 사람");
        User user2 = UserHelper.makeUser(3L, "강감찬", "강감찬 사람");
        User user3 = UserHelper.makeUser(4L, "을지문덕", "을지문덕 사람");

        userSearchRepository.save(user);
        userSearchRepository.save(user1);
        userSearchRepository.save(user2);
        userSearchRepository.save(user3);

        List<User> userList = StreamSupport
                .stream(userSearchRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(4, userList.size());
    }

    @Test
    void 사용자_조회() {
        User user = UserHelper.makeUser(1L, "홍길동", "홍길동 사람");
        userSearchRepository.save(user);

        User selectUser = userSearchRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("결과 없습니다."));

        assertEquals(user.getId(), selectUser.getId());
        assertEquals(user.getName(), selectUser.getName());
    }
}