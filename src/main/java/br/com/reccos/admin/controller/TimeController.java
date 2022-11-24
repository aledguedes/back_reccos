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

import br.com.reccos.admin.model.Time;
import br.com.reccos.admin.service.TimeService;

@RestController
@RequestMapping(value = "/times")
@CrossOrigin("*")
public class TimeController {

	@Autowired
	private TimeService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Time> listById(@PathVariable Integer id) {
		Time time = service.listById(id);
		return ResponseEntity.ok().body(time);
	}
	
	@GetMapping(value = "/status/{status}")
	public ResponseEntity<List<Time>> listByStatus(@PathVariable Boolean status) {
		List<Time> list = service.listByStatus(status);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Time>> listarTodos(){
		List<Time> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Time> criarTime(@RequestBody Time time) {
		Time obj = service.create(time);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Time> atualizarTime(@PathVariable Integer id, @RequestBody Time time){
		Time obj = service.update(id, time);
		
		if(obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Time> deletarTime(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
