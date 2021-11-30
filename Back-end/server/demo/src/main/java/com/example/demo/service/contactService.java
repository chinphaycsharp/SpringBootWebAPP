package com.example.demo.service;

import com.example.demo.dto.contactDto;
import org.springframework.stereotype.Service;

@Service
public interface contactService {
    contactDto saveOrUpdate (Long Id, contactDto dto);
}
