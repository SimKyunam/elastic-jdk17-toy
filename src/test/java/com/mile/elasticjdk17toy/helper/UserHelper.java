package com.mile.elasticjdk17toy.helper;

import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.domain.embed.BasicProfile;

public class UserHelper {

    public static User makeUser(Long id, String name, String description) {
        return User.builder()
                .id(id)
                .basicProfile(new BasicProfile(name, description))
                .build();
    }
}
