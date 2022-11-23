package br.com.reccos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Contract;
import br.com.reccos.admin.reposirory.ContractRepository;

@Service
public class ContractService {

	@Autowired
	private ContractRepository repository;
	
	public Contract listById(Integer id) {
		Optional<Contract> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}
	
	public List<Contract> listAll() {
		return repository.findAll();
	}
}
