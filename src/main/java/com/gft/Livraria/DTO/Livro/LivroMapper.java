package com.gft.Livraria.DTO.Livro;

import java.util.List;

import com.gft.Livraria.Entity.Livro;

public class LivroMapper {
	public static Livro fromDTO(RegistroLivroDTO dto) {
		return new Livro(null, dto.getTitulo(), dto.getAutor(), dto.getPaginas(), dto.getPreco());
	}
	
	public static ConsultaLivroDTO fromEntity(Livro livro) {
		return new ConsultaLivroDTO(livro.getId(), livro.getTitulo(),livro.getAutor(), livro.getPaginas(), livro.getPreco());
	}
}