package br.com.pamcary.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pamcary.avaliacao.model.Usuario;
import br.com.pamcary.avaliacao.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity <List<Usuario>> getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
		// select * from tb_postagens;
	}
		
	@GetMapping("/{id}")
	public ResponseEntity <Usuario> getById(@PathVariable Long id){
		return usuarioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))//200
				.orElse(ResponseEntity.notFound().build()); //400
	}	
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Usuario>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(usuarioRepository.findByNomeContainingIgnoreCase(nome));
	}
		
	@PostMapping
	public ResponseEntity <Usuario> postUsuario(@Valid @RequestBody Usuario usuario){//@Valid erro 400, sem ele erro 500
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity <Usuario> putUsuario(@Valid @RequestBody Usuario usuario){
		return usuarioRepository.findById(usuario.getId())
				.map(resposta -> ResponseEntity.ok(usuarioRepository.save(usuario)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}") // Método void
	public ResponseEntity <?> deleteUsuario(@PathVariable Long id){
		return usuarioRepository.findById(id)
				.map(resposta -> {
					usuarioRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
