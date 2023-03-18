package controller;

import model.Product;
import model.ProductPrice;
import model.SellDetail;
import repository.ISellRepo;
import repository.SellDetailRepo;
import repository.SellRepo;
import service.IProductService;
import service.ISellService;
import service.ProductService;
import service.SellService;
import util.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductController implements IProductController{
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public void addProduct(String name_product) throws SQLException {
        Product product = new Product();
        product.setName_product(name_product);
        productService.addProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) throws SQLException {
        productService.getByIdProduct(id);
        ProductPrice productPrice = productService.getByIdProduct(id);
        if (productPrice.getProduct_id() != null) {
            productService.getByIdProductSell(id);
            SellDetail sellDetail = productService.getByIdProductSell(id);
            if (sellDetail.getProduct_price_id() == null) {
                productService.deleteProduct(id);
            } else {
                System.err.println("Data id sudah digunakan di transaksi");
            }
        } else {
            System.err.println("Data id tidak ada");
        }
    }
}
