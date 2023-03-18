package repository;

import model.Product;
import model.ProductPrice;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepo {
    public void addProduct(Product product) throws SQLException;
    public void deleteProduct(Integer id) throws SQLException;
    public ProductPrice getById(Integer id) throws SQLException;
}
