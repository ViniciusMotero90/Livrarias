package com.gft.Livraria.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.Livraria.Entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{

}
