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

import br.com.reccos.admin.model.Rodada;
import br.com.reccos.admin.service.RodadaService;

@RestController
@RequestMapping(value = "/rodadas")
@CrossOrigin("*")
public class RodadaController {

	@Autowired
	private RodadaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Rodada> listById(@PathVariable Integer id) {
		Rodada obj = service.listById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Rodada>> listarTodos(){
		List<Rodada> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Rodada> criarArbitro(@RequestBody Rodada rodada) {
		Rodada obj = service.create(rodada);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_rodada()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Rodada> atualizarArbitro(@PathVariable Integer id, @RequestBody Rodada jogo){
		Rodada obj = service.update(id, jogo);
		
		if(obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Rodada> deletarArbitro(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
