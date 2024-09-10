package ru.netology.dataaccessobject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.dataaccessobject.repository.CustomerOrderRepository;
import ru.netology.dataaccessobject.repository.Product;

import java.util.List;

@Service
public class CustomerOrderService {
    private final CustomerOrderRepository orderRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Product> getProducts(String customerName) {
        return orderRepository.getProducts(customerName);
    }
}
