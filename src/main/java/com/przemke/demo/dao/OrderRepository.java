package com.przemke.demo.dao;

import com.przemke.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderByDateIsNull();
    List<Order> findOrdersByDateBetween(LocalDate start, LocalDate finish);
}
