package com.gft.Livraria.DTO.Usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.Livraria.DTO.Perfil.PerfilMapper;
import com.gft.Livraria.Entity.Usuario;

public class UsuarioMapper {
	
	public static Usuario fromDTO(RegistroUsuarioDTO dto) {
		 return  new Usuario(null, dto.getEmail(),dto.getSenha(), PerfilMapper.fromDTO(dto.getPerfil()));
	}
	
	public static ConsultaUsuarioDTO fromEntity(Usuario usuario) {
		return new ConsultaUsuarioDTO(usuario.getEmail(),usuario.getSenha(),PerfilMapper.fromEntity(usuario.getPerfil()));
	}
	
}