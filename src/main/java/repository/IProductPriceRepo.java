package repository;

import model.Product;
import model.ProductPrice;

import java.sql.SQLException;
import java.util.List;

public interface IProductPriceRepo {
    public void addProductPrice(ProductPrice product) throws SQLException;
    public List<ProductPrice> detailProduct() throws SQLException;
    public ProductPrice getLastId() throws SQLException;

}
