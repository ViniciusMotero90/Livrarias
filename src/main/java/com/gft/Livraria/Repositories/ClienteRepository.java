package com.gft.Livraria.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.Livraria.DTO.Cliente.ConsultaClienteDTO;
import com.gft.Livraria.DTO.Cliente.RegistroClienteDTO;
import com.gft.Livraria.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Page<Cliente> findAll(Pageable pageable);
	
    @Query("select c from Cliente c where c.cpf like ?1")
    Optional<Cliente> findClienteByCpf(String cpf);
	
    @Query("select c from Cliente c where c.email like ?1")
	Optional<Cliente> findByEmail(String email);
}