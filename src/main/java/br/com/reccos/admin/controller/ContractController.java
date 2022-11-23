package br.com.reccos.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping
	public ResponseEntity<List<Contract>> listarTodos(){
		List<Contract> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}

}
