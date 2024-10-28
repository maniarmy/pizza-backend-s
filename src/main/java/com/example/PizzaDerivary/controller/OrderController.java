package com.example.PizzaDerivary.controller;

import com.example.PizzaDerivary.Model.Order;
import com.example.PizzaDerivary.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return "New order added successfully";
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getAll/{id}")
    public Optional<Order> getOrderByIds(@PathVariable int id) {
        return orderService.getByIdOrders(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order with ID " + id + " deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder != null) {
            return "Order with ID " + id + " updated successfully";
        } else {
            return "Order with ID " + id + " not found";
        }
    }
}
