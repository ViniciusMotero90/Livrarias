package com.gft.Livraria.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import com.gft.Livraria.Entity.Livro;
import com.gft.Livraria.Entity.Loja;
import com.gft.Livraria.Repositories.LivroRepository;
import com.gft.Livraria.Repositories.LojaRepository;

@Service
public class LojaService {
	@Autowired
	private final LojaRepository lojaRepository;
	
	public LojaService(LojaRepository lojaRepository) {
		super();
		this.lojaRepository = lojaRepository;
	}

	public Loja salvarLoja(Loja loja) {
		return lojaRepository.save(loja);
	}
	
	public Page<Loja> buscarTodosOsLoja(Pageable pageable){
		return lojaRepository.findAll(pageable);
	}
	
	public Loja buscarLoja(Long id) {
		Optional<Loja> findById = lojaRepository.findById(id);
		
		return findById.orElseThrow(() -> new EntityNotFoundException("Livro não Encontrado"));
	}
	
	public Loja atualizarLoja(Loja loja, long id) {
		Loja lojaOriginal = this.buscarLoja(id);
		
		loja.setId(lojaOriginal.getId());
		
		return lojaRepository.save(loja);
	}

	public void excluirLoja(Long id) {
		Loja loja = this.buscarLoja(id);
		lojaRepository.deleteById(id);
	}
	
}