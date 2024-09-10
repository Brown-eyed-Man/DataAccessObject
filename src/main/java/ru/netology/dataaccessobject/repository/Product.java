package ru.netology.dataaccessobject.repository;

import java.util.Objects;

public class Product {
    private String productName;
    private String customerName;
    private String customerSurname;
    private String date;
    private int amount;

    public Product(String productName, String customerName, String customerSurname, String date, int amount) {
        this.productName = productName;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.date = date;
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount && Objects.equals(productName, product.productName) && Objects.equals(customerName, product.customerName) && Objects.equals(customerSurname, product.customerSurname) && Objects.equals(date, product.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, customerName, customerSurname, date, amount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
