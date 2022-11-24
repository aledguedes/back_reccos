package br.com.reccos.admin.reposirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Liga;

public interface LigaRepository extends JpaRepository<Liga, Integer> {
	public List<Liga> findByStatus(boolean status);
}
