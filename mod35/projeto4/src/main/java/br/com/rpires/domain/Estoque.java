package br.com.rpires.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "produto")
    @JoinColumn(name = "fk_produto_id",
    foreignKey = @ForeignKey(name = "fk_produto_id"),
    referencedColumnName = "id")
    private ProdutoQuantidade produto;

    @Column(name = "quantidade", nullable = false)
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
