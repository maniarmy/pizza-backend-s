package com.example.PizzaDerivary.services;

import com.example.PizzaDerivary.Model.Order;
import com.example.PizzaDerivary.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getByIdOrders(int id) {

        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(int id, Order order) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);
        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setCustomer(order.getCustomer());
            existingOrder.setPhone(order.getPhone());
            existingOrder.setAddress(order.getAddress());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
