package com.bookstore.shippingservice.core.domain.service.interfaces;

import com.bookstore.shippingservice.core.domain.model.Order;
import com.bookstore.shippingservice.port.order.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IShippingService {

    public Order createOrder(Order order);

    public Order getOrder(UUID id) throws OrderNotFoundException;

    public List<Order> getAllUserOrders(Long userId) throws OrderNotFoundException;

    public void deleteOrder(UUID id) throws OrderNotFoundException;

    public void calculateTotalSum(UUID id) throws OrderNotFoundException;

}
