package com.company.service;

import com.company.dto.MessageCriteria;
import com.company.entity.Message;
import com.company.repository.second.CustomMessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final CustomMessageRepo customMessageRepo;

    public ResponseEntity<List<?>> getAll(MessageCriteria criteria) {
        List<Message> messageList = customMessageRepo.getMessageList(criteria);
        return ResponseEntity.ok(messageList);
    }
}
