package com.example.demo.service;

import com.example.demo.dto.categoryDto;
import org.springframework.stereotype.Service;

@Service
public interface categoryService {
    categoryDto saveOrUpdate (Long Id, categoryDto dto);
}
