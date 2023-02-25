package com.bookstore.shippingservice.port.order;

import com.bookstore.shippingservice.core.domain.model.Order;
import com.bookstore.shippingservice.core.domain.service.implementation.ShippingService;
import com.bookstore.shippingservice.port.order.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/shipping")
    @ResponseBody Order createOrder (@RequestBody Order order) {
        return shippingService.createOrder(order);
    }

    @GetMapping("/shipping/{id}")
    public Order getOrder(@PathVariable UUID id) throws OrderNotFoundException {
        return shippingService.getOrder(id);
    }

    @GetMapping("/shipping/user/{userId}")
    public List<Order> getAllOrdersOfUser(@PathVariable Long userId) throws OrderNotFoundException {
        return shippingService.getAllUserOrders(userId);
    }

}
