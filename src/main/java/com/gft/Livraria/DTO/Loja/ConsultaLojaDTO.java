package com.gft.Livraria.DTO.Loja;

import com.gft.Livraria.Entity.Livro;

public class ConsultaLojaDTO {
    private String nome;
	
	private String endereco;
	
	private Livro livro;

	public ConsultaLojaDTO() {
	}

	public ConsultaLojaDTO(String nome, String endereco, Livro livro) {
		this.nome = nome;
		this.endereco = endereco;
		this.livro = livro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}