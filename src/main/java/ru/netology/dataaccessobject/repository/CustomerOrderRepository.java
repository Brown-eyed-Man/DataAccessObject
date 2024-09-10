package ru.netology.dataaccessobject.repository;

import java.util.List;

public interface CustomerOrderRepository {
    List<Product> getProducts(String customerName);
}
