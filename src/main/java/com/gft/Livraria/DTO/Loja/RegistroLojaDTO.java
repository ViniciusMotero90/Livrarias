package com.gft.Livraria.DTO.Loja;

import com.gft.Livraria.Entity.Livro;

public class RegistroLojaDTO {
    private String nome;
	
	private String endereco;
	
	private Livro registroLivroDTO;

	public RegistroLojaDTO() {
	}

	public RegistroLojaDTO(String nome, String endereco, Livro registroLivroDTO) {
		this.nome = nome;
		this.endereco = endereco;
		this.registroLivroDTO = registroLivroDTO;
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

	public Livro getRegistroLivroDTO() {
		return registroLivroDTO;
	}

	public void setRegistroLivroDTO(Livro registroLivroDTO) {
		this.registroLivroDTO = registroLivroDTO;
	}
}