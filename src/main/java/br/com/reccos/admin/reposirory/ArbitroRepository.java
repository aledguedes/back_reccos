package br.com.reccos.admin.reposirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Arbitro;

public interface ArbitroRepository extends JpaRepository<Arbitro, Integer> {
	public List<Arbitro> findByStatus(boolean status);
}
