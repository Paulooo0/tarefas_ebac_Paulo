/**
 * 
 */
package br.com.rpires.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import anotacao.ColunaTabela;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	@OneToOne(mappedBy = "estoque")
	@JoinColumn(name = "fk_estoque_id",
	foreignKey = @ForeignKey(name = "fk_estoque_id"),
	referencedColumnName = "id")
	private Estoque estoque;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_venda_id",
	foreignKey = @ForeignKey(name = "fk_produto_qtd_id"),
	referencedColumnName = "id")
	private Venda venda;

    public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public ProdutoQuantidade(Estoque estoque) {
		this();
        this.estoque = estoque;
    }

	public ProdutoQuantidade() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

    public void adicionarQuantidade(Integer quantidade) {
        estoque.adicionarQuantidadeProduto(this, quantidade);
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.valorTotal.add(novoValor);
		this.valorTotal = novoTotal;
	}
	
	public void remover(Integer quantidade) {
		this.quantidade -= quantidade;
		BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}
	
	
}
