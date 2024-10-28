package com.example.PizzaDerivary.services;

import com.example.PizzaDerivary.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    void saveOrder(Order order);
    List<Order> getAllOrders();
    Optional<Order> getByIdOrders(int id);
    Order updateOrder(int id, Order order);
    void deleteOrder(int id);
}
