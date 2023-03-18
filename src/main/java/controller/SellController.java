package controller;

import model.Sell;
import service.ISellService;

import java.sql.SQLException;

public class SellController implements ISellController{
    private ISellService sellService;

    public SellController(ISellService sellService) {
        this.sellService = sellService;
    }

    @Override
    public void addSell(String trans_date, String customer_name) throws SQLException {
        Sell sell = new Sell();
        sell.setTrans_date(trans_date);
        sell.setCustomer_name(customer_name);
        sellService.addSell(sell);
    }

    @Override
    public void deleteTransaksi(Integer id) throws SQLException {
        sellService.getIdSell(id);
        Sell sell = sellService.getIdSell(id);
        if (sell.getId() != null) {
            sellService.deleteTransaksi(id);
        } else {
            System.err.println("Data id Transaksi tidak ada :P");
        }
    }
}
