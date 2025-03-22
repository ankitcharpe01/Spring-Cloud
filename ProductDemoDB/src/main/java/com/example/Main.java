package com.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductService service= new ProductService();
//        System.out.println(service);
//        service.addProduct(new Product("HP",2022,"Brown Table","Laptop"));
//        service.addProduct(new Product("Cello",2021,"Black Box","Pen"));
//        service.addProduct(new Product("Apple",2023,"Brown Table","Mouse"));
//        service.addProduct(new Product("Java Book",2024,"Drawer","Laptop"));
//        service.addProduct(new Product("Type C",2025,"Brown Box","Cable"));

        List<Product>products=service.getAllProducts();
        for(Product p:products){
            System.out.println(p);
        }

        System.out.println("==============================================");
        System.out.println("A Particular Product:");
        Product p= service.getProduct("HP");
        System.out.println(p);

        System.out.println("===============================================");
        System.out.println("A Particular Text:");
        List<Product>prods = service.getProductWithText("black");
        for (Product product:prods){
            System.out.println(product);
        }
    }
}