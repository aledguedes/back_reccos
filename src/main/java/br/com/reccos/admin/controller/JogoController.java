package br.com.reccos.admin.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.reccos.admin.model.Arbitro;
import br.com.reccos.admin.model.Jogo;
import br.com.reccos.admin.service.JogoService;

@RestController
@RequestMapping(value = "/jogos")
@CrossOrigin("*")
public class JogoController {
	
	@Autowired
	private JogoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogo> listById(@PathVariable Integer id) {
		Jogo jogo = service.listById(id);
		return ResponseEntity.ok().body(jogo);
	}
	
	@GetMapping
	public ResponseEntity<List<Jogo>> listarTodos(){
		List<Jogo> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Arbitro> criarArbitro(@RequestBody Jogo jogo) {
		Jogo obj = service.create(jogo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_jogo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogo> atualizarArbitro(@PathVariable Integer id, @RequestBody Jogo jogo){
		Jogo obj = service.update(id, jogo);
		
		if(obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Arbitro> deletarArbitro(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
