package com.gft.Livraria.DTO.Cliente;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.Livraria.DTO.Livro.LivroMapper;
import com.gft.Livraria.Entity.Cliente;

public class ClienteMapper {
	public static Cliente fromDTO(RegistroClienteDTO dto) {
		return new Cliente(null, dto.getCpf(), dto.getNome(), dto.getTelefone(), dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getSenha()),LivroMapper.fromDTO(dto.getLivros()));
	}
	
	public static ConsultaClienteDTO fromEntity(Cliente cliente) {
		return new ConsultaClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail(), new BCryptPasswordEncoder().encode(cliente.getSenha()),LivroMapper.fromEntity(cliente.getLivro()));
	}
}