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

import br.com.reccos.admin.model.Atleta;
import br.com.reccos.admin.service.AtletaService;

@RestController
@RequestMapping(value = "/atletas")
@CrossOrigin("*")
public class AtletaController {

	@Autowired
	private AtletaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atleta> listById(@PathVariable Integer id) {
		Atleta atleta = service.listById(id);
		return ResponseEntity.ok().body(atleta);
	}
	
	@GetMapping
	public ResponseEntity<List<Atleta>> listarTodos(){
		List<Atleta> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Atleta> criarTime(@RequestBody Atleta atleta) {
		Atleta obj = service.create(atleta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Atleta> atualizarTime(@PathVariable Integer id, @RequestBody Atleta atleta){
		Atleta obj = service.update(id, atleta);
		
		if(obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Atleta> deletarTime(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
