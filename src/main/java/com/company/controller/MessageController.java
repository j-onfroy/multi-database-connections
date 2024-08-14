package com.company.controller;

import com.company.dto.MessageCriteria;
import com.company.entity.Message;
import com.company.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/app")
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message/all")
    public ResponseEntity<?> get(@RequestBody MessageCriteria criteria) {
        return messageService.getAll(criteria);
    }
 @PostMapping("/message/create")
    public ResponseEntity<?> create(@RequestBody Message message) {
        return messageService.save(message);
    }

}
