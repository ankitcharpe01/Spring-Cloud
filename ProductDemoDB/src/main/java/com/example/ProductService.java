package com.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService  {

    List<Product> products = new ArrayList<>();
    ProductDB  db = new ProductDB();
    public void addProduct(Product p) {
//        products.add(p);
        db.save(p);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
    }

    public Product getProduct(String name) {
        return db.getByName(name);
    }

    public List<Product> getProductWithText(String text) {
        return db.searchByKeyword(text.toLowerCase());
    }

}
