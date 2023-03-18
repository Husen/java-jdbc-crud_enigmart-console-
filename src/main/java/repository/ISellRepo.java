package repository;

import model.Sell;

import java.sql.SQLException;
import java.util.List;

public interface ISellRepo {
    public void addSell(Sell sell) throws SQLException;
    public Sell getIdSell(Integer id) throws SQLException;
    public void delete(Integer id) throws SQLException;
}
