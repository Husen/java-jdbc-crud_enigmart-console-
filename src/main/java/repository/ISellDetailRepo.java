package repository;

import model.Sell;
import model.SellDetail;

import java.sql.SQLException;
import java.util.List;

public interface ISellDetailRepo {
    public List<SellDetail> detailTransaksi() throws SQLException;
    public void addSellDetail(SellDetail sellDetail) throws SQLException;
    public SellDetail getLastId() throws SQLException;
    public SellDetail getByIdProduct(Integer id) throws SQLException;
}
