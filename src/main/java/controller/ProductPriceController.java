package controller;

import model.Laporan;
import model.ProductPrice;
import service.IProductPriceService;
import java.sql.SQLException;
import java.util.List;

public class ProductPriceController implements IProductPriceController{
    private IProductPriceService productPriceService;

    public ProductPriceController(IProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @Override
    public void addProductPrice(Integer price) throws SQLException {
        productPriceService.getLastId();
        ProductPrice productPrice = productPriceService.getLastId();
        productPrice.setProduct_id(productPrice.getProduct_id());
        productPrice.setPrice(price);
        productPriceService.addProductPrice(productPrice);
    }
    @Override
    public void detailProduct() throws SQLException {
        List<ProductPrice> productPrices = productPriceService.detailProduct();
        for(ProductPrice productPrice : productPrices) {
            System.out.println(productPrice.toString());
        }

    }
}
