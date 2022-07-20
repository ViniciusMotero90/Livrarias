package com.gft.Livraria.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.Livraria.Entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}