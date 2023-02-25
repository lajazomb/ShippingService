package com.bookstore.shippingservice.core.domain.service.implementation;

import com.bookstore.shippingservice.core.domain.model.Order;
import com.bookstore.shippingservice.core.domain.service.interfaces.IShippingRepository;
import com.bookstore.shippingservice.core.domain.service.interfaces.IShippingService;
import com.bookstore.shippingservice.port.order.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShippingService implements IShippingService {

    @Autowired
    private IShippingRepository shippingRepository;

    @Override
    public Order createOrder(Order order) {
        return shippingRepository.save(order);
    }

    @Override
    public Order getOrder(UUID id) throws OrderNotFoundException {
        if (shippingRepository.findById(id).isEmpty()) {
            throw new OrderNotFoundException();
        }
        return shippingRepository.findById(id).get();
    }

    @Override
    public List<Order> getAllUserOrders(Long userId) throws OrderNotFoundException {
        if (shippingRepository.findByUserId(userId).isEmpty()) {
            throw new OrderNotFoundException();
        }
        return shippingRepository.findByUserId(userId);
    }

    @Override
    public void deleteOrder(UUID id) throws OrderNotFoundException {
        if (shippingRepository.findById(id) == null) {
            throw new OrderNotFoundException();
        }
        shippingRepository.deleteById(id);
    }

    @Override
    public void calculateTotalSum(UUID id) throws OrderNotFoundException {
        if (shippingRepository.findById(id) == null) {
            throw new OrderNotFoundException();
        }
        //do calculation and return the result
    }
}
