package com.przemke.demo.dao;

import com.przemke.demo.entity.OrderProduct;
import com.przemke.demo.entity.OrderProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductKey> {
}
