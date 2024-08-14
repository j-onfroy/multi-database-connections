package com.company.controller;

import com.company.dto.UserEntityCriteria;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/app")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        UserEntity save = userService.save(user);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        UserEntity user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(@RequestBody UserEntityCriteria criteria) {
        List<UserEntity> userEntities = userService.allUser(criteria);
        return ResponseEntity.ok(userEntities);
    }
}
