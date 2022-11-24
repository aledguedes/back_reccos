package br.com.reccos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Time;
import br.com.reccos.admin.reposirory.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;

	public Time listById(Integer id) {
		Optional<Time> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}
	
	public List<Time> listByStatus(boolean status) {
		List<Time> obj = repository.findByStatus(status);
		return obj;
	}

	public List<Time> listAll() {
		return repository.findAll();
	}

	public Time create(Time time) {
		time.setId(null);
		return repository.save(time);
	}

	public Time update(Integer id, Time time) {
		time.setId(id);
		return repository.save(time);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
