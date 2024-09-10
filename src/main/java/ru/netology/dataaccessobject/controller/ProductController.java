package ru.netology.dataaccessobject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dataaccessobject.repository.Product;
import ru.netology.dataaccessobject.service.CustomerOrderService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CustomerOrderService service;

    @Autowired
    public ProductController(CustomerOrderService service) {
        this.service = service;
    }

    @GetMapping("/fetch-product")
    public List<Product> getProducts(@RequestParam("name") String customerName) {
        return service.getProducts(customerName);
    }
}
