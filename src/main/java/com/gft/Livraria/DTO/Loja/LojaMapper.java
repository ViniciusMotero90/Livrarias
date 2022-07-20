package com.gft.Livraria.DTO.Loja;


import com.gft.Livraria.DTO.Livro.LivroMapper;
import com.gft.Livraria.Entity.Loja;

public class LojaMapper {
	public static Loja fromDTO(RegistroLojaDTO dto) {
		return new Loja(null, dto.getNome(), dto.getEndereco(), dto.getRegistroLivroDTO());
	}
	
	public static ConsultaLojaDTO entityDTO(Loja loja) {
		return new ConsultaLojaDTO(loja.getNome(), loja.getEndereco(), loja.getLivro());
	}
}