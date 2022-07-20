package com.gft.Livraria.DTO.Perfil;

import com.gft.Livraria.Entity.Perfil;

public class PerfilMapper {
	public static Perfil fromDTO(PerfilDTO dto) {
		return new Perfil(null, dto.getNome());
	}
	
	public static PerfilDTO fromEntity(Perfil perfil) {
		return new PerfilDTO(perfil.getId(),perfil.getNome());
	}
}