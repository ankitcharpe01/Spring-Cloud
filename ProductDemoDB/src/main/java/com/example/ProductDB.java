package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn = null;

    public ProductDB() {
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/telusko","root","admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Product p) {

        String query = "insert into product (name ,type ,place ,warranty) values(?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2,p.getType());
            st.setString(3,p.getPlace());
            st.setInt(4,p.getWarranty());
            st.execute() ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product>products = new ArrayList<>();

        String query = "select name ,type ,place ,warranty from product";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product getByName(String name) {
        Product p =null;
        String query = "SELECT * FROM product WHERE name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public List<Product> searchByKeyword(String text) {
        List<Product>products = new ArrayList<>();

        String query = "SELECT * FROM product WHERE LOWER(name) LIKE ? OR LOWER(type) LIKE ? OR LOWER(place) LIKE ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            String searchText = "%" + text.toLowerCase() + "%";
            st.setString(1, searchText);
            st.setString(2, searchText);
            st.setString(3, searchText);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setType(rs.getString("type"));
                product.setPlace(rs.getString("place"));
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
