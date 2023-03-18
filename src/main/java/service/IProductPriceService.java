package service;

import model.ProductPrice;

import java.sql.SQLException;
import java.util.List;

public interface IProductPriceService {
    public void addProductPrice(ProductPrice productPrice) throws SQLException;
    public ProductPrice getLastId() throws SQLException;
    public List<ProductPrice> detailProduct() throws SQLException;
}
