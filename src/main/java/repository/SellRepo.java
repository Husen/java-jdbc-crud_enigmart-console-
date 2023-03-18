package repository;

import model.Sell;
import model.SellDetail;

import java.sql.*;
import java.time.LocalDate;

public class SellRepo implements ISellRepo{
    private final Connection connection;
    public SellRepo(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void addSell(Sell sell) throws SQLException {
        String sql = "insert into t_sell (trans_date, customer_name) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setDate(1, java.sql.Date.valueOf(sell.getTrans_date()));
        statement.setString(2, sell.getCustomer_name());

        statement.executeUpdate();

        statement.close();
    }

    @Override
    public Sell getIdSell(Integer id) throws SQLException {
        String sql = "SELECT id from t_sell where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        Sell sell = new Sell();
        while (result.next()) {
            sell.setId(result.getInt("id"));
        }
        return sell;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM t_sell where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.executeUpdate();
        statement.close();
    }
}
