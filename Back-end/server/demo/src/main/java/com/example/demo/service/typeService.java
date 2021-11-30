package com.example.demo.service;

import com.example.demo.dto.typeDto;
import org.springframework.stereotype.Service;

@Service
public interface typeService {
    typeDto saveOrUpdate (Long Id, typeDto dto);
}
