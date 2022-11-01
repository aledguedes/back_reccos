package br.com.reccos.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import java.util.List;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Liga;
import br.com.reccos.admin.reposirory.LigaRepository;

@Service
public class LigaService {
	
	@Autowired
	private LigaRepository repository;
	
	public Liga listById(Integer id) {
		Optional<Liga> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}
	
	public List<Liga> listAll() {
		return repository.findAll();
	}
	
	public Liga create(Liga obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Liga update(Integer id, Liga obj) {
		obj.setId(id);
		return repository.save(obj);
	}

}
