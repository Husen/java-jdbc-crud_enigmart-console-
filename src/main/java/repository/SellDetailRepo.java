package repository;

import model.Product;
import model.ProductPrice;
import model.Sell;
import model.SellDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellDetailRepo implements ISellDetailRepo{
    private final Connection connection;
    public SellDetailRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SellDetail> detailTransaksi() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select trans_date, customer_name, name_product, price, qty from t_sell_detail as sd join t_sell as s on s.id=sd.sell_id join m_product_price as pc on pc.id=sd.product_price_id join m_product as p on p.id=pc.product_id order by sd.id asc";
        ResultSet result = statement.executeQuery(sql);
        List<SellDetail> sellDetails = new ArrayList<SellDetail>();
        while (result.next()) {
            sellDetails.add(
                    new SellDetail(new Sell(result.getString("trans_date"), result.getString("customer_name")),
                                    new Product(result.getString("name_product")),
                                    new ProductPrice(result.getInt("price")),
                                    result.getInt("price")
                    )
            );
        }
        return sellDetails;
    }

    @Override
    public void addSellDetail(SellDetail sellDetail) throws SQLException {
        String sql = "INSERT INTO t_sell_detail (sell_id, product_price_id, qty) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, sellDetail.getSell_id());
        statement.setInt(2, sellDetail.getProduct_price_id());
        statement.setInt(3, sellDetail.getQty());

        statement.executeUpdate();

        statement.close();

    }

    @Override
    public SellDetail getByIdProduct(Integer id) throws SQLException {
        String sql = "SELECT * from t_sell_detail where product_price_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        SellDetail sellDetail = new SellDetail();
        while (result.next()) {
            sellDetail.setProduct_price_id(result.getInt("product_price_id"));
        }
        return sellDetail;
    }

    @Override
    public SellDetail getLastId() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select id from t_sell order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        SellDetail sellDetail = new SellDetail();
        while (result.next()) {
            sellDetail.setSell_id(result.getInt("id"));
        }
        return sellDetail;
    }
}
