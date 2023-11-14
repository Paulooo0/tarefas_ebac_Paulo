/**
 * 
 */
package br.com.pauloh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import anotacao.ColunaTabela;
import br.com.pauloh.dao.Persistente;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteMySQL implements Persistente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cpf", nullable = false, unique = true)
    private Long cpf;
    
	@Column(name = "tel", nullable = false, length = 12)
    private Long tel;
    
	@Column(name = "end", nullable = false, length = 64)
    private String end;
    
	@Column(name = "numero", nullable = false, length = 6)
    private Integer numero;
    
	@Column(name = "cidade", nullable = false, length = 64)
    private String cidade;
    
	@ColunaTabela(dbName = "estado", setJavaName = "setEstado")
	@Column(name = "estado", nullable = false, length = 64)
    private String estado;

	@Column(name = "email", nullable = false, length = 64, unique = true)
    private String email;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

	

}
