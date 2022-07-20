package com.gft.Livraria.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.Livraria.DTO.Cliente.ConsultaClienteDTO;
import com.gft.Livraria.DTO.Cliente.RegistroClienteDTO;
import com.gft.Livraria.Entity.Cliente;
import com.gft.Livraria.Entity.Usuario;
import com.gft.Livraria.Repositories.ClienteRepository;

@Service
public class ClienteService implements UserDetailsService{
	@Autowired
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente buscarUsuarioPorEmail(String email) {
		Optional<Cliente> optional = clienteRepository.findByEmail(email);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return optional.get();
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarTodosOsCliente(){
		return clienteRepository.findAll();
	}

	public Cliente buscarCliente(Long id) {
		Optional<Cliente> findById = clienteRepository.findById(id);
		
		return findById.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrada"));
	}
	
	public Cliente atualizarCliente(Cliente cliente, long id) {
		Cliente clienteOriginal = this.buscarCliente(id);
		
		cliente.setId(clienteOriginal.getId());
		
		return clienteRepository.save(cliente);
	}

	public void excluirCliente(Long id) {
		Cliente clienteOriginal = this.buscarCliente(id);
		clienteRepository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return buscarUsuarioPorEmail(username);
	}
	public Cliente buscarUsuarioPorId(Long idUsuario) {
		Optional<Cliente> optional = clienteRepository.findById(idUsuario);
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Id não encontrado");
		}
		
		return optional.get();
	}
}