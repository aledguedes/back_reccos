package br.com.reccos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Atleta;
import br.com.reccos.admin.reposirory.AtletaRepository;

@Service
public class AtletaService {

	@Autowired
	private AtletaRepository repository;
	
	public Atleta listById(Integer id) {
		Optional<Atleta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}
	
	public List<Atleta> listAll() {
		return repository.findAll();
	}
	
	public Atleta create(Atleta obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Atleta update(Integer id, Atleta obj) {
		obj.setId(id);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
