package service;

import model.SellDetail;
import repository.ISellDetailRepo;

import java.sql.SQLException;
import java.util.List;

public class SellDetailService implements ISellDetailService{
    private ISellDetailRepo sellDetailRepo;

    public SellDetailService(ISellDetailRepo sellDetailRepo) {
        this.sellDetailRepo = sellDetailRepo;
    }

    @Override
    public List<SellDetail> detailProduct() throws SQLException {
        return sellDetailRepo.detailTransaksi();
    }

    @Override
    public SellDetail getLastId() throws SQLException {
        return sellDetailRepo.getLastId();
    }

    @Override
    public void addSellDetail(SellDetail sellDetail) throws SQLException {
        sellDetailRepo.addSellDetail(sellDetail);
    }
}
