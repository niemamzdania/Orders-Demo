package com.przemke.demo.restcontroller;

import com.przemke.demo.entity.Order;
import com.przemke.demo.entity.Product;
import com.przemke.demo.service.OrderService;
import com.przemke.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private final ProductService productService;
    private final OrderService orderService;

    public AdminRestController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product.setId(0);
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        product.setId(productId);
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping(value = "/products/{productId}", produces = "application/json; charset=UTF-8")
    public String deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return "Deleted product with id=" + productId;
    }

    @PatchMapping("/orders/recalculate/{orderId}")
    public Optional<Order> recalculateTheOrder(@PathVariable int orderId) {
        return orderService.calculateOrder(orderId);
    }
}
