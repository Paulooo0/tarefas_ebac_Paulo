package br.com.pauloh.dao.jdbc.dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloh.dao.jdbc.ConnectionFactory;
import br.com.pauloh.domain.Client;

public class ClientDAO implements IClientDAO {

    @Override
    public Integer create(Client client) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_client (code, name) VALUES (?, ?)";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, client.getCode());
            prepStmt.setString(2, client.getName());
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
    public Client read(String code) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Client client = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_client WHERE code = ?";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, code);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                client = new Client();
                client.setId(rs.getLong("id"));
                client.setCode(rs.getString("code"));
                client.setName(rs.getString("name"));
            }
            return client; 
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
    public Integer update(Client client) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_client SET name = ? WHERE code = ?";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, client.getName());
            prepStmt.setString(2, client.getCode());
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
    public Integer delete(Client client) throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM tb_client WHERE code = ?";
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, client.getCode());
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
    public List<Client> readAll() throws Exception {
        Connection connection = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> list = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_client";
            prepStmt = connection.prepareStatement(sql);
            list = new ArrayList<>();
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getLong("id"));
                client.setCode(rs.getString("code"));
                client.setName(rs.getString("name"));
                list.add(client);
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
