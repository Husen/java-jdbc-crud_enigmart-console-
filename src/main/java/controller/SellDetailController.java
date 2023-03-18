package controller;

import model.ProductPrice;
import model.SellDetail;
import repository.SellDetailRepo;
import service.ISellDetailService;
import service.SellDetailService;

import java.sql.SQLException;
import java.util.List;

public class SellDetailController implements ISellDetailController{
    private ISellDetailService sellDetailService;

    public SellDetailController(ISellDetailService sellDetailService) {
        this.sellDetailService = sellDetailService;
    }

    @Override
    public void addSellDetail(Integer product_price_id, Integer qty) throws SQLException {
        sellDetailService.getLastId();
        SellDetail sellDetail = sellDetailService.getLastId();
        sellDetail.setProduct_price_id(product_price_id);
        sellDetail.setQty(qty);
        sellDetailService.addSellDetail(sellDetail);
    }

    @Override
    public void detailTransaksi() throws SQLException {
        List<SellDetail> sellDetails = sellDetailService.detailProduct();
        for(SellDetail sellDetail : sellDetails) {
            System.out.println(sellDetail.toString());
        }
    }
}
