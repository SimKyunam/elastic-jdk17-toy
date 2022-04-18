package com.mile.elasticjdk17toy.controller;

import com.mile.elasticjdk17toy.model.dto.UserRequestDto;
import com.mile.elasticjdk17toy.model.dto.UserResponseDto;
import com.mile.elasticjdk17toy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> save(@RequestBody UserRequestDto userRequestDto) {
        Long id = userService.save(userRequestDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<List<UserResponseDto>> search(@PathVariable String name, Pageable pageable) {
        List<UserResponseDto> userResponse = userService.searchByName(name, pageable);
        return ResponseEntity.ok(userResponse);
    }
}