package controller;

import java.sql.SQLException;

public interface ISellController {
    public void addSell(String trans_date, String customer_name) throws SQLException;
    public void deleteTransaksi(Integer id) throws SQLException;
}
