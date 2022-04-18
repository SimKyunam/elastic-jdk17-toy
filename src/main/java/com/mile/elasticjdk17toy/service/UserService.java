package com.mile.elasticjdk17toy.service;

import com.mile.elasticjdk17toy.domain.User;
import com.mile.elasticjdk17toy.model.dto.UserRequestDto;
import com.mile.elasticjdk17toy.model.dto.UserResponseDto;
import com.mile.elasticjdk17toy.repository.es.UserSearchRepository;
import com.mile.elasticjdk17toy.repository.rdb.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserSearchRepository userSearchRepository;

    @Transactional
    public Long save(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getName(), userRequestDto.getDescription());
        User savedUser = userRepository.save(user);
        userSearchRepository.save(user);
        return savedUser.getId();
    }

    public List<UserResponseDto> searchByName(String name, Pageable pageable) {
        // userSearchRepository.findByBasicProfile_NameContains(name) 가능
        return userSearchRepository.searchByName(name, pageable)
                .stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }
}