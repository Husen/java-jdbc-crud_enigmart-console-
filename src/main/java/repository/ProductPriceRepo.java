package repository;

import model.Product;
import model.ProductPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductPriceRepo implements IProductPriceRepo{
    private final Connection connection;
    public ProductPriceRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addProductPrice(ProductPrice productPrice) throws SQLException {
        String sql = "INSERT INTO m_product_price (product_id, price) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, productPrice.getProduct_id());
        statement.setInt(2, productPrice.getPrice());

        statement.executeUpdate();

        statement.close();

    }

    @Override
    public List<ProductPrice> detailProduct() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select p.name_product, pc.price from m_product_price as pc left join m_product as p on p.id=pc.product_id";
        ResultSet result = statement.executeQuery(sql);
        List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
        while (result.next()) {
            productPrices.add(new ProductPrice(result.getInt("price"), result.getString("name_product")));
        }
        return productPrices;
    }



    @Override
    public ProductPrice getLastId() throws SQLException {
        String sql = ("select id from m_product order by id desc limit ?");

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);

        ResultSet result = statement.executeQuery();
        ProductPrice productPrice = new ProductPrice();
        while (result.next()) {
            productPrice.setProduct_id(result.getInt("id"));
        }
        return productPrice;
    }
}
