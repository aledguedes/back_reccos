package br.com.reccos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Arbitro;
import br.com.reccos.admin.reposirory.ArbitroRepository;

@Service
public class ArbitroService {
	
	@Autowired
	private ArbitroRepository repository;
	
	public Arbitro listById(Integer id) {
		Optional<Arbitro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}
	
	public List<Arbitro> listAll() {
		return repository.findAll();
	}
	
	public Arbitro create(Arbitro obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Arbitro update(Integer id, Arbitro obj) {
		obj.setId(id);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
