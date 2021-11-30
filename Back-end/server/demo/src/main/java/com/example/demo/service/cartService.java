package com.example.demo.service;

import com.example.demo.dto.cartDto;
import org.springframework.stereotype.Service;

@Service
public interface cartService {
    cartDto saveOrUpdate (Long Id, cartDto dto);
}
