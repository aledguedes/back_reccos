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

import br.com.reccos.admin.model.Contract;
import br.com.reccos.admin.service.ContractService;

@RestController
@RequestMapping(value = "/contratos")
@CrossOrigin("*")
public class ContractController {
	
	@Autowired
	private ContractService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contract> listById(@PathVariable Integer id) {
		Contract contrato = service.listById(id);
		return ResponseEntity.ok().body(contrato);
	}
	
	@GetMapping(value = "/status/{status}")
	public ResponseEntity<List<Contract>> listByStatus(@PathVariable Boolean status) {
		List<Contract> list = service.listByStatus(status);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Contract>> listarTodos(){
		List<Contract> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Contract> criarTime(@RequestBody Contract contrato) {
		Contract obj = service.create(contrato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contract> atualizarTime(@PathVariable Integer id, @RequestBody Contract contrato){
		Contract obj = service.update(id, contrato);
		
		if(obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Contract> deletarTime(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
