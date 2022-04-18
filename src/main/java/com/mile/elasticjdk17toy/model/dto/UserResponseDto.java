package com.mile.elasticjdk17toy.model.dto;

import com.mile.elasticjdk17toy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String description;

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getDescription());
    }
}