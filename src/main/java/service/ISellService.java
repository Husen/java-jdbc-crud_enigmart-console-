package service;

import model.Sell;

import java.sql.SQLException;

public interface ISellService {
    public void addSell(Sell sell) throws SQLException;
    public Sell getIdSell(Integer id) throws SQLException;
    public void deleteTransaksi(Integer id) throws SQLException;
}
