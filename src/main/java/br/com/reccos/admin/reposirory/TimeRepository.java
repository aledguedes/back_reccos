package br.com.reccos.admin.reposirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {
	public List<Time> findByStatus(boolean status);
}
