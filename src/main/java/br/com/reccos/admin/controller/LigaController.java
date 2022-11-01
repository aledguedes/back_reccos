package br.com.reccos.admin.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.reccos.admin.model.Liga;
import br.com.reccos.admin.service.LigaService;

@RestController
@RequestMapping(value = "/ligas")
@CrossOrigin("*")
public class LigaController {

	@Autowired
	private LigaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Liga> listById(@PathVariable Integer id) {
		Liga liga = service.listById(id);
		return ResponseEntity.ok().body(liga);
	}
	
	@GetMapping
	public ResponseEntity<List<Liga>> listarTodos(){
		List<Liga> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Liga> criarLiga(@RequestBody Liga liga) {
		Liga obj = service.create(liga);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Liga> atualizarLiga(@PathVariable Integer id, @RequestBody Liga liga){
		Liga obj = service.update(id, liga);
		
		if(obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
