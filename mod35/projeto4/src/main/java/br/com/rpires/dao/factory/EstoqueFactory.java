package br.com.rpires.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.rpires.domain.Estoque;
import br.com.rpires.domain.ProdutoQuantidade;

public class EstoqueFactory {
    public static Estoque convert(ResultSet rs) throws SQLException {
        Estoque estoque = new Estoque();
        estoque.setId(rs.getLong("ID"));
        ProdutoQuantidade prod = ProdutoQuantidadeFactory.convert(rs);
        estoque.setProduto(prod);
        estoque.setQuantidade(rs.getInt("QUANTIDADE"));
        return estoque;
    }
}
