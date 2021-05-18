package com.przemke.demo.restcontroller;

import com.przemke.demo.entity.Order;
import com.przemke.demo.entity.Product;
import com.przemke.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/orders", produces = "application/json; charset=UTF-8")
    public String addOrder() {
        orderService.addOrder();
        return "ok";
    }

    @GetMapping(value = "/orders/date", produces = "application/json; charset=UTF-8")
    public List<Order> getOrdersByDate(@RequestParam String startDate, @RequestParam String endDate) {
        return orderService.findOrdersByDate(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @PutMapping(value = "/orders/bucket/{productId}", produces = "application/json; charset=UTF-8")
    public String addProductToBucket(@PathVariable int productId) {
        orderService.addProductToBucket(productId);
        return "Product has been added to the bucket";
    }
}
