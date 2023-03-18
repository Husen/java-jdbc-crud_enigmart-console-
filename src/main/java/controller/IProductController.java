package controller;

import model.Product;

import java.sql.SQLException;

public interface IProductController {
    public void addProduct(String name_product) throws SQLException;
    public void deleteProduct(Integer id) throws SQLException;

}
