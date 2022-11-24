package br.com.reccos.admin.reposirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Rodada;

public interface RodadaRepository extends JpaRepository<Rodada, Integer> {
	public List<Rodada> findByStatus(boolean status);
}
