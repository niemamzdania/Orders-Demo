package com.przemke.demo.service;

import com.przemke.demo.dao.OrderProductRepository;
import com.przemke.demo.dao.OrderRepository;
import com.przemke.demo.dao.ProductRepository;
import com.przemke.demo.entity.Order;
import com.przemke.demo.entity.OrderProduct;
import com.przemke.demo.entity.Product;
import com.przemke.demo.exceptionhandling.CustomNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public void addOrder() {
        Order order = orderRepository.findOrderByDateIsNull();
        if (order == null)
            throw new CustomNotFoundException("There are not products in the bucket");
        order.setDate(LocalDate.now());
        orderRepository.save(order);
    }

    @Override
    public List<Order> findOrdersByDate(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findOrdersByDateBetween(startDate, endDate);
    }

    @Override
    public void addProductToBucket(int productId) {
        if (!productRepository.existsById(productId))
            throw new CustomNotFoundException("Product with id=" + productId + " not found");

        Product product = productRepository.findProductById(productId);
        Order order = orderRepository.findOrderByDateIsNull();

        if (order == null) {
            order = new Order();
            orderRepository.save(order);
        }

        OrderProduct orderProduct = new OrderProduct(order.getId(), product.getId(), product.getPrice());
        orderProductRepository.save(orderProduct);
    }

    @Override
    public Optional<Order> calculateOrder(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            order.get().getOrderProducts().forEach(n -> {
                n.setPrice(n.getProduct().getPrice());
            });
            orderRepository.save(order.get());
        }
        return order;
    }
}
