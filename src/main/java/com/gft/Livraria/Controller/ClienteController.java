package com.gft.Livraria.Controller;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.Livraria.DTO.Cliente.ClienteMapper;
import com.gft.Livraria.DTO.Cliente.ConsultaClienteDTO;
import com.gft.Livraria.DTO.Cliente.RegistroClienteDTO;
import com.gft.Livraria.Entity.Cliente;
import com.gft.Livraria.Entity.Livro;
import com.gft.Livraria.Service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/cliente")
@Api(value = "API REST Cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	@Autowired
	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('admin')")
	@ApiOperation(value = "Retornar todos os clientes")
	public ResponseEntity<List<ConsultaClienteDTO>> buscarTodasOsCliente(){
		
		return ResponseEntity.ok(clienteService.listarTodosOsCliente().stream().map(ClienteMapper :: fromEntity).collect(Collectors.toList()));
		
	}
	
	@PostMapping("/criar")
	@PreAuthorize("hasAuthority('admin')")
	@ApiOperation(value = "Salvar um cliente")
	public ResponseEntity<ConsultaClienteDTO> salvarCliente(@RequestBody RegistroClienteDTO dto){
        Cliente cliente = clienteService.salvarCliente(ClienteMapper.fromDTO(dto));
		
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}
	
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	@ApiOperation(value = "Retornar um cliente")
	public ResponseEntity<ConsultaClienteDTO> buscarCliente(@PathVariable Long id){
	    Cliente cliente = clienteService.buscarCliente(id);
			
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	@ApiOperation(value = "Atualiza um cliente")
	public ResponseEntity<ConsultaClienteDTO> atualizarCliente(@RequestBody RegistroClienteDTO dto, @PathVariable Long id){
		try {
			Cliente cliente = clienteService.atualizarCliente(ClienteMapper.fromDTO(dto), id);
			return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	@ApiOperation(value = "Delete um cliente")
	public ResponseEntity<ConsultaClienteDTO> deleteCliente(@PathVariable Long id){
		try {
			clienteService.excluirCliente(id);
			
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}