package controller;

import java.sql.SQLException;

public interface ISellDetailController {
    public void addSellDetail(Integer product_price_id, Integer qty) throws SQLException;
    public void detailTransaksi() throws SQLException;
}
