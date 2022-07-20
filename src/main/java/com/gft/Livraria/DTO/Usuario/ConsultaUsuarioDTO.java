package com.gft.Livraria.DTO.Usuario;

import com.gft.Livraria.DTO.Perfil.PerfilDTO;

public class ConsultaUsuarioDTO {
	
	private String email;
	
	private String senha;
	
	private PerfilDTO perfil;

	public ConsultaUsuarioDTO() {
	}

	public ConsultaUsuarioDTO(String email, String senha, PerfilDTO perfil) {
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}

	public ConsultaUsuarioDTO(String email, PerfilDTO perfil) {
		this.email = email;
		this.perfil = perfil;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
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
