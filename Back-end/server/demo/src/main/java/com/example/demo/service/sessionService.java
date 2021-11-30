package com.example.demo.service;

import com.example.demo.dto.sessionDto;
import org.springframework.stereotype.Service;

@Service
public interface sessionService {
    sessionDto saveOrUpdate (Long Id, sessionDto dto);
}
