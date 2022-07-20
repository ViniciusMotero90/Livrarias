package com.gft.Livraria.Controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.Livraria.DTO.AutenticacaoDTO;
import com.gft.Livraria.DTO.TokenDTO;
import com.gft.Livraria.DTO.Cliente.ConsultaClienteDTO;
import com.gft.Livraria.DTO.Cliente.RegistroClienteDTO;
import com.gft.Livraria.DTO.Usuario.ConsultaUsuarioDTO;
import com.gft.Livraria.DTO.Usuario.RegistroUsuarioDTO;
import com.gft.Livraria.DTO.Usuario.UsuarioMapper;
import com.gft.Livraria.Entity.Cliente;
import com.gft.Livraria.Entity.Perfil;
import com.gft.Livraria.Entity.Usuario;
import com.gft.Livraria.Service.AutenticacaoService;
import com.gft.Livraria.Service.UsuarioService;

@RestController
@RequestMapping("v1/usuario")
public class UsuarioController {
	@Autowired
	private final UsuarioService usuarioService;
	
	@Autowired
	AutenticacaoService autenticacaoService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/auth")
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoDTO authform){
		
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(authform));
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/criar")
	public ResponseEntity<ConsultaUsuarioDTO> salvarUsuario(@RequestBody RegistroUsuarioDTO dto){
        Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.fromDTO(dto));
		
		return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
	}
}