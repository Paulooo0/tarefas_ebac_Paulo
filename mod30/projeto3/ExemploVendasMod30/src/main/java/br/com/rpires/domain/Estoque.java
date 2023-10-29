package br.com.rpires.domain;

import anotacao.Tabela;

@Tabela("TB_ESTOQUE")
public class Estoque {
    private Long id;
    private ProdutoQuantidade produto;
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public ProdutoQuantidade getProduto() {
        return produto;
    }
    
    public void setProduto(ProdutoQuantidade prod) {
        this.produto = prod;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void reduzirQuantidadeProduto(ProdutoQuantidade produto, Integer quantidade) {
        Integer quantidadeAtual = produto.getQuantidade();
        
        if (quantidadeAtual >= quantidade) {
            Integer novaQuantidade = quantidadeAtual - quantidade;
            produto.setQuantidade(novaQuantidade);
        } else {
            throw new RuntimeException("Quantidade insuficiente no estoque");
        }
    }

    public void adicionarQuantidadeProduto(ProdutoQuantidade produto, Integer quantidade) {
        Integer quantidadeAtual = produto.getQuantidade();
        
        if (quantidadeAtual <= quantidade) {
            Integer novaQuantidade = quantidadeAtual + quantidade;
            produto.setQuantidade(novaQuantidade);
        }
    }

}
