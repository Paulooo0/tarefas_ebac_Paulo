package br.com.pauloh;

public class Client {
    private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarNome(String nome) {
		setNome(nome);
	}
}
