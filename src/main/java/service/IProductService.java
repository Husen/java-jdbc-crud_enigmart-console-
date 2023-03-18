package service;

import model.Product;
import model.ProductPrice;
import model.SellDetail;

import java.sql.SQLException;

public interface IProductService {
    public void addProduct(Product product) throws SQLException;
    public void deleteProduct(Integer id) throws SQLException;
    public ProductPrice getByIdProduct(Integer id) throws SQLException;
    public SellDetail getByIdProductSell(Integer id) throws SQLException;
}
