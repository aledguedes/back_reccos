package br.com.reccos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reccos.admin.exceptions.ObjectnotFoundException;
import br.com.reccos.admin.model.Jogo;
import br.com.reccos.admin.reposirory.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;

	public Jogo listById(Integer id) {
		Optional<Jogo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}

	public List<Jogo> listAll() {
		return repository.findAll();
	}
	
	public List<Jogo> listByStatus(boolean status) {
		List<Jogo> obj = repository.findByStatus(status);
		return obj;
	}

	public Jogo create(Jogo jogo) {
		jogo.setId_jogo(null);
		return repository.save(jogo);
	}

	public Jogo update(Integer id, Jogo jogo) {
		jogo.setId_jogo(id);
		return repository.save(jogo);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
