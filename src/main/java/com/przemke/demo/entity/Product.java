package com.przemke.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Column
    private BigDecimal price;

    public Product(@NotNull @Size(min = 3, max = 50) String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
