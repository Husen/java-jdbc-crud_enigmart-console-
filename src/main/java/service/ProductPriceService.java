package service;

import model.ProductPrice;
import repository.IProductPriceRepo;
import repository.ProductPriceRepo;

import java.sql.SQLException;
import java.util.List;

public class ProductPriceService implements IProductPriceService {
    private IProductPriceRepo productPriceRepo;

    public ProductPriceService(IProductPriceRepo productPriceRepo) {
        this.productPriceRepo = productPriceRepo;
    }

    @Override
    public void addProductPrice(ProductPrice productPrice) throws SQLException {
        productPriceRepo.addProductPrice(productPrice);
    }

    @Override
    public ProductPrice getLastId() throws SQLException {
        return productPriceRepo.getLastId();
    }

    @Override
    public List<ProductPrice> detailProduct() throws SQLException {
        return productPriceRepo.detailProduct();
    }
}
