package com.example.demo.responsitory;

import com.example.demo.domain.message;
import com.example.demo.dto.messageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface messageRepository extends JpaRepository<message,Long> {
    @Query("select new com.example.demo.dto.messageDto(e) from message e")
    List<messageDto> getAllMessage();
}
