package repository;

import model.Product;
import model.ProductPrice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepo implements IProductRepo{
    private final Connection connection;

    public ProductRepo(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO m_product (name_product) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, product.getName_product());

        statement.executeUpdate();

        statement.close();
    }

    @Override
    public ProductPrice getById(Integer id) throws SQLException {
        String sql = "SELECT * from m_product_price where product_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        ProductPrice productPrice = new ProductPrice();
        while (result.next()) {
            productPrice.setProduct_id(result.getInt("product_id"));
        }
        return productPrice;
    }

    @Override
    public void deleteProduct(Integer id) throws SQLException {
        String sql = "DELETE FROM m_product where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.executeUpdate();

        statement.close();

    }
}
