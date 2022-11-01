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
import br.com.reccos.admin.service.ArbitroService;

@RestController
@RequestMapping(value = "/arbitros")
@CrossOrigin("*")
public class ArbitroController {
	
	@Autowired
	private ArbitroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Arbitro> listById(@PathVariable Integer id) {
		Arbitro arbitro = service.listById(id);
		return ResponseEntity.ok().body(arbitro);
	}
	
	@GetMapping
	public ResponseEntity<List<Arbitro>> listarTodos(){
		List<Arbitro> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Arbitro> criarArbitro(@RequestBody Arbitro arbitro) {
		Arbitro obj = service.create(arbitro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Arbitro> atualizarArbitro(@PathVariable Integer id, @RequestBody Arbitro arbitro){
		Arbitro obj = service.update(id, arbitro);
		
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
