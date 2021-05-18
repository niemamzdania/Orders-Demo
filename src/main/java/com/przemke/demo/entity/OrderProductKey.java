package com.przemke.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductKey implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;
}
