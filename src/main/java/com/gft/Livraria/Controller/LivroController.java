package com.gft.Livraria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.Livraria.DTO.Livro.ConsultaLivroDTO;
import com.gft.Livraria.DTO.Livro.LivroMapper;
import com.gft.Livraria.DTO.Livro.RegistroLivroDTO;
import com.gft.Livraria.Entity.Livro;
import com.gft.Livraria.Service.LivroService;

@RestController
@RequestMapping("v1/livro")
public class LivroController {
	@Autowired
	private final LivroService livroService;
	
	public LivroController(LivroService livroService) {
		super();
		this.livroService = livroService;
	}
	
	@PostMapping("/criar")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaLivroDTO> salvarCliente(@RequestBody RegistroLivroDTO dto){
		Livro livro = livroService.salvarLivro(LivroMapper.fromDTO(dto));
		
		return ResponseEntity.ok(LivroMapper.fromEntity(livro));
	}
}
