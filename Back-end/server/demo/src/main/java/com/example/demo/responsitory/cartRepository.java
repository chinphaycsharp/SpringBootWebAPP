package com.example.demo.responsitory;

import com.example.demo.domain.cart;
import com.example.demo.dto.cartDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface cartRepository extends JpaRepository<cart,Long> {

    @Query("select new com.example.demo.dto.cartDto(e) from cart e")
    List<cartDto> getAll();

    @Query("select new com.example.demo.dto.cartDto(e)  from cart e where  e.id = :id")
    cartDto getcategoryById(@Param("id") Long id);

    @Query("select e from cart e where  e.id = :id")
    cart getById(@Param("id") Long id);
}
