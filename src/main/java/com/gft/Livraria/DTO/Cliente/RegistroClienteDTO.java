package com.gft.Livraria.DTO.Cliente;

import java.util.List;

import com.gft.Livraria.DTO.Livro.RegistroLivroDTO;
import com.gft.Livraria.DTO.Perfil.PerfilDTO;
import com.gft.Livraria.Entity.Livro;

public class RegistroClienteDTO {
    private String cpf;
	
	private String nome;
	
	private String telefone;
	
    private String email;
    
	private String senha;
	
	private RegistroLivroDTO livros;

	public RegistroClienteDTO() {
	}

	public RegistroClienteDTO(String cpf, String nome, String telefone, String email, String senha, RegistroLivroDTO livros) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.livros = livros;
	}

	public RegistroLivroDTO getLivros() {
		return livros;
	}

	public void setLivros(RegistroLivroDTO livros) {
		this.livros = livros;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}