package service;

import model.Sell;
import repository.ISellRepo;

import java.sql.SQLException;

public class SellService implements ISellService{
    private ISellRepo sellRepo;

    public SellService(ISellRepo sellRepo) {
        this.sellRepo = sellRepo;
    }

    @Override
    public void addSell(Sell sell) throws SQLException {
        sellRepo.addSell(sell);
    }

    @Override
    public Sell getIdSell(Integer id) throws SQLException {
        return sellRepo.getIdSell(id);
    }

    @Override
    public void deleteTransaksi(Integer id) throws SQLException {
        sellRepo.delete(id);
    }
}
