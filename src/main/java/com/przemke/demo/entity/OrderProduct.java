package com.przemke.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders_products")
@Data
@NoArgsConstructor
@IdClass(OrderProductKey.class)
public class OrderProduct {

    @Id
    @JsonBackReference
    private int orderId;

    @Id
    @JsonBackReference
    private int productId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @Column
    private BigDecimal price;

    public OrderProduct(int orderId, int productId, BigDecimal price) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
    }
}
