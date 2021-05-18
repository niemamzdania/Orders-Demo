package com.przemke.demo.service;

import com.przemke.demo.entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    void addOrder();
    List<Order> findOrdersByDate(LocalDate startDate, LocalDate endDate);
    void addProductToBucket(int productId);
    Optional<Order> calculateOrder(int orderId);
}
