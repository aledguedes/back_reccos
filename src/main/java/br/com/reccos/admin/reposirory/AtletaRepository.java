package br.com.reccos.admin.reposirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
	public List<Atleta> findByStatus(boolean status);
}
