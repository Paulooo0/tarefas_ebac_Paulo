package br.com.pauloh.dao.jdbc.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloh.dao.jdbc.ConnectionFactory;
import br.com.pauloh.domain.Product;

public class ProductDAO implements IProductDAO {

    @Override
    public Integer create(Product product) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_product (code, name, price) VALUES (?, ?, ?)";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, product.getCode());
            prepStmt.setString(2, product.getName());
            prepStmt.setString(3, product.getPrice());
            return prepStmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Product read(String code) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_client WHERE code = ?";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, code);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
            }
            return product; 
        } catch (Exception e) {
            throw e;
        } finally {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer update(Product product) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_client SET name = ? AND price = ? WHERE code = ?";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, product.getName());
            prepStmt.setString(2, product.getPrice());
            prepStmt.setString(2, product.getCode());
            return prepStmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer delete(Product product) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM tb_product WHERE code = ?";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, product.getCode());
            return prepStmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Product> readAll() throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Product product = null;
        List<Product> list = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_product";
            prepStmt = connection.prepareStatement(sql);
            list = new ArrayList<>();
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                list.add(product);
            }
            return list; 
        } catch (Exception e) {
            throw e;
        } finally {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
}
