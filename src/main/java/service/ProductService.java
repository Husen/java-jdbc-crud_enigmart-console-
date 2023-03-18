package service;

import model.Product;
import model.ProductPrice;
import model.SellDetail;
import repository.*;
import util.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductService implements IProductService{
    Connector connector = new Connector();

    private IProductRepo productRepo;
//    private ISellDetailRepo sellDetailRepo;
    Connection connection = connector.connect();
    ISellDetailRepo sellDetailRepo = new SellDetailRepo(connection);
    ISellDetailService sellDetailService = new SellDetailService(sellDetailRepo);


    public ProductService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductService(ISellDetailRepo sellDetailRepo) {
        this.sellDetailRepo = sellDetailRepo;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        productRepo.addProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) throws SQLException {
        productRepo.deleteProduct(id);
    }

    @Override
    public ProductPrice getByIdProduct(Integer id) throws SQLException {
        return productRepo.getById(id);
    }
    public SellDetail getByIdProductSell(Integer id) throws SQLException {
        return sellDetailRepo.getByIdProduct(id);
    }
}
