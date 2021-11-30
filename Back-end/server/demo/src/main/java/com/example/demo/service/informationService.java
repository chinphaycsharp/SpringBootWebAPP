package com.example.demo.service;

import com.example.demo.dto.informationDto;
import org.springframework.stereotype.Service;

@Service
public interface informationService {
    informationDto saveOrUpdate (Long Id, informationDto dto);
}
