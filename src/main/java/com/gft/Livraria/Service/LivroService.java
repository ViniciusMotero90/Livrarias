package com.gft.Livraria.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import com.gft.Livraria.Entity.Livro;
import com.gft.Livraria.Repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private final LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Livro salvarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Page<Livro> buscarTodosOsLivros(Pageable pageable){
		return livroRepository.findAll(pageable);
	}
	
	public Livro buscarLivro(Long id) {
		Optional<Livro> findById = livroRepository.findById(id);
		
		return findById.orElseThrow(() -> new EntityNotFoundException("Livro não Encontrado"));
	}
	
	public Livro atualizarLivro(Livro livro, long id) {
		Livro livroOriginal = this.buscarLivro(id);
		
		livro.setId(livroOriginal.getId());
		
		return livroRepository.save(livro);
	}

	public void excluirLivro(Long id) {
		Livro livro = this.buscarLivro(id);
		livroRepository.deleteById(id);
	}
	
}