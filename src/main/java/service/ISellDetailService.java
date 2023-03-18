package service;

import model.ProductPrice;
import model.SellDetail;

import java.sql.SQLException;
import java.util.List;

public interface ISellDetailService {
    public SellDetail getLastId() throws SQLException;
    public void addSellDetail(SellDetail sellDetail) throws SQLException;
    public List<SellDetail> detailProduct() throws SQLException;
}
