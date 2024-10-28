package com.example.PizzaDerivary.services;

import com.example.PizzaDerivary.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public void saveCustomer(Customer customer);
    public List<Customer> getAllCustomers();
}
