package br.com.reccos.admin.reposirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reccos.admin.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer>{
	public List<Contract> findByStatus(boolean status);
}
