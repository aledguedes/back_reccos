package br.com.reccos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Rodada;
import br.com.reccos.admin.reposirory.RodadaRepository;

@Service
public class RodadaService {

	@Autowired
	private RodadaRepository repository;

	public Rodada listById(Integer id) {
		Optional<Rodada> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}
	
	public List<Rodada> listByStatus(boolean status) {
		List<Rodada> obj = repository.findByStatus(status);
		return obj;
	}

	public List<Rodada> listAll() {
		return repository.findAll();
	}

	public Rodada create(Rodada obj) {
		obj.setId_rodada(null);
		return repository.save(obj);
	}

	public Rodada update(Integer id, Rodada obj) {
		obj.setId_rodada(id);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
