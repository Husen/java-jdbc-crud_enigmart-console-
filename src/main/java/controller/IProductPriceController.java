package controller;

import model.ProductPrice;

import java.sql.SQLException;

public interface IProductPriceController {
    public void addProductPrice(Integer price) throws SQLException;
    public void detailProduct() throws SQLException;
}
