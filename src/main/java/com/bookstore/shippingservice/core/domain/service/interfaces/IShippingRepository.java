package com.bookstore.shippingservice.core.domain.service.interfaces;

import com.bookstore.shippingservice.core.domain.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IShippingRepository extends CrudRepository<Order, UUID> {

    List<Order> findByUserId(Long userId);

}
