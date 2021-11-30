package com.example.demo.service;

import com.example.demo.dto.messageDto;
import org.springframework.stereotype.Service;

@Service
public interface messageService {
    messageDto saveOrUpdate (Long Id, messageDto dto);
}
